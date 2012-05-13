package arithmeticTree;

/**
 *
 * @author vladimir-zakharov
 */
public class Number extends TreeElement {
    
    public Number(String string) {
        this.number = string;
    }
    
    @Override
    public void print() {
        System.out.print(number + ' ');
    }
    
    @Override
    public int calculate() {
        return Integer.parseInt(number);
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
    private String number;
}
