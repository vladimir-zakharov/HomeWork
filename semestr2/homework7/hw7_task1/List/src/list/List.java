package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * use to create a List
 *
 * @author vladimir-zakharov
 */
public class List<ElementType> implements Iterable<ElementType> {

    /**
     * insert element into list behind index position
     *
     * @param index
     * @param value value, which you want to add
     * @throws ListIndexOutOfBoundsException
     */
    public void insert(int index, ElementType value) {
        if (index > size - 1) {
            throw new ListIndexOutOfBoundsException();
        }

        if (size == 0) {
            addFirstElement(value);
        } else if (index == size - 1) {
            addToEnd(value);
        } else {
            ListElement temp = head;

            for (int i = 0; i < index; ++i) {
                temp = temp.next;
            }
            ListElement newElement = new ListElement(value, temp.next, temp);
            temp.next.previous = newElement;
            temp.next = newElement;
            size++;
        }
    }

    /**
     * add element to tail of the list
     *
     * @param value value, which you want to add
     */
    public void addToEnd(ElementType value) {
        if (size == 0) {
            addFirstElement(value);
        } else {
            ListElement newElement = new ListElement(value, null, tail);
            tail.next = newElement;
            tail = newElement;
            size++;
        }
    }

    /**
     * add element to head of the list
     *
     * @param value value, which you want to add
     */
    public void addToHead(ElementType value) {
        if (size == 0) {
            addFirstElement(value);
        } else {
            ListElement newElement = new ListElement(value, head, null);
            head.previous = newElement;
            head = newElement;
            size++;
        }
    }

    /**
     * add first element of List
     */
    private void addFirstElement(ElementType value) {
        ListElement newElement = new ListElement(value, null, null);
        head = newElement;
        tail = newElement;
        size = 1;
    }

    /**
     * checks existence of the element in the list
     *
     * @param value value, which you check for existence
     * @return true if exists; false if not exists
     */
    public boolean exist(ElementType value) {
        ListElement temp = head;

        while (temp != null) {
            if (temp.value.equals(value)) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    /**
     * @return number of elements
     */
    public int amountElements() {
        return size;
    }

    /**
     * elements of List
     */
    private class ListElement {

        /**
         * constructor for ListElement
         *
         * @param value value, which you init element
         * @param next link to next element
         * @param previous link to previous element
         */
        private ListElement(ElementType value, ListElement next, ListElement previous) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
        private ElementType value;
        private ListElement next;
        private ListElement previous;
    }
    /**
     * head of list
     */
    private ListElement head;
    /**
     * tail of list
     */
    private ListElement tail;
    /**
     * number of elements
     */
    private int size;

    @Override
    public ListIterator<ElementType> iterator() {
        return new ListIter();
    }

    /**
     * Iterator of the list
     */
    public class ListIter implements ListIterator<ElementType> {

        /**
         * constructor for ListIter
         */
        public ListIter() {
            this.position = head;
            this.index = 1;
        }

        /**
         * 
         * @return 
         */
        @Override
        public ElementType next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            if (index < 1) {
                position = head;
                index++;
                return null;
            } else {
                ListElement temp = position;
                position = position.next;
                index++;
                return temp.value;
            }
        }

        /**
         * 
         * @return 
         */
        @Override
        public ElementType previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }

            if (index > size) {
                position = tail;
                index--;
                return null;
            } else {
                ListElement temp = position;
                position = position.previous;
                index--;
                return temp.value;
            }
        }

        /**
         * 
         * @return 
         */
        @Override
        public boolean hasNext() {
            return index < size + 1;
        }

        /**
         * 
         * @return 
         */
        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        /**
         * 
         */
        @Override
        public void remove() {
            if (position == null) {
                throw new IllegalStateException();
            }

            if (size == 1) {
                head = null;
                tail = null;
                position = null;
                index = 0;
            } else if (position == head) {
                position.next.previous = null;
                head = position.next;
                position = position.next;
            } else if (position == tail) {
                position.previous.next = null;
                tail = position.previous;
                position = position.previous;
                index--;
            } else {
                position.previous.next = position.next;
                position.next.previous = position.previous;
                position = position.next;
            }
            size--;
        }
        /**
         * 
         */
        private ListElement position;
        /**
         * 
         */
        private int index;
    }

    public static void main(String[] argv) {
        List<Integer> list = new List<Integer>();
        list.addToHead(15);
        list.insert(0, 5);
        list.insert(0, 10);
        list.insert(1, 20);
        ListIterator<Integer> iterator = list.iterator();

        for (Integer i : list) {
            System.out.println(i);
        }
    }
}