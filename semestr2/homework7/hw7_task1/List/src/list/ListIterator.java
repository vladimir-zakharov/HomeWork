/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import java.util.Iterator;

/**
 *
 * @author vladimir-zakharov
 */
interface ListIterator<ElementType> extends Iterator<ElementType> {

    /**
     * 
     * @return 
     */
    public ElementType previous();

    /**
     * 
     * @return 
     */
    public boolean hasPrevious();
}
