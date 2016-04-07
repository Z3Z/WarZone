package net.warzone.main.handlers;

import java.io.File;

import net.warzone.main.gameState;
import net.warzone.main.main;
import net.warzone.main.utils.worldManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class commandHandler extends BukkitCommand {
	
	@SuppressWarnings("unused")
	private main plugin;

	public commandHandler(String string) {
		super(string);
		this.description = "A command";
	}

	public boolean execute(CommandSender sender,
			String alias, String[] args) {
		Player p = (Player) sender;
		if(sender.equals(p)){
		
		if (alias.equalsIgnoreCase("copy")){
			Bukkit.getServer().getWorld("RAWR").save();
			World delete = Bukkit.getWorld("FUN");
			File deleteFolder = delete.getWorldFolder();
			// The world to copy
			World source = Bukkit.getWorld("RAWR");
			File sourceFolder = source.getWorldFolder();
			 
			// The world to overwrite when copying
			World target = Bukkit.getWorld("FUN");
			File targetFolder = target.getWorldFolder();
			if(args.length >= 2 || args.length < 1 || args.equals(null)){
				for (Player player : Bukkit.getOnlinePlayers()){
					Location loc1 = new Location(Bukkit.getWorld("world"), 0.5, 100, 0.5, -90, 0);
					player.teleport(loc1);
				}
					worldManager.unloadWorld(Bukkit.getWorld("FUN"));
					p.sendMessage("UNLOADED FUN");
					worldManager.unloadWorld(Bukkit.getWorld("RAWR"));
					p.sendMessage("UNLOADED RAWR");
					worldManager.deleteWorld(deleteFolder);
					p.sendMessage("DELETED FUN");
					worldManager.copyWorld(sourceFolder, targetFolder);
					p.sendMessage("COPIED RAWR TO FUN");
					worldManager.createWorld("FUN");
					p.sendMessage("LOADED FUN");
					worldManager.createWorld("RAWR");
					p.sendMessage("LOADED RAWR");
					for (Player player : Bukkit.getOnlinePlayers()){
						Location loc = new Location(Bukkit.getWorld("FUN"), 0.5, 100, 0.5, -90, 0);
						player.teleport(loc);
						player.sendMessage("TPED TO FUN");
					}
					gameState.setCurrentState(gameState.INGAME);
			}
			}
		
		if (alias.equalsIgnoreCase("tp")){
			if(args.length >= 2 || args.length < 1 || args.equals(null)){
				p.sendMessage("SPECIFY A WORLD");
			}else if(args[0].equalsIgnoreCase("rawr")){
					Location loc = new Location(Bukkit.getWorld("RAWR"), 0.5, 100, 0.5, -90, 0);
					p.teleport(loc);
					p.sendMessage("TPED TOO RAWR");
				}else if(args[0].equalsIgnoreCase("fun")){
					Location loc = new Location(Bukkit.getWorld("FUN"), 0.5, 100, 0.5, -90, 0);
					p.teleport(loc);
					p.sendMessage("TPED TOO FUN");
				}else if(args[0].equalsIgnoreCase("world")){
					Location loc = new Location(Bukkit.getWorld("world"), 0.5, 100, 0.5, -90, 0);
					p.teleport(loc);
					p.sendMessage("TPED TOO WORLD");
				}else if(args[0].equalsIgnoreCase("lobby")){
					Location loc = new Location(Bukkit.getWorld("LOBBY"), 0.5, 100, 0.5, -90, 0);
					p.teleport(loc);
					p.sendMessage("TPED TOO LOBBY");
				}
			}
		
		if (alias.equalsIgnoreCase("state")){
			if(args.length >= 2 || args.length < 1 || args.equals(null)){
				p.sendMessage("SPECIFY A WORLD");
			}else if(args[0].equalsIgnoreCase("lobby")){
					gameState.setCurrentState(gameState.LOBBY);
				}else if(args[0].equalsIgnoreCase("end")){
					gameState.setCurrentState(gameState.ENDGAME);
				}else if(args[0].equalsIgnoreCase("ingame")){
					gameState.setCurrentState(gameState.INGAME);
				}
			}
		
		}
		
		
		return true;
	}
}
