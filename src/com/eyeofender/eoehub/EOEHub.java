package com.eyeofender.eoehub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import pgDev.bukkit.DisguiseCraft.DisguiseCraft;
import pgDev.bukkit.DisguiseCraft.api.DisguiseCraftAPI;

import com.eyeofender.enderpearl.EnderPearl;
import com.eyeofender.eoehub.handlers.ConfigurationHandler;
import com.eyeofender.eoehub.listener.PlayerListener;
import com.eyeofender.eoehub.listener.VotingListener;
import com.eyeofender.eoehub.menus.Menu;
import com.eyeofender.eoehub.menus.ModMenu;
import com.eyeofender.eoehub.timers.BarTimer;

public class EOEHub extends JavaPlugin {

    public Map<String, Boolean> ienvisible = new HashMap<String, Boolean>();
    public List<Player> invisible = new ArrayList<Player>();
    
    /** Classes **/
    private ConfigurationHandler configHandler = new ConfigurationHandler(this);
	private DisguiseCraftAPI dcAPI;
	private EnderPearl ep;

    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
		this.setupDisguiseCraft();

        /** Loads Inits **/
         configHandler.init();
        
        this.getServer().getPluginManager().registerEvents(new VotingListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        this.getServer().getPluginManager().registerEvents(new Menu(), this);
        this.getServer().getPluginManager().registerEvents(new ModMenu(), this);
        getCommand("setloc").setExecutor(new SetLocCommand(this));

        BarTimer barTimer = new BarTimer(this);
        barTimer.init();

        Menu.init(this);
        ModMenu.init(this);
        
        
        try {
            this.ep = (EnderPearl) this.getServer().getPluginManager().getPlugin("EnderPearl");
        } catch (NoClassDefFoundError e) {
            getLogger().info("Unsupported or no version of EnderPearl found.");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }
    
    /**********************************************
	 * 
	 * 				Messaging
	 * 
	 *********************************************/
	
	public void sendMessage(Player player, String message){
		player.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "< " + ChatColor.BLUE + "Hub" + ChatColor.RED + ChatColor.BOLD + " > " + ChatColor.GRAY + message);
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

	public ConfigurationHandler getConfigHandler() {
		return configHandler;
	}

	public void setConfigHandler(ConfigurationHandler configHandler) {
		this.configHandler = configHandler;
	}
	
	public void setupDisguiseCraft() {
		setDcAPI(DisguiseCraft.getAPI());
	}

	public DisguiseCraftAPI getDcAPI() {
		return dcAPI;
	}

	public void setDcAPI(DisguiseCraftAPI dcAPI) {
		this.dcAPI = dcAPI;
	}

	public EnderPearl getEp() {
		return ep;
	}

	public void setEp(EnderPearl ep) {
		this.ep = ep;
	}
}
