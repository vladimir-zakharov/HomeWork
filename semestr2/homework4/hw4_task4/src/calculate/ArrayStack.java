package calculate;

/**
 *
 * @author vladimir-zakharov
 */
public class ArrayStack implements InterfaceStack {

    /**
     *
     */
    public ArrayStack() {
        this.elements = new float[0];
    }

    /**
     *
     * @param value
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
     *
     */
    @Override
    public void pop() {
        if (!isEmpty()) {
            elements[--size] = 0;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public float top() {
        return elements[size - 1];
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    private boolean isFull() {
        if (elements.length == size) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param capacity
     */
    private void stretch(int capacity) {
        float[] newSize = new float[capacity * 2];
        System.arraycopy(elements, 0, newSize, 0, size);
        elements = newSize;
    }
    
    /**
     *
     */
    private int size;
    
    /**
     *
     */
    private float elements[];
}
