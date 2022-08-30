package fr.grimmjoow.fallenkingdom.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import fr.grimmjoow.fallenkingdom.GState;
import fr.grimmjoow.fallenkingdom.Main;
import fr.grimmjoow.fallenkingdom.Zone;
import fr.grimmjoow.fallenkingdom.teams.TeamFK;

public class GameListener implements Listener {

	Main main;
	public GameListener(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		if (main.isState(GState.PLAYING)) {
			for (Zone zone : TeamFK.getTeamWithPlayer(event.getPlayer()).getZones()) {
				if (!zone.isOn(event.getBlock())){
					event.setCancelled(true);
					event.getPlayer().sendMessage("Tu peux pas");
				}
			}
		}
	}
}
