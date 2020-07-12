package network.starplum.events.cheatbreaker;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.cheatbreaker.api.CheatBreakerAPI;

import network.starplum.Essentials;

public class CBStaffNametag implements Listener {
	
	@EventHandler
	public void sendNametag(PlayerJoinEvent a) {
		Player player = a.getPlayer();
		
		for(Player players : Bukkit.getOnlinePlayers()) {
			if(players.hasPermission(Essentials.getCore().getConfig().getString("cheatbreaker.staff.staffpermission"))) {
				CheatBreakerAPI.getInstance().overrideNametag(players, Arrays.asList("§5§lSTAFF", "§7" + players.getName()), player);
			}
		}
		
	}

}
