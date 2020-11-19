package queues;

import contracts.QueueContract;
import exceptions.EmptyException;
import exceptions.InvalidElementException;
import nodes.LinkedNode;

/**
 * Represents a queue implemented using linked nodes.
 * 
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> Type of elements to be stored in the queue.
 */
public class LinkedQueue<T> implements QueueContract<T> {

    private LinkedNode<T> front;

    private LinkedNode<T> rear;

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
     * @throws InvalidElementException If the element is invalid
     */
    @Override
    public void enqueue(T element) throws InvalidElementException {
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
     * @throws exceptions.EmptyException if the queue is empty.
     */
    @Override
    public T dequeue() throws EmptyException {
        if (this.count == 0) {
            throw new EmptyException("Empty queue");
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
     * @throws exceptions.EmptyException if the queue is empty.
     */
    @Override
    public T first() throws EmptyException{
        if(this.isEmpty()){
            throw new EmptyException("Empty queue");
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
                queue += current.toString() + "\n";
                current = current.getNext();
            }
            queue += current.toString();
        }
        
        return queue;
    }
}
