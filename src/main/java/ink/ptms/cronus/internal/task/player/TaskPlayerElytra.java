package ink.ptms.cronus.internal.task.player;

import ink.ptms.cronus.database.data.DataQuest;
import ink.ptms.cronus.internal.task.special.Countable;
import ink.ptms.cronus.internal.task.Task;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Map;

/**
 * @Author 坏黑
 * @Since 2019-05-28 17:21
 */
@Task(name = "player_gliding")
public class TaskPlayerElytra extends Countable<PlayerMoveEvent> {

    public TaskPlayerElytra(ConfigurationSection config) {
        super(config);
    }

    @Override
    public void init(Map<String, Object> data) {
        super.init(data);
    }

    @Override
    public boolean check(Player player, DataQuest dataQuest, PlayerMoveEvent e) {
        return player.isGliding();
    }

    @Override
    public String toString() {
        return "TaskPlayerWalk{" +
                "count=" + count +
                ", id='" + id + '\'' +
                ", config=" + config +
                ", condition=" + condition +
                ", guide=" + guide +
                ", action=" + action +
                '}';
    }
}
