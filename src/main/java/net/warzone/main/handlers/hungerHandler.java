package net.warzone.main.handlers;

import net.warzone.main.main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class hungerHandler implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;
	public hungerHandler(main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void noHunger(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}

}
