package calculator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author vladimir-zakharov
 */
public class CalculatorListener implements ActionListener {

    CalculatorListener(Calculator calculator) {
        this.calc = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String dispFieldText = calc.getText();
        double displayValue = 0;

        int point = 0;

        for (int i = 0; i != dispFieldText.length(); i++) {
            if (dispFieldText.charAt(i) == '.') {
                point++;

                if (point > 1) {
                    JOptionPane.showConfirmDialog(null,
                            "More than one point", "Error!",
                            JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);
                }
            }

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

        switch (clickedButton.getText().charAt(0)) {
            case '+':
                selectedAction = '+';
                currentResult = displayValue;
                calc.setText("");
                break;
            case '-':
                selectedAction = '-';
                currentResult = displayValue;
                calc.setText("");
                break;
            case '*':
                selectedAction = '*';
                currentResult = displayValue;
                calc.setText("");
                break;
            case '/':
                selectedAction = '/';
                currentResult = displayValue;
                calc.setText("");
                break;
            case 'C':
                currentResult = 0;
                calc.setText("");
                break;
            case '=':
                switch (selectedAction) {
                    case '+':
                        currentResult += displayValue;
                        calc.setText("" + currentResult);
                        break;
                    case '-':
                        currentResult -= displayValue;
                        calc.setText("" + currentResult);
                        break;
                    case '*':
                        currentResult *= displayValue;
                        calc.setText("" + currentResult);
                        break;
                    case '/':
                        if (displayValue == 0) {
                            JOptionPane.showConfirmDialog(null,
                                    "Division by zero", "Error!",
                                    JOptionPane.PLAIN_MESSAGE);
                            calc.setText("");
                        } else {
                            currentResult /= displayValue;
                            calc.setText("" + currentResult);
                        }
                        break;
                    case ' ':
                        break;
                    default:
                        String clickedButtonLabel = clickedButton.getText();
                        calc.setText(dispFieldText + clickedButtonLabel);
                        break;
                }
                break;
            default:
                String clickedButtonLabel = clickedButton.getText();
                calc.setText(dispFieldText + clickedButtonLabel);
                break;
        }
    }
    private Calculator calc;
    private char selectedAction = ' ';
    private double currentResult;
}
