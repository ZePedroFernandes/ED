package contracts;

import exceptions.ElementNotFoundException;

/**
 * The contract to implement an Unordered List.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> the type of elements to be stored in the list.
 */
public interface UnorderedListContract<T> {

    /**
     * Adds an element to the front of the list.
     *
     * @param element element to be added
     */
    public void addToFront(T element);

    /**
     * Adds an element to the rear of the list.
     *
     * @param element element to be added
     */
    public void addToRear(T element);

    /**
     * Adds an element after a particular element in the list.
     *
     * @param element element to be added
     * @param target target element
     * @throws ElementNotFoundException if the target is not found
     */
    public void addAfter(T element, T target) throws ElementNotFoundException;

}
