package list;

import java.util.Iterator;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author vladimir-zakharov
 */
public class ListTest {

    /**
     * Test of insert method, of class List.
     */
    @Test(expected = ListIndexOutOfBoundsException.class)
    public void testInsert() {
        List<Integer> list = new List<Integer>();
        list.addToHead(15);
        list.insert(0, 5);
        list.insert(0, 10);
        list.insert(1, 20);
        list.insert(17, 100);
    }

    /**
     * Test of addToEnd method, of class List.
     */
    @Test
    public void testAddToEnd() {
        List<Integer> list = new List<Integer>();
        list.addToEnd(15);
        list.addToEnd(10);
        list.addToEnd(20);
    }

    /**
     * Test of addToHead method, of class List.
     */
    @Test
    public void testAddToHead() {
        List<Integer> list = new List<Integer>();
        list.addToHead(15);
        list.addToHead(10);
        list.addToHead(20);
    }

    /**
     * Test of exist method, of class List.
     */
    @Test
    public void testExist() {
        List<Integer> list = new List<Integer>();
        assertFalse(list.exist(1));
        list.addToHead(15);
        list.insert(0, 5);
        list.insert(0, 10);
        list.insert(1, 20);
        assertTrue(list.exist(15));
        assertTrue(list.exist(5));
        assertTrue(list.exist(20));
        assertTrue(list.exist(10));
        assertFalse(list.exist(123));
        assertFalse(list.exist(41));
    }

    /**
     * Test of amountElements method, of class List.
     */
    @Test
    public void testAmountElements() {
        List<Integer> list = new List<Integer>();
        list.addToHead(15);
        list.insert(0, 5);
        list.addToEnd(20);
        assertEquals(3, list.amountElements());
    }

    /**
     * Test of listIterator method, of class List.
     */
    @Test
    public void testListIterator() {
        List<Integer> list = new List<Integer>();
        ListIterator<Integer> iterator = list.iterator();
    }
}
