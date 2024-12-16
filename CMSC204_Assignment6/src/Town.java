import java.util.ArrayList;
import java.util.List;

/**
 * Represents a town in a graph.
 */
public class Town implements Comparable<Town>{

	private String name;
	List<Town> adjacentTowns;
	
	
	/**
     * Constructs a Town with the given name.
     *
     * @param name the name of the town
     */
	public Town(String name) {
		this.name = name;
		this.adjacentTowns = new ArrayList<>();
	}
	
	
	/**
     * Copy constructor
     *
     * @param anotherTown the town to copy
     */
	public Town(Town anotherTown) {
		this.name = anotherTown.name;
		this.adjacentTowns = new ArrayList<Town>(anotherTown.adjacentTowns);
	}
	
	
	/**
     * Returns the list of adjacent towns.
     *
     * @return the list of adjacent towns
     */
	public List<Town> getAdjacentTown(){
		return adjacentTowns;
	}
	
	
	/**
     * Adds a town to the list of adjacent towns.
     *
     * @param t the adjacent town to add
     */
	public void addAdjacentTowns(Town t) {
		adjacentTowns.add(t);
	}
	
	
	 /**
     * Returns the name of the town.
     *
     * @return the name of the town
     */
	public String getName() {
		return name;
	}
	
	
	/**
     * Compares this town with another town by their names.
     *
     * @param t the town to compare to
     * @return a negative integer, zero, or a positive integer as this town's name
     *         is less than, equal to, or greater than the specified town's name
     */
	@Override
	public int compareTo(Town t) {
		return this.name.compareTo(t.name);
	}
	
	
	/**
     * Returns a string representation of the town (its name).
     *
     * @return the name of the town
     */
	@Override
	public String toString() {
		return name;
	}
	
	
	/**
     * Returns the hash code of the town, based on its name.
     *
     * @return the hash code of the town
     */
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	
	 /**
     * Checks if this town is equal to another object.
     *
     * @param o the object to compare to
     * @return true if the other object is a Town with the same name, false otherwise
     */
	@Override 
	public boolean equals(Object o) {
		Town t = (Town) o;
		return compareTo(t)==0;
	}

}
