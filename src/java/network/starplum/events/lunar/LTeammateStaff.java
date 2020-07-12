package network.starplum.events.lunar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import net.mineaus.lunar.api.LunarClientAPI;
import net.mineaus.lunar.api.event.impl.AuthenticateEvent;
import network.starplum.Essentials;

public class LTeammateStaff implements Listener {
	
	private static List<Player> staffMembers = new ArrayList<Player>();
	
	public static List<Player> getStaffMembers() {
		return staffMembers;
	}
	
	@EventHandler
	public void registerStaff(AuthenticateEvent a) {
		Player player = a.getPlayer();
		if(player.hasPermission(Essentials.getCore().getConfig().getString("lunar.staff.staffpermission"))) {
			staffMembers.add(player);
		}
	}
	
	@EventHandler
	public void registerTeammates(AuthenticateEvent a) {
		Player player = a.getPlayer();
		
		for(Player players : Bukkit.getOnlinePlayers()) {
			if(players.hasPermission(Essentials.getCore().getConfig().getString("lunar.staff.staffpermission"))) {
				try {
					LunarClientAPI.INSTANCE().sendTeamMate(player, players);
				} catch (IOException e) {}
			}
		}
	}

}
