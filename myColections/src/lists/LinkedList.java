package lists;

import exceptions.InvalidElementException;
import exceptions.EmptyException;
import java.util.Iterator;
import nodes.LinkedNode;

/**
 * This class represents a LinkedList. This List is composed by
 * {@link LinkedNode linked Nodes}.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> The tipe of node to be created.
 */
public class LinkedList<T> {

    /**
     * List element counter.
     */
    private int count;

    /**
     * List's first Node.
     */
    public LinkedNode<T> head;

    /**
     * List's last Node.
     */
    public LinkedNode<T> tail;

    public LinkedList() {
        this.count = 0;
    }

    private class LinkedListIterator<T> implements Iterator<T> {

        private LinkedNode<T> cursor;

        public LinkedListIterator() {
            this.cursor = (LinkedNode<T>) head;
        }

        @Override
        public boolean hasNext() {
            if (this.cursor == null) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                T element = this.cursor.getElement();
                this.cursor = this.cursor.getNext();
                return element;
            }
            return null;
        }

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

    public Iterator<T> iterator() {
        return new LinkedListIterator<>();
    }

    public void invert() {
        this.invert(this.head, null);
    }

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
    
    public int size(){
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

}
