package net.warzone.main;

import net.warzone.main.handlers.buildHandler;
import net.warzone.main.handlers.commandHandler;
import net.warzone.main.handlers.deathHandler;
import net.warzone.main.handlers.endStateHandler;
import net.warzone.main.handlers.hungerHandler;
import net.warzone.main.handlers.inGameHandler;
import net.warzone.main.handlers.lobbyStateHandler;
import net.warzone.main.handlers.pvpHandler;
import net.warzone.main.handlers.scoreBoardHandler;
import net.warzone.main.handlers.teamHandler;
import net.warzone.main.handlers.weatherHandler;
import net.warzone.main.messages.warZone;
import net.warzone.main.utils.hashMapStorage;
import net.warzone.main.utils.packets;
import net.warzone.main.utils.util;
import net.warzone.main.utils.worldManager;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_9_R1.CraftServer;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener{
	
	public void onEnable(){
		loadListeners();
		loadCommands();
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(util.color(warZone.colorOfGame + warZone.nameOfGame + " &eHas been enabled!"));
		worldManager.createWorld("GAME");
		worldManager.createWorld("LOBBY");
		worldManager.createWorld("MAP1");
		worldManager.createWorld("MAP2");
		worldManager.createWorld("MAP3");
		worldManager.createWorld("MAP4");
		worldManager.createWorld("MAP5");
		worldManager.createWorld("MAP6");
		worldManager.createWorld("MAP7");
		worldManager.createWorld("MAP8");
		worldManager.createWorld("MAP9");
		worldManager.createWorld("MAP10");
		gameState.setCurrentState(gameState.LOBBY);
		buildHandler.blueScore = warZone.scoreToWin;
		buildHandler.redScore = warZone.scoreToWin;
		endStateHandler.mapNumber = warZone.mapNumber;
		hashMapStorage.started.put("started", false);
	}
	
	public void onDisable(){
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(util.color(warZone.colorOfGame + warZone.nameOfGame + " &eHas been disabled!"));
	}
	
	public void loadListeners(){
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new util(this), this);
		pm.registerEvents(new packets(this), this);
		pm.registerEvents(new playerConnection(this), this);
		pm.registerEvents(new worldManager(this), this);
		pm.registerEvents(new scoreBoardHandler(this), this);
		pm.registerEvents(new teamHandler(this), this);
		pm.registerEvents(new hungerHandler(this), this);
		pm.registerEvents(new buildHandler(this), this);
		pm.registerEvents(new pvpHandler(this), this);
		pm.registerEvents(new endStateHandler(this), this);
		pm.registerEvents(new lobbyStateHandler(this), this);
		pm.registerEvents(new inGameHandler(this), this);
		pm.registerEvents(new weatherHandler(this), this);
		pm.registerEvents(new deathHandler(this), this);
	}
	
	public void loadCommands(){
		((CraftServer) this.getServer()).getCommandMap().register("copy", new commandHandler("copy"));
		((CraftServer) this.getServer()).getCommandMap().register("tp", new commandHandler("tp"));
		((CraftServer) this.getServer()).getCommandMap().register("state", new commandHandler("state"));
	}
	
	
	
}
