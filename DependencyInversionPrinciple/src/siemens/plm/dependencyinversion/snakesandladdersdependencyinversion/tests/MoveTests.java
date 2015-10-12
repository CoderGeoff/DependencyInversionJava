package siemens.plm.dependencyinversion.snakesandladdersdependencyinversion.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import siemens.plm.dependencyinversion.snakesandladdersdependencyinversion.IBoard;
import siemens.plm.dependencyinversion.snakesandladdersdependencyinversion.Move;
import siemens.plm.dependencyinversion.snakesandladdersdependencyinversion.MoveOutcome;

public class MoveTests {

	@Test
	public void givenAPlayerOnSquare97_WhenTheyMove3_TheyShouldEndUpOnSquare98() {

		// Given
		BoardWith100SquaresAndNoSnakes board = new BoardWith100SquaresAndNoSnakes();
		Move move = new Move(board);
		
		// When
		MoveOutcome outcome = move.execute(97,  3);
		
		// Then
		assertEquals(98, outcome.getSquareAtEndOfMove());
	}
}
