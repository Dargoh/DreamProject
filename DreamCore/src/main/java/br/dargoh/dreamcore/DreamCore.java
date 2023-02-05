package br.dargoh.dreamcore;

import br.dargoh.dreamcore.listeners.ActionBarListener;
import br.dargoh.dreamcore.listeners.JoinListener;
import br.dargoh.dreamcore.listeners.WorldListener;
import br.dargoh.dreamcore.util.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DreamCore extends JavaPlugin {

    public static DreamCore PLUGIN;

    @Override
    public void onEnable(){
        PLUGIN = this;

        MessageUtils.pluginLoaded(this);

        this.registerListeners();
    }

    private void registerListeners(){
        Bukkit.getPluginManager().registerEvents(new ActionBarListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new WorldListener(), this);
    }
}
