package arithmeticTree;

import java.io.File;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author vladimir-zakharov
 */
public class ArithmeticTreeTest {

    /**
     * Test of print method, of class ArithmeticTree.
     */
    @Test
    public void testPrint() {
        File file = new File("/home/spec/HomeWork/semestr2/homework5/hw5_task1/src/arithmeticTree/input.txt");
        ArithmeticTree tree = new ArithmeticTree(file);
        tree.print();
    }

    /**
     * Test of calculate method, of class ArithmeticTree.
     */
    @Test
    public void testCalculate() {
        File file = new File("/home/spec/HomeWork/semestr2/homework5/hw5_task1/src/arithmeticTree/input.txt");
        ArithmeticTree tree = new ArithmeticTree(file);
        assertEquals(800, tree.calculate());
    }
}
