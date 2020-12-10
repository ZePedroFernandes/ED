package lists;

import contracts.ListADT;
import exceptions.EmptyException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import nodes.DoubleLinkedNode;

/**
 * Sentinel Double Linked List.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T>
 */
public abstract class DoubleLinkedList<T> implements ListADT<T>, Iterable<T> {

    protected DoubleLinkedNode<T> head; //Sentinel Node

    protected DoubleLinkedNode<T> tail; //Sentinel Node

    protected int size;

    private final int ELEMENT_NOT_FOUND = -1;

    protected int modCount;

    public DoubleLinkedList() {
        this.head = new DoubleLinkedNode<>();
        this.tail = new DoubleLinkedNode<>();
        this.head.setNext(this.tail);
        this.tail.setPrevious(this.head);
        this.size = 0;
        this.modCount = 0;
    }

    private class DoubleLinkedListIterator<T> implements Iterator<T> {

        private DoubleLinkedNode<T> cursor;

        private final int excpectedModCount;

        public DoubleLinkedListIterator(int modCount) {
            this.excpectedModCount = modCount;
            cursor = (DoubleLinkedNode<T>) head.getNext();
        }

        @Override
        public boolean hasNext() {
            if (this.excpectedModCount != modCount) {
                throw new ConcurrentModificationException("A lista foi alterada");
            }

            return (cursor != tail);
        }

        @Override
        public T next() {
            T element = null;
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            element = cursor.getElement();
            cursor = cursor.getNext();
            return element;
        }
    }

    @Override
    public T removeFirst() throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("Empty List");
        }
        T removedElement = this.head.getNext().getElement();
        this.head.setNext(this.head.getNext().getNext());
        this.head.getNext().setPrevious(this.head);
        this.size--;
        this.modCount++;
        return removedElement;
    }

    @Override
    public T removeLast() throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("Empty List");
        }
        T removedElement = this.tail.getPrevious().getElement();

        this.tail.setPrevious(this.tail.getPrevious().getPrevious());
        this.tail.getPrevious().setNext(this.tail);
        this.size--;
        this.modCount++;
        return removedElement;
    }

    @Override
    public T remove(T element) throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("Empty List");
        }
        DoubleLinkedNode<T> targetNode = this.find(element);

        if (targetNode == null) {
            return null;
        }

        targetNode.getPrevious().setNext(targetNode.getNext());
        targetNode.getNext().setPrevious(targetNode.getPrevious());
        this.size--;
        this.modCount++;

        return element;
    }

    @Override
    public T first() {
        return this.head.getElement();
    }

    @Override
    public T last() {
        return this.tail.getElement();
    }

    @Override
    public boolean contains(T target) {
        return (this.find(target) != null);
    }

    private DoubleLinkedNode<T> find(T target) {
        DoubleLinkedNode<T> current = this.head.getNext();
        DoubleLinkedNode<T> targetNode = null;
        boolean found = false;

        while (current != this.tail && !found) {
            if (current.getElement() == target) {
                found = true;
            } else {
                current = current.getNext();
            }
        }
        if (found) {
            targetNode = current;
        }
        return targetNode;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return (new DoubleLinkedListIterator<>(this.modCount));
    }

    public T[] getInverted() {
        T[] array = (T[]) new Object[this.size];
        this.invert(array, this.head.getNext(), this.size);
        return array;
    }

    private T invert(T[] array, DoubleLinkedNode<T> node, int size) {
        if (node == this.tail.getPrevious()) {
            array[size - 1] = node.getElement();
            return node.getPrevious().getElement();
        } else {
            array[size - 1] = invert(array, node.getNext(), size - 1);
            return node.getPrevious().getElement();
        }
    }

    /**
     * Returns a String representation of the {@link DoubleLinkedNode}.
     *
     * @return a String representation of the {@link DoubleLinkedNode}.
     */
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return null;
        }
        String result = "";
        DoubleLinkedNode<T> current = this.head.getNext();

        while (current != this.tail) {
            result += current.getElement().toString() + "\n";
            current = current.getNext();
        }

        return result.substring(0, result.length() - 1);
    }
}
