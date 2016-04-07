package net.warzone.main.handlers;

import net.warzone.main.main;
import net.warzone.main.messages.warZone;
import net.warzone.main.utils.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class scoreBoardHandler implements Listener{
	
	private static main plugin;
	public scoreBoardHandler(main listener) {
		scoreBoardHandler.plugin = listener;
		boardUpdater();
	}
	
public static Scoreboard board;
public static Objective objective;
	
    public static void makeScoreBoard(final Player p){
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        board = scoreboardManager.getNewScoreboard();
        objective = board.registerNewObjective("lobby","dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(util.color(warZone.colorOfGame + warZone.nameOfGame.toUpperCase()));
        /*Score score = objective.getScore(util.color("&c&lRED WOOL"));
        score.setScore(14);
        Score score2 = objective.getScore(util.color(ChatColor.BLUE + "" + ChatColor.BOLD));
        score2.setScore(13);
        Score score3 = objective.getScore(util.color(" "));
        score3.setScore(12);
        Score score4 = objective.getScore(util.color("&9&lBLUE WOOL"));
        score4.setScore(11);
        Score score5 = objective.getScore(util.color(ChatColor.YELLOW + "" + ChatColor.BOLD));
        score5.setScore(10);
        Score score6 = objective.getScore(util.color("  "));
        score6.setScore(9);*/
        Score score7 = objective.getScore(util.color("&c&lRED WOOL"));
        score7.setScore(8);
        Score score8 = objective.getScore(util.color(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD));
        score8.setScore(7);
        Score score9 = objective.getScore(util.color("   "));
        score9.setScore(6);
        Score score10 = objective.getScore(util.color("&9&lBLUE WOOL"));
        score10.setScore(5);
        Score score11 = objective.getScore(util.color(ChatColor.AQUA + "" + ChatColor.BOLD));
        score11.setScore(4);
        Score score12 = objective.getScore(util.color("    "));
        score12.setScore(3);
        Score score13 = objective.getScore(util.color("&a&lLEVEL"));
        score13.setScore(2);
        Score score14 = objective.getScore(util.color(ChatColor.RED + "" + ChatColor.BOLD));
        score14.setScore(1);
        
        /*Team team1 = board.registerNewTeam("team1");
        team1.addEntry(util.color(ChatColor.BLUE + "" + ChatColor.BOLD));
        
        Team team2 = board.registerNewTeam("team2");
        team2.addEntry(ChatColor.YELLOW + "" + ChatColor.BOLD);
        */
        Team team3 = board.registerNewTeam("team3");
        team3.addEntry(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD);
        
        Team team4 = board.registerNewTeam("team4");
        team4.addEntry(ChatColor.AQUA + "" + ChatColor.BOLD);
        
        Team team5 = board.registerNewTeam("team5");
        team5.addEntry(ChatColor.RED + "" + ChatColor.BOLD);
		p.setScoreboard(board);
    }
    
    
    public static void boardUpdater(){
    	Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
        		public void run() {
        			
        			for(final Player p : Bukkit.getOnlinePlayers()){
        				if(!(p.equals(null))){
        					
        			/*Team team1 = p.getScoreboard().getTeam("team1");
    				team1.setPrefix(util.color("&8&l" + "▶ "));
    				team1.setSuffix(util.color("&r" + "NUMBER HERE"));
        			
    				Team team2 = p.getScoreboard().getTeam("team2"); 
    				team2.setPrefix(util.color("&8&l" + "▶ "));
    				team2.setSuffix(util.color("&r" + "NUMBER_HERE"));*/
    				
    				Team team3 = p.getScoreboard().getTeam("team3");
    				team3.setPrefix(util.color("&8&l" + "▶ "));
    				team3.setSuffix(util.color("&r" + buildHandler.redScore));
    				
    				Team team4 = p.getScoreboard().getTeam("team4");
    				team4.setPrefix(util.color("&8&l" + "▶ "));
    				team4.setSuffix(util.color("&r" + buildHandler.blueScore));
    				
    				Team team5 = p.getScoreboard().getTeam("team5");
    				team5.setPrefix(util.color("&8&l" + "▶ "));
    				team5.setSuffix(util.color("&r" + "_NUMBERHERE_"));
        			}
        			}
        			}
            	}, 0, 5);
					//END OF SCOREBOARD DISPLAYNAME
    }
}
