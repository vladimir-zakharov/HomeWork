/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zachet;

import java.util.Comparator;

/**
 *
 * @author vladimir-zakharov
 */
public class MyComparator<Type extends Comparable<Type>> implements Comparator<Type> {

    @Override
    public int compare(Type first, Type second) {
        if (first.equals(second)) {
            return 0;
        } else if (first.compareTo(second) < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
