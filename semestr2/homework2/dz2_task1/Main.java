/*
 * Tests:
 * 1)
 * input:
 * 1  2  3  4  5
 * 6  7  8  9  10
 * 11 12 13 14 15
 * 16 17 18 19 20
 * 21 22 23 24 25
 * 
 * otput:Данный массив, распечатанный по спирали, начиная из центра:
 * 13 12 17 18 19 14 9 8 7 6 11 16 21 22 23 24 25 20 15 10 5 4 3 2 1 
 */
package spiral;

import javax.swing.JOptionPane;

public class Main {

    final static int size = 5;

    public static void in(int[][] mass) {
        JOptionPane.showMessageDialog(null, "Введите эелементы массива "
                + size + " x " + size);
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                String input = JOptionPane.showInputDialog("Введите число");
                mass[i][j] = Integer.parseInt(input);
            }
        }
    }

    public static void main(String[] argv) {
        int[][] mass = new int[size][size];
        in(mass);
        PrintMass printStandart = new PrintStandart();
        printStandart.printMass(mass);
        PrintMass printSpiral = new PrintSpiral();
        printSpiral.printMass(mass);
    }
}
