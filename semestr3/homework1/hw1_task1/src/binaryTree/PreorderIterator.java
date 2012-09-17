package binaryTree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Iterator for BinaryTree
 *
 * @author vladimir-zakharov
 */
public class PreorderIterator implements Iterator<Integer> {

    /**
     * constructor for PreorderIterator
     *
     * @param tree for this tree you will create an iterator
     */
    PreorderIterator(BinaryTree tree) {
        node = tree.getRoot();
        stack.push(node);
    }

    /**
     * Returns the current element value and advances the cursor to the next
     * position.
     *
     * @return the current element value
     * @throws NoSuchElementException if the iterator hasn't next element
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        node = stack.pop();
        int result = node.getValue();

        if (node.getRight() != null) {
            stack.push(node.getRight());
        }
        if (node.getLeft() != null) {
            stack.push(node.getLeft());
        }

        if (stack.empty()) {
            node = null;
        }

        return result;
    }

    /**
     * returns true if the iterator has next element; else false
     *
     * @return true if the iterator has next element; else false
     */
    @Override
    public boolean hasNext() {
        return node != null;
    }

    @Override
    public void remove() {
    }
    private TreeElement node;
    private Stack<TreeElement> stack = new Stack<TreeElement>();
}
