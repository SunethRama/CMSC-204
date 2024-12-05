/**
 * Tree Node class
 * @author Suneth Ramawickrama 
 * @param <T> generic datatype
 */

public class TreeNode<T> {

	private T data;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	
	
	/**
	 * Constructor
	 * @param dataNode data portion of the binary tree node
	 */
	public TreeNode(T dataNode) {
		this.data = dataNode;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	
	/**
	 * copy constructor
	 * @param node the node to be copied
	 */
	public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.leftChild = new TreeNode<T>(node.leftChild);
		this.rightChild = new TreeNode<T>(node.rightChild);
	}
	
	
	/**
	 * getter for the data field
	 * @return data 
	 */
	public T getData() {
		return data;
	}

	
	/**
	 * setter for the left node
	 * @param treeNode the node
	 */
	public void setLeftNode(TreeNode<T> treeNode) {
		this.leftChild = treeNode;
	}

	
	/**
	 * setter for the right node
	 * @param treeNode the node
	 */
	public void setRightNode(TreeNode<T> treeNode) {
		this.rightChild = treeNode;
	}

	
	/**
	 * getter for the left node
	 * @return the left node
	 */
	public TreeNode<T> getLeftChild() {
		return this.leftChild;
	}
	
	
	/**
	 * getter for the right node
	 * @return the right node
	 */
	public TreeNode<T> getRightChild() {
		return this.rightChild;
	}
	
}
