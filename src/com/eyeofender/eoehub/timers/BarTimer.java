package com.eyeofender.eoehub.timers;

import java.util.List;
import java.util.Random;

import me.confuser.barapi.BarAPI;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.eyeofender.eoehub.EOEHub;
import com.google.common.collect.ImmutableList;

public class BarTimer implements Runnable {

    private static Random rand = new Random();
    private static ChatColor[] validColors = { ChatColor.AQUA, ChatColor.BLUE, ChatColor.DARK_AQUA, ChatColor.DARK_BLUE, ChatColor.DARK_GREEN, ChatColor.DARK_PURPLE, ChatColor.DARK_RED,
            ChatColor.GOLD, ChatColor.GREEN, ChatColor.LIGHT_PURPLE, ChatColor.RED, ChatColor.YELLOW };

    private EOEHub plugin;
    private int timer;
    private List<String> messages;
    private int message;

    public BarTimer(EOEHub plugin) {
        this.plugin = plugin;
    }

    public void init() {
        messages = ImmutableList.of("Eye of Ender | hub.playeoe.com", "Coming Soon | Search & Destroy", "Website | www.eyeofender.com", "Coming Soon | Survival Games");
        timer = messages.size() * 10;
        plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, this, 20L, 20L);
    }

    @Override
    public void run() {
        if (timer % 10 == 0) message = timer / 10;

        for (Player player : plugin.getServer().getOnlinePlayers()) {
            BarAPI.setMessage(player, getRandomColor() + "-=- " + messages.get(message - 1) + " -=-");
            BarAPI.setHealth(player, (float) message / messages.size());
        }

        timer--;
        if (timer <= 0) timer = messages.size() * 10;
    }

    private ChatColor getRandomColor() {
        return validColors[rand.nextInt(validColors.length)];
    }
}