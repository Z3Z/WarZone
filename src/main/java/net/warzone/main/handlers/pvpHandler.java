package net.warzone.main.handlers;

import net.warzone.main.gameState;
import net.warzone.main.main;
import net.warzone.main.utils.hashMapStorage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class pvpHandler implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;
	public pvpHandler(main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void entityDamage(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			Player player = (Player) e.getEntity();
			Player damager = (Player) e.getDamager();
			if(gameState.getCurrentState() == gameState.INGAME){
				if(hashMapStorage.Blue.containsKey(player) && hashMapStorage.Blue.containsKey(damager)){
					e.setCancelled(true);
				}
				if(hashMapStorage.Red.containsKey(player) && hashMapStorage.Red.containsKey(damager)){
					e.setCancelled(true);
				}
			}else{
				e.setCancelled(true);
			}
		}
	}
	
}
