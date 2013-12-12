package com.eyeofender.eoehub.listener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

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
        Boolean premium = false;

        try {
            URL url = new URL("http://www.minecraft.net/haspaid.jsp?user=" + event.getVote().getUsername());
            String pr = new BufferedReader(new InputStreamReader(url.openStream())).readLine().toUpperCase();
            premium = Boolean.valueOf(pr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(premium == true){
            Vote vote = event.getVote();
            String p = vote.getUsername();
            int amount = plugin.getConfig().getInt("votingAmount");
    
            CurrencyMain.api.pay(p, amount, false);
            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "broadcast ALL " + ChatColor.RED + "[ " + ChatColor.BLUE + "Voting" + ChatColor.RED + " ] " + ChatColor.RED + p
                    + " has voted and received $1,000. Type /Vote.");
        }
    }
}
