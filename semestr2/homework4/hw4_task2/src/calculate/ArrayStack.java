package calculate;

/**
 * use to create an array stack
 * 
 * @author vladimir-zakharov
 */
public class ArrayStack implements StackInterface {

    /**
     * constructor for array stack
     */
    public ArrayStack() {
        this.elements = new float[0];
    }

    /**
     * push value to the head of the stack
     *
     * @param value value, which you want to push
     */
    @Override
    public void push(float value) {
        if (isFull()) {
            stretch(size + 1);
        }
        elements[size] = value;
        size++;
    }

    /**
     * pop an element from the stack
     */
    @Override
    public void pop() throws EmptyStack {
        if (isEmpty()) {
            throw new EmptyStack();
        }
        elements[--size] = 0;
    }

    /**
     * use to return value of the top element
     *
     * @return value of the top element
     */
    @Override
    public float top() {
        return elements[size - 1];
    }

    /**
     * checks for elements
     *
     * @return true, if stack is empty; else false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * checks for full
     *
     * @return true if stack is full; else false
     */
    private boolean isFull() {
        return elements.length == size;
    }

    /**
     * increases size of the stack
     * 
     * @param capacity how many elements can set into the stack
     */
    private void stretch(int capacity) {
        float[] newSize = new float[capacity * 2];
        System.arraycopy(elements, 0, newSize, 0, size);
        elements = newSize;
    }
    /**
     * size of the stack
     */
    private int size;
    /**
     * elements of the stack
     */
    private float elements[];
}
