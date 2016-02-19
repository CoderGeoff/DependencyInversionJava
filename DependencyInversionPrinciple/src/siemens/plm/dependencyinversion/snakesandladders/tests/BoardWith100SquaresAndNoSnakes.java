package siemens.plm.dependencyinversion.snakesandladders.tests;

import siemens.plm.dependencyinversion.snakesandladders.IBoard;

public class BoardWith100SquaresAndNoSnakes implements IBoard {

	@Override
	public Integer tryGetSnakeTailWithHeadAt(int square) {
		return null;
	}

	@Override
	public int getLastSquare() {
		return 99;
	}

}
