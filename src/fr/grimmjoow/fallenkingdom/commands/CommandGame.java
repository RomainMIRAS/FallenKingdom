package fr.grimmjoow.fallenkingdom.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.grimmjoow.fallenkingdom.GState;
import fr.grimmjoow.fallenkingdom.Main;
import fr.grimmjoow.fallenkingdom.task.Game_Starting;

public class CommandGame implements CommandExecutor {

	private Main main;
	public CommandGame(Main main) {
		this.main = main;
	}

	// Commande depuis console
	//Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "Command");

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (args.length == 1) {
			switch (args[0]) {
			case "start":
				Game_Starting start = new Game_Starting(main);
				start.runTaskTimer(main, 0, 20);
				break;				
			case "pause":
				main.setState(GState.PAUSE);
				break;
			case "reset":
				main.setState(GState.WAITING);
				break;
			case "help":
				helpMessage(sender); 
				break;
			case "kit":
				main.getKits().playerSetKit((Player) sender);; 
				break;
			default:
				helpMessage(sender);
				break;
			}
		}
				
		return false;
	}
	
	
	public void helpMessage(CommandSender sender) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			player.sendMessage("Jews");
		}
	}

}
