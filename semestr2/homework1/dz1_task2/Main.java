/*
 * Test:
 * 1)
 * input: 1
 * output:Число Фибоначчи = 1
 * 2)
 * input: 7
 * output:Число Фибоначчи = 13
 * 3)
 * input: 11
 * output:Число Фибоначчи = 89
 */
package fibonacci;

import javax.swing.JOptionPane;

public class Main {

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int in() {
        String input = JOptionPane.showInputDialog("Введите номер числа Фибоначчи");
        return Integer.parseInt(input);
    }

    public static void main(String[] argv) {
        int n = in();
        System.out.print("Число Фибоначчи равно = ");
        System.out.println(fibonacci(n));
    }
}