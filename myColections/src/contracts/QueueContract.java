package contracts;

import exceptions.EmptyException;
import exceptions.InvalidElementException;

/**
 * Represents the interface that must be used to implement a queue.
 * 
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> Type of elements to be stored in the queue.
 */
public interface QueueContract<T> {

    /**
     * Adds an element to the rear of the queue.
     *
     * @param element element to be added.
     * @throws exceptions.InvalidElementException if the element is invalid
     */
    public void enqueue(T element) throws InvalidElementException;

    /**
     * Removes an element from the front of the queue.
     *
     * @return the removed element.
     * @throws exceptions.EmptyException if the queue is empty.
     */
    public T dequeue() throws EmptyException;

    /**
     * Examins the element at the front of the queue.
     *
     * @return the examined element.
     * @throws exceptions.EmptyException if the queue is empty.
     */
    public T first() throws EmptyException;

    /**
     * Determines if the queue is empty.
     *
     * @return true if the queue is empty otherwise returns false.
     */
    public boolean isEmpty();

    /**
     * Determines the number of the elements in the queue.
     *
     * @return the number of elements in the queue.
     */
    public int size();

}
