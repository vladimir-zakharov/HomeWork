package arithmeticTree;

/**
 *
 * @author vladimir-zakharov
 */
public class Deduction extends Operation {

    @Override
    public void print() {
        System.out.print('(');
        System.out.print("- ");
        super.print();
    }

    @Override
    public int calculate() {
        return this.getLeft().calculate() - this.getRight().calculate();
    }
}
