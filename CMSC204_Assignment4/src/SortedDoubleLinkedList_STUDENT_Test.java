import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedList_STUDENT_Test {

	private SortedDoubleLinkedList<String> sortedNameList;
	private SortedDoubleLinkedList<Integer> sortedIntList;
	
	@Before
	public void setUp() throws Exception {
		
		sortedNameList = new SortedDoubleLinkedList<String>(new StringComparator());
		sortedIntList = new SortedDoubleLinkedList<Integer>(new IntComparator());
	
		sortedIntList.add(2);
		sortedIntList.add(1);
		sortedIntList.add(9);
		sortedIntList.add(-1);
		sortedIntList.add(5);
		sortedIntList.add(8);
		
		
		sortedNameList.add("Adam");  //2
		sortedNameList.add("Zayn"); //6
		sortedNameList.add("Brian"); //3
		sortedNameList.add("Carey"); //4
		sortedNameList.add("AB"); //1
		sortedNameList.add("Mike"); //5
	
	}

	@After
	public void tearDown() throws Exception {
		sortedNameList = null;
		sortedIntList= null;
	}

	@Test
	public void testAdd() {
	
		ArrayList<Integer> intList = sortedIntList.toArrayList();
		
		assertEquals(Integer.valueOf(-1), intList.get(0));
		assertEquals(Integer.valueOf(1), intList.get(1));
		assertEquals(Integer.valueOf(2), intList.get(2));
		assertEquals(Integer.valueOf(5), intList.get(3));
		assertEquals(Integer.valueOf(8), intList.get(4));
		assertEquals(Integer.valueOf(9), intList.get(5));
		
		ArrayList<String> nameList = sortedNameList.toArrayList();
		
		assertEquals("AB", nameList.get(0));
		assertEquals("Adam", nameList.get(1));
		assertEquals("Brian", nameList.get(2));
		assertEquals("Carey", nameList.get(3));
		assertEquals("Mike", nameList.get(4));
		assertEquals("Zayn", nameList.get(5));
	}

	@Test
	public void testRemove​() {
		
		StringComparator stringComparator = new StringComparator();
		
		assertEquals(6, sortedNameList.getSize());
		sortedNameList.remove("AB", stringComparator);
		assertEquals(5, sortedNameList.getSize());
		assertEquals("Adam", sortedNameList.getFirst());
		
		sortedNameList.remove("Zayn", stringComparator);
		assertEquals(4, sortedNameList.getSize());
		assertEquals("Mike", sortedNameList.getLast());
		
		IntComparator intComparator = new IntComparator();
		
		assertEquals(6, sortedIntList.getSize());
		sortedIntList.remove(-1, intComparator);
		assertEquals(5, sortedIntList.getSize());
		assertEquals(Integer.valueOf(1), sortedIntList.getFirst());
		
		sortedIntList.remove(9, intComparator);
		assertEquals(4, sortedIntList.getSize());
		assertEquals(Integer.valueOf(8), sortedIntList.getLast());
		
	}
	

	@Test
	public void testIteratorHasNextAndNext() {
	
		ListIterator<String> listIterator = sortedNameList.iterator();
		
		assertTrue(listIterator.hasNext());
		assertEquals("AB", listIterator.next());
		assertEquals("Adam", listIterator.next());
		assertEquals("Brian", listIterator.next());
		assertEquals("Carey", listIterator.next());
		assertEquals("Mike", listIterator.next());
		assertEquals("Zayn", listIterator.next());
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
	public void testIteratorHasPreviousAndPrevious() {
	
		ListIterator<Integer> intIterator = sortedIntList.iterator();
		
		intIterator.next();
		intIterator.next();
		intIterator.next();
		intIterator.next();
		intIterator.next();
		intIterator.next();
		
		assertEquals(Integer.valueOf(9), intIterator.previous());
		assertEquals(Integer.valueOf(8), intIterator.previous());
		assertEquals(Integer.valueOf(5), intIterator.previous());
		assertEquals(Integer.valueOf(2), intIterator.previous());
		assertEquals(Integer.valueOf(1), intIterator.previous());
		assertEquals(Integer.valueOf(-1), intIterator.previous());
		
		try {
			intIterator.previous();
			assertTrue("Exception should have been thrown",false);
		}
		catch(NoSuchElementException e) {
			assertTrue("Exception thrown successfully", true);
		}
	}

	
	@Test
	public void testAddToEnd() {
		try {
			sortedNameList.addToEnd(null);
			assertTrue("The exception should have been thrown", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw the exception", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an incorrect exception", false);
		}
		
		try {
			sortedIntList.addToEnd(null);
			assertTrue("The exception should have been thrown", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw the exception", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an incorrect exception", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedNameList.addToFront(null);
			assertTrue("The exception should have been thrown", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw the exception", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an incorrect exception", false);
		}
		
		try {
			sortedIntList.addToFront(null);
			assertTrue("The exception should have been thrown", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw the exception", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an incorrect exception", false);
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
