package hashTable;

/**
 *
 * @author vladimir-zakharov
 */
public class DefaultHashFunction implements HashFunctionInterface {

    /**
     * calculate the hash function
     *
     * @param string calculate hash function for this string
     * @param hashSize size of hashTable
     * @return hash function of string
     */
    @Override
    public int hashFunction(String string, int hashSize) {
        return string.hashCode() % hashSize;
    }
}
