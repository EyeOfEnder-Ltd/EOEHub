package com.eyeofender.eoehub.timers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.confuser.barapi.BarAPI;

import com.eyeofender.eoehub.EOEHub;

public class BarTimer implements Runnable{

	EOEHub plugin;
	int t;
	int timer;
	
	public BarTimer ( EOEHub plugin ){
		this.plugin = plugin;
	}
	
	public void init(){
		timer = 40;
		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, this, 20L, 20L);
	}

	@Override
	public void run() {
		if(timer != 0){
			timer--;
		}
		if(timer == 40){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.GOLD + "-=- Eye Of Ender | Hub.PlayEoE.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 39){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.RED + "-=- Eye Of Ender | Hub.PlayEoE.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 38){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.LIGHT_PURPLE + "-=- Eye Of Ender | Hub.PlayEoE.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 37){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.BLUE + "-=- Eye Of Ender | Hub.PlayEoE.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 36){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.GOLD + "-=- Eye Of Ender | Hub.PlayEoE.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 35){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.RED +"-=- Eye Of Ender | Hub.PlayEoE.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 34){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.LIGHT_PURPLE + "-=- Eye Of Ender | Hub.PlayEoE.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 33){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.BLUE + "-=- Eye Of Ender | Hub.PlayEoE.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 32){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.GOLD + "-=- Eye Of Ender | Hub.PlayEoE.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 31){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.RED + "-=- Eye Of Ender | Hub.PlayEoE.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}if(timer == 30){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.LIGHT_PURPLE + "-=- Coming Soon: Search & Destroy -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 29){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.BLUE + "-=- Coming Soon: Search & Destroy -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}if(timer == 28){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.GOLD + "-=- Coming Soon: Search & Destroy -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 27){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.RED + "-=- Coming Soon: Search & Destroy -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 26){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.LIGHT_PURPLE + "-=- Coming Soon: Search & Destroy -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 25){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.BLUE + "-=- Coming Soon: Search & Destroy -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}if(timer == 24){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.GOLD + "-=- Coming Soon: Search & Destroy -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 23){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.RED + "-=- Coming Soon: Search & Destroy -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 22){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.LIGHT_PURPLE + "-=- Coming Soon: Search & Destroy -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 21){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.BLUE + "-=- Coming Soon: Search & Destroy -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}if(timer == 20){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.GOLD + "-=- Eye Of Ender Website | EyeOfEnder.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 19){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.RED + "-=- Eye Of Ender Website | EyeOfEnder.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 18){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.LIGHT_PURPLE + "-=- Eye Of Ender Website | EyeOfEnder.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 17){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.BLUE + "-=- Eye Of Ender Website | EyeOfEnder.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}if(timer == 16){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.GOLD + "-=- Eye Of Ender Website | EyeOfEnder.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 15){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.RED + "-=- Eye Of Ender Website | EyeOfEnder.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 14){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.LIGHT_PURPLE + "-=- Eye Of Ender Website | EyeOfEnder.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 13){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.BLUE + "-=- Eye Of Ender | Hub.PlayEoE.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 12){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.GOLD + "-=- Eye Of Ender Website | EyeOfEnder.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}if(timer == 11){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.RED + "-=- Eye Of Ender Website | EyeOfEnder.Com -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 10){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.LIGHT_PURPLE + "-=- Coming Soon: Survival Games -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 9){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.GOLD + "-=- Coming Soon: Survival Games -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 8){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.BLUE + "-=- Coming Soon: Survival Games -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 7){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.GOLD + "-=- Coming Soon: Survival Games -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}if(timer == 6){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.GOLD + "-=- Coming Soon: Survival Games -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 5){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.RED + "-=- Coming Soon: Survival Games -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 4){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.LIGHT_PURPLE + "-=- Coming Soon: Survival Games -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 3){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.BLUE + "-=- Coming Soon: Survival Games -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
			}
		}
		if(timer == 1){
			for(Player player : plugin.getServer().getOnlinePlayers()){
				BarAPI.setMessage(player, ChatColor.GOLD + "-=- Coming Soon: Survival Games -=-");
				BarAPI.setHealth(player, (float) (timer * 2.5));
				timer = 40;
			}
		}
	}
	
}