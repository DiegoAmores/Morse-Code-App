package MorseCode;
/**
 * This class is the Tree Node class for the Morse Code Tree
 * It consists of a Tree Node with generic data and references to both left and right Node types
 * 
 * Tree Node Generic Type
 * 
 * @author Diego Amores
 *
 */

public class TreeNode<T> {
	protected T data;
	protected TreeNode<T> left;
	protected TreeNode<T> right;
	
	/**
	 * Constructor that creates a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode The data to be stored in the TreeNode
	 */
	
	public TreeNode(T dataNode) {
		left = right = null;
		data = dataNode;
		
	}
	
	/**
	 * Constructor used for making deep copies
	 * @param node Node to make copy of
	 */
	
	public TreeNode(TreeNode<T> node) {
		node.data = data;
		
		if(this.left != null)
			node.left = this.left;
		if(this.right != null)
			node.right = this.right;

	}
	
	/**
	 * Returns the data within this TreeNode 
	 * @return The data within the TreeNode
	 */
	
	public T getData() {
		return data;
		
	}
	
	/**
	 * Returns left Tree Node reference
	 * @return The left Tree Node reference
	 */
	
	public TreeNode<T> getLeft() {
		return left;
		
	}
	
	/**
	 * Returns right Tree Node reference
	 * @return The right Tree Node reference
	 */
	
	public TreeNode<T> getRight() {
		return right;
		
	}
}
