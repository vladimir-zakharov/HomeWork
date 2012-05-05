package arithmeticTree;

/**
 * interface of tree element
 *
 * @author vladimir-zakharov
 */
public interface TreeElement {

    /**
     * prints element
     */
    void print();

    /**
     * calculates element
     *
     * @return number, if element is number; result of the operation if element
     * is operation
     */
    int calculate();

    /**
     * add left child to element
     *
     * @param left element, which you want to add
     */
    void setLeft(TreeElement left);

    /**
     * return left child
     *
     * @return left child
     */
    TreeElement getLeft();

    /**
     * add right child to element
     *
     * @param right element, which you want to add
     */
    void setRight(TreeElement right);

    /**
     * returns right child
     *
     * @return right child
     */
    TreeElement getRight();
}
