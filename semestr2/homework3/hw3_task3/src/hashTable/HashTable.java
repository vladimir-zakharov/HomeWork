package hashTable;

/**
 * use to create Hash table
 *
 * @author vladimir-zakharov
 */
public class HashTable implements InterfaceHashTable {

    /**
     * size of hash table
     */
    final private int hashSize = 100;

    /**
     * constructor for hash table
     */
    public HashTable() {
        for (int i = 0; i < hashSize; ++i) {
            this.buckets[i] = new List();
        }
    }

    /**
     * add element to hash table
     *
     * @param string
     */
    @Override
    public void addToHash(String string) {
        int index = hashFunction(string);
        buckets[index].addToEnd(string);
    }

    /**
     * return size of hash table
     *
     * @return
     */
    @Override
    public int returnHashSize() {
        return hashSize;
    }

    /**
     * calculate hash function
     *
     * @param string
     * @return
     */
    private int hashFunction(String string) {
        return string.hashCode() % hashSize;
    }
    /**
     * hash table elements
     */
    private List[] buckets = new List[hashSize];
}
