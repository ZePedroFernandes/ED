/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 * This Exception is thrown when an unsupported operation is found.
 * 
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class OperationException extends Exception {
    
    /**
     * Constructs an instance of {@link OperationException}.
     */
    public OperationException(){
        super();
    }
    
    /**
     * Constructs an instance of {@link OperationException} with a message.
     *
     * @param message the message of the {@link OperationException}.
     */
    public OperationException(String message){
        super(message);
    }
}
