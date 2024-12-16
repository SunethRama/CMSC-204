import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test {

	private Town t1;
	private Town t2;
	private Town t3;
	
	@Before
	public void setUp() throws Exception {
		t1 = new Town("Rockville");
		t2 = new Town("Bethesda");
		t3 = new Town(t2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {
		assertEquals("Rockville", t1.getName());
		assertEquals("Bethesda", t2.getName());
	}

	@Test
	public void testCompareTo() {
		assertEquals(0, t3.compareTo(t2));
		assertTrue(t2.compareTo(t1)<0);
	}

	@Test
	public void testToString() {
		assertEquals("Rockville", t1.toString());
		assertEquals("Bethesda", t2.toString());
	}

	@Test
	public void testEqualsObject() {
		assertTrue(t2.equals(t2));
	}

}
