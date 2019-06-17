package ink.ptms.cronus.internal.condition.impl;

import ink.ptms.cronus.database.data.DataQuest;
import ink.ptms.cronus.internal.bukkit.ItemStack;
import ink.ptms.cronus.internal.bukkit.parser.BukkitParser;
import ink.ptms.cronus.internal.condition.Cond;
import ink.ptms.cronus.internal.condition.Condition;
import me.skymc.taboolib.inventory.TEquipment;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.util.NumberConversions;

import java.util.regex.Matcher;

/**
 * @Author 坏黑
 * @Since 2019-05-29 11:12
 */
@Cond(name = "item.slot", pattern = "item\\.(?<slot>\\S+) (?<symbol>\\S+) (?<value>.+)")
public class CondItemInHand extends Condition {

    private int slot;
    private TEquipment equipment;
    private String symbol;
    private ItemStack itemStack;

    @Override
    public void init(Matcher matcher) {
        try {
            equipment = TEquipment.valueOf(matcher.group("slot").toUpperCase());
        } catch (Throwable ignored) {
            slot = NumberConversions.toInt(matcher.group("slot"));
        }
        symbol = matcher.group("symbol");
        itemStack = BukkitParser.toItemStack(matcher.group("value"));
    }

    @Override
    public boolean isValid(Player player, DataQuest quest, Event event) {
        org.bukkit.inventory.ItemStack bukkitItem = equipment != null ? equipment.getItem(player) : player.getInventory().getItem(slot);
        switch (symbol) {
            case "=":
            case "==":
                return itemStack.isItem(bukkitItem);
            case "!=":
                return !itemStack.isItem(bukkitItem);
        }
        return false;
    }

    @Override
    public String toString() {
        return "CondItemInHand{" +
                "slot=" + slot +
                ", equipment=" + equipment +
                ", symbol='" + symbol + '\'' +
                ", itemStack=" + itemStack +
                '}';
    }
}