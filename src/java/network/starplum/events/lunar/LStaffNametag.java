package network.starplum.events.lunar;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import net.mineaus.lunar.api.LunarClientAPI;
import net.mineaus.lunar.api.event.impl.AuthenticateEvent;
import network.starplum.Essentials;

public class LStaffNametag implements Listener {
	
	@EventHandler
	public void setStafftag(AuthenticateEvent a) {
		
		Player player = a.getPlayer();
		
		for(Player staff : Bukkit.getOnlinePlayers()) {
			if(staff.hasPermission(Essentials.getCore().getConfig().getString("lunar.staff.staffpermission"))) {
				try {
					LunarClientAPI.INSTANCE().updateNameTag(player, staff, "§5§lSTAFF", "§7" + staff.getName());
				} catch (IOException e) {}
			}
		}
		
	}

}
