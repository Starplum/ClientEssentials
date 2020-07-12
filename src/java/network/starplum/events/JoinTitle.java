package network.starplum.events;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.cheatbreaker.api.CheatBreakerAPI;
import com.cheatbreaker.api.object.CBNotification;
import com.cheatbreaker.api.object.CBNotification.Level;

import net.mineaus.lunar.api.LunarClientAPI;
import net.mineaus.lunar.api.type.Notification;
import network.starplum.Essentials;
import network.starplum.events.utils.EventUtils;

public class JoinTitle implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent a) {
		
		Player player = a.getPlayer();
		
		Bukkit.getScheduler().runTaskLater(Essentials.getCore(), new Runnable() {
			
			@Override
			public void run() {
				
				if(EventUtils.isNew(player)) {
					
					if(LunarClientAPI.INSTANCE().isAuthenticated(player)) {
						try {
							LunarClientAPI.INSTANCE().sendNotification(player, "Welcome to " + Essentials.getCore().getConfig().getString("server.rawname"), Notification.INFO, 5);
						} catch(IOException z) {}
					} else if(CheatBreakerAPI.getInstance().isRunningCheatBreaker(player)) {
						CheatBreakerAPI.getInstance().sendNotification(player, new CBNotification("Welcome to " + Essentials.getCore().getConfig().getString("server.rawname"), 5, TimeUnit.SECONDS));
					} else {
						player.sendTitle(Essentials.getCore().getConfig().getString("title.title.newuser".replace('&', '§')), Essentials.getCore().getConfig().getString("title.subtitle.newuser".replace('&', '§')));
					}
					
				} else {
					
					if(LunarClientAPI.INSTANCE().isAuthenticated(player)) {
						try {
							LunarClientAPI.INSTANCE().sendNotification(player, "Welcome back to " + Essentials.getCore().getConfig().getString("server.rawname"), Notification.INFO, 5);
						} catch(IOException z) {} 
						
					} else if(CheatBreakerAPI.getInstance().isRunningCheatBreaker(player)) {
						CheatBreakerAPI.getInstance().sendNotification(player, new CBNotification("Welcome back to " + Essentials.getCore().getConfig().getString("server.rawname"), 5, TimeUnit.SECONDS, Level.INFO));
					} else {
						if(Essentials.getCore().getConfig().getBoolean("title.enabled")) {
							player.sendTitle(Essentials.getCore().getConfig().getString("title.title.existinguser".replace('&', '§')), Essentials.getCore().getConfig().getString("title.subtitle.existinguser".replace('&', '§')));
						} else {}
						
					}
					
				}
				
			}
		}, 20);
		
	}
	
	

}
