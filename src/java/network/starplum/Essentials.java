package network.starplum;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import network.starplum.events.JoinTitle;
import network.starplum.events.cheatbreaker.CBDefaultWaypoints;
import network.starplum.events.cheatbreaker.CBStaffModules;
import network.starplum.events.cheatbreaker.CBStaffNametag;
import network.starplum.events.cheatbreaker.CBTeammateStaff;
import network.starplum.events.lunar.LJoinEvent;
import network.starplum.events.lunar.LStaffModules;
import network.starplum.events.lunar.LStaffNametag;
import network.starplum.events.lunar.LTeammateStaff;

public class Essentials extends JavaPlugin {
	
	private static Essentials core;
	
	public static Essentials getCore() {
		return core;
	}
	
	@Override
	public void onLoad() {
	}
	
	@Override
	public void onEnable() {
		core = this;
		PluginManager manager = Bukkit.getPluginManager();
		
		manager.registerEvents(new CBDefaultWaypoints(), this);
		manager.registerEvents(new CBStaffModules(), this);
		manager.registerEvents(new CBStaffNametag(), this);
		manager.registerEvents(new CBTeammateStaff(), this);
		
		manager.registerEvents(new LJoinEvent(), this);
		manager.registerEvents(new LStaffModules(), this);
		manager.registerEvents(new LStaffNametag(), this);
		manager.registerEvents(new LTeammateStaff(), this);
		
		manager.registerEvents(new JoinTitle(), this);
	}

}
