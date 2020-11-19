package main;

import calculator.Calculator;
import exceptions.*;
import java.util.EmptyStackException;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Calculator calculadora = new Calculator();
            
            String s = "2 3 * 4 1 / + ";
            String s1 = "1 2 / 3 * 9 +";
            
            Double i = calculadora.calcutate(s);
            System.out.println(i);
        } catch (InvalidElementException | OperationException | SyntaxException | EmptyStackException ex){
            System.out.println(ex.getMessage());
        }
    }

}
