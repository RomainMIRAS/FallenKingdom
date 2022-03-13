package fr.grimmjoow.fallenkingdom.kits;

import java.util.ArrayList;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
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
	
	public static void getKitGuerrier(Player player) {
		
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
	
	public static void getKitMineur(Player player) {
		Inventory inv = player.getInventory();
		// ARC 1
		ItemStack it = new ItemStack(Material.STONE_PICKAXE,1);
		ItemMeta meta = it.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 1, false);
		it.setItemMeta(meta);
		inv.addItem(it);
		
		// BOTTES EN FER
		it = new ItemStack(Material.IRON_PICKAXE,1);
		it.setDurability((short) 80);
		meta = it.getItemMeta();
		meta.addEnchant(Enchantment.DIG_SPEED, 1, false);
		it.setItemMeta(meta);
		inv.addItem(it);
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
	
	public static void getKitFarmeur(Player player) {
		Inventory inv = player.getInventory();
		inv.addItem(new ItemStack(Material.BONE,64));
		
		ItemStack it = new ItemStack(Material.STONE_SWORD,1);
		ItemMeta meta = it.getItemMeta();
		meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, false);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 1, false);
		it.setItemMeta(meta);
		inv.addItem(it);
		
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
	
	public static void getKitEclaireur(Player player) {
		Inventory inv = player.getInventory();
		
		// ARC 1
		ItemStack it = new ItemStack(Material.IRON_PICKAXE,1);
		it.setDurability((short) 12);
		inv.addItem(it);
		
		// Fléches
		inv.addItem(new ItemStack(Material.POTION,1,(byte)16386));
		
		inv.addItem(new ItemStack(Material.POTION,1,(byte)16418));

		inv.addItem(new ItemStack(Material.POTION,1,(byte)8194));

		inv.addItem(new ItemStack(Material.POTION,1,(byte)16450));

		inv.addItem(new ItemStack(Material.POTION,1,(byte)8258));

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
	
	public static void getKitRanger(Player player) {
		Inventory inv = player.getInventory();
		
		// ARC 1
		ItemStack it = new ItemStack(Material.BOW,1);
		ItemMeta meta = it.getItemMeta();
		meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, false);
		meta.addEnchant(Enchantment.ARROW_DAMAGE, 2, false);
		it.setItemMeta(meta);
		inv.addItem(it);
		
		// Fléches
		inv.addItem(new ItemStack(Material.ARROW,64));
		
		// BOTTES EN FER
		it = new ItemStack(Material.IRON_BOOTS,1);
		meta = it.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2,false);
		meta.addEnchant(Enchantment.PROTECTION_FALL, 4,false);
		it.setItemMeta(meta);
		inv.addItem(it);
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
	
	public static void getKitAlchimiste(Player player) {
		Inventory inv = player.getInventory();
		inv.addItem(new ItemStack(Material.BREWING_STAND_ITEM,1));
		inv.addItem(new ItemStack(Material.POTION,12,(byte)16));
		inv.addItem(new ItemStack(Material.SPIDER_EYE,3));
		inv.addItem(new ItemStack(Material.SUGAR,5));
		inv.addItem(new ItemStack(Material.BROWN_MUSHROOM,3));
		inv.addItem(new ItemStack(Material.REDSTONE,3));
		inv.addItem(new ItemStack(Material.GLOWSTONE_DUST,3));
		inv.addItem(new ItemStack(Material.SPECKLED_MELON,1));
		inv.addItem(new ItemStack(Material.GHAST_TEAR,1));
		inv.addItem(new ItemStack(Material.POTION,1,(byte)16428));
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
	
	public static void getKitEnchanteur(Player player) {
		Inventory inv = player.getInventory();

		inv.addItem(new ItemStack(Material.EXP_BOTTLE,64));
		inv.addItem(new ItemStack(Material.LAPIS_BLOCK,32));
		inv.addItem(new ItemStack(Material.ANVIL,1));
		
		// SHARP 1
		ItemStack it = new ItemStack(Material.ENCHANTED_BOOK,2);
		ItemMeta meta = it.getItemMeta();
		meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
		it.setItemMeta(meta);
		inv.addItem(it);
		
		// P2
		it = new ItemStack(Material.ENCHANTED_BOOK,2);
		meta = it.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2,false);
		it.setItemMeta(meta);
		inv.addItem(it);
		
		// P1
		it = new ItemStack(Material.ENCHANTED_BOOK,1);
		meta = it.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1,false);
		it.setItemMeta(meta);
		inv.addItem(it);
		
		// Thorns
		it = new ItemStack(Material.ENCHANTED_BOOK,2);
		meta = it.getItemMeta();
		meta.addEnchant(Enchantment.THORNS, 1,false);
		it.setItemMeta(meta);
		inv.addItem(it);
		
		// knockback
		it = new ItemStack(Material.ENCHANTED_BOOK,1);
		meta = it.getItemMeta();
		meta.addEnchant(Enchantment.KNOCKBACK, 2,false);
		it.setItemMeta(meta);
		inv.addItem(it);
		
		// Shap 2
		it = new ItemStack(Material.ENCHANTED_BOOK,2);
		meta = it.getItemMeta();
		meta.addEnchant(Enchantment.DAMAGE_ALL, 2,false);
		it.setItemMeta(meta);
		inv.addItem(it);
	}
	
}
