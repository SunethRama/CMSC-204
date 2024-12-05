import java.util.ArrayList;

/**
 * MorseCodeTree class
 * @author Suneth Ramawickrama
 * 
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	private TreeNode<String> root;
	
	
	/**
	 * No Arg Constructor calls the buildTree method
	 */
	public MorseCodeTree() {
		buildTree();
	}
	
	
	/**
	 * call the insert method to build the tree
	 */
	@Override
	public void buildTree() {
		
		this.root = new TreeNode<>(""); 
		
		insert(".", "e");
		insert("-", "t");
		
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-.-.", "c");
		insert("-..-", "x");
		insert("-.--", "y");
		insert("--.-", "q");
		insert("--..", "z");
	}
	
	
	/**
	 * call the addNode method to build the tree
	 * @param code the code correspoinding to each letter
	 * @param result the letter
	 */
	@Override
	public void insert(String code, String result) {
		addNode(this.root, code, result);
		
	}
	
	
	/**
	 * a recursive method that builds the binary tree, putting each letter in correct place
	 * @param root root
	 * @param code the code 
	 * @param letter the letter corresponding to the code
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		if (code.length()==1) {
			if (code.charAt(0)=='.') {
				root.setLeftNode(new TreeNode<>(letter));
			}
			else if (code.charAt(0)=='-') {
				root.setRightNode(new TreeNode<>(letter));
			}
			else 
				return;
		}
		
		else {
			if (code.charAt(0)=='.') {
				root = root.getLeftChild(); 
			}
			else if (code.charAt(0)=='-') {
				root = root.getRightChild();
			}
			
			code = code.substring(1);
			
			addNode(root, code, letter);
		}
		
	}
	
	
	/**
	 * getter for the root field
	 * @return the root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return this.root;
	}

	
	/**
	 * setter for the root field
	 * @param newNode new root node
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;
	}

	
	/**
	 * call the fetchNode method to fetch the corresponding letter
	 * @param code the code
	 * @return the corresponding letter for the code
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(this.root, code);
	}

	
	/**
	 * This recursive method find the corresponding letter for each code
	 * @param code the code
	 * @param root the root
	 * @return the corresponding letter for the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if (code.length()==1) {
			if (code.charAt(0)=='.') {
				return root.getLeftChild().getData();
			}
			else if (code.charAt(0)=='-') {
				return root.getRightChild().getData();
			}
			else 
				return null;
		}
		
		else {
			if (code.charAt(0)=='.') {
				root = root.getLeftChild(); 
			}
			else if (code.charAt(0)=='-') {
				root = root.getRightChild();
			}
			
			code = code.substring(1);
			
			return fetchNode(root, code);
		}
	}

	
	/**
	 * delete method is not supported
	 * @param data data
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	
	/**
	 * update method is not supported
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}


	/**
	 * Traverse the tree in LNR order and store each letter in an arrayList
	 * @return an arrayList 
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> LNRoutputList = new ArrayList<>();
		LNRoutputTraversal(root, LNRoutputList);
		return LNRoutputList;
	}
	

	/**
	 * This recursive method traverse the tree in LNR order and add each 
	 * letter to the arrayList according to the correct order
	 * @param root root
	 * @param list the arrayList
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		TreeNode<String> leftChild = root.getLeftChild();
		TreeNode<String> rightChild = root.getRightChild();
		 
		if (leftChild != null) {
			LNRoutputTraversal(leftChild, list);
		}
		
		list.add(root.getData());
		
		if (rightChild != null) {
			LNRoutputTraversal(rightChild, list);
		}
		 
	}

}
