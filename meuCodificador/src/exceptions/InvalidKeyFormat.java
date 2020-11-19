package exceptions;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class InvalidKeyFormat extends Exception{

    /**
     * Constructs an Instance of {@link InvalidKeyFormat}.
     */
    public InvalidKeyFormat() {
        super();
    }

    /**
     * Constructs an Instance of {@link InvalidKeyFormat} with a message.
     * 
     * @param message the message of the exception.
     */
    public InvalidKeyFormat(String message) {
        super(message);
    }
}
