package lists.OrderedLists;

import contracts.ListADT;
import exceptions.EmptyException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> type of the elements
 */
public abstract class ArrayList<T> implements ListADT<T> {

    protected T[] elements;

    protected int rear;

    private final int ELEMENT_NOT_FOUND = -1;

    protected final int DEFAULT_CAPACITY = 10;

    private class ArrayListIterator<T> implements Iterator<T> {

        private int cursor;

        private ArrayListIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return (this.cursor < rear);
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            cursor++;
            return ((T) elements[cursor - 1]);
        }
    }

    public ArrayList() {
        this.elements = (T[]) new Object[this.DEFAULT_CAPACITY];
        this.rear = 0;
    }

    public ArrayList(int size) {
        if (size == 0) {
            size++;
        }
        this.elements = (T[]) new Object[size];
        this.rear = 0;
    }

    @Override
    public T removeFirst() throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("The list is empty");
        }

        T removedElement = this.elements[0];
        for (int i = 0; i < this.rear - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[this.rear - 1] = null;
        this.rear--;
        return removedElement;
    }

    @Override
    public T removeLast() throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("The list is empty");
        }

        T removedElement = this.elements[this.rear - 1];
        this.elements[this.rear - 1] = null;
        this.rear--;
        return removedElement;
    }

    /**
     * This method removes an element from the List.
     *
     * @param element the element to be returned;
     * @return the removed element or null if the element is not in the list.
     *
     */
    @Override
    public T remove(T element) throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("The list is empty");
        }

        int index = find(element);

        T removedElement = null;

        for (; index < this.rear - 1; index++) {
            this.elements[index] = this.elements[index + 1];
        }
        this.rear--;
        this.elements[this.rear] = null;

        return removedElement;
    }

    private int find(T element) {
//        if (element == null) {
//            return this.ELEMENT_NOT_FOUND;
//        }

        for (int index = 0; index < this.rear; index++) {
            if (this.elements[index].equals(element)) {
                return index;
            }
        }
        return this.ELEMENT_NOT_FOUND;
    }

    @Override
    public T first() {
        return this.elements[0];
    }

    @Override
    public T last() {
        return this.elements[this.rear - 1];
    }

    @Override
    public boolean contains(T target) {
        if (this.isEmpty()) {
            return false;
        }
        return (this.find(target) != this.ELEMENT_NOT_FOUND);
    }

    public void expandCapacity() {
        T[] oldElements = this.elements;
        this.elements = (T[]) new Object[this.elements.length * 2];

        for (int position = 0; position < oldElements.length; position++) {
            this.elements[position] = oldElements[position];
        }
    }

    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    @Override
    public int size() {
        return this.rear;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<>();
    }

    @Override
    public String toString() {
        String list = "";

        for (int i = 0; i < this.rear; i++) {
            list += this.elements[i].toString();
        }
        return list;
    }

}
