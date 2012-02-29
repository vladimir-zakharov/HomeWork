/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spiral;

/**
 * Предназначен для распечатывания двумерного массива по спирали
 */
public class PrintSpiral extends PrintMass {

    /**
     * Распечатывет элемент массива
     * @param mass
     * @param i
     * @param j 
     */
    private static void printElement(int[][] mass, int i, int j) {
        System.out.print(mass[i][j]);
        System.out.print(' ');
    }

    /**
     * Распечатывает двумерный массив по спирали, начиная с центра
     * @param mass
     */
     @Override public void printMass(int[][] mass) {
        int i = (1 + mass.length) / 2 - 1;
        int j = i;
        int iMove = 1;
        int jMove = -1;
        System.out.println("Данный массив, распечатанный по спирали, "
                + "начиная из центра:");

        for (int k = 1; k < mass.length; ++k) {

            for (int l = 0; l < k; ++l) {
                printElement(mass, i, j);
                j = j + jMove;
            }

            for (int l = 0; l < k; ++l) {
                printElement(mass, i, j);
                i = i + iMove;
            }

            iMove = -iMove;
            jMove = -jMove;
        }

        for (int l = 0; l < mass.length; ++l) {
            printElement(mass, i, j);
            j = j + jMove;
        }
    }
}

