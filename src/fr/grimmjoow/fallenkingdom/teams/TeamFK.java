package fr.grimmjoow.fallenkingdom.teams;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import fr.grimmjoow.fallenkingdom.Main;
import fr.grimmjoow.fallenkingdom.Zone;
import fr.grimmjoow.fallenkingdom.task.ATHManager;
import fr.grimmjoow.fallenkingdom.utils.ColorUtils;
import net.minecraft.server.v1_8_R3.Position;

public class TeamFK {
	private static HashMap<Color,TeamFK> TEAMS = new HashMap<>();
	private static Scoreboard SCOREBOARD;
	
	private HashSet<Player> players = new HashSet<>();
	private int health;
	private Color color;
	private boolean alive;
	private Location point_spawn;
	private Team team;
	private HashSet<Zone> zones = new HashSet<>();
	private final static int VIE = 1000; //A changer
	
	TeamFK(Color color) {
		this.color = color;
		this.health = VIE;
		this.alive = true;	
		
		team = SCOREBOARD.registerNewTeam(ColorUtils.colorToString(color));
		team.setPrefix(ColorUtils.colorToChatColor(color) + "");
		setSpawn();
		setZones();
	}
	
	public static void initTeams() {
		ScoreboardManager manager = Bukkit.getServer().getScoreboardManager();
		SCOREBOARD = manager.getNewScoreboard();
		
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
	
	public static void teleportPlayers() {
		for (TeamFK team: TeamFK.getTeams().values() ) {
			for (Player teamPlayer : team.getPlayers()) {
				teamPlayer.teleport(team.getPoint_spawn());
				teamPlayer.setBedSpawnLocation(team.getPoint_spawn(),true);
			}
		}
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
		ATHManager.update_ATH();
	}
	
	
	
	//Methodes d'instances
	public void setHealth(int health) {
		this.health = health;
		if(health <= 0) {
			this.alive = false;
			this.health = 0;
		}
	}
	
	public void decreaseHealth(int health) {
		this.health -= health;
		if(health <= 0) {
			this.alive = false;
			this.health = 0;
		}
	}
	// Vrai si ok, faux si deja dans l'équipe
	public boolean addPlayer(Player player) {
		team.addEntry(player.getName());
		player.setScoreboard(SCOREBOARD);
		return this.players.add(player);	
		
	}
	
	// Vrai si existait dans l'équipe, faux sinon
	public boolean removePlayer(Player player) {
		team.removeEntry(player.getName());
		return this.players.remove(player);
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
	
	public HashSet<Zone> getZones() {
		return this.zones;
	}
	//True si ok, Faux si existe deja
	public boolean addZone(Zone zone) {
		return this.zones.add(zone);
	}
	//True si bien supprimee, Faux si n'existait pas
	public boolean removeZone(Zone zone) {
		return this.zones.remove(zone);
	}
	
	public boolean isZonesTriggered(Player player) {
		for(Zone zone : this.zones) {
			if (zone.isOn(player)) {
				return true;
			}
		}
		return false;
	}

	public Location getPoint_spawn() {
		return point_spawn;
	}

	public void setPoint_spawn(Location point_spawn) {
		this.point_spawn = point_spawn;
	}
	
	private void setSpawn() {
		if (this.getColor() == Color.RED) {
			setPoint_spawn(new Location(Main.monde,143.5,72,103.5,90,0));
		} else if (this.getColor() == Color.ORANGE) {
			setPoint_spawn(new Location(Main.monde,61.5,72,128.5,-180,0));
		} else if (this.getColor() == Color.BLUE) {
			setPoint_spawn(new Location(Main.monde,61.5,72,-9.5,0,0));
		} else if (this.getColor() == Color.GREEN) {
			setPoint_spawn(new Location(Main.monde,11.5,72,59.5,-90,0));
		} else if (this.getColor() == Color.YELLOW) {
			setPoint_spawn(new Location(Main.monde,143.5,72,15.5,90,0));
		}
			
	}
	
	private void setZones() {
		if (this.getColor() == Color.RED) {
			// Base ext 
			this.zones.add(new Zone(new Position(131,72,89),new Position(159,90,117)));
		} else if (this.getColor() == Color.ORANGE) {
			// Base ext 
			this.zones.add(new Zone(new Position(75,72,116),new Position(47,90,144)));
		} else if (this.getColor() == Color.BLUE) {
			// Base ext 
			this.zones.add(new Zone(new Position(47,72,2),new Position(75,90,-26)));
		} else if (this.getColor() == Color.GREEN) {
			// Base ext 
			this.zones.add(new Zone(new Position(23,72,73),new Position(-5,90,45)));
		} else if (this.getColor() == Color.YELLOW) {
			// Base ext 
			this.zones.add(new Zone(new Position(131,72,1),new Position(159,90,29)));
		}
			
	}
	
	
}
