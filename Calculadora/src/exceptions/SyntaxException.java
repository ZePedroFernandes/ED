/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 * This Exception is thrown when the syntax of an expression is not correct.
 * 
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class SyntaxException extends Exception{

    /**
     * Constructs an instance of {@link SyntaxException}.
     */
    public SyntaxException(){
        super();
    }
    
    /**
     * Constructs an instance of {@link SyntaxException} with a message.
     *
     * @param message the message of the {@link SyntaxException}.
     */
    public SyntaxException(String message){
        super(message);
    }
}
