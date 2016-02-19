# DependencyInversionPrincipleJava
An exercise on the dependency inversion principle, for a Java / Eclipse environment.
Based on Java 1.8, JUnit 4 and Eclipse 4.5.0.

This exercise is based on the popular board game of snakes and ladders, which you can read up about here <https://en.wikipedia.org/wiki/Snakes_and_Ladders>, although, to keep things more simple, this version has only 
snakes and no ladders. You should make sure you're familiar with the rules. Here's a clear, succinct version: <http://www.ehow.com/facts_5163203_snakes-amp-ladders-rules.html>.

## Getting started

1. Clone the repository, checking out the master branch (this is the default) 
2. Open Eclipse
3. Set the Eclipse workspace at the root directory of the repository
4. Run the JUnit tests in `siemens.plm.dependencyinversion.snakesandladders.tests`  
5. Have a look at the code in `siemens.plm.dependencyinversion.snakesandladders` as indicated below:

# Code that doesn't adhere to the Dependency Inversion Principle

In `siemens.plm.dependencyinversion.snakesandladders.consolebasedgame`, there's an version of the game you and run on a console and play. It has a simple implementation of `main()` in `ConsoleBasedGame.java`.

In `siemens.plm.dependencyinversion.snakesandladders`, there's an implementation of the game that doesn't adhere to the Dependency Inversion Principle. It has the following classes:

| Class | Description |
|-------|-------------|
| Board | A board, with 100 squares and snakes added randomly |
| Die | A  die that gives random numbers from 1 to 6 |
| Player | Represents a player on the board |
| SnakesAndLadders | The game itself. It has one method, play, that interacts with the console as you play the game |
| Move | Has the responsibility for moving a player a given number of players forward on the board. It takes care of landing on snakes and overshooting the end of the board |
| MoveOutcome | A class the describes what happened to the player during the move |
| MoveOutcomeBuilder | A utility class used during to player's move to build MoveOutcome objects |
| SnakesAndLadders | The game itself. It has two methods, Play and IsFinished |


There are no tests for `siemens.plm.dependencyinversion.snakesandladders`, but there is a project, `siemens.plm.dependencyinversion.snakesandladders.tests`, 
which is already set up for writing acceptance tests on the game. 

## Task 1
Your task is to write a test to prove that, given a move that overshoots the end of the board by one, the player ends up on the square before the last one. 
If you look in `siemens.plm.dependencyinversion.snakesandladders.AcceptanceTests.java`, you'll find test case declaration that just needs completing.

```
public class AcceptanceTests {
	@Test
	public void givenAPlayerOnSquare97_WhenTheyMove3_TheyShouldEndUpOnSquare98() {
	}
}
```

# Task 2
Now write a test to prove that, given a move that lands a player on snake, that they end up at the bottom of the snake.

```
	@Test
	public void givenASnakeFromSquare2To1_WhenAPlayerMovesOnToSquare2_TheyShouldEndUpOnSquare1() {
	}
```
 
# Task 3
The next task is to write a test to prove that the game ends when a player reaches the last square on the board. Note that you are now testing SnakesAndLadders, and so you need a new test suite. The test case should look something like this;

```
	@Test
	public void whenAPlayerLandsOnTheLastSquare_TheGameShouldEnd() {
	}
```

# Task 4

Your last task is to prove that when a player throws the die, they move the number of squares shown. 
You test could be something like this.  
 
```
	@Test
	public void givenAPlayersThrowMissesAnySnakesAndDoesntReachTheEndOfTheBoard_WhenAPlayerMoves_TheyShouldMoveForwardTheNumberOfSquaresThrown() {
	}
```

# Code that adheres rather more to the Dependency Inversion Principle

Now chck out the branch, DependencyInversion

In `siemens.plm.dependencyinversion.snakesandladders`:

| Class | Description |
|-------|-------------|
| `IBoard` | An abstract interface to the board |
| `Board` | An actual board, with 100 squares and snakes added randomly |
| `IDie` | An abstract represntation of the die |
| `Die` | A concrete die that gives random numbers from 1 to 6 |
| `Player` | Represents a player on the board |
| `SnakesAndLadders` | The game itself. It has one method, play, that interacts with the console as you play the game |
| `Move` | Has the responsibility for moving a player a given number of players forward on the board. It takes care of landing on snakes and overshooting the end of the board |
| `MoveOutcome` | A class the describes what happened to the player during the move |
| `MoveOutcomeBuilder` | A utility class used during to player's move to build MoveOutcome objects |
| `SnakesAndLadders` | The game itself. It has one method, play, that interacts with the console as you play the game |

Now repeat tasks 1-4, this writing the test tests, but starting with the code that adheres more to the dependency inversion  principle.