package mathTest;

import java.util.Iterator;

import graphs.Dijkstra;
import graphs.Edge;
import graphs.ListGraph;
import problems.AdditionArithmeticProblem;
import problems.MathProblem;
import problems.SubtractionArithmeticProblem;

public class MathTest2 {
	
	MathProblem[] problemVertices;
	ListGraph graph;
	int desiredDestination;
	int size;
	int width;
	int depth;
	double[] distances;
	int[] predecessors;
	
	
	/**
	 * Overloaded constructors will allow us to create
	 * many different types of MathTests
	 * @param size
	 * @pre width must be a divisor of size
	 * @pre startingDifficulty must be at least one greater than width
	 */
	public MathTest2(int depth, int width) {
		int size = depth * width;
		problemVertices = new MathProblem[size];
		graph = new ListGraph(size, true);
		desiredDestination = size - width;
		this.size = size;
		this.depth = depth;
		this.width = width;
		distances = new double[size];
		predecessors = new int[size];
		
		int numberOfOperations = width + 1;
		int i;
		for(i = 0; i < width * (depth / 2); i++) {
			problemVertices[i] = new AdditionArithmeticProblem(30, numberOfOperations);
			numberOfOperations--;
		}
		numberOfOperations = width + 1;
		
		for( ; i < size; i++) {
			if(problemVertices[i] == null) {
				problemVertices[i] = new SubtractionArithmeticProblem(25, numberOfOperations);
				numberOfOperations--;
			}
		}
		
		int h = 1;
		int weight = 0;
		
		for(i = 0; i < size; i++) {
			weight = weight * 2;
			
			if(i == 0) {
				weight = 2;
				graph.insert(new Edge(i, i + 1, 2));
				if(h < depth) {
					graph.insert(new Edge(i, i + (width), 1));
				}
			} else if((i % width == 0)){
				h++;
				weight = 2;
				graph.insert(new Edge(i, i + 1, weight));
				if(h < depth) {
					graph.insert(new Edge(i, i + (width), 1));
				}
			} else if((i + 1) % width == 0) {
				
				graph.insert(new Edge(i, i - 1, weight/2));
				if(h < depth){
					graph.insert(new Edge(i, i + (width - 1), 3));
				}
					
			} else if (i % width != 0) {
				graph.insert(new Edge(i, i + 1, weight));
				graph.insert(new Edge(i, i - 1, weight/2));
				if(h < depth) {
					graph.insert(new Edge(i, i + (width - 1), 3));
				}
				
			} else {
				System.out.println("Error");
			}
		}
	}
	
	public void printProblems() {
		int i = 0;
		for(MathProblem problem: problemVertices) {
			System.out.println("Problem @ vertex " + i + "\n" + problem.toString());
			i++;
		}
	}
	
	public String getEquation(int i) {
		if(i < size) {
			return problemVertices[i].getEquation();
		}
		return "Invalid index.";
	}
	
	public String getAnswer(int i) {
		if(i < size) {
			return problemVertices[i]. getAnswer();
		}
		return "Invalid index.";
	}
	
	public ListGraph getStructure() {
		return graph;
	}
	
	public int getDesiredDestination() {
		return desiredDestination;
	}
	
	public void printStructure() {
		System.out.println(graph.toString());
	}
	
	public static void main(String[] args) {
		//int size, int width, int difficulty
		MathTest2 jambox = new MathTest2(3, 4);
		jambox.printProblems();
		
		jambox.printStructure();
	}

	public int moveTowardsGoal(int testLocation) {
		int newTestLocation = desiredDestination;
		Dijkstra.dijkstrasAlgorithm(graph, testLocation, predecessors, distances);
		boolean done = false;
		while(!done){
			if(predecessors[newTestLocation] == testLocation) {
				return desiredDestination;
			}
			newTestLocation = predecessors[newTestLocation];
			
			if(predecessors[newTestLocation] == testLocation) {
				done = true;
			}
		}
		
		return newTestLocation;
	}

	public int failForward(int testLocation) {
		if (((testLocation + 1) % width == 0) && (testLocation + width - 1 < size)) {
			return testLocation + width - 1;
		} else if((testLocation + 1) % width == 0) {
			return -1;
		} else {
			Iterator<Edge> it = getStructure().edgeIterator(testLocation);
			double largest = 0;
			int dest = -1;
			while(it.hasNext()) {
				Edge edge = it.next();
				double temp = edge.getWeight();
				if(temp > largest) {
					largest = temp;
					dest = edge.getDest();
				}
			}
			return dest;
		}
	}
}