package com.eyeofender.eoehub.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.util.Vector;

import com.eyeofender.eoehub.EOEHub;
import com.eyeofender.eoehub.menus.Menu;

public class PlayerListener implements Listener {

    EOEHub plugin;

    public PlayerListener(EOEHub plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoinHub(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setGameMode(GameMode.SURVIVAL);
        player.getInventory().clear();

        Inventory i = player.getInventory();
        i.setItem(0, Menu.menuCompass());
        i.setItem(8, Menu.invisibleGelInactive());

        event.setJoinMessage(null);
        player.sendMessage(ChatColor.GREEN + "Welcome to " + ChatColor.BOLD + "Eye Of Ender! " + ChatColor.GREEN + "Click a sign to join a server.");
        plugin.teleportPlayer(player, plugin.l);

        for (Player players : Bukkit.getOnlinePlayers()) {
            if (plugin.invisible.contains(players)) {
                players.hidePlayer(event.getPlayer());
            } else {
                players.showPlayer(event.getPlayer());
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onKick(PlayerKickEvent event) {
        event.setLeaveMessage(null);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLeave(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.PHYSICAL) {
            // The player triggered a physical interaction event

            if (event.getClickedBlock().getType() == Material.STONE_PLATE) {
                // The player stepped on a stone pressure plate

                event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().multiply(5));
                event.getPlayer().setVelocity(new Vector(event.getPlayer().getVelocity().getX(), 1.0D, event.getPlayer().getVelocity().getZ()));
            }
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getCause() == DamageCause.FALL) {
                event.setDamage(0.0);
            }
        }
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getItem() == null) return;

        if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {

            if (event.getItem().isSimilar(Menu.invisibleGelInactive())) {
                player.playSound(player.getLocation(), Sound.SLIME_ATTACK, 20L, 1L);
                for (Player players : Bukkit.getOnlinePlayers()) {
                    player.hidePlayer(players);
                }
                plugin.invisible.add(player);
                player.sendMessage(ChatColor.BLUE + "Players are now invisible!");
            } else if (event.getItem().isSimilar(Menu.invisibleGelActive())) {
                player.playSound(player.getLocation(), Sound.ORB_PICKUP, 20L, 20L);
                for (Player players : Bukkit.getOnlinePlayers()) {
                    player.showPlayer(players);
                }
                plugin.invisible.remove(player);
                player.sendMessage(ChatColor.BLUE + "Players are now visible!");
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onWeatherUpdate(WeatherChangeEvent event) {
        if (event.toWeatherState() && !plugin.getConfig().getBoolean("weather-enabled")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemThrow(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onItemPickUp(PlayerPickupItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerHunger(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }
}
