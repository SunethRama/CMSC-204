import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {
	
	Road road1, road2, road3, road4;

	@Before
	public void setUp() throws Exception {
		
		road1 = new Road(new Town("Rockville"), new Town("Potomac"), 10, "MD200");
		road2 = new Road(new Town("Rockville"), new Town("Bethesda"), 8, "MD201");
		road3 = new Road(new Town("Bethesda"), new Town("Olney"), 20, "MD202");
		road4 = new Road(new Town("Rockville"), new Town("Potomac"), 10, "MD200");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testContains() {
		assertTrue(road1.contains(new Town("Rockville")));
		assertTrue(road2.contains(new Town("Bethesda")));
		assertTrue(road3.contains(new Town("Olney")));
	}

	@Test
	public void testGetName() {
		assertEquals("MD200", road1.getName());
		assertEquals("MD201", road2.getName());
		assertEquals("MD202", road3.getName());
		assertEquals("MD200", road4.getName());
	}

	@Test
	public void testGetDestination() {
		assertEquals(new Town("Potomac"), road1.getDestination());
		assertEquals(new Town("Bethesda"), road2.getDestination());
		assertEquals(new Town("Olney"), road3.getDestination());
		assertEquals(new Town("Potomac"), road4.getDestination());
	}

	@Test
	public void testGetSource() {
		assertEquals(new Town("Rockville"), road1.getSource());
		assertEquals(new Town("Rockville"), road2.getSource());
		assertEquals(new Town("Bethesda"), road3.getSource());
		assertEquals(new Town("Rockville"), road4.getSource());
	}

	@Test
	public void testGetWeight() {
		assertEquals(10, road1.getWeight());
		assertEquals(8, road2.getWeight());
		assertEquals(20, road3.getWeight());
		assertEquals(10, road4.getWeight());
	}

	@Test
	public void testToString() {
		assertEquals("Rockville Potomac 10 MD200", road1.toString());
	}

	@Test
	public void testCompareTo() {
		
		assertTrue(road1.compareTo(road4)==0);
	}

	@Test
	public void testEqualsObject() {
		assertTrue(road1.equals(road4));
		assertFalse(road1.equals(road3));
	}

}
