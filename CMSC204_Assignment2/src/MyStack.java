/**
 * implement ADT Stack using an array.
 * @author Suneth Ramawickrama
 */

import java.util.ArrayList;

/**
 * @param <T> generic data type
 */
public class MyStack<T> implements StackInterface<T>{
	
	private T[] stack;
	private int topEntry;
	private final int DEFAULT_CAPACITY=30;
	private int size;

	/**
	 * no arg constructor
	 */
	public MyStack() {
		
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[DEFAULT_CAPACITY];
		stack = tempStack;
		topEntry = -1;
		size = 0;
	}
	
	/**
	 * construct a stack with given size
	 * @param size size of the stack
	 */
	public MyStack(int size) {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[size];
		stack = tempStack;
		topEntry = -1;
		size = 0;
	}

	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return topEntry < 0;
	}


	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		return topEntry == stack.length -1;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if (!isEmpty()) {
			T data = top();
			stack[topEntry] = null;
			topEntry--;
			size--;
			return data;
		}
		else
			throw new StackUnderflowException();
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException {
		if (!isEmpty()) {
			return stack[topEntry];
		}
		else
			throw new StackUnderflowException();
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(T anEntry) throws StackOverflowException {
		if (!isFull()) {
			stack[topEntry + 1] = anEntry;
			topEntry++;
			size++;
			return true;
		}
		else 
			throw new StackOverflowException();
	}

	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		
		String stackStr = "";
		
		for (int i = 0 ; i <= topEntry ;i++) {
			stackStr = stackStr + stack[i];
		}
		return stackStr;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {

		String stackStr = "";
		
		for (int i = 0 ; i <= topEntry ;i++) {
			stackStr = stackStr + stack[i];
			if (i < topEntry) {
				stackStr = stackStr + delimiter;
			}
		}
		return stackStr;
	}

	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	@Override
	public void fill(ArrayList<T> list) {
		
		ArrayList <T> tempList = new ArrayList<T>(list);
		
		for (int i = 0 ; i < tempList.size() ; i++) {
			try {
				push(tempList.get(i));
			} catch (StackOverflowException e) {
				e.printStackTrace();
			}
		}
	}

}
