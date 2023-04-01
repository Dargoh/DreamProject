package br.dargoh.dreamcore.util;

import org.bukkit.plugin.java.JavaPlugin;

public class MessageUtils {
    public static String SERVER_NAME = "§5§lDREAM";

    public static String COMMAND_NOT_FOUND = "§cComando desconhecido!";
    public static String NO_PERMISSION = "§cVocê não tem permissão para fazer isto!";
    public static String PLAYER_NOT_FOUND = "§cJogador não encontrado!";

    public static String ONLY_PLAYERS = "§cEste comando só pode ser executado por jogadores!";

    public static String commandUse(String command){
        return "§cUso correto: '/@command'".replaceAll("@command", command);
    }

    public static void pluginLoaded(JavaPlugin plugin){
        plugin.getLogger().info(plugin.getName() + " carregado com sucesso.");
    }
}
