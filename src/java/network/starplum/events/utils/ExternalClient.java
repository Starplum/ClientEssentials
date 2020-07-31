package network.starplum.events.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class ExternalClient {
	
	private static List<Player> lunarClientUsers = new ArrayList<Player>();
	private static List<Player> cheatbreakerUsers = new ArrayList<Player>();
	
	public static List<Player> getCheatbreakerUsers() {
		return cheatbreakerUsers;
	}
	
	public static List<Player> getLunarClientUsers() {
		return lunarClientUsers;
	}
	
	public static void clearLists() {
		lunarClientUsers.clear();
		cheatbreakerUsers.clear();
	}
	
	public static void clearLunar() {
		lunarClientUsers.clear();
	}
	
	public static void clearCheatbreaker() {
		cheatbreakerUsers.clear();
	}

}
