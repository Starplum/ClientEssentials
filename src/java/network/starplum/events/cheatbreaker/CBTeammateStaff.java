package network.starplum.events.cheatbreaker;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.cheatbreaker.api.CheatBreakerAPI;
import com.cheatbreaker.nethandler.server.CBPacketTeammates;

import network.starplum.Essentials;

public class CBTeammateStaff implements Listener {
	
	@EventHandler
	public void sendTeammates(PlayerJoinEvent a) {
		Player player = a.getPlayer();
		for(Player staff : Bukkit.getOnlinePlayers()) {
			if(staff.hasPermission(Essentials.getCore().getConfig().getString("cheatbreaker.staff.staffpermission"))) {
				final Map<UUID, Map<String, Double>> staffMembers = new HashMap<UUID, Map<String,Double>>();
				CheatBreakerAPI.getInstance().sendTeammates(player, new CBPacketTeammates(null, 1000L, staffMembers));
			}
		}
	}

}
