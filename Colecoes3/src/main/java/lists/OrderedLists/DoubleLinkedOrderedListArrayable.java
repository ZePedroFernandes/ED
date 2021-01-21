package lists.OrderedLists;

import nodes.DoubleLinkedNode;

/**
 * This class has the possibility to get an array representation of itself.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class DoubleLinkedOrderedListArrayable<T> extends DoubleLinkedOrderedList<T> {

    /**
     * Construct's a {@link DoubleLinkedOrderedListArrayable}
     */
    public DoubleLinkedOrderedListArrayable() {
        super();
    }

    /**
     * Returns an array representation of the
     * {@link DoubleLinkedOrderedListArrayable list}.
     *
     * @return an array representation of the
     * {@link DoubleLinkedOrderedListArrayable list}
     */
    public T[] toArray() {
        T[] result = (T[]) new Object[this.size];

        DoubleLinkedNode<T> current = this.head.getNext();

        for (int i = 0; i < this.size; i++) {
            result[i] = current.getElement();
            current = current.getNext();
        }
        return result;
    }

}
