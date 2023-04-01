package br.dargoh.dreamcore.commands;

import br.dargoh.dreamcore.util.MessageUtils;
import br.dargoh.dreamcore.util.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CurarCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        if(arguments.length > 1){
            sender.sendMessage(MessageUtils.commandUse("curar <jogador>"));
            return true;
        }

        if(arguments.length == 0){ // Quer curar a si proprio
            if(!(sender instanceof Player)){
                sender.sendMessage("§cVocê não pode curar a si próprio!");
                return true;
            }

            if(!sender.hasPermission("dreamcore.curar")){
                sender.sendMessage(MessageUtils.NO_PERMISSION);
                return true;
            }

            Player player = (Player) sender;

            player.setHealth(player.getMaxHealth());

            sender.sendMessage("§aYay! Você se curou.");
        } else { // Quer curar outro player
            if(!sender.hasPermission("dreamcore.curar.outros")){
                sender.sendMessage(MessageUtils.NO_PERMISSION);
                return true;
            }

            Player target = Bukkit.getPlayer(arguments[0]);

            if(target == null){ // Nao encontrou player
                sender.sendMessage(MessageUtils.PLAYER_NOT_FOUND);
                return true;
            }

            target.setHealth(target.getMaxHealth());

            sender.sendMessage("§aVocê curou " + PlayerUtils.getFormattedName(target) + " §a.");
        }

        return true;
    }

}
