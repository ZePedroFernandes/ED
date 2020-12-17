package lists.OrderedLists;

import ADTs.ListADT;
import exceptions.EmptyException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents a list implemented using an array.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> type of the elements
 */
public abstract class ArrayList<T> implements ListADT<T> {

    /**
     * The elements in the list.
     */
    protected T[] elements;

    /**
     * The rear of the list.
     */
    protected int rear;

    /**
     * Value to use when an element isn't found.
     */
    private final int ELEMENT_NOT_FOUND = -1;

    /**
     * The default capacity of the list.
     */
    protected final int DEFAULT_CAPACITY = 10;

    /**
     * Implements an iterator to iterate the {@link ArrayList}.
     *
     * @param <T> the type of the elements in the {@link ArrayList}.
     */
    private class ArrayListIterator<T> implements Iterator<T> {

        /**
         * The iterator's cursor.
         */
        private int cursor;

        /**
         * Construct's an instance of {@link ArrayListIterator}.
         */
        private ArrayListIterator() {
            this.cursor = 0;
        }

        /**
         * Checks if the iterator has a next element.
         *
         * @return true if there is a net element, false if there isn´t.
         */
        @Override
        public boolean hasNext() {
            return (this.cursor < rear);
        }

        /**
         * Returns the iterator' next element.
         *
         * @return the iterator' next element.
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            cursor++;
            return ((T) elements[cursor - 1]);
        }
    }

    /**
     * Construct's an instance of {@link ArrayList}.
     */
    public ArrayList() {
        this.elements = (T[]) new Object[this.DEFAULT_CAPACITY];
        this.rear = 0;
    }

    /**
     * Construct's an instance of {@link ArrayList} with a specific size.
     *
     * @param size the size of the {@link ArrayList}.
     */
    public ArrayList(int size) {
        if (size == 0) {
            size++;
        }
        this.elements = (T[]) new Object[size];
        this.rear = 0;
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

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws EmptyException if the list is empty
     */
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
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     * @return removed element or null if it does not exist
     * @throws exceptions.EmptyException if the list is empty
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

    /**
     * Finds a specific element in the list returning the it's position in the
     * list.
     *
     * @param target the target element to find.
     * @return
     */
    private int find(T target) {
        for (int index = 0; index < this.rear; index++) {
            if (this.elements[index].equals(target)) {
                return index;
            }
        }
        return this.ELEMENT_NOT_FOUND;
    }

    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list
     */
    @Override
    public T first() {
        return this.elements[0];
    }

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list
     */
    @Override
    public T last() {
        return this.elements[this.rear - 1];
    }

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    @Override
    public boolean contains(T target) {
        if (this.isEmpty()) {
            return false;
        }
        return (this.find(target) != this.ELEMENT_NOT_FOUND);
    }

    /**
     * Expands the capacity of the {@link ArrayList} 2 times.
     */
    public void expandCapacity() {
        T[] oldElements = this.elements;
        this.elements = (T[]) new Object[this.elements.length * 2];

        for (int position = 0; position < oldElements.length; position++) {
            this.elements[position] = oldElements[position];
        }
    }

    /**
     * Returns true if this list contains no elements, otherwise returns false.
     *
     * @return true if this list contains no elements, otherwise returns false
     */
    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    @Override
    public int size() {
        return this.rear;
    }

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<>();
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        String list = "";

        for (int i = 0; i < this.rear; i++) {
            list += this.elements[i].toString();
        }
        return list;
    }

}
