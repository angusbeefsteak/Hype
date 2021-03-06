package net.angusbeefgaming.hype.plugins;

import java.io.IOException;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.exceptions.InvalidPlayerException;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.player.HypixelPlayer;
import me.kbrewster.hypixelapi.player.stats.tnt.TNTGames;
import net.angusbeefgaming.hype.Plugin;
import net.angusbeefgaming.hype.Util;

public class TNTGamesStats extends Plugin {
	public TNTGamesStats(HypixelAPI api) {
		super("TNTGames", "Atticus Zambrana");
	}
	
	@Override
	public void startup() {
		
	}

	@Override
	public void execute() {
		Util.print(getName(), "Who would you like to lookup?");
		
		String name = Util.getInput();
		
		HypixelPlayer player = null;
		try {
			player = api.getPlayer(name);
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Util.print("TNT Games Stats", "Showing TNT Games Stats for " + name);
		TNTGames tnt = player.getStats().getTNTGames();
		
		System.out.println("Coins: " + tnt.getCoins());
		System.out.println("Wins: " + tnt.getWins());
		System.out.println("Current Winstreak: " + tnt.getWinstreak());
		
		System.out.println("");
	}
}
