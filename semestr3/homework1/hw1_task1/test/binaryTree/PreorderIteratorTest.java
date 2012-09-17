package binaryTree;

import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author vladimir-zakharov
 */
public class PreorderIteratorTest {

    /**
     * Test of next method, of class PreorderIterator.
     */
    @Test
    public void testNext() {
        BinaryTree tree = new BinaryTree();
        tree.addValue(10);
        tree.addValue(7);
        tree.addValue(9);
        tree.addValue(5);
        tree.addValue(15);
        tree.addValue(20);
        Integer values[] = {10, 7, 5, 9, 15, 20};
        int i = 0;
        PreorderIterator iter = tree.iterator();
        while (iter.hasNext()) {
            assertEquals(iter.next(), values[i]);
            i++;
        }
    }

    /**
     * Test of next method's exception , of class PreorderIterator.
     */
    @Test(expected = NoSuchElementException.class)
    public void testNextException() {
        BinaryTree tree = new BinaryTree();
        tree.addValue(10);
        tree.addValue(7);
        PreorderIterator iter = tree.iterator();
        iter.next();
        iter.next();
        iter.next();
    }

    /**
     * Test of hasNext method, of class PreorderIterator.
     */
    @Test
    public void testHasNext() {
        BinaryTree tree = new BinaryTree();
        tree.addValue(10);
        tree.addValue(7);
        PreorderIterator iter = tree.iterator();
        assertTrue(iter.hasNext());
        iter.next();
        assertTrue(iter.hasNext());
        iter.next();
        assertFalse(iter.hasNext());
    }

    /**
     * Test IteratorForeach.
     */
    @Test
    public void testForeach() {
        BinaryTree tree = new BinaryTree();
        tree.addValue(10);
        tree.addValue(7);
        tree.addValue(9);
        tree.addValue(5);
        tree.addValue(15);
        tree.addValue(20);

        PreorderIterator iter = tree.iterator();

        for (Integer i : tree) {
            assertEquals(iter.next(), i);
        }
    }
}
