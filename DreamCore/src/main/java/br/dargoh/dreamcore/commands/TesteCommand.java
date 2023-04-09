package br.dargoh.dreamcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class TesteCommand extends DreamCommand {

    public TesteCommand(String command) {
        super(command);
    }

    @Override
    public void execute(CommandSender sender, String label, String[] arguments){
        Bukkit.broadcastMessage("Teste");
    }
}
