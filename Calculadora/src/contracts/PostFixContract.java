/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contracts;

import exceptions.OperationException;
import exceptions.SyntaxException;
import exceptions.EmptyException;

/**
 * This is a contract to create a post fix calculator.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public interface PostFixContract {

    /**
     * Checks if a String is well formated to be operated. If the string is well
     * formed returns true otherwise returns false.
     *
     * @param s String to check.
     * @return true if the String is well formed otherwise returns false.
     */
    public boolean isWellFormated(String s);

    /**
     * Returns a stack represenation of a String. this method should use
     * {@link isWellFormated(String s) isWellFormated method}.
     *
     * @param s String to be converted to stack.
     * @throws exceptions.SyntaxException if the String is not well formed.
     */
    public void stringToStack(String s) throws SyntaxException;

    /**
     * Gets the result of first operation second.
     *
     * @param first number to be operated.
     * @param second number to be operated.
     * @param operation operation to do.
     * @return the result of the calculation.
     * @throws exceptions.OperationException if there is an invalid Operation.
     */
    public float calculateResult(float first, float second, Character operation) throws OperationException;

    /**
     * Calculates final result of the string.
     *
     * @param s the String with the numbers and operations.
     * @return the final result.
     * @throws exceptions.SyntaxException if the string syntax is incorrect. 
     * @throws exceptions.EmptyException if the stack is empty.
     * @throws exceptions.OperationException if there is an invalid Operation.
     */
    public float calculateExpression(String s) throws SyntaxException, EmptyException, OperationException;

}
