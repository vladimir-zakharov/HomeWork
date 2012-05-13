package arithmeticTree;

/**
 *
 * @author vladimir-zakharov
 */
public abstract class Operation extends TreeElement {

    /**
     * prints element
     */
    @Override
    public void print() {
        left.print();
        right.print();
        System.out.print(')');
    }

    /**
     * add left child to element
     *
     * @param left element, which you want to add
     */
    @Override
    public void setLeft(TreeElement left) {
        this.left = left;
    }

    /**
     * return left child
     *
     * @return left child
     */
    @Override
    public TreeElement getLeft() {
        return left;
    }

    /**
     * add right child to element
     *
     * @param right element, which you want to add
     */
    @Override
    public void setRight(TreeElement right) {
        this.right = right;
    }

    /**
     * returns right child
     *
     * @return right child
     */
    @Override
    public TreeElement getRight() {
        return right;
    }
    
    private TreeElement left;
    private TreeElement right;
}
