package sortMass;

import javax.swing.JOptionPane;

public class Main {

    final static int size = 3;

    public static void main(String[] argv) {
        int[][] mass = new int[size][size];
        in(mass);
        System.out.println("Получившийся массив:");
        printMass(mass);
        Sort.bubbleSort(mass);
        System.out.println("Отсортированный массив:");
        printMass(mass);
    }

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

    public static void printMass(int[][] mass) {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                printElement(mass, i, j);
            }
            System.out.println();
        }
    }

    public static void printElement(int[][] mass, int i, int j) {
        System.out.print(mass[i][j]);
        System.out.print(' ');
    }
}
