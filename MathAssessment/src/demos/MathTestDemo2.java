package demos;

import mathTest.MathTest2;

public class MathTestDemo2 {
	public static void main(String[] args) {
		int depth = 2;
		int width = 8;
		MathTest2 jambox = new MathTest2(depth, width);
		jambox.printProblems();
		
		jambox.printStructure();
	}
}
