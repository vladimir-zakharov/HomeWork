/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zachet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author vladimir-zakharov
 */
public class BubbleSortTest {

    /**
     * Test of bubbleSort method, of class BubbleSort.
     */
    @Test
    public void testBubbleSortInteger() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(1);
        list.add(4);
        list.add(2);
        Comparator<Integer> comp = new MyComparator<Integer>();
        BubbleSort<Integer> sort = new BubbleSort<Integer>();
        list = sort.bubbleSort(list, comp);
        for (int i = 0; i < list.size() - 1; ++i) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }
    
    /**
     * Test of bubbleSort method, of class BubbleSort.
     */
    @Test
    public void testBubbleSortString() {
        List<String> list = new ArrayList<String>();
        list.add("aab");
        list.add("aac");
        list.add("aaa");
        list.add("aaa");
        list.add("aac");
        list.add("aad");
        Comparator<String> comp = new MyComparator<String>();
        BubbleSort<String> sort = new BubbleSort<String>();
        list = sort.bubbleSort(list, comp);
        for (int i = 0; i < list.size() - 1; ++i) {
            assertTrue(list.get(i).compareTo(list.get(i + 1)) <= 0);
        }
    }
    
        /**
     * Test of bubbleSort method, of class BubbleSort.
     */
    @Test
    public void testBubbleSortDouble() {
        List<Double> list = new ArrayList<Double>();
        list.add(1.3);
        list.add(0.4);
        list.add(432.1);
        list.add(12.6);
        Comparator<Double> comp = new MyComparator<Double>();
        BubbleSort<Double> sort = new BubbleSort<Double>();
        list = sort.bubbleSort(list, comp);
        for (int i = 0; i < list.size() - 1; ++i) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }
}
