package hashTable;

/**
 * use to calculate hash function
 * 
 * @author vladimir-zakharov
 */
public interface HashFunctionInterface {

    /**
     * calculate the hash function
     *
     * @param string calculate hash function for this string
     * @param hashSize size of hashTable
     * @return hash function of string
     */
    public int hashFunction(String string, int hashSize);
}
