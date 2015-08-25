package siemens.plm.dependencyinversion.snakesandladdersdependencyinversion;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Board implements IBoard {
	private int lastSquare;
	private Map<Integer, Integer> snakes;

	public Board(int sizeOfOneSide) {
		lastSquare = (sizeOfOneSide * sizeOfOneSide) - 1;
		snakes = makeSnakes(sizeOfOneSide);
	}

	@Override
	public Integer tryGetSnakeTailWithHeadAt(int square) {
	    return snakes.get(square);
	}

	@Override
	public int getLastSquare() {
		return lastSquare;
	}

	private Map<Integer, Integer> makeSnakes(int sizeOfOneSide) {
		HashMap<Integer, Integer> snakes = new HashMap<Integer, Integer>();
		
		 Random random = new Random();
		 random.setSeed(System.currentTimeMillis());
		
		int numberOfSnakes = sizeOfOneSide;
		int lowestSquareForSnakeHead = sizeOfOneSide;
		int highestSquareForSnakeHead = sizeOfOneSide * sizeOfOneSide - 1;
		int range = highestSquareForSnakeHead - lowestSquareForSnakeHead;
		for (int i = 0; i < numberOfSnakes; ++i)
		{
			int head = random.nextInt(range) + lowestSquareForSnakeHead + 1;
			int tail = random.nextInt(head - 1) + 1;
			snakes.put(head, tail);
		}
		return snakes;
	}
}