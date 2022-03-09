package fr.grimmjoow.fallenkingdom.teams;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Color;
import org.bukkit.entity.Player;

public class TeamFK {
	private static HashMap<Color,TeamFK> TEAMS = new HashMap<>();
	
	private HashSet<Player> players = new HashSet<>();
	private int health;
	private Color color;
	private boolean alive;

	
	private final static int VIE = 1000;
	
	TeamFK(Color color) {
		this.color = color;
		this.health = VIE;
		this.alive = true;		
	}
	
	public static void initTeams() {
		TEAMS.put(Color.RED, new TeamFK(Color.RED));
		TEAMS.put(Color.BLUE, new TeamFK(Color.BLUE));
		TEAMS.put(Color.GREEN, new TeamFK(Color.GREEN));
		TEAMS.put(Color.YELLOW, new TeamFK(Color.YELLOW));
		TEAMS.put(Color.ORANGE, new TeamFK(Color.ORANGE));
	}
	
	
	//Methodes de classes
	public static HashMap<Color, TeamFK> getTeams() {
		return TEAMS;
	}
	
	public static TeamFK getTeamWithColor(Color color) {
		return TEAMS.get(color);
	}
	
	public static HashSet<Player> getPlayersWithColor(Color color) {
		return TEAMS.get(color).getPlayers();
	}
	public static boolean playerHasTeam(Player player) {
		for(TeamFK team : TEAMS.values()) {
			if(team.players.contains(player)) {
				return true;
			}
		}
		return false;
	}
	public static TeamFK getTeamWithPlayer(Player player) {
		//{Le joueur doit avoir une équipe} => {Renvoie l'équipe du joueur}
		for(TeamFK team : TEAMS.values()) {
			if(team.players.contains(player)) {
				return team;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public static void switchTeamToPlayer(Player player, Color color) {
		if(TeamFK.playerHasTeam(player)) {
			TeamFK.getTeamWithPlayer(player).removePlayer(player);
		}
		TeamFK.getTeamWithColor(color).addPlayer(player);
	}
	
	
	
	//Methodes d'instances
	public void setHealth(int health) {
		this.health = health;
		if(health <= 0) {
			this.alive = false;
			this.health = 0;
		}
	}
	
	// Vrai si ok, faux si deja dans l'équipe
	public boolean addPlayer(Player player) {
		return this.players.add(player);
		
	}
	
	// Vrai si existait dans l'équipe, faux sinon
	public boolean removePlayer(Player player) {
		return this.players.remove(player);
	}
	
	public void decreaseHealth(int health) {
		this.health -= health;
		if(health <= 0) {
			this.alive = false;
			this.health = 0;
		}
	}
	
	public HashSet<Player> getPlayers() {
		return players;
	}
	
	public int getHealth() {
		return health;
	}
	
	public Color getColor() {
		return color;
	}
	
	public boolean isAlive() {
		return this.alive;
	}
}
