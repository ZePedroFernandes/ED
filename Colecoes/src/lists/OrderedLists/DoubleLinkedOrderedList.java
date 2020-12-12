package lists.OrderedLists;

import lists.DoubleLinkedList;
import exceptions.InvalidElementException;
import nodes.DoubleLinkedNode;

/**
 * Represents an ordered Double Linked List
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> The type of the elements to be stored.
 */
public class DoubleLinkedOrderedList<T> extends DoubleLinkedList<T> {

    /**
     * Construct's an instance of {@link DoubleLinkedOrderedList}.
     */
    public DoubleLinkedOrderedList() {
        super();
    }

    /**
     * Adds an element to the {@link ArrayOrderedList} in the correct position.
     *
     * @param element the element to be added.
     * @throws InvalidElementException if the element is invalid.
     */
    public void add(T element) throws InvalidElementException {

        if (element == null) {
            throw new InvalidElementException("null element");
        }

        if (element instanceof Comparable) {
            Comparable<T> comparableElem = (Comparable) element;
            DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(element);
            if (this.isEmpty()) {
                this.head.setNext(newNode);
                this.tail.setPrevious(newNode);
                newNode.setPrevious(this.head);
                newNode.setNext(this.tail);
                this.size++;
                this.modCount++;
                return;
            }

            DoubleLinkedNode<T> current = this.head.getNext();

            while (current.getElement() != null) {
                if (comparableElem.compareTo(current.getElement()) <= 0) {
                    current.getPrevious().setNext(newNode);
                    newNode.setPrevious(current.getPrevious());
                    current.setPrevious(newNode);
                    newNode.setNext(current);
                    this.size++;
                    this.modCount++;
                    return;
                }
                current = current.getNext();
            }
            this.tail.getPrevious().setNext(newNode);
            newNode.setPrevious(this.tail.getPrevious());
            newNode.setNext(this.tail);
            this.tail.setPrevious(newNode);
            this.modCount++;
            this.size++;
        }
    }

    /**
     * Returns an inverted string representation of the
     * {@link DoubleLinkedOrderedList}.
     *
     * @return an inverted string representation of the
     * {@link DoubleLinkedOrderedList}
     */
    public String getInvertedList() {
        if (this.isEmpty()) {
            return null;
        }
        DoubleLinkedNode<T> current = this.tail.getPrevious();

        String result = "";
        while (current != this.head) {
            result += current.getElement().toString() + "\n";
            current = current.getPrevious();
        }
        return result.substring(0, result.length() - 1);
    }
}
