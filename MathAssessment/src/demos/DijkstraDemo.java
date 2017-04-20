package demos;

import graphs.Dijkstra;
import mathTest.MathTest2;

public class DijkstraDemo {

	public static void main(String[] args) {
		
		
		int[] pred = new int[20];
		double[] dist = new double[20];
		MathTest2 test = new MathTest2(3, 5);
		System.out.println(test.getStructure().toString());
		int testLoc = 6;
		Dijkstra.dijkstrasAlgorithm(test.getStructure(), testLoc, pred, dist);
		
		System.out.println("v      d[v]    \t  p[v]");
		System.out.println("------------------------------");
		for(int i = 0; i < 15; i++){
			if(i != testLoc) {
				System.out.println(i + "\t" + dist[i] + "\t  " + pred[i]);
			}
		}
		
		System.out.println("\nOur current location is: " + testLoc);
		System.out.println("\nIf we got it right: " + test.moveTowardsGoal(testLoc));
		System.out.println("If we got it wrong: " + test.failForward(testLoc));
	}
}
