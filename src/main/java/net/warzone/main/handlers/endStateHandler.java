package net.warzone.main.handlers;

import net.warzone.main.gameState;
import net.warzone.main.main;
import net.warzone.main.messages.warZone;
import net.warzone.main.utils.hashMapStorage;
import net.warzone.main.utils.packets;
import net.warzone.main.utils.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class endStateHandler implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;
	public endStateHandler(main listener) {
		this.plugin = listener;
	}
	
	public static Integer mapNumber;
	
	public static void blue(){
		gameState.setCurrentState(gameState.ENDGAME);
		if(mapNumber == 10){
			mapNumber = 1;
		}else{
			mapNumber++;
		}
		for(Player p : Bukkit.getOnlinePlayers()){
			Location loc = new Location(Bukkit.getWorld("LOBBY"), 0.5, 100, 0.5, -90, 0);
			p.teleport(loc);
			hashMapStorage.Red.clear();
			hashMapStorage.Blue.clear();
			buildHandler.blueScore = warZone.scoreToWin;
			buildHandler.redScore = warZone.scoreToWin;
			packets.sendTitle(p, util.color("&9&lBLUE"), util.color("&eTeam Wins!"));
			hashMapStorage.started.remove("started");
			hashMapStorage.started.put("started", false);
		}
		lobbyStateHandler.prepareGame();
		inGameHandler.gameStarter();
	}
	
	public static void red(){
		gameState.setCurrentState(gameState.ENDGAME);
		if(mapNumber == 10){
			mapNumber = 1;
		}else{
			mapNumber++;
		}
		for(Player p : Bukkit.getOnlinePlayers()){
			Location loc = new Location(Bukkit.getWorld("LOBBY"), 0.5, 100, 0.5, -90, 0);
			p.teleport(loc);
			hashMapStorage.Red.clear();
			hashMapStorage.Blue.clear();
			buildHandler.blueScore = warZone.scoreToWin;
			buildHandler.redScore = warZone.scoreToWin;
			packets.sendTitle(p, util.color("&c&lRED"), util.color("&eTeam Wins!"));
		}
		lobbyStateHandler.prepareGame();
		inGameHandler.gameStarter();
	}

}
