package siemens.plm.dependencyinversion.snakesandladders;

public class MoveOutcomeBuilder {
	private int squareAtEndOfDiceCount;
	private int squareAtEndOfMove;
	boolean overshot;

	public MoveOutcomeBuilder(int square) {
		squareAtEndOfDiceCount = square;
		squareAtEndOfMove = square;
		overshot = false;
	}

	public void OvershotTo(int square) {
		squareAtEndOfDiceCount = square;
		squareAtEndOfMove = square;
		overshot = true;
	}

	public void WentDownSnakeTo(int square) {
		squareAtEndOfMove = square;
	}

	public MoveOutcome Build() {
		return new MoveOutcome(squareAtEndOfDiceCount, squareAtEndOfMove, overshot);
	}
}
