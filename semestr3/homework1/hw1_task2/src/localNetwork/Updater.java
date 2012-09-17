package localNetwork;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author vladimir-zakharov
 */
public class Updater {

    public Updater(LocalNetwork network) {
        this.network = network;
    }

    public void start() {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                network.updateSystemState();
                network.printSysytemState();
            }
        };

        timer.schedule(task, 5000, 5000);
    }

    private LocalNetwork network;
}
