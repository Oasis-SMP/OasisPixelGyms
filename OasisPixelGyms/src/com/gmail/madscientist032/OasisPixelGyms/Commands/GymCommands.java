package com.gmail.madscientist032.OasisPixelGyms.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import com.gmail.madscientist032.OasisPixelGyms.OasisPixelGyms;

public final class GymCommands {}

/*	private OasisPixelGyms plugin;
	
	public GymCommands(OasisPixelGyms plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{

		String gym;
		int gymNumber = 8; // Eight official gyms (not including Shadow Gym which is event-based 
		sender.sendMessage(ChatColor.GOLD + "[GYM LEADERS ONLINE]" );
		Player[] onlinePlayers = Bukkit.getServer()
				.getOnlinePlayers();
		for (Player oplayer : onlinePlayers) 
		{
			if ((oplayer != null)
					&& (oplayer.hasPermission("oasispixelgyms.gyms.leader")) || (oplayer.hasPermission("oasispixelgyms.gyms.coleader"))) 
			{

			switch (gymNumber) 
				{
				case 1: oplayer.hasPermission("oasispixelgyms.gyms.leader.grass");
				gym = oplayer.getName() + "Grass Gym, levels 10-20";
				sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
				break;
	
				case 2: oplayer.hasPermission("oasispixelgyms.gyms.leader.flying");
				gym = oplayer.getName() + "Flying Gym, levels 20-30";
				sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
				break;
	
				case 3: oplayer.hasPermission("oasispixelgyms.gyms.leader.bug");
				gym = oplayer.getName() + "Bug Gym, levels 30-40";
				sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
				break;
	
				case 4: oplayer.hasPermission("oasispixelgyms.gyms.leader.psychic");
				gym = oplayer.getName() + "Psychic Gym, levels 40-50";
				sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
				break;
	
				case 5: oplayer.hasPermission("oasispixelgyms.gyms.leader.water");
				gym = oplayer.getName() + "Water Gym, levels 50-60";
				sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
				break;
	
				case 6: oplayer.hasPermission("oasispixelgyms.gyms.leader.steel");
				gym = oplayer.getName() + "Steel Gym, levels 60-70";
				sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
				break;
	
				case 7: oplayer.hasPermission("oasispixelgyms.gyms.leader.dragon");
				gym = oplayer.getName() + "Dragon Gym, levels 70-80";
				sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
				break;
	
				case 8: oplayer.hasPermission("oasispixelgyms.gyms.leader.fire");
				gym = oplayer.getName() + "Fire Gym, levels 80-90";
				sender.sendMessage(ChatColor.GOLD + oplayer.getName() + "" + gym);
				break;
				} // end switch
			}	// end if
		}	//end for
		return true;
	}// end gymCommand
} // end of GymCommands
8?
/*
 * 
 * package net.charter.orion_pax.OasisChat.Commands;

import java.awt.List;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.charter.orion_pax.OasisChat.OasisChat;
import net.charter.orion_pax.OasisChat.Parties;
import net.charter.orion_pax.OasisChat.PartyPlayer;
import net.charter.orion_pax.OasisChat.Commands.SubCommands.*;

public class PartyCommand implements CommandExecutor {

	private OasisChat plugin;

	public PartyCommand(OasisChat plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage(plugin.partychatsub);
			return true;
		}

		Player player = (Player) sender;
		String name = player.getName();
		String password = "";
		String myparty = null;
		if (plugin.partyPlayer.get(name).myParty()!=null){
			myparty = plugin.partyPlayer.get(name).myParty();
		}

		if (args.length > 1) {
			if (args[0].equalsIgnoreCase("create")) {
				if (args.length == 3) {
					password = args[2];
				}
				if (myparty!=null) {
					if (plugin.MyParties.get(myparty).isOwner(name)) {
						plugin.MyParties.get(myparty).sendMessage(plugin.pcprefix + myparty + " is disbanded!");
						plugin.MyParties.get(myparty).removeMembers();
						plugin.partyPlayer.get(name).removeParty();

					} else if (plugin.partyPlayer.get(name).getMyParty() != null) {
						plugin.MyParties.get(myparty).sendMessage(plugin.pcprefix + name + " has left chat!");
						plugin.MyParties.get(myparty).removeMember(name);
					}
				}
				if (plugin.MyParties.containsKey(args[1])==false) {
					plugin.MyParties.put(args[1], new Parties(plugin, name, args[1], password, null));
					plugin.partyPlayer.get(name).changeParty(args[1]);
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix) + args[1] + " has been created!");
					plugin.saveParties();
					return true;
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + args[1] + " already exist!"));
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix)+ "Usage: /party create <partyname> <password> (password is optional)");
				return true;
			}
		}
		if (args[0].equalsIgnoreCase("quit")) {
			if (plugin.MyParties.get(myparty).isOwner(name)) {
				plugin.MyParties.get(myparty).sendMessage(plugin.pcprefix + myparty + " is disbanded!");
				plugin.MyParties.get(myparty).removeMembers();
				plugin.partyPlayer.get(name).removeParty();
				plugin.saveParties();

			} else if (plugin.partyPlayer.get(name).getMyParty()!=null) {
				plugin.MyParties.get(myparty).sendMessage(plugin.pcprefix + name+ " has left chat!");
				plugin.MyParties.get(myparty).removeMember(name);
				plugin.saveParties();
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix) + "You are not in a party!");
				return true;
			}
			return false;
		}
		if (args[0].equalsIgnoreCase("join")) {
			if (args.length > 1) {
				if (args.length == 3) {
					password = args[2];
				}
				Set<String> parties = plugin.partyconfig.getConfig().getConfigurationSection("partychats").getKeys(false);
				if (parties.contains(args[1])) {
					if (plugin.MyParties.get(args[1]).getPassword().equals(password)) {
						plugin.MyParties.get(args[1]).addMember(name);
						plugin.MyParties.get(args[1]).sendMessage(plugin.pcprefix + name + " has joined " + args[1] + "!");
						plugin.saveParties();
					} else {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix) + "Incorrect password!");
					}
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.pcprefix) + "The party " + args[1] + " does not exist!");
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix) + "Usage: /party join <partyname> <password> (password optional)");
				return true;
			}
			return false;
		}
		if (args[0].equalsIgnoreCase("kick")) {
			if (args.length > 1) {
				if (plugin.MyParties.get(myparty).isOwner(name)) {
					if (plugin.getServer().getPlayer(args[1]).hasPlayedBefore()) {
						Player target = plugin.getServer().getPlayer(args[1]);
						if (target == null) {
							OfflinePlayer otarget = plugin.getServer().getOfflinePlayer(args[1]);
							if (plugin.MyParties.get(myparty).getMembers().contains(otarget.getName())) {
								plugin.MyParties.get(myparty).sendMessage(plugin.pcprefix + otarget.getName() + " has been kicked from " + myparty + "!");
								plugin.MyParties.get(myparty).removeMember(otarget.getName());
								plugin.saveParties();
								return true;
							} else {
								sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + plugin.getServer().getOfflinePlayer(args[1]).getName() + " is not a member of your party!"));
								return true;
							}
						}
						if (plugin.MyParties.get(myparty).getMembers().contains(target.getName())) {
							plugin.MyParties.get(myparty).sendMessage(plugin.pcprefix + target.getName() + " has been kicked from " + myparty + "!");
							plugin.MyParties.get(myparty).removeMember(target.getName());
							plugin.saveParties();
							return true;
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix) + target.getName() + " is not a member of your party!");
							return true;
						}
					}
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + "You are not the owner of this party!"));
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix) + "Usage: /party kick <playername>");
				return true;
			}
			return false;
		}
		if (args[0].equalsIgnoreCase("invite")) {
			if (args.length > 1) {
				Player target = plugin.getServer().getPlayer(args[1]);
				if (target == null) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix) + args[1] + " is not online!");
					return true;
				}
				if (plugin.MyParties.get(myparty).getMembers().contains(target.getName())) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix) + target.getName() + " is allready a member of a party!");
					return true;
				}
				if (target.isOnline() && (plugin.MyParties.get(myparty).isOwner(name))) {
					plugin.partyPlayer.get(target.getName()).setInvite(myparty);
					timer(target);
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + target.getName() + " has been invited to " + myparty + "!"));
					target.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + sender.getName() + " has invited you to " + myparty + "!"));
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix) + "Usage: /party invite <playername>");
				return true;
			}
		}
		if (args[0].equalsIgnoreCase("accept")) {
			if (plugin.MyParties.get(myparty).getMembers().contains(name)) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + "You must leave your current party first!"));
				return true;
			} else if (plugin.MyParties.get(myparty).isOwner(name)) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + "You must leave your current party first!"));
				return true;
			} else if (!(plugin.partyPlayer.get(name).getInvite().equals(""))) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + "You have no invitations pending!"));
				return true;
			} else {
				plugin.MyParties.get(plugin.partyPlayer.get(name).getInvite()).addMember(name);
				plugin.MyParties.get(plugin.partyPlayer.get(name).getInvite()).sendMessage(plugin.pcprefix + name + " has joined " + plugin.partyPlayer.get(name).getInvite() + "!");
				plugin.partyPlayer.get(name).setInvite("");
				plugin.saveParties();
				return true;
			}
		}
		if (args[0].equalsIgnoreCase("give")) {
			if (args.length == 2) {
				Player target = plugin.getServer().getPlayer(args[1]);
				if (target == null) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix) + args[1] + " is not online!");
				} else if ((!(plugin.MyParties.get(target.getName()).isOwner(target.getName()))) || (!(plugin.MyParties.get(target.getName()).getMembers().contains(target.getName())))) {
					plugin.MyParties.get(myparty).changeOwner(target.getName());
					plugin.MyParties.get(myparty).sendMessage(plugin.pcprefix + "Ownership has been given to " + target.getName() + "!");
					plugin.saveParties();
					return true;
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + "They are already part of a party!"));
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + "Usage: /party give <playername>"));
				return true;
			}
		}
		if (args[0].equalsIgnoreCase("password")) {
			if (args.length == 2) {
				if (plugin.MyParties.get(myparty).isOwner(name)) {
					plugin.MyParties.get(myparty).changePassword(args[1]);
					plugin.saveParties();
					return true;
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix) + "You are not an owner of a party!");
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix) + "Usage: /party password <newpassword>");
			}
		}
		if (args[0].equalsIgnoreCase("list")) {
			if (plugin.MyParties.get(myparty).getMembers().contains(name)) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + "Owner: " + plugin.MyParties.get(myparty).getOwner()));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + "Members: " + plugin.MyParties.get(myparty).getMembers()));
				Iterator it = plugin.partyPlayer.entrySet().iterator();
				List mlist = null;
				while (it.hasNext()){
					Map.Entry entry = (Map.Entry)it.next();
					PartyPlayer partyplayer = (PartyPlayer) entry.getValue();
					if (partyplayer.getMyParty().equals(myparty)){
						mlist.add(partyplayer.getName());
					}
				}
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + "Online: " + mlist));
				return true;
			} else if (plugin.MyParties.get(myparty).isOwner(name)) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + "PartyChat: " + myparty));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + "Password: " + plugin.MyParties.get(myparty).getPassword()));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + "Members: " + plugin.MyParties.get(myparty).getMembers()));
				Iterator it = plugin.partyPlayer.entrySet().iterator();
				List mlist = null;
				while (it.hasNext()){
					Map.Entry entry = (Map.Entry)it.next();
					PartyPlayer partyplayer = (PartyPlayer) entry.getValue();
					if (partyplayer.getMyParty().equals(myparty)){
						mlist.add(partyplayer.getName());
					}
				}
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.pcprefix + "Online: " + mlist));
				return true;
			}
		}
		sender.sendMessage(plugin.partychatsub);
		return false;
	}

	public void timer(final Player player){
		plugin.getServer().getScheduler().runTaskLater(plugin, new Runnable()
		{
			public void run()
			{
				plugin.partyPlayer.get(player.getName()).setInvite("");
			}
		}
		, 6000);
	}
}
 */

/*
public class DisableMeCommand implements CommandExecutor{
	
	private OasisExtras plugin;
	
	public DisableMeCommand (OasisExtras plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			plugin.getServer().broadcastMessage(ChatColor.GOLD + sender.getName() + " is " + ChatColor.RED + "DISABLED!");
			return true;
		} else if (args.length == 1) {
			plugin.getServer().broadcastMessage(ChatColor.GOLD + args[0] + " is " + ChatColor.RED + "DISABLED!");
			return true;
		}
		return true;
	}
	*/ //here for reference
	


	
