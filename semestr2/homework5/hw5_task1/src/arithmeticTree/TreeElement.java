package arithmeticTree;

/**
 *
 * @author vladimir-zakharov
 */
public interface TreeElement {
    
    void print();
    
    int calculate();
    
    void setLeft(TreeElement left);
    
    TreeElement getLeft();
    
    void setRight(TreeElement right);
    
    TreeElement getRight();
}
