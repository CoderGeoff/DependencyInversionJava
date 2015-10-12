package siemens.plm.dependencyinversion.snakesandladdersdependencyinversion;

public class Move {
	private IBoard board;

	public Move(IBoard board) {
		this.board = board;
	}
	
	public MoveOutcome execute(int startSquare, int squaresToMove)
	{
	    // move the number of square shown on the die
	    int newPosition = startSquare + squaresToMove;
	    MoveOutcomeBuilder outcomeBuilder = new MoveOutcomeBuilder(newPosition);

	    if (newPosition > board.getLastSquare())
	    {
	        // if we've overshot the last square, we have to go back
	        int numberOfSpacesToGoBack = newPosition - board.getLastSquare();
	        newPosition = board.getLastSquare() - numberOfSpacesToGoBack;
	        outcomeBuilder.OvershotTo(newPosition);
	    }

	    // check to see if we're at the head of a snake
	    Integer tail = board.tryGetSnakeTailWithHeadAt(newPosition);
	    if (tail != null)
	    {
	        outcomeBuilder.WentDownSnakeTo(tail.intValue());
	        newPosition = tail.intValue();
	    }

	    return outcomeBuilder.Build();
	}
}
