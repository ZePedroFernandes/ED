package contracts;

import exceptions.ElementNotFoundException;
import java.util.Iterator;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public interface BinaryTreeADT<T> {

    /**
     * Return a reference to the root element.
     *
     * @return a reference to the root element.
     */
    public T getRoot();

    /**
     * Returns true if this binary tree is empty and false otherwise.
     *
     * @return true if this binary tree is empty.
     */
    public boolean isEmpty();

    /**
     * Returnshe number of elements in this binary tree.
     *
     * @return the integer number of elements in this tree
     */
    public int size();

    /**
     * Returns true if the binary tree contains an element that matches the
     * specified element and false otherwise.
     *
     * @param targetElement the element being sought in the tree
     * @return true if the tree contains the target element
     */
    public boolean contains(T targetElement);

    /**
     * Returns a reference to the specified element if it is found in this
     * binary tree. Throws an exception if the specified element is not found.
     *
     * @param targetElement the element being sought in the tree
     * @return a reference to the specified element
     * @throws exceptions.ElementNotFoundException if the specified element is not found.
     */
    public T find(T targetElement) throws ElementNotFoundException;

    /**
     * Returns the string representation of the binary tree.
     *
     * @return a string representation of the binary tree
     */
    @Override
    public String toString();

    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with the root.
     *
     *
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorInOrder();

    /**
     * Performs a preorder traversal on this binary tree by calling an
     * overloaded, recursive preorder method that starts with the root.
     *
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorPreOrder();

    /**
     * Performs a postorder traversal on this binary tree by calling an
     * overloaded, recursive postorder method that starts with the root.
     *
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorPostOrder();

    /**
     * Performs a levelorder traversal on the binary tree, using a queue.
     *
     *
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorLevelOrder();
}
