package ink.ptms.cronus.internal.condition.impl.player;

import com.ilummc.tlib.resources.TLocale;
import ink.ptms.cronus.database.data.DataQuest;
import ink.ptms.cronus.internal.condition.Cond;
import ink.ptms.cronus.internal.condition.special.CondNumber;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

/**
 * @Author 坏黑
 * @Since 2019-06-17 20:21
 */
@Cond(name = "player.playtime", pattern = "player\\.playtime (?<expression>.+)", example = "player.playtime [expression]")
public class CondPlayTime extends CondNumber {

    @Override
    public Number getNumber(Player player, DataQuest quest, Event event) {
        return player.getPlayerTime();
    }

    @Override
    public String translate() {
        return TLocale.asString("translate-condition-playtime", expression.translate());
    }

    @Override
    public String toString() {
        return "CondPlayTime{" +
                "expression=" + expression +
                '}';
    }
}