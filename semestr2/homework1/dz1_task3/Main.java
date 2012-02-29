/*
 * Test:
 * 1)
 * input: 8 3 6 1 9
 * output: 
 * Отсортированный массив:
 * 1 3 6 8 9
 */
package Bubblesort;

import javax.swing.JOptionPane;

public class Main {

    public static void bubbleSort(int[] mass) {
        for (int i = 0; i < mass.length - 1; ++i) {
            for (int j = 0; j < mass.length - i - 1; ++j) {
                if (mass[j] > mass[j + 1]) {
                    int temp = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = temp;
                }
            }
        }
    }

    public static void in(int[] mass) {
        JOptionPane.showMessageDialog(null, "Введите " + mass.length + " чисел");
        for (int i = 0; i < mass.length; ++i) {
            String input = JOptionPane.showInputDialog("Введите число");
            mass[i] = Integer.parseInt(input);
        }
    }

    public static void main(String[] argv) {
        int[] mass = new int[5];
        in(mass);
        bubbleSort(mass);
        System.out.println("Отсортированный массив:");

        for (int i = 0; i < mass.length; ++i) {
            System.out.print(mass[i]);
            System.out.print(' ');
        }

        System.out.println();
    }
}
