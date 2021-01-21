package trees;

import ADTs.AvlBinarySearchTreeADT;
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

    /**
     * Adds an element to the tree. Alters the node balancing factor in the
     * nodes that need that update. Balances the tree after adding if there is
     * the need to.
     *
     * @param element element to be added to the tree.
     */
    @Override
    public void addElement(T element) {
        BinaryTreeNode<T> temp = new AVLNode<>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;

        if (isEmpty()) {
            root = (AVLNode<T>) temp;
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
//            linearBalanceFactorUpdateDown(root, current);
            updateBalanceFactorUp(current);
            balance(current);
        }
        count++;

    }

    /**
     * Removes a node based on its parent. Updates all necessary balancing
     * factors. Balances the tree if needed.
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
                } else {
                    updateNode = parent2;
                }
                //caso current.right == null, o nodo pai irá ter que levar um update ao seu fator de balanceamento
                parent2.left = current.right;
                current.right = node.right;
                current.left = node.left;
            }
            result = current;
        }
        if (parent == root && node == root) { //O elemento a substituir é o root.
            root = (AVLNode<T>) result;
        } else {
            if (node == parent.left) {
                parent.left = result;
            } else {
                parent.right = result;
            }
            updateBalanceFactorUp(updateNode);
            balance(updateNode);
        }

    }

    /**
     * Finds and removes an element from the tree.
     *
     * @param targetElement the element to be removed
     */
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
     * Updates the balancing factor of a node an the balancing node of it's
     * parents.
     *
     * @param node the node wich balancing factor will be updated.
     */
    private void updateBalanceFactorUp(BinaryTreeNode<T> node) {
        if (node != null) {
            ((AVLNode<T>) node).balanceFactor = this.getHeight(node.right) - this.getHeight(node.left);
            updateBalanceFactorUp(this.getParent(node));
        }
    }

    private void linearBalanceFactorUpdateDown(BinaryTreeNode<T> updateNode, BinaryTreeNode<T> targetNode) {
        ((AVLNode<T>) updateNode).balanceFactor = this.getHeight(updateNode.right) - this.getHeight(updateNode.left);
        if (updateNode != targetNode) {
            if (((Comparable<T>) targetNode.element).compareTo(updateNode.element) < 0) {
                updateNode = updateNode.left;
            } else {
                updateNode = updateNode.right;
            }
            linearBalanceFactorUpdateDown(updateNode, targetNode);
        }
    }

    /**
     * Updates the balancing factor of a node an the balancing factor of it's
     * childs.
     *
     * @param node the node wich balancing factor will be updated.
     */
    private void updateBalanceFactorDown(BinaryTreeNode<T> node) {
        if (node != null) {
            ((AVLNode<T>) node).balanceFactor = this.getHeight(node.right) - this.getHeight(node.left);
            updateBalanceFactorDown(node.left);
            updateBalanceFactorDown(node.right);
        }
    }
    /**
     * Gets the height of a node. If the node is null the heihgt is -1 If the
     * node has no childs the height is 0 Else the height is 1 + the max height
     * between the left and right child.
     *
     * @param node the node to calculate the height.
     * @return the height of the node.
     */
    private int getHeight(BinaryTreeNode<T> node) {
        if (node == null) {
            return -1;
        }
        if (node.left == null && node.right == null) {
            return 0;
        }

        return 1 + Math.max(this.getHeight(node.left), this.getHeight(node.right));
    }

    /**
     * Given a node present in the tree, finds and returns it's parent. If the
     * node is the root null is returned.
     *
     * @param node node to find the parent.
     * @return the node's parent or null if the node is the root.
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

    /**
     * Recursively searchs the tree from bottom to top, if the node is
     * unbalanced that node is returned, if not the parent node is checked to
     * see if that one is unbalanced and so on. If there are no unbalanced nodes
     * returns null;
     *
     * @param node node to check balancing
     * @return the unbalanced node or the next unbalanced ascending node .
     */
    private BinaryTreeNode<T> getAscendingUnbalancedNode(BinaryTreeNode<T> node) {
//        if (node == null) {
//            return null;
//        }
//        if (((AVLNode<T>) node).balanceFactor > 1 || ((AVLNode<T>) node).balanceFactor < -1) {
//            return node;
//        } else {
//            return getAscendingUnbalancedNode(this.getParent(node));
//        }
        BinaryTreeNode<T> unbalancedNode = null;
        if (node != null) {
            if (((AVLNode<T>) node).isBalanced()) {
                unbalancedNode = getAscendingUnbalancedNode(this.getParent(node));
            } else {
                unbalancedNode = node;
            }
        }
        return unbalancedNode;
    }

    /**
     * Balances the tree if the node or any ascendent is unbalanced.
     *
     * @param node the node to check the balancing.
     */
    private void balance(BinaryTreeNode<T> node) {
        AVLNode<T> unbalancedNode = (AVLNode<T>) getAscendingUnbalancedNode(node);

        if (unbalancedNode != null) {
            if (unbalancedNode.isLeftHeavy()) {
                if (unbalancedNode.isLeftRightHeavy()) {
                    leftRotation(unbalancedNode.left);
                }
                rightRotation(unbalancedNode);
            } else if (unbalancedNode.isRightHeavy()) {
                if (unbalancedNode.isRightLeftHeavy()) {
                    rightRotation(unbalancedNode.right);
                }

                leftRotation(unbalancedNode);
            }
            updateBalanceFactorDown(root);
        }
        
    }

    /**
     * Performs a right roation in a specifc node.
     *
     * @param node the node to be rotated
     */
    public void rightRotation(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> parent = this.getParent(node);
        BinaryTreeNode<T> temp = node.left;
        node.left = temp.right;
        temp.right = node;

        if (parent == null) {
            root = temp;
        } else {
            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
        }
    }

    /**
     * Performs a left roation in a specifc node.
     *
     * @param node the node to be rotated
     */
    public void leftRotation(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> parent = this.getParent(node);
        BinaryTreeNode<T> temp = node.right;

        node.right = temp.left;
        temp.left = node;

        if (parent == null) {
            root = temp;
        } else {
            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
        }
    }

}
