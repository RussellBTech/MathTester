package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListGraph extends AbstractGraph {

	private List<Edge>[] edges;

	/**
	 * Constructor with specified number of vertices and
	 * direction
	 * @param numV - number of vertices
	 * @param directed - directed or not
	 */
	@SuppressWarnings("unchecked")
	public ListGraph(int numV, boolean directed) {
		super(numV, directed);
		edges = new List[numV];

		for (int i = 0; i < numV; i++) {
			edges[i] = new LinkedList<Edge>();
		}
	}

	/**
	 * inserts a new edge into graph
	 * @param edge - the new edge
	 */
	public void insert(Edge edge) {

		edges[edge.getSource()].add(edge);
		if (!isDirected()) {
			edges[edge.getDest()].add(new Edge(edge.getDest(), edge.getSource(), edge.getWeight()));
		}
	}

	/**
	 * whether edge exists or not
	 * @param source - source vertex
	 * @param dest - destination vertex
	 * @return - true if edge exists
	 */
	public boolean isEdge(int source, int dest) {
		return edges[source].contains(new Edge(source, dest));
	}

	/**
	 * gets the edge between two vertices.  
	 * @param source - source vertex
	 * @param dest - destination vertex
	 * @return edge between the two vertices
	 */
	public Edge getEdge(int source, int dest) {
		Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
		for (Edge edge : edges[source]) {
			if (edge.equals(target)) {
				return edge;
			}
		}
		return target;
	}

	/**
	 * returns an iterator to the edges connected to given
	 * vertex
	 * @param source - source vertex
	 * @return - Iterator<Edge> to vertex
	 */
	public Iterator<Edge> edgeIterator(int source) {
		return edges[source].iterator();
	}
	
	/**
	 * returns string of the edges and vertices for graph
	 * @return - string 
	 */
	public String toString() {
		StringBuilder graph = new StringBuilder();
		
		Edge e;
		
		for(int i = 0; i < edges.length; i++) {
			Iterator<Edge> iter = edgeIterator(i);
			while(iter.hasNext()) {
				e = iter.next();
				graph.append(e.toString());
				graph.append(" " + e.getWeight() + "\n");
			}
			graph.append("=========================\n");
		}
		return graph.toString();
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		ListGraph lg = new ListGraph(5, true);
		Edge zeroOne = new Edge(0, 1, 10);
		Edge zeroThree = new Edge(0, 3, 30);
		Edge zeroFour = new Edge(0, 4, 100);
		Edge oneTwo = new Edge(1, 2, 50);
		Edge twoFour = new Edge(2, 4, 10);
		Edge threeTwo = new Edge(3, 2, 20);
		Edge threeFour = new Edge(3, 4, 60);
		
		lg.insert(zeroOne);
		lg.insert(zeroThree);
		lg.insert(zeroFour);
		lg.insert(oneTwo);
		lg.insert(twoFour);
		lg.insert(threeTwo);
		lg.insert(threeFour);
		
		Edge e;
		
		Iterator<Edge> iter = lg.edgeIterator(0);
		while(iter.hasNext()) {
			e = iter.next();
			System.out.print(e.toString());
			System.out.println(" " + e.getWeight());
		}
		
		System.out.println("=========================");
		
		Iterator<Edge> iter1 = lg.edgeIterator(1);
		while(iter1.hasNext()) {
			e = iter1.next();
			System.out.print(e.toString());
			System.out.println(" " + e.getWeight());
		}
		
		System.out.println("=========================");
		
		Iterator<Edge> iter2 = lg.edgeIterator(2);
		while(iter2.hasNext()) {
			e = iter2.next();
			System.out.print(e.toString());
			System.out.println(" " + e.getWeight());
		}
		
		System.out.println("=========================");
		
		Iterator<Edge> iter3 = lg.edgeIterator(3);
		while(iter3.hasNext()) {
			e = iter3.next();
			System.out.print(e.toString());
			System.out.println(" " + e.getWeight());
		}
		
		System.out.println("=========================");
		System.out.println("");
		Dijkstra d = new Dijkstra();
		int[] pred = new int[10];
		double[] dist = new double[10];
		
		d.dijkstrasAlgorithm(lg, 0, pred, dist);
		
		System.out.println("v      d[v]      p[v]");
		System.out.println("----------------------");
		for(int i = 1; i < 5; i++){
			
			System.out.println(i + "      " + dist[i] + "       " + pred[i]);
		}
	}
}




