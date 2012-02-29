package StackClass;

/**
 * Используется для создания стека
 */
public class Stack {

    /**
     * кладет элемент на вершину стека
     */
    public void push(int value) {
        StackElement newElement = new StackElement();
        newElement.value = value;
        newElement.next = head;
        head = newElement;
    }

    /**
     * снимает элемент с вершины стека
     */
    public int pop() {
        int value = head.value;
        head = head.next;
        return value;
    }

    /**
     * возвращает значение вершины стека
     */
    public int headValue() {
        return head.value;
    }

    private class StackElement {

        private int value;
        private StackElement next;
    }
    private StackElement head;
}
