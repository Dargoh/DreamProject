package br.dargoh.dreamcore.util;

import br.dargoh.dreamcore.DreamCore;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultUtils {

    public static Economy econ;
    public static Permission perms;
    public static Chat chat;

    public static boolean setupEconomy(){
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            return false;
        }

        RegisteredServiceProvider<Economy> rsp = DreamCore.PLUGIN.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static boolean setupChat(){
        RegisteredServiceProvider<Chat> rsp = DreamCore.PLUGIN.getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    public static boolean setupPermissions(){
        RegisteredServiceProvider<Permission> rsp = DreamCore.PLUGIN.getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

}
