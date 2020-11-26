/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @param <T>
 */
public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {

    protected int count;

    protected T[] tree;

    private final int CAPACITY = 50;

    public ArrayBinaryTree() {
        this.count = 0;
        this.tree = (T[]) new Object[this.CAPACITY];
    }

    public ArrayBinaryTree(T element) {
        this.count = 1;
        this.tree = (T[]) new Object[this.CAPACITY];
        this.tree[0] = element;
    }

    @Override
    public T getRoot() {
        return this.tree[0];
    }

    @Override
    public boolean isEmpty() {
        return (this.count == 0);
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean contains(T targetElement) {
        try {
            return (find(targetElement) != null);
        } catch (ElementNotFoundException ex) {
            return false;
        }
    }

    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        T element = null;
        boolean found = false;

        for (int current = 0; current < count; current++) {
            if (targetElement.equals(tree[current])) {
                element = tree[current];
                found = true;
            }
        }

        if (!found) {
            throw new ElementNotFoundException("Elemento não encontrado");
        }

        return element;
    }

    private void inOrder(int node, ArrayUnorderedList<T> tmpList) {
        if (node < tree.length) {
            if (tree[node] != null) {
                inOrder(2 * node + 1, tmpList);
                tmpList.addToRear(tree[node]);
                inOrder(2 * (node + 1), tmpList);
            }
        }
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tmpList = new ArrayUnorderedList<>();
        inOrder(0, tmpList);
        return tmpList.iterator();
    }

    private void preOrder(int node, ArrayUnorderedList<T> tmpList) {
        if (node < tree.length) {
            if (tree[node] != null) {
                tmpList.addToRear(tree[node]);
                inOrder(2 * node + 1, tmpList);
                inOrder(2 * (node + 1), tmpList);
            }
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tmpList = new ArrayUnorderedList<>();
        preOrder(0, tmpList);
        return tmpList.iterator();
    }

    private void postOrder(int node, ArrayUnorderedList<T> tmpList) {
        if (node < tree.length) {
            if (tree[node] != null) {
                inOrder(2 * node + 1, tmpList);
                inOrder(2 * (node + 1), tmpList);
                tmpList.addToRear(tree[node]);
            }
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tmpList = new ArrayUnorderedList<>();
        postOrder(0, tmpList);
        return tmpList.iterator();
    }

    private void levelOrder(LinkedQueue<Integer> nodes, ArrayUnorderedList<T> results) {
        try {
            nodes.enqueue(0);
        } catch (InvalidElementException ex) {
            System.out.println(ex.getMessage());
        }
        Integer element = null;

        while (!nodes.isEmpty()) {
            try {
                element = nodes.dequeue();
            } catch (EmptyException ex) {
                System.out.println(ex.getMessage());
            }
            if (tree[element] != null && element < count) {
                results.addToRear(tree[element]);
                try {
                    nodes.enqueue(2 * element + 1);
                    nodes.enqueue(2 * (element + 1));
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
        LinkedQueue<Integer> nodes = new LinkedQueue<>();
        ArrayUnorderedList<T> results = new ArrayUnorderedList<>();
        levelOrder(nodes, results);
        return results.iterator();
    }

}
