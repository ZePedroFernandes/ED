package lists;

import java.util.Objects;

/**
 * This class represents a node that will be used to form a LinkedList. It's has
 * an element and a reference to the next node.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> the type of elements held in this collection
 */
public class LinkedNode<T> {

    /**
     * Node Element.
     */
    protected T element;

    /**
     * Node's Next Node.
     */
    private LinkedNode<T> next;

    /**
     * Constructs an empty Node.
     */
    public LinkedNode() {
    }

    /**
     * Constructs an Node with one element passed as an parameter.
     *
     * @param element the element to be added.
     */
    public LinkedNode(T element) {
        this.element = element;
    }

    /**
     * Gets the {@link LinkedNode#next next Node}.
     *
     * @return The {@link LinkedNode#next next Node}
     */
    public LinkedNode<T> getNext() {
        return this.next;
    }

    /**
     * Sets the {@link LinkedNode#next next Node}.
     *
     * @param next The {@link LinkedNode#next next Node}
     */
    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    /**
     * Gets the {@link LinkedNode#element Node's element}.
     *
     * @return the {@link LinkedNode#element Node's element}
     */
    public T getElement() {
        return this.element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Compares if two Nodes are equal.
     *
     * @param obj the Object to be compraed
     * @return true if the the Objects are equal or false id they aren´t
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
        final LinkedNode<?> other = (LinkedNode<?>) obj;
        if (!Objects.equals(this.element, other.element)) {
            return false;
        }
        return true;
    }

    /**
     * Returns a String representation of the {@link LinkedNode}.
     *
     * @return a String representation of the {@link LinkedNode}
     */
    @Override
    public String toString() {
        return this.element.toString();
    }

}
