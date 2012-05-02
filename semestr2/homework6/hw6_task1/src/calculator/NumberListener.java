/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author vladimir-zakharov
 */
public class NumberListener implements ActionListener {

    NumberListener(Calculator calculator) {
        this.calc = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String clickedButtonLabel = clickedButton.getText();
        calc.setText(calc.getText() + clickedButtonLabel);
    }
    private Calculator calc;
}