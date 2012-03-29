package calculate;

/**
 * use to calculate two values
 *
 * @author vladimir-zakharov
 */
public class Calculator {

    /**
     * constructor for calculator
     *
     * @param stack
     */
    public Calculator(StackInterface stack) {
        this.stack = stack;
    }

    /**
     * adds two values
     *
     * @param first first value
     * @param second second value
     * @return first + second
     */
    public float addition(float first, float second) throws EmptyStack {
        init(first, second);
        float x = stack.top();
        popElement();
        float y = stack.top();
        popElement();
        stack.push(x + y);
        return stack.top();
    }

    /**
     * multiplate two values
     *
     * @param first first value
     * @param second second value
     * @return first * second
     */
    public float multiplication(float first, float second) throws EmptyStack {
        init(first, second);
        float x = stack.top();
        popElement();
        float y = stack.top();
        popElement();
        stack.push(x * y);
        return stack.top();
    }

    /**
     * divides two values
     *
     * @param first first value
     * @param second second value
     * @return first / second
     */
    public float division(float first, float second) throws DivNull, EmptyStack {
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
     * deducts two values
     *
     * @param first first value
     * @param second second value
     * @return first - second
     */
    public float deduction(float first, float second) throws EmptyStack {
        init(first, second);
        float x = stack.top();
        popElement();
        float y = stack.top();
        popElement();
        stack.push(y - x);
        return stack.top();
    }

    /**
     * put two values, which you want calculate to the stack
     *
     * @param first first value
     * @param second second value
     */
    private void init(float first, float second) {
        stack.push(first);
        stack.push(second);
    }

    /**
     * pop an element from the stack and catch exception
     */
    private void popElement() throws EmptyStack {
        try {
            stack.pop();
        } catch (EmptyStack emptyStack) {
            throw emptyStack;
        }
    }
    /**
     * the stack of the calculator
     */
    private StackInterface stack;
}
