/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import contracts.BinarySearchTreeADT;
import exceptions.ElementNotFoundException;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

    /**
     * Creates an empty binary search tree.
     */
    public LinkedBinarySearchTree() {
        super();
    }

    /**
     * Creates a binary search with the specified element as its root.
     *
     * @param element the element that will be the root of the new binary search
     * tree
     */
    public LinkedBinarySearchTree(T element) {
        super(element);
    }

    /**
     * Adds the specified object to the binary search tree in the appropriate
     * position according to its key value. Note that equal elements are added
     * to the right.
     *
     * @param element the element to be added to the binary search tree
     */
    @Override
    public void addElement(T element) {
        BinaryTreeNode<T> temp = new BinaryTreeNode<>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;

        if (isEmpty()) {
            root = temp;
        } else {
            BinaryTreeNode<T> current = root;
            boolean added = false;

            while (!added) {
                if (comparableElement.compareTo(current.element) < 0) {
                    if (current.left == null) {
                        current.left = temp;
                        added = true;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = temp;
                        added = true;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
        count++;
    }

    /**
     * Removes the first element that matches the specified target element from
     * the binary search tree and returns a reference to it. Throws a
     * ElementNotFoundException if the specified target element is not found in
     * the binary search tree
     *
     * @param targetElement the element to be removed from this tree
     * @return the element removed from this tree
     * @throws exceptions.ElementNotFoundException if the element is not present
     * in the tree.
     */
    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;
        if (!isEmpty()) {
            if (((Comparable) targetElement).equals(root.element)) {
                result = root.element;
                root = replacement(root);
                count--;
            } else {
                BinaryTreeNode<T> current;
                BinaryTreeNode<T> parent = root;
                boolean found = false;
                if (((Comparable) targetElement).compareTo(root.element) < 0) {
                    current = root.left;
                } else {
                    current = root.right;
                }

                while (current != null && !found) {
                    if (targetElement.equals(current.element)) {
                        found = true;
                        count--;
                        result = current.element;

                        if (current == parent.left) {
                            parent.left = replacement(current);
                        } else {
                            parent.right = replacement(current);
                        }
                    } else {
                        parent = current;
                        if (((Comparable) targetElement).compareTo(current.element) < 0) {
                            current = current.left;
                        } else {
                            current = current.right;
                        }
                    }
                }
                if (!found) {
                    throw new ElementNotFoundException("binary search tree");
                }
            }
        }
        return result;
    }

    /**
     * Returns a reference to a node that will replace the one specified for
     * removal. In the case where the removed node has two children, the inorder
     * successor is used as its replacement.
     *
     * @param node the node to be removeed
     * @return a reference to the replacing node
     */
    protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;

        if ((node.left == null) && (node.right == null)) {
            result = null;
        } else if ((node.left != null) && (node.right == null)) {
            result = node.left;
        } else if ((node.left == null) && (node.right != null)) {
            result = node.right;
        } else {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;
            while (current.left != null) {
                parent = current;
                current = current.left;
            }
            if (node.right == current) {
                current.left = node.left;
            } else {
                parent.left = current.right;
                current.right = node.right;
                current.left = node.left;
            }
            result = current;
        }
        return result;
    }

    @Override
    public void removeAllOccurrences(T targetElement) {
        boolean stop = false;
        while (!stop) {
            try {
                removeElement(targetElement);
            } catch (ElementNotFoundException ex) {
                stop = true;
            }
        }
    }

    @Override
    public T removeMin() {
        T element;

        if (root.left == null) {
            element = root.element;
            root = root.right;
            return element;
        }

        BinaryTreeNode<T> parent = root;
        BinaryTreeNode<T> current = root.left;
        while (current.left != null) {
            current = current.left;
        }
        element = current.element;
        if (current.right != null) {
            current = current.right;
            parent.left = current;
        } else {
            parent.left = null;
        }
        return element;
    }

    @Override
    public T removeMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
