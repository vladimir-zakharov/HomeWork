package list;

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
    @Test
    public void testInsert() throws Exception {
        List<Integer> list = new List<Integer>();
        list.addToHead(15);
        list.insert(0, 5);
        list.insert(0, 10);
        list.insert(1, 20);
    }

    /**
     * Test of addToEnd method, of class List.
     */
    @Test
    public void testAddToEnd() {

    }

    /**
     * Test of addToHead method, of class List.
     */
    @Test
    public void testAddToHead() {

    }

    /**
     * Test of Exist method, of class List.
     */
    @Test
    public void testExist() {

    }

    /**
     * Test of amountElements method, of class List.
     */
    @Test
    public void testAmountElements() {

    }

    /**
     * Test of listIterator method, of class List.
     */
    @Test
    public void testListIterator() {

    }
}
