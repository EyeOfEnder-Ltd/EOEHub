package com.eyeofender.eoehub.menus;

import java.util.ArrayList;
import java.util.Map;
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

import pgDev.bukkit.DisguiseCraft.disguise.Disguise;
import pgDev.bukkit.DisguiseCraft.disguise.DisguiseType;

import com.eyeofender.eoehub.EOEHub;
import com.google.common.collect.Maps;

public class ModMenu implements Listener {
    public static Inventory myInventory = Bukkit.createInventory(null, 54, "   -=- Disguise Menu -=-");
    private static Map<ItemStack, Integer> icons = Maps.newHashMap();

    private static EOEHub plugin;

    public static void init(EOEHub plugin) {
        ModMenu.plugin = plugin;

        createDisplay(Material.EGG, myInventory, 0, ChatColor.BLUE + "Chicken");
        createDisplay(Material.LEATHER, myInventory, 2, ChatColor.BLUE + "Cow");
        createDisplay(Material.MILK_BUCKET, myInventory, 4, ChatColor.BLUE + "Ocelot");
        createDisplay(Material.RAW_BEEF, myInventory, 6, ChatColor.BLUE + "Pig");
        createDisplay(Material.WOOL, myInventory, 8, ChatColor.BLUE + "Sheep");
        createDisplay(Material.HAY_BLOCK, myInventory, 10, ChatColor.BLUE + "Horse");
        createDisplay(Material.INK_SACK, myInventory, 12, ChatColor.BLUE + "Squid");
        createDisplay(Material.STONE, myInventory, 14, ChatColor.BLUE + "Bat");
        createDisplay(Material.EMERALD, myInventory, 16, ChatColor.BLUE + "Villager");
        createDisplay(Material.RED_MUSHROOM, myInventory, 18, ChatColor.BLUE + "Mooshroom");
        createDisplay(Material.ENDER_PEARL, myInventory, 20, ChatColor.BLUE + "Enderman");
        createDisplay(Material.STRING, myInventory, 22, ChatColor.BLUE + "Spider");
        createDisplay(Material.BONE, myInventory, 24, ChatColor.BLUE + "Wolf");
        createDisplay(Material.GOLD_NUGGET, myInventory, 26, ChatColor.BLUE + "Zombie Pigman");
        createDisplay(Material.BLAZE_ROD, myInventory, 28, ChatColor.BLUE + "Blaze");
        createDisplay(Material.SULPHUR, myInventory, 30, ChatColor.BLUE + "Creeper");
        createDisplay(Material.MAGMA_CREAM, myInventory, 32, ChatColor.BLUE + "Magma Cube");
        createDisplay(Material.RAW_FISH, myInventory, 34, ChatColor.BLUE + "Silverfish");
        createDisplay(Material.ARROW, myInventory, 36, ChatColor.BLUE + "Skeleton");
        createDisplay(Material.SLIME_BALL, myInventory, 38, ChatColor.BLUE + "Slime");
        createDisplay(Material.POTION, myInventory, 40, ChatColor.BLUE + "Witch");
        createDisplay(Material.IRON_INGOT, myInventory, 42, ChatColor.BLUE + "Iron Golem");
        createDisplay(Material.ROTTEN_FLESH, myInventory, 44, ChatColor.BLUE + "Zombie");
        createDisplay(Material.WATER_BUCKET, myInventory, 48, ChatColor.RED + "Undisguise");
        createDisplay(Material.LAVA, myInventory, 50, ChatColor.RED + "Back");

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();

        if (clicked == null) return;
        
        if(!plugin.getEp().getRankManager().hasRank(player)){
        	plugin.sendMessage(player, ChatColor.RED + "You have to be Iron+ to use disguise menu.");
        	player.closeInventory();
        	return;
        }

        if (inventory.getName().equals(myInventory.getName())) {
            event.setCancelled(true);
            if (clicked.getType() == Material.EGG) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Chicken);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a chicken.");
            }else if (clicked.getType() == Material.LAVA) { 
				player.closeInventory(); 
            }else if (clicked.getType() == Material.WATER_BUCKET) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				plugin.sendMessage(player, "You have been undisguised.");
            }else if (clicked.getType() == Material.ROTTEN_FLESH) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Zombie);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a zombie.");
            }else if (clicked.getType() == Material.IRON_INGOT) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.IronGolem);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a iron golem.");
            }else if (clicked.getType() == Material.POTION) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Witch);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a witch.");
            }else if (clicked.getType() == Material.SLIME_BALL) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Slime);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a slime.");
            }else if (clicked.getType() == Material.ARROW) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Skeleton);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a skeleton.");
            }else if (clicked.getType() == Material.RAW_FISH) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Silverfish);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a silverfish.");
            }else if (clicked.getType() == Material.MAGMA_CREAM) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.MagmaCube);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a magma cube.");
            }else if (clicked.getType() == Material.SULPHUR) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Creeper);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a creeper.");
            }else if (clicked.getType() == Material.BLAZE_ROD) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Blaze);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a blaze.");
            }else if (clicked.getType() == Material.GOLD_NUGGET) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.PigZombie);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a zombie pigman.");
            }else if (clicked.getType() == Material.BONE) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Wolf);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a wolf.");
            }else if (clicked.getType() == Material.STRING) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Spider);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a spider.");
            }else if (clicked.getType() == Material.ENDER_PEARL) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Enderman);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a ender man.");
            }else if (clicked.getType() == Material.RED_MUSHROOM) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.MushroomCow);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a mushroom.");
            }else if (clicked.getType() == Material.EMERALD) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Villager);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a villager.");
            }else if (clicked.getType() == Material.STONE) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Bat);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a bat.");
            }else if (clicked.getType() == Material.INK_SACK) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Squid);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a squid.");
            }else if (clicked.getType() == Material.HAY_BLOCK) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Horse);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a horse.");
            }else if (clicked.getType() == Material.WOOL) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Sheep);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a sheep.");
            }else if (clicked.getType() == Material.RAW_BEEF) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Pig);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a pig.");
            }else if (clicked.getType() == Material.LEATHER) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Cow);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a cow.");
            }else if (clicked.getType() == Material.MILK_BUCKET) { 
				player.closeInventory(); 
				
				if(plugin.getDcAPI().isDisguised(player))
					plugin.getDcAPI().undisguisePlayer(player);
				
				Disguise d = new Disguise(plugin.getDcAPI().newEntityID(), DisguiseType.Ocelot);
				plugin.getDcAPI().disguisePlayer(player, d);
				
				plugin.sendMessage(player, "You have been disguised as a ocelot.");
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
        Lore.add(ChatColor.GRAY + "Click to disguise.");
        Lore.add(ChatColor.RED + "* Have to be Iron+ *");
        meta.setLore(Lore);
        item.setItemMeta(meta);

        inv.setItem(slot, item);
        icons.put(item, slot);
    }

    public static ItemStack menuItem() {
        ItemStack item = new ItemStack(Material.MONSTER_EGG);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "Disguise Menu");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add("Click to use Disguise Menu.");
        meta.setLore(Lore);
        item.setItemMeta(meta);

        return item;
    }
}