import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTestStudent {

	private MyStack<Double> stack;
	  
	@BeforeEach
	void setUp() throws Exception {
		stack = new MyStack<Double>(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		stack = null;
	}

	@Test
	void testThatIsEmptyAndSizeReturnCorrectValues(){
		assertTrue(stack.isEmpty());
		assertEquals(0,stack.size());
		
		stack.push(3.0);
		stack.push(8.5);
		stack.push(10.2);
		assertEquals(3,stack.size());
		
		assertFalse(stack.isEmpty());
		
		stack.pop();
		stack.pop();
		stack.pop();
		assertEquals(0,stack.size());
		
		assertTrue(stack.isEmpty());
	}

	@Test
	void testIsFull(){
		
		stack.push(3.0);
		stack.push(8.5);
		stack.push(10.2);
		assertFalse(stack.isFull());
		
		stack.push(8.0);
		stack.push(10.0);
		assertTrue(stack.isFull());
		
		stack.pop();
		assertFalse(stack.isFull());
	}

	@Test
	void testPop() {
		try {
			stack.pop();
			assertTrue("Test Failed: No exception thrown ", false);
		}
		catch(StackUnderflowException e) {
			assertTrue("Correct exception thrown", true);
		}
		catch (Exception e) {
			assertTrue("Invalid exception called", false);
		}
		
		stack.push(3.0);
		stack.push(8.5);
		stack.push(10.2);
		
		assertEquals(10.2, stack.pop());
		assertEquals(8.5, stack.pop());
		assertEquals(3.0, stack.pop());
		
	}

	@Test
	void testTop() {
		try {
			stack.top();
			assertTrue("Test Failed: No exception thrown ", false);
		}
		catch(StackUnderflowException e) {
			assertTrue("Correct exception thrown", true);
		}
		catch (Exception e) {
			assertTrue("Invalid exception called", false);
		}
		
		stack.push(3.0);
		stack.push(8.5);
		stack.push(10.2);
		
		assertEquals(10.2, stack.top());
		stack.pop();
		assertEquals(8.5, stack.top());
		stack.pop();
		assertEquals(3.0, stack.top());
	}

	@Test
	void testPush() {
		
		stack.push(3.0);
		stack.push(8.5);
		stack.push(10.2);
		stack.push(3.0);
		stack.push(8.5);
		
		try {
			stack.push(10.2);
		}
		catch(StackOverflowException e) {
			assertTrue("Correct exception thrown", true);
		}
		catch (Exception e) {
			assertTrue("Invalid exception called", false);
		}
	}

	@Test
	void testToString() {
		
		stack.push(3.0);
		stack.push(8.5);
		stack.push(10.2);
		stack.push(3.0);
		stack.push(8.5);
		
		assertEquals("3.08.510.23.08.5",stack.toString());
	}

	@Test
	void testToStringWithDelimiter() {
		stack.push(3.0);
		stack.push(8.5);
		stack.push(10.2);
		stack.push(3.0);
		stack.push(8.5);
		
		assertEquals("3.0 8.5 10.2 3.0 8.5",stack.toString(" "));
		assertEquals("3.0 % 8.5 % 10.2 % 3.0 % 8.5",stack.toString(" % "));
		
	}

	@Test
	void testFill() {
		ArrayList<Double> doubleList = new ArrayList<Double>();
		
		doubleList.add(3.0);
		doubleList.add(8.5);
		doubleList.add(10.2);
		doubleList.add(3.0);
		doubleList.add(8.5);
		
		stack.fill(doubleList);
		
		assertEquals(5,stack.size());
		assertEquals("3.0 8.5 10.2 3.0 8.5",stack.toString(" "));
	}

}
