/**
 * The class includes methods, setters, accessors, and other appropriate methods,
 * functions, and helper functions to implement the data structure red-black tree. 
 * A red-black tree is a 'self-balancing' binary search trees (BST) with an
 * extra class field color, represented as a boolean variable.
 * A unique property of red-black trees is that every path from the root
 * to a null (empty) node has same number of black nodes.
 * Overall, the making of red-black trees is an attempt to make searching
 * through binary trees more efficient, rather than an endless list of items
 * (linked list), more efficient.
 
 * The goal of a red black tree is to keep the path from the root to each leaf constant 
 * (a certain height of 2Log2(n+1)). There are two main types of 'self-balancing':
 * (1) recoloring and (2) rotation.
 
 * @author Kartikeya Sharma
 * @course Advanced Topics in Computer Science 2
 * @mentor Mr. Burkhart
 * @institution The Pingry School, Basking Ridge, NJ
 * @version 1.0
 */

public class RedBlackTree<K extends Comparable,V> {
    
    /**
     * Class Field
     * The root node of the tree from which subsequent children node branch off.
     */
    
	protected RedBlackNode<K,V> root;
	
    /**
     * Default Constructor
     * Since no root node has been specified, tree is instantiated with 
     * null node.
     */
    
	public RedBlackTree() {
		this(new RedBlackNode<K,V>());
	}
	
    /** Constructor
     * Constructs tree with the specified root.
     * Uses setRoot(RedBlackNode<K,V>) to avoid code repetition.
     * @param root Specified root for red-black tree.
     */
    
	public RedBlackTree(RedBlackNode<K,V> root) {
		setRoot(root);
	}
    
    /**
     * Inserts node into tree by first finding a valid and available spot.
     * A valid spot is defined as: the left child node of any specified node
     * is less than the specified (parent) node, and the right child node of any specified
     * node is greater than the specified node. If a cetain left or right child
     * node does not exist, i.e. is null, the "spot" in th tree is considered
     * available. If a duplicate is found, the inputted node is not inserted into the tree
     * and false is returned. Otherwise, if no duplicate is found, the inputted node
     * is inserted into the tree and true is returned.
     
     * Once the leaf node has been added to the tree, a central property to 
     * red-black trees is checked against: no red node can have a red parent node.
     * Since all nodes inserted (inserted as leaves) must be red, any node that
     * is being inserted into the tree under a red parent node must be handled separately.
     * Such a situation is handled by the helper method handleRedParent().
     
     * @param node Node to be inserted into the tree if a duplicate is not found.
     * @return True upon successful insertion into the tree.
     */
     
    public boolean insert(RedBlackNode<K,V> node) {
        // Must initially try to insert node as a red leaf node into the red-black tree.
        // True resembles black, and false resembles red.
        if (node.getColor()==true) {
            node.setColor(false);
        }
        RedBlackNode<K,V> currentNode = root;
        boolean run=true;
        while (run) {
            if (node.compareTo(currentNode)==0) {
                return false;
            }
            else if (node.compareTo(currentNode)<0){
                if (currentNode.getLeft()==null) {
                    currentNode.setLeft(node);
                    if (currentNode.getColor()==false) {
                        handleRedParent(node, currentNode, true);
                    }
                    return true;
                }
                else {
                    currentNode = currentNode.getLeft();
                }
            }
            else {
                if (currentNode.getRight()==null) {
                    currentNode.setRight(node);
                    if (currentNode.getColor()==true) {
                        handleRedParent(node, currentNode, false);
                    }
                    return true;
                }
                else {
                    currentNode = currentNode.getRight();
                }
            }
        }
        return false;
    }
    
    /**
     * Serves as a helper method to insert().
     * handleRedParent() resolves the violation of the red-black tree property:
     * No red node can have a red parent node.
     
     * @param node Node to be inserted into the tree and whose parent is red.
     * @param parent Parent node of node being inserted into the tree, whose red
     * property mutually violates the no red-red parent-child rule.
     * @param size Boolean representation of which child of the parent node the node to
     * be inserted will be designated as. True represents "left child," whereas false
     * represents "right child."
     * @return True upon successful no red-red parent-child rule violation handling.
     */
    
    // Work-in-progress. Not complete.
    private boolean handleRedParent(RedBlackNode<K,V> childNode, RedBlackNode<K,V> parent, boolean side) {
        if (parent.getChild(!side)==null) {
//            rotate();
//            recolor();
        }
        else if (parent.getChild(!side).getColor()==true) {
//            recolor();
            // check again
        }
        return false;
    }
	
    /**
     * Sets the inputted node as the root of the tree.
     * @param root Node to be set as the root of the tree.
     */
    
	public void setRoot(RedBlackNode<K,V> root) {
		this.root = root;
	}
	
    /**
     * Gets the node designated as the root of the tree in the root class field.
     * @return Root node of the tree.
     */
    
	public RedBlackNode<K,V> getRoot() {
		return root;
	}
}
