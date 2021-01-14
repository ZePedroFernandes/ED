package stacks;

import exceptions.EmptyException;
import ADTs.StackADT;
import exceptions.InvalidElementException;
import lists.LinkedNode;

/**
 * Represents a Linked Stack.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> Type of the elements to store in the stack.
 */
public class LinkedStack<T> implements StackADT<T> {

    /**
     * Stack's top element.
     */
    private LinkedNode<T> top;

    /**
     * Stack's number of elements.
     */
    private int count;

    /**
     * Constructs a {@link LinkedStack}.
     */
    public LinkedStack() {
        this.top = new LinkedNode<>();
        this.count = 0;
    }

    /**
     * Adds a element to the top of the stack.The element can´t be null, if that
     * happens and Exception is thrown, there can't be null elemets in the
     * stack.
     *
     * @param element to be added.
     */
    @Override
    public void push(T element) {
        if (element == null) {
            throw new InvalidElementException("null elements are invalid");
        }
        LinkedNode<T> newHead = new LinkedNode<>(element);
        if (this.count == 0) {
            this.top.setNext(newHead);
        } else {
            newHead.setNext(this.top.getNext());
            this.top.setNext(newHead);
        }
        this.count++;
    }

    /**
     * Removes an element from the top of the stack. If the stack is empty an
     * {@link EmptyException} is thrown.
     *
     * @return the element from the top of the stack
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        LinkedNode<T> popNode = this.top.getNext();
        this.top.setNext(popNode.getNext());
        this.count--;

        return popNode.getElement();
    }

    /**
     * Returns the element in the top of the stack.
     *
     * @return the element from the top of the stack
     * @throws EmptyException if the stack is empty
     */
    @Override
    public T peek(){
        if (isEmpty()) {
            return null;
        }
        return (this.top.getNext().getElement());
    }

    /**
     * Returns false if the stack is not empty, otherwise returns true.
     *
     * @return false if the stack is not empty, otherwise returns true
     */
    @Override
    public boolean isEmpty() {
        return (this.count == 0);
    }

    /**
     * Returns the size of the stack.
     *
     * @return the size of the stack
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Returns a string representation of the stack.
     *
     * @return a string representation of the stack
     */
    @Override
    public String toString() {
        if (this.count == 0) {
            return null;
        }

        String s = new String();
        LinkedNode<T> current = this.top;

        while (current.getNext() != null) {
            current = current.getNext();
            s += current.getElement().toString() + "\n";
        }

        return s.substring(0, s.length() - 1);
    }
}
