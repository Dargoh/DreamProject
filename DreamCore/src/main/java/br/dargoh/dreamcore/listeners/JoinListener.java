package br.dargoh.dreamcore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent e){
        e.setJoinMessage(null);

        //Teleportar player para o spawn
    }
}
