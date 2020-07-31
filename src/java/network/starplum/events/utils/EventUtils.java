package network.starplum.events.utils;

import org.bukkit.entity.Player;

import net.mineaus.lunar.api.LunarClientAPI;

public class EventUtils {
	
	public static boolean isNew(Player player) {
		
		if(player.hasPlayedBefore()) {
			return false;
		} else {
			return true;
		}
		
	}
	
	public static boolean isOnLunar(Player player) {
		if(LunarClientAPI.INSTANCE().isAuthenticated(player)) {
			ExternalClient.getLunarClientUsers().add(player);
			return true;
		} else return false;
	}

}
