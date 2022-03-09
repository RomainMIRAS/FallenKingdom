package fr.grimmjoow.fallenkingdom.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.grimmjoow.fallenkingdom.GState;
import fr.grimmjoow.fallenkingdom.Main;

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
				main.setState(GState.STARTING);
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