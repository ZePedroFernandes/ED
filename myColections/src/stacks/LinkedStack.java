package stacks;

import exceptions.EmptyException;
import contracts.StackADT;
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
    public void push(T element){
        if (element == null) {
            return;
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

    @Override
    public T pop(){
        if (isEmpty()) {
            return null;
        }
        LinkedNode<T> popNode = this.top.getNext();
        this.top.setNext(popNode.getNext());
        this.count--;

        return popNode.getElement();
    }

    @Override
    public T peek() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("Empty Stack");
        }
        return (this.top.getNext().getElement());
    }

    @Override
    public boolean isEmpty() {
        return (this.count == 0);
    }

    @Override
    public int size() {
        return this.count;
    }

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
