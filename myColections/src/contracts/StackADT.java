package contracts;

import exceptions.EmptyException;
import exceptions.InvalidElementException;

/**
 * Contract to create a Stack.
 * 
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> Type of elements in the Stack.
 */
public interface StackADT<T> {

    /**
     * Adds a element to the top of the stack.The element can´t be null, if that
     * happens and Exception is thrown, there can't be null elemets in the stack.
     *
     * @param element to be added
     * @throws exceptions.InvalidElementException if the element is null.
     */
    public void push(T element) throws InvalidElementException;
    
    /**
     * Removes an element from the top of the stack.
     * If the stack is empty an {@link EmptyException} is thrown.
     * 
     * @return the element from the top of the stack.
     * @throws EmptyException if the StackIs empty.
     */
    public T pop() throws EmptyException;
    
    /**
     * Returns the element in the top of the stack.
     * 
     * @return the element from the top of the stack.
     * @throws EmptyException if the stack is empty.
     */
    public T peek() throws EmptyException;
    
    /**
     * Returns false if the stakc is not empty, otherwise returns true.
     * 
     * @return false if the stakc is not empty, otherwise returns true
     */
    public boolean isEmpty();
    
    /**
     * Returns the size of the stack.
     * 
     * @return The size of the stack.
     */
    public int size();
    
    /**
     * Returns a string representation of the stack.
     * 
     * @return A string representation of the stack.
     */
    @Override
    public String toString();
}
