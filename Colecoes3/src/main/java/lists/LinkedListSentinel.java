package lists;

import exceptions.EmptyException;
import exceptions.InvalidElementException;

/**
 * This class represents a Sentinel Linked List where the head and the tail are
 * only references and do not contain usefull stored information.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> The type of the list's elements.
 */
public class LinkedListSentinel<T> {

    /**
     * Number of {@link LinkedNode Nodes} in the
     * {@link LinkedListSentinel List}.
     */
    private int count;

    /**
     * {@link LinkedListSentinel List's} {@link LinkedListSentinel#head head Node}.
     */
    private final LinkedNode head;

    /**
     * {@link LinkedListSentinel List's} {@link LinkedListSentinel#tail tail Node}.
     */
    private final LinkedNode tail;

    /**
     * Constructs an instance of {@link LinkedListSentinel}.
     */
    public LinkedListSentinel() {
        this.count = 0;
        this.head = new LinkedNode();
        this.tail = new LinkedNode();
        this.head.setNext(this.tail); //Head and tail are linked
    }

    /**
     * Adds a Node with the information contained in the parameter to the @link
     * LinkedListSentinel}. If the parameter is null an
     * {@link InvalidElementException} is thrown.
     *
     * @param element element to be added.
     * @throws exceptions.InvalidElementException if the parameter is null.
     */
    public void add(T element) throws InvalidElementException {
        if (element == null) {
            throw new InvalidElementException("Can´t store null elements");
        }

        LinkedNode newNode = new LinkedNode(element);
        newNode.setNext(this.head.getNext());
        this.head.setNext(newNode);
        this.count++;
    }

    /**
     * Removes a {@link LinkedNode ndoe} with the information contained in the
     * parameter. It only removes the first node that matches the desired
     * element. If the {@link LinkedListSentinel List} is empty an
     * {@link EmptyException} is thrown.
     *
     * @param element The element to be removed.
     * @throws exceptions.EmptyException if the List is Empty;
     */
    public void remove(T element) throws EmptyException {
        if (this.count == 0) {
            throw new EmptyException("Can´t remove elemts from an empty list");
        }
        LinkedNode current = this.head;

        while (current.getNext() != null) {
            if (current.getNext().getElement().equals(element)) {
                current.setNext(current.getNext().getNext());
                this.count--;
                return;
            }
            current = current.getNext();
        }
    }

    public void replace(T existingElement, T newElement) {
        replaceRecursive(existingElement, newElement, this.head.getNext(), this.head);
    }

    private void replaceRecursive(T element, T replaceElement, LinkedNode<T> current, LinkedNode<T> previous) {
        if (current.getElement().equals(element)) {
            LinkedNode<T> newNode = new LinkedNode<>(replaceElement);
            newNode.setNext(current.getNext());
            previous.setNext(newNode);
            current = newNode;
        }
        if (current.getNext() == this.tail) {
        } else {
            replaceRecursive(element, replaceElement, current.getNext(), current);
        }
    }

    /**
     * Returns a string representation of the {@link LinkedListSentinel}.
     *
     * @return a string representation of the {@link LinkedListSentinel}
     */
    @Override
    public String toString() {
        if (this.count == 0) {
            return null;
        }

        String s = "";
        LinkedNode current = this.head.getNext();

        for (int i = 0; i < this.count; i++) {
            s += current.toString();
            current = current.getNext();
        }

        return s;
    }

}
