package net.warzone.main.handlers;

import java.util.Random;

import net.warzone.main.main;
import net.warzone.main.utils.hashMapStorage;
import net.warzone.main.utils.util;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class teamHandler implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;
	public teamHandler(main listener) {
		this.plugin = listener;		
	}
	
	static Random random = new Random();

	public static void addToTeam(Player p) {
	    if (hashMapStorage.Red.size() == hashMapStorage.Blue.size()) {
	        if (random.nextBoolean()) {
	            hashMapStorage.Red.put(p, p.getUniqueId());
	            p.sendMessage(util.color("&eYou have been added to the &c&lRED &eteam!"));
	        } else {
	        	hashMapStorage.Blue.put(p, p.getUniqueId());
	        	p.sendMessage(util.color("&eYou have been added to the &9&lBLUE &eteam!"));
	        }
	    } else {
	        if (hashMapStorage.Red.size() < hashMapStorage.Blue.size()) {
	        	hashMapStorage.Red.put(p, p.getUniqueId());
	        	p.sendMessage(util.color("&eYou have been added to the &c&lRED &eteam!"));
	        } else {
	        	hashMapStorage.Blue.put(p, p.getUniqueId());
	        	p.sendMessage(util.color("&eYou have been added to the &9&lBLUE &eteam!"));
	        }
	    }
	}

}
