package graphs;

import java.util.*;

public interface Graph {

	/**
	 * return number of vertices
	 * @return - number of vertices
	 */
	int getNumV();

	/**
	 * whether graph is directed or not
	 * @return - true if directed
	 */
	boolean isDirected();

	/**
	 * insert a new edge on the graph
	 * @param edge - new edge
	 */
	void insert(Edge edge);

	/**
	 * whether edge exists
	 * @param source - source vertex
	 * @param dest - destination vertex
	 * @return - true if edge exists
	 */
	boolean isEdge(int source, int dest);

	/**
	 * edge between two vertices
	 * @param source - source vertex
	 * @param dest - destination vertex
	 * @return - the Edge between vertices
	 */
	Edge getEdge(int source, int dest);

	/**
	 * iterator to the edges connected to given vertex
	 * @param source - source vertex
	 * @return - An Iterator<Edge> to vertices connected 
	 */
	Iterator<Edge> edgeIterator(int source);

}