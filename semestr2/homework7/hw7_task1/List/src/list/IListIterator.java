package list;

/**
 *
 * @author vladimir-zakharov
 */
public interface IListIterator<ElementType> {
    
    ElementType next() throws NoElementsException;
    
    ElementType previous() throws NoElementsException;
    
    boolean hasNext();
    
    boolean hasPrevious();
    
    void deleteElement();
    
    void insert(ElementType value);
    
    void addToHead(ElementType value);
    
    void addToEnd(ElementType value);
    
}
