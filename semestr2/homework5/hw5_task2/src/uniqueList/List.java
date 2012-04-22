/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uniqueList;

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
     * @param index position's number
     * @param value value, which you want to add
     * @throws ListIndexOutOfBoundsException
     */
    public void insert(int index, ElementType value) throws ExistException {
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
     * add element to the tail of the list
     *
     * @param value value, which you want to add
     */
    public void addToEnd(ElementType value) throws ExistException {
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
     * add element to the head of the list
     *
     * @param value value, which you want to add
     */
    public void addToHead(ElementType value) throws ExistException {
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
     * deletes an element from the list
     *
     * @param value value, which you want to delete
     * @throws NotFoundElementException This Exception will be trown if an
     * element not found in the list
     */
    public void deleteElement(ElementType value) throws NotFoundElementException {
        if (!exist(value)) {
            throw new NotFoundElementException();
        }

        if (head.value.equals(value)) {
            head = head.next;
        } else {
            ListElement temp = head.next;

            while (temp != null) {
                if (temp.value.equals(value)) {
                    break;
                }
                temp = temp.next;
            }

            temp.previous.next = temp.previous.next.next;
        }
    }

    /**
     * @return number of elements
     */
    public int amountElements() {
        return size;
    }

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
         * Returns the current element value and advances the cursor to next
         * position.
         *
         * @return the current element value
         * @throws NoSuchElementException if the iteration has no next element
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
         * Returns the current element value and advances the cursor to previous
         * position.
         *
         * @return the current element value
         * @throws NoSuchElementException if the iteration has no previous
         * element
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
         * @return true if the list iterator has next element; else false
         */
        @Override
        public boolean hasNext() {
            return index < size + 1;
        }

        /**
         * @return true if the list iterator has previous element; else false
         */
        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        /**
         * delete current element
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
         * current cursor position
         */
        private ListElement position;
        /**
         * current index position
         */
        private int index;
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
}