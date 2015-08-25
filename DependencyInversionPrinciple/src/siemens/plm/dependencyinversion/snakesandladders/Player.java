package siemens.plm.dependencyinversion.snakesandladders;

public class Player {
	private String name;
	private int currentSquare;
	
	public Player(String name) {
		this.name = name;
		currentSquare = 0;
	}
	
	public String getName() {
	    return name;
	}

	public void setSquare(int newPosition) {
	    currentSquare = newPosition;
	}

	public int getSquare() {
	    return currentSquare;
	}
}
