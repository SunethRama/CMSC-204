import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBStructureTest_STUDENT {

	private CourseDBStructure courseMap, courseMap2;
	private CourseDBElement course1, course2, course3, course4;
	
	@Before
	public void setUp() throws Exception {
		courseMap = new CourseDBStructure(15);
		courseMap2 = new CourseDBStructure(500);
		
		course1 = new CourseDBElement("CMSC204", 2000, 4, "SW200", "TBD");
		course2 = new CourseDBElement("CMSC203", 3000, 4, "SW300", "TBD");
		course3 = new CourseDBElement("CMSC207", 4000, 4, "SW400", "TBD");
		course4 = new CourseDBElement("CMSC207-	UP", 4000, 4, "SW400-UP", "TBD-UP");
		
	}

	@After
	public void tearDown() throws Exception {
		courseMap = null;
		courseMap2 = null;
	}

	@Test
	public void testAdd() {
		
		ArrayList<String> courseList = new ArrayList<>();
		
		courseMap.add(course1);
		courseMap.add(course1);
		
		courseList = courseMap.showAll();
		
		assertEquals(courseList.size(), 1);
		
		courseMap.add(course2);
		courseMap.add(course3);
		
		courseList = courseMap.showAll();
		assertEquals(courseList.size(), 3);
		
		courseMap.add(course4);
		
		courseList = courseMap.showAll();
		assertEquals(courseList.size(), 3);
	}

	@Test
	public void testGet() {
		
		courseMap.add(course1);
		courseMap.add(course2);
		courseMap.add(course3);
		courseMap.add(course4);
		
		try {
			assertEquals(courseMap.get(2000), course1);
			assertEquals(courseMap.get(3000), course2);
			assertEquals(courseMap.get(4000), course4);
			
			courseMap.get(2500);
			assertTrue("Should have thrown the exception", false);
			
		} catch (IOException e) {
			assertTrue("Exception thrown successfully", true);
		}
		
	}

	@Test
	public void testGetTableSize() {
		assertEquals(courseMap.getTableSize(), 11);
		assertEquals(courseMap2.getTableSize(), 347);
	}

}
