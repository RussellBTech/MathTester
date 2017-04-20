package demos;

import mathTest.MathTest2;

public class MathTestDemo {
	public static void main(String[] args) {
		//int size, int width, int difficulty
		MathTest2 jambox = new MathTest2(3, 4);
		jambox.printProblems();
		
		jambox.printStructure();
	}
}
