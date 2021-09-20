package pira_exercice.java_Junit01;

public class MyClass {
	
	public int multiply(int x, int y) {
		if(x > 999) {
			throw new IllegalArgumentException("X should be lass ore than 1000");
		}
		
		return x*y;
	}
	


}
