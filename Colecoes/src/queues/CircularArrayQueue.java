package queues;

import contracts.QueueContract;
import exceptions.EmptyException;
import exceptions.InvalidElementException;
import java.util.NoSuchElementException;

/**
 * Represents a queue implemented with a Circular Array.
 * 
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> Type of elements to be stored in the queue.
 */
public class CircularArrayQueue<T> implements QueueContract<T> {

    private T[] elements;

    private final int DEFAULT_CAPACITY = 10;

    private int count;

    private int front;

    private int rear;

    /**
     * Constructs an instance of {@link CircularArrayQueue} with the default capacity (10).
     */
    public CircularArrayQueue() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        this.count = 0;
        this.front = 0;
        this.rear = 0;
    }

    /**
     * Constructs an instance of {@link CircularArrayQueue} with a specific capacity.
     * 
     * @param capacity initial capacity of the {@link CircularArrayQueue queue}.
     */
    public CircularArrayQueue(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.count = 0;
        this.front = 0;
        this.rear = 0;
    }

    /**
     * Doubles the size of the array so more elements can fit.
     */
    private void doubleArraySize() {
        T[] oldElements = this.elements;
        this.elements = (T[]) (new Object[this.elements.length * 2]);

        for (int i = 0; i < oldElements.length; i++) {
            this.elements[i] = oldElements[(this.front + i) % oldElements.length];
        }

        this.front = 0;
        this.rear = this.count;
    }

    /**
     * Adds an element to the rear of the queue.
     *
     * @param element element to be added.
     */
    @Override
    public void enqueue(T element){
        if (element == null) {
            throw new NullPointerException("Invalid element");
        }

        if (this.count == this.elements.length) {
            this.doubleArraySize();
        }

        this.elements[this.rear] = element;
        this.rear = (this.rear + 1) % this.elements.length;
        this.count++;
    }

    /**
     * Removes an element from the front of the queue.
     *
     * @return the removed element.
     */
    @Override
    public T dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Empty queue");
        }

        T element = this.elements[this.front];
        this.elements[this.front] = null;
        this.front = (this.front + 1) % this.elements.length;
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
            throw new NoSuchElementException("Empty queue");
        }
        return this.elements[this.front];
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
        if (this.isEmpty()) {
            return "";
        }

        String queue = "";
        int pos = this.front;
        while (pos != ((this.rear - 1) + this.elements.length) % this.elements.length) {
            queue += this.elements[pos].toString();
            queue += "\n";
            pos = (pos + 1) % this.elements.length;
        }
        queue += this.elements[((this.rear - 1) + this.elements.length) % this.elements.length];

        return queue;
    }

}
