package queue;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests for PriorityQueue
 *
 * @author vladimir-zakharov
 */
public class PriorityQueueTest {

    /**
     * Test of enqueue method, of class PriorityQueue.
     */
    @Test
    public void testEnqueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.enqueue(10, 2);
        queue.enqueue(5, 4);
        queue.enqueue(345, 1);
        queue.enqueue(532, 3);
    }

    /**
     * Test of dequeue method, of class PriorityQueue.
     */
    @Test(expected = EmptyQueue.class)
    public void testDequeue() throws EmptyQueue {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.enqueue(10, 2);
        queue.enqueue(15, 2);
        queue.enqueue(20, 2);
        queue.enqueue(5, 4);
        queue.enqueue(345, 1);
        queue.enqueue(532, 3);
        assertTrue(345 == queue.dequeue());
        assertTrue(10 == queue.dequeue());
        assertTrue(15 == queue.dequeue());
        assertTrue(20 == queue.dequeue());
        assertTrue(532 == queue.dequeue());
        assertTrue(5 == queue.dequeue());
        queue.dequeue();
    }
}
