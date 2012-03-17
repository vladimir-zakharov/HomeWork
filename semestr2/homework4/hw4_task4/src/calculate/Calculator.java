package calculate;

/**
 *
 * @author vladimir-zakharov
 */
public class Calculator {

    /**
     * 
     * @param stack 
     */
    public Calculator(InterfaceStack stack) {
        this.stack = stack;
    }

    /**
     * 
     * @param first
     * @param second
     * @return 
     */
    public float addition(float first, float second) {
        init(first, second);
        float x = stack.top();
        stack.pop();
        float y = stack.top();
        stack.pop();
        stack.push(x + y);
        return stack.top();
    }

    /**
     * 
     * @param first
     * @param second
     * @return 
     */
    public float multiplication(float first, float second) {
        init(first, second);
        float x = stack.top();
        stack.pop();
        float y = stack.top();
        stack.pop();
        stack.push(x * y);
        return stack.top();
    }

    /**
     * 
     * @param first
     * @param second
     * @return 
     */
    private float divison(float first, float second) {
        init(first, second);
        float x = stack.top();
        stack.pop();
        float y = stack.top();
        stack.pop();
        stack.push(x / y);
        return stack.top();
    }

    /**
     * 
     * @param first
     * @param second
     * @return 
     */
    private float deduction(float first, float second) {
        init(first, second);
        float x = stack.top();
        stack.pop();
        float y = stack.top();
        stack.pop();
        stack.push(x - y);
        return stack.top();
    }

    /**
     * 
     * @param first
     * @param second 
     */
    private void init(float first, float second) {
        stack.push(first);
        stack.push(second);
    }
    
    /**
     * 
     */
    private InterfaceStack stack;
}
