package com.gmail.madscientist032.OasisPixelGyms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.*;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.madscientist032.OasisPixelGyms.Commands.*;

public class OasisPixelGyms extends JavaPlugin implements Listener {

	public ConsoleCommandSender console;
	public ConfigFile gymConfigFile;
	public Logger g;

	@Override
	public void onEnable() {
			new OasisPixelGymsEvents(this);
		createconfig();
		gymConfigFile = new ConfigFile(this,"gyms.yml");
	//	if(ImgUtility.CreateImageDir(this)){
		//	ChargerMap();
//		}

		getCommand("leaders").setExecutor(new LeadersCommand(this));
		
		g = Logger.getLogger("");
		getLogger().info("OasisPixelGyms has been enabled!");
	}

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
