package me.megalodonbait.chatNickPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission("nicknameplugin.nickself")){
            String playerName = player.getName();
            if (args.length != 2){
                player.sendMessage(ChatColor.RED + "Usage: /nick <player> <nickname>");
            } else if (!playerName.equalsIgnoreCase(args[0])) {
                if (player.hasPermission("nicknameplugin.nickothers")) {
                    Player player1 = Bukkit.getPlayer(args[0]);
                    player1.setDisplayName(args[1]);
                    player.sendMessage(ChatColor.GREEN + args[0] + "'s nickname set to: " + args[1]);
                } else {
                    player.sendMessage(ChatColor.RED + "You don't have permission to use this command");
                }
            } else {
                player.setDisplayName(args[1]);
                player.sendMessage(ChatColor.GREEN + args[0] + "'s nickname set to: " + args[1]);
            }
        } else {
            player.sendMessage(ChatColor.RED + "You don't have permission to use this command");
        }
        return true;
    }
}
