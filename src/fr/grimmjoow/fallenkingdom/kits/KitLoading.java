package fr.grimmjoow.fallenkingdom.kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitLoading {
		
	//////////////////////////////////////
	// GUERRIER
	//////////////////////////////////////
	
	
	public static ItemStack getItemGuerrier() {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add("§7Obtenez en début de partie :");
		lore.add("");
		
		ItemStack it = new ItemStack(Material.STONE_SWORD,1);
		ItemMeta meta = it.getItemMeta();
		meta.setDisplayName("§eGuerrier §65");
		meta.setLore(lore);
		
		it.setItemMeta(meta);
		return it;
	}
	
	public static void getKitGuerrier() {
		
	}

	//////////////////////////////////////
	// MINEUR
	//////////////////////////////////////
	
	
	public static ItemStack getItemMineur() {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add("§7Obtenez en début de partie :");
		lore.add("");
		lore.add("§7- Une pioche en pierre §defficacité I");
		lore.add("§7- Une pioche en fer §cusée §defficacité I");
		
		ItemStack it = new ItemStack(Material.STONE_PICKAXE,1);
		ItemMeta meta = it.getItemMeta();
		meta.setDisplayName("§eMineur §65");
		meta.setLore(lore);
		
		it.setItemMeta(meta);
		return it;
	}
	
	public static void getKitMineur() {
		
	}
	
	//////////////////////////////////////
	// FARMER
	//////////////////////////////////////
	
	
	public static ItemStack getItemFarmeur() {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add("§7Obtenez en début de partie :");
		lore.add("");
		lore.add("§7- 64 Bone Meals");
		lore.add("§7- Une épee en pierre §dlooting III");
		lore.add("§7  avec §dFire aspect I");

		
		ItemStack it = new ItemStack(Material.BONE,1);
		ItemMeta meta = it.getItemMeta();
		meta.setDisplayName("§eFarmeur §65");
		meta.setLore(lore);
		
		it.setItemMeta(meta);
		return it;
	}
	
	public static void getKitFarmeur() {
		
	}
	
	//////////////////////////////////////
	// ECLAIREUR
	//////////////////////////////////////
	
	
	public static ItemStack getItemEclaireur() {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add("§7Obtenez en début de partie :");
		lore.add("");
		lore.add("§7- Une pioche en fer §8(12 utilisations)");
		lore.add("§7- Une potion §8splash §5speed");
		lore.add("§7- Une potion §8splash §5speed §dII");
		lore.add("§7- Une potion speed");
		lore.add("§7- Une potion §8splash §5speed §dallongé");
		lore.add("§7- Une potion speed §dallongé");
		
		ItemStack it = new ItemStack(Material.FEATHER,1);
		ItemMeta meta = it.getItemMeta();
		meta.setDisplayName("§eEclaireur §65");
		meta.setLore(lore);
		
		it.setItemMeta(meta);
		return it;
	}
	
	public static void getKitEclaireur() {
		
	}
	
	
	//////////////////////////////////////
	// RANGER
	//////////////////////////////////////
	
	
	public static ItemStack getItemRanger() {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add("§7Obtenez en début de partie :");
		lore.add("");
		lore.add("§7- Un arc §dPunch I§5, Power II");
		lore.add("§7- 64 Flèches");
		lore.add("§7- Des bottes en fer §dPII");
		lore.add("  §dFeather Falling IV");

		
		ItemStack it = new ItemStack(Material.BOW,1);
		ItemMeta meta = it.getItemMeta();
		meta.setDisplayName("§eRanger §65");
		meta.setLore(lore);
		
		it.setItemMeta(meta);
		return it;
	}
	
	public static void getKitRanger() {
		
	}
	
	//////////////////////////////////////
	// Alchimiste
	//////////////////////////////////////
	
	
	public static ItemStack getItemAlchimiste() {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add("§7Obtenez en début de partie :");
		lore.add("");
		lore.add("§7- 1 Brewing stand");
		lore.add("§7- 12 Awkward Potion");
		lore.add("§7- 3 Yeux d'araignée");
		lore.add("§7- 5 Sucres");
		lore.add("§7- 3 Champignons");
		lore.add("§7- 3 Redstones");
		lore.add("§7- 3 Glowstones");
		lore.add("§7- 1 Pastèque Dorée");
		lore.add("§7- 1 Larme de Ghast");
		lore.add("§7- 1 Instant Damage II");
		
		ItemStack it = new ItemStack(Material.BREWING_STAND_ITEM,1);
		ItemMeta meta = it.getItemMeta();
		meta.setDisplayName("§eAlchimiste §65");
		meta.setLore(lore);
		
		it.setItemMeta(meta);
		return it;
	}
	
	public static void getKitAlchimiste() {
		
	}
	
	//////////////////////////////////////
	// Enchanteur
	//////////////////////////////////////
	
	
	public static ItemStack getItemEnchanteur() {
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add("§7Obtenez en début de partie :");
		lore.add("");
		lore.add("§7- 64 Bouteilles d'Exp");
		lore.add("§7- 32 Lapis Lazuli");
		lore.add("§7- Une enclume");
		lore.add("§7- 2 livres Sharpness I");
		lore.add("§7- 2 livres Protection II");
		lore.add("§7- Un livre Protection I");
		lore.add("§7- 2 livres Throns I");
		lore.add("§7- Une livre Knockback II");
		lore.add("§7- 2 livres Sharpness II");

		
		ItemStack it = new ItemStack(Material.EXP_BOTTLE,1);
		ItemMeta meta = it.getItemMeta();
		meta.setDisplayName("§eEnchanteur §65");
		meta.setLore(lore);
		
		it.setItemMeta(meta);
		return it;
	}
	
	public static void getKitEnchanteur() {
		
	}
	
}
