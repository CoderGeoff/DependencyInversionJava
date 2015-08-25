package siemens.plm.dependencyinversion.snakesladders;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SnakesAndLadders implements ISnakesAndLadders {
	private Board m_Board;
	private int m_CurrentPlayerIndex;
	private Player[] m_Players;
	private static Map<Integer, String> s_Numbers = new HashMap<Integer, String>();

	static {
		s_Numbers.put(1, "one");
		s_Numbers.put(2, "two");
		s_Numbers.put(3, "three");
		s_Numbers.put(4, "four");
		s_Numbers.put(5, "five");
		s_Numbers.put(6, "six");
	}

	public SnakesAndLadders(List<String> players) {
		m_Board = new Board(10);
		m_CurrentPlayerIndex = 0;
		m_Players = players.stream()
				.map(name -> new Player(name))
				.collect(Collectors.toList())
				.toArray(new Player[] {});
	}

	public void play() {
		System.out.println("Let's start");
		while (takeNextTurn()) {
			m_CurrentPlayerIndex = ++m_CurrentPlayerIndex % m_Players.length;
		}
	}

	private boolean takeNextTurn() {
		Player player = m_Players[m_CurrentPlayerIndex];
		System.out.printf("Ok, %s to go next. Press any key to continue.\n", player.getName());
		try {
			System.in.read();
		} catch (IOException e) {
		}

		// throw the die
		int thrown = Die.getThrow();
		System.out.printf("%s has thrown a %d\n", player.getName(), thrown);
		printMoving(thrown);

		// move the number of square shown on the die
		int newPosition = player.getSquare() + thrown;
		if (newPosition > m_Board.getLastSquare()) {
			// if we've overshot the last square, we have to go back
			int numberOfSpacesToGoBack = m_Board.getLastSquare() - newPosition;
			newPosition = m_Board.getLastSquare() - numberOfSpacesToGoBack;
			System.out.println("Bad luck - you overshot the end!");
		}
		System.out.printf("You're now on %d\n", newPosition);

		// check to see if we're at the head of a snake
		Integer tail = m_Board.tryGetSnakeTailWithHeadAt(newPosition);
		if (tail != null) {
			System.out.println("Oh no, you've landed on a snake. Down you go!");
			newPosition = tail.intValue();
			System.out.printf("You're now on %d\n", newPosition);
		}
		player.setSquare(newPosition);

		// see if the player has won
		if (newPosition == m_Board.getLastSquare()) {
			System.out.println("You've won!");
			return false;
		}

		return true;
	}

	private void printMoving(int count) {
		System.out.print("Moving... ");
		for (int i = 1; i <= count; ++i) {
			System.out.printf("%d... ", s_Numbers.get(i));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("");
	}
}
