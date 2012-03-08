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
     * Test of deleteElement method, of class HashTable.
     */
    @Test
    public void testDeleteElement() {
        HashTable hash = new HashTable();
        hash.addToHash("hello");
        hash.addToHash("world");
        assertEquals(true, hash.isExists("hello"));
        hash.deleteElement("hello");
        assertEquals(false, hash.isExists("hello"));
        assertEquals(true, hash.isExists("world"));
        hash.deleteElement("world");
        assertEquals(false, hash.isExists("world"));

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

    /**
     * Test of isExists method, of class HashTable.
     */
    @Test
    public void testIsExists() {
        HashTable hash = new HashTable();
        hash.addToHash("hello");
        hash.addToHash("world");
        assertEquals(true, hash.isExists("hello"));
        assertEquals(false, hash.isExists("test"));
        assertEquals(true, hash.isExists("world"));
    }
}
