package localNetwork;

/**
 *
 * @author vladimir-zakharov
 */
abstract public class OperatingSystem {
    
    public int getInfectionProbability() {
        return infectionProbability;
    }

    protected int infectionProbability;
}
