package fr.grimmjoow.fallenkingdom;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.Position;

public class Zone {
	private Position pos1;
	private Position pos2;

	public Zone(Position position1, Position position2) {
		setPos1(position1);
		setPos2(position2);
	}

	public void setPos1(Position pos1) {
		this.pos1 = pos1;
	}

	public void setPos2(Position pos2) {
		this.pos2 = pos2;
	}

	// Check si un joueur est dans un zone
	public boolean isOn(Player joueur) {

		boolean onZone = false;
		Location playerl = joueur.getLocation();

		if ((pos2.getZ() < playerl.getBlockZ() && playerl.getBlockZ() < pos1.getZ())
				|| (pos1.getZ() < playerl.getBlockZ() && playerl.getBlockZ() < pos2.getZ())) {
			if ((pos2.getX() < playerl.getBlockX() && playerl.getBlockX() < pos1.getX())
					|| (pos1.getX() < playerl.getBlockX() && playerl.getBlockX() < pos2.getX())) {
				if ((pos2.getY() < playerl.getBlockY() && playerl.getBlockY() < pos1.getY())
						|| (pos1.getY() < playerl.getBlockY() && playerl.getBlockY() < pos2.getY())) {
					onZone = true;
				}
			}
		}

		return onZone;
	}
	
	public boolean isOn(Block block) {

		boolean onZone = false;
		Location playerl = block.getLocation();

		if ((pos2.getZ() < playerl.getBlockZ() && playerl.getBlockZ() < pos1.getZ())
				|| (pos1.getZ() < playerl.getBlockZ() && playerl.getBlockZ() < pos2.getZ())) {
			if ((pos2.getX() < playerl.getBlockX() && playerl.getBlockX() < pos1.getX())
					|| (pos1.getX() < playerl.getBlockX() && playerl.getBlockX() < pos2.getX())) {
				if ((pos2.getY() < playerl.getBlockY() && playerl.getBlockY() < pos1.getY())
						|| (pos1.getY() < playerl.getBlockY() && playerl.getBlockY() < pos2.getY())) {
					onZone = true;
				}
			}
		}

		return onZone;
	}
	

}
