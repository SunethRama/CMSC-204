/**
 * implement ADT Queue using an array.
 * @author Suneth Ramawickrama
 */

import java.util.ArrayList;

/**
 * @param <T> generic data type
 */
public class MyQueue<T> implements QueueInterface<T>{

	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private int elementCount;
	private final int DEFAULT_CAPACITY = 30;
	
	/**
	 * no arg constructor
	 */
	public MyQueue() {
		@SuppressWarnings({ "unchecked" })
		T[] tempQueue = (T[]) new Object[DEFAULT_CAPACITY];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = -1;
		elementCount = 0;
	}
	
	/**
	 * constructor with capacity
	 * @param capacity capacity of the queue
	 */
	public MyQueue(int capacity) {
		@SuppressWarnings({ "unchecked" })
		T[] tempQueue = (T[]) new Object[capacity];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = -1;
		elementCount = 0;
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return elementCount == 0;
	}


	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		return elementCount == queue.length;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if (!isEmpty()) {
			T frontData = getFront();
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			elementCount--;
			return frontData;
		}
		throw new QueueUnderflowException();
	}

	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return elementCount;
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	@Override
	public boolean enqueue(T anEntry) throws QueueOverflowException{
	
		if (!isFull()) {
			backIndex = (backIndex + 1) % queue.length;
			queue[backIndex] = anEntry;
			elementCount++;
			return true;
		}
		throw new QueueOverflowException();
		
	}

	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		String queueStr = "";
		int currentIndex = frontIndex;
		for (int i = 0 ; i < elementCount ; i++) {
			queueStr = queueStr + queue[currentIndex];
			currentIndex = (currentIndex + 1) % queue.length;
		}
		return queueStr;
	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter){
		String queueStr = "";
		int currentIndex = frontIndex;
		for (int i = 0 ; i < elementCount ; i++) {
			queueStr = queueStr + queue[currentIndex];
			if (i < elementCount-1) {
				queueStr = queueStr + delimiter;
			}
			currentIndex = (currentIndex + 1) % queue.length;
		}
		return queueStr;
	}
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> listCopy = new ArrayList<T>(list);
		
		for(int i=0 ; i < listCopy.size(); i++) {
			try {
				enqueue(listCopy.get(i));
			} catch (QueueOverflowException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * returns the element at the front of the queue
	 * @return  element at the front of the queu
	 */
	private T getFront(){
		return queue[frontIndex];
	}

}
