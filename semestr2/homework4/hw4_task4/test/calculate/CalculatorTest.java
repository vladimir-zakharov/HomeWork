package calculate;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author vladimir-zakharov
 */
public class CalculatorTest {

    /**
     * Test of addition method, of class Calculator.
     */
    @Test
    public void testAddition() {
        Calculator calc = new Calculator(new LinkedStack());
        float addition = calc.addition((float) 1.2, (float) 1.3);
        assertEquals(addition, (float) 2.5, 0.0);
    }

    /**
     * Test of multiplication method, of class Calculator.
     */
    @Test
    public void testMultiplication() {
        Calculator calc = new Calculator(new LinkedStack());
        float multiplication = calc.multiplication((float) 1.2, (float) 1.2);
        assertEquals(multiplication, (float) 1.44, 0.0);
    }

    /**
     * Test of division method, of class Calculator.
     */
    @Test
    public void testDivision() throws DivNull {
        Calculator calc = new Calculator(new LinkedStack());
        float division = (float) 0.0;
        try {
            division = calc.division((float) 2.6, (float) 2.0);
        } catch (DivNull divNull) {
            System.out.println("division by zero");
        }
        assertEquals(division, (float) 1.3, 0.0);
        try {
            division = calc.division((float) 2.6, (float) 0.0);
        } catch (DivNull divNull) {
            System.out.println("division by zero");
        }
    }

    /**
     * Test of deduction method, of class Calculator.
     */
    @Test
    public void testDeduction() {
        Calculator calc = new Calculator(new LinkedStack());
        float deduction = calc.deduction((float) 1.5, (float) 1.3);
        assertEquals(deduction, (float) 0.2, 0.0001);
    }
}
