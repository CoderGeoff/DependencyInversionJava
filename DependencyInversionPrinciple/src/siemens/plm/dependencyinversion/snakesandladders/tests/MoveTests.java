package siemens.plm.dependencyinversion.snakesandladders.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import siemens.plm.dependencyinversion.snakesandladders.IBoard;
import siemens.plm.dependencyinversion.snakesandladders.Move;
import siemens.plm.dependencyinversion.snakesandladders.MoveOutcome;

public class MoveTests {

	@Test
	public void givenAPlayerOnSquare97_WhenTheyMove3_TheyShouldEndUpOnSquare98() {

		// Given
		BoardWith100SquaresAndNoSnakes board = new BoardWith100SquaresAndNoSnakes();
		Move move = new Move(board);
		
		// When
		// TODO implement the test
	}
}
