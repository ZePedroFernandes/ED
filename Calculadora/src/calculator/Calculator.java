/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import exceptions.InvalidElementException;
import exceptions.OperationException;
import exceptions.SyntaxException;
import stacks.LinkedStack;
import java.util.EmptyStackException;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Calculator {

    /**
     * {@link Calculator Calculator's} stack and numbers are stored.
     */
    public LinkedStack<Double> stack;

    /**
     * Constructs an Instance of {@link Calculator}.
     */
    public Calculator() {
        this.stack = new LinkedStack();
    }

    public boolean isWellFormated(String operation) {
        int numbers = 0;
        int operations = 0;
        String current = "";

        for (int i = 0; i < operation.length(); i++) {
            current = "";
            while (i != operation.length() && operation.charAt(i) != ' ') {
                current += operation.charAt(i);
                i++;
            }
            if (current.matches("[+\\-*/]")) {
                operations++;

            } else {

                try {
                    Double.parseDouble(current);
                    numbers++;
                } catch (NumberFormatException EX) {
                    return false;
                }
            }
        }
        if (numbers == operations + 1) {
            return true;
        } else {
            return false;
        }
    }

    public double calculateResult(double second, double first, Character operation) throws OperationException {
        switch (operation) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '/':
                return first / second;
            case '*':
                return first * second;
            default:
                throw new OperationException("Operação não suportada");
        }
    }

    public double calcutate(String operation) throws SyntaxException, EmptyStackException, InvalidElementException, OperationException {
        while (operation.endsWith(" ")) {
            operation = operation.substring(0, operation.length() - 1);
        }

        while (operation.startsWith(" ")) {
            operation = operation.substring(1, operation.length());
        }

        if (!this.isWellFormated(operation)) {
            throw new SyntaxException("Invalid syntax");
        }

        double result = 0;
        String current = "";

        for (int i = 0; i < operation.length(); i++) {
            current = "";

            while (operation.length() > i && operation.charAt(i) != ' ') {
                current += operation.charAt(i);
                i++;
            }

            if (!current.matches("[+\\-*/]")) {
                this.stack.push(Double.parseDouble(current));
            } else {
                result = this.calculateResult(this.stack.pop(), this.stack.pop(), current.charAt(0));
                this.stack.push(result);
            }
        }
        return this.stack.pop();
    }
}
