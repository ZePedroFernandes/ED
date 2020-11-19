package exceptions;

/**
 * An exception that shall be throwed when a Invalid message is found.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class InvalidMessageException extends Exception {

    /**
     * Constructs an Instance of {@link InvalidMessageException}.
     */
    public InvalidMessageException(){
        super();
    }
    
    /**
     * Constructs an Instance of {@link InvalidMessageException} with a message.
     * 
     * @param message the message of the exception.
     */
    public InvalidMessageException(String message){
        super(message);
    }
}
