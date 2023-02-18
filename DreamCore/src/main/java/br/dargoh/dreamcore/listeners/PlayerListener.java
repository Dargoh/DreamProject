package br.dargoh.dreamcore.listeners;

import br.dargoh.dreamcore.DreamCore;
import com.connorlinfoot.titleapi.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.setJoinMessage(null); // Remove a mensagem de entrada no servidor

        //e.getPlayer().teleport(Locais.HUB); // Teleporta para o Hub
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        e.setQuitMessage(null); // Remove a mensagem de saída do servidor
    }

    @EventHandler
    public void onHungerDeflect(FoodLevelChangeEvent e){
        e.setCancelled(true);

        Player player = Bukkit.getPlayer(e.getEntity().getUniqueId());

        player.setFoodLevel(20); // Seta o nível da barra de fome para o valor máximo
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        e.setDeathMessage(null); // Remove a mensagem de morte do jogador

        e.setKeepLevel(true); // Faz o jogador não perder XP ao morrer

        // Auto-respawn e mensagem de morte
        e.getEntity().spigot().respawn();

        //e.getEntity().teleport(Locais.HUB); // Teleporta para o Hub

        TitleAPI.sendTitle(e.getEntity(), "§c§lVocê morreu!", "", 20, 20, 20);

        e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ANVIL_LAND, 20, 20);
    }
}
