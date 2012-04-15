package clock;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;

/**
 *
 * @author vladimir-zakharov
 */
public class Clock extends JFrame {

    public Clock() {
        Timer timer = new Timer(1000, new MyListener());
        timer.start();
    }

    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    public void showForm() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(250, 250);
    }

    @Override
    public void paint(java.awt.Graphics painter) {

        Calendar time = Calendar.getInstance();
        int hour = time.get(Calendar.HOUR_OF_DAY) % 12;
        int minute = time.get(Calendar.MINUTE);
        int second = time.get(Calendar.SECOND);

        super.paint(painter);
        Graphics2D painter2D = (Graphics2D) painter;
        painter2D.translate(getWidth() / 2, (getHeight() + 20) / 2);
        double side = Math.min(getWidth(), getHeight());
        painter2D.scale(side / 250.0, side / 250.0);

        int[] xHour = {1, -1, -1, -3, 0, 3, 1};
        int[] yHour = {3, 3, -40, -40, -45, -40, -40};

        int[] xMinute = {1, -1, -1, -3, 0, 3, 1};
        int[] yMinute = {3, 3, -60, -60, -65, -60, -60};

        int[] xSecond = {1, -1, -1, -3, 0, 3, 1};
        int[] ySecond = {3, 3, -80, -80, -85, -80, -80};

        painter2D.rotate(Math.PI * (30.0 * (hour + minute / 60) / 180));
        painter2D.setColor(Color.red);
        painter2D.fillPolygon(xHour, yHour, 7);
        painter2D.rotate(-Math.PI * (30.0 * (hour + minute / 60) / 180));

        painter2D.rotate(Math.PI * (6.0 * (minute + second / 60) / 180));
        Color darkGreen = new Color(0, 150, 0);
        painter2D.setColor(darkGreen);
        painter2D.fillPolygon(xMinute, yMinute, 7);
        painter2D.rotate(-Math.PI * (6.0 * (minute + second / 60) / 180));

        painter2D.rotate(Math.PI * (6.0 * second / 180));
        painter2D.setColor(Color.blue);
        painter2D.fillPolygon(xSecond, ySecond, 7);
        painter2D.rotate(-Math.PI * (6.0 * second / 180));    
        
        painter2D.setColor(Color.red);
        for (int i = 0; i < 12; ++i) {
            painter2D.drawLine(-90, 0, -95, 0);
            painter2D.rotate(Math.PI / 6);
        }

        painter2D.setColor(darkGreen);
        for (int i = 0; i < 60; ++i) {
            if ((i % 5) != 0) {
                painter2D.drawLine(-90, 0, -95, 0);
            }
            painter2D.rotate(Math.PI / 30);
        }
    }
}