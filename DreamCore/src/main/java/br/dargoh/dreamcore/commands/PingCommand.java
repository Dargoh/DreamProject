package br.dargoh.dreamcore.commands;

import br.dargoh.dreamcore.util.MessageUtils;
import br.dargoh.dreamcore.util.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        if(arguments.length > 1){
            sender.sendMessage(MessageUtils.commandUse("ping <jogador>"));
            return true;
        }

        if(arguments.length == 0){ // Quer ver o proprio ping
            if(!(sender instanceof Player)){
                sender.sendMessage("§cVocê não pode ver o próprio ping!");
                return true;
            }

            Player player = (Player) sender;

            int ping = PlayerUtils.getPing(player);

            if(ping == -1){ // Se nao conseguiu obter o ping, retorna -1
                sender.sendMessage("§cNão foi possível identificar seu ping.");
            } else {
                sender.sendMessage("§aSeu ping é de " + ping + "ms.");
            }
        } else { // Quer ver o ping de alguem
            Player target = Bukkit.getPlayer(arguments[0]);

            if(target == null){ // Nao encontrou player
                sender.sendMessage(MessageUtils.PLAYER_NOT_FOUND);
                return true;
            }

            int ping = PlayerUtils.getPing(target);

            if(ping == -1){ // Se nao conseguiu obter o ping, retorna -1
                sender.sendMessage("§cNão foi possível identificar o ping de " + PlayerUtils.getFormattedName(target) + "§c.");
            } else {
                sender.sendMessage("§aO ping de " + PlayerUtils.getFormattedName(target) + "§a é de " + ping + "ms.");
            }
        }

        return true;
    }

}
