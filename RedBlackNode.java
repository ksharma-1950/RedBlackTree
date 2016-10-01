/**
 * A RedBlackNode object serve as nodes to a red-black tree.
 * A red-black tree is a 'self-balancing' binary search trees (BST) with an
 * extra class field color, represented as a boolean variable.
 * A unique property of red-black trees is that every path from the root 
 * to a null (empty) node has same number of black nodes.
 * Overall, the making of red-black trees is an attempt to make searching 
 * through binary trees more efficient, rather than an endless list of items 
 * (linked list), more efficient.
 
 * @author Kartikeya Sharma
 * @course Advanced Topics in Computer Science 2
 * @mentor Mr. Burkhart
 * @institution The Pingry School, Basking Ridge, NJ
 * @version 1.0
 */

public class RedBlackNode<K extends Comparable,V> implements Comparable<RedBlackNode<K,V>>{
    
    /**
     * The red and black boolean constants make the readability for
     * RedBlackNode easier. A true value (of the boolean variable color)
     * denotes a black node, whereas a false value denotes a red one.
     */
    
    private static final boolean BLACK = true;
    private static final boolean RED = false;
    
    /**
     * RedBlackNode holds left and right children nodes, as well as
     * an inherent key (of generic type K) and value (of generic type V).
     * Red-black nodes have an additional color property compared to
     * binary search tree nodes.
     */
    
    protected boolean color;
    protected K key;
    protected V value;
	protected RedBlackNode<K,V> left;
	protected RedBlackNode<K,V> right;
    
    /**
     * Constructors utilize each other to finally initialize the object 
     * in constructor RedBlackNode(boolean, K, V, RedBlackNode<K,V>, RedBlackNode<K,V>).
     */
    
    /**
     * Default constructor
     * Sets color to black, and through using other constructors,
     * sets children, key, and value to null.
     * Useful for creating leaves, which are black by default.
     */
     
    public RedBlackNode() {
        this(BLACK);
    }
	
    /**
     * Constructor
     * Sets inputted color ('true' is black, whereas 'false' is red).
     * @param color Boolean representation of the specified color for the node.
     */
    
     public RedBlackNode(boolean color) {
        this(color, null, null);
	}
    
    /**
     * Constructor
     * Sets inputted color ('true' is black, whereas 'false' is red).
     * Sets key and value of node.
     * @param color Boolean representation of the specified color for the node.
     * @param key Key of the node.
     * @param value Value the node holds.
     */
    
    public RedBlackNode(boolean color, K key, V value) {
        this(color, key, value, null, null);
    }
	
    /** 
     * Constructor
     * Sets inputted color ('true' is black, whereas 'false' is red).
     * Sets key and value of node.
     * Sets left and right children nodes.
     * @param color Boolean representation of the specified color for the node.
     * @param key Key of the node.
     * @param value Value the node holds.
     * @param left Left child node.
     * @param right Right child node.
     */
     
	public RedBlackNode(boolean color, K key, V value, RedBlackNode<K,V> left, RedBlackNode<K,V> right) {
        setColor(color);
        setKey(key);
        setValue(value);
        setLeft(left);
        setRight(right);
	}
	
    /**
     * Sets the node color.
     * True represents black, whereas false represents red.
     * @param color Boolean representation of the specified color for the node.
     */
    
	public void setColor(boolean color) {
        this.color = color;
	}
	
    /**
     * Sets the node color to true if the inputted String object
     * has a capital-insensitive value equivalent to "b" or "black".
     * Sets the node color to false if the inputted String object
     * has a capital-insensitive value equivalent to "r" or "red".
     * @param color String representation of the specified color for the node.
     */
    
    public void setColor(String color) {
        if (color.equalsIgnoreCase("b") || color.equalsIgnoreCase("black")) {
            this.color = BLACK;
        }
        else if (color.equalsIgnoreCase("r") || color.equalsIgnoreCase("red")) {
            this.color = RED;
        }
        else {
            System.out.println("Node color has not been set. Please specify 'b' or 'black' to specify the node color as black or 'r' or 'red' to specify the node color as red.");
        }
    }
    
    /**
     * Sets the left child node for this node object.
     * @param left Left child node.
     */
    
	// Side note for myself:
    // If the node and child node are not different colors, need to fix the tree.
    
	public void setLeft(RedBlackNode<K,V> left) {
		this.left = left;
	}
	
    /**
     * Sets the right child node for this node object.
     * @param right Right child node.
     */
    
    // Side note for myself:
	// If the node and child node are not different colors, need to fix the tree.
    
	public void setRight(RedBlackNode<K,V> right) {
		this.right = right;
	}
    
    /**
     * Sets inputted node as the specified child of this node.
     
     * @param node Node to be set as the specified child of this node.
     * @param Boolean representation of which child the inputted node
     * will be of this node, i.e. the parent node.
     */
    
    public void setChild(RedBlackNode<K,V> node, boolean side) {
        if (side == true) {
            setLeft(node);
        }
        else {
            setRight(node);
        }
    }
    
    /**
     * Sets the key for this node.
     * @param key Key of the node.
     */
    
    public void setKey(K key) {
        this.key = key;
    }
    
    /**
     * Sets the value for the node.
     * @param value Value the node holds.
     */
    
    public void setValue(V value) {
        this.value = value;
    }
	
    /** 
     * Returns a boolean representation of the node color.
     * True represents black, whereas false represents red.
     * @return A boolean representation of the node.
     */
    
	public boolean getColor() {
		return color;
	}
	
    /**
     * Returns the left child node of the node.
     * @return Left child node of the node.
     */
    
	public RedBlackNode<K,V> getLeft() {
		return left;
	}
	
    /**
     * Returns the right child node of the node.
     * @return Right child node of the node.
     */
    
	public RedBlackNode<K,V> getRight() {
		return right;
	}
    
    /**
     * Returns the requested child node of the node inputted.
     
     * @param node Node whose child node is being requested.
     * @param side Boolean representation of which child node to be 
     * returned. True for left child node, and false for right child node.
     * @return Requested child node of inputted node.
     */
    
    public RedBlackNode<K,V> getChild(RedBlackNode<K,V> node, boolean side) {
        if (side == true) {
            return getLeft();
        }
        else {
            return getRight();
        }
    }
    
    /**
     * Returns the key of the node.
     * @return Key of the node.
     */
    
    public K getKey() {
        return key;
    }
    
    /**
     * Returns the value of the node.
     * @return Value of the node.
     */
    
    public V getValue() {
        return value;
    }
    
    /**
     * Uses compareTo method of K class
     * Note: the K class has already been checked for implementation of
     * the Comparable interface in the RedBlackNode class signature.
     * @return Returns -1, zero, or (positive) 1 if this object is
     * less than, equal to, or greater than the specified object respectively.
     */
    
    @SuppressWarnings("unchecked")
    public int compareTo(RedBlackNode<K,V> node) {
        if (!(this.key instanceof Comparable)) {
            throw new IllegalArgumentException(
            "K generic in RedBlackNode<K,V> must extend interface Comparable.");
        }
        if (!(node.getKey() instanceof Comparable)) {
            throw new IllegalArgumentException(
            "K generic in RedBlackNode<K,V> must extend interface Comparable.");
        }
        int output = this.key.compareTo(node.getKey());
        if (output > 0) {
            return 1;
        }
        else if (output < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }
    
}
