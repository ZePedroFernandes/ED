package exceptions;

/**
 * An exception that shall be throwed when a size is invalid.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class InvalidSizeException extends Exception {

    /**
     * Constructs an instance of {@link InvalidSizeException}.
     */
    public InvalidSizeException() {
    }

    /**
     * Constructs an instance of {@link InvalidSizeException} with a message.
     *
     * @param message the message of the {@link InvalidSizeException}.
     */
    public InvalidSizeException(String message) {
        super(message);
    }
}
