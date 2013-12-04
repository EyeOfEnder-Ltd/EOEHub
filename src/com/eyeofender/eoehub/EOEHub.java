package com.eyeofender.eoehub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
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

        BarTimer barTimer = new BarTimer(this);
        barTimer.init();
    }

    public void teleportPlayer(Player player, Location location) {
        if (location == null) return;

        Location l = location.clone().add(0.5D, 0.5D, 0.5D);
        player.teleport(l);
    }
}
