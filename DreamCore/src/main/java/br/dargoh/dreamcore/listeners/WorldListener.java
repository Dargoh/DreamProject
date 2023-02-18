package br.dargoh.dreamcore.listeners;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WorldListener implements Listener {

    @EventHandler
    public void onRain(WeatherChangeEvent e){
        if(e.toWeatherState()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onFireSpread(BlockIgniteEvent e){
        if(e.getCause() == BlockIgniteEvent.IgniteCause.SPREAD || e.getCause() == BlockIgniteEvent.IgniteCause.LAVA || e.getCause() == BlockIgniteEvent.IgniteCause.EXPLOSION || e.getCause() == BlockIgniteEvent.IgniteCause.LIGHTNING){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onWalkOverSlime(PlayerMoveEvent e){
        // Fazer slime dar launch para o player
    }

}
