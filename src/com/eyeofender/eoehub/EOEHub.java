package com.eyeofender.eoehub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.eyeofender.eoehub.listener.PlayerListener;
import com.eyeofender.eoehub.listener.VotingListener;
import com.eyeofender.eoehub.menus.Menu;
import com.eyeofender.eoehub.timers.BarTimer;

public class EOEHub extends JavaPlugin {

    public Location l;
    public Map<String, Boolean> ienvisible = new HashMap<String, Boolean>();
    public List<Player> invisible = new ArrayList<Player>();

    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.getServer().getPluginManager().registerEvents(new VotingListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        this.getServer().getPluginManager().registerEvents(new Menu(), this);

        if (this.getConfig().contains("spawn")) {
            String y = this.getConfig().getString("spawn.yaw");
            String p = this.getConfig().getString("spawn.pitch");

            float yaw = Float.parseFloat(y);
            float pitch = Float.parseFloat(p);

            l = new Location(this.getServer().getWorld("world"), this.getConfig().getInt("spawn.x"), this.getConfig().getInt("spawn.y"), this.getConfig().getInt("spawn.z"), yaw, pitch);
        }

        BarTimer barTimer = new BarTimer(this);
        barTimer.init();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String CommandLabel, String[] args) {

        Player player = (Player) sender;

        if (CommandLabel.equalsIgnoreCase("setspawn")) {
            if (player.isOp()) {
                if (args.length == 0) {
                    this.getConfig().set("spawn.x", player.getLocation().getBlockX());
                    this.getConfig().set("spawn.y", player.getLocation().getBlockY());
                    this.getConfig().set("spawn.z", player.getLocation().getBlockZ());
                    this.getConfig().set("spawn.yaw", player.getLocation().getYaw());
                    this.getConfig().set("spawn.pitch", player.getLocation().getPitch());
                    player.sendMessage(ChatColor.RED + "Spawn point has been updated.");
                    this.saveConfig();

                } else {
                    this.getConfig().set("spawn.x", player.getLocation().getBlockX());
                    this.getConfig().set("spawn.y", player.getLocation().getBlockY());
                    this.getConfig().set("spawn.z", player.getLocation().getBlockZ());
                    this.getConfig().set("spawn.yaw", player.getLocation().getYaw());
                    this.getConfig().set("spawn.pitch", player.getLocation().getPitch());
                    player.sendMessage(ChatColor.RED + "Spawn point has been updated.");
                    this.saveConfig();
                }
            }
        }

        if (CommandLabel.equalsIgnoreCase("spawn")) {
            if (args.length == 0) {
                this.teleportPlayer(player, l);
                player.sendMessage(ChatColor.RED + "You have been spawned.");
            } else {
                this.teleportPlayer(player, l);
                player.sendMessage(ChatColor.RED + "You have been spawned.");
            }
        }

        return false;
    }

    public void teleportPlayer(Player player, Location location) {
        Location l = location.clone().add(0.5D, 0.5D, 0.5D);

        player.teleport(l);
    }
}
