package com.eyeofender.eoehub.menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
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

public class Menu implements Listener {
    public static Inventory myInventory = Bukkit.createInventory(null, 9, "-=- Eye Of Ender Hub -=-");

    static {
        createDisplay(Material.BOW, myInventory, 1, "Archer Games", "Click to open kit menu.");
        createDisplay(Material.BLAZE_POWDER, myInventory, 3, "Search & Destroy", "Coming soon.");
        createDisplay(Material.BREAD, myInventory, 5, "Hunger Games", "Coming soon.");
        createDisplay(Material.IRON_BLOCK, myInventory, 7, "To be announced", "Coming soon.");
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();
        if (inventory.getName().equals(myInventory.getName())) {
            if (clicked.getType() == Material.DIAMOND_SWORD) {
                event.setCancelled(true);
                player.closeInventory();
            } else {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onMenuClick(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
                && event.getItem().getType() == Material.COMPASS) {
            event.getPlayer().openInventory(myInventory);
        }
    }

    public static void createDisplay(Material material, Inventory inv, int Slot, String name, String lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(lore);
        meta.setLore(Lore);
        item.setItemMeta(meta);

        inv.setItem(Slot, item);

    }

    public static ItemStack menuCompass() {
        ItemStack item = new ItemStack(Material.COMPASS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Server List");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add("Click to pick server.");
        meta.setLore(Lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack invisibleGelInactive() {
        ItemStack item = new ItemStack(Material.MAGMA_CREAM);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Invisibility Gel");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add("Toggles player visibility.");
        meta.setLore(Lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack invisibleGelActive() {
        ItemStack item = new ItemStack(Material.SLIME_BALL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Invisibility Gel");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add("Toggles player visibility.");
        meta.setLore(Lore);
        item.setItemMeta(meta);

        return item;
    }
}