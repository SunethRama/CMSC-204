/**
 * Database management class
 * @author Suneth Ramawickrama
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	private CourseDBStructure courses = new CourseDBStructure(100);
	
	
	/**
	 * add a couse to the data structure
	 * @param id 
	 * @param crn
	 * @param credits
	 * @param roomNum
	 * @param instructor
	 * 
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {

		CourseDBElement course = new CourseDBElement(id, crn, credits, roomNum, instructor);
		courses.add(course);
	}

	
	
	/**
	 * get the related course object given the CRN
	 * @param crn
	 * @return the course object
	 */
	@Override
	public CourseDBElement get(int crn) {
		
		CourseDBElement course = null;
		
		try {
			course = courses.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return course;
	}

	
	
	/**
	 * add courses read by a file to the data structure
	 * @param input file with the course details
	 * @throws FileNotFoundException
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {

		try (Scanner inputFile = new Scanner(input)) {
			
			while (inputFile.hasNextLine()) {
				
				String courseDesc = inputFile.nextLine();
				
				// use the split function to tokenize the string
				String[] courseElements = courseDesc.split(" ");
				
				CourseDBElement course = new CourseDBElement
						(courseElements[0], 
						Integer.parseInt(courseElements[1]), 
						Integer.parseInt(courseElements[2]), 
						courseElements[3], 
						courseElements[4]);
				
				courses.add(course);
				
			}
		}
		
		catch (IOException e) {
			e.getMessage();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	
	
	/**
	 * show all the courses in the data structure
	 * @return all the courses in the data structure
	 */
	@Override
	public ArrayList<String> showAll() {
		
		return courses.showAll();
	}

}
