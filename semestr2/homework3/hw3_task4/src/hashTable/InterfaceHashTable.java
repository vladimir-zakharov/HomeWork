package hashTable;

/**
 * use to create a hash table
 *
 * @author vladimir-zakharov
 */
public interface InterfaceHashTable {

    /**
     * add element to hash table
     *
     * @param string string, which you want to add
     */
    void addToHash(String string);

    /**
     * delete element of the hash table
     *
     * @param string string, which you want to delete
     */
    void deleteElement(String string);

    /**
     * @return size of hash table
     */
    int getHashSize();

    /**
     * checks existence of the element in the hash table
     *
     * @param string string, which you check for existence
     * @return true if exists; false if not exists
     */
    boolean Exists(String string);
}
