import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	
	GradeBook gradeBook1;
	GradeBook gradeBook2;
	

	@BeforeEach
	void setUp() throws Exception {
		gradeBook1 = new GradeBook(5);
		gradeBook2 = new GradeBook(5);
		
		gradeBook1.addScore(95.5);
		gradeBook1.addScore(85.5);
		gradeBook1.addScore(90.0);
		gradeBook1.addScore(75.5);
		
		gradeBook2.addScore(75.5);
		gradeBook2.addScore(84.25);
		gradeBook2.addScore(70.75);
		gradeBook2.addScore(100.0);
		gradeBook2.addScore(95.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		gradeBook1 = null;
		gradeBook2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(gradeBook1.toString().equals("95.5 85.5 90.0 75.5 "));
		assertEquals(4,gradeBook1.getScoreSize());
		
		assertTrue(gradeBook2.toString().equals("75.5 84.25 70.75 100.0 95.0 "));
		assertEquals(5,gradeBook2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(346.5, gradeBook1.sum());
		assertEquals(425.5, gradeBook2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(75.5, gradeBook1.minimum());
		assertEquals(70.75, gradeBook2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(271.0 , gradeBook1.finalScore(),0);
		assertEquals(354.75, gradeBook2.finalScore(),0);
	}
	
}
