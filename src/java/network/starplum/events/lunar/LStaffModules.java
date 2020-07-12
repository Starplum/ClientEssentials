package network.starplum.events.lunar;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.mineaus.lunar.api.LunarClientAPI;
import net.mineaus.lunar.api.type.StaffModule;
import network.starplum.Essentials;
import network.starplum.events.utils.ExternalClient;

public class LStaffModules implements Listener {
	
	@EventHandler
	public void giveStaffModules(PlayerJoinEvent a) {
		Player player = a.getPlayer();
		Bukkit.getScheduler().runTaskLater(Essentials.getCore(), new Runnable() {
			
			@Override
			public void run() {
				if(Essentials.getCore().getConfig().getBoolean("lunar.enabled")) {
					if(player.hasPermission(Essentials.getCore().getConfig().getString("lunar.staff.staffpermission"))) {
						if(ExternalClient.getLunarClientUsers().contains(player)) {
							player.sendMessage(Essentials.getCore().getConfig().getString("lunar.staff.message".replace('&', '§')));
							try {
								for(StaffModule modules : StaffModule.values()) {
									LunarClientAPI.INSTANCE().toggleStaffModule(player, modules, true);
								}
							} catch(IOException z) {}
						}
					}
				}
			}
		}, 60);
	}

}
