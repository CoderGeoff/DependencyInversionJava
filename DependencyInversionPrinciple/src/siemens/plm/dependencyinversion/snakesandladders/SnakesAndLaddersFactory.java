package siemens.plm.dependencyinversion.snakesandladders;

import java.util.List;

public class SnakesAndLaddersFactory {
	public ISnakesAndLadders create(List<String> players) {
		IBoard board = new Board(10);
		IDie die = new Die();
		return new SnakesAndLadders(board, die, players);
	}
}

