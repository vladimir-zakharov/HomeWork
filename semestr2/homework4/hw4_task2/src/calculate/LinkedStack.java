package calculate;

/**
 * use to create a linked stack
 *
 * @author vladimir-zakharov
 */
public class LinkedStack implements StackInterface {

    /**
     * push value to the head of the stack
     *
     * @param value value, which you want to push
     */
    @Override
    public void push(float value) {
        StackElement newElement = new StackElement();
        newElement.value = value;
        newElement.next = head;
        head = newElement;
    }

    /**
     * pop an element from the stack
     */
    @Override
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
    @Override
    public float top() {
        return head.value;
    }

    /**
     * checks for elements
     * 
     * @return true, if stack is empty; else false
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * an element of the stack
     */
    private class StackElement {

        private float value;
        private StackElement next;
    }
    /**
     * the top element of the stack
     */
    private StackElement head;
}
