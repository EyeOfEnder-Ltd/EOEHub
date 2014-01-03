package com.eyeofender.eoehub.menus;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.eyeofender.eoehub.EOEHub;
import com.google.common.collect.Maps;

public class HeadMenu implements Listener {
    public static Inventory myInventory = Bukkit.createInventory(null, 9, "   -=- Eye of Ender Hub -=-");
    private static Map<ItemStack, Integer> icons = Maps.newHashMap();

    //private static EOEHub plugin;

    public static void init(EOEHub plugin) {
        //HeadMenu.plugin = plugin;

        int i = 0;
        for(String s : plugin.getConfigHandler().getStaffNames()){
        	createDisplay(Material.SKULL_ITEM, myInventory, i, s);
        	i++;
        	i++;
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();

        if (clicked == null) return;

        if (inventory.getName().equals(myInventory.getName())) {
            event.setCancelled(true);
            for (Entry<ItemStack, Integer> entry : icons.entrySet()) {
                if (clicked.isSimilar(entry.getKey())) {
                	//ItemStack skull = new ItemStack(397, 1, (short) 3);
                    //SkullMeta meta = (SkullMeta) skull.getItemMeta();
                    //meta.setOwner();
                    //skull.setItemMeta(meta);
                    //player.getInventory().setHelmet(skull);
                    player.closeInventory();
                    return;
                }
            }
        }
    }

    @EventHandler
    public void onMenuClick(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
                && event.getItem().isSimilar(menuItem())) {
            event.getPlayer().openInventory(myInventory);
        }
    }

    public static void createDisplay(Material material, Inventory inv, int slot, String name) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        ArrayList<String> Lore = new ArrayList<String>();
        meta.setLore(Lore);
        item.setItemMeta(meta);

        inv.setItem(slot, item);
        icons.put(item, slot);
    }

    public static ItemStack menuItem() {
        ItemStack item = new ItemStack(Material.EYE_OF_ENDER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "EOE Servers");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add("Click to pick server");
        meta.setLore(Lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack invisibilityGel() {
        ItemStack item = new ItemStack(Material.MAGMA_CREAM);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Invisibility Gel");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add("Toggles player visibility.");
        meta.setLore(Lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack visiblityGel() {
        ItemStack item = new ItemStack(Material.SLIME_BALL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Visibility Gel");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add("Toggles player visibility.");
        meta.setLore(Lore);
        item.setItemMeta(meta);

        return item;
    }
}