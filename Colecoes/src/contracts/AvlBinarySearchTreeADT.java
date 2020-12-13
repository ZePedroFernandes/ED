package contracts;

import exceptions.ElementNotFoundException;
import trees.AVLNode;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public interface AvlBinarySearchTreeADT<T> extends BinarySearchTreeADT<T> {

    /**
     * Adds an element to the tree.
     * Alters the node balancing factor.
     * 
     * @param element element to be added to the tree.
     */
    @Override
    public void addElement(T element);

    /**
     * Removes an element from the tree.
     * Alters the nodes balancing factors.
     * 
     * @param targetElement element to be removed from the tree.
     */
    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException;
    
    /**
     * Rotates a subTree to the right
     * @param node root node of the subtree
     */
    public void rightRotation(AVLNode node);
    
    /**
     * Rotates a subTree to the left.
     * @param node root node of the subtree
     */
    public void leftRotation(AVLNode node);
    

}
