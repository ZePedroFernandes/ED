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
            updateBlancingFactor(root);
            balance(current);
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
            root = (AVLNode<T>) result;
        } else {
            if (node == parent.left) {
                parent.left = result;
            } else {
                parent.right = result;
            }
        }
        updateBlancingFactor(root);
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
    private void updateBlancingFactor(BinaryTreeNode<T> node) {
        if (node.left == null && node.right == null) {
            ((AVLNode<T>) node).balanceFactor = 0;
        } else if (node.left != null && node.right == null) {
            ((AVLNode<T>) node).balanceFactor = -(Math.abs(((AVLNode<T>) node.left).balanceFactor) + 1);
            updateBlancingFactor(node.left);
        } else if (node.left == null && node.right != null) {
            ((AVLNode<T>) node).balanceFactor = Math.abs(((AVLNode) node.right).balanceFactor) + 1;
            updateBlancingFactor(node.right);
        } else {
            ((AVLNode<T>) node).balanceFactor = this.getHeight(node.right) - this.getHeight(node.left);
            updateBlancingFactor(node.left);
            updateBlancingFactor(node.right);
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
            if (node.left == null) {
                return 1 + this.getHeight(node.right);
            }
            if (node.right == null) {
                return 1 + this.getHeight(node.left);
            }

            return 1 + Math.max(this.getHeight(node.left), this.getHeight(node.right));

//            if (((AVLNode<T>) node).balanceFactor < 0) {
//                return (1 + this.getHeight((AVLNode<T>) node.left));
//            } else {
//                return (1 + this.getHeight((AVLNode<T>) node.right));
//            }
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

    private BinaryTreeNode<T> getUnbalancedNode(BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (((AVLNode<T>) node).balanceFactor > 1 || ((AVLNode<T>) node).balanceFactor < -1) {
            return node;
        } else {
            return getUnbalancedNode(this.getParent(node));
        }
    }

    private void balance(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> unbalancedNode = this.getUnbalancedNode(node);
        if (((AVLNode<T>) root).balanceFactor > 1 || ((AVLNode<T>) root).balanceFactor < -1) {
//            if (((AVLNode<T>) unbalancedNode).balanceFactor < -1) {
//                if (((AVLNode<T>) unbalancedNode.left).balanceFactor > 0) {
//                    this.leftRotation(unbalancedNode.left);
//                }
//                this.rightRotation(unbalancedNode);
//            } else if (((AVLNode<T>) unbalancedNode).balanceFactor > 1) {
//                if (((AVLNode<T>) unbalancedNode.right).balanceFactor < 0) {
//                    this.rightRotation(unbalancedNode.right);
//                }
//                this.leftRotation(unbalancedNode);
//            }

            if (((AVLNode<T>) unbalancedNode).balanceFactor < -1 && ((AVLNode<T>) unbalancedNode.left).balanceFactor < 0) {
                this.rightRotation(unbalancedNode);
            } else if (((AVLNode<T>) unbalancedNode).balanceFactor > 1 && ((AVLNode<T>) unbalancedNode.right).balanceFactor > 0) {
                this.leftRotation(unbalancedNode);
            } else if (((AVLNode<T>) unbalancedNode).balanceFactor > 1 && ((AVLNode<T>) unbalancedNode.right).balanceFactor < 0) {
                this.rightRotation(unbalancedNode.right);
                this.leftRotation(unbalancedNode);
            } else if (((AVLNode<T>) unbalancedNode).balanceFactor < -1 && ((AVLNode<T>) unbalancedNode.left).balanceFactor > 0) {
                this.leftRotation(unbalancedNode.left);
                this.rightRotation(unbalancedNode);
            }
            updateBlancingFactor(root);
            balance(unbalancedNode);
        }
    }

    public void rightRotation(BinaryTreeNode<T> node) {
        if (node == root) {
            BinaryTreeNode<T> tmp = root;
            root = root.left;
            tmp.left = root.right;
            root.right = tmp;
        } else if (((AVLNode<T>) node).balanceFactor < -1) {
            BinaryTreeNode<T> parent = this.getParent(node);
            BinaryTreeNode<T> left = node.left;
            left.right = node;
            node.left = null;
            parent.left = left;
        } else {
            BinaryTreeNode<T> parent = this.getParent(node);
            parent.right = node.left;
            node.left = null;
            parent.right.right = node;
        }
//        BinaryTreeNode<T> left = node.left;
//        BinaryTreeNode<T> parent = this.getParent(left);
//        node.left = left.right;
//
//        left.right = node;
//
//        if (node != root) {
//            if (parent.left == node) {
//                parent.left = left;
//            } else {
//                parent.right = left;
//            }
//        } else {
//            this.root = left;
//        }

    }

    public void leftRotation(BinaryTreeNode<T> node) {
        if (node == root) {
            BinaryTreeNode<T> tmp = root;
            root = root.right;
            tmp.right = root.left;
            root.left = tmp;
        } else if (((AVLNode<T>) node).balanceFactor > 1) {
            BinaryTreeNode<T> parent = this.getParent(node);
            BinaryTreeNode<T> left = node.left;
            left.right = node;
            node.left = null;
            parent.left = left;
        } else {
            BinaryTreeNode<T> parent = this.getParent(node);
            parent.left = node.right;
            node.right = null;
            parent.left.left = node;
        }
//        BinaryTreeNode<T> right = node.right;
//        BinaryTreeNode<T> parent = this.getParent(right);
//        node.right = right.left;
//
//        right.left = node;
//
//        if (node != root) {
//            if (parent.left == node) {
//                parent.left = right;
//            } else {
//                parent.right = right;
//            }
//        } else {
//            this.root = right;
//        }

    }

}
