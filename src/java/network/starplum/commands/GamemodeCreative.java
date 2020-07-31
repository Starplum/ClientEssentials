package network.starplum.commands;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cheatbreaker.api.CheatBreakerAPI;
import com.cheatbreaker.api.object.CBNotification;

import net.mineaus.lunar.api.LunarClientAPI;
import net.mineaus.lunar.api.type.Notification;
import network.starplum.Essentials;

public class GamemodeCreative implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String A, String[] args) {
		
		Player player = (Player) sender;
		
		if(!(sender instanceof Player)) {
			return true;
		} else {
			if(player.hasPermission(Essentials.getCore().getConfig().getString("permission.root" + ".gamemode.creative")) || player.hasPermission(Essentials.getCore().getConfig().getString("permission.root" + "*"))) {
				player.setGameMode(GameMode.CREATIVE);
				if(LunarClientAPI.INSTANCE().isAuthenticated(player)) {
					try {
						LunarClientAPI.INSTANCE().sendNotification(player, "Gamemode Updated to Creative", Notification.INFO, 5);
					} catch(IOException z) {}
				} else if(CheatBreakerAPI.getInstance().isRunningCheatBreaker(player)) {
					CheatBreakerAPI.getInstance().sendNotification(player, new CBNotification("Gamemode Updated to Creative", 5L, TimeUnit.SECONDS));
				} else {
					player.sendMessage(Essentials.getCore().getConfig().getString("server.prefix") + " §fGamemode updated to §7§oCreative");
				}
			}
		}
		
		return false;
	}

}
