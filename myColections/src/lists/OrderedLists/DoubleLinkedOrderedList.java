package lists.OrderedLists;

import exceptions.InvalidElementException;
import nodes.DoubleLinkedNode;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> The type of the elements to be stored.
 */
public class DoubleLinkedOrderedList<T> extends DoubleLinkedList<T> {

    public DoubleLinkedOrderedList() {
        super();
    }

    public void add(T elem) throws InvalidElementException {

        if (elem == null) {
            throw new InvalidElementException("null element");
        }

        if (elem instanceof Comparable) {
            Comparable<T> element = (Comparable) elem;
            DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(elem);
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
                if (element.compareTo(current.getElement()) <= 0) {
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
