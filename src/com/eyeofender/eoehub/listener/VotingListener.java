package com.eyeofender.eoehub.listener;

import me.libraryaddict.Currency.CurrencyMain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.eyeofender.eoehub.EOEHub;
import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;

public class VotingListener implements Listener {

	EOEHub plugin;
	
	public VotingListener(EOEHub plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onVote(VotifierEvent event){
		Vote vote = event.getVote();
		String p = vote.getUsername();
		Player player = Bukkit.getPlayer(p);
		
		int amount = plugin.getConfig().getInt("votingAmount");
		
		CurrencyMain.api.pay(player.getName(), amount, false);
		
		Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "broadcast ALL " + ChatColor.RED + "[ " + ChatColor.BLUE + "Voting" + ChatColor.RED + " ] " +ChatColor.RED + player.getName() + " has voted and received $1,000. Type /Vote.");
	}
}
