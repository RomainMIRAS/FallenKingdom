package fr.grimmjoow.fallenkingdom;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Kits {

	public static final int GUERRIER = 9;
	public static final int MINEUR = 10;
	public static final int FARMER = 11;
	public static final int ECLAIREUR = 12;
	public static final int RANGER = 13;
	public static final int ALCHIMISTE = 14;
	public static final int ENCHANTEUR = 15;
			
	private HashMap<Player,Integer> kitJoueur;
	
	public Kits() {
		
		this.kitJoueur = new HashMap<Player,Integer>();
	}
	
	public HashMap<Player, Integer> getKitJoueur() {
		return kitJoueur;
	}
	
	public void addKitToJoueur(int kit, Player joueur){
		kitJoueur.put(joueur,kit);
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
    	
    	player.openInventory(inv);
		
	}
}
