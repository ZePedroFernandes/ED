package calculator;

import exceptions.InvalidElementException;
import exceptions.EmptyException;
import contracts.PostFixContract;
import exceptions.OperationException;
import exceptions.SyntaxException;
import stacks.ArrayStack;

/**
 * Represents a postfix calculator.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class CalculatorSimple implements PostFixContract {

    /**
     * {@link CalculatorSimple CalculatorSimple's} stack where operations and numbers ate
     * stored.
     */
    public ArrayStack stack;

    /**
     * Constructs an Instance of {@link exceptions}.
     */
    public CalculatorSimple() {
        this.stack = new ArrayStack();
    }

    /**
     * Checks if a String is well formated to be operated. If the string is well
     * formed returns true otherwise returns false.
     *
     * @param s String to check.
     * @return true if the String is well formed otherwise returns false.
     */
    @Override
    public boolean isWellFormated(String s) {
        if (s.isEmpty()) {
            return false;
        }

        return s.matches("[0-9]*( [0-9]* [+\\-*/])*");
    }

    /**
     * Returns a stack represenation of a String. this method should use
     * {@link isWellFormated(String s) isWellFormated method}. Each caracter in
     * the String is an element of the stack.
     *
     * @param s String to be passed to the stack.
     * @throws exceptions.SyntaxException if the String is not well formed.
     */
    @Override
    public void stringToStack(String s) throws SyntaxException {
        if (!this.isWellFormated(s)) {
            throw new SyntaxException();
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            try {
                this.stack.push(s.charAt(i));
            } catch (InvalidElementException ex) {
                return;
            }
        }

    }

    /**
     * Gets the result of an operation between 2 elements. The supported
     * operations are '+' '-' '*' '/'.
     *
     * @param first number to be operated.
     * @param second number to be operated.
     * @param operation operation to do.
     * @return the the calculation.
     * @throws exceptions.OperationException if there is an invalid Operation.
     */
    @Override
    public float calculateResult(float first, float second, Character operation) throws OperationException {
        switch (operation) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
            default:
                throw new OperationException("Operation not supported");
        }
    }

    /**
     * Returns the next number in the stack and skips the next position in the
     * stack. It only skips the next position beacuse the Object in the Stack
     * does not represent a number, it represents a blank space ' ', this space
     * is not a necessary component to the calculation.
     *
     * @return the number read.
     * @throws EmptyException if the stack is empty.
     */
    private float popNumber() throws EmptyException {
        String Number = new String();
        for (int i = 0; !this.stack.peek().equals(' '); i++) {
            Number += (Character) this.stack.pop();
        }
        this.stack.pop();
        return (float) Float.parseFloat(Number);
    }

    /**
     * Calculates final result of an expression passed as an argument. This
     * string argument must be well formed, it has to follow the post fixed
     * calculation method, Ex: ("1 3 + 6 * 9 /").
     *
     * @param s the String with the expression to be calculated.
     * @return the final result of the expression passed as argument.
     * @throws exceptions.SyntaxException if the string syntax is incorrect.
     * @throws exceptions.EmptyException id the stack is empty.
     * @throws exceptions.OperationException if there is an invalid Operation.
     */
    @Override
    public float calculateExpression(String s) throws SyntaxException, EmptyException, OperationException {
        this.stringToStack(s);
        float result = this.popNumber();
        float secondNumber = this.popNumber();
        Character operation = (Character) this.stack.pop();

        while (!this.stack.isEmpty()) {
            this.stack.pop();
            result = this.calculateResult(result, secondNumber, operation);
            secondNumber = this.popNumber();
            operation = (Character) this.stack.pop();
        }
        return this.calculateResult(result, secondNumber, operation);
    }

}
