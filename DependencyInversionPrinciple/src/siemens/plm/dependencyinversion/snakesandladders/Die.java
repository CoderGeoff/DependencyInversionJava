package siemens.plm.dependencyinversion.snakesandladders;

import java.util.Random;

public class Die {
	 private static Random s_Random = new Random();
	 
	 static { 
		 s_Random.setSeed(System.currentTimeMillis());
	 }
	 
	 public static int getThrow() {
		 return s_Random.nextInt(6) + 1;
	 }
}
