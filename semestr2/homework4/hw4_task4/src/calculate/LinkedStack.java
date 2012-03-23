package calculate;

/**
 * use to create a linked stack
 *
 * @author vladimir-zakharov
 */
public class LinkedStack implements InterfaceStack {

    /**
     *
     * @param value
     */
    @Override
    public void push(float value) {
        StackElement newElement = new StackElement();
        newElement.value = value;
        newElement.next = head;
        head = newElement;
    }

    /**
     *
     */
    @Override
    public void pop() throws EmptyStack {
        if (isEmpty()) {
            throw new EmptyStack();
        }
        head = head.next;
    }

    /**
     *
     * @return
     */
    @Override
    public float top() {
        return head.value;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     */
    private class StackElement {

        private float value;
        private StackElement next;
    }
    /**
     *
     */
    private StackElement head;
}
