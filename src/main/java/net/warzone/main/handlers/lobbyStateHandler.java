package net.warzone.main.handlers;

import java.io.File;

import net.warzone.main.gameState;
import net.warzone.main.main;
import net.warzone.main.utils.hashMapStorage;
import net.warzone.main.utils.util;
import net.warzone.main.utils.worldManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class lobbyStateHandler implements Listener{

	@SuppressWarnings("unused")
	private main plugin;
	public lobbyStateHandler(main listener) {
		this.plugin = listener;
	}
	
	public static void prepareGame(){
		World delete = Bukkit.getWorld("GAME");
		File deleteFolder = delete.getWorldFolder();
		World target = Bukkit.getWorld("GAME");
		File targetFolder = target.getWorldFolder();
		if(endStateHandler.mapNumber == 1){
			World source = Bukkit.getWorld("MAP1");
			File sourceFolder = source.getWorldFolder();
			worldManager.unloadWorld(Bukkit.getWorld("GAME"));
			Bukkit.getServer().broadcastMessage("1-1");
			worldManager.unloadWorld(source);
			Bukkit.getServer().broadcastMessage("1-2");
			worldManager.deleteWorld(deleteFolder);
			Bukkit.getServer().broadcastMessage("1-3");
			worldManager.copyWorld(sourceFolder, targetFolder);
			Bukkit.getServer().broadcastMessage("1-4");
			worldManager.createWorld("GAME");
			Bukkit.getServer().broadcastMessage("1-5");
			gameState.setCurrentState(gameState.LOBBY);
		}else if(endStateHandler.mapNumber == 2){
			World source = Bukkit.getWorld("MAP2");
			File sourceFolder = source.getWorldFolder();
			worldManager.unloadWorld(Bukkit.getWorld("GAME"));
			Bukkit.getServer().broadcastMessage("2-1");
			worldManager.unloadWorld(source);
			Bukkit.getServer().broadcastMessage("2-2");
			worldManager.deleteWorld(deleteFolder);
			Bukkit.getServer().broadcastMessage("2-3");
			worldManager.copyWorld(sourceFolder, targetFolder);
			Bukkit.getServer().broadcastMessage("2-4");
			worldManager.createWorld("GAME");
			Bukkit.getServer().broadcastMessage("2-5");
			gameState.setCurrentState(gameState.LOBBY);
		}else if(endStateHandler.mapNumber == 3){
			World source = Bukkit.getWorld("MAP3");
			File sourceFolder = source.getWorldFolder();
			worldManager.unloadWorld(Bukkit.getWorld("GAME"));
			worldManager.unloadWorld(source);
			worldManager.deleteWorld(deleteFolder);
			worldManager.copyWorld(sourceFolder, targetFolder);
			worldManager.createWorld("GAME");
			gameState.setCurrentState(gameState.LOBBY);
		}else if(endStateHandler.mapNumber == 4){
			World source = Bukkit.getWorld("MAP4");
			File sourceFolder = source.getWorldFolder();
			worldManager.unloadWorld(Bukkit.getWorld("GAME"));
			worldManager.unloadWorld(source);
			worldManager.deleteWorld(deleteFolder);
			worldManager.copyWorld(sourceFolder, targetFolder);
			worldManager.createWorld("GAME");
			gameState.setCurrentState(gameState.LOBBY);
		}else if(endStateHandler.mapNumber == 5){
			World source = Bukkit.getWorld("MAP5");
			File sourceFolder = source.getWorldFolder();
			worldManager.unloadWorld(Bukkit.getWorld("GAME"));
			worldManager.unloadWorld(source);
			worldManager.deleteWorld(deleteFolder);
			worldManager.copyWorld(sourceFolder, targetFolder);
			worldManager.createWorld("GAME");
			gameState.setCurrentState(gameState.LOBBY);
		}else if(endStateHandler.mapNumber == 6){
			World source = Bukkit.getWorld("MAP6");
			File sourceFolder = source.getWorldFolder();
			worldManager.unloadWorld(Bukkit.getWorld("GAME"));
			worldManager.unloadWorld(source);
			worldManager.deleteWorld(deleteFolder);
			worldManager.copyWorld(sourceFolder, targetFolder);
			worldManager.createWorld("GAME");
			gameState.setCurrentState(gameState.LOBBY);
		}else if(endStateHandler.mapNumber == 7){
			World source = Bukkit.getWorld("MAP7");
			File sourceFolder = source.getWorldFolder();
			worldManager.unloadWorld(Bukkit.getWorld("GAME"));
			worldManager.unloadWorld(source);
			worldManager.deleteWorld(deleteFolder);
			worldManager.copyWorld(sourceFolder, targetFolder);
			worldManager.createWorld("GAME");
			gameState.setCurrentState(gameState.LOBBY);
		}else if(endStateHandler.mapNumber == 8){
			World source = Bukkit.getWorld("MAP8");
			File sourceFolder = source.getWorldFolder();
			worldManager.unloadWorld(Bukkit.getWorld("GAME"));
			worldManager.unloadWorld(source);
			worldManager.deleteWorld(deleteFolder);
			worldManager.copyWorld(sourceFolder, targetFolder);
			worldManager.createWorld("GAME");
			gameState.setCurrentState(gameState.LOBBY);
		}else if(endStateHandler.mapNumber == 9){
			World source = Bukkit.getWorld("MAP9");
			File sourceFolder = source.getWorldFolder();
			worldManager.unloadWorld(Bukkit.getWorld("GAME"));
			worldManager.unloadWorld(source);
			worldManager.deleteWorld(deleteFolder);
			worldManager.copyWorld(sourceFolder, targetFolder);
			worldManager.createWorld("GAME");
			gameState.setCurrentState(gameState.LOBBY);
		}else if(endStateHandler.mapNumber == 10){
			World source = Bukkit.getWorld("MAP10");
			File sourceFolder = source.getWorldFolder();
			worldManager.unloadWorld(Bukkit.getWorld("GAME"));
			worldManager.unloadWorld(source);
			worldManager.deleteWorld(deleteFolder);
			worldManager.copyWorld(sourceFolder, targetFolder);
			worldManager.createWorld("GAME");
			gameState.setCurrentState(gameState.LOBBY);
		}	
	}
	
	public static Block blocks;
	public static void startGame() {
		if(Bukkit.getOnlinePlayers().size() >= 2){
		gameState.setCurrentState(gameState.INGAME);
		for(Player p : Bukkit.getOnlinePlayers()){
			if(!hashMapStorage.Blue.containsKey(p) && !hashMapStorage.Red.containsKey(p)){
				teamHandler.addToTeam(p);
			}
			if(hashMapStorage.Blue.containsKey(p)){
				Location loc = new Location(Bukkit.getWorld("GAME"), -22.5, 52, 86.5, 180, 0);
				p.teleport(loc);
				p.getInventory().addItem(util.createItem(Material.WOOD, 64, 0, util.color("&c&lWOOD"), null));
			}else if(hashMapStorage.Red.containsKey(p)){
				Location loc = new Location(Bukkit.getWorld("GAME"), -22.5, 52, -99.5, 0, 0);
				p.teleport(loc);
				p.getInventory().addItem(util.createItem(Material.WOOD, 64, 0, util.color("&c&lWOOD"), null));
			}
		}
	}else {
		return;
	}
	}
	
}
