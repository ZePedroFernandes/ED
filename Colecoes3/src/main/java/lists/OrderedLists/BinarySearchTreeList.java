package lists.OrderedLists;

import ADTs.ListADT;
import exceptions.ElementNotFoundException;
import exceptions.EmptyException;
import exceptions.InvalidElementException;
import java.util.Iterator;
import trees.LinkedBinarySearchTree;

/**
 * This classe implements a list using a {@link LinkedBinarySearchTree}.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class BinarySearchTreeList<T> implements ListADT<T> {

    private LinkedBinarySearchTree<T> tree;

    /**
     * Construct's a {@link BinarySearchTreeList list}.
     */
    public BinarySearchTreeList() {
        tree = new LinkedBinarySearchTree<>();
    }

    /**
     * Construct's a {@link BinarySearchTreeList list} with a element.
     *
     * @param element element to be added to the list.
     */
    public BinarySearchTreeList(T element) {
        tree = new LinkedBinarySearchTree<>(element);
    }

    public void add(T element) throws InvalidElementException {
        if (element == null) {
            throw new InvalidElementException("null elements aren´t valid");
        }
        tree.addElement(element);
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws EmptyException if the list is empty
     */
    @Override
    public T removeFirst() throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("Empty List");
        }

        T element = tree.findMin();
        tree.removeMin();
        return element;
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws EmptyException if the list is empty
     */
    @Override
    public T removeLast() throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("Empty List");
        }

        T element = tree.findMax();
        tree.removeMax();
        return element;
    }

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     * @return removed element or null if it does not exist
     * @throws exceptions.EmptyException if the list is empty
     */
    @Override
    public T remove(T element) throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("Empty List");
        }

        T removedElement = null;
        try {
            removedElement = tree.removeElement(element);
        } catch (ElementNotFoundException ex) {
        }

        return removedElement;
    }

    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list
     */
    @Override
    public T first() {
        return tree.findMin();
    }

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list
     */
    @Override
    public T last() {
        return tree.findMax();
    }

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    @Override
    public boolean contains(T target) {
        return tree.contains(target);
    }

    /**
     * Returns true if this list contains no elements, otherwise returns false.
     *
     * @return true if this list contains no elements, otherwise returns false
     */
    @Override
    public boolean isEmpty() {
        return (tree.size() == 0);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    @Override
    public int size() {
        return tree.size();
    }

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator() {
        return tree.iteratorInOrder();
    }

}
