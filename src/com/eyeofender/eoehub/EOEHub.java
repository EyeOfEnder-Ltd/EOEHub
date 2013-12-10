package com.eyeofender.eoehub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.eyeofender.eoehub.listener.PlayerListener;
import com.eyeofender.eoehub.listener.VotingListener;
import com.eyeofender.eoehub.menus.Menu;
import com.eyeofender.eoehub.timers.BarTimer;

public class EOEHub extends JavaPlugin {

    public Map<String, Boolean> ienvisible = new HashMap<String, Boolean>();
    public List<Player> invisible = new ArrayList<Player>();

    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.getServer().getPluginManager().registerEvents(new VotingListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        this.getServer().getPluginManager().registerEvents(new Menu(), this);
        getCommand("setloc").setExecutor(new SetLocCommand(this));

        BarTimer barTimer = new BarTimer(this);
        barTimer.init();

        Menu.init(this);
    }

    public void teleportPlayer(Player player, Location location) {
        if (location == null) return;

        Location l = location.clone().add(0.5D, 0.5D, 0.5D);
        player.teleport(l);
    }

    public Location getLocation(String name) {
        String worldName = getConfig().getString("location." + name + ".world");
        if (worldName == null) return null;

        World world = Bukkit.getWorld(worldName);
        double x = getConfig().getDouble("location." + name + ".x");
        double y = getConfig().getDouble("location." + name + ".y");
        double z = getConfig().getDouble("location." + name + ".z");
        double yaw = getConfig().getDouble("location." + name + ".yaw");
        double pitch = getConfig().getDouble("location." + name + ".pitch");

        return new Location(world, x, y, z, (float) yaw, (float) pitch);
    }

    public void setLocation(String name, Location spawnLocation) {
        getConfig().set("location." + name + ".world", spawnLocation.getWorld().getName());
        getConfig().set("location." + name + ".x", spawnLocation.getBlockX() + 0.5);
        getConfig().set("location." + name + ".y", spawnLocation.getY());
        getConfig().set("location." + name + ".z", spawnLocation.getBlockZ() + 0.5);
        getConfig().set("location." + name + ".yaw", spawnLocation.getYaw());
        getConfig().set("location." + name + ".pitch", spawnLocation.getPitch());
        saveConfig();
    }
}
