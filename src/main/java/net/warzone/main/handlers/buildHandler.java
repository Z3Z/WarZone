package net.warzone.main.handlers;

import net.warzone.main.gameState;
import net.warzone.main.main;
import net.warzone.main.utils.hashMapStorage;
import net.warzone.main.utils.packets;
import net.warzone.main.utils.util;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class buildHandler implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;

	public buildHandler(main listener) {
		this.plugin = listener;		
	}
	
	public static Integer redScore;
	public static Integer blueScore;
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		FireworkEffect blueEffect = FireworkEffect.builder().trail(true).flicker(true).withColor(new Color[] { Color.BLUE }).with(FireworkEffect.Type.BURST).build();
		FireworkEffect redEffect = FireworkEffect.builder().trail(true).flicker(true).withColor(new Color[] { Color.RED }).with(FireworkEffect.Type.BURST).build();
		Material blockType = e.getBlock().getType();
		Block block = e.getBlock();
		if(gameState.getCurrentState() == gameState.INGAME){
		if(blockType.equals(Material.DIAMOND_BLOCK) || blockType.equals(Material.EMERALD_BLOCK) || blockType.equals(Material.DIAMOND_ORE) || blockType.equals(Material.EMERALD_ORE) || blockType.equals(Material.IRON_BLOCK) || blockType.equals(Material.IRON_ORE) || blockType.equals(Material.GOLD_BLOCK) || blockType.equals(Material.GOLD_ORE) || blockType.equals(Material.BEACON) || blockType.equals(Material.STAINED_CLAY)){
			e.setCancelled(true);
			e.getPlayer().sendMessage(util.color("&eYou are not allowed to break &c" + blockType.toString().toUpperCase().replace("_", " ")));
		}else if (blockType.equals(Material.WOOL) && block.getData() == 14){
			if(hashMapStorage.Blue.containsKey(e.getPlayer())){
				
				
				if(redScore != 1){
					redScore--;
				}else{
					redScore--;
					endStateHandler.blue();
				}
				e.setCancelled(true);
				block.setType(Material.AIR);
				block.getWorld().playSound(e.getPlayer().getLocation(), Sound.ENTITY_SHULKER_OPEN, Integer.MAX_VALUE, Integer.MAX_VALUE);
				packets.playFirework(block.getLocation().add(0, 20, 0), blueEffect, 1);
				for(Player p : Bukkit.getOnlinePlayers()){
					p.sendMessage(util.color("&9&l" + e.getPlayer().getName() + " &ehas destroyed a &c&lRED &ewool!"));
					packets.sendActionBar(p, util.color("&9&l" + e.getPlayer().getName() + " &ehas destroyed a &c&lRED &ewool!"));
				}
				
				
			}else if(hashMapStorage.Red.containsKey(e.getPlayer())){
				e.setCancelled(true);
				e.getPlayer().sendMessage(util.color("&eYou arent allowed to break your own wool!"));
			}
		}else if (blockType.equals(Material.WOOL) && block.getData() == 11){
			if(hashMapStorage.Blue.containsKey(e.getPlayer())){
				e.setCancelled(true);
				e.getPlayer().sendMessage(util.color("&eYou arent allowed to break your own wool!"));
			}else if(hashMapStorage.Red.containsKey(e.getPlayer())){
				
				if(blueScore != 1){
					blueScore--;
				}else{
					blueScore--;
					endStateHandler.red();
				}
				e.setCancelled(true);
				block.setType(Material.AIR);
				block.getWorld().playSound(e.getPlayer().getLocation(), Sound.ENTITY_SHULKER_OPEN, Integer.MAX_VALUE, Integer.MAX_VALUE);
				packets.playFirework(block.getLocation().add(0, 20, 0), redEffect, 1);
				for(Player p : Bukkit.getOnlinePlayers()){
					p.sendMessage(util.color("&c&l" + e.getPlayer().getName() + " &ehas destroyed a &9&lBLUE &ewool!"));
					packets.sendActionBar(p, util.color("&c&l" + e.getPlayer().getName() + " &ehas destroyed a &9&lBLUE &ewool!"));
				}
				
			}
		}
		}else {
			e.setCancelled(true);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBuild(BlockPlaceEvent e){
		Block block = e.getBlock();
		Material blockType = block.getType();
		if(!(gameState.getCurrentState() == gameState.INGAME)){
			e.setCancelled(true);
		}else if(gameState.getCurrentState() == gameState.INGAME){
			if (blockType.equals(Material.WOOL) && block.getData() == 14){
				e.setCancelled(true);
			}else if (blockType.equals(Material.WOOL) && block.getData() == 11){
				e.setCancelled(true);
			}
		}
	}

}
