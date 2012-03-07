package hashTable;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author vladimir-zakharov
 */
public class HashTableTest {

    public HashTableTest() {
    }

    /**
     * Test of addToHash method, of class HashTable.
     */
    @Test
    public void testAddToHash() {
        HashTable hash = new HashTable();
        hash.addToHash("hello");
    }

    /**
     * Test of returnHashSize method, of class HashTable.
     */
    @Test
    public void testReturnHashSize() {
        HashTable hash = new HashTable();
        assertEquals(100, hash.returnHashSize());
        assertFalse(hash.returnHashSize() == 5);
    }
}
