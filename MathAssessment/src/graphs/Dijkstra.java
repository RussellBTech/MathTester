package graphs;

import java.util.HashSet;
import java.util.Iterator;

public class Dijkstra {
	
	/**
	 * Dijkstra's Shortest-Path algorithm
	 * @param graph - weighted graph to be searched
	 * @param start - start vertex
	 * @param pred - array to contain the predecessors in the shortest path
	 * @param dist - array to contain the distance in the shortest path
	 */
	public static void dijkstrasAlgorithm(Graph graph, int start, int[] pred, double[] dist) {
		
		int numV = graph.getNumV();
		HashSet<Integer> vMinusS = new HashSet<Integer>(numV);
		for(int i = 0; i < numV; i++) {
			if(i != start) {
				vMinusS.add(i);
			}
		}
		
		for(int v : vMinusS) {
			pred[v] = start;
			dist[v] = graph.getEdge(start, v).getWeight();
		}
		
		while(vMinusS.size() != 0) {
			double minDist = Double.POSITIVE_INFINITY;
			int u = -1;
			for(int v : vMinusS) {
				if(dist[v] < minDist) {
					minDist = dist[v];
					u = v;
				}
			}
			
			if(u != -1) {
				vMinusS.remove(u);
				Iterator<Edge> edgeIter = graph.edgeIterator(u);
				while(edgeIter.hasNext()) {
					Edge edge = edgeIter.next();
					int v = edge.getDest();
					if(vMinusS.contains(new Integer(v))) {
						double weight = edge.getWeight();
						if(dist[u] + weight < dist[v]) {
							dist[v] = dist[u] + weight;
							pred[v] = u;
						}
					}
				}
			} else {
				vMinusS.removeAll(vMinusS);
			}
			/**
			 * FOR MATRIX GRAPH!!!!!!
			 */
/*			
			for(int v : vMinusS) {
				if(graph.isEdge(u,  v)) {
					double weight = graph.getEdge(u,  v).getWeight();
					if(dist[u] + weight < dist[v]) {
						dist[v] = dist[u] + weight;
						pred[v] = u;
					}
				}
			}
*/
		}
	}
}
