package calculate;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * @author vladimir-zakharov
 */
public class CalculatorTest {

    /**
     * Test of addition method, of class Calculator.
     */
    @Test
    public void testAddition() throws EmptyStack {
        Calculator calc = new Calculator(new LinkedStack());
        float addition = calc.addition((float) 1.2, (float) 1.3);
        assertEquals(addition, (float) 2.5, 0.0);
    }

    /**
     * Test of multiplication method, of class Calculator.
     */
    @Test
    public void testMultiplication() throws EmptyStack {
        Calculator calc = new Calculator(new LinkedStack());
        float multiplication = calc.multiplication((float) 1.2, (float) 1.2);
        assertEquals(multiplication, (float) 1.44, 0.0);
    }

    /**
     * Test of division method, of class Calculator.
     */
    @Test(expected= DivNull.class)
    public void testDivision() throws EmptyStack, DivNull {
        Calculator calc = new Calculator(new LinkedStack());
        float division = (float) 0.0;
        division = calc.division((float) 2.6, (float) 2.0);
        assertEquals(division, (float) 1.3, 0.0);
        calc.division((float) 2.6, (float) 0.0);
    }

    /**
     * Test of deduction method, of class Calculator.
     */
    @Test
    public void testDeduction() throws EmptyStack {
        Calculator calc = new Calculator(new LinkedStack());
        float deduction = calc.deduction((float) 1.5, (float) 1.3);
        assertEquals(deduction, (float) 0.2, 0.0001);
    }
}
