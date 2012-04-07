package list;

/**
 * use to create a List
 *
 * @author vladimir-zakharov
 */
public class List<ElementType> {

    /**
     * elements of List
     */
    public class ListElement<ElementType> {

        /**
         * constructor for ListElement
         *
         * @param value string, which you init element
         * @param next link to next element
         * @param previous link to previous element
         */
        private ListElement(ElementType value, ListElement<ElementType> next, ListElement<ElementType> previous) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
        private ElementType value;
        private ListElement<ElementType> next;
        private ListElement<ElementType> previous;
    }

    /**
     * checks existence of the element in the list
     *
     * @param value value, which you check for existence
     * @return true if exists; false if not exists
     */
    public boolean Exist(ElementType value) {
        ListElement<ElementType> temp = head;
        boolean successfullSearch = false;

        while (temp != null) {
            if (temp.value.equals(value)) {
                successfullSearch = true;
                break;
            }
            temp = temp.next;
        }

        return successfullSearch;
    }

    /**
     * @return number of elements
     */
    public int amountElements() {
        return count;
    }
    /**
     * head of list
     */
    private ListElement<ElementType> head;
    /**
     * tail of list
     */
    private ListElement<ElementType> tail;
    /**
     * number of elements
     */
    private int count;

    public IListIterator<ElementType> listIterator() {
        return new ListIterator();
    }

    public class ListIterator implements IListIterator<ElementType> {

        public ListIterator() {
            this.position = head;
        }

        @Override
        public ElementType next() throws NoElementsException {
            if (!hasNext()) {
                throw new NoElementsException();
            }

            ListElement<ElementType> temp = position;
            position = position.next;
            return temp.value;
        }

        @Override
        public ElementType previous() throws NoElementsException {
            if (!hasPrevious()) {
                throw new NoElementsException();
            }

            ListElement<ElementType> temp = position;
            position = position.previous;
            return temp.value;
        }

        @Override
        public boolean hasNext() {
            return position.next != null;
        }

        @Override
        public boolean hasPrevious() {
            return position.previous != null;
        }

        @Override
        public void deleteElement() {
            if (count == 1) {
                head = null;
                tail = null;
            } else if (position == head) {
                position.next.previous = null;
                head = position.next;
            } else if (position == tail) {
                position.previous.next = null;
                tail = position.previous;
            } else {
                position.previous.next = position.next;
                position.next.previous = position.previous;
            }
            count--;
        }

        /**
         * insert element into list behind current position
         *
         * @param value value, which you want to add
         */
        @Override
        public void insert(ElementType value) {
            if (count == 0) {
                addFirstElement(value);
            } else if (position == tail) {
                addToEnd(value);
            } else {
                ListElement<ElementType> newElement = new ListElement<ElementType>(value, position.next, position);
                position.next.previous = newElement;
                position.next = newElement;
                count++;
            }
        }

        /**
         * add element to tail of the list
         *
         * @param value value, which you want to add
         */
        public void addToEnd(ElementType value) {
            if (count == 0) {
                addFirstElement(value);
            } else {
                ListElement<ElementType> newElement = new ListElement<ElementType>(value, null, tail);
                tail.next = newElement;
                tail = newElement;
                count++;
            }
        }

        /**
         * add first element of List
         */
        private void addFirstElement(ElementType value) {
            ListElement<ElementType> newElement = new ListElement<ElementType>(value, null, null);
            head = newElement;
            tail = newElement;
            position = newElement;
            count = 1;
        }
                
        /**
         * add element to head of the list
         *
         * @param value value, which you want to add
         */
        @Override
        public void addToHead(ElementType value) {
            if (count == 0) {
                addFirstElement(value);
            } else {
                ListElement<ElementType> newElement = new ListElement<ElementType>(value, head, null);
                head.previous = newElement;
                head = newElement;
                count++;
            }
        }
        
        private ListElement<ElementType> position;
    }
}