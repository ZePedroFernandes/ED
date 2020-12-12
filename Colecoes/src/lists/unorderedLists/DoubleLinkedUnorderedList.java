package lists.unorderedLists;

import lists.DoubleLinkedList;
import contracts.UnorderedListContract;
import exceptions.ElementNotFoundException;
import nodes.DoubleLinkedNode;

/**
 * Represents a double linked list that is not ordered.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> The typ of the elements in the list.
 */
public class DoubleLinkedUnorderedList<T> extends DoubleLinkedList<T> implements UnorderedListContract<T> {

    /**
     * Construct's a {@link DoubleLinkedUnorderedList}.
     */
    public DoubleLinkedUnorderedList() {
        super();
    }

    /**
     * Adds an element to the front of the list.
     *
     * @param element element to be added
     */
    @Override
    public void addToFront(T element) {
        if (element == null) {
            return;
        }

        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(element);

        newNode.setPrevious(this.head);
        newNode.setNext(this.head.getNext());
        this.head.getNext().setPrevious(newNode);
        this.head.setNext(newNode);

        this.size++;

    }

    /**
     * Adds an element to the rear of the list.
     *
     * @param element element to be added
     */
    @Override
    public void addToRear(T element) {
        if (element == null) {
            return;
        }

        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(element);
        newNode.setNext(this.tail);
        newNode.setPrevious(this.tail.getPrevious());
        this.tail.getPrevious().setNext(newNode);
        this.tail.setPrevious(newNode);
        this.size++;
    }

    /**
     * Adds an element after a particular element in the list.
     *
     * @param element element to be added
     * @param target target element
     * @throws ElementNotFoundException if the target is not found
     */
    @Override
    public void addAfter(T element, T target) throws ElementNotFoundException {
        if (element == null && target == null) {
            return;
        }
        DoubleLinkedNode<T> current = this.head.getNext();

        while (current != this.tail && current.getElement() != target) {
            current = current.getNext();
        }

        if (current == this.tail) {
            throw new ElementNotFoundException("target element not found");
        }

        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(element);

        newNode.setNext(current.getNext());
        newNode.setPrevious(current);
        current.getNext().setPrevious(newNode);
        current.setNext(newNode);

        this.size++;
    }

}
