package siemens.plm.dependencyinversion.snakesladders;

public class Player {
	private String m_Name;
	private int m_CurrentSquare;
	
	public Player(String name) {
		m_Name = name;
		m_CurrentSquare = 0;
	}
	
	public String getName() {
	    return m_Name;
	}

	public void setSquare(int newPosition) {
	    m_CurrentSquare = newPosition;
	}

	public int getSquare() {
	    return m_CurrentSquare;
	}
}
