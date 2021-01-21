package lists.unorderedLists;

import lists.OrderedLists.ArrayList;
import ADTs.UnorderedListContract;
import exceptions.ElementNotFoundException;

/**
 * Represents an array list that is not ordered.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> Type of elements in the list.
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListContract<T> {

    /**
     * Constructs an {@link ArrayUnorderedList}.
     */
    public ArrayUnorderedList() {
    }

    /**
     * Constructs an {@link ArrayUnorderedList} with a specific size.
     *
     * @param size the size of the list.
     */
    public ArrayUnorderedList(int size) {
        super(size);
    }

    /**
     * Adds an element to the front of the list.
     *
     * @param element element to be added
     */
    @Override
    public void addToFront(T element) {
        if (this.rear == this.elements.length) {
            this.expandCapacity();
        }

        for (int i = this.rear; i > 0; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[0] = element;
        this.rear++;
    }

    /**
     * Adds an element to the rear of the list.
     *
     * @param element element to be added
     */
    @Override
    public void addToRear(T element) {
        if (this.rear == this.elements.length) {
            this.expandCapacity();
        }
        this.elements[rear] = element;
        this.rear++;
    }

    /**
     * Adds an element after a particular element in the list.
     *
     * @param element element to be added
     * @param target target element
     * @throws ElementNotFoundException if the target is not found
     */
    @Override
    public void addAfter(T element, T target) throws ElementNotFoundException {
        if (this.rear == this.elements.length) {
            this.expandCapacity();
        }

        int index = 0;
        while (index < this.rear && !(this.elements[index] == target)) {
            index++;
        }

        for (int i = this.rear; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }

        if (index == this.rear) {
            throw new ElementNotFoundException();
        }
        this.elements[index] = element;
        this.rear++;
    }

}
