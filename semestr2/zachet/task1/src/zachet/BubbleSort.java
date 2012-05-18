/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zachet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author vladimir-zakharov
 */
public class BubbleSort<Type> {

    /**
     * sorts list
     * @param list list, which you want to sort
     * @param comp comparator for compare elemnents
     * @return sorted list
     */
    public List<Type> bubbleSort(List<Type> list, Comparator<Type> comp) {

        for (int i = 0; i < list.size() - 1; ++i) {
            for (int j = 0; j < list.size() - i - 1; ++j) {
                if (comp.compare(list.get(j), list.get(j + 1)) == 1) {
                    Type temp = list.get(j);
                    list.remove(j);
                    list.add(j + 1, temp);
                }
            }
        }
        
        return list;
    }

    public static void main(String[] argv) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(1);
        list.add(4);
        list.add(2);
        Comparator<Integer> comp = new MyComparator<Integer>();
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        BubbleSort<Integer> sort = new BubbleSort<Integer>();
        list = sort.bubbleSort(list, comp);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
