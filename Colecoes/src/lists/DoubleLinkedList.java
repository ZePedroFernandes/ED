package lists;

import contracts.ListADT;
import exceptions.EmptyException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import nodes.DoubleLinkedNode;

/**
 * This classe represents a Double Linked List that has sentinel nodes.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T>
 */
public abstract class DoubleLinkedList<T> implements ListADT<T>, Iterable<T> {

    /**
     * List's head node.
     */
    protected DoubleLinkedNode<T> head; //Sentinel Node

    /**
     * List's tail node.
     */
    protected DoubleLinkedNode<T> tail; //Sentinel Node

    /**
     * List's size.
     */
    protected int size;

    /**
     * Value to use when an element isn't found.
     */
    private final int ELEMENT_NOT_FOUND = -1;

    /**
     * Number of modifications since the creation of the list.
     */
    protected int modCount;

    /**
     * Construct's an Empty {@link DoubleLinkedList DoubleLinkedList}.
     */
    public DoubleLinkedList() {
        this.head = new DoubleLinkedNode<>();
        this.tail = new DoubleLinkedNode<>();
        this.head.setNext(this.tail);
        this.tail.setPrevious(this.head);
        this.size = 0;
        this.modCount = 0;
    }

    /**
     * This class allows to iterate the Double Linked List.
     *
     * @param <T> the type of elements stored in the list
     */
    private class DoubleLinkedListIterator<T> implements Iterator<T> {

        /**
         * The iterator's cursor.
         */
        private DoubleLinkedNode<T> cursor;

        /**
         * The excpected number of modifications to the
         * {@link DoubleLinkedList double linked list}.
         */
        private final int excpectedModCount;

        /**
         * Construct's an instance of the iterator
         * {@link DoubleLinkedListIterator}.
         *
         * @param modCount the current number of modifications in the double
         * linked list.
         */
        public DoubleLinkedListIterator(int modCount) {
            this.excpectedModCount = modCount;
            cursor = (DoubleLinkedNode<T>) head.getNext();
        }

        /**
         * Checks if the iterator has a next element. Throws a
         * {@link ConcurrentModificationException} if the
         * {@link DoubleLinkedList list} was modified.
         *
         * @return true if there is a net element, false if there isn´t
         */
        @Override
        public boolean hasNext() {
            if (this.excpectedModCount != modCount) {
                throw new ConcurrentModificationException("A lista foi alterada");
            }

            return (cursor != tail);
        }

        /**
         * Get's the next element in the {@link DoubleLinkedList list}. If there
         * is no next element an {@link NoSuchElementException} is thrown
         *
         * @return the next element in the list
         */
        @Override
        public T next() {
            T element = null;
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            element = cursor.getElement();
            cursor = cursor.getNext();
            return element;
        }
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
            throw new EmptyException("Empty List");
        }
        T removedElement = this.head.getNext().getElement();
        this.head.setNext(this.head.getNext().getNext());
        this.head.getNext().setPrevious(this.head);
        this.size--;
        this.modCount++;
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
            throw new EmptyException("Empty List");
        }
        T removedElement = this.tail.getPrevious().getElement();

        this.tail.setPrevious(this.tail.getPrevious().getPrevious());
        this.tail.getPrevious().setNext(this.tail);
        this.size--;
        this.modCount++;
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
            throw new EmptyException("Empty List");
        }
        DoubleLinkedNode<T> targetNode = this.find(element);

        if (targetNode == null) {
            return null;
        }

        targetNode.getPrevious().setNext(targetNode.getNext());
        targetNode.getNext().setPrevious(targetNode.getPrevious());
        this.size--;
        this.modCount++;

        return element;
    }

    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list
     */
    @Override
    public T first() {
        return this.head.getElement();
    }

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list
     */
    @Override
    public T last() {
        return this.tail.getElement();
    }

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    @Override
    public boolean contains(T target) {
        return (this.find(target) != null);
    }

    /**
     * Finds an element in the list and returns it's node.
     *
     * @param target the target element to be found
     * @return a reference to the node where the element was found
     */
    private DoubleLinkedNode<T> find(T target) {
        DoubleLinkedNode<T> current = this.head.getNext();
        DoubleLinkedNode<T> targetNode = null;
        boolean found = false;

        while (current != this.tail && !found) {
            if (current.getElement() == target) {
                found = true;
            } else {
                current = current.getNext();
            }
        }
        if (found) {
            targetNode = current;
        }
        return targetNode;
    }

    /**
     * Returns true if this list contains no elements, otherwise returns false.
     *
     * @return true if this list contains no elements, otherwise returns false
     */
    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator() {
        return (new DoubleLinkedListIterator<>(this.modCount));
    }

    /**
     * Returns an inverted copy of the list in the form of an array.
     *
     * @return an inverted array representation of the
     * {@link DoubleLinkedList list}.
     */
    public T[] getInverted() {
        T[] array = (T[]) new Object[this.size];
        this.invert(array, this.head.getNext(), this.size);
        return array;
    }

    /**
     * Inverts all elements in the {@link DoubleLinkedList list} and passes them
     * to an array. Works recursively. For each iteration, the next element is passed
     * to the last available position in the array.
     *
     * @param array the array where the information will be stored
     * @param startNode the start node
     * @param size the size of the list
     * @return the element of the previous node.
     */
    private T invert(T[] array, DoubleLinkedNode<T> startNode, int size) {
        if (startNode == this.tail.getPrevious()) {
            array[size - 1] = startNode.getElement();
            return startNode.getPrevious().getElement();
        } else {
            array[size - 1] = invert(array, startNode.getNext(), size - 1);
            return startNode.getPrevious().getElement();
        }
    }

    /**
     * Returns a String representation of the {@link DoubleLinkedNode}.
     *
     * @return a String representation of the {@link DoubleLinkedNode}.
     */
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return null;
        }
        String result = "";
        DoubleLinkedNode<T> current = this.head.getNext();

        while (current != this.tail) {
            result += current.getElement().toString() + "\n";
            current = current.getNext();
        }

        return result.substring(0, result.length() - 1);
    }
}
