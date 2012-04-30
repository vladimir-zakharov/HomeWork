package calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author vladimir-zakharov
 */
public class Calculator extends JFrame {

    public void showForm() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        Font myFont = new Font("MyFont", 4, 30);
        displayField.setFont(myFont);
        displayField.setHorizontalAlignment(JTextField.RIGHT);

        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        add("North", displayField);

        JPanel mainPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(5, 4);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);
        mainPanel.setLayout(gridLayout);
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(buttonClear);
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);
        mainPanel.add(buttonPlus);
        mainPanel.add(button4);
        mainPanel.add(button5);
        mainPanel.add(button6);
        mainPanel.add(buttonMinus);
        mainPanel.add(button7);
        mainPanel.add(button8);
        mainPanel.add(button9);
        mainPanel.add(buttonMultiply);
        mainPanel.add(button0);
        mainPanel.add(buttonPoint);
        mainPanel.add(buttonEqual);
        mainPanel.add(buttonDivide);

        add("Center", mainPanel);

        CalculatorListener calcListener = new CalculatorListener(this);
        button0.addActionListener(calcListener);
        button1.addActionListener(calcListener);
        button2.addActionListener(calcListener);
        button3.addActionListener(calcListener);
        button4.addActionListener(calcListener);
        button5.addActionListener(calcListener);
        button6.addActionListener(calcListener);
        button7.addActionListener(calcListener);
        button8.addActionListener(calcListener);
        button9.addActionListener(calcListener);
        buttonPoint.addActionListener(calcListener);
        buttonPlus.addActionListener(calcListener);
        buttonMinus.addActionListener(calcListener);
        buttonDivide.addActionListener(calcListener);
        buttonMultiply.addActionListener(calcListener);
        buttonEqual.addActionListener(calcListener);
        buttonClear.addActionListener(calcListener);
    }

    public void setText(String text) {
        displayField.setText(text);
    }

    public String getText() {
        return displayField.getText();
    }
    private JTextField displayField = new JTextField(10);
    private JButton button0 = new JButton("0");
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");
    private JButton button7 = new JButton("7");
    private JButton button8 = new JButton("8");
    private JButton button9 = new JButton("9");
    private JButton buttonPoint = new JButton(".");
    private JButton buttonEqual = new JButton("=");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonDivide = new JButton("/");
    private JButton buttonMultiply = new JButton("*");
    private JButton buttonClear = new JButton("C");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
}
