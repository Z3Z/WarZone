package net.warzone.main.messages;

import net.warzone.main.main;
import net.warzone.main.utils.util;

import org.bukkit.event.Listener;

public class warZone implements Listener{
	
	public main plugin;
	public warZone(main listener) {
		this.plugin = listener;	
	}

	public static String nameOfGame = "WarZone";
	public static String colorOfGame = util.color("&e&l");
	public static Integer scoreToWin = 10;
	public static Integer mapNumber = 1;
	
}
