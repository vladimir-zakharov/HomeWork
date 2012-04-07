package stack;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests for Stack
 *
 * @author vladimir-zakharov
 */
public class StackTest {

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(15);
        stack.push(20);
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test(expected = EmptyStack.class)
    public void testPop() throws EmptyStack {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(15);
        stack.push(20);
        assertTrue(stack.top() == 20);
        stack.pop();
        assertTrue(stack.top() == 15);
        stack.pop();
        assertTrue(stack.top() == 10);
        stack.pop();
        stack.pop();

    }

    /**
     * Test of top method, of class Stack.
     */
    @Test
    public void testTop() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(20);
        assertTrue(stack.top() == 20);
        stack.push(15);
        assertTrue(stack.top() == 15);
        stack.push(10);
        assertTrue(stack.top() == 10);
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() throws EmptyStack {
        Stack<Integer> stack = new Stack<Integer>();
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }
}
