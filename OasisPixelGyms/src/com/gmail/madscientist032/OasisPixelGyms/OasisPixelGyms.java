package com.gmail.madscientist032.OasisPixelGyms;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Filter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

//import net.charter.orion_pax.OasisExtras.MyConfigFile;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
//import org.bukkit.plugin.RegisteredServiceProvider;
//import org.bukkit.scheduler.BukkitRunnable;
//import org.bukkit.scheduler.BukkitTask;

import com.gmail.madscientist032.OasisPixelGyms.Commands.*;

public class OasisPixelGyms extends JavaPlugin{

	public ConsoleCommandSender console;
	public ConfigFile gymConfigFile;
//	public MyConfigFile maps;
//	public RemoteConsoleCommandSender rcon;
//	public List<Chunk> eList = new ArrayList<Chunk>();
//	public List<Item> aura = new ArrayList<Item>();
//	public int default_min, default_max, ndt, treecount=0,amount,joinignore;
//	public long bcasttimer;
//	public static Chat chat = null;
//	public OasisPlayer[] myplayers;
//	public boolean closed = false;
//	public LogHandler myloghandler = new LogHandler(this);
//	public Logger g;
//	private HashMap<String, ArrayList<ItemStack>> cache = new HashMap<String, ArrayList<ItemStack>>();
//	public OasisEntityPlayerManager OEPManager = new OasisEntityPlayerManager(this);
	//public SLAPI slapi;

/*	public String[] oasisextrassub = {
			ChatColor.GOLD + "Usage: /oasisextras subcommand subcommand"
			,ChatColor.GOLD + "SubCommands:"
			,ChatColor.GOLD + "RELOAD - Reloads config"
			,ChatColor.GOLD + "BCAST LIST/ADD/REMOVE"
			,ChatColor.GOLD + "Do /oasisextras [subcommand] for more info"
	};

	public String[] oasisextrassub2 = {
			ChatColor.GOLD + "Usage as follows...."
			,ChatColor.GOLD + "/oasisextras BCAST LIST - List auto bcast msgs"
			,ChatColor.GOLD + "/oasisextras BCAST ADD - Adds a msg to the auto bcast list"
			,ChatColor.GOLD + "/oasisextras BCAST REMOVE - Removes a msg from the auto bcast list"
	};
*/
	public void onEnable() {

		createconfig();
		gymConfigFile = new ConfigFile(this,"gyms.yml");
	//	if(ImgUtility.CreateImageDir(this)){
		//	ChargerMap();
//		}

		getCommand("leaders").setExecutor(new LeadersCommand(this));
/*		getCommand("disableme").setExecutor(new DisableMeCommand(this));
 * 		getCommand("setbadge").setExecutor(new SetBadgeCommand(this));
		getCommand("givebadge").setExecutor(new GiveCouponCommand(this));
		getCommand("friends").setExecutor(new FriendsCommand(this));
		getCommand("notify").setExecutor(new NotifyCommand(this));
*/
		
/*	
		task = new OasisExtrasTask(this);
		setup();
		console = Bukkit.getServer().getConsoleSender();
		loadPlayerConfigs();
*/
//		g = Logger.getLogger("");
//		removeGhostHandlers(g);
//		g.addHandler(myloghandler);
		getLogger().info("OasisPixelGyms has been enabled!");
	}
/*
	private static void removeGhostHandlers(final Logger l) {
		for (final Handler h : l.getHandlers()) {
			if (h.getClass().getName().equals(LogHandler.class.getName())) {
				l.removeHandler(h);
			}
		}
	}
*/
	@Override
	public void onDisable(){
	//	this.saveConfig();
		
		getLogger().info("OasisPixelGyms has been disabled!");
	}

/* save this for later! Could come in handy for gym badge things?
* 		public void loadPlayerConfigs(){
		myplayers = new OasisPlayer[this.getServer().getOfflinePlayers().length];
		int count = 0;
		for(OfflinePlayer offPlayer:this.getServer().getOfflinePlayers()){
			OasisPlayer oPlayer = new OasisPlayer(this,offPlayer.getName());
			this.oasisplayer.put(offPlayer.getName(), oPlayer);
			myplayers[count] = oPlayer;
			count++;
		}

	}
*/
	
	/*// save for later!!
	public void setup(){
		setupChat();
		joinmsg=getConfig().getString("join");
		quitmsg=getConfig().getString("quit");
		kickmsg=getConfig().getString("kick");
		if (getConfig().contains("votifier")) {
			amount = getConfig().getInt("votifier");
		}
		bcasttimer = getConfig().getInt("broadcasttimer",15*1200)*1200;
		default_min = getConfig().getInt("min_default_location",-2500);
		default_max = getConfig().getInt("max_default_location",2500);
		ndt = getConfig().getInt("default_invulnerability_ticks",300);
		task.bcasttask.runTaskTimer(this, Util.randomNum(0, 18000), bcasttimer);
		if (!appletreefile.getConfig().contains("appletrees")){
			appletreefile.getConfig().createSection("appletrees");
		}
		CoreProtect = getCoreProtect();
		loadTree();
		voteCheck();
	}
*/
	

	public void createconfig(){
		File file = new File(getDataFolder(), "config.yml");
		if(file.exists()){
			return;
		}
		if(!getDataFolder().exists()){
			if(!getDataFolder().mkdirs()){
				getLogger().severe("Datafolder could not be created!");
				getLogger().severe("Disabling");
				setEnabled(false);
				return;
			}
		}
		InputStream in = getResource("config.yml");
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
		} catch (IOException e) {
			getLogger().warning("Failed to copy the default config! (I/O)");
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				getLogger().warning("Failed to close the streams! (I/O -> Output)");
				e.printStackTrace();
			}
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				getLogger().warning("Failed to close the streams! (I/O -> Input)");
				e.printStackTrace();
			}
		}
	} 
}
