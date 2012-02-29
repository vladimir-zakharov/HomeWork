package StackClass;

public class Main {

    public static void main(String[] argv) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(15);
        int summ = stack.pop() + stack.headValue();
        System.out.println(summ);
    }
}
