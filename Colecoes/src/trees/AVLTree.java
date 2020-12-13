package trees;

import contracts.AvlBinarySearchTreeADT;
import exceptions.ElementNotFoundException;
import java.util.Iterator;
import lists.unorderedLists.ArrayUnorderedList;
import queues.LinkedQueue;

/**
 * This class represents a Linked Avl binary search tree;
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T>
 */
public class AVLTree<T> implements AvlBinarySearchTreeADT<T> {

    protected AVLNode<T> root;

    protected int count;

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
        AVLNode<T> temp = new AVLNode<>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;

        if (isEmpty()) {
            root = temp;
        } else {
            AVLNode<T> current = root;
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

    protected AVLNode<T> replacement(AVLNode<T> node) {
        AVLNode<T> result = null;

        if ((node.left == null) && (node.right == null)) {
            result = null;
        } else if ((node.left != null) && (node.right == null)) {
            result = node.left;
        } else if ((node.left == null) && (node.right != null)) {
            result = node.right;
        } else {
            AVLNode<T> current = node.right;
            AVLNode<T> parent = node;
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
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;
        if (!isEmpty()) {
            if (((Comparable) targetElement).equals(root.element)) {
                result = root.element;
                root = replacement(root);
                count--;
            } else {
                AVLNode<T> current;
                AVLNode<T> parent = root;
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

    private void updateFactor(AVLNode<T> node) {
        if (node.left == null && node.right == null) {
            node.balanceFactor = 0;
        } else if (node.left != null && node.right == null) {
            node.balanceFactor = -(Math.abs(node.left.balanceFactor) + 1);
        } else if (node.left == null && node.right != null) {
            node.balanceFactor = Math.abs(node.right.balanceFactor) + 1;
        } else {
            node.balanceFactor = this.getHeight(node.right) - this.getHeight(node.left);
        }
        if (node != root) {
            AVLNode<T> parent = this.getParent(node);
            updateFactor(parent);
        }
    }
    
    private int getHeight(AVLNode<T> node){
        if(node.left == null && node.right == null){
            return 1;
        }else{
            if(node.balanceFactor < 0){
                return (1 + this.getHeight(node.left));
            }else{
                return (1 + this.getHeight(node.right));
            }
        }
    }

    /**
     * Given a node present in the tree, finds and returns it's parent.
     *
     * @param node node to find the parent.
     * @return the node's parent.
     */
    private AVLNode<T> getParent(AVLNode<T> node) {
        AVLNode<T> parent = null;
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

    @Override
    public void rightRotation(AVLNode node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void leftRotation(AVLNode node) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        T element = null;
        if (root.left == null) {
            element = root.element;
            root = root.right;
        } else {
            AVLNode<T> parent = root;
            AVLNode<T> current = root.left;

            while (current.left != null) {
                parent = current;
                current = current.left;
            }
            element = current.getElement();
            parent.left = replacement(current);
        }

        return element;
    }

    @Override
    public T removeMax() {
        T element = null;
        if (root.right == null) {
            element = root.element;
            root = root.left;
        } else {
            AVLNode<T> parent = root;
            AVLNode<T> current = root.right;

            while (current.right != null) {
                parent = current;
                current = current.right;
            }
            element = current.getElement();
            parent.right = replacement(current);
        }

        return element;
    }

    @Override
    public T findMin() {
        T element = null;

        AVLNode<T> current = root;
        while (current.left != null) {
            current = current.left;
        }

        element = current.element;

        return element;
    }

    @Override
    public T findMax() {
        T element = null;

        AVLNode<T> current = root;
        while (current.right != null) {
            current = current.right;
        }

        element = current.element;

        return element;
    }

    @Override
    public T getRoot() {
        return this.root.element;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    private AVLNode<T> findAgain(T targetElement, AVLNode<T> next) {
        if (next == null) {
            return null;
        }

        if (next.element.equals(targetElement)) {
            return next;
        }

        AVLNode<T> tmp = findAgain(targetElement, next.left);

        if (tmp == null) {
            tmp = findAgain(targetElement, next.right);
        }

        return tmp;
    }

    @Override
    public boolean contains(T targetElement) {
        return (findAgain(targetElement, root) != null);
    }

    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        AVLNode<T> current = findAgain(targetElement, root);

        if (current == null) {
            throw new ElementNotFoundException("binary tree");
        }

        return current.element;
    }

    protected void inOrder(AVLNode<T> node, ArrayUnorderedList<T> tmpList) {
        if (node != null) {
            inOrder(node.left, tmpList);
            tmpList.addToRear(node.element);
            inOrder(node.right, tmpList);
        }
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tmpList = new ArrayUnorderedList<>();
        inOrder(root, tmpList);

        return tmpList.iterator();
    }

    protected void preOrder(AVLNode<T> node, ArrayUnorderedList<T> tmpList) {
        if (node != null) {
            tmpList.addToRear(node.element);
            preOrder(node.left, tmpList);
            preOrder(node.right, tmpList);
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tmpList = new ArrayUnorderedList<>();
        preOrder(root, tmpList);

        return tmpList.iterator();
    }

    public void postOrder(AVLNode<T> node, ArrayUnorderedList<T> tmpList) {
        if (node != null) {
            postOrder(node.left, tmpList);
            postOrder(node.right, tmpList);
            tmpList.addToRear(node.element);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tmpList = new ArrayUnorderedList<>();
        postOrder(root, tmpList);

        return tmpList.iterator();
    }

    public void levelOrder(ArrayUnorderedList<T> results) {
        LinkedQueue<AVLNode<T>> nodes = new LinkedQueue<>();
        AVLNode<T> element = null;
        nodes.enqueue(root);

        while (!nodes.isEmpty()) {
            element = nodes.dequeue();

            if (element != null) {
                results.addToRear(element.element);
                if (element.left != null) {
                    nodes.enqueue(element.left);
                }
                if (element.right != null) {
                    nodes.enqueue(element.right);
                }
            } else {
                results.addToRear(null);
            }
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnorderedList<T> results = new ArrayUnorderedList<>();
        levelOrder(results);
        return results.iterator();
    }

}
