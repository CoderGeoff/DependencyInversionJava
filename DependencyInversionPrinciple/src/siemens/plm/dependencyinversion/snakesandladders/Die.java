package siemens.plm.dependencyinversion.snakesandladders;

import java.util.Random;

public class Die implements IDie {

	private static Random random = new Random();
	 
    public Die() {
		 random.setSeed(System.currentTimeMillis());
	}

    @Override
	public int getThrow() {
	    return random.nextInt(6) + 1;
	}

}
