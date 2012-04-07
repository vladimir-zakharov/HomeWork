package stack;

/**
 * use to create a linked stack
 *
 * @author vladimir-zakharov
 */
public class Stack<ElementType> {

    /**
     * push value to the head of the stack
     *
     * @param value value, which you want to push
     */
    public void push(ElementType value) {
        StackElement<ElementType> newElement = new StackElement<ElementType>();
        newElement.value = value;
        newElement.next = head;
        head = newElement;
    }

    /**
     * pop an element from the stack
     */
    public void pop() throws EmptyStack {
        if (isEmpty()) {
            throw new EmptyStack();
        }
        head = head.next;
    }

    /**
     * use to return value of the top element
     *
     * @return value of the top element
     */
    public ElementType top() {
        return head.value;
    }

    /**
     * checks for elements
     * 
     * @return true, if stack is empty; else false
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * an element of the stack
     */
    private class StackElement<ElementType> {

        private ElementType value;
        private StackElement<ElementType> next;
    }
    /**
     * the top element of the stack
     */
    private StackElement<ElementType> head;
}