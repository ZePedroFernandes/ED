package trees;

import contracts.AvlBinarySearchTreeADT;
import exceptions.ElementNotFoundException;

/**
 * This class represents a Linked Avl binary search tree;
 * 
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class LinkedAVLBinarySearchTree<T> extends LinkedBinarySearchTree<T> implements AvlBinarySearchTreeADT<T> {

    @Override
    public void addElement(T element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void rightRotation(AvlTreeNode node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void leftRotation(AvlTreeNode node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
