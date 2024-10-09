import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTestStudent {

	private MyQueue<Double> doubleQ;
	
	@BeforeEach
	void setUp() throws Exception {
		doubleQ = new MyQueue<Double>(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		doubleQ = null;
	}


	@Test
	void testThatIsEmptyAndSizeReturnsCorrectValues() {
		assertTrue(doubleQ.isEmpty());
		assertEquals(0,doubleQ.size());
		
		doubleQ.enqueue(3.0);
		doubleQ.enqueue(8.5);
		doubleQ.enqueue(10.2);
		assertEquals(3,doubleQ.size());
		
		assertFalse(doubleQ.isEmpty());
		
		doubleQ.dequeue();
		doubleQ.dequeue();
		doubleQ.dequeue();
		assertEquals(0,doubleQ.size());
		
		assertTrue(doubleQ.isEmpty());
	}

	@Test
	void testIsFull() {
		doubleQ.enqueue(3.0);
		doubleQ.enqueue(8.5);
		doubleQ.enqueue(10.2);
		assertFalse(doubleQ.isFull());
		
		doubleQ.enqueue(8.5);
		doubleQ.enqueue(10.2);
		assertTrue(doubleQ.isFull());
		
		doubleQ.dequeue();
		assertFalse(doubleQ.isFull());
	}

	@Test
	void testDequeue() {
		try {
			doubleQ.dequeue();
			assertTrue("Test Failed: No exception thrown ", false);
		}
		catch(QueueUnderflowException e) {
			assertTrue("Correct exception thrown", true);
		}
		catch (Exception e) {
			assertTrue("Invalid exception called", false);
		}
		
		doubleQ.enqueue(3.0);
		doubleQ.enqueue(8.5);
		doubleQ.enqueue(10.2);
		
		assertEquals(3.0, doubleQ.dequeue());
		assertEquals(8.5, doubleQ.dequeue());
		assertEquals(10.2, doubleQ.dequeue());
	}

	@Test
	void testEnqueue() {
		
		doubleQ.enqueue(3.0);
		doubleQ.enqueue(8.5);
		doubleQ.enqueue(10.2);
		doubleQ.enqueue(3.0);
		doubleQ.enqueue(8.5);
		
		try {
			doubleQ.enqueue(10.2);
		}
		catch(QueueOverflowException e) {
			assertTrue("Correct exception thrown", true);
		}
		catch (Exception e) {
			assertTrue("Invalid exception called", false);
		}
	}

	@Test
	void testToString() {
		doubleQ.enqueue(3.0);
		doubleQ.enqueue(8.5);
		doubleQ.enqueue(10.2);
		doubleQ.enqueue(3.0);
		doubleQ.enqueue(8.5);
		
		assertEquals("3.08.510.23.08.5",doubleQ.toString());
	}

	@Test
	void testToStringWithDelimiter() {
		doubleQ.enqueue(3.0);
		doubleQ.enqueue(8.5);
		doubleQ.enqueue(10.2);
		doubleQ.enqueue(3.0);
		doubleQ.enqueue(8.5);
		
		assertEquals("3.0 8.5 10.2 3.0 8.5",doubleQ.toString(" "));
		assertEquals("3.0 % 8.5 % 10.2 % 3.0 % 8.5",doubleQ.toString(" % "));
	}

	@Test
	void testFill() {
		ArrayList<Double> doubleList = new ArrayList<Double>();
		
		doubleList.add(3.0);
		doubleList.add(8.5);
		doubleList.add(10.2);
		doubleList.add(3.0);
		doubleList.add(8.5);
		
		doubleQ.fill(doubleList);
		
		assertEquals(5,doubleQ.size());
		assertEquals("3.0 8.5 10.2 3.0 8.5",doubleQ.toString(" "));
	}

}
