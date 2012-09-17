package localNetwork;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author vladimir-zakharov
 */
public class LocalNetwork {

    public LocalNetwork(int[][] structure, Computer[] computers) {
        this.networkStructure = structure;
        this.computers = computers;
    }

    public static void main(String[] args) {
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
        computers[0] = new Computer(new Windows(), true);
        computers[1] = new Computer(new Linux(), false);
        computers[2] = new Computer(new MacOS(), false);
        computers[3] = new Computer(new MacOS(), true);
        computers[4] = new Computer(new Linux(), false);
        computers[5] = new Computer(new Windows(), true);
        computers[6] = new Computer(new MacOS(), false);
        computers[7] = new Computer(new Windows(), false);
        computers[8] = new Computer(new Linux(), false);
        computers[9] = new Computer(new Linux(), false);
        myNetwork = new LocalNetwork(networkStructure, computers);
        myNetwork.printSysytemState();
        
        Updater updater = new Updater(myNetwork);
        updater.start();
    }
    private static LocalNetwork myNetwork;

    public void updateSystemState() {
        Computer[] currentComputersState = new Computer[computers.length];
        for (int i = 0; i < currentComputersState.length; ++i) {
            currentComputersState[i] = new Computer(computers[i].getOperatingSystem(),
                    computers[i].currentState());
        }

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (networkStructure[i][j] == 1) {
                    if (currentComputersState[i].currentState()) {
                        computers[j].virusAttack();
                    }
                }
            }
        }
    }

    public void printSysytemState() {
        for (int i = 0; i < 10; ++i) {
            if (computers[i].currentState()) {
                System.out.println("Computer # " + i + " is infected");
            } else {
                System.out.println("Computer # " + i + " isn't infected");
            }
        }

        System.out.println();
    }
    private Computer[] computers;
    private int[][] networkStructure;
}
