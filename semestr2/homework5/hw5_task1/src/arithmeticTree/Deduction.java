package arithmeticTree;

/**
 *
 * @author vladimir-zakharov
 */
public class Deduction implements TreeElement {

    @Override
    public void print() {
        System.out.print('(');
        System.out.print("* ");
        left.print();
        right.print();
        System.out.print(')');
    }

    @Override
    public int calculate() {
        return left.calculate() - right.calculate();
    }

    @Override
    public void setLeft(TreeElement left) {
        this.left = left;
    }

    @Override
    public TreeElement getLeft() {
        return left;
    }

    @Override
    public void setRight(TreeElement right) {
        this.right = right;
    }

    @Override
    public TreeElement getRight() {
        return right;
    }
    
    private TreeElement left;
    private TreeElement right;
}
