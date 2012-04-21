package list;

import java.util.Iterator;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author vladimir-zakharov
 */
public class ListIteratorTest {

    /**
     * Test of next method, of class ListIterator.
     */
    @Test
    public void testNext() {
        List<Integer> list = new List<Integer>();
        list.addToHead(15);
        list.addToHead(10);
        list.addToHead(20);
        ListIterator<Integer> iterator = list.iterator();
        assertEquals(20, (int) iterator.next());
        assertEquals(10, (int) iterator.next());
    }

    /**
     * Test of previous method, of class ListIterator.
     */
    @Test
    public void testPrevious() {
        List<Integer> list = new List<Integer>();
        list.addToHead(15);
        list.addToHead(10);
        list.addToHead(20);
        ListIterator<Integer> iterator = list.iterator();
        iterator.next();
        iterator.next();
        assertEquals(15, (int) iterator.previous());
        assertEquals(10, (int) iterator.previous());
    }

    /**
     * Test of hasNext method, of class ListIterator.
     */
    @Test
    public void testHasNext() {
        List<Integer> list = new List<Integer>();
        list.addToHead(15);
        list.addToHead(10);
        list.addToHead(20);
        ListIterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    /**
     * Test of hasPrevious method, of class ListIterator.
     */
    @Test
    public void testHasPrevious() {
        List<Integer> list = new List<Integer>();
        list.addToHead(15);
        list.addToHead(10);
        list.addToHead(20);
        ListIterator<Integer> iterator = list.iterator();
        iterator.previous();
        assertFalse(iterator.hasPrevious());
        iterator.next();
        assertTrue(iterator.hasPrevious());
    }

    /**
     * Test of remove method, of class ListIterator.
     */
    @Test
    public void testRemove() {
        List<Integer> list = new List<Integer>();
        list.addToHead(15);
        list.addToHead(10);
        list.addToHead(20);
        ListIterator<Integer> iterator = list.iterator();
        assertTrue(list.exist(20));
        iterator.remove();
        assertFalse(list.exist(20));
        assertTrue(list.exist(15));
        iterator.next();
        iterator.remove();
        assertFalse(list.exist(15));
    }

     /**
     * Test foreach.
     */
    @Test
    public void testForeach() {
        List<Integer> list = new List<Integer>();
        list.addToHead(15);
        list.addToHead(10);
        list.addToHead(20);
        list.addToHead(25);
        ListIterator<Integer> iter = list.iterator();
        int count = 0;
        
        for (Integer i : list) {
            assertEquals(iter.next(), i);
            count++;
        }
        
        assertEquals(count, list.amountElements());
    }
    
}
