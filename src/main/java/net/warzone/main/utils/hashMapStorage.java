package net.warzone.main.utils;

import java.util.HashMap;
import java.util.UUID;

import net.warzone.main.main;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitTask;

public class hashMapStorage implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;
	public hashMapStorage(main listener) {
		this.plugin = listener;		
	}
	
	public static HashMap<Player, UUID> Blue = new HashMap<Player, UUID>();
	public static HashMap<Player, UUID> Red = new HashMap<Player, UUID>();
	public static HashMap<String, BukkitTask> gameStarter = new HashMap<String, BukkitTask>();
	public static HashMap<String, Boolean> started = new HashMap<String, Boolean>();
	
}
