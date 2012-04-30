package calculator;

import java.awt.Dimension;

/**
 *
 * @author vladimir-zakharov
 */
public class Frame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.showForm();
        calc.setMinimumSize(new Dimension(420, 250));
        calc.setSize(420, 300);
    }
}
