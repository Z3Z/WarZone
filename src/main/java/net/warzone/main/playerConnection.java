package net.warzone.main;

import net.warzone.main.handlers.inGameHandler;
import net.warzone.main.handlers.lobbyStateHandler;
import net.warzone.main.handlers.scoreBoardHandler;
import net.warzone.main.handlers.teamHandler;
import net.warzone.main.utils.hashMapStorage;
import net.warzone.main.utils.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class playerConnection implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;
	public playerConnection(main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void connectionInbound(PlayerJoinEvent e){
		Player p = e.getPlayer();
		teamHandler.addToTeam(p);
		if(hashMapStorage.Red.containsKey(p)){
			e.setJoinMessage(util.color("&c&l" + p.getName() + " &eHas joined!"));
		}
		if(hashMapStorage.Blue.containsKey(p)){
			e.setJoinMessage(util.color("&9&l" + p.getName() + " &eHas joined!"));
		}
		p.setFoodLevel(20);
		if(Bukkit.getOnlinePlayers().size() >= 2){
			if(gameState.getCurrentState() == gameState.LOBBY){
			if(hashMapStorage.started.get("started") == false){
				inGameHandler.gameStarter();
				hashMapStorage.started.remove("started");
				hashMapStorage.started.put("started", true);
				lobbyStateHandler.prepareGame();
			}
			Location loc = new Location(Bukkit.getWorld("LOBBY"), 0.5, 100, 0.5, -90, 0);
			p.teleport(loc);
			}else if(gameState.getCurrentState() == gameState.INGAME){
				
				Location loc = new Location(Bukkit.getWorld("LOBBY"), 0.5, 100, 0.5, -90, 0);
				p.teleport(loc);
			}else if(gameState.getCurrentState() == gameState.ENDGAME){
				Location loc = new Location(Bukkit.getWorld("LOBBY"), 0.5, 100, 0.5, -90, 0);
				p.teleport(loc);
			}
		}
		p.setFoodLevel(20);
		scoreBoardHandler.makeScoreBoard(p);
		if(p.hasPlayedBefore() == false){
			p.setFoodLevel(20);
			if(gameState.getCurrentState() == gameState.LOBBY){
				
				Location loc = new Location(Bukkit.getWorld("LOBBY"), 0.5, 100, 0.5, -90, 0);
				p.teleport(loc);
			}else if(gameState.getCurrentState() == gameState.INGAME){
				
				Location loc = new Location(Bukkit.getWorld("LOBBY"), 0.5, 100, 0.5, -90, 0);
				p.teleport(loc);
			}else if(gameState.getCurrentState() == gameState.ENDGAME){
				Location loc = new Location(Bukkit.getWorld("LOBBY"), 0.5, 100, 0.5, -90, 0);
				p.teleport(loc);
			}
		}
		if(gameState.getCurrentState() == gameState.LOBBY){
			
			Location loc = new Location(Bukkit.getWorld("LOBBY"), 0.5, 100, 0.5, -90, 0);
			p.teleport(loc);
		}else if(gameState.getCurrentState() == gameState.INGAME){
			
			Location loc = new Location(Bukkit.getWorld("LOBBY"), 0.5, 100, 0.5, -90, 0);
			p.teleport(loc);
		}else if(gameState.getCurrentState() == gameState.ENDGAME){
			Location loc = new Location(Bukkit.getWorld("LOBBY"), 0.5, 100, 0.5, -90, 0);
			p.teleport(loc);
		}
	}
	
	@EventHandler
	public void connectionOutbound(PlayerQuitEvent e){
		Player p = e.getPlayer();
		scoreBoardHandler.makeScoreBoard(p);
		if(Bukkit.getOnlinePlayers().size() <= 1){
			hashMapStorage.started.remove("started");
			hashMapStorage.started.put("started", false);
		}
		if(gameState.getCurrentState() == gameState.LOBBY){
			if(hashMapStorage.Red.containsKey(p)){
				hashMapStorage.Red.remove(p);
			}
			if(hashMapStorage.Blue.containsKey(p)){
				hashMapStorage.Blue.remove(p);
			}
		}else if(gameState.getCurrentState() == gameState.INGAME){
			if(hashMapStorage.Red.containsKey(p)){
				hashMapStorage.Red.remove(p);
			}
			if(hashMapStorage.Blue.containsKey(p)){
				hashMapStorage.Blue.remove(p);
			}
		}else if(gameState.getCurrentState() == gameState.ENDGAME){
			if(hashMapStorage.Red.containsKey(p)){
				hashMapStorage.Red.remove(p);
			}
			if(hashMapStorage.Blue.containsKey(p)){
				hashMapStorage.Blue.remove(p);
			}
		}
	}
	
}
