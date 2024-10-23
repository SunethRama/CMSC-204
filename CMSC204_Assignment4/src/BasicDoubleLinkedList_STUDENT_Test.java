import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_STUDENT_Test {

	private BasicDoubleLinkedList<String> nameList;
	private BasicDoubleLinkedList<Integer> intList;
	
	
	
	@Before
	public void setUp() throws Exception {
		
		nameList = new BasicDoubleLinkedList<String>();
		intList = new BasicDoubleLinkedList<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		
		nameList = null;
		intList = null;
	}

	@Test
	public void testGetSize() {
		
		assertEquals(0, nameList.getSize());
		nameList.addToEnd("John");
		nameList.addToFront("Kate");
		assertEquals(2, nameList.getSize());
		
		assertEquals(0, intList.getSize());
		intList.addToEnd(1);
		intList.addToFront(2);
		assertEquals(2, nameList.getSize());
		
	}

	@Test
	public void testAddToEnd() {
		
		nameList.addToEnd("John");
		nameList.addToEnd("Kate");
		assertEquals("Kate", nameList.getLast());
		
		intList.addToEnd(5);
		intList.addToEnd(10);
		assertEquals(Integer.valueOf(10), intList.getLast());
		intList.addToEnd(12);
		intList.addToEnd(22);
		assertEquals(Integer.valueOf(22), intList.getLast());
	}

	@Test
	public void testAddToFront() {
		
		nameList.addToFront("John");
		nameList.addToFront("Kate");
		assertEquals("Kate", nameList.getFirst());
		
		intList.addToFront(5);
		intList.addToFront(10);
		assertEquals(Integer.valueOf(10), intList.getFirst());
		intList.addToFront(12);
		intList.addToFront(22);
		assertEquals(Integer.valueOf(22), intList.getFirst());
	}

	@Test
	public void testGetFirst() {
		
		nameList.addToFront("Jerry");
		nameList.addToFront("Terry");
		nameList.addToEnd("John");
		nameList.addToEnd("Kate");
		
		assertEquals("Terry", nameList.getFirst());
		
		intList.addToFront(5);
		intList.addToFront(10);
		assertEquals(Integer.valueOf(10), intList.getFirst());
	}

	@Test
	public void testGetLast() {
		nameList.addToFront("Jerry");
		nameList.addToFront("Terry");
		nameList.addToEnd("John");
		nameList.addToEnd("Kate");
		
		assertEquals("Kate", nameList.getLast());
		
		intList.addToFront(5);
		intList.addToFront(10);
		assertEquals(Integer.valueOf(5), intList.getLast());
	}

	@Test
	public void testRetrieveFirstElement() {

		nameList.addToFront("Jerry");
		nameList.addToFront("Terry");
		nameList.addToEnd("John");
		nameList.addToEnd("Kate");
		
		assertEquals("Terry", nameList.retrieveFirstElement());
		assertEquals("Jerry", nameList.retrieveFirstElement());
		assertEquals("John", nameList.getFirst());
		assertEquals(2, nameList.getSize());
		
		
		intList.addToFront(2);
		intList.addToFront(4);
		intList.addToFront(6);
		intList.addToFront(8);
		
		assertEquals(Integer.valueOf(8), intList.retrieveFirstElement());
		assertEquals(Integer.valueOf(6), intList.retrieveFirstElement());
		assertEquals(Integer.valueOf(4), intList.retrieveFirstElement());
		assertEquals(Integer.valueOf(2), intList.retrieveFirstElement());
		assertEquals(null, intList.retrieveFirstElement());
		assertEquals(0, intList.getSize());
	}

	@Test
	public void testRetrieveLastElement() {
		
		nameList.addToEnd("Jerry");
		nameList.addToEnd("Terry");
		nameList.addToEnd("John");
		nameList.addToEnd("Kate");
		
		assertEquals("Kate", nameList.retrieveLastElement());
		assertEquals("John", nameList.retrieveLastElement());
		assertEquals("Terry", nameList.retrieveLastElement());
		assertEquals("Jerry", nameList.retrieveLastElement());
		assertEquals(null, nameList.retrieveLastElement());
		assertEquals(0, nameList.getSize());
		
		
		intList.addToEnd(2);
		intList.addToEnd(4);
		intList.addToEnd(6);
		intList.addToEnd(8);
		
		assertEquals(Integer.valueOf(8), intList.retrieveLastElement());
		assertEquals(Integer.valueOf(6), intList.retrieveLastElement());
		assertEquals(Integer.valueOf(4), intList.retrieveLastElement());
		assertEquals(Integer.valueOf(2), intList.retrieveLastElement());
		assertEquals(null, intList.retrieveLastElement());
		assertEquals(0, intList.getSize());
	}

	@Test
	public void testRemove() {
		
		StringComparator stringComparator = new StringComparator();
		IntComparator intComparator = new IntComparator();
		
		nameList.addToEnd("Jerry");
		nameList.addToEnd("Terry");
		nameList.addToEnd("John");
		nameList.addToEnd("Kate");
		
		assertEquals(4, nameList.getSize());
		nameList.remove("Jerry", stringComparator);
		assertEquals(3, nameList.getSize());
		assertEquals("Terry", nameList.getFirst());
		
		nameList.remove("Kate", stringComparator);
		assertEquals(2, nameList.getSize());
		assertEquals("John", nameList.getLast());
		
		intList.addToEnd(2);
		intList.addToEnd(4);
		intList.addToEnd(6);
		intList.addToEnd(8);
		
		assertEquals(4, intList.getSize());
		intList.remove(6, intComparator);
		assertEquals(3, intList.getSize());
		intList.remove(2, intComparator);
		assertEquals(Integer.valueOf(4), intList.getFirst());
	}

	@Test
	public void testToArrayList() {
		
		nameList.addToEnd("Jerry");
		nameList.addToEnd("John");
		nameList.addToEnd("Kate");
		nameList.addToFront("Bryan");
		nameList.addToFront("Will");
		
		ArrayList<String> nameListArrList = nameList.toArrayList();
		
		assertEquals("Will", nameListArrList.get(0));
		assertEquals("Bryan", nameListArrList.get(1));
		assertEquals("Jerry", nameListArrList.get(2));
		assertEquals("John", nameListArrList.get(3));
		assertEquals("Kate", nameListArrList.get(4));
		
		
		intList.addToEnd(5);
		intList.addToEnd(10);
		intList.addToEnd(15);
		intList.addToFront(1);
		intList.addToFront(12);
		
		ArrayList<Integer> intListArrList = intList.toArrayList();
		
		assertEquals(Integer.valueOf(12), intListArrList.get(0));
		assertEquals(Integer.valueOf(1), intListArrList.get(1));
		assertEquals(Integer.valueOf(5), intListArrList.get(2));
		assertEquals(Integer.valueOf(10), intListArrList.get(3));
		assertEquals(Integer.valueOf(15), intListArrList.get(4));
		
	}

	@Test
	public void testThatIteratorHasNextAndNextReturnsCorrectOutputs() {

		nameList.addToEnd("Jerry");
		nameList.addToEnd("John");
		nameList.addToEnd("Kate");
		nameList.addToFront("Bryan");
		nameList.addToFront("Will");
		
		ListIterator<String> listIterator = nameList.iterator();
		
		assertTrue(listIterator.hasNext());
		assertEquals("Will", listIterator.next());
		assertEquals("Bryan", listIterator.next());
		assertEquals("Jerry", listIterator.next());
		assertEquals("John", listIterator.next());
		assertEquals("Kate", listIterator.next());
		assertFalse(listIterator.hasNext());
		
		try {
			listIterator.next();
			assertTrue("Exception should have been thrown",false);
		}
		catch(NoSuchElementException e) {
			assertTrue("Exception thrown successfully", true);
		}
	}
	
	@Test
	public void testThatIteratorHasPreviousAndPreviousReturnCorrectOutputs() {
		
		intList.addToEnd(5);
		intList.addToEnd(10);
		intList.addToEnd(15);
		intList.addToEnd(20);
		intList.addToEnd(25);
		
		ListIterator<Integer> intIterator = intList.iterator();
		
		intIterator.next();
		intIterator.next();
		intIterator.next();
		intIterator.next();
		intIterator.next();
		assertEquals(Integer.valueOf(25), intIterator.previous());
		assertEquals(Integer.valueOf(20), intIterator.previous());
		assertEquals(Integer.valueOf(15), intIterator.previous());
		assertEquals(Integer.valueOf(10), intIterator.previous());
		assertEquals(Integer.valueOf(5), intIterator.previous());
		
		try {
			intIterator.previous();
			assertTrue("Exception should have been thrown",false);
		}
		catch(NoSuchElementException e) {
			assertTrue("Exception thrown successfully", true);
		}
	}
	
	@Test
	public void TestThatUnsupportedIteratorMethodsThrowException() {
		
		ListIterator<Integer> intIterator = intList.iterator();
		try {
			intIterator.add(null);
			assertTrue("The Exception should have been thrown", false);
		}
		
		catch(UnsupportedOperationException e) {
			assertTrue("Correct Exception thrown", true);
		}
		
		try {
			intIterator.set(null);
			assertTrue("The Exception should have been thrown", false);
		}
		
		catch(UnsupportedOperationException e) {
			assertTrue("Correct Exception thrown", true);
		}
		
		try {
			intIterator.previousIndex();
			assertTrue("The Exception should have been thrown", false);
		}
		
		catch(UnsupportedOperationException e) {
			assertTrue("Correct Exception thrown", true);
		}
		
		try {
			intIterator.nextIndex();
			assertTrue("The Exception should have been thrown", false);
		}
		
		catch(UnsupportedOperationException e) {
			assertTrue("Correct Exception thrown", true);
		}
		
		try {
			intIterator.remove();
			assertTrue("The Exception should have been thrown", false);
			
		}
		
		catch(UnsupportedOperationException e) {
			assertTrue("Correct Exception thrown", true);
		}
	}
	
	class StringComparator implements Comparator<String>{

		@Override
		public int compare(String name1, String name2) {
			return name1.compareTo(name2);
		}
		
	}
	
	class IntComparator implements Comparator <Integer>{

		@Override
		public int compare(Integer num1, Integer num2) {
			return num1 - num2;
		}
		
	}

}
