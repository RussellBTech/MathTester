package graphs;

import java.util.Iterator;

import mathTest.MathTest;
import mathTest.MathTest2;

public class Testing {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Dijkstra d = new Dijkstra();
		int[] pred = new int[20];
		double[] dist = new double[20];
		MathTest2 test = new MathTest2(3, 5);
		System.out.println(test.getStructure().toString());
		int testLoc = 6;
		d.dijkstrasAlgorithm(test.getStructure(), testLoc, pred, dist);
		
		System.out.println("v      d[v]    \t  p[v]");
		System.out.println("------------------------------");
		for(int i = 0; i < 15; i++){
			if(i != testLoc) {
				System.out.println(i + "\t" + dist[i] + "\t  " + pred[i]);
			}
		}
		
		System.out.println(test.moveTowardsGoal(testLoc));
	}
}
