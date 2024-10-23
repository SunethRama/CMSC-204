import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T>{

	protected Node head;
	protected Node tail;
	protected int size;
	
	public BasicDoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void addToEnd(T data) {
		
		Node newNode = new Node(data);
		
		if (getSize() == 0) {
			head = newNode;
			tail = newNode;
		}
		
		else{
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		
		size++;
	}
	
	
	public void addToFront(T data) {
		
	Node newNode = new Node(data);
		
		if (getSize() == 0) {
			head = newNode;
			tail = newNode;
		}
		
		else{
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		
		size++;
	}
	

	public T getFirst() {
		return head.data;
	}
	
	public T getLast() {
		return tail.data;
	}
	
	public T retrieveFirstElement() {
		
		if (size == 0) {
			return null;
		}
		
		else {
			T data;
			data = head.data;
			head = head.next;
			size--;
			return data;
		}
	}
	
	public T retrieveLastElement() {
		
		if (size == 0) {
			return null;
		}
		
		else {
			T data;
			data = tail.data;
			tail = tail.prev;
			size--;
			return data;
		}
	}
	
	public Node remove(T targetData, Comparator<T> comparator) {
		
		Node currentNode = head;
		Node nodeToRemove = null;
		Node nodeBefore;
		Node nodeAfter;
		boolean found = false;
		
		while(!found && currentNode != null) {
			if (comparator.compare(targetData, currentNode.data)==0) {
				nodeToRemove = currentNode;
				found = true;
			}
			currentNode = currentNode.next;
		}
		
		if (nodeToRemove == null) {
			return null;
		}
		
		else {
			Node returnNode = nodeToRemove;
			nodeBefore = nodeToRemove.prev;
			nodeAfter = nodeToRemove.next;
			
			// if the nodeBefore is null, that means the nodeToRemove is the first node in the chain
			if (nodeBefore == null) {
				head = head.next;
			}
			
			// if the nodeAfter is null, that means the nodeToRemove is the last node in the chain
			else if (nodeAfter == null) {
				tail = tail.prev;
			}
			
			else {
				nodeBefore.next = nodeAfter;
				nodeAfter.prev = nodeBefore;
			}
			size--;
			return returnNode;
		}
	}
	
	public ArrayList<T> toArrayList() {
		
		ArrayList <T> returnList = new ArrayList<T>();
		Node currentNode = this.head;
		
		for (int i=0 ; i < this.size ; i++) {
			
			if (currentNode != null) {
			returnList.add(currentNode.data);
			currentNode = currentNode.next;
			}
		}
		
		return returnList;
	}
	
	
	@Override
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
	
	protected class DoubleLinkedListIterator implements ListIterator<T>{

		Node currentNode;
		int currentIndex;
		
		public DoubleLinkedListIterator(){
			currentNode = head;
			currentIndex = 0;
		}
		
		@Override
		public boolean hasNext() {
			return currentNode.next != null;
		}

		@Override
		public T next() {
			
			T data;
			
			if (hasNext()) {
				
				if (currentIndex == 0) {
					data = currentNode.data;
				}
				
				else {
					currentNode = currentNode.next;
					data = currentNode.data;
				}
				currentIndex++;
				return data;
			}
			else 
				throw new NoSuchElementException();
			
		}

		@Override
		public boolean hasPrevious() {
			return currentNode !=  null;
		}

		@Override
		public T previous() {
			
			T data;
			
			if (hasPrevious()) {

				data = currentNode.data;
				currentNode = currentNode.prev;
				
				currentIndex--;
				return data;
			}
			
			else 
				throw new NoSuchElementException();
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();
		}
	}
	
	protected class Node {
		
		T data;
		Node prev;
		Node next;
		
		public Node(T data){
			this.data = data;
			prev = null;
			next = null;
		} 
	}
	
}
