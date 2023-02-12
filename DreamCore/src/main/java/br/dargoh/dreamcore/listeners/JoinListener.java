package br.dargoh.dreamcore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent e){
        e.setJoinMessage(null);

        //Teleportar player para o spawn
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){

    }
}
