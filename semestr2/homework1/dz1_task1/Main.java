/*
 * Test:
 * 1)
 * input: 3 
 * otput: Факториал равен = 6
 * 2)
 * input: 5 
 * otput: Факториал равен = 120
 * 3)
 * input: 8
 * output: Факториал равен = 40320
 */
package factorial;

import javax.swing.JOptionPane;

public class Main {

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int in() {
        String input = JOptionPane.showInputDialog("Введите число");
        return Integer.parseInt(input);
    }

    public static void main(String[] argv) {
        int n = in();
        System.out.print("Факториал равен = ");
        System.out.println(factorial(n));
    }
}
