package uniqueList;

import java.util.Iterator;

/**
 *
 * @author vladimir-zakharov
 */
interface ListIterator<ElementType> extends Iterator<ElementType> {

    /**
     * Returns the current element value and advances the cursor to previous position.
     * 
     * @return the current element value
     * @throws NoSuchElementException if the iteration has no previous element
     */
    public ElementType previous();

    /**
     * @return true if the list iterator has previous element; else false
     */
    public boolean hasPrevious();
}
