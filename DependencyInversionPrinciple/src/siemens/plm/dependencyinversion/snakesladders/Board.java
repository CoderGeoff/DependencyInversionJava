package siemens.plm.dependencyinversion.snakesladders;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Board {
	private int m_LastSquare;
	private Map<Integer, Integer> m_Snakes;

	public Board(int sizeOfOneSide) {
		m_LastSquare = (sizeOfOneSide * sizeOfOneSide) - 1;
		m_Snakes = makeSnakes(sizeOfOneSide);
	}

	public Integer tryGetSnakeTailWithHeadAt(int square) {
	    return m_Snakes.get(square);
	}

	public int getLastSquare() {
		return m_LastSquare;
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
