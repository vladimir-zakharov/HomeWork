package list;

/**
 * use to create a List
 *
 * @author vladimir-zakharov
 */
public class List<ElementType> {
    
        /**
         * insert element into list behind index position
         *
         * @param index
         * @param value value, which you want to add
         * @throws ListIndexOutOfBoundsException 
         */
        public void insert(int index, ElementType value) throws ListIndexOutOfBoundsException {
            if (index > size - 1) {
                throw new ListIndexOutOfBoundsException();
            }
            
            if (size == 0) {
                addFirstElement(value);
            } else if (index == size - 1) {
                addToEnd(value);
            } else {
                ListElement<ElementType> temp = head;
                
                for (int i = 0; i < index; ++i) {
                    temp = temp.next;
                }
                ListElement<ElementType> newElement = new ListElement<ElementType>(value, temp.next, temp);
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
                ListElement<ElementType> newElement = new ListElement<ElementType>(value, null, tail);
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
                ListElement<ElementType> newElement = new ListElement<ElementType>(value, head, null);
                head.previous = newElement;
                head = newElement;
                size++;
            }
        }

        /**
         * add first element of List
         */
        private void addFirstElement(ElementType value) {
            ListElement<ElementType> newElement = new ListElement<ElementType>(value, null, null);
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
        return size;
    }

    /**
     * elements of List
     */
    private class ListElement<ElementType> {

        /**
         * constructor for ListElement
         *
         * @param value value, which you init element
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
    private int size;

    public IListIterator<ElementType> listIterator() {
        return new ListIterator();
    }

    public class ListIterator implements IListIterator<ElementType> {

        public ListIterator() {
            this.position = head;
        }

        @Override
        public void next() throws NoElementsException {
            if (!hasNext()) {
                throw new NoElementsException();
            }

            position = position.next;
        }

        @Override
        public void previous() throws NoElementsException {
            if (!hasPrevious()) {
                throw new NoElementsException();
            }

            position = position.previous;
        }
        
        @Override
        public ElementType currentItem() {
            return position.value;
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
        public void deleteElement() throws NoElementsException {
            if (position == null) {
               throw new NoElementsException();
            }
            
            if (size == 1) {
                head = null;
                tail = null;
                position = null;
            } else if (position == head) {
                position.next.previous = null;
                head = position.next;
                position = position.next;
            } else if (position == tail) {
                position.previous.next = null;
                tail = position.previous;
                position = position.previous;
            } else {
                position.previous.next = position.next;
                position.next.previous = position.previous;
                position = position.next;
            }
            size--;
        }

        private ListElement<ElementType> position;
    }
}