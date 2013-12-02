package com.eyeofender.eoehub.listener;

import me.libraryaddict.Currency.CurrencyMain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.eyeofender.eoehub.EOEHub;
import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;

public class VotingListener implements Listener {

    private EOEHub plugin;

    public VotingListener(EOEHub plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onVote(VotifierEvent event) {
        Vote vote = event.getVote();
        String p = vote.getUsername();
        int amount = plugin.getConfig().getInt("votingAmount");

        CurrencyMain.api.pay(p, amount, false);
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "broadcast ALL " + ChatColor.RED + "[ " + ChatColor.BLUE + "Voting" + ChatColor.RED + " ] " + ChatColor.RED + p
                + " has voted and received $1,000. Type /Vote.");
    }
}
