package arithmeticTree;

/**
 * abstract class TreeElement
 *
 * @author vladimir-zakharov
 */
public abstract class TreeElement {

    /**
     * prints element
     */
    abstract void print();

    /**
     * calculates element
     *
     * @return number, if element is number; result of the operation if element
     * is operation
     */
    abstract int calculate();

    /**
     * add left child to element
     *
     * @param left element, which you want to add
     */
    void setLeft(TreeElement left) {
    }

    /**
     * return left child
     *
     * @return left child
     */
    TreeElement getLeft() {
        return null;
    }

    /**
     * add right child to element
     *
     * @param right element, which you want to add
     */
    void setRight(TreeElement right) {
    }

    /**
     * returns right child
     *
     * @return right child
     */
    TreeElement getRight() {
        return null;
    }
}
