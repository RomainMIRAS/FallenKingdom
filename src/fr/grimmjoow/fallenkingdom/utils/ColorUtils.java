package fr.grimmjoow.fallenkingdom.utils;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Color;

public class ColorUtils {
	private static HashMap<Color,String> COLORS = new HashMap<>();
	private static HashMap<Color,ChatColor> CHAT_COLORS = new HashMap<>(); 
	
	public static void InitColors() {
		initColorsToString();
		initColorsToChatcolors();
	}
	
	
	private static void initColorsToString() {
		COLORS.put(Color.BLUE, "Bleu");
		COLORS.put(Color.RED, "Rouge");
		COLORS.put(Color.ORANGE, "Orange");
		COLORS.put(Color.GREEN, "Vert");
		COLORS.put(Color.YELLOW, "Jaune");
	}
	
	public static String colorToString(Color color) {
		return COLORS.get(color);
	}
	
	
	
	
	private static void initColorsToChatcolors() {
		CHAT_COLORS.put(Color.BLUE, ChatColor.BLUE);
		CHAT_COLORS.put(Color.RED, ChatColor.RED);
		CHAT_COLORS.put(Color.ORANGE, ChatColor.GOLD);
		CHAT_COLORS.put(Color.GREEN, ChatColor.GREEN);
		CHAT_COLORS.put(Color.YELLOW, ChatColor.YELLOW);
	}
	
	public static ChatColor colorToChatColor(Color color) {
		return CHAT_COLORS.get(color);
	}
	
}
