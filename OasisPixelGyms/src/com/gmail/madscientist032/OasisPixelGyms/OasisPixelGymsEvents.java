package com.gmail.madscientist032.OasisPixelGyms;

//import net.charter.orion_pax.OasisExtras.OasisPlayer;
import com.gmail.madscientist032.OasisPixelGyms.OasisPixelGyms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OasisPixelGymsEvents {

	private OasisPixelGyms plugin;
	
	// On login, check if player has 'leader' or 'coleader' perm node. 
	// if leader/coleader perm exists, check if player has 'staff' perm group. 
	// if staff perm exists, check if staff member is vanished.
	// if staff member joined vanished, do not fire announcement. 
	// 
	// 
	@EventHandler(priority = EventPriority.HIGH)
	public boolean OnPlayerJoin(final PlayerJoinEvent event){
		Player player = event.getPlayer();
		
		//First round of checks. Here we check the config to see if the 'notify-on-gymleader-join' is set to true

		//second round of checks. here we check if player has leader or coleader perm node. 
			if(player.hasPermission("oasispixelgyms.gyms.leader") || (player.hasPermission("oasispixelgyms.gyms.coleader"))){
				//event.setJoinMessage(ChatColor.YELLOW + "The Gym Leader " + event.getPlayer().getName() + " has joined the server!");
				this.plugin.getServer().broadcastMessage(ChatColor.YELLOW + "The Gym Leader " + player.getName() + " has joined the server!");
				this.plugin.getLogger().info(player.getName() + " joined as a Gym Leader.");
				return true;
			}
			this.plugin.getServer().broadcastMessage(ChatColor.AQUA + "Player " + player.getName() + " has joined the server. How boring.");
			this.plugin.getLogger().info(player.getName() + " joined normally.");
			return false;
		}
		
	}
	
	
		//	sender.sendMessage(ChatColor.GOLD + oplayer.getName());
/*
if ((player.hasPermission("OasisPixelGyms.gyms.leader")) || (player.hasPermission("OasisPixelGyms.gyms.coleader"))) 
{ 
	// plugin.getServer().broadcastMessage(ChatColor.GOLD + "A gym leader has logged in!"); // + ChatColor.RED + "DISABLED!");
	event.setJoinMessage(ChatColor.GOLD + "The Gym leader " + event.getPlayer().getName() + " has logged in!");
	// currently the login messages are not displaying for those who have the perm nodes.
}
else {
	return;
	//plugin.getServer().broadcastMessage(ChatColor.AQUA + "A gym leader has shit himself!"); //')
}

*/