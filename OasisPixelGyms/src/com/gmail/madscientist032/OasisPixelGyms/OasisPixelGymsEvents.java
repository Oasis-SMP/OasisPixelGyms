package com.gmail.madscientist032.OasisPixelGyms;

//import net.charter.orion_pax.OasisExtras.OasisPlayer;
import com.gmail.madscientist032.OasisPixelGyms.OasisPixelGyms;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
//import org.bukkit.plugin.java.*;
import org.bukkit.event.player.PlayerJoinEvent;

public class OasisPixelGymsEvents implements Listener {
	public OasisPixelGymsEvents(OasisPixelGyms plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){ 
		Player player = e.getPlayer(); //grabbing player
		if(player.hasPermission("oasispixelgyms.gyms.leader") 
				|| (player.hasPermission("oasispixelgyms.gyms.coleader"))){
		e.setJoinMessage(ChatColor.AQUA + "The Gym Leader " + player.getName() + " has logged on!"	); // this is sent out to the ENTIRE server.
	}
		else {
			player.sendMessage(ChatColor.GREEN + "This is a private message."); // this is sent only to the player.
		}
			
	} //end onPlayerJoin
	
}// end class