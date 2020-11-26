package exceptions;

/**
 * An exception that shall be throwed when a List is empty.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class EmptyException extends Exception {

    /**
     * Constructs an instance of {@link EmptyException}.
     */
    public EmptyException() {
    }

    /**
     * Constructs an instance of {@link EmptyException} with a message.
     *
     * @param message the message of the {@link EmptyException}.
     */
    public EmptyException(String message) {
        super(message);
    }

}
