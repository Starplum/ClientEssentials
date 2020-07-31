package network.starplum.events.cheatbreaker;

import java.awt.Color;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.cheatbreaker.api.CheatBreakerAPI;
import com.cheatbreaker.api.object.CBWaypoint;

import network.starplum.Essentials;
import network.starplum.events.utils.ExternalClient;

public class CBDefaultWaypoints implements Listener {
	
	@EventHandler
	public void sendWaypoint(PlayerJoinEvent a) {
		Player player = a.getPlayer();
		Bukkit.getScheduler().runTaskLater(Essentials.getCore(), new Runnable() {
			
			@Override
			public void run() {
				if(ExternalClient.getCheatbreakerUsers().contains(player)) {
					CheatBreakerAPI.getInstance().sendWaypoint(player, new CBWaypoint(
							Essentials.getCore().getConfig().getString("cheatbreaker.waypoint.spawn.name".replace('&', '§')),
							Essentials.getCore().getConfig().getInt("cheatbreaker.waypoint.spawn.x"),
							Essentials.getCore().getConfig().getInt("cheatbreaker.waypoint.spawn.y"),
							Essentials.getCore().getConfig().getInt("cheatbreaker.waypoint.spawn.z"),
							Essentials.getCore().getConfig().getString("cheatbreaker.waypoint.spawn.world"),
							Color.green.getRGB(),
							true,
							true
							));
				}
				
			}
		}, 70);
	}

}
