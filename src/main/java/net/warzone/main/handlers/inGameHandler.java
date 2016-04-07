package net.warzone.main.handlers;

import net.warzone.main.main;
import net.warzone.main.utils.hashMapStorage;
import net.warzone.main.utils.packets;
import net.warzone.main.utils.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitScheduler;

public class inGameHandler implements Listener{
	
	private static main plugin;
	public inGameHandler(main listener) {
		inGameHandler.plugin = listener;
	}
	
	public static Integer countDown;
	
	public static void gameStarter(){
		countDown = 30;
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		hashMapStorage.gameStarter.put("starter", scheduler.runTaskTimer(plugin, new Runnable() {
					public void run() {
						if(countDown.equals(0)){
							hashMapStorage.gameStarter.get("starter").cancel();
							hashMapStorage.gameStarter.remove("starter");
							lobbyStateHandler.startGame();
							lobbyStateHandler.prepareGame();
							hashMapStorage.started.remove("started");
							hashMapStorage.started.put("started", true);
						}else{
							countDown--;
						}
						if(countDown.equals(25) || countDown.equals(20) || countDown.equals(15) || countDown.equals(10) || countDown.equals(5) || countDown.equals(4) || countDown.equals(3) || countDown.equals(2) || countDown.equals(1)){
							for(Player p : Bukkit.getOnlinePlayers()){
								p.sendMessage(util.color("&eGame starting in &c" + countDown));
								packets.sendActionBar(p, util.color("&eGame starting in &c" + countDown));
							}
						}
					}
				}, 0, 20L));
	}
}
