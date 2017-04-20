package graphs;

import java.util.Scanner;

public abstract class AbstractGraph implements Graph {

	private int numV;
	private boolean directed;
	
	/**
	 * Contructor for graph
	 * @param numV - number of vertices
	 * @param directed - is directed or not
	 */
	public AbstractGraph(int numV, boolean directed) {
		this.numV = numV;
		this.directed = directed;
	}
	
	/**
	 * return number of vertices
	 * @return - the number of vertices
	 */
	public int getNumV() {
		return numV;
	}

	/**
	 * return whether directed graph or not
	 * @return true if this is a directed graph
	 */
	public boolean isDirected() {
		return directed;
	}

	/**
	 * 
	 * @param scan
	 */
	public void loadEdgesFromFile(Scanner scan) {

	}

	/**
	 * Create a graph and load the data from an input file.
	 * The first line of the input file should contain the number 
	 * of vertices.  Remaining lines contain the edge data.
	 * @param scan - Scanner connected to file
	 * @param isDirected - true if this is a directed graph
	 * @param type - Matrix or List to be created
	 * @return - graph
	 */
	public static Graph createGraph(Scanner scan, boolean isDirected, String type) {

		int numV = scan.nextInt();
		AbstractGraph returnValue = null;

		if (type.equalsIgnoreCase("Matrix")) {
			returnValue = new MatrixGraph(numV, isDirected);
		} else if (type.equalsIgnoreCase("List")) {
			returnValue = new ListGraph(numV, isDirected);
		} else {
			throw new IllegalArgumentException();
		}
		returnValue.loadEdgesFromFile(scan);
		;
		return returnValue;
	}
}