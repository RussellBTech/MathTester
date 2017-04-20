package graphs;

import java.util.Iterator;

public class MatrixGraph extends AbstractGraph {

	double[][] edges;

	@SuppressWarnings("unused")
	private class Iter<E> implements Iterator<E> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	public MatrixGraph(int numV, boolean directed) {
		super(numV, directed);
		edges = new double[numV][];
		for(int i = 0; i <= numV; i++) {
			for(int k = 0; k <= numV; k++) {
				edges[i][k] = 0.0;
			}
		}
	}

	public void insert(Edge edge) {
		edges[edge.getSource()][edge.getDest()] = 1.0;
	}

	public boolean isEdge(int source, int dest) {
		return edges[source][dest] == 1.0;
	}

	public Edge getEdge(int source, int dest) {
		Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
		if(edges[source][dest] == 1.0) {
			Edge edge = new Edge(source, dest);
			return edge;
		} else {
			return target;
		}
	}

	public Iterator<Edge> edgeIterator(int source) {
		// TODO Auto-generated method stub
		return null;
	}
}