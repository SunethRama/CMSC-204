/**
 * Database structure class
 * @author Suneth Ramawickrama
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	private int size;
	private LinkedList<CourseDBElement>[] hashTable;
	
	
	/**
	 * A constructor that takes in an integer n which represents the 
	 * estimated number of courses and determines the size of the hash
	 * table by finding a 4K+3 prime just greater than n /loading factor.
	 * @param n 
	 */
	
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int n) {
		
		int prime = (int) (n / 1.5);
		
		while (((prime - 3)%4 != 0) || !isPrime(prime)) {
			prime++;
		}
		
		this.size = prime;
		
		hashTable = new LinkedList[size];
	}
	
	
	/**
	 * A Constructor for testing purposes. This constructor will take a 
	 * string Testing and an int for the hashtable size.  This is used
	 * only for testing.
	 * @param string
	 * @param n
	 */
	
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String string, int n) {
		this.size = n;
		hashTable = new LinkedList[size];
	}

	
	/**
	 * Determines if the given number is a prime number
	 * @param num 
	 * @return whether the number is a prime number or not
	 */
	
	private boolean isPrime(int num) {
		
		if (num <= 1)
			return false;
		
		if (num == 2)
			return true;
		
		if (num % 2 == 0)
			return false;
		
		for(int i = 3 ; i * i <= num ; i+=2) {
			if (num % i == 0)
				return false;
		}
		
		return true;
	}
	
	
	/**
	 * add a course to the hashtable
	 * @param element course object to be added
	 */
	
	@Override
	public void add(CourseDBElement element) {
		
		int hashIndex = element.hashCode() % size;
		
		if (hashTable[hashIndex] == null) {
			LinkedList<CourseDBElement> courseList = new LinkedList<CourseDBElement>();
			hashTable[hashIndex] = courseList;
			courseList.addFirst(element);
		}
		
		else {
			
			for (int i = 0 ; i < hashTable[hashIndex].size() ; i++) {
				
				// if an existing object is being added, silently ignored
				if (hashTable[hashIndex].get(i).equals(element)) {
					return;
				}
				
				// if an object with the same CRN is added, the updated object would be added
				if (hashTable[hashIndex].get(i).getCRN() == element.getCRN()) {
					
					hashTable[hashIndex].remove(i);
					hashTable[hashIndex].add(i, element);
					return;
				}
			}

			hashTable[hashIndex].add(element);
		}
	}

	
	/**
	 * Returns the course related to the given CRN
	 * @param crn
	 * @throws IOException
	 * @return the course related to the given CRN
	 */
	
	@Override
	public CourseDBElement get(int crn) throws IOException {

		CourseDBElement course = null;
		
		int hashIndex = Integer.toString(crn).hashCode() % size;
		
		if (hashTable[hashIndex] != null) {
			
			for (int i = 0 ; i < hashTable[hashIndex].size() ; i++) {
				if (hashTable[hashIndex].get(i).getCRN() == crn) {
					course = hashTable[hashIndex].get(i);
					break;
				}
			}
			
		} 
		
		if (course != null)
			return course;
		else
			throw new IOException();
	}

	
	/**
	 * Returns all the elements in the hashtable
	 * @return all the elements in the hashtable
	 */
	
	@Override
	public ArrayList<String> showAll() {
		
		ArrayList<String> courseList = new ArrayList<String>();
		
		for (int i=0 ; i < this.size ; i++) {
			
			if (hashTable[i] != null) {
				
				for (int j = 0 ; j < hashTable[i].size(); j++ ) {
					
					courseList.add(hashTable[i].get(j).toString());
				}
				
			}
			
		}
		
		return courseList;
	}

	
	/**
	 * Returns the size of the hashtable
	 * @return the size of the hashtable
	 */
	
	@Override
	public int getTableSize() {
		return size;
	}

}
