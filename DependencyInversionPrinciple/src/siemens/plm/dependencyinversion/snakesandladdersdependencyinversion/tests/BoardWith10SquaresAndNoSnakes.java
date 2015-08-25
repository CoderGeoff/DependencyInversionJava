package siemens.plm.dependencyinversion.snakesandladdersdependencyinversion.tests;

import siemens.plm.dependencyinversion.snakesandladdersdependencyinversion.IBoard;

public class BoardWith10SquaresAndNoSnakes implements IBoard {

	@Override
	public Integer tryGetSnakeTailWithHeadAt(int square) {
		return null;
	}

	@Override
	public int getLastSquare() {
		return 10;
	}

}
