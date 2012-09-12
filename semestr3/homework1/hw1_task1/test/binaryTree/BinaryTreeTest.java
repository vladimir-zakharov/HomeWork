package binaryTree;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author vladimir-zakharov
 */
public class BinaryTreeTest {

    /**
     * Test of print method, of class BinaryTree.
     */
    @Test
    public void testPrint() {
        BinaryTree tree = new BinaryTree();
        tree.addValue(10);
        tree.addValue(7);
        tree.addValue(9);
        tree.addValue(5);
        tree.addValue(15);
        tree.addValue(20);
        tree.print();
    }

    /**
     * Test of addValue method, of class BinaryTree.
     */
    @Test
    public void testAddValue() {
        BinaryTree tree = new BinaryTree();
        tree.addValue(10);
        tree.addValue(7);
        tree.addValue(9);
        tree.addValue(5);
        tree.addValue(15);
        tree.addValue(20);
    }
}
