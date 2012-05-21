/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package associativeArray;

import java.util.ArrayList;

/**
 *
 * @author vladimir-zakharov
 */
public class Btree<Type> {

    /**
     * constructor
     */
    public Btree() {
        root = new Node();
        root.setIndexParent(-1);
    }

    /**
     * inserts element into btree
     *
     * @param key key of the inserted element
     * @param value value of the inserted element
     */
    public void insert(int key, Type value) {
        insertElement(root, key, value);

        if (root.elements.size() == 2 * order - 1) {
            Node node1 = new Node();
            Node node2 = new Node();
            int j = 0;
            while (j < order - 1) {
                Element temp = root.elements.get(j);
                node1.elements.add(j, temp);
                if (!root.children.isEmpty()) {
                    Node child = root.children.get(j);
                    node1.children.add(j, child);
                    node1.children.get(j).setParent(node1);
                    node1.children.get(j).setIndexParent(j);
                }
                ++j;
            }
            if (!root.children.isEmpty()) {
                node1.children.add(j, root.children.get(j));
                node1.children.get(j).setParent(node1);
                node1.children.get(j).setIndexParent(j);
            }
            ++j;
            while (j < 2 * order - 1) {
                Element temp = root.elements.get(j);
                node2.elements.add(j - order, temp);
                if (!root.children.isEmpty()) {
                    Node child = root.children.get(j);
                    node2.children.add(j - order, child);
                    node2.children.get(j - order).setParent(node2);
                    node2.children.get(j - order).setIndexParent(j - order);
                }
                ++j;
            }
            if (!root.children.isEmpty()) {
                node2.children.add(j - order, root.children.get(j));
                node2.children.get(j - order).setParent(node2);
                node2.children.get(j - order).setIndexParent(j - order);
            }
            Element mid = root.elements.get(order - 1);
            Node newRoot = new Node();
            newRoot.elements.add(0, mid);
            newRoot.children.add(0, node1);
            newRoot.children.add(1, node2);
            newRoot.setIndexParent(-1);
            node1.setParent(newRoot);
            node2.setParent(newRoot);
            node1.setIndexParent(0);
            node2.setIndexParent(1);
            root = newRoot;
        }
    }

    /**
     * removes element from the btree
     *
     * @param key key of removed element
     * @throws Exception will be thrown, if key not found
     */
    public void remove(int key) throws Exception {
        if (root.children.isEmpty()) {
            int search = binarySearch(root, key);
            if (search == -1) {
                throw new NotFoundElementException();
            } else {
                root.elements.remove(root.elements.get(search));
            }
        } else {
            Node node = searchNode(root, key);
            if (node == null) {
                throw new NotFoundElementException();
            } else {
                removeElement(node, key);
            }
        }
    }

    /**
     * searchs element with the current key
     *
     * @param key key of the element, which you want to find
     * @return value of the element
     */
    public Type search(int key) {
        return searchElement(root, key);
    }

    private void insertElement(Node node, int key, Type value) {
        if (!node.children.isEmpty()) {
            int i = 0;
            while (i < node.elements.size() && key > node.elements.get(i).key) {
                ++i;
            }
            insertElement(node.children.get(i), key, value);
            if (node.children.get(i).elements.size() == 2 * order - 1) {
                Node currentNode = node.children.get(i);
                Node node1 = new Node();
                Node node2 = new Node();
                int j = 0;
                while (j < order - 1) {
                    Element temp = currentNode.elements.get(j);
                    node1.elements.add(j, temp);
                    if (!currentNode.children.isEmpty()) {
                        Node child = currentNode.children.get(j);
                        node1.children.add(j, child);
                        node1.children.get(j).setParent(node1);
                        node1.children.get(j).setIndexParent(j);
                    }
                    ++j;
                }
                if (!currentNode.children.isEmpty()) {
                    node1.children.add(j, currentNode.children.get(j));
                    node1.children.get(j).setParent(node1);
                    node1.children.get(j).setIndexParent(j);
                }
                ++j;
                while (j < 2 * order - 1) {
                    Element temp = currentNode.elements.get(j);
                    node2.elements.add(j - order, temp);
                    if (!currentNode.children.isEmpty()) {
                        Node child = currentNode.children.get(j);
                        node2.children.add(j - order, child);
                        node2.children.get(j - order).setParent(node2);
                        node2.children.get(j - order).setIndexParent(j - order);
                    }
                    ++j;
                }
                if (!currentNode.children.isEmpty()) {
                    node2.children.add(j - order, currentNode.children.get(j));
                    node2.children.get(j - order).setParent(node2);
                    node2.children.get(j - order).setIndexParent(j - order);
                }
                Element mid = currentNode.elements.get(order - 1);
                node.elements.add(i, mid);
                node.children.remove(i);
                node.children.add(i, node1);
                node.children.add(i + 1, node2);
                node1.setParent(node);
                node2.setParent(node);
                node1.setIndexParent(i);
                node2.setIndexParent(i + 1);
            }
        } else {
            int i = 0;
            while (i < node.elements.size() && key > node.elements.get(i).key) {
                ++i;
            }
            node.elements.add(i, new Element(key, value));
        }
    }

    private void removeElement(Node node, int key) {
        if (node.children.isEmpty()) {
            int search = binarySearch(node, key);
            node.elements.remove(search);
            if (node.elements.size() < order - 1) {
                reconstruct(node);
                int parentSize = node.parent.elements.size();
                if (parentSize < order - 1) {
                    if (node.parent != root) {
                        reconstruct(node.parent);
                    }
                }
                if (root.elements.isEmpty()) {
                    root = root.children.get(0);
                    root.setParent(null);
                    root.setIndexParent(-1);
                }
            }
        } else {
            int i = binarySearch(node, key);
            Node temp = rightMostChild(node.children.get(i));
            Element memory = temp.elements.get(temp.elements.size() - 1);
            removeElement(temp, memory.key);
            Node currentNode = searchNode(root, key);
            int j = binarySearch(currentNode, key);
            currentNode.elements.remove(j);
            currentNode.elements.add(j, memory);
        }
    }

    private void reconstruct(Node node) {
        Node parent = node.parent;
        int parentSize = parent.children.size();
        int i = node.indexParent;
        if (i + 1 < parentSize && parent.children.get(i + 1).elements.size() >= order) {
            Node rightBrother = parent.children.get(i + 1);
            Element separator = parent.elements.get(i);
            parent.elements.remove(i);
            node.elements.add(separator);
            if (!rightBrother.children.isEmpty()) {
                node.children.add(rightBrother.children.get(0));
                node.children.get(node.children.size() - 1).setParent(node);
                node.children.get(node.children.size() - 1).setIndexParent(node.children.size() - 1);
                rightBrother.children.remove(0);
                for (int j = 0; j < rightBrother.children.size(); ++j) {
                    Node child = rightBrother.children.get(j);
                    child.setIndexParent(j);
                }
            }
            Element temp = rightBrother.elements.get(0);
            rightBrother.elements.remove(0);
            parent.elements.add(i, temp);
        } else if (i - 1 >= 0 && parent.children.get(i - 1).elements.size() >= order) {
            Node leftBrother = parent.children.get(i - 1);
            Element separator = parent.elements.get(i - 1);
            parent.elements.remove(i - 1);
            node.elements.add(0, separator);
            if (!leftBrother.children.isEmpty()) {
                node.children.add(0, leftBrother.children.get(leftBrother.elements.size() - 1));
                node.children.get(0).setParent(node);
                node.children.get(0).setIndexParent(0);
                leftBrother.children.remove(leftBrother.elements.size() - 1);
                for (int j = 0; j < leftBrother.children.size(); ++j) {
                    Node child = leftBrother.children.get(j);
                    child.setIndexParent(j);
                }
            }
            Element temp = leftBrother.elements.get(leftBrother.elements.size() - 1);
            leftBrother.elements.remove(leftBrother.elements.size() - 1);
            parent.elements.add(i - 1, temp);
        } else {
            merge(node);
        }
    }

    private void merge(Node node) {
        Node parent = node.parent;
        int parentSize = parent.children.size();
        int i = node.indexParent;
        if (i + 1 < parentSize) {
            Node rightBrother = parent.children.get(i + 1);
            node.elements.add(parent.elements.get(i));
            parent.elements.remove(i);
            node.elements.addAll(rightBrother.elements);
            int sizeNode = node.children.size() - 1;
            for (int j = 0; j < rightBrother.children.size(); ++j) {
                Node child = rightBrother.children.get(j);
                node.children.add(child);
                node.children.get(sizeNode + j).setParent(node);
                node.children.get(sizeNode + j).setIndexParent(sizeNode + j);
            }
            parent.children.remove(i + 1);
        } else {
            Node leftBrother = parent.children.get(i - 1);
            node.elements.add(0, parent.elements.get(i - 1));
            parent.elements.remove(i - 1);
            node.elements.addAll(0, leftBrother.elements);
            for (int j = 0; j < leftBrother.children.size(); ++j) {
                Node child = leftBrother.children.get(j);
                node.children.add(j, child);
                node.children.get(j).setParent(node);
                node.children.get(j).setIndexParent(j);
            }
            parent.children.remove(i - 1);
        }
        for (int j = 0; j < parent.children.size(); ++j) {
            Node child = parent.children.get(j);
            child.setIndexParent(j);
        }
    }

    private Node rightMostChild(Node node) {
        while (!node.children.isEmpty()) {
            node = node.children.get(node.children.size() - 1);
        }

        return node;
    }

    private Type searchElement(Node node, int key) {
        if (node.elements.isEmpty()) {
            return null;
        }

        int search = binarySearch(node, key);
        if (search != -1) {
            return node.elements.get(search).value;
        } else {
            int i = 0;
            while (i < node.elements.size() && key > node.elements.get(i).key) {
                ++i;
            }
            if (node.children.size() - 1 < i) {
                return null;
            } else {
                return searchElement(node.children.get(i), key);
            }
        }
    }

    private Node searchNode(Node node, int key) {
        if (node.elements.isEmpty()) {
            return null;
        }

        int search = binarySearch(node, key);
        if (search != -1) {
            return node;
        } else {
            int i = 0;
            while (i < node.elements.size() && key > node.elements.get(i).key) {
                ++i;
            }
            if (node.children.size() - 1 < i) {
                return null;
            } else {
                return searchNode(node.children.get(i), key);
            }
        }
    }

    private int binarySearch(Node node, int key) {
        if (node.elements.isEmpty()) {
            return -1;
        }
        int mid = node.elements.size() / 2;
        int midKey = node.elements.get(mid).key;
        int begin = 0;
        int end = node.elements.size() - 1;
        while (begin <= end) {

            if (key == midKey) {
                return mid;
            }

            if (key < midKey) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }

            mid = (begin + end) / 2;
            midKey = node.elements.get(mid).key;
        }

        return -1;
    }

    private class Node {

        private Node() {
            this.elements = new ArrayList<Element>();
            this.children = new ArrayList<Node>();
        }

        private void setParent(Node parent) {
            this.parent = parent;
        }

        private void setIndexParent(int indexParent) {
            this.indexParent = indexParent;
        }
        Node parent;
        int indexParent;
        ArrayList<Element> elements;
        ArrayList<Node> children;
    }

    private class Element {

        private Element(int key, Type value) {
            this.key = key;
            this.value = value;
        }

        private Element(Element element) {
            this.key = element.key;
            this.value = element.value;
        }
        int key;
        Type value;
    }
    private Node root;
    private final int order = 3;
}
