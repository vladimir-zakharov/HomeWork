package calculate;

/**
 *
 * @author vladimir-zakharov
 */
public class Calculator {

    /**
     * constructor for calculator
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
        popElement();
        float y = stack.top();
        popElement();
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
        popElement();
        float y = stack.top();
        popElement();
        stack.push(x * y);
        return stack.top();
    }

    /**
     * 
     * @param first
     * @param second
     * @return 
     */
    public float division(float first, float second) throws DivNull {
        init(first, second);
        float x = stack.top();
        popElement();
        float y = stack.top();
        popElement();
        
        if (x == 0.0) {
            throw new DivNull();
        }
        
        stack.push(y / x);
        return stack.top();
    }

    /**
     * 
     * @param first
     * @param second
     * @return 
     */
    public float deduction(float first, float second) {
        init(first, second);
        float x = stack.top();
        popElement();
        float y = stack.top();
        popElement();
        stack.push(y - x);
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
    
    private void popElement() {
        try {
        stack.pop();
        } catch(EmptyStack empty) {
            System.out.println("Stack is empty");
        }
    }
    
    /**
     * 
     */
    private InterfaceStack stack;
}
