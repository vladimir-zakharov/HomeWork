package hashTable;

/**
 *
 * @author spec
 */
public class HashTable implements InterfaceHashTable {

    final private int hashSize = 100;

    public HashTable() {
        for (int i = 0; i < hashSize; ++i) {
            this.buckets[i] = new List();
        }
    }

    @Override
    public void addToHash(String string) {
        int index = hashFunction(string);
        buckets[index].addToEnd(string);
    }

    @Override
    public int returnHashSize() {
        return hashSize;
    }

    private int hashFunction(String string) {
        return string.hashCode() % hashSize;
    }
    private List[] buckets = new List[hashSize];
}
