package exceptions;

/**
 * An exception that shall be throwed when a Element isn´t found.
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class ElementNotFoundException extends Exception {

    /**
     * Constructs an instance of {@link ElementNotFoundException}.
     */
    public ElementNotFoundException() {
    }

    /**
     * Constructs an instance of {@link ElementNotFoundException} with a
     * message.
     *
     * @param message the message of the {@link ElementNotFoundException}
     */
    public ElementNotFoundException(String message) {
        super(message);
    }

}
