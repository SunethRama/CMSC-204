import java.util.Objects;

/**
 * The Road class represents a connection between two towns in a graph
 */
public class Road implements Comparable<Road> {

	private Town source;
	private Town destination;
	private int weight;
	private String name;
	
	
	 /**
     * Constructs a Road object with a specified source, destination, weight, and name.
     *
     * @param source      the source Town of the road
     * @param destination the destination Town of the road
     * @param degrees     the weight of the road (distance or cost)
     * @param name        the name of the road
     */
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = degrees;
		this.name = name;
	}
	
	
	/**
     * Constructs a Road object with a specified source, destination, and name.
     * The weight is defaulted to 1.
     *
     * @param source      the source Town of the road
     * @param destination the destination Town of the road
     * @param name        the name of the road
     */
	public Road(Town source,Town destination,String name) {
		this(source, destination, 1, name);
	}
	
	
	/**
     * Checks if the road contains the specified town.
     *
     * @param town the Town to check
     * @return true if the road connects to the given town, false otherwise
     */
	public boolean contains(Town town) {
		return town.equals(source) || town.equals(destination);
	}

	
	/**
     * Retrieves the name of the road.
     *
     * @return the name of the road
     */
	public String getName() {
		return name;
	}
	
	
	/**
     * Retrieves the destination town of the road.
     *
     * @return the destination Town
     */
	public Town getDestination() {
		return this.destination;
	}
	
	
	/**
     * Retrieves the source town of the road.
     *
     * @return the source Town
     */
	public Town getSource() {
		return this.source;
	}
	
	
	/**
     * Retrieves the weight of the road.
     *
     * @return the weight of the road
     */
	public int getWeight() {
		return weight;
	}
	
	
	/**
     * Returns a string representation of the road, including source, destination, weight, and name.
     *
     * @return a string describing the road
     */
	@Override
	public String toString(){
		return "" + source + " " + destination 
				+ " " + weight + " " + name;
	}
	
	
	/**
     * Compares this road to another road by their names.
     *
     * @param o the other Road to compare
     * @return a negative, zero, or positive integer if this road's name is lexicographically
     *         less than, equal to, or greater than the other road's name
     */
	@Override
	public int compareTo(Road o) {
		return this.name.compareTo(o.name);
	}
	
	
	/**
     * Checks if this road is equal to another object.
     *
     * @param obj the object to compare
     * @return true if the roads are equal, false otherwise
     */
	@Override
    public boolean equals(Object obj) {
    
        Road other = (Road) obj;
        return (Objects.equals(source, other.source) && Objects.equals(destination, other.destination)) ||
               (Objects.equals(source, other.destination) && Objects.equals(destination, other.source));
    }

	
}
