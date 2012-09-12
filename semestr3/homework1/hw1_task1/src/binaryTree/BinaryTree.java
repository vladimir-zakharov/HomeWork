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
        head.print();
    }
    
    /**
     * add value to the tree
     * 
     * @param value value, which you want to add
     */
    public void addValue(int value) {
        if (head == null) {
            head = new TreeElement(value, null, null);
        } else {
            TreeElement temp = head;
            
            while(temp != null) {
                if (temp.getValue() < value) {
                    if (temp.getRight() == null) {
                        temp.setRight(new TreeElement(value, null, null));
                    } else {
                        temp = temp.getRight();
                    }
                } else if (temp.getValue() > value) {
                    if (temp.getLeft() == null) {
                        temp.setLeft(new TreeElement(value, null, null));
                    } else {
                        temp = temp.getLeft();
                    }
                } else {
                    break;
                }
            }
        }     
    }
    
    /**
     * head of the tree
     */
    private TreeElement head;
}
