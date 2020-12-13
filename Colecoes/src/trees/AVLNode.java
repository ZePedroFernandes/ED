package trees;

/**
 * Represenation of a AVL tree node
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T>
 */
public class AVLNode<T> extends BinaryTreeNode<T>{

    protected int balanceFactor;
        
    public AVLNode() {
        this.balanceFactor = 0;
    }

    public AVLNode(T element) {
        super(element);
        this.balanceFactor = 0;
    }
    

}
