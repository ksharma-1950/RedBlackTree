/**
 * Runs and thoroughly tests the methods implemented in RedBlackNode.java.
 
 * @author Kartikeya Sharma
 * @course Advanced Topics in Computer Science 2
 * @mentor Mr. Burkhart
 * @institution The Pingry School, Basking Ridge, NJ
 * @version 1.0
 */

public class RedBlackNodeRunner {
    public static void main (String[] args) {
        
        /**
         * Tests one parameter constructor.
         * 'True' denotes a black node, whereas 'false' denotes a red node.
         */
        
        RedBlackNode<Integer, String> node1 = new RedBlackNode<Integer, String>(true);
        RedBlackNode<Integer, String> node2 = new RedBlackNode<Integer, String>(false);
        RedBlackNode<Integer, String> node3 = new RedBlackNode<Integer, String>(false);
        System.out.println("1. Testing one parameter constructor...");
        System.out.println("Left child node should be null: " + node3.getLeft());
        System.out.println("Right child node should be null: " + node3.getRight());
        System.out.println();
        
        /**
         * Tests three parameter constructor.
         */
        
        RedBlackNode<Integer, String> node4 = new RedBlackNode<Integer, String>(true, null, null);
        
        /**
         * Tests getColor().
         */
        
        System.out.println("2. Testing getColor() and setColor()...");
        System.out.println("Initialized color should be black ('true'): " + node4.getColor());
        
        /**
         * Tests setColor().
         */
        
        node4.setColor("red");
        System.out.println("Changed color should now be red ('false'): " + node4.getColor());
        System.out.println();
        
        /**
         * Testing getLeft() and getRight().
         */
        
        System.out.println("3. Testing getLeft()/getRight()...");
        System.out.println("Left child node: " + node4.getLeft());
        System.out.println("Right child node: " + node4.getRight());
        System.out.println();
        
        /**
         * Tests setLeft() and setRight().
         * getLeft() and getRight() functions tested in previous test.
         */
        
        node1.setLeft(node3);
        node1.setRight(node2);
        System.out.println("4. Testing setLeft()/setRight()...");
        System.out.println("Left child node should be " + node3 + ": " + node1.getLeft());
        System.out.println("Right child node should be " + node2 + ": " + node1.getRight());
        System.out.println();
    }
}
