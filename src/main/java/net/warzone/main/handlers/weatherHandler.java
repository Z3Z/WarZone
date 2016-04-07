package net.warzone.main.handlers;

import net.warzone.main.main;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class weatherHandler implements Listener {
	@SuppressWarnings("unused")
	private main plugin;

	public weatherHandler(main hub) {
		this.plugin = hub;
	}

	@EventHandler
	  public void weatherChange(WeatherChangeEvent event)
	  {
	    if (event.toWeatherState()) {
	        World world = event.getWorld();
	          event.setCancelled(true);
	          world.setStorm(false);
	          world.setThundering(false);
	          world.setWeatherDuration(0);
	    }
	  }

}
