/**
 * Database element class
 * @author Suneth Ramawickrama
 */

public class CourseDBElement implements Comparable<CourseDBElement>{

	private String courseID;
	private int CRN;
	private int numOfCredits;
	private String roomNumber;
	private String instructorName;
	
	
	/**
	 * No Arg Constructor
	 */
	public CourseDBElement() {
	}

	
	/**
	 * All Arg constructor
	 * @param courseID
	 * @param CRN
	 * @param numOfCredits
	 * @param roomNumber
	 * @param instructorName
	 */
	public CourseDBElement(String courseID, int CRN, int numOfCredits, String roomNumber, String instructorName) {
		
		this.courseID = courseID;
		this.CRN = CRN;
		this.numOfCredits = numOfCredits;
		this.roomNumber = roomNumber;
		this.instructorName = instructorName;
	}

	
	/**
	 * compare two CourseDBElement objects
	 * @param object to be compared
	 * @return 0 if the two objects have the same CRN or the difference 
	 */
	@Override
	public int compareTo(CourseDBElement o) {
		return this.CRN - o.CRN;
	}
	
	
	/**
	 * check the equality of two CourseDBElement objects
	 * @param object to be compared
	 * @return true if all the attributes of two object are equal
	 */
	@Override 
	public boolean equals(Object o) {
		CourseDBElement cde = (CourseDBElement) o;
		return this.courseID.equals(cde.courseID) && this.numOfCredits == cde.numOfCredits
				&& this.roomNumber.equals(cde.roomNumber) && 
				this.instructorName.equals(cde.instructorName) && this.CRN == cde.CRN;
	}
	
	
	/**
	 * generate the hashcode
	 * @return the hashcode
	 */
	@Override
	public int hashCode() {
		String hashCode = "" + CRN;
		return hashCode.hashCode();
	}
	
	
	/**
	 * toString method
	 * @return string representation of the object
	 */
	@Override 
	public String toString() {
		
		return "\nCourse:" + this.courseID + " CRN:" + this.CRN + " Credits:"
				+ this.numOfCredits + " Instructor:" + this.instructorName +
				" Room:" + this.roomNumber;
	}

	
	/**
	 * getter for courseID
	 * @return courseID
	 */
	public String getID() {
		return courseID;
	}

	/**
	 * setter for courseID
	 * @param courseID
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	/**
	 * getter for numOfCredits
	 * @return numOfCredits
	 */
	public int getNumOfCredits() {
		return numOfCredits;
	}

	/**
	 * setter for numOfCredits
	 * @param numOfCredits
	 */
	public void setNumOfCredits(int numOfCredits) {
		this.numOfCredits = numOfCredits;
	}

	/**
	 * getter for roomNumber
	 * @return roomNumber
	 */
	public String getRoomNum() {
		return roomNumber;
	}

	/**
	 * setter for roomNumber
	 * @param roomNumber
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * getter for instructorName
	 * @return instructorName
	 */
	public String getInstructorName() {
		return instructorName;
	}

	/**
	 * setter for instructorName
	 * @param instructorName
	 */
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	/**
	 * getter for CRN
	 * @return CRN
	 */
	public int getCRN() {
		return CRN;
	}

	/**
	 * setter for CRN
	 * @param CRN
	 */
	public void setCRN(int CRN) {
		this.CRN = CRN;
	}


}
