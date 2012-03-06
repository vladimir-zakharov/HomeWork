package hashTable;

/**
 * Используется для создания списка
 */
public class List {

    public class ListElement {

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
     * добавляет элемент в начало списка
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
     * добавляет элемент в конец списка
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
     * вставляет элемент в список
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
     * возвращает значение данного элемента списка
     */
    public String PositionValue(ListElement position) {
        return position.value;
    }

    /**
     * возвращает значение первого элемента списка
     */
    public String HeadValue() {
        return head.value;
    }

    /**
     * возвращает значение последнего элемента списка
     */
    public String TailValue() {
        return tail.value;
    }

    /**
     * удаляет данный элемент
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
     * возвращает количество элементов в списке
     */
    public int amountElements() {
        return count;
    }

    /**
     * возвращает позицию первого элемента списка
     */
    public ListElement firstPosition() {
        return head;
    }

    /**
     * возвращает позицию последнего элемента списка
     */
    public ListElement endPosition() {
        return tail;
    }

    /**
     * возвращает следующую за данной позицию
     */
    public ListElement nextPosition(ListElement position) {
        return position.next;
    }

    /**
     * возвращает предыдущую позицию
     */
    public ListElement prevPosition(ListElement position) {
        return position.prev;
    }

    /**
     * распечатывает список
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
     * добавляет первый элемент списка
     */
    private void addFirstElement(String value) {
        ListElement newElement = new ListElement(value, null, null);
        head = newElement;
        tail = newElement;
        count = 1;
    }
    private ListElement head;
    private ListElement tail;
    private int count;
}
