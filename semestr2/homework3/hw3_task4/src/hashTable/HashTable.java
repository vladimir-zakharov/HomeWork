package hashTable;

/**
 * use to create a hash table
 *
 * @author vladimir-zakharov
 */
public class HashTable {

    /**
     * constructor for hash table
     */
    public HashTable(HashFunctionInterface hashFunction) {
        for (int i = 0; i < hashSize; ++i) {
            this.buckets[i] = new List();
        }
        this.hashFunction = hashFunction;
    }

    /**
     * add element to hash table
     *
     * @param string string, which you want to add
     */
    public void addToHash(String string) {
        int index = hashFunction.hashFunction(string, hashSize);
        buckets[index].addToEnd(string);
    }

    /**
     * delete element of the hash table
     *
     * @param string string, which you want to delete
     */
    public void deleteElement(String string) {
        int hash = hashFunction.hashFunction(string, hashSize);
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
    public int getHashSize() {
        return hashSize;
    }

    public void changeHashFunction(HashFunctionInterface newHashFunction) {
        List[] newBuckets = new List[hashSize];
      
        for (int i = 0; i < hashSize; ++i) {
            newBuckets[i] = new List();
        }

        for (int i = 0; i < hashSize; ++i) {
            List.ListElement position = buckets[i].firstPosition();
            while (position != null) {
                String currentString = buckets[i].positionValue(position);
                int index = newHashFunction.hashFunction(currentString, hashSize);
                newBuckets[index].addToEnd(currentString);
                List.ListElement temp = position;
                position = buckets[i].nextPosition(position);
                buckets[i].deleteElement(temp);
            }        
        }
        
        System.arraycopy(newBuckets, 0, buckets, 0, hashSize);
        this.hashFunction = newHashFunction;
    }

    /**
     * checks existence of the element in the hash table
     *
     * @param string string, which you check for existence
     * @return true if exists; false if not exists
     */
    public boolean Exists(String string) {
        int hash = hashFunction.hashFunction(string, hashSize);
        return buckets[hash].Exist(string);
    }
    /**
     * size of hash table
     */
    final private int hashSize = 100;
    /**
     * hash table elements
     */
    private List[] buckets = new List[hashSize];
    /**
     * hash function
     */
    private HashFunctionInterface hashFunction;
}
