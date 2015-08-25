package siemens.plm.dependencyinversion.snakesandladdersdependencyinversion;

public class MoveOutcome {
	private boolean overshot;
	private int squareAtEndOfMove;
	private int squareAtEndOfDiceCount;
	
	public MoveOutcome(int squareAtEndOfDiceCount, int squareAtEndOfMove, boolean overshot)
	{
		this.squareAtEndOfDiceCount = squareAtEndOfDiceCount;
		this.squareAtEndOfMove = squareAtEndOfMove;
		this.overshot = overshot;
	}
	
	public boolean didHitSnake() {
		return squareAtEndOfDiceCount != squareAtEndOfMove;
	}
	
	public boolean isOvershot() {
		return overshot;
	}
	
	public int getSquareAtEndOfMove() {
		return squareAtEndOfMove;
	}

	public int getSquareAtEndOfDiceCount() {
		return squareAtEndOfDiceCount;
	}
}
