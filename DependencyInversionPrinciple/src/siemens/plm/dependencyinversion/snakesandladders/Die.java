package siemens.plm.dependencyinversion.snakesandladders;

import java.util.Random;

public class Die {
	 private static Random random = new Random();
	 
	 static { 
		 random.setSeed(System.currentTimeMillis());
	 }
	 
	 public static int getThrow() {
		 return random.nextInt(6) + 1;
	 }
}
