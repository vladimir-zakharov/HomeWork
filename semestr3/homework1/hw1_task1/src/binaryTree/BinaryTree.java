package binaryTree;

/**
 *
 * @author vladimir-zakharov
 */
public class BinaryTree {

    /**
     * prints all elements
     */
    public void print() {
        root.print();
    }
    
    /**
     * add value to the tree
     * 
     * @param value value, which you want to add
     */
    public void addValue(int value) {
        if (root == null) {
            root = new TreeElement(value, null, null);
        } else {
            TreeElement temp = root;
            
            while(temp != null) {
                if (temp.getValue() < value) {
                    if (temp.getRight() == null) {
                        temp.setRight(new TreeElement(value, null, null));
                        break;
                    } else {
                        temp = temp.getRight();
                    }
                } else if (temp.getValue() > value) {
                    if (temp.getLeft() == null) {
                        temp.setLeft(new TreeElement(value, null, null));
                        break;
                    } else {
                        temp = temp.getLeft();
                    }
                } else {
                    break;
                }
            }
        }     
    }
    
    public TreeElement getRoot() {
        return root;
    }
    
    public PreorderIterator iterator() {
        return new PreorderIterator(this);
    }
    
    /**
     * head of the tree
     */
    private TreeElement root;
}
