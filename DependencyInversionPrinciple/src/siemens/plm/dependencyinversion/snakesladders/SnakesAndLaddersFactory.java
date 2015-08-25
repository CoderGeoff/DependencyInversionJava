package siemens.plm.dependencyinversion.snakesladders;

import java.util.List;

public class SnakesAndLaddersFactory {
	public ISnakesAndLadders create(List<String> players) {
		return new SnakesAndLadders(players);
	}
}
