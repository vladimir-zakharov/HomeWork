package list;

/**
 *
 * @author vladimir-zakharov
 */
public interface IListIterator<ElementType> {
    
    void next() throws NoElementsException;
    
    void previous() throws NoElementsException;
    
    ElementType currentItem();
    
    boolean hasNext();
    
    boolean hasPrevious();
    
    void deleteElement() throws NoElementsException;
    
}
