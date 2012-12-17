package robots;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author vladimir-zakharov
 */
public class MainTest {

    /**
     * Test of numberOfRobots and setNewStructure methods, of class Main.
     */
    @Test
    public void testNumberOfRobotsAndSetNewStructure() {
        int[][] matrix = {
            {0, 1, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 1, 0}       
        };
        int[] structure = {1, 0, 0, 1, 1, 1};
        Main main = new Main(matrix, structure);
        assertEquals(main.numberOfRobots(), 4);

        int[] otherStructure = {0, 0, 1, 0, 0, 1};
        main.setNewStructure(matrix, otherStructure);
        assertEquals(main.numberOfRobots(), 2);
    }

    /**
     * Test of isSolved method, of class Main.
     */
    @Test
    public void testIsSolved1() {
        int[][] matrix = {
            {0, 1, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 1, 0}       
        };
        int[] robots = {1, 0, 0, 1, 1, 1};
        Main main = new Main(matrix, robots);
        assertTrue(main.isSolved());
    }
    
    /**
     * Test of isSolved method, of class Main.
     */
    @Test
    public void testIsSolved2() {
        int[][] matrix = {
            {0, 1, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0}       
        };
        int[] robots = {1, 0, 0, 1, 1, 1};
        Main main = new Main(matrix, robots);
        assertFalse(main.isSolved());
    }
    
    /**
     * Test of isSolved method, of class Main.
     */
    @Test
    public void testIsSolved3() {
        int[][] matrix = {
            {0, 1, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0}       
        };
        int[] robots = {1, 1, 0, 1, 1, 1};
        Main main = new Main(matrix, robots);
        assertTrue(main.isSolved());
    }
    
    /**
     * Test of isSolved method, of class Main.
     */
    @Test
    public void testIsSolved4() {
        int[][] matrix = {
            {0, 1, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0}       
        };
        int[] robots = {1, 0, 0, 0, 0, 0};
        Main main = new Main(matrix, robots);
        assertFalse(main.isSolved());
    }
}
