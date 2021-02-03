package exceptions;

/**
 *
 * @author Nome : José Pedro Fernandes 
Número: 8190239 
Turma: 1
 */
public class EmptyCollectionException extends RuntimeException{

    public EmptyCollectionException() {
    }

    public EmptyCollectionException(String message) {
        super(message);
    }

}
