package com.eyeofender.eoehub.listener;

import me.libraryaddict.Currency.CurrencyMain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.eyeofender.UniversalCredits.UniversalCredits;
import com.eyeofender.eoehub.EOEHub;
import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;

public class VotingListener implements Listener {

    private static final String PREFIX = ChatColor.RED + "[ " + ChatColor.BLUE + "Voting" + ChatColor.RED + " ] " + ChatColor.RED;

    private EOEHub plugin;

    public VotingListener(EOEHub plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onVote(VotifierEvent event) {

        Vote vote = event.getVote();
        String player = vote.getUsername();
        int amount = plugin.getConfig().getInt("votingAmount");

        CurrencyMain.api.pay(player, amount, false);
        UniversalCredits.api.pay(player, 50, false);
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "broadcast ALL " + PREFIX + player + " has voted and received $1,000 and 50 Credits. Type /Vote.");
    }
}
