package graphs;

public class Edge {

	private int dest;
	private int source;
	private double weight;

	/**
	 * Constructor that takes in source vertex and 
	 * destination
	 * @param source - source vertex
	 * @param dest - destination vertex
	 */
	public Edge(int source, int dest) {
		this.dest = dest;
		this.source = source;
		weight = 1.0;
	}

	/**
	 * Constructor that takes in source, destination, and 
	 * the weight of an edge
	 * @param source - source vertex
	 * @param dest - destination vertex
	 * @param w - weight of vertex
	 */
	public Edge(int source, int dest, double w) {
		this.dest = dest;
		this.source = source;
		weight = w;
	}

	/**
	 * Compares two edges for equality.  
	 * Weight is not considered
	 * @param e - edge to be compared
	 * @return - true if equal
	 */
	public boolean equals(Edge e) {
		return ((this.source == e.source) && (this.dest == e.dest)) ? true : false;
	}

	/**
	 * returns destination of vertex
	 * @return - destination
	 */
	public int getDest() {
		return dest;
	}

	/**
	 * returns source of vertex
	 * @return - source of vertex
	 */
	public int getSource() {
		return source;
	}

	/**
	 * return the weight of vertex
	 * @return - weight of vertex
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * return has code for an edge.  
	 * @return - number for hashcode
	 */
	public int hashCode() {
		return dest + source;
	}

	/**
	 * returns a string representation of the edge
	 * @return - string of edge
	 */
	public String toString() {

		String sb;
		sb = ("{" + source + ", " + dest + "}");
		return sb;
	}

	public static void main(String[] args) {

		Edge edge = new Edge('A', 'D');
		Edge edge1 = new Edge('A', 'E');
		Edge edge2 = new Edge('A', 'D');
		System.out.println(edge.toString());
		System.out.println(edge.equals(edge1));
		System.out.println(edge.equals(edge2));
	}
}