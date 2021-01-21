package trees;

/**
 * Represenation of a AVL tree node
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T>
 */
public class AVLNode<T> extends BinaryTreeNode<T> {

    protected int balanceFactor;

    public AVLNode() {
        this.balanceFactor = 0;
    }

    public AVLNode(T element) {
        super(element);
        this.balanceFactor = 0;
    }

    protected boolean isUnbalanced() {
        return (this.balanceFactor <= -2 || this.balanceFactor >= 2);
    }

    protected boolean isBalanced() {
        return (this.balanceFactor >= -1 && this.balanceFactor <= 1);
    }

    protected boolean isLeftHeavy() {
        return (this.balanceFactor <= -2);
    }
    protected boolean isLeftRightHeavy() {
        return (((AVLNode<T>)this.left).balanceFactor >= 1);
    }
    protected boolean isRightLeftHeavy() {
        return (((AVLNode<T>)this.right).balanceFactor <= -1);
    }

    protected boolean isRightHeavy() {
        return (this.balanceFactor >= 2);
    }
}
