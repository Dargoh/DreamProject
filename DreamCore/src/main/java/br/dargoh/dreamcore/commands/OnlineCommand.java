package br.dargoh.dreamcore.commands;

import br.dargoh.dreamcore.util.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class OnlineCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        sender.sendMessage(MessageUtils.SERVER_NAME + " §eAtualmente temos §a" + Bukkit.getOnlinePlayers().size() + " jogadores §eon-line.");
        return true;
    }

}
