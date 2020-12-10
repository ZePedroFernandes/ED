package exceptions;

/**
 * An exception that shall be throwed when a Node is invalid.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class InvalidElementException extends RuntimeException {

    /**
     * Constructs an instance of {@link InvalidElementException}.
     */
    public InvalidElementException() {
    }

    /**
     * Constructs an instance of {@link InvalidElementException} with a message.
     *
     * @param message the message of the {@link InvalidElementException}.
     */
    public InvalidElementException(String message) {
        super(message);
    }
}
