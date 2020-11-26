package lists.OrderedLists;

import exceptions.InvalidElementException;

/**
 *
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> The type of elements to be stored.
 */
public class ArrayOrderedList<T> extends ArrayList<T> {

    public ArrayOrderedList() {
        super();
    }

    public ArrayOrderedList(int size) {
        super(size);
    }

    public void add(T element) throws InvalidElementException{
        if(element == null){
            throw new InvalidElementException();
        }

        Comparable<T> temp = (Comparable<T>) element;

        if (this.rear == this.elements.length) {
            this.expandCapacity();
        }
        int targetPosition = 0;
        while (targetPosition < rear && temp.compareTo(this.elements[targetPosition]) > 0) {
            targetPosition++;
        }

        for (int pos = this.rear; pos > targetPosition; pos--) {
            this.elements[pos] = this.elements[pos - 1];
        }

        this.elements[targetPosition] = element;
        this.rear++;
    }

}
