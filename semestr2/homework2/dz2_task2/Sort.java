package sortMass;

/**
 * сортирует массив одним из способов
 */
public class Sort {

    /**
     * сортирует двумерный массив методом пузырька
     */
    public static void bubbleSort(int[][] mass) {
        for (int i = 0; i < mass.length - 1; ++i) {
            for (int j = 0; j < mass.length - i - 1; ++j) {
                if (mass[0][j] > mass[0][j + 1]) {
                    for (int k = 0; k < mass.length; ++k) {
                        int temp = mass[k][j];
                        mass[k][j] = mass[k][j + 1];
                        mass[k][j + 1] = temp;
                    }
                }
            }
        }
    }
}
