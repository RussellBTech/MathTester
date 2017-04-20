package mathTest;

import java.util.HashSet;

import graphs.Edge;
import graphs.ListGraph;
import problems.AdditionArithmeticProblem;
import problems.MathProblem;
import problems.SubtractionArithmeticProblem;

public class MathTest {
	MathProblem[] problemVertices;
	ListGraph testStructure;
	int desiredDestination;
	int size;
	
	/**
	 * Overloaded constructors will allow us to create
	 * many different types of MathTests
	 * @param size
	 * @pre width must be a divisor of size
	 * @pre startingDifficulty must be at least one greater than width
	 */
	public MathTest(int size, int width, int startingDifficulty) {
		problemVertices = new MathProblem[size];
		testStructure = new ListGraph(size, true);
		desiredDestination = size - width;
		this.size = size;
		
		
		
		if(size % width != 0) {
			System.out.println("Width must be a factor of size.");
			System.exit(1);
		}
		int i = 0;
		int numberOfOperations = startingDifficulty;
		for(i = 0; i < width; i++) {
			problemVertices[i] = new AdditionArithmeticProblem(30, numberOfOperations);
			numberOfOperations--;
		}
		
		numberOfOperations = startingDifficulty;
		for( ; i < size; i++) {
			problemVertices[i] = new SubtractionArithmeticProblem(25, numberOfOperations);
			numberOfOperations--;
		}
		int widthLocation = 0;
		for(i = 0; i < size; i++) {
			
			if((i + 1) % width != 0) {
				int widLocModifier = 1;
				if(i % width != 0) {
					widLocModifier = i;
				}
				testStructure.insert(new Edge(i, i + 1, widLocModifier * 2));
			}
			
			if((i + width) % width != 0 && (i + width) - 1 < size) {
				testStructure.insert(new Edge(i, i + width - 1, 3));
			}
			
			if((i > width) && (i % width != 0)) {
				testStructure.insert(new Edge(i, i - 1, widthLocation * 2));
			}
			
			if((i == 0 || i % width == 0) && (i + width) % width == 0 && i + width < size) {
				testStructure.insert(new Edge(i, i + width, 1));
			}
			widthLocation = (widthLocation + 1) % width;
		}
	}
	
	public void printProblems() {
		int i = 0;
		for(MathProblem problem: problemVertices) {
			System.out.println("Problem @ node " + i + "\n" + problem.toString());
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
		return testStructure;
	}
	
	public int getDesiredDestination() {
		return desiredDestination;
	}
	
	public void printStructure() {
		System.out.println(testStructure.toString());
	}
	
	public static void main(String[] args) {
		MathTest jambox = new MathTest(4, 2, 3);
		jambox.printProblems();
		
		jambox.printStructure();
	}
	
	public int getNextVertex() {
		return 0;
	}
}
