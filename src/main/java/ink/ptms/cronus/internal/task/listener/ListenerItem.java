package ink.ptms.cronus.internal.task.listener;

import ink.ptms.cronus.CronusAPI;
import ink.ptms.cronus.internal.task.item.TaskItemConsume;
import me.skymc.taboolib.listener.TListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * @Author 坏黑
 * @Since 2019-05-28 17:24
 */
@TListener
public class ListenerItem implements Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void e(PlayerItemConsumeEvent e) {
        CronusAPI.stageHandle(e.getPlayer(), e, TaskItemConsume.class);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void e(CraftItemEvent e) {
        CronusAPI.stageHandle((Player) e.getWhoClicked(), e, TaskItemConsume.class);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void e(EnchantItemEvent e) {
        CronusAPI.stageHandle(e.getEnchanter(), e, TaskItemConsume.class);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void e(PlayerPickupItemEvent e) {
        CronusAPI.stageHandle(e.getPlayer(), e, TaskItemConsume.class);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void e(PlayerPickupArrowEvent e) {
        CronusAPI.stageHandle(e.getPlayer(), e, TaskItemConsume.class);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void e(PrepareAnvilEvent e) {
        if (!e.getViewers().isEmpty()) {
            CronusAPI.stageHandle((Player) e.getViewers().get(0), e, TaskItemConsume.class);
        }
    }
}