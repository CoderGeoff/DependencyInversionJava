package siemens.plm.dependencyinversion.snakesandladders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SnakesAndLadders implements ISnakesAndLadders {
	private Board board;
	private int currentPlayerIndex;
	private Player[] players;
	private static Map<Integer, String> numbers = new HashMap<Integer, String>();
	private Scanner consoleReader = new Scanner(System.in);

	static {
		numbers.put(1, "one");
		numbers.put(2, "two");
		numbers.put(3, "three");
		numbers.put(4, "four");
		numbers.put(5, "five");
		numbers.put(6, "six");
	}

	public SnakesAndLadders(List<String> players) {
		board = new Board(10);
		currentPlayerIndex = 0;
		this.players = players.stream()
				.map(name -> new Player(name))
				.collect(Collectors.toList())
				.toArray(new Player[] {});
	}

	public void play() {
		System.out.println("Let's start");
		while (takeNextTurn()) {
			currentPlayerIndex = ++currentPlayerIndex % players.length;
		}
	}

	private boolean takeNextTurn() {
		Player player = players[currentPlayerIndex];
		System.out.printf("Ok, %s to go next. Press any key to continue.\n", player.getName());
		consoleReader.nextLine();

		// throw the die
		int thrown = Die.getThrow();
		System.out.printf("%s has thrown a %d\n", player.getName(), thrown);
		printMoving(thrown);

		// move the number of square shown on the die
		int newPosition = player.getSquare() + thrown;
		if (newPosition > board.getLastSquare()) {
			// if we've overshot the last square, we have to go back
			int numberOfSpacesToGoBack = board.getLastSquare() - newPosition;
			newPosition = board.getLastSquare() - numberOfSpacesToGoBack;
			System.out.println("Bad luck - you overshot the end!");
		}
		System.out.printf("You're now on %d\n", newPosition);

		// check to see if we're at the head of a snake
		Integer tail = board.tryGetSnakeTailWithHeadAt(newPosition);
		if (tail != null) {
			System.out.println("Oh no, you've landed on a snake. Down you go!");
			newPosition = tail.intValue();
			System.out.printf("You're now on %d\n", newPosition);
		}
		player.setSquare(newPosition);

		// see if the player has won
		if (newPosition == board.getLastSquare()) {
			System.out.println("You've won!");
			return false;
		}

		return true;
	}

	private void printMoving(int count) {
		System.out.print("Moving... ");
		for (int i = 1; i <= count; ++i) {
			System.out.printf("%s... ", numbers.get(i));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("");
	}
}
