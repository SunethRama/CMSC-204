import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
/**
 * Implementation of a Graph using an adjacency list.
 * This graph represents vertices as Town objects and edges as Road objects.
 *
 * @param <Town> the type of vertices in the graph
 * @param <Road> the type of edges in the graph
 */
public class Graph implements GraphInterface<Town, Road>{

	private HashMap<Town, LinkedList<Road>> graph;
	private HashMap<Town, Integer> weights;
	private Map<Town, Town> predecessors;

	
	/**
     * No Arg constructor
     */
	public Graph() {
		graph = new HashMap<>();
		weights = new HashMap<>();
	
	}
	
	
	 /**
     * Retrieves the Road connecting two Towns, if it exists.
     *
     * @param sourceVertex      the source Town
     * @param destinationVertex the destination Town
     * @return the Road connecting the Towns, or null if no such Road exists
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
	
	    if (sourceVertex == null || destinationVertex == null) {
	        return null; 
	    }

	    LinkedList<Road> roadList = graph.get(sourceVertex);
	    if (roadList == null) {
	        return null; 
	    }

	    for (Road road : roadList) {
	        if (road.getDestination().equals(destinationVertex) || road.getSource().equals(destinationVertex)) {
	            return road; 
	        }
	    }
	    return null;
	}


	/**
     * Adds a Road connecting two Towns to the graph.
     *
     * @param sourceVertex      the source Town
     * @param destinationVertex the destination Town
     * @param weight            the weight of the Road
     * @param description       the description of the Road
     * @return the added Road
     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
	
		if (sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		
		if (!graph.containsKey(sourceVertex)|| !graph.containsKey(destinationVertex)) {
			throw new IllegalArgumentException();
		}
		
		sourceVertex.addAdjacentTowns(destinationVertex);
		Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
		graph.get(sourceVertex).add(newRoad);
		graph.get(destinationVertex).add(newRoad);
		
		return null;
	}

	

    /**
     * Adds a Town to the graph.
     *
     * @param v the Town to add
     * @return true if the Town was added, false if it already exists
     */
	@Override
	public boolean addVertex(Town v) {
		if (v == null) {
			throw new NullPointerException();
		}
		
		if (graph.containsKey(v)) {
			return false;
		}
		
		graph.put(v, new LinkedList<Road>());
		return true;
	}

	
	/**
     * Checks if a Road exists between two Towns.
     *
     * @param sourceVertex      the source Town
     * @param destinationVertex the destination Town
     * @return true if a Road exists, false otherwise
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		
		if (sourceVertex == null || destinationVertex == null) {
		        return false; 
		}
		 
	    LinkedList<Road> roadList = graph.get(sourceVertex);
	    if (roadList == null) {
	        return false; 
	    }

	    for (Road road : roadList) {
	        if (road.getDestination().equals(destinationVertex) || road.getSource().equals(destinationVertex)) {
	            return true; 
	        }
	    }
	    return false;
	}

	
	 /**
     * Checks if a Town exists in the graph.
     *
     * @param v the Town to check
     * @return true if the Town exists, false otherwise
     */
	@Override
	public boolean containsVertex(Town v) {
		return graph.containsKey(v);
	}

	
	 /**
     * Retrieves all Roads in the graph.
     *
     * @return a set of all Roads
     */
	@Override
	public Set<Road> edgeSet() {
		Set<Road> edgeSet = new TreeSet<>();
		
		for (LinkedList<Road> r : graph.values()) {
			edgeSet.addAll(r);
		}
		return edgeSet;
	}

	
	 /**
     * Retrieves all Roads connected to a given Town.
     *
     * @param vertex the Town
     * @return a set of Roads connected to the Town
     */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		
		Set<Road> edgeSet = new TreeSet<Road>();
		LinkedList<Road> roadList = graph.get(vertex);
	   
	    for (Road road : roadList) {
	    	edgeSet.add(road);
	    }
	    return edgeSet;
	}

	
	/**
     * Removes a Road from the graph.
     *
     * @param sourceVertex      the source Town
     * @param destinationVertex the destination Town
     * @param weight            the weight of the Road
     * @param description       the description of the Road
     * @return the removed Road
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (sourceVertex == null || destinationVertex == null ||
				weight< -1 || description == null)
			return null;
		
		Road roadToRemove = new Road(sourceVertex, destinationVertex, weight, description);
		if (graph.get(sourceVertex).contains(roadToRemove)&&
				graph.get(destinationVertex).contains(roadToRemove)) {
			graph.get(sourceVertex).remove(roadToRemove);
			graph.get(destinationVertex).remove(roadToRemove);
		}
		return null;
	}

	
	/**
     * Removes a Town from the graph.
     *
     * @param v the Town to remove
     * @return true if the Town was removed, false otherwise
     */
	@Override
	public boolean removeVertex(Town v) {
		
		if (v == null)
			return false;
		
		if (!graph.containsKey(v))
			return false;
		
		for (Town t : graph.keySet()) {
			if (t.getAdjacentTown().contains(v)) {
				t.getAdjacentTown().remove(v);
			}
		}
		graph.remove(v);
		return true;
	}

	
	 /**
     * Retrieves all Towns in the graph.
     *
     * @return a set of all Towns
     */
	@Override
	public Set<Town> vertexSet() {
		return graph.keySet();
	}
	
	
	 /**
     * Implements Dijkstra's algorithm to calculate shortest paths from a source Town.
     *
     * @param sourceVertex the source Town
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		
		Set<Town> keySet = graph.keySet();
		
		HashMap<Town, Integer> weights = new HashMap<>();
		Set <Town> visited = new HashSet<>();
		Map<Town, Town> predecessors = new HashMap<>();

		for (Town t : keySet) {
			if (!t.equals(sourceVertex)) {
				weights.put(t,Integer.MAX_VALUE);
			}
		}
		
		weights.put(sourceVertex, 0);

		while (visited.size() < graph.size()) {
			Town selectedVertex = getMinimum(weights, visited);
			
			if (selectedVertex == null) {
				break;
			}
			
			visited.add(selectedVertex);
			
			for (Road road : graph.get(selectedVertex)) {
				
				Town adjacentTown = null;
				
				if (road.getDestination().equals(selectedVertex)) {
					adjacentTown = road.getSource();
				}
				else
					adjacentTown = road.getDestination();
				
				if (!visited.contains(adjacentTown)) {
					int newWeight = weights.get(selectedVertex) + road.getWeight();
					
					if (newWeight < weights.get(adjacentTown)) {
						weights.put(adjacentTown, newWeight);
						predecessors.put(adjacentTown, selectedVertex);
					}
				}
				
			}
		}
		
		this.weights = weights;
		this.predecessors = predecessors;
	}
	
	/**
	 * Find the next vertex for the shortest path algorithm
	 * 
	 * @param weights set of weights
	 * @param visited set of visited vertices
	 * @return the vertex with the minimum weight
	 */
	private Town getMinimum(Map<Town, Integer> weights, Set<Town> visited) {
		
		Town selectedVertex = null;
		int min = Integer.MAX_VALUE;
		
		for (Entry<Town, Integer> entry : weights.entrySet()) {
			if (!visited.contains(entry.getKey())&&entry.getValue()<min) {
				min = entry.getValue();
				selectedVertex = entry.getKey();
			}
		}
		return selectedVertex;
		
	}
	
	
	 /**
     * Retrieves the shortest path from a source Town to a destination Town.
     *
     * @param sourceVertex      the source Town
     * @param destinationVertex the destination Town
     * @return a list of strings describing the shortest path
     */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		if (weights == null || predecessors == null) {
	        dijkstraShortestPath(sourceVertex);
	    }

	    ArrayList<String> path = new ArrayList<>();
	    Town current = destinationVertex;

	    while (!current.equals(sourceVertex)) {
	        Town predecessor = predecessors.get(current);
	        if (predecessor == null) {
	            return path;
	        }

	        Road road = getEdge(predecessor, current);
	        path.add(0, String.format("%s via %s to %s %d mi",
	            predecessor.toString(),
	            road.getName(),
	            current.toString(),
	            road.getWeight()
	        ));
	        current = predecessor;
	    }

	    return path;
	}
	
}
