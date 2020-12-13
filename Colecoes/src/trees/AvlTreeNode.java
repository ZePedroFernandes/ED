package trees;

/**
 * Represenation of a AVL tree node
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T>
 */
public class AvlTreeNode<T> extends BinaryTreeNode<T> {

    protected int balanceFactor;

    public AvlTreeNode() {
        balanceFactor = 0;
    }

    public AvlTreeNode(T element) {
        super(element);
        balanceFactor = 0;
    }

}
