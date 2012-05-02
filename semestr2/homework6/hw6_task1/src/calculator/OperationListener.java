package calculator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author vladimir-zakharov
 */
public class OperationListener implements ActionListener {

    OperationListener(Calculator calculator) {
        this.calc = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String dispFieldText = calc.getText();
        double displayValue = 0;

        if (clickedButton.getText().charAt(0) == 'C') {
            currentResult = 0;
            calc.setText("");
            selectedAction = 'C';
            return;
        }

        int point = 0;

        for (int i = 0; i != dispFieldText.length(); i++) {
            if (dispFieldText.charAt(i) == '.') {
                point++;
            }
        }
        if (point > 1) {
            JOptionPane.showConfirmDialog(null, "More than one point", "Error!",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);
        }

        if (!"".equals(dispFieldText)) {
            try {
                displayValue = Double.parseDouble(dispFieldText);
            } catch (NumberFormatException exception) {
                javax.swing.JOptionPane.showConfirmDialog(null,
                        "Incorrect insertion", "Error",
                        javax.swing.JOptionPane.PLAIN_MESSAGE);
                return;
            }
        }

        if (clickedButton.getText().charAt(0) == '=') {
            calculate(selectedAction, displayValue);
            selectedAction = '=';
        } else {
            if (selectedAction == 'C' || selectedAction == '=') {
                currentResult = displayValue;
            } else {
                calculate(selectedAction, displayValue);
            }
            selectedAction = clickedButton.getText().charAt(0);
            calc.setText("");
        }
    }

    private void calculate(char selectedAction, double value) {
        switch (selectedAction) {
            case '+':
                currentResult += value;
                calc.setText("" + currentResult);
                break;
            case '-':
                currentResult -= value;
                calc.setText("" + currentResult);
                break;
            case '*':
                currentResult *= value;
                calc.setText("" + currentResult);
                break;
            case '/':
                if (value == 0) {
                    JOptionPane.showConfirmDialog(null,
                            "Division by zero", "Error!",
                            JOptionPane.PLAIN_MESSAGE);
                    calc.setText("");
                } else {
                    currentResult /= value;
                    calc.setText("" + currentResult);
                }
                break;
        }
    }
    private Calculator calc;
    private char selectedAction = 'C';
    private double currentResult;
}
