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
        assertTrue(hash.Exists("hello"));
        hash.changeHashFunction(newHashFunction);
        assertTrue(hash.Exists("hello"));
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
        assertTrue(hash.Exists("hello"));
        hash.deleteElement("hello");
        assertFalse(hash.Exists("hello"));
        assertTrue(hash.Exists("world"));
        hash.deleteElement("world");
        assertFalse(hash.Exists("world"));
        hash.changeHashFunction(newHashFunction);
        hash.addToHash("ololo");
        assertTrue(hash.Exists("ololo"));
        hash.deleteElement("ololo");
        assertFalse(hash.Exists("ololo"));

    }

    /**
     * Test of returnHashSize method, of class HashTable.
     */
    @Test
    public void testReturnHashSize() {
        DefaultHashFunction hashFunction = new DefaultHashFunction();
        HashTable hash = new HashTable(hashFunction);
        assertEquals(100, hash.getHashSize());
        assertFalse(hash.getHashSize() == 5);
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
        assertTrue(hash.Exists("hello"));
        assertFalse(hash.Exists("test"));
        assertTrue(hash.Exists("world"));
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
