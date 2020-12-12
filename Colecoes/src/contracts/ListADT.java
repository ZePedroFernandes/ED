package contracts;

import exceptions.EmptyException;
import java.util.Iterator;

/**
 * This interface represents a contract to create a list.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> the type of elements in the list.
 */
public interface ListADT<T> extends Iterable<T> {

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws EmptyException if the list is empty
     */
    public T removeFirst() throws EmptyException;

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws EmptyException if the list is empty
     */
    public T removeLast() throws EmptyException;

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     * @return removed element or null if it does not exist
     * @throws exceptions.EmptyException if the list is empty
     */
    public T remove(T element) throws EmptyException;

    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list
     */
    public T first();

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list
     */
    public T last();

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    public boolean contains(T target);

    /**
     * Returns true if this list contains no elements, otherwise returns false.
     *
     * @return true if this list contains no elements, otherwise returns false
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    public int size();

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator();

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString();
}
