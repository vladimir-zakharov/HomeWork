package calculate;

/**
 * use to create stack
 *
 * @author vladimir-zakharov;
 */
public interface StackInterface {

    /**
     * push value to the head of the stack
     *
     * @param value value, which you want to push
     */
    void push(float value);

    /**
     * pop an element from the stack
     */
    void pop() throws EmptyStack;

    /**
     * use to return value of the top element
     *
     * @return value of the top element
     */
    float top();

    /**
     * checks for elements
     *
     * @return true, if stack is empty; else false
     */
    boolean isEmpty();
}
