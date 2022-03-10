package fr.grimmjoow.fallenkingdom.listener;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.grimmjoow.fallenkingdom.GState;
import fr.grimmjoow.fallenkingdom.Main;
import fr.grimmjoow.fallenkingdom.teams.TeamFK;
import fr.grimmjoow.fallenkingdom.utils.ColorUtils;

public class LobbyListener implements Listener {

	private Main main;

	// Mettre bonne co
	// private Zone lobby = new Zone(new Position(171,73,152),new
	// Position(177,69,146));

	private Location spawn = new Location(Bukkit.getWorld("FK"), 74.5, 59, 69.5, -60f, -5f);

	public LobbyListener(Main main) {
		this.main = main;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////                      GESTION UTILISATEUR 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {

		Player player = event.getPlayer();

		player.teleport(spawn);
		player.setFoodLevel(20);
		player.setHealth(20);
		player.setGameMode(GameMode.ADVENTURE);
		// Si le jeu à commancer
		if (!main.isState(GState.WAITING)) {
			player.setGameMode(GameMode.SPECTATOR);
			player.sendMessage("§eLa partie a déjà commencé");
			return;
		}
		player.getInventory().clear();
		player.getInventory().setItem(1, getItem(Material.BANNER, "Teams", (byte) 15));
		player.getInventory().setItem(0, getItem(Material.NAME_TAG, "§eChoix du Kits"));

		if (player.isOp()) {
			event.setJoinMessage(main.getEnteteChat() + " §4" + player.getDisplayName() + " §7 a rejoint la partie "
					+ "§a(" + player.getWorld().getPlayers().size() + 1 + "/" + Bukkit.getMaxPlayers() + ")");
		} else {
			event.setJoinMessage(main.getEnteteChat() + " §f" + player.getDisplayName() + " §7 a rejoint la partie "
					+ "§a(" + player.getWorld().getPlayers().size() + 1 + "/" + Bukkit.getMaxPlayers() + ")");
		}

	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		if (!main.isState(GState.PLAYING)) {
			if (!event.getPlayer().isOp())
				event.setCancelled(true);

		}

	}

	@EventHandler
	public void onDamaged(EntityDamageEvent event) {
		if (!main.isState(GState.PLAYING)) {
			if (event.getEntityType() == EntityType.PLAYER)
				event.setCancelled(true);
		}
	}

	@EventHandler
	public void onZone(PlayerMoveEvent event) {
		//Player player = event.getPlayer();
		if (main.isState(GState.WAITING)) {
//			if (!lobby.isOn(player)){
//				player.teleport(spawn);
//			}
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//// GESTION GUI
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {

		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();
		if (it == null)
			return;

		if (it.getType() == Material.BANNER) {
			if (it.getItemMeta().getDisplayName().equalsIgnoreCase("Teams")) {

				if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
					event.setCancelled(true);
					openTeamMenu(player);
				}
			}
		} else if (it.getType() == Material.NAME_TAG) {
			if (it.getItemMeta().getDisplayName().equalsIgnoreCase("§eChoix du Kits")) {

				if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
					event.setCancelled(true);
					main.getKits().openInterfaceKits(player);
				}
			}
		}
	}

	public void openTeamMenu(Player player) {
		Inventory inv = Bukkit.createInventory(null, 9, "§8Choisir une équipe");
		inv.setItem(1, getItem(Material.BANNER, "§cEquipe Rouge", (byte) 1));
		inv.setItem(3, getItem(Material.BANNER, "§cEquipe Bleu", (byte) 4));
		inv.setItem(5, getItem(Material.BANNER, "§cEquipe Vert", (byte) 10));
		player.openInventory(inv);
	}

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();

		if (item == null)
			return;

		// Si sur le menu team selector
		if (inv.getName().equalsIgnoreCase("§8Choisir une équipe")) {

			// Gestion Erreur
			if (item.getItemMeta() == null)
				return;

			// cancel le ramassage
			event.setCancelled(true);
			player.closeInventory();

			// Check Click Banner
			switch (item.getItemMeta().getDisplayName()) {
			case "§cEquipe Rouge":
				
				TeamFK.switchTeamToPlayer(player, Color.RED);
				
				break;
			case "§cEquipe Bleu":
				
				TeamFK.switchTeamToPlayer(player, Color.BLUE);;
				break;
			case "§cEquipe Vert":
				
				TeamFK.switchTeamToPlayer(player, Color.GREEN);
				break;
			default:
				break;
			}
			player.sendMessage("Vous avez rejoint l'équipe " + ColorUtils.colorToString(TeamFK.getTeamWithPlayer(player).getColor()));
			
		}
	}

	// Créer un item facilement
	public ItemStack getItem(Material mat, String custonName) {
		ItemStack it = new ItemStack(mat, 1);
		ItemMeta itM = it.getItemMeta();

		if (custonName != null)
			itM.setDisplayName(custonName);
		it.setItemMeta(itM);

		return it;

	}

	// Créer un item facilement avec byte
	public ItemStack getItem(Material mat, String custonName, byte customByte) {
		ItemStack it = new ItemStack(mat, 1, customByte);
		ItemMeta itM = it.getItemMeta();

		if (custonName != null)
			itM.setDisplayName(custonName);
		it.setItemMeta(itM);

		return it;

	}

}
