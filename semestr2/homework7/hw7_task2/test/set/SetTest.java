/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package set;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test for class Set
 * 
 * @author vladimir-zakharov
 */
public class SetTest {

    /**
     * Test of addElement method, of class Set.
     */
    @Test(expected = ExistException.class)
    public void testAddElement() throws Exception {
        Set<Integer> set = new Set<Integer>();
        set.addElement(10);
        set.addElement(124);
        set.addElement(41);
        set.addElement(10);
    }

    /**
     * Test of Exist method, of class Set.
     */
    @Test
    public void testExist() throws Exception {
        Set<Integer> set = new Set<Integer>();
        set.addElement(10);
        set.addElement(124);
        set.addElement(41);
        assertTrue(set.Exist(10));
        assertTrue(set.Exist(124));
        assertTrue(set.Exist(41));
        assertFalse(set.Exist(51));
    }

    /**
     * Test of deleteElement method, of class Set.
     */
    @Test(expected = NotFoundElementException.class)
    public void testDeleteElement() throws Exception {
        Set<Integer> set = new Set<Integer>();
        set.addElement(10);
        set.deleteElement(10);
        set.addElement(10);
        set.addElement(124);
        set.addElement(41);
        set.deleteElement(124);
        set.deleteElement(123);
        set.deleteElement(10);
        set.deleteElement(41);
        set.deleteElement(1);
    }

    /**
     * Test of intersection method, of class Set.
     */
    @Test
    public void testIntersection() throws Exception {
        Set<Integer> firstSet = new Set<Integer>();
        Set<Integer> secondSet = new Set<Integer>();

        firstSet.addElement(10);
        firstSet.addElement(124);
        firstSet.addElement(41);

        secondSet.addElement(10);
        secondSet.addElement(41);

        Set<Integer> intersectionSet = firstSet.intersection(secondSet);

        assertTrue(intersectionSet.Exist(10));
        assertTrue(intersectionSet.Exist(41));
        assertFalse(intersectionSet.Exist(124));
    }

    /**
     * Test of union method, of class Set.
     */
    @Test(expected = ExistException.class)
    public void testUnion() throws Exception {
        Set<Integer> firstSet = new Set<Integer>();
        Set<Integer> secondSet = new Set<Integer>();

        firstSet.addElement(10);
        firstSet.addElement(124);
        firstSet.addElement(41);

        secondSet.addElement(10);
        secondSet.addElement(41);
        secondSet.addElement(15);
        secondSet.addElement(123);

        Set<Integer> unionSet = firstSet.union(secondSet);

        assertTrue(unionSet.Exist(10));
        assertTrue(unionSet.Exist(124));
        assertTrue(unionSet.Exist(41));
        assertTrue(unionSet.Exist(15));
        assertTrue(unionSet.Exist(123));
    }
}
