package network.starplum.commands.lunar;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.mineaus.lunar.api.LunarClientAPI;
import net.mineaus.lunar.api.type.Notification;

public class LAnnouncement implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String A, String[] args) {
		
		if(A.length() != 0) {
			
			for(Player players : Bukkit.getOnlinePlayers()) {
				if(LunarClientAPI.INSTANCE().isAuthenticated(players)) {
					try {
						LunarClientAPI.INSTANCE().sendNotification(players, args.toString(), Notification.INFO, 15);
					} catch (IOException e) {}
				}
			}
			
		} else {
			sender.sendMessage("put some text idiot");
		}
		
		return true;
	}

}
