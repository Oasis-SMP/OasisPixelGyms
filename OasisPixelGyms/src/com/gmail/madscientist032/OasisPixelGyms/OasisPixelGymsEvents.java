package com.gmail.madscientist032.OasisPixelGyms;

//import net.charter.orion_pax.OasisExtras.OasisPlayer;

import java.util.logging.Filter;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.LogRecord;


import com.gmail.madscientist032.OasisPixelGyms.OasisPixelGyms;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.*;
import org.bukkit.event.player.PlayerJoinEvent;

public class OasisPixelGymsEvents implements Listener {
	
	public OasisPixelGymsEvents(OasisPixelGyms plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
				
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){ 
		Player player = e.getPlayer(); //grabbing player
		String logString;
		if //begin check staff (this is hard coded and will be removed in a later version)
		(	
			(player.hasPermission("oasispixelgyms.gyms.leader") || (player.hasPermission("oasispixelgyms.gyms.coleader")))
					&& (player.hasPermission("oasispixelgyms.staff")) ) 
			return;
		else if (
			(player.hasPermission("oasispixelgyms.gyms.leader") || (player.hasPermission("oasispixelgyms.gyms.coleader")) ) )
			{
			//getLogger().info(ChatColor.AQUA + "The gym leader " + player.getName() + " has joined the game!");
			//Logger.getLogger(ChatColor.AQUA + "The gym leader " + player.getName() + " has joined the game!");
			logString=(ChatColor.AQUA + "The gym leader " + player.getName() + " has joined the game!").toString();
			e.setJoinMessage(ChatColor.AQUA + "The gym leader " + player.getName() + " has joined the game!"); // this is sent out to the ENTIRE server.
		// eventually the plugin will be able to detect which gym the player is a leader/coleader of!
			
			// oasispixelgyms.gyms.leader.bug
			// oasispixelgyms.gyms.leader.<type>
	}
		else {
			return;
			//player.sendMessage(ChatColor.GREEN + "This is a private message."); // this is sent only to the player.
		}
			
	} //end onPlayerJoin

	
}// end class