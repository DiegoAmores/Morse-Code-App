package MorseCode;

import java.util.ArrayList;

/** 
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to english 
 * It relies on a root (reference to root of the tree) The root is set to null when the tree is empty. 
 * The class uses an external generic TreeNode class which consists of a reference to the data and a reference to the left and right child. 
 * The TreeNode is parameterized as a String, TreeNode This class uses a private member root (reference to a TreeNode) 
 * The constructor will call the buildTree method
 * 
 * MorseCodeTree implements LinkedConverterTreeInterface(String) class
 * 
 * @author Diego Amores
 * 
 */

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;
	private String letterFetched;
	
	/**
	 * Constructor that calls the buildTree method 
	 */
	
	public MorseCodeTree() {
		root = null;
		buildTree();
	}
	
	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code. A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. The code ".-" would be stored as the right child of the left child of the root Algorithm for the recursive method:
	 * 1. if there is only one character
	 * a. if the character is '.' (dot) store to the left of the current root
	 * b. if the character is "-" (dash) store to the right of the current root
	 * c. return
	 * 2. if there is more than one character
	 * a. if the first character is "." (dot) new root becomes the left child
	 * b. if the first character is "-" (dash) new root becomes the right child
	 * c. new code becomes all the remaining charcters in the code (beyond the first character)
	 * d. call addNode(new root, new code, letter)
	 * 
	 * @param root The root of the tree for this particular recursive instance of addNode
	 * @param code The code for this particular recursive instance of addNode
	 * @param letter The data of the new TreeNode to be added
	 */

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() == 1) {
			if(code.equals("."))
				root.left = new TreeNode<String>(letter);
				
			else if(code.equals("-"))
				root.right = new TreeNode<String>(letter);
			
			return;
			
		} else {
			if(code.substring(0, 1).equals("."))
				addNode(root.getLeft(), code.substring(1), letter);
			
			else if(code.substring(0, 1).equals("-"))
				addNode(root.getRight(), code.substring(1), letter);
		}
	}
	
	/**
	 * Adds element to the correct position in the tree based on the code This method will call the recursive method addNode
	 * @param code The code for the new node to be added, example ".-."
	 * @param letter The letter for the corresponding code, example "r" 
	 * @return The MorseCodeTree with the new node added
	 */
	
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String letter) {
		addNode(root, code, letter);
		
		return this;
	}
	
	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. The root will 
	 * have a value of "" (empty string) level one: insert(".", "e"); insert("-", "t"); level two: insert("..", "i"); insert(".-", "a"); 
	 * insert("-.", "n"); insert("--", "m"); etc. Look at the tree and the table of codes to letters in the assignment description.
	 */
	
	@Override
	public void buildTree() {
		root = new TreeNode<String>("");
		
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
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}
	
	/**
	 * Sets the root of the MorseCodeTree 
	 * @param newNode A copy of newNode will be the new root
	 */
	
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	
	/**
	 * Returns a reference to the root
	 * @return Reference to root
	 */
	
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}
	
	/**
	 * This is the recursive method that fetches the data of the TreeNode that corresponds with the code A '.' (dot) means traverse to 
	 * the left. A "-" (dash) means traverse to the right. The code ".-" would fetch the data of the TreeNode 
	 * stored as the right child of the left child of the root
	 * @param root The root of the tree for this particular recursive instance of addNode
	 * @param code The code for this particular recursive instance of addNode 
	 * @return The string (letter) corresponding to the code
	 */
	
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if(code.length() == 1) {
			if(code.equals("."))
				letterFetched = root.getLeft().getData();
				
			else if(code.equals("-"))
				letterFetched = root.getRight().getData();
			
		} else {
			if(code.substring(0, 1).equals("."))
				fetchNode(root.getLeft(), code.substring(1));
			
			else if(code.substring(0, 1).equals("-"))
				fetchNode(root.getRight(), code.substring(1));
			
		}
		
		return letterFetched;
	}
	
	/**
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
	 * @param code The code that describes the traversals to retrieve the string (letter) 
	 * @return The string (letter) that corresponds to the code
	 */

	@Override
	public String fetch(String code) {
		String letter;
		
		letter = fetchNode(root, code);
		
		return letter;
	}
	
	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder) 
	 * @param root The root of the tree for this particular recursive instance
	 * @param list The ArrayList that will hold the contents of the tree in LNR order
	 */

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root != null) {
			LNRoutputTraversal(root.getLeft(), list);
			list.add(root.getData());
			LNRoutputTraversal(root.getRight(), list);
			
		}
	}
	
	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order Used for testing to make sure tree is built correctly
	 * @return An ArrayList of the items in the linked Tree
	 */
	
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> printTree = new ArrayList<String>();
		
		LNRoutputTraversal(root, printTree);
		
		return printTree;
	}
	
	/**
	 * This operation is not supported in the MorseCodeTree
	 * @param data Data of node to be deleted 
	 * @return Reference to the current tree
	 * @throws UnsupportedOperationException Not supported method
	 */
	
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		return null;
	}
	
	/**
	 * This operation is not supported in the MorseCodeTree
	 * @return Reference to the current tree
	 * @throws UnsupportedOperationException Not supported method
	 */

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		return null;
	}
}
