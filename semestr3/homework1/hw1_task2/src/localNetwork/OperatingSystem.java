package localNetwork;

/**
 *
 * @author vladimir-zakharov
 */
public abstract class OperatingSystem {

    public int getInfectionProbability() {
        return infectionProbability;
    }
    
    protected int infectionProbability;
}
