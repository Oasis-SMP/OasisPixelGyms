package com.gmail.madscientist032.OasisPixelGyms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import com.gmail.madscientist032.OasisPixelGyms.OasisPixelGyms;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LeadersCommand implements CommandExecutor{
	
	private OasisPixelGyms plugin;
	
	public LeadersCommand(OasisPixelGyms plugin){
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{

		
		//int gymNumber = 0; // Eight official gyms (not including Shadow Gym which is event-based 
		sender.sendMessage(ChatColor.GOLD + "[GYM LEADERS ONLINE]" );
		Player[] onlinePlayers = Bukkit.getServer()
				.getOnlinePlayers();
		for (Player oplayer : onlinePlayers) 
		{
			if ((oplayer != null)
					&& (oplayer.hasPermission("oasispixelgyms.gyms.leader")) || (oplayer.hasPermission("oasispixelgyms.gyms.coleader"))) 
			{
			String gym;
			
			//if (month == 1) {
			//   System.out.println("January");
			    
			if (oplayer.hasPermission("oasispixelgyms.gyms.leader.grass")) {
				gym = " - Grass Gym, levels 10-20";
				sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
				} else 
					if (oplayer.hasPermission("oasispixelgyms.gyms.leader.flying")) {
						gym = oplayer.getName() + "Flying Gym, levels 20-30"; 
						sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
					} else
						if (oplayer.hasPermission("oasispixelgyms.gyms.leader.bug")) {
							gym = " - Bug Gym, levels 30-40";
							sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
							} else
								if (oplayer.hasPermission("oasispixelgyms.gyms.leader.psychic")) {
									gym = " - Psychic Gym, levels 40-50";
									sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
									} else
										if (oplayer.hasPermission("oasispixelgyms.gyms.leader.water")) {
											gym = " - Water Gym, levels 50-60";
											sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
											} else
												if (oplayer.hasPermission("oasispixelgyms.gyms.leader.steel")) {
													gym = " - Steel Gym, levels 60-70";
													sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
													} else
														if (oplayer.hasPermission("oasispixelgyms.gyms.leader.dragon")) {
															gym = " - Dragon Gym, levels 70-80";
															sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
															} else
																if (oplayer.hasPermission("oasispixelgyms.gyms.leader.fire")) {
																	gym = " - Fire Gym, levels 80-90";
																	sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
																	} 
			/* switch (gymNumber) 
				{
				case 1: oplayer.hasPermission("oasispixelgyms.gyms.leader.grass");
				case 2: oplayer.hasPermission("oasispixelgyms.gyms.leader.flying");
				case 3: oplayer.hasPermission("oasispixelgyms.gyms.leader.bug");
				case 4: oplayer.hasPermission("oasispixelgyms.gyms.leader.psychic");
				case 5: oplayer.hasPermission("oasispixelgyms.gyms.leader.water");
				case 6: oplayer.hasPermission("oasispixelgyms.gyms.leader.steel");
				case 7: oplayer.hasPermission("oasispixelgyms.gyms.leader.dragon");
				case 8: oplayer.hasPermission("oasispixelgyms.gyms.leader.fire");
				} // end switch
				*/
			
			}	// end if
		}	//end for
		return true; // if return false, displays "usage: /leaders" ?
	}// end gymCommand
} // end of leaderscommand
	/*@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
	/* 	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.acprefix) + "[GYM LEADERS ONLINE]"); 
	//plugin.getServer().broadcastMessage(ChatColor.GOLD + sender.getName() + " is " + ChatColor.RED + "DISABLED!") 
		sender.sendMessage(ChatColor.GOLD + "[GYM LEADERS ONLINE]" );
				
		Player[] onlinePlayers = Bukkit.getServer()
				.getOnlinePlayers();
		for (Player oplayer : onlinePlayers) 
		{
			if ((oplayer != null) && (oplayer.hasPermission("oasispixelgyms.gyms.leader")) || (oplayer.hasPermission("oasispixelgyms.gyms.coleader"))) 
			{
				sender.sendMessage(ChatColor.GOLD + oplayer.getName());
			} //end if 
		} // end for
		return true;
	}
	// END OF GOOD CODE
*/

// } end leaderscommand.java

/*
 * int month = 8;
        String monthString;
        switch (month) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        System.out.println(monthString);
    }
}
 */

/* 
package net.charter.orion_pax.OasisChat.Commands;

import net.charter.orion_pax.OasisChat.OasisChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffCommand implements CommandExecutor {

	private OasisChat plugin; // pointer to your main class, unrequired if you don't need methods from the main class

	public StaffCommand(OasisChat plugin){
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes(
				'&', plugin.acprefix) + "[STAFF ONLINE]");
		Player[] onlinePlayers = Bukkit.getServer()
				.getOnlinePlayers();
		for (Player oplayer : onlinePlayers) {
			if ((oplayer != null)
					&& (oplayer.hasPermission("OasisChat.staff.a"))) {
				sender.sendMessage(ChatColor
						.translateAlternateColorCodes('&',
								plugin.acprefix)
								+ oplayer.getName());
			}
		}
		return true;
	}

}
*/