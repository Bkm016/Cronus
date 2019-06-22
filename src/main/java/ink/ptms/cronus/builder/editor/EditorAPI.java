package ink.ptms.cronus.builder.editor;

import com.google.common.collect.Lists;
import ink.ptms.cronus.builder.editor.data.PlayerData;
import ink.ptms.cronus.builder.editor.data.PlayerDataHandler;
import ink.ptms.cronus.builder.editor.module.IModule;
import ink.ptms.cronus.builder.editor.module.IModuleHandler;
import me.skymc.taboolib.entity.EntityTag;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.List;

/**
 * @Author 坏黑
 * @Since 2019-03-11 17:55
 */
public class EditorAPI {

    public static int getListLength() {
        return 16;
    }

    public static String formatPath(String canonicalPath) {
        return canonicalPath.contains(File.separator + "plugins") ? canonicalPath.substring(canonicalPath.indexOf(File.separator + "plugins")) : canonicalPath;
    }

    public static void setEditMode(Player player, boolean mode) {
        EntityTag.getInst().set("Cronus:Editor:EditMode", mode, player);
    }

    public static boolean isEditMode(Player player) {
        return EntityTag.getInst().getBoolean("Cronus:Editor:EditMode", player);
    }

    public static List<String> getContent(Player player) {
        return PlayerDataHandler.getPlayerData(player).getLines();
    }

    public static void openEdit(Player player, List<String> content) {
        PlayerData playerData = PlayerDataHandler.newData(player);
        playerData.setLines(Lists.newArrayList(content));
        playerData.setSaved(true);
        playerData.setActionEdit(Lists.newArrayList());
    }

    public static void eval(Player player, String message) {
        if (!message.startsWith(":")) {
            return;
        }
        IModule module = IModuleHandler.getModules().get(message.substring(1).split(" ")[0]);
        if (module == null) {
            player.sendMessage("§c§l[§4§lCronus§c§l] §c无效的命令.");
        } else {
            try {
                module.eval(player, message.substring(message.split(" ")[0].length() + 1));
            } catch (Throwable t) {
                module.eval(player, "");
            }
        }
    }
}
