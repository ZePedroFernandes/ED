package trees;

import contracts.BinarySearchTreeADT;
import exceptions.ElementNotFoundException;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T> implements BinarySearchTreeADT<T> {

    protected int height;
    protected int maxIndex;

    public ArrayBinarySearchTree() {
        super();
        height = 0;
        maxIndex = -1;
    }

    /**
     * Creates a binary search with the specified element as its root
     *
     * @param element the element that will become the root of the new tree
     */
    public ArrayBinarySearchTree(T element) {
        super(element);
        height = 1;
        maxIndex = 0;
    }

    private void expandCapacity() {
        T[] temp = this.tree;
        this.tree = (T[]) new Object[temp.length * 2];
        System.arraycopy(temp, 0, this.tree, 0, temp.length);
    }

    /**
     * Adds the specified object to this binary search tree in the appropriate
     * position according to its key value. Note that equal elements are added
     * to the right. Also note that the index of the left child of the current
     * index can be found by doubling the current index and adding 1. Finding
     * the index of the right child can be calculated by doubling the current
     * index and adding 2.
     *
     * @param element the element to be added to the search tree
     */
    @Override
    public void addElement(T element) {
        if (tree.length < maxIndex * 2 + 3) {
            expandCapacity();
        }
        Comparable<T> tempelement = (Comparable<T>) element;
        if (isEmpty()) {
            tree[0] = element;
            maxIndex = 0;
        } else {
            boolean added = false;
            int currentIndex = 0;
            while (!added) {
                if (tempelement.compareTo((tree[currentIndex])) < 0) {
                    /**
                     * go left
                     */
                    if (tree[currentIndex * 2 + 1] == null) {
                        tree[currentIndex * 2 + 1] = element;
                        added = true;
                        if (currentIndex * 2 + 1 > maxIndex) {
                            maxIndex = currentIndex * 2 + 1;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 1;
                    }
                } else {
                    /**
                     * go right
                     */
                    if (tree[currentIndex * 2 + 2] == null) {
                        tree[currentIndex * 2 + 2] = element;
                        added = true;
                        if (currentIndex * 2 + 2 > maxIndex) {
                            maxIndex = currentIndex * 2 + 2;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 2;
                    }
                }
            }
        }
        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        count++;
    }

    /**
     * Troca um elemento com o maior elemento que seja filho do filho esquerdo.
     * O método vai á esquerda do elemento de paramentro (filho esquerdo),
     * depois de ir ao filho esquerdo, vai ao filho direito do filho esquerdo,
     * depois vai outra vez ao filho direito e assim sucessivamente até chegar
     * ao fim do ramo.
     *
     * @param element o elemento a ser substituido.
     */
    public void replace(int element) {
        if (tree.length - 1 < element * 2 + 1) { // Se não há espaço no array para os filhos, não há filhos.
            tree[element] = null;
        } else if (tree.length - 1 == element * 2 + 1) { // Se o array apenas permitir ter filho esquerdo.
            tree[element] = tree[element * 2 + 1];
        } else {
            if (tree[element * 2 + 1] == null && tree[element * 2 + 2] == null) { // Não tem filhos
                tree[element] = null;

            } else if (tree[element * 2 + 1] != null && tree[element * 2 + 2] == null) { //Tem so um filho ,esquerdo

                tree[element] = tree[element * 2 + 1];
                tree[element * 2 + 1] = null;
                replace(element * 2 + 1);

            } else if (tree[element * 2 + 1] == null && tree[element * 2 + 2] != null) { // Tem so um filho, direito

                tree[element] = tree[element * 2 + 2];
                tree[element * 2 + 2] = null;
                replace(element * 2 + 2);

            } else { //Tem dois filhos
                int closestLeftValue = element * 2 + 1;
                while (tree[closestLeftValue * 2 + 2] != null && tree.length - 1 > closestLeftValue * 2 + 2) {
                    closestLeftValue = closestLeftValue * 2 + 2;
                }

                tree[element] = tree[closestLeftValue];
                tree[closestLeftValue] = null;
            }

        }
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;
        int element = 0;
        boolean found = false;
        while (!found) {
            if (tree.length - 1 < element || tree[element] == null) {
                throw new ElementNotFoundException("Element not found");
            }
            if (tree[element] == targetElement) {
                found = true;
            } else {
                if (((Comparable) tree[element]).compareTo(targetElement) < 0) {
                    element = element * 2 + 2;
                } else {
                    element = element * 2 + 1;
                }
            }
        }
        result = tree[element];
        replace(element);

        return result;
    }

    @Override
    public void removeAllOccurrences(T targetElement) {
        boolean allRemoved = false;
        
        while(!allRemoved){
            try{
                removeElement(targetElement);
            }catch(ElementNotFoundException exception){
                allRemoved = true;
            }
        }
    }

    @Override
    public T removeMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findMin() {
        boolean found = false;
        int element = 0;

        if (tree[1] != null) {
            while (!found) {
                if (tree.length > element * 2 + 1 && tree[element * 2 + 1] == null) {
                    found = true;
                } else {
                    element = element * 2 + 1;
                }
            }
        }

        return tree[element];
    }

    @Override
    public T findMax() {
        boolean found = false;
        int element = 0;

        if (tree[1] != null) {
            while (!found) {
                if (tree.length > element * 2 + 2 && tree[element * 2 + 2] == null) {
                    found = true;
                } else {
                    element = element * 2 + 2;
                }
            }
        }

        return tree[element];
    }

}
