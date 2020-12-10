package queues;

import contracts.QueueContract;
import exceptions.EmptyException;
import exceptions.InvalidElementException;
import stacks.LinkedStack;

/**
 * This class repensents a queue that is implemented via 2 stacks. Whenever
 * there is the the need to add new elements to queue, the elements is added to
 * the input stack. In order to get this elements with the logic of a queue,
 * the elements in the input stack are transfered one by one to the output
 * stack, this way the order of the elements in the stack is inverted.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> Type of the elements to be stored.
 */
public class DoubleStackQueue<T> implements QueueContract<T> {

    /**
     * The {@link DoubleStackQueue} input stack.
     */
    private LinkedStack<T> stackInput;

    /**
     * The {@link DoubleStackQueue} output stack.
     */
    private LinkedStack<T> stackOutput;

    /**
     * Tells if some element was recently poped. This atribute is usefull to
     * manage boht stacks.
     */
    private boolean elementRecentlyPoped;

    /**
     * Tells the size of the queue.
     */
    private int size;

    /**
     * Construct's an instance of {@link DoubleStackQueue}.
     */
    public DoubleStackQueue() {
        this.stackInput = new LinkedStack<>();
        this.stackOutput = new LinkedStack<>();
        this.size = 0;
        this.elementRecentlyPoped = false;
    }

    /**
     * Adds an element to the queue. If the element is null an exception is
     * thrown.
     *
     * @param element the element to be added
     * @throws InvalidElementException if the element is null.
     */
    @Override
    public void enqueue(T element) throws InvalidElementException {
        if (element == null) {
            throw new InvalidElementException("Null element");
        }

        if (this.elementRecentlyPoped) {
            this.defineInputStack();
            this.elementRecentlyPoped = false;
        }
        this.stackInput.push(element);

        this.size++;
    }

    /**
     * Defines the input stack. pops everything out of the output stack and
     * pushes them to the input queue.The order that the elements will be poped
     * out of the input stack will be inverted when compared the the output
     * queue.
     */
    public void defineInputStack() {
        while (!this.stackOutput.isEmpty()) {
            this.stackInput.push(this.stackOutput.pop());
        }
    }

    /**
     * Defines the output stack. pops everything out of the input stack and
     * pushes them to the output queue.The order that the elements will be poped
     * out of the output stack will be inverted when compared the the input
     * queue. This gives this class the behavior of a queue.
     */
    public void defineOutputStack() {
        while (!this.stackInput.isEmpty()) {
            this.stackOutput.push(this.stackInput.pop());
        }
    }

    /**
     * Removes an element from the queue.
     *
     * @return the element removed.
     * @throws EmptyException if the queue is empty.
     */
    @Override
    public T dequeue() throws EmptyException {
        if (!this.elementRecentlyPoped) {
            this.defineOutputStack();
        }

        T popedElement = this.stackOutput.pop();
        this.size--;
        this.elementRecentlyPoped = true;

        return popedElement;
    }

    /**
     * Returns the next element to be dequeued but it does not remove it.
     *
     * @return the next element in the queue.
     * @throws EmptyException if the queue is empty.
     */
    @Override
    public T first() throws EmptyException {
        this.defineOutputStack();
        return stackOutput.peek();
    }

    /**
     * Returns true if the queue is empty otherwise returns false.
     *
     * @return true if the queue is empty or false if the queue is not empty.
     */
    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     * Returns the size of the queue.
     *
     * @return the size of the queue.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns a string representation of the queue.
     *
     * @return a string representation of the queue.
     */
    @Override
    public String toString() {
        this.defineOutputStack();
        return this.stackOutput.toString();
    }
}
