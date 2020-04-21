package Hangman;

import java.util.ArrayList;

public class GameStatistics {

	private int lost, won, gamesPlayed;
	
	public GameStatistics() {
		lost = 0;
		won = 0;
		gamesPlayed = 0;
	}
	
	
	public int getGamesLost() {
		
		return lost;
	}
	
	public int getGamesWon() {
		
		return won;
	}
	
	public int getTotalGamesPlayed() {
		
		return gamesPlayed;
	}
	
}
