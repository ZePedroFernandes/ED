package nodes;

import java.util.Objects;

/**
 * A class that represents a doubly linked Node. This Node has a next and a
 * previous Node.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> The type of Node's element
 */
public class DoubleLinkedNode<T> {

    /**
     * The Node's element.
     */
    private T element;

    /**
     * The Node's previous Node.
     */
    private DoubleLinkedNode<T> previous;

    /**
     * The Node's next Node.
     */
    private DoubleLinkedNode<T> next;

    /**
     * Constructs an instance of {@link DoubleLinkedNode}.
     */
    public DoubleLinkedNode() {
    }

    /**
     * Constructs an instance of {@link DoubleLinkedNode} with an element.
     *
     * @param element information to be stored in the node.
     */
    public DoubleLinkedNode(T element) {
        this.element = element;
    }

    /**
     * Gets the
     * {@link DoubleLinkedNode Node's} {@link DoubleLinkedNode#next next Node}.
     *
     * @return the
     * {@link DoubleLinkedNode Node's} {@link DoubleLinkedNode#next next Node}.
     */
    public DoubleLinkedNode<T> getNext() {
        return this.next;
    }

    /**
     * Gets the
     * {@link DoubleLinkedNode Node's} {@link DoubleLinkedNode#previous previous Node}.
     *
     * @return the
     * {@link DoubleLinkedNode Node's} {@link DoubleLinkedNode#previous previous Node}.
     */
    public DoubleLinkedNode<T> getPrevious() {
        return this.previous;
    }

    /**
     * Sets the
     * {@link DoubleLinkedNode Node's} {@link DoubleLinkedNode#next next Node}.
     *
     * @param next
     * {@link DoubleLinkedNode Node's} {@link DoubleLinkedNode#next next Node}.
     */
    public void setNext(DoubleLinkedNode<T> next) {
        this.next = next;
    }

    /**
     * Sets the
     * {@link DoubleLinkedNode Node's} {@link DoubleLinkedNode#previous previous Node}.
     *
     * @param previous
     * {@link DoubleLinkedNode Node's} {@link DoubleLinkedNode#previous previous Node}.
     */
    public void setPrevious(DoubleLinkedNode<T> previous) {
        this.previous = previous;
    }

    /**
     * Gets the {@link DoubleLinkedNode#element Node's element}.
     *
     * @return the {@link DoubleLinkedNode#element Node's element}.
     */
    public T getElement() {
        return this.element;
    }

    /**
     * Compares if two {@link DoubleLinkedNode} are equal.
     *
     * @param obj the Object to be compraed.
     * @return true if the the Objects are equal or false id they aren´t.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DoubleLinkedNode<?> other = (DoubleLinkedNode<?>) obj;
        if (!Objects.equals(this.element, other.element)) {
            return false;
        }
        return true;
    }

    /**
     * Returns a String representation of the {@link DoubleLinkedNode}.
     *
     * @return a String representation of the {@link DoubleLinkedNode}.
     */
    @Override
    public String toString() {
        return element.toString();
    }
}
