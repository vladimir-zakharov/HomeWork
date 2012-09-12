package binaryTree;

/**
 * class TreeElement
 *
 * @author vladimir-zakharov
 */
public class TreeElement {
    
    /**
     * constructor for TreeElement
     * 
     * @param value value, which you initiate new element
     * @param left left son of new element
     * @param right right son of new element
     */
    public TreeElement(int value, TreeElement left, TreeElement right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * prints element
     */
    public void print() {
        System.out.println(value);
        if (left != null) {
            left.print();
        }
        if (right != null) {
            right.print();
        }
    }
    
    /**
     * returns element's value
     * 
     * @return element's value
     */
    public int getValue() {
       return value; 
    }
    
    /**
     * adds left child to element
     *
     * @param left element, which you want to add
     */
    void setLeft(TreeElement left) {
        this.left = left;
    }

    /**
     * returns left child
     *
     * @return left child
     */
    TreeElement getLeft() {
        return left;
    }

    /**
     * adds right child to element
     *
     * @param right element, which you want to add
     */
    void setRight(TreeElement right) {
        this.right = right;
    }

    /**
     * returns right child
     *
     * @return right child
     */
    TreeElement getRight() {
        return right;
    }
    
    private int value;
    private TreeElement left;
    private TreeElement right;
}
