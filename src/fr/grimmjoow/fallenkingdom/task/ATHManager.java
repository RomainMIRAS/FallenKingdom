package fr.grimmjoow.fallenkingdom.task;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import fr.grimmjoow.fallenkingdom.GState;
import fr.grimmjoow.fallenkingdom.Main;
import fr.grimmjoow.fallenkingdom.teams.TeamFK;

public class ATHManager extends BukkitRunnable {
		
	private Main main;

	public ATHManager(Main main) {
		this.main = main;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		update_ATH();
		if (main.isState(GState.PLAYING)) {
			Main.minutes++;
			if (Main.minutes == 60) {
				Main.heures++;
				Main.minutes = 0;
			}
			if (Main.heures == 24) {
				Main.heures = 0;
				Main.jour++;
			}
		}

	}
	
	public static void update_ATH() {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		
		Objective objective = board.registerNewObjective("ATH", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		 
		//Setting the display name of the scoreboard/objective
		objective.setDisplayName("§6Jour " + Main.jour+" §a"+getHours());
		Score score = objective.getScore(ChatColor.GRAY + "-----------");
		score.setScore(14);
		
		score = objective.getScore("§cRouge §f"+TeamFK.getPlayersWithColor(Color.RED).size());
		score.setScore(13);
		
		score = objective.getScore("§9Bleu §f"+TeamFK.getPlayersWithColor(Color.BLUE).size());
		score.setScore(12);
		
		score = objective.getScore("§aVert §f"+TeamFK.getPlayersWithColor(Color.GREEN).size());
		score.setScore(11);


		score = objective.getScore("§eJaune §f"+TeamFK.getPlayersWithColor(Color.YELLOW).size());
		score.setScore(10);
		
		score = objective.getScore("§6Orange §f"+TeamFK.getPlayersWithColor(Color.ORANGE).size());
		score.setScore(9);
		
		
		score = objective.getScore(ChatColor.GRAY + "----------");
		score.setScore(1);
		
		score = objective.getScore("§eFallen Kingdom");
		score.setScore(0);
		
		for(Player online : Bukkit.getOnlinePlayers()){
			  online.setScoreboard(board);
			}
	}
	
	public static String getHours() {
		String minute_affiche = (Main.minutes < 10) ? "0" + Main.minutes :String.valueOf(Main.minutes);
		String heures_affiche = (Main.heures < 10) ? "0" + Main.heures :String.valueOf(Main.heures);
		return heures_affiche +':'+ minute_affiche;
	}

}
