package com.gmail.madscientist032.OasisPixelGyms.Permissions;

import java.util.Iterator;
import java.util.List;

import com.gmail.madscientist032.OasisPixelGyms.OasisPixelGyms;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

public class GymPermissions  {

	private OasisPixelGyms plugin;

	public GymPermissions(OasisPixelGyms plugin, CommandSender sender){
		this.plugin = plugin;
		
		List<Permission> permList = plugin.getDescription().getPermissions();
		Iterator permIt = permList.iterator();
		while(permIt.hasNext()){
			Permission perm = (Permission) permIt.next();
			sender.sendMessage(ChatColor.RED + perm.getName() + ChatColor.GOLD + " - " + ChatColor.GRAY + perm.getDescription());
		}
		return;
		
	}
}	 
/*	    
	    public boolean mayCreate() {
	        return hasPluginPermission("OasisPixelGyms.create");
	    }
	    
	    public boolean mayRedefine(ProtectedRegion region) {
	        return hasPatternPermission("redefine", region);
	    }
	    	    
	    public boolean mayDelete(ProtectedRegion region) {
	        return hasPatternPermission("remove", region);
	    }
	 	    	   	    
	    public boolean mayLookup(ProtectedRegion region) {
	        return hasPatternPermission("info", region);
	    }
	    
	    public boolean mayList() {
	        return hasPluginPermission("OasisPixelGyms.list");
	    }
	    
	    public boolean mayList(String targetPlayer) {
	        if (targetPlayer == null) {
	            return mayList();
	        }
	        
	        if (targetPlayer.equalsIgnoreCase(getSender().getName())) {
	            return hasPluginPermission("region.list.own");
	        } else {
	            return mayList();
	        }
	    }
	    
	    public boolean maySetFlag(ProtectedRegion region) {
	        return hasPatternPermission("flag.regions", region);
	    }
	    
	    public boolean maySetFlag(ProtectedRegion region, Flag<?> flag) {
	        // This is a WTF permission
	        return hasPatternPermission(
	                "flag.flags." + flag.getName().toLowerCase(), region);
	    }

	} 
	*/

