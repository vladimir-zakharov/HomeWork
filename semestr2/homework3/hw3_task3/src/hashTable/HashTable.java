package hashTable;

/**
 * use to create a hash table
 *
 * @author vladimir-zakharov
 */
public class HashTable implements InterfaceHashTable {

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
     * @param string string, which you want to add
     */
    @Override
    public void addToHash(String string) {
        int index = hashFunction(string);
        buckets[index].addToEnd(string);
    }

    /**
     * delete element of the hash table
     *
     * @param string string, which you want to delete
     */
    @Override
    public void deleteElement(String string) {
        int hash = hashFunction(string);
        List.ListElement temp = buckets[hash].searchPosition(string);

        if (temp != null) {
            buckets[hash].deleteElement(temp);
            System.out.println("Successfully deletion");
        } else {
            System.out.println("Element not found");
        }
    }

    /**
     * @return size of hash table
     */
    @Override
    public int returnHashSize() {
        return hashSize;
    }

    /**
     * checks existence of the element in the hash table
     *
     * @param string string, which you check for existence
     * @return true if exists; false if not exists
     */
    @Override
    public boolean isExists(String string) {
        int hash = hashFunction(string);
        return buckets[hash].isExist(string);
    }

    /**
     * calculate the hash function
     *
     * @param string calculate hash function for this string
     * @return hash function of string
     */
    private int hashFunction(String string) {
        return string.hashCode() % hashSize;
    }
    
    /**
     * size of hash table
     */
    final private int hashSize = 100;
    
    /**
     * hash table elements
     */
    private List[] buckets = new List[hashSize];
}
