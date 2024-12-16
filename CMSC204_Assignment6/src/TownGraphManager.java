import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;

/**
 * The TownGraphManager class manages a graph of towns and roads
 */
public class TownGraphManager implements TownGraphManagerInterface {

	Graph graph;
	
	/**
     * No Arg Constructor
     * Initializes a new Graph instance.
     */
	public TownGraphManager() {
		this.graph = new Graph();
	}
	
	
	/**
     * Adds a road between two towns with a specified weight and name.
     *
     * @param town1    the name of the first town
     * @param town2    the name of the second town
     * @param weight   the weight of the road (distance or cost)
     * @param roadName the name of the road
     * @return true if the road was successfully added, false otherwise
     */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		
		graph.addVertex(t1);
		graph.addVertex(t2);
		
		if(!graph.containsEdge(t1, t2)) {
			graph.addEdge(t1, t2, weight, roadName);
			return true;
		}
		
		return false;
	}

	
	 /**
     * Retrieves the name of the road connecting two towns.
     *
     * @param town1 the name of the first town
     * @param town2 the name of the second town
     * @return the name of the road connecting the towns, or null if no such road exists
     */
	@Override
	public String getRoad(String town1, String town2) {
		
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		Road r = graph.getEdge(t1, t2);
		return r.getName();
	}

	
	/**
     * Adds a new town to the graph.
     *
     * @param v the name of the town to be added
     * @return true if the town was successfully added, false otherwise
     */
	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}

	
	 /**
     * Retrieves a town by its name.
     *
     * @param name the name of the town
     * @return the Town object representing the town
     */
	@Override
	public Town getTown(String name) {
		Town t = new Town(name);
		graph.addVertex(t);
		return t;
	}

	
	/**
     * Checks if a town exists in the graph.
     *
     * @param v the name of the town
     * @return true if the town exists, false otherwise
     */
	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));
	}

	
	 /**
     * Checks if a road connection exists between two towns.
     *
     * @param town1 the name of the first town
     * @param town2 the name of the second town
     * @return true if the road exists, false otherwise
     */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		
		return graph.containsEdge(t1, t2);
	}

	
	 /**
     * Retrieves a list of all road names in the graph.
     *
     * @return an ArrayList of road names
     */
	@Override
	public ArrayList<String> allRoads() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> allRoads = new ArrayList<>();
		
		for (Road road : roads) {
			allRoads.add(road.getName());
		}
		return allRoads;
	}

	
	 /**
     * Deletes a road connection between two towns.
     *
     * @param town1 the name of the first town
     * @param town2 the name of the second town
     * @param road  the name of the road
     * @return true if the road was successfully deleted, false otherwise
     */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		Road r = graph.getEdge(t1, t1);
		
		if (r != null) {
			graph.removeEdge(t1, t2, r.getWeight(), road);
			return true;
		}

		return false;
	}

	
	/**
     * Deletes a town from the graph.
     *
     * @param v the name of the town to be deleted
     * @return true if the town was successfully deleted, false otherwise
     */
	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(new Town(v));
	}

	
	/**
     * Retrieves a sorted list of all town names in the graph.
     *
     * @return an ArrayList of town names
     */
	@Override
	public ArrayList<String> allTowns() {
		
		Set<Town> towns = graph.vertexSet();
		ArrayList<String> allTowns = new ArrayList<>();
		
		for (Town town : towns) {
			allTowns.add(town.getName());
		}
		
		Collections.sort(allTowns);
		return allTowns;
	}

	
	/**
     * Retrieves the shortest path between two towns.
     *
     * @param town1 the name of the source town
     * @param town2 the name of the destination town
     * @return an ArrayList of strings representing the path
     */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return graph.shortestPath(new Town(town1), new Town(town2));
	}

	
	/**
     * Populates the graph with towns and roads from a file.
     *
     * @param selectedFile the file containing town and road data
     * @throws IOException if the file cannot be read
     */
	public void populateTownGraph(File selectedFile) throws IOException{
		
		try (Scanner inputFile = new Scanner(selectedFile)) {
			
			while(inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				String[] parts = line.split(";");
				String[] roadInfo = parts[0].split(",");
				
				Town t1 = new Town(parts[1]);
				Town t2 = new Town(parts[2]);
				graph.addVertex(t1);
				graph.addVertex(t2);
				
				graph.addEdge(t1, t2, Integer.parseInt(roadInfo[1]), roadInfo[0]);
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}

}
