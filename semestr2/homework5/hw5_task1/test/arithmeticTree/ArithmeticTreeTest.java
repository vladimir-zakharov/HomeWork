package arithmeticTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author vladimir-zakharov
 */
public class ArithmeticTreeTest {

    public class Writer {

        public void writeTextToFile(String text) throws IOException {
            File script = new File(fileName);
            FileWriter out = new FileWriter(script);
            out.write(text);
            out.close();
        }
        private String fileName = "/home/spec/HomeWork/semestr2/homework5/hw5_task1/src/arithmeticTree/input.txt";
    }

    /**
     * Test of print method, of class ArithmeticTree.
     */
    @Test
    public void testPrint() throws Exception {
        Writer writer = new Writer();
        File file = new File("/home/spec/HomeWork/semestr2/homework5/hw5_task1/src/arithmeticTree/input.txt");
        writer.writeTextToFile("(* (+ (* (+ 10 15) 2) 50) (- (+ 5 5) (/ 8 4)))");
        ArithmeticTree tree = new ArithmeticTree(file);
        tree.print();
        System.out.println();
        writer.writeTextToFile("(* (+ 1 1) 2)");
        tree = new ArithmeticTree(file);
        tree.print();
        System.out.println();
        writer.writeTextToFile("(+ (/ 100 20) (/ 100500 (/ 400 4))");
        tree = new ArithmeticTree(file);
        tree.print();
        System.out.println();
    }

    /**
     * Test of calculate method, of class ArithmeticTree.
     */
    @Test
    public void testCalculate() throws Exception {
        Writer writer = new Writer();
        File file = new File("/home/spec/HomeWork/semestr2/homework5/hw5_task1/src/arithmeticTree/input.txt");
        writer.writeTextToFile("(* (+ (* (+ 10 15) 2) 50) (- (+ 5 5) (/ 8 4)))");
        ArithmeticTree tree = new ArithmeticTree(file);
        assertEquals(800, tree.calculate());
        writer.writeTextToFile("(* (+ 1 1) 2)");
        tree = new ArithmeticTree(file);
        assertEquals(4, tree.calculate());
        writer.writeTextToFile("(+ (/ 100 20) (/ 100500 (/ 400 4))");
        tree = new ArithmeticTree(file);
        assertEquals(1010, tree.calculate());
    }
}
