package com.eyeofender.eoehub.timers;

import java.util.List;

import me.confuser.barapi.BarAPI;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.eyeofender.eoehub.EOEHub;
import com.google.common.collect.ImmutableList;

public class BarTimer implements Runnable {

    private static ChatColor[] validColors = { ChatColor.AQUA, ChatColor.DARK_GREEN, ChatColor.DARK_PURPLE, ChatColor.GOLD, ChatColor.DARK_AQUA, ChatColor.GREEN, ChatColor.LIGHT_PURPLE,
            ChatColor.RED, ChatColor.BLUE, ChatColor.YELLOW };

    private EOEHub plugin;
    private int timer;
    private List<String> messages;
    private int color;

    public BarTimer(EOEHub plugin) {
        this.plugin = plugin;
    }

    public void init() {
        messages = ImmutableList.of("Eye of Ender | hub.playeoe.com", "Coming Soon | Search & Destroy", "Website | www.eyeofender.com", "Coming Soon | Survival Games");
        plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, this, 0L, 5 * 20L);
    }

    @Override
    public void run() {
        String message = getNextColor() + "-=- " + messages.get(timer) + " -=-";
        float progress = ((float) timer) / (messages.size() - 1);

        for (Player player : plugin.getServer().getOnlinePlayers()) {
            BarAPI.setMessage(player, message, progress * 100);
        }

        timer++;
        if (timer == messages.size()) timer = 0;
    }

    private ChatColor getNextColor() {
        color++;
        if (color == validColors.length) color = 0;
        return validColors[color];
    }
}