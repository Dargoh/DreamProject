package br.dargoh.dreamcore.util;

import org.bukkit.entity.Player;

public class PlayerUtil {

    public static void heal(Player player){
        player.setHealth(player.getMaxHealth());
    }

}
