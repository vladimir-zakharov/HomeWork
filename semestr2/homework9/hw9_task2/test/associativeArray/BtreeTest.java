package associativeArray;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author vladimir-zakharov
 */
public class BtreeTest {

    /**
     * Test of insert method, of class Btree.
     */
    @Test
    public void testInsert() {
        Btree<Integer> bTree = new Btree<Integer>();
        bTree.insert(10, 15);
        bTree.insert(5, 20);
        bTree.insert(15, 10);
        bTree.insert(16, 100);
        bTree.insert(17, 110);
        bTree.insert(18, 120);
        bTree.insert(19, 130);
        bTree.insert(20, 14);
        bTree.insert(21, 15);
        bTree.insert(22, 16);
        bTree.insert(23, 17);
    }

    /**
     * Test of insert method, of class Btree.
     */
    @Test(expected = NotFoundElementException.class)
    public void testInsertAlredyExists() throws Exception {
        Btree<Integer> bTree = new Btree<Integer>();
        bTree.insert(10, 15);
        bTree.insert(10, 20);
        bTree.remove(10);
        bTree.remove(10);
    }

    /**
     * Test of remove method, of class Btree.
     */
    @Test(expected = NotFoundElementException.class)
    public void testRemoveEmptyTree() throws Exception {
        Btree<Integer> bTree = new Btree<Integer>();
        bTree.remove(10);
    }

    /**
     * Test of remove method, of class Btree.
     */
    @Test(expected = NotFoundElementException.class)
    public void testRemoveNotFound() throws Exception {
        Btree<Integer> bTree = new Btree<Integer>();
        bTree.insert(10, 15);
        bTree.insert(5, 20);
        bTree.insert(15, 10);
        bTree.insert(16, 100);
        bTree.insert(17, 110);
        bTree.insert(18, 120);
        bTree.insert(19, 130);
        bTree.insert(20, 14);
        bTree.insert(21, 15);
        bTree.insert(22, 16);
        bTree.insert(23, 17);
        bTree.remove(30);
    }

    /**
     * Test of remove method, of class Btree.
     */
    @Test
    public void testRemove() throws Exception {
        Btree<Integer> bTree = new Btree<Integer>();
        bTree.insert(10, 15);
        bTree.insert(5, 20);
        bTree.insert(15, 10);
        bTree.insert(16, 100);
        bTree.insert(17, 110);
        bTree.insert(18, 120);
        bTree.insert(19, 130);
        bTree.insert(20, 14);
        bTree.insert(21, 15);
        bTree.insert(22, 16);
        bTree.insert(23, 17);
        bTree.remove(23);
        assertTrue(bTree.search(23) == null);
        bTree.remove(15);
        assertTrue(bTree.search(15) == null);
        bTree.remove(18);
        assertTrue(bTree.search(18) == null);
        bTree.remove(20);
        assertTrue(bTree.search(20) == null);
        bTree.remove(21);
        assertTrue(bTree.search(21) == null);
        bTree.remove(10);
        assertTrue(bTree.search(10) == null);
        bTree.remove(5);
        assertTrue(bTree.search(5) == null);
        bTree.remove(19);
        assertTrue(bTree.search(19) == null);
        bTree.remove(22);
        assertTrue(bTree.search(22) == null);
        bTree.remove(16);
        assertTrue(bTree.search(16) == null);
        bTree.remove(17);
        assertTrue(bTree.search(17) == null);
    }

    /**
     * Test of search method, of class Btree.
     */
    @Test
    public void testSearchEmptyTree() {
        Btree<Integer> bTree = new Btree<Integer>();
        assertTrue(bTree.search(10) == null);
    }

    /**
     * Test of search method, of class Btree.
     */
    @Test
    public void testSearchNotFound() {
        Btree<Integer> bTree = new Btree<Integer>();
        bTree.insert(10, 15);
        bTree.insert(5, 20);
        bTree.insert(15, 10);
        bTree.insert(16, 100);
        bTree.insert(17, 110);
        bTree.insert(18, 120);
        bTree.insert(19, 130);
        bTree.insert(20, 14);
        bTree.insert(21, 15);
        bTree.insert(22, 16);
        bTree.insert(23, 17);
        assertTrue(bTree.search(30) == null);
        assertTrue(bTree.search(1) == null);
        assertTrue(bTree.search(9) == null);
    }

    /**
     * Test of search method, of class Btree.
     */
    @Test
    public void testSearch() {
        Btree<Integer> bTree = new Btree<Integer>();
        bTree.insert(10, 15);
        bTree.insert(5, 20);
        bTree.insert(15, 10);
        bTree.insert(16, 100);
        bTree.insert(17, 110);
        bTree.insert(18, 120);
        bTree.insert(19, 130);
        bTree.insert(20, 14);
        bTree.insert(21, 15);
        bTree.insert(22, 16);
        bTree.insert(23, 17);
        int value = bTree.search(10);
        assertEquals(15, value);
        value = bTree.search(5);
        assertEquals(20, value);
        value = bTree.search(15);
        assertEquals(10, value);
        value = bTree.search(16);
        assertEquals(100, value);
        value = bTree.search(17);
        assertEquals(110, value);
        value = bTree.search(18);
        assertEquals(120, value);
        value = bTree.search(19);
        assertEquals(130, value);
        value = bTree.search(20);
        assertEquals(14, value);
        value = bTree.search(21);
        assertEquals(15, value);
        value = bTree.search(22);
        assertEquals(16, value);
        value = bTree.search(23);
        assertEquals(17, value);
    }
}
