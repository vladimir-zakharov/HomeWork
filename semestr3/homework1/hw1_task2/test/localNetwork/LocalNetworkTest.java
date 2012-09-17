/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package localNetwork;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author vladimir-zakharov
 */
public class LocalNetworkTest {

    /**
     * Test of updateSystemState method, of class LocalNetwork.
     */
    @Test
    public void testUpdateSystemState() {
        int[][] networkStructure = {
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0}
        };
        
        Computer[] computers = new Computer[10];
        computers[0] = new TestComputer(new Windows(), true);
        computers[1] = new TestComputer(new Linux(), false);
        computers[2] = new TestComputer(new MacOS(), false);
        computers[3] = new TestComputer(new MacOS(), true);
        computers[4] = new TestComputer(new Linux(), false);
        computers[5] = new TestComputer(new Windows(), true);
        computers[6] = new TestComputer(new MacOS(), false);
        computers[7] = new TestComputer(new Windows(), false);
        computers[8] = new TestComputer(new Linux(), false);
        computers[9] = new TestComputer(new Linux(), false);
        LocalNetwork myNetwork = new LocalNetwork(networkStructure, computers);
        
        assertFalse(computers[2].currentState());
        assertFalse(computers[9].currentState());
        assertFalse(computers[4].currentState());
        myNetwork.updateSystemState();  
        assertTrue(computers[2].currentState());
        assertTrue(computers[9].currentState());
        assertTrue(computers[4].currentState());
        assertFalse(computers[1].currentState());
        assertFalse(computers[7].currentState());
        assertFalse(computers[8].currentState());
        myNetwork.updateSystemState(); 
        assertTrue(computers[1].currentState());
        assertTrue(computers[7].currentState());
        assertTrue(computers[8].currentState());
        assertFalse(computers[6].currentState());
        myNetwork.updateSystemState(); 
        assertTrue(computers[6].currentState());
    }

    /**
     * Test of printSysytemState method, of class LocalNetwork.
     */
    @Test
    public void testPrintSysytemState() {
        int[][] networkStructure = {
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0}
        };
        
        Computer[] computers = new Computer[10];
        computers[0] = new TestComputer(new Windows(), true);
        computers[1] = new TestComputer(new Linux(), false);
        computers[2] = new TestComputer(new MacOS(), false);
        computers[3] = new TestComputer(new MacOS(), true);
        computers[4] = new TestComputer(new Linux(), false);
        computers[5] = new TestComputer(new Windows(), true);
        computers[6] = new TestComputer(new MacOS(), false);
        computers[7] = new TestComputer(new Windows(), false);
        computers[8] = new TestComputer(new Linux(), false);
        computers[9] = new TestComputer(new Linux(), false);
        LocalNetwork myNetwork = new LocalNetwork(networkStructure, computers);
        myNetwork.printSysytemState();
    }
    
    private class TestComputer extends Computer {
       
        public TestComputer(OperatingSystem system, boolean startState) {
            super(system, startState);
            this.currentOS = system;
            this.isInfected = startState;
        }
        
        @Override
        public void virusAttack() {
            isInfected = true;
        }
        
        @Override
        public boolean currentState() {
            return isInfected;
        }
        
        private OperatingSystem currentOS;
        boolean isInfected;
    }
}
