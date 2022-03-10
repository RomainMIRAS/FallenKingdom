package fr.grimmjoow.fallenkingdom.kits;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Kits {
			
	private HashMap<Player,ListKits> kitJoueur;
	
	public Kits() {
		
		this.kitJoueur = new HashMap<Player,ListKits>();
	}
	
	public HashMap<Player, ListKits> getKitJoueur() {
		return kitJoueur;
	}
	
	public void addKitToJoueur(ListKits kit, Player joueur){
		kitJoueur.put(joueur,kit);
		joueur.sendMessage("§6Votre kit : §e" + getKitNameFromPlayer(joueur));
	}
	
	public boolean hasKit(Player joueur) {
		return 	kitJoueur.containsKey(joueur);
	}
	
	// Precondition : Player 
	private String getKitNameFromPlayer(Player player) {
		String name;
		if (!hasKit(player)) {
			name = "Aucun";
		} else {
			switch (kitJoueur.get(player)) {
			case GUERRIER:
				name =  "Guerrier";
				break;
			case MINEUR:
				name =  "Mineur";
				break;
			case FARMER:
				name =  "Farmer";
				break;
			case ECLAIREUR:
				name =  "Eclaireur";
				break;
			case RANGER:
				name =  "Ranger";
				break;
			case ALCHIMISTE:
				name =  "Alchimiste";
				break;
			case ENCHANTEUR:
				name =  "Enchanteur";
				break;
			default:
				name = "Aucun";
				break;
			}
		}
		return name;
		
	}
	
	public void openInterfaceKits(Player player) {
    	Inventory inv = Bukkit.createInventory(null, 9,"§7Sélection : §e" + getKitNameFromPlayer(player));
    	inv.addItem(KitLoading.getItemGuerrier());
    	inv.addItem(KitLoading.getItemMineur());
    	inv.addItem(KitLoading.getItemFarmeur());
    	inv.addItem(KitLoading.getItemEclaireur());
    	inv.addItem(KitLoading.getItemRanger());
    	inv.addItem(KitLoading.getItemAlchimiste());
    	inv.addItem(KitLoading.getItemEnchanteur());
    	player.openInventory(inv);
	}
}
