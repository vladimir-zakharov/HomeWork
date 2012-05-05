package arithmeticTree;

import java.io.*;

/**
 *
 * @author vladimir-zakharov
 */
public class ArithmeticTree {

    public ArithmeticTree(File file) {
        String string = "";
        BufferedReader input;
        try {
            input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            string = input.readLine();
        } catch (IOException e) {
        }
        init(string, head, 0);
    }

    public void print() {
        head.print();
    }

    public int calculate() {
        return head.calculate();
    }

    private void init(String string, TreeElement currentElement, int key) {
        String temp = "";
        
        switch(key) {
            case 0:
                head = setOperation(string.charAt(count));
                currentElement = head;
                break;
            case 1:
                currentElement.setLeft(setOperation(string.charAt(count)));
                currentElement = currentElement.getLeft();
                break;
            case 2:
                currentElement.setRight(setOperation(string.charAt(count)));
                currentElement = currentElement.getRight();
                break;
        }
        
        count += 2;

        while (isDigit(string.charAt(count))) {
            temp += string.charAt(count);
            count++;
        }

        if (!temp.equals("")) {
            currentElement.setLeft(new Number(temp));
        } else if (string.charAt(count) == '(') {
            count++;
            init(string, currentElement, 1);
        }
        
        if (string.charAt(count) == ')') {
            count++;
        }
        count ++;
        temp = "";

        while (isDigit(string.charAt(count))) {
            temp += string.charAt(count);
            count++;
        }

        if (!temp.equals("")) {
            currentElement.setRight(new Number(temp));
        } else if (string.charAt(count) == '(') {
            count++;
            init(string, currentElement, 2);
        }
    }

    private boolean isDigit(char symbol) {
        return (symbol >= '0' && symbol <= '9');
    }

    private TreeElement setOperation(char operation) {
        switch (operation) {
            case '+':
                return new Addition();
            case '-':
                return new Deduction();
            case '*':
                return new Multiplication();
            case '/':
                return new Division();
            default:
                return null;
        }
    }
    
    private int count = 1;
    private TreeElement head;

    public static void main(String[] argv) {
        ArithmeticTree tree = new ArithmeticTree(new File("/home/spec/HomeWork/semestr2/homework5/hw5_task1/src/arithmeticTree/input.txt"));
        tree.print();
        System.out.println();
        System.out.println(tree.calculate());
    }
}
