package network.starplum.events.cheatbreaker;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.cheatbreaker.api.CheatBreakerAPI;

import network.starplum.Essentials;
import network.starplum.events.utils.ExternalClient;

public class CBStaffModules implements Listener {
	
	@EventHandler
	public void sendStaffModules(PlayerJoinEvent a) {
		
		Player player = a.getPlayer();
		
		if(CheatBreakerAPI.getInstance().isRunningCheatBreaker(player)) {
			ExternalClient.getCheatbreakerUsers().add(player);
			if(Essentials.getCore().getConfig().getBoolean("cheatbreaker.enabled")) {
				if(Essentials.getCore().getConfig().getBoolean("cheatbreaker.staff.enabled")) {
					if(player.hasPermission(Essentials.getCore().getConfig().getString("cheatbreaker.staff.staffpermission"))) {
						player.sendMessage(Essentials.getCore().getConfig().getString("cheatbreaker.staff.message".replace('&', '§').replaceAll("%player%", player.getName())));
						CheatBreakerAPI.getInstance().giveAllStaffModules(player);
					}
				}
			}
		}
	}

}
