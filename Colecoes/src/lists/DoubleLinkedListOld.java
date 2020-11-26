package lists;

import exceptions.InvalidSizeException;
import exceptions.EmptyException;
import exceptions.InvalidElementException;
import nodes.DoubleLinkedNode;

/**
 * This class represents a Doubly Linked List. Contains
 * {@link DoubleLinkedNode doubly linked nodes} that have a next and previous
 * node making it simpler to remove Nodes that the
 * {@link LinkedList LinkedList}.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> The type of the information to be stored in the list.
 */
public class DoubleLinkedListOld<T> {

    /**
     * The number of {@link DoubleLinkedNode Nodes} present in the
     * {@link DoubleLinkedListOld List}.
     */
    private int count;

    /**
     * The {@link DoubleLinkedNode List's} head.
     */
    private DoubleLinkedNode<T> head;

    /**
     * The {@link DoubleLinkedNode List's} tail.
     */
    private DoubleLinkedNode<T> tail;

    public DoubleLinkedListOld() {
        this.count = 0;
    }

    /**
     * Adds a new {@link DoubleLinkedListOld#head head} to the
     * {@link DoubleLinkedListOld List}. If the Node is null an
     * {@link InvalidElementException} is thrown.
     *
     * @param element the information to be stored.
     * @throws InvalidElementException if the parameter element is null.
     */
    public void addHead(T element) throws InvalidElementException {
        if (element == null) {
            throw new InvalidElementException("Can´t store null element");
        }
        DoubleLinkedNode newHead = new DoubleLinkedNode(element);

        if (this.count == 0) {
            this.head = newHead;
            this.tail = newHead;
        } else {
            this.head.setPrevious(newHead);
            newHead.setNext(this.head);
            this.head = newHead;
        }
        this.count++;
    }

    /**
     * Returns true if the {@link DoubleLinkedListOld list} is empty or false if it
     * is not.
     *
     * @return true if the {@link DoubleLinkedListOld list} is empty or false if it
     * is not.
     */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Adds a new Node to the {@link DoubleLinkedNode List}, that node contains
     * the information passed as an argument. If the Node is null an
     * {@link InvalidElementException} is thrown. If the
     * {@link DoubleLinkedNode List} is empty the Node becomes the
     * {@link DoubleLinkedListOld#head Head} and the
     * {@link DoubleLinkedListOld#tail Tail}.
     *
     * @param element the information to be stored.
     * @throws InvalidElementException if the parameter element is null.
     */
    public void add(T element) throws InvalidElementException {
        if (element == null) {
            throw new InvalidElementException("Can´t add \"null\" to a \"LinkedListSentinel\"");
        }
        this.addHead(element);
    }

    /**
     * Removes the {@link DoubleLinkedListOld#head} of the List making the second
     * element the new {@link DoubleLinkedListOld#head}. If the
     * {@link DoubleLinkedListOld list} is empty an {@link EmptyException} is
     * thrown. If the {@link DoubleLinkedListOld list} has one
     * {@link DoubleLinkedNode Node} both {@link DoubleLinkedListOld#head} and
     * {@link DoubleLinkedListOld#tail} are set to null.
     *
     * @throws exceptions.EmptyException if the
     * {@link DoubleLinkedNode List} is empty.
     */
    public void removeHead() throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("List is empty");
        }

        if (this.count == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.head.setPrevious(null);
        }
        this.count--;
    }

    /**
     * Removes the {@link DoubleLinkedListOld#tail} of the
     * {@link DoubleLinkedListOld list} making the penultimate element the new
     * {@link DoubleLinkedListOld#tail}. If the {@link DoubleLinkedListOld list} is
     * empty an {@link EmptyException} is thrown. If the
     * {@link DoubleLinkedListOld list} has one {@link DoubleLinkedNode Node} both
     * {@link DoubleLinkedListOld#head} and {@link DoubleLinkedListOld#tail} are set
     * to null.
     *
     * @throws exceptions.EmptyException if the
     * {@link DoubleLinkedNode List} is empty.
     */
    public void removeTail() throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("List is empty");
        }

        if (this.count == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.getPrevious();
            this.tail.setNext(null);
        }
        this.count--;
    }

    /**
     * Removes a {@link DoubleLinkedNode Node} that contains the element given
     * as parameter. If the {@link DoubleLinkedNode List} is empty an
     * {@link EmptyException} is thrown. If the
     * {@link DoubleLinkedNode Node} isn´t in the {@link DoubleLinkedNode List}
     * nothinh happens to the {@link DoubleLinkedNode List}.
     *
     * @param element the element to be removed from the.
     * {@link DoubleLinkedNode List}.
     * @throws EmptyException If the {@link DoubleLinkedNode List} is empty.
     */
    public void remove(T element) throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("The Sentinel List is empty");
        }
        DoubleLinkedNode<T> current = this.head.getNext();

        while (current.getNext() != this.tail) {
            if (current.getElement().equals(element)) {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                this.count--;
                return;
            }
            current = current.getNext();
        }

        if (this.head.getElement().equals(element)) {
            this.removeHead();
            return;
        }

        if (this.tail.getElement().equals(element)) {
            this.removeTail();
        }

    }

    /**
     * Removes all {@link DoubleLinkedNode Nodes} that contains the element
     * given as parameter. If the {@link DoubleLinkedNode List} is empty an
     * {@link EmptyException} is thrown.
     *
     * @param element the element to be removed from the
     * {@link DoubleLinkedNode List}.
     * @throws EmptyException If the {@link DoubleLinkedNode List} is empty.
     */
    public void removeAll(T element) throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("List is empty");
        }
        DoubleLinkedNode current = this.head.getNext();

        while (current.getNext() != this.tail) {
            if (current.getElement().equals(element)) {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                this.count--;
            }
            current = current.getNext();
        }

        if (this.head.getElement().equals(element)) {
            this.removeHead();
        }

        if (this.tail.getElement().equals(element)) {
            this.removeTail();
        }
    }

    /**
     * Returns an array with the specified start and end that represents the
     * list. Private method that is used in other methods.
     *
     * @param start the start index of the array.
     * @param end the end index of the array.
     * @return an array with the specified size that represents the list.
     */
    private Object[] toArraySize(int start, int end) {
        if(start > end){
            return null;
        }
        Object[] array = new Object[end - start];
        DoubleLinkedNode current = this.head;

        for (int i = 0; i < start; i++) {
            current = current.getNext();
        }

        for (int i = 0; i < end - start; i++) {
            array[i] = current.getElement();
            current = current.getNext();
        }

        return array;
    }

    /**
     * Returns an Array representation of the List. This array is compound by
     * objects. If the list is empty an {@link EmptyException} is thrown.
     *
     * @return an array representation of the list.
     * @throws EmptyException if the list is empty.
     */
    public Object[] toArray() throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("Empty list");
        }

        return this.toArraySize(0, this.count);
    }

    /**
     * Returns an Array representation of the List with a specified size.This
     * array is compound by objects. If the list is empty an
     * {@link EmptyException} is thrown.
     *
     * @param size the size of the array.
     * @return an array representation of the list.
     * @throws InvalidSizeException if the size is greater than the list size.
     */
    public Object[] toArray(int size) throws InvalidSizeException {
        if (this.count < size) {
            throw new InvalidSizeException("Size greater than number of list elements");
        }

        return toArraySize(0, size);
    }

    /**
     * Returns an Array representation of the list starting in a specified
     * position. If the start is greater than the number of elements in the list
     * an {@link InvalidSizeException} is thrown.
     *
     * @param start the start position of the list to copy into the array.
     * @return an array representation of the list.
     * @throws InvalidSizeException If start is greater than the number of elements.
     */
    public Object[] toArrayFrom(int start) throws InvalidSizeException {
        if (start > this.count) {
            throw new InvalidSizeException("Start index is greater than number of list elements");
        }

        return toArraySize(start, this.count);
    }

    /**
     * Returns an array representation of the list starting and ending at
     * specific positions. If the positions given are invalid an
     * {@link InvalidSizeException} is thrown.
     *
     * @param start the start position of the list to copy into the array.
     * @param end the end position of the list to copy into the array.
     * @return an array representation of the list.
     * @throws InvalidSizeException If the positions given are invalid.
     */
    public Object[] toArrayBetween(int start, int end) throws InvalidSizeException {
        if (start > end) {
            throw new InvalidSizeException("star greater than end");
        }
        if (start < 0 || end > this.count) {
            throw new InvalidSizeException("out of bounds start or end value");
        }

        return toArraySize(start, end);
    }

    /**
     * Returns all Pair elements in the list if the list is compound of Integer
     * elements, if not returns null.
     *
     * @return all Pair elements in the list.
     */
    public Integer[] getPairs() {
        if (!(this.head.getElement() instanceof Integer)) {
            return null;
        }
        int j = 0;
        DoubleLinkedNode current = this.head;
        Integer[] pairs = new Integer[this.count];

        for (int i = 0; i < this.count; i++) {
            if (((Integer) current.getElement() % 2 == 0)) {
                pairs[j] = (Integer) current.getElement();
                j++;
            }

            current = current.getNext();
        }
        Integer[] pairsFinal = new Integer[j];
        System.arraycopy(pairs, 0, pairsFinal, 0, j);

        return pairsFinal;
    }

    /**
     * Returns a String representation of the {@link DoubleLinkedNode}.
     *
     * @return a String representation of the {@link DoubleLinkedNode}.
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return null;
        }
        String s = "";
        DoubleLinkedNode<T> current = this.head;

        for (int i = 0; i < this.count; i++) {
            s += current.toString();
            current = current.getNext();
        }

        return s;
    }
}
