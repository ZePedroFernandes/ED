package ADTs;

import exceptions.EmptyCollectionException;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> the type of elements to store in the heap
 */
public interface HeapADT<T> extends BinaryTreeADT<T> {

    /**
     * Adds the specified object to this heap.
     *
     * @param obj the element to added to this head
     */
    public void addElement(T obj);

    /**
     * Removes element with the lowest value from this heap.
     *
     * @return the element with the lowest value from this heap
     * @throws EmptyCollectionException if the heap is empty
     */
    public T removeMin() throws EmptyCollectionException;

    /**
     * Returns a reference to the element with the lowest value in this heap.
     *
     * @return a reference to the element with the lowest value in this heap
     */
    public T findMin();
}
