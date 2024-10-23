import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{

	Comparator<T> compareableObject;
	
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		super();
		this.compareableObject = compareableObject;
	}
	
	public void add(T data) {
		
		Node newNode = new Node(data);
		
		if (super.size == 0) {
			super.head = newNode;
			super.tail = newNode;
			super.size++;
		}
		
		else if (super.size == 1) {
			if (compareableObject.compare(newNode.data, head.data) < 0) {
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
				super.size++;
			}
			
			else {
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
				super.size++;
			}
		}
		
		else {
			
			Node currentNode = super.head;
			Node nodeAfter = currentNode.next;
			boolean inserted = false;
			
			while (currentNode != null & !inserted && nodeAfter != null) {
				
				if (compareableObject.compare(newNode.data, currentNode.data) > 0
						&& (compareableObject.compare(newNode.data, nodeAfter.data)<0)) {
					currentNode.next = newNode;
					newNode.prev = currentNode;
					newNode.next = nodeAfter;
					nodeAfter.prev = newNode;
					inserted = true;
					size++;
				}
				
				currentNode = currentNode.next;
				nodeAfter = currentNode.next;
			}
			
			if (inserted == false) {
				if (compareableObject.compare(newNode.data, currentNode.data) > 0) {
					tail.next = newNode;
					newNode.prev = tail;
					tail = newNode;
					inserted = true;
					size++;
				}
				
				else {
					newNode.next = head;
					head.prev = newNode;
					head = newNode;
					inserted = true;
					size++;
				}
			}
					
		}
		
	}
	
	
	public void addToEnd(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	public void addToFront(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	public Node remove​(T data, Comparator<T> comparator){
		return super.remove(data, comparator);
	}
	
	
}
