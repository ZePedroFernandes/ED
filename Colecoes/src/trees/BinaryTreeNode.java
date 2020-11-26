/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> type of stored elements.
 */
public class BinaryTreeNode<T> {

    protected T element;

    protected BinaryTreeNode left, right;

    public BinaryTreeNode(T element){
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

    public BinaryTreeNode getLeft() {
        return left;
    }

    protected BinaryTreeNode getRight() {
        return right;
    }

    protected void setElement(T element) {
        this.element = element;
    }

    protected void setLeft(BinaryTreeNode left) {
        this.left = left;
    }
    
    
}
