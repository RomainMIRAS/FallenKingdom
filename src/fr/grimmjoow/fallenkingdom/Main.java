package fr.grimmjoow.fallenkingdom;

import org.bukkit.plugin.java.JavaPlugin;

import fr.grimmjoow.fallenkingdom.commands.CommandGame;
import fr.grimmjoow.fallenkingdom.commands.CommandTest;
import fr.grimmjoow.fallenkingdom.kits.Kits;
import fr.grimmjoow.fallenkingdom.listener.LobbyListener;
import fr.grimmjoow.fallenkingdom.task.ATHManager;
import fr.grimmjoow.fallenkingdom.teams.TeamFK;
import fr.grimmjoow.fallenkingdom.utils.ColorUtils;

public class Main extends JavaPlugin {

	
	private GState state;
	private Kits kits = new Kits();
	private String enteteChat = "§8[§9FK§8]";
	
	// Variable de temps
	public static int minutes =0;
	public static int heures = 6;
	public static int jour = 0;
	

	@Override
	public void onEnable() {
		System.out.println("Le Plugin c'est bien allume");
		ColorUtils.InitColors();
		TeamFK.initTeams();
		setState(GState.WAITING);
		getCommand("test").setExecutor(new CommandTest());
		getCommand("game").setExecutor(new CommandGame(this));
		getServer().getPluginManager().registerEvents(new LobbyListener(this),this);	
		ATHManager ath = new ATHManager(this);
		// toutes les 0.5 secondes ( 20 = 1 s )
		ath.runTaskTimer(this, 0, 10);
	}

	@Override
	public void onDisable() {
		System.out.println("Le plugin c'est etaint ");
	}
	
	public Kits getKits() {
		return kits;
	}
	
	public void setState(GState state) {
		this.state = state;
	}
	
	public boolean isState(GState state) {
		return this.state == state;
	}
	
	public String getEnteteChat() {
		return enteteChat;
	}
	
}
