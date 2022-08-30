package fr.grimmjoow.fallenkingdom.task;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.grimmjoow.fallenkingdom.GState;
import fr.grimmjoow.fallenkingdom.Main;
import fr.grimmjoow.fallenkingdom.teams.TeamFK;

public class Game_Starting extends BukkitRunnable {
	
	private int timer = 10;

	private Main main;
	public Game_Starting(Main main) {
		this.main = main;
		main.setState(GState.STARTING);
	}

	@Override
	public void run() {
		
		if (timer == 0) {
			launch();
			this.cancel();
		}
		
		
		
		Bukkit.broadcastMessage("§6La partie commence dans §e" + timer + "§6 seconde(s).");
		timer--;
	}
	
	private void launch() {
		main.setState(GState.PLAYING);
		Main.monde.setDifficulty(Difficulty.NORMAL);
		Main.jour = 1;
		for(Player player : Bukkit.getOnlinePlayers()) {
			// A changer
			//player.playSound(null, null, timer, timer);
			player.getInventory().clear();
			main.getKits().playerSetKit(player);
		}
		TeamFK.teleportPlayers();
	}

}
