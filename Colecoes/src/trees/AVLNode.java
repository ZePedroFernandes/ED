package trees;

/**
 * Represenation of a AVL tree node
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T>
 */
public class AVLNode<T> {

    protected int balanceFactor;
    
    protected T element;
    
    protected AVLNode<T> left,right;

    public AVLNode() {
        this.balanceFactor = 0;
    }

    public AVLNode(T element) {
        this.element = element;
        this.balanceFactor = 0;
    }
    
    public T getElement() {
        return element;
    }

}
