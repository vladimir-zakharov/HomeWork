package queue;

/**
 * use to create a priority queue
 *
 * @author vladimir-zakharov
 */
public class PriorityQueue<Type> {

    /**
     * add element to queue
     *
     * @param value value, which you want to add
     * @param priority priority of the element
     */
    public void enqueue(Type value, int priority) {
        if (tail == null) {
            firstElement(value, priority);
        } else {
            if (tail.priority > priority) {
                QueueElement newElement = new QueueElement(value, priority, tail);
                tail = newElement;
            } else {
                QueueElement temp = tail;

                while (temp.prev != null) {
                    if (temp.prev.priority > priority) {
                        break;
                    }
                    temp = temp.prev;
                }

                QueueElement newElement = new QueueElement(value, priority, temp.prev);
                temp.prev = newElement;
            }
        }
    }

    /**
     * delete top prority element from queue
     *
     * @return value of top priority elment
     */
    public Type dequeue() throws EmptyQueue {

        if (tail == null) {
            throw new EmptyQueue();
        }

        Type value = tail.value;
        tail = tail.prev;
        return value;
    }

    /**
     * an element of the queue
     */
    public class QueueElement {

        public QueueElement(Type value, int priority, QueueElement prev) {
            this.value = value;
            this.prev = prev;
            this.priority = priority;
        }
        private Type value;
        private QueueElement prev;
        private int priority;
    }

    /**
     * add first element to the queue
     *
     * @param value value, which you want to add
     * @param priority priority of the element
     */
    private void firstElement(Type value, int priority) {
        QueueElement newElement = new QueueElement(value, priority, null);
        tail = newElement;
    }
    /**
     * tail of the queue
     */
    private QueueElement tail;
}
