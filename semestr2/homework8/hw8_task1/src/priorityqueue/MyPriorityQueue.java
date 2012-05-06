/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue;

/**
 * This is an example of priority queue class. High priority items have low
 * 'prio' value, i.e. ("str1", 0) > ("str2", 1)
 *
 * @author Author
 */
public class MyPriorityQueue<T> {

    private class QueueElement {

        /**
         * constructor QueueElement
         */
        public QueueElement() {
        }

        /**
         * yet another constructor
         *
         * @param v value, which you init element
         * @param p priority of the element
         */
        public QueueElement(T v, int p) {
            next = null;
            value = v;
            prio = p;
        }

        /**
         * returns next element
         *
         * @return next element
         */
        public QueueElement getNext() {
            return next;
        }

        /**
         * adds next element
         *
         * @param nxt element, which you want to add
         */
        public void setNext(QueueElement nxt) {
            next = nxt;
        }

        /**
         * returns value of the element
         *
         * @return value of the element
         */
        public T getValue() {
            return value;
        }

        /**
         * returns priority of the element
         *
         * @return priority of the element
         */
        public int getPrio() {
            return prio;
        }
        private T value;           // stored value
        private QueueElement next;  // next item
        private int prio;          // item priority
    }

    /**
     * constructor for MyPriorityQueue
     */
    public MyPriorityQueue() {
        head = new QueueElement();  // create sentinel
    }

    /**
     * adds item to queue
     *
     * @param val value of the item, which you want to add
     * @param prio priority of the item, which you want to add
     */
    public void enqueue(T val, int prio) {
        QueueElement l = head;
        while (l.getNext() != null && l.getNext().getPrio() <= prio) {
            l = l.getNext();
        }
        QueueElement tmp = new QueueElement(val, prio);
        tmp.setNext(l.getNext());
        l.setNext(tmp);
    }

    /**
     * get item from queue with highest priority
     *
     * @return item's value
     * @throws Exception will be thrown if queue is empty
     */
    public T dequeue() throws Exception {
        if (head.getNext() == null) {
            throw new EmptyQueueException("Queue is empty!!!");
        }
        QueueElement tmp = head.getNext();
        head.setNext(tmp.getNext());
        return tmp.getValue();
    }
    
    private QueueElement head; // sentinel
}