package lists;

import exceptions.InvalidElementException;
import exceptions.EmptyException;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents a LinkedList. This List is composed by
 * {@link LinkedNode linked Nodes}.
 *
 * @param <T> The tipe of node to be created.
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class LinkedList<T> {

    /**
     * List's first Node.
     */
    protected LinkedNode<T> head;
    /**
     * List's last Node.
     */
    protected LinkedNode<T> tail;
    /**
     * List element counter.
     */
    protected int count;

    /**
     * Construct's an instance of {@link LinkedList}
     */
    public LinkedList() {
        this.count = 0;
    }

    public LinkedList(T element) {
        LinkedNode<T> node = new LinkedNode<>(element);
        this.head = node;
        this.tail = node;
        this.count = 1;
    }

    /**
     * Adds elements to the {@link LinkedList List}. If element is null an
     * {@link InvalidElementException} is thrown. The new element becomes the
     * {@link LinkedList#head List's Head}.
     *
     * @param element the element to be added to the {@link LinkedList List}.
     * @throws InvalidElementException if the element parameter is null.
     */
    public void add(T element) throws InvalidElementException {
        if (element == null) {
            throw new InvalidElementException("Can´t add \"null\" to a \"LinkedList\"");
        }
        LinkedNode<T> newNode = new LinkedNode<>(element);//Node to be inserted in the List

        if (this.count == 0) {  // The new Node becomes the head and the tail
            this.head = newNode;
            this.tail = newNode;
        } else {                //The new Node becomes he head
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.count++;
    }

    /**
     * Removes an element from the {@link LinkedList}, it will remove the first
     * element that is encountered. If the {@link LinkedList list} is empty an
     * {@link EmptyException} is thrown. If the {@link LinkedNode node} isn't in
     * the {@link LinkedList list} nothing happens to the list.
     *
     * @param element the element to be removed.
     * @throws EmptyException if the {@link LinkedList list} is empty.
     */
    public void remove(T element) throws EmptyException {
        if (this.count == 0) {
            throw new EmptyException("The list is empty");
        }

        if (this.count == 1 && this.head.getElement().equals(element)) {// Removing the one element in the list
            this.head = null;
            this.tail = null;
            this.count--;
        } else {
            LinkedNode<T> current = this.head;

            if (this.head.getElement().equals(element)) {
                this.head = this.head.getNext();
                return;
            }

            while (current.getNext() != null) {
                if (current.getNext().getElement().equals(element)) {
                    current.setNext(current.getNext().getNext());
                    this.count--;
                    return;
                }
                current = current.getNext();
            }
        }
    }

    /**
     * Returns an iterator of the {@link LinkedList}.
     *
     * @return an iterator of the {@link LinkedList}
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator<>();
    }

    /**
     * Inverts the list.
     */
    public void invert() {
        this.invert(this.head, null);
    }

    /**
     * Recursively inverts the list.
     *
     * @param current  the current node
     * @param previous the previous node
     */
    private void invert(LinkedNode<T> current, LinkedNode<T> previous) {

        if (current == this.tail) {
            current.setNext(previous);
        } else {
            LinkedNode tmp = current.getNext();
            current.setNext(previous);
            this.head = tmp;
            invert(tmp, current);
        }
    }

    /**
     * Returns the size of the {@link LinkedList}.
     *
     * @return the size of the {@link LinkedList}
     */
    public int size() {
        return this.count;
    }

    /**
     * Returns a string representation of the {@link LinkedList}.
     *
     * @return a string representation of the {@link LinkedList}.
     */
    @Override
    public String toString() {
        if (this.count == 0) {
            return null;
        }
        String s = "";
        LinkedNode current = this.head;

        while (current != null) {
            s += current.toString();
            current = current.getNext();
        }

        return s;
    }

    /**
     * Provides an itrator the the {@link LinkedList}.
     *
     * @param <T> the type of elements present in the {@link LinkedList}
     */
    private class LinkedListIterator<T> implements Iterator<T> {

        /**
         * The iterator's cursor.
         */
        private LinkedNode<T> cursor;

        /**
         * Creates an instance of {@link LinkedListIterator}
         */
        public LinkedListIterator() {
            this.cursor = (LinkedNode<T>) head;
        }

        /**
         * Checks if there is a next element.
         *
         * @return true if there is a next element, else false
         */
        @Override
        public boolean hasNext() {
            return (this.cursor != null);
        }

        /**
         * Returns the next element in the {@link LinkedList}.
         *
         * @return the next element in the {@link LinkedList}
         */
        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            T element = this.cursor.getElement();
            this.cursor = this.cursor.getNext();
            return element;
        }

    }

}
