package com.Baummann.SetRank;


import org.bukkit.ChatColor; 
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class spl extends PlayerListener {
    public static SetRank plugin;
    
    public spl(SetRank instance) {
    	plugin = instance;
    }
    
    public void onPlayerJoin(PlayerJoinEvent event) {
    	Player player = event.getPlayer();
    	String a = "";
    	String g = plugin.getGroup(player);
    	if (player.getName().equals(SetRank.ownerName)) {
    		if (SetRank.broadcastRankOnLogin)
    			event.setJoinMessage(ChatColor.DARK_RED + player.getName() + " " + ChatColor.DARK_RED + "the " + ChatColor.YELLOW + "Owner " + ChatColor.DARK_RED + "joined the game");
    	} else {
    	    if (g.startsWith("a") || g.startsWith("e") || g.startsWith("i") || g.startsWith("o") || g.startsWith("u") || g.startsWith("A") || g.startsWith("E") || g.startsWith("I") || g.startsWith("O") || g.startsWith("U"))
    		    a = "an";
    	    else
    		    a = "a";
    	    if (SetRank.broadcastRankOnLogin)
    	        event.setJoinMessage(ChatColor.DARK_RED + player.getName() + " " + ChatColor.DARK_RED + a + " " + ChatColor.YELLOW + g + ChatColor.DARK_RED + " joined the game!");
    	}
    }
}
