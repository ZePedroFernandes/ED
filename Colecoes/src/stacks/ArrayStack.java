package stacks;

import exceptions.InvalidElementException;
import exceptions.EmptyException;
import ADTs.StackADT;

/**
 * Represents a stack implemented via Array.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> Type of elements to be stored in the Stack
 */
public class ArrayStack<T> implements StackADT<T> {

    /**
     * Stack's default capacity.
     */
    private final int DEFAULT_CAPACITY = 100;

    /**
     * Stack's storage array.
     */
    private T[] storageArray;

    /**
     * Stack's next available position.
     */
    private int top;

    /**
     * Constructs an {@link ArrayStack} with the dafault capacity (100).
     */
    public ArrayStack() {
        this.top = 0;
        this.storageArray = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Constructs an {@link ArrayStack} with a specific capacity.
     * @param size capacity of the stack.
     */
    public ArrayStack(int size) {
        this.top = 0;
        this.storageArray = (T[]) (new Object[size]);
    }

    /**
     * Adds a element to the top of the stack. The element can´t be null, if
     * that happens and Exception is thrown, there can't be null elemets in the
     * stack.
     *
     * @param element to be added.
     * @throws exceptions.InvalidElementException if the element is null.
     */
    @Override
    public void push(T element) throws InvalidElementException {
        if (element == null) {
            throw new InvalidElementException("Null elements not supported");
        }
        if (this.top == this.storageArray.length) {
            this.expandSize();
        }

        this.storageArray[this.top] = element;
        this.top++;
    }

    /**
     * Expands the size of the {@link ArrayStack#storageArray stack's array}.
     */
    public void expandSize() {
        T[] array = this.storageArray;
        this.storageArray = (T[]) (new Object[this.storageArray.length * 2]);
        System.arraycopy(array, 0, this.storageArray, 0, array.length);
    }

    /**
     * Removes an element from the top of the stack. If the stack is empty an
     * {@link EmptyException} is thrown.
     *
     * @return the element from the top of the stack.
     * @throws EmptyException if the StackIs empty.
     */
    @Override
    public T pop() throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("Empty Stack");
        }
        T element = this.storageArray[this.top - 1];
        this.top--;
        this.storageArray[this.top] = null;

        return element;
    }

    /**
     * Returns the element in the top of the stack.
     * 
     * @return the element from the top of the stack.
     * @throws EmptyException if the stack is empty.
     */
    @Override
    public T peek() throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("Empty Stack");
        }
        
        return(this.storageArray[this.top-1]);
    }

    /**
     * Returns false if the stakc is not empty, otherwise returns true.
     * 
     * @return false if the stakc is not empty, otherwise returns true
     */
    @Override
    public boolean isEmpty() {
        return (this.top == 0);
    }

    /**
     * Returns the the number of elements in the stack.
     * 
     * @return the number of elements in the stack.
     */
    @Override
    public int size() {
        return (this.top);
    }

    /**
     * Returns a string representation of the stack.
     *
     * @return A string representation of the stack.
     */
    @Override
    public String toString() {
        if (this.top == 0) {
            return null;
        }
        String s = new String();

        for (int i = this.top - 1; i >= 0; i--) {
            s += "1: " + this.storageArray[i].toString() + "\n";
        }

        return s;
    }
}
