package net.warzone.main.handlers;

import net.warzone.main.main;
import net.warzone.main.utils.hashMapStorage;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class deathHandler implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;

	public deathHandler(main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		if(e.getEntity() instanceof Player){
			Player p = e.getEntity();
		if(hashMapStorage.Red.containsKey(p)){
			p.spigot().respawn();
			Location loc = new Location(Bukkit.getWorld("GAME"), -22.5, 52, -99.5, 0, 0);
			p.teleport(loc);
		}else if(hashMapStorage.Blue.containsKey(p)){
			p.spigot().respawn();
			Location loc = new Location(Bukkit.getWorld("GAME"), -22.5, 52, 86.5, 180, 0);
			p.teleport(loc);
		}
		}
	}

}
