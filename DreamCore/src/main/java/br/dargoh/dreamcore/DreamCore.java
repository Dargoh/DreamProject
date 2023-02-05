package br.dargoh.dreamcore;

import br.dargoh.dreamcore.util.MessageUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class DreamCore extends JavaPlugin {

    public static DreamCore PLUGIN;

    @Override
    public void onEnable(){
        PLUGIN = this;

        MessageUtils.pluginLoaded(this);
    }
}
