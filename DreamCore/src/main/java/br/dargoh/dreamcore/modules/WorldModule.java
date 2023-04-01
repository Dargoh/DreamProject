package br.dargoh.dreamcore.modules;

import br.dargoh.dreamcore.DreamCore;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class WorldModule implements Module {

    @Override
    public void initialize() {
        this.registerListeners();
        this.registerCommands();

        this.timeWorldControl();
    }

    @Override
    public void registerListeners() {

    }

    @Override
    public void registerCommands() {

    }

    private void timeWorldControl(){
        new BukkitRunnable() {
            @Override
            public void run() {
                for (World world : Bukkit.getWorlds()) {
                    world.setTime(9000);
                }
            }
        }.runTaskTimer(DreamCore.PLUGIN, 0L, 100L);
    }
}
