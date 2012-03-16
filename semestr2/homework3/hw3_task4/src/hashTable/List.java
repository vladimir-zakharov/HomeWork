package hashTable;

/**
 * use to create a List
 *
 * @author vladimir-zakharov
 */
public class List {

    /**
     * elements of List
     */
    public class ListElement {

        /**
         * constructor for ListElement
         *
         * @param value string, which you init element
         * @param next link to next element
         * @param prev link to previous element
         */
        public ListElement(String value, ListElement next, ListElement prev) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
        private String value;
        private ListElement next;
        private ListElement prev;
    }

    /**
     * add element to head of the list
     *
     * @param value string, which you want to add
     */
    public void addToHead(String value) {
        if (count == 0) {
            addFirstElement(value);
        } else {
            ListElement newElement = new ListElement(value, head, null);
            head.prev = newElement;
            head = newElement;
            count++;
        }
    }

    /**
     * add element to tail of the list
     *
     * @param value string, which you want to add
     */
    public void addToEnd(String value) {
        if (count == 0) {
            addFirstElement(value);
        } else {
            ListElement newElement = new ListElement(value, null, tail);
            tail.next = newElement;
            tail = newElement;
            count++;
        }
    }

    /**
     * insert element into list behind current position
     *
     * @param position current position
     * @param value string, which you want to add
     */
    public void insert(ListElement position, String value) {
        if (count == 0) {
            addFirstElement(value);
        } else if (position == head) {
            addToHead(value);
        } else if (position == tail) {
            addToEnd(value);
        } else {
            ListElement newElement = new ListElement(value, position.next, position);
            position.next.prev = newElement;
            position.next = newElement;
            count++;
        }
    }

    /**
     * @param position current position
     * @return value of current position
     */
    public String positionValue(ListElement position) {
        return position.value;
    }

    /**
     * @return value of head
     */
    public String headValue() {
        return head.value;
    }

    /**
     * @return value of tail
     */
    public String tailValue() {
        return tail.value;
    }

    /**
     * delete element of current position
     *
     * @param position current position
     */
    public void deleteElement(ListElement position) {
        if (count == 1) {
            head = null;
            tail = null;
        } else if (position == head) {
            position.next.prev = null;
            head = position.next;
        } else if (position == tail) {
            position.prev.next = null;
            tail = position.prev;
        } else {
            position.prev.next = position.next;
            position.next.prev = position.prev;
        }
        count--;
    }

    /**
     * checks existence of the element in the list
     *
     * @param string string, which you check for existence
     * @return true if exists; false if not exists
     */
    public boolean isExist(String string) {
        ListElement temp = head;
        boolean successfullSearch = false;

        while (temp != null) {
            if (temp.value.equals(string)) {
                successfullSearch = true;
                break;
            }
            temp = temp.next;
        }

        return successfullSearch;
    }

    /**
     * search string in the list
     * 
     * @param string string, which you want to find
     * @return position of string, if it exists in the list; else null
     */
    public ListElement searchPosition(String string) {
        ListElement temp = head;

        while (temp != null) {
            if (temp.value.equals(string)) {
                return temp;
            }
        }

        return null;
    }

    /**
     * @return number of elements
     */
    public int amountElements() {
        return count;
    }

    /**
     * @return head position
     */
    public ListElement firstPosition() {
        return head;
    }

    /**
     * @return tail position
     */
    public ListElement endPosition() {
        return tail;
    }

    /**
     * @param position current position
     * @return next position
     */
    public ListElement nextPosition(ListElement position) {
        return position.next;
    }

    /**
     * @param position current position
     * @return previous position
     */
    public ListElement prevPosition(ListElement position) {
        return position.prev;
    }

    /**
     * print List
     */
    public void printList() {
        ListElement temp = head;
        System.out.println("Данный список:");

        while (temp != null) {
            System.out.print(temp.value);
            System.out.print(' ');
            temp = temp.next;
        }

        System.out.println();
    }

    /**
     * add first element of List
     */
    private void addFirstElement(String value) {
        ListElement newElement = new ListElement(value, null, null);
        head = newElement;
        tail = newElement;
        count = 1;
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
    private int count;
}
