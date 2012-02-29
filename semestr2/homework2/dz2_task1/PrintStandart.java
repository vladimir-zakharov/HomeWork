package spiral;

/**
 * Предназачен для стандартного распечатнывания массива
 */
class PrintStandart extends PrintMass {

    /**
     * Распечатывает двумерный массив в стандартной форме
     * @param mass
     */
   @Override public void printMass(int[][] mass) {
        System.out.println("Получившийся массив:");
        for (int i = 0; i < mass.length; ++i) {
            for (int j = 0; j < mass.length; ++j) {
                System.out.print(mass[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}