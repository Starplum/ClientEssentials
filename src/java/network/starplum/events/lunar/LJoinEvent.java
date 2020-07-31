package network.starplum.events.lunar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import network.starplum.Essentials;
import network.starplum.events.utils.EventUtils;

public class LJoinEvent implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent a) {
		Player player = a.getPlayer();
		
		Bukkit.getScheduler().runTaskLater(Essentials.getCore(), () -> 
			EventUtils.isOnLunar(player), 40);
		
	}

}
