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
        DefaultHashFunction hashFunction = new DefaultHashFunction();
        NewHashFunction newHashFunction = new NewHashFunction();
        HashTable hash = new HashTable(hashFunction);
        hash.addToHash("hello");
        hash = new HashTable(newHashFunction);
        hash.addToHash("ololo");
    }

    /**
     * Test of deleteElement method, of class HashTable.
     */
    @Test
    public void testDeleteElement() {
        DefaultHashFunction hashFunction = new DefaultHashFunction();
        NewHashFunction newHashFunction = new NewHashFunction();
        HashTable hash = new HashTable(hashFunction);
        hash.addToHash("hello");
        hash.addToHash("world");
        assertTrue(hash.isExists("hello"));
        hash.deleteElement("hello");
        assertFalse(hash.isExists("hello"));
        assertTrue(hash.isExists("world"));
        hash.deleteElement("world");
        assertFalse(hash.isExists("world"));
        hash = new HashTable(newHashFunction);
        hash.addToHash("ololo");
        assertTrue(hash.isExists("ololo"));
        hash.deleteElement("ololo");
        assertFalse(hash.isExists("ololo"));

    }

    /**
     * Test of returnHashSize method, of class HashTable.
     */
    @Test
    public void testReturnHashSize() {
        DefaultHashFunction hashFunction = new DefaultHashFunction();
        HashTable hash = new HashTable(hashFunction);
        assertEquals(100, hash.returnHashSize());
        assertFalse(hash.returnHashSize() == 5);
    }

    /**
     * Test of isExists method, of class HashTable.
     */
    @Test
    public void testIsExists() {
        DefaultHashFunction hashFunction = new DefaultHashFunction();
        HashTable hash = new HashTable(hashFunction);
        hash.addToHash("hello");
        hash.addToHash("world");
        assertTrue(hash.isExists("hello"));
        assertFalse(hash.isExists("test"));
        assertTrue(hash.isExists("world"));
    }

    public class NewHashFunction implements HashFunctionInterface {

        @Override
        public int hashFunction(String string, int hashSize) {

            int result = 0;
            for (int i = 0; i < string.length(); ++i) {
                result += string.charAt(i);
            }

            return result % hashSize;
        }
    }
}
