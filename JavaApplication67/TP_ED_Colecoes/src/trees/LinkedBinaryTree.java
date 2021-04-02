package trees;

import ADTs.BinaryTreeADT;
import exceptions.ElementNotFoundException;
import java.util.Iterator;
import lists.unorderedLists.ArrayUnorderedList;
import queues.LinkedQueue;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> type of stored elements.
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    protected int count;

    protected BinaryTreeNode<T> root;

    public LinkedBinaryTree() {
        count = 0;
        root = new BinaryTreeNode<>();
    }

    public LinkedBinaryTree(T element) {
        count = 1;
        root = new BinaryTreeNode<>(element);
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

    @Override
    public boolean contains(T targetElement) {
        return (findAgain(targetElement, root) != null);
    }

    private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }

        if (next.element.equals(targetElement)) {
            return next;
        }

        BinaryTreeNode<T> tmp = findAgain(targetElement, next.left);

        if (tmp == null) {
            tmp = findAgain(targetElement, next.right);
        }

        return tmp;
    }

    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findAgain(targetElement, root);

        if (current == null) {
            throw new ElementNotFoundException("binary tree");
        }

        return current.element;
    }

    protected void inOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tmpList) {
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

    protected void preOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tmpList) {
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

    public void postOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tmpList) {
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
        if (!this.isEmpty()) {
            LinkedQueue<BinaryTreeNode<T>> nodes = new LinkedQueue<>();
            BinaryTreeNode<T> element = null;
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
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnorderedList<T> results = new ArrayUnorderedList<>();
        levelOrder(results);
        return results.iterator();
    }

    public void removeAllElements(){
        this.root = new BinaryTreeNode<>();
        count = 0;
    }
}
