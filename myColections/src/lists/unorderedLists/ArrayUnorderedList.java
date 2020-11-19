package lists.unorderedLists;

import lists.OrderedLists.ArrayList;
import contracts.UnorderedListContract;
import exceptions.ElementNotFoundException;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> Type of elements.
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListContract<T> {

    public ArrayUnorderedList() {
    }

    public ArrayUnorderedList(int size) {
        super(size);
    }

    @Override
    public void addToFront(T element) {
        if (element == null) {
            return;
        }

        if (this.rear == this.elements.length) {
            this.expandCapacity();
        }

        for (int i = this.rear; i > 0; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[0] = element;
        this.rear++;
    }

    @Override
    public void addToRear(T element) {
        if (element == null) {
            return;
        }

        if (this.rear == this.elements.length) {
            this.expandCapacity();
        }
        this.elements[rear] = element;
        this.rear++;
    }

    @Override
    public void addAfter(T element, T target) throws ElementNotFoundException {
        if (element == null) {
            return;
        }

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
