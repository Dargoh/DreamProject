package br.dargoh.dreamcore;

import br.dargoh.dreamcore.listeners.ActionBarListener;
import br.dargoh.dreamcore.listeners.PlayerListener;
import br.dargoh.dreamcore.listeners.WorldListener;
import br.dargoh.dreamcore.util.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class DreamCore extends JavaPlugin {

    public static DreamCore PLUGIN;

    @Override
    public void onEnable() {
        PLUGIN = this;

        MessageUtils.pluginLoaded(this);

        this.registerListeners();

        new BukkitRunnable() {
            @Override
            public void run() {
                for (World world : Bukkit.getWorlds()) {
                    world.setTime(9000);
                }
            }
        }.runTaskTimer(this, 0L, 100L);
    }

    private void registerListeners(){
        Bukkit.getPluginManager().registerEvents(new ActionBarListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new WorldListener(), this);
    }
}
