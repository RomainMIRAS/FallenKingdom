package fr.grimmjoow.fallenkingdom;

import org.bukkit.plugin.java.JavaPlugin;

import fr.grimmjoow.fallenkingdom.commands.CommandGame;
import fr.grimmjoow.fallenkingdom.commands.CommandTest;
import fr.grimmjoow.fallenkingdom.listener.LobbyListener;

public class Main extends JavaPlugin {

	
	private GState state;
	private Kits kits = new Kits();

	@Override
	public void onEnable() {
		System.out.println("Le Plugin c'est bien allume");
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
	
	
}