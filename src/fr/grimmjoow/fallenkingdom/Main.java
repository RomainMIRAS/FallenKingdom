package fr.grimmjoow.fallenkingdom;

import org.bukkit.plugin.java.JavaPlugin;

import fr.grimmjoow.fallenkingdom.commands.CommandGame;
import fr.grimmjoow.fallenkingdom.commands.CommandTest;
import fr.grimmjoow.fallenkingdom.kits.Kits;
import fr.grimmjoow.fallenkingdom.listener.LobbyListener;
import fr.grimmjoow.fallenkingdom.teams.TeamFK;
import fr.grimmjoow.fallenkingdom.utils.ColorUtils;

public class Main extends JavaPlugin {

	
	private GState state;
	private Kits kits = new Kits();
	private String enteteChat = "§8[§9FK§8]";

	@Override
	public void onEnable() {
		System.out.println("Le Plugin c'est bien allume");
		ColorUtils.InitColors();
		TeamFK.initTeams();
		setState(GState.WAITING);
		getCommand("test").setExecutor(new CommandTest());
		getCommand("game").setExecutor(new CommandGame(this));
		getServer().getPluginManager().registerEvents(new LobbyListener(this),this);		
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
