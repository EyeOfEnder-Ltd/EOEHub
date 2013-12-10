package com.eyeofender.eoehub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLocCommand implements CommandExecutor {

    private EOEHub plugin;

    public SetLocCommand(EOEHub plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (args.length > 0) {
            plugin.setLocation(args[0], player.getLocation());
            player.sendMessage(ChatColor.GREEN + "Waypoint set to your current location.");
        } else {
            player.sendMessage(ChatColor.RED + "Please specify a waypoint.");
        }
        return true;
    }

}
