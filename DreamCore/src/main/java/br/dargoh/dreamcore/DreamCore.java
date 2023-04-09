package br.dargoh.dreamcore;

import br.dargoh.dreamcore.commands.TesteCommand;
import br.dargoh.dreamcore.modules.WorldModule;
import br.dargoh.dreamcore.util.MessageUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class DreamCore extends JavaPlugin {

    public static DreamCore PLUGIN;

    public static WorldModule WORLDMODULE;

    @Override
    public void onEnable() {
        PLUGIN = this;

        MessageUtils.pluginLoaded(this);

        WORLDMODULE = new WorldModule();

        new TesteCommand("teste");
    }
}
