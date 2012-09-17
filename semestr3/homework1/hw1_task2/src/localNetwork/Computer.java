package localNetwork;

import java.util.Random;

/**
 *
 * @author vladimir-zakharov
 */
public class Computer {

    public Computer(OperatingSystem system, boolean startState) {
        this.currentOS = system;
        this.isInfected = startState;
    }

    public void virusAttack() {
        Random random = new Random();
        int num = random.nextInt(100) + 1;
        if (num <= currentOS.getInfectionProbability()) {
            isInfected = true;
        }
    }
    
    public boolean currentState() {
        return isInfected;
    }
    
    public OperatingSystem getOperatingSystem() {
        return currentOS;
    } 
    
    private OperatingSystem currentOS;
    private boolean isInfected;
}
