package br.dargoh.dreamcore.util;

import org.bukkit.entity.Player;

public class PlayerUtils {

    public static void heal(Player player){
        player.setHealth(player.getMaxHealth());
    }

    public static String getFormattedName(Player player){
        return "§7" + player.getName();
    }

    public static int getPing(Player player) {
        try {
            return (int) player.getClass().getMethod("getPing").invoke(player);

        } catch (Throwable e) {
            return -1;
        }
    }
}
