package trees;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> type of stored elements.
 */
public class BinaryTreeNode<T> {

    protected T element;

    protected BinaryTreeNode left, right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(T element) {
        this.element = element;
    }

    public BinaryTreeNode(T element, BinaryTreeNode left, BinaryTreeNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public int numChildren() {
        int children = 0;

        if (left != null) {
            children = 1 + left.numChildren();
        }

        if (right != null) {
            children = children + 1 + right.numChildren();
        }

        return children;
    }

    public T getElement() {
        return element;
    }

}
