package queues;

import contracts.QueueContract;
import exceptions.InvalidElementException;
import java.util.NoSuchElementException;
import lists.LinkedNode;

/**
 * Represents a queue implemented using linked nodes.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> Type of elements to be stored in the queue.
 */
public class LinkedQueue<T> implements QueueContract<T> {

    /**
     * The queue's front node.
     */
    private LinkedNode<T> front;

    /**
     * The queue's rear node.
     */
    private LinkedNode<T> rear;

    /**
     * The queue's number of elements.
     */
    private int count;

    /**
     * Construct's an instance of {@link LinkedQueue}.
     */
    public LinkedQueue() {
        this.front = new LinkedNode<>();
        this.front.setNext(rear);
        this.rear = new LinkedNode<>();
        this.count = 0;
    }

    /**
     * Adds an element to the rear of the queue.
     *
     * @param element element to be added
     */
    @Override
    public void enqueue(T element) {
        if (element == null) {
            throw new InvalidElementException();
        }

        LinkedNode<T> newElement = new LinkedNode<>(element);
        if (this.count == 0) {
            this.front = newElement;
            this.rear = this.front;
        } else {
            this.rear.setNext(newElement);
            this.rear = newElement;
        }
        this.count++;
    }

    /**
     * Removes an element from the front of the queue.
     *
     * @return the removed element.
     */
    @Override
    public T dequeue() {
        if (this.count == 0) {
            throw new NoSuchElementException("Empty Queue");
        }

        T element = this.front.getElement();
        this.front = this.front.getNext();
        this.count--;

        return element;
    }

    /**
     * Examins the element at the front of the queue.
     *
     * @return the examined element.
     */
    @Override
    public T first() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }

        return this.front.getElement();
    }

    /**
     * Determines if the queue is empty.
     *
     * @return true if the queue is empty otherwise returns false.
     */
    @Override
    public boolean isEmpty() {
        return (this.count == 0);
    }

    /**
     * Determines the number of the elements in the queue.
     *
     * @return the number of elements in the queue.
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Returns a string representation of the queue.
     *
     * @return a string representation of the queue.
     */
    @Override
    public String toString() {
        String queue = "";
        LinkedNode<T> current = this.front;
        if (this.front != null) {
            while (current.getNext() != null) {
                if (current.getElement() == null) {
                    queue += "null\n";
                } else {
                    queue += current.toString() + "\n";
                }
                current = current.getNext();

            }
            if (current.getElement() == null) {
                queue += "null";
            } else {
                queue += current.toString();
            }
        }

        return queue;
    }
}
