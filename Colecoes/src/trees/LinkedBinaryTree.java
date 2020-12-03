package trees;

import contracts.BinaryTreeADT;
import exceptions.ElementNotFoundException;
import exceptions.EmptyException;
import exceptions.InvalidElementException;
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

    public LinkedBinaryTree(){
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

    protected void inorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tmpList) {
        if (node != null) {
            inorder(node.left, tmpList);
            tmpList.addToRear(node.element);
            inorder(node.right, tmpList);
        }
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tmpList = new ArrayUnorderedList<>();
        inorder(root, tmpList);

        return tmpList.iterator();
    }

    protected void preOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tmpList) {
        if (node != null) {
            tmpList.addToRear(node.element);
            inorder(node.left, tmpList);
            inorder(node.right, tmpList);
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
            inorder(node.left, tmpList);
            inorder(node.right, tmpList);
            tmpList.addToRear(node.element);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tmpList = new ArrayUnorderedList<>();
        postOrder(root, tmpList);

        return tmpList.iterator();
    }

    public void levelOrder(LinkedQueue<BinaryTreeNode<T>> nodes, ArrayUnorderedList<T> results) {
        BinaryTreeNode<T> element = null;

        try {
            nodes.enqueue(root);
        } catch (InvalidElementException ex) {
            System.out.println(ex.getMessage());
        }

        while (!nodes.isEmpty()) {
            try {
                element = nodes.dequeue();
            } catch (EmptyException e) {
                System.out.println(e.getMessage());
            }

            if (element != null) {
                results.addToRear(element.element);
                try {
                    nodes.enqueue(element.left);
                    nodes.enqueue(element.right);
                } catch (InvalidElementException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                results.addToRear(null);
            }
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        LinkedQueue<BinaryTreeNode<T>> nodes = new LinkedQueue<>();
        ArrayUnorderedList<T> results = new ArrayUnorderedList<>();
        levelOrder(nodes, results);
        return results.iterator();
    }

}
