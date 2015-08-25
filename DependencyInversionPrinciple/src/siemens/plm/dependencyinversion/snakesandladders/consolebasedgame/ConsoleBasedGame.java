package siemens.plm.dependencyinversion.snakesandladders.consolebasedgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import siemens.plm.dependencyinversion.snakesladders.ISnakesAndLadders;
import siemens.plm.dependencyinversion.snakesladders.SnakesAndLaddersFactory;

public class ConsoleBasedGame {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Snakes and Ladders");

		List<String> players = readPlayersFromConsole();
		ISnakesAndLadders game = new SnakesAndLaddersFactory().create(players);
	    game.play();
	}
	
	private static List<String> readPlayersFromConsole(){
	    ArrayList<String> players = new ArrayList<String>();

		int index = 1;
	    Scanner consoleReader = new Scanner(System.in);
	    String player = readNameFromConsole(index, consoleReader); 
	    while (player != null)
	    {
	    	players.add(player);
	    	player = readNameFromConsole(++index, consoleReader);
	    }
		return players; 
	}
	
	private static String readNameFromConsole(int index, Scanner consoleReader)
	{
		System.out.println("Who's playing (type end to start the game)?");

		System.out.printf("Player %d: ", index);
		String input = consoleReader.nextLine().trim();
		return input.equals("end") ? null : input; 
	}

}
