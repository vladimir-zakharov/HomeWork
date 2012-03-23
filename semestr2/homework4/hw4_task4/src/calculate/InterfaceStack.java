package calculate;

/**
 * use to create stack
 *
 * @author vladimir-zakharov;
 */
public interface InterfaceStack {

    /**
     * push element to head of the stack
     *
     * @param value
     */
    void push(float value);

    /**
     *
     */
    void pop() throws EmptyStack;

    /**
     *
     * @return
     */
    float top();

    /**
     *
     * @return true, if stack is empty; else false
     */
    boolean isEmpty();
}
