package trees;

import contracts.AvlBinarySearchTreeADT;
import exceptions.ElementNotFoundException;

/**
 * This class represents a Linked Avl binary search tree;
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T>
 */
public class AVLTree<T> extends LinkedBinarySearchTree<T> implements AvlBinarySearchTreeADT<T> {

    public AVLTree(T element) {
        count = 0;
        this.root = new AVLNode<>(element);
    }

    public AVLTree() {
        count = 0;
        root = new AVLNode<>();
    }

    @Override
    public void addElement(T element) {
        BinaryTreeNode<T> temp = new AVLNode<>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;

        if (isEmpty()) {
            root = (AVLNode<T>)temp;
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
            updateFactor(current);
        }
        count++;
    }

    /**
     * Removes a node based on its parent.
     *
     * @param parent the node's parent node
     * @param node the node to be removed.
     */
    protected void removeNode(BinaryTreeNode<T> parent, BinaryTreeNode<T> node) {

        BinaryTreeNode<T> result = null;
        BinaryTreeNode<T> updateNode = parent;

        if ((node.left == null) && (node.right == null)) {
            //O nodo pai irá ter que levar um update ao seu fator de balanceamento
            result = null;
        } else if ((node.left != null) && (node.right == null)) {
            //O nodo node.left irá ter que levar um update ao seu fator de balanceamento
            updateNode = node.left;
            result = node.left;
        } else if ((node.left == null) && (node.right != null)) {
            //O nodo node.right irá ter que levar um update ao seu fator de balanceamento
            updateNode = node.right;
            result = node.right;
        } else {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent2 = node;
            while (current.left != null) {
                parent2 = current;
                current = current.left;
            }
            if (node.right == current) {
                current.left = node.left;
                //O nodo current irá ter que levar um update ao seu fator de balanceamento
                updateNode = current;
            } else {
                if (current.right != null) {
                    updateNode = current.right;
                }
                //caso current.right == null, o nodo pai irá ter que levar um update ao seu fator de balanceamento
                parent2.left = current.right;
                current.right = node.right;
                current.left = node.left;
            }
            result = current;
        }
        if (parent == root && node == root) { //O elemento a substituir é o root.
            root = (AVLNode<T>)result;
        } else {
            if (node == parent.left) {
                parent.left = result;
            } else {
                parent.right = result;
            }
        }
        updateFactor(updateNode);
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;
        if (!isEmpty()) {
            if (((Comparable) targetElement).equals(root.element)) {
                result = root.element;
                removeNode(root, root);
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
                        removeNode(parent, current);
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
     * Updates the balancing factor of a node.
     *
     * @param node the node wich balancing factor will be updated.
     */
    private void updateFactor(BinaryTreeNode<T> node) {
        if (node.left == null && node.right == null) {
            ((AVLNode<T>)node).balanceFactor = 0;
        } else if (node.left != null && node.right == null) {
            ((AVLNode<T>)node).balanceFactor = -(Math.abs(((AVLNode<T>) node.left).balanceFactor) + 1);
        } else if (node.left == null && node.right != null) {
            ((AVLNode<T>)node).balanceFactor = Math.abs(((AVLNode)node.right).balanceFactor) + 1;
        } else {
            ((AVLNode<T>)node).balanceFactor = this.getHeight(node.right) - this.getHeight(node.left);
        }
        if (node != root) {
            BinaryTreeNode<T> parent = this.getParent(node);
            updateFactor(parent);
        }
    }

    /**
     * Gets the height of a node. (The number of descendants + 1).
     *
     * @param node the node to calculate the height.
     * @return the height of the node.
     */
    private int getHeight(BinaryTreeNode<T> node) {
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            if (((AVLNode<T>)node).balanceFactor < 0) {
                return (1 + this.getHeight((AVLNode<T>)node.left));
            } else {
                return (1 + this.getHeight((AVLNode<T>)node.right));
            }
        }
    }

    /**
     * Given a node present in the tree, finds and returns it's parent.
     *
     * @param node node to find the parent.
     * @return the node's parent.
     */
    private BinaryTreeNode<T> getParent(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> parent = null;
        boolean found = false;

        if (node != root) {
            parent = root;
            while (!found) {
                if (((Comparable<T>) parent.element).compareTo(node.element) > 0) {
                    if (parent.left == node) {
                        found = true;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == node) {
                        found = true;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }

        return parent;
    }

    public void rightRotation(BinaryTreeNode node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void leftRotation(BinaryTreeNode node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
