package siemens.plm.dependencyinversion.snakesandladdersdependencyinversion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import siemens.plm.dependencyinversion.snakesandladders.Player;

public class SnakesAndLadders implements ISnakesAndLadders {

	private IBoard board;
	private IDie die;
	private Player[] players;
	private Move move;
    private Scanner consoleReader = new Scanner(System.in);

	private static Map<Integer, String> numbers = new HashMap<Integer, String>();
	static {
		numbers.put(1, "one");
		numbers.put(2, "two");
		numbers.put(3, "three");
		numbers.put(4, "four");
		numbers.put(5, "five");
		numbers.put(6, "six");
	}

	public SnakesAndLadders(IBoard board, IDie die, List<String> players)
	{
		this.board = board;
		this.die = die;
		this.move = new Move(board);
		this.players = players.stream()
				.map(name -> new Player(name))
				.collect(Collectors.toList())
				.toArray(new Player[] {});
	}
	
	@Override
	public void play() {
		System.out.println("Let's start");
	    for (int playerIndex = 0;
	        players[playerIndex].getSquare() != board.getLastSquare();
	        playerIndex = ++playerIndex % players.length) {
	    	
	        Player player = players[playerIndex];
			System.out.printf("Ok, %s to go next. Press any key to continue.\n", player.getName());
			consoleReader.nextLine();

	        int thrown = die.getThrow();
			System.out.printf("%s has thrown a %d\n", player.getName(), thrown);
	        printMoving(thrown);

	        MoveOutcome outcome= move.execute(player.getSquare(), thrown);
	        printMove(outcome);
	        player.setSquare(outcome.getSquareAtEndOfMove());
	    } 

		System.out.println("You've won!");
	}
	
	private void printMoving(int count) {
		System.out.print("Moving... ");
		for (int i = 1; i <= count; ++i) {
			System.out.printf("%s... ", numbers.get(i));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("");
	}
	
	void printMove(MoveOutcome outcome)
	{
	    if (outcome.isOvershot())
	    {
			System.out.println("Bad luck - you overshot the end!");
	    }
		System.out.printf("You're now on %d\n", outcome.getSquareAtEndOfDiceCount());

	    if (outcome.didHitSnake())
	    {
			System.out.println("Oh no, you've landed on a snake. Down you go!");
			System.out.printf("You're now on %d\n", outcome.getSquareAtEndOfMove());
	    }
	}
}