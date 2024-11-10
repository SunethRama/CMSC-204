import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManagerTest_STUDENT {

	private CourseDBManager dbManager;
	
	@Before
	public void setUp() throws Exception {
		
		dbManager = new CourseDBManager();
		
		dbManager.add("CMSC204", 2000, 4, "SW200", "TBD");
		dbManager.add("CMSC203", 3000, 4, "SW300", "TBD");
		dbManager.add("CMSC207", 4000, 4, "SW400", "TBD");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddandGet() {
		
		assertEquals(dbManager.get(2000).getID(), "CMSC204");
		assertEquals(dbManager.get(3000).getNumOfCredits(), 4);
		assertEquals(dbManager.get(4000).getRoomNum(), "SW400");
	}

	@Test
	public void testShowAll() {

		ArrayList<String> courseList = new ArrayList<>();
		courseList = dbManager.showAll();
		
		assertEquals(courseList.size(), 3);

	}

}
