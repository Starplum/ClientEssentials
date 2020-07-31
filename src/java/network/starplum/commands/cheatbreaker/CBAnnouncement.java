package network.starplum.commands.cheatbreaker;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cheatbreaker.api.CheatBreakerAPI;
import com.cheatbreaker.api.object.CBNotification;
import com.cheatbreaker.api.object.CBNotification.Level;

public class CBAnnouncement implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String A, String[] args) {
		
		if(A.length() != 0) {
			for(Player players : Bukkit.getOnlinePlayers()) {
				if(CheatBreakerAPI.getInstance().isRunningCheatBreaker(players)) {
					CheatBreakerAPI.getInstance().sendNotification(players, new CBNotification(args.toString().replace('&', '§'), 10L, TimeUnit.SECONDS, Level.INFO));
				}
			}
		} else {
			sender.sendMessage("put some text u idiot");
		}
		
		return true;
	}
	
	

}
