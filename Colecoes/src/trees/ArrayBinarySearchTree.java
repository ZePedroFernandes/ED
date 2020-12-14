package trees;

import contracts.BinarySearchTreeADT;
import exceptions.ElementNotFoundException;

/**
 * This class implements a binary search tree using an array
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T> implements BinarySearchTreeADT<T> {

    /**
     * tree's height.
     */
    protected int height;

    /**
     * tree's maximum index.
     */
    protected int maxIndex;

    /**
     * Creates an empty binary search tree.
     */
    public ArrayBinarySearchTree() {
        super();
        height = 0;
        maxIndex = -1;
    }

    /**
     * Creates a binary search with the specified element as its root.
     *
     * @param element the element that will become the root of the new tree
     */
    public ArrayBinarySearchTree(T element) {
        super(element);
        height = 1;
        maxIndex = 0;
    }

    /**
     * Expands the array capacity by a factor of 2.
     */
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
     * Checks if a specific element has a left child.
     *
     * @param index the index of the element to check if it has a left child.
     * @return true if the element has a left child, otherwise false.
     */
    private boolean hasLeftChild(int index) {
        boolean hasLeftChild = false;
        if (tree.length - 1 >= index * 2 + 1) {
            if (tree[index * 2 + 1] != null) {
                hasLeftChild = true;
            } else {
                hasLeftChild = false;
            }
        }
        return hasLeftChild;
    }

    /**
     * Checks if a specific element has a right child.
     *
     * @param index the index of the element to check if it has a right child.
     * @return true if the element has a right child, otherwise false.
     */
    private boolean hasRightChild(int index) {
        boolean hasRightChild = false;
        if (tree.length - 1 >= index * 2 + 2) {
            if (tree[index * 2 + 2] != null) {
                hasRightChild = true;
            } else {
                hasRightChild = false;
            }
        }
        return hasRightChild;
    }

    /**
     * Recursively removes an element in the binary tree based on it's index in
     * the array. If the element has no childs it is replaced with null. If it
     * has only a left child, the element is replaced with that child and the
     * left subtree will be shiffted across the array to the correct position.
     * If it has a right child, the left subtree will remain intact and the
     * minimun value present on the right subtree will replace the parameter
     * element and the subtree of this element will be shiffted to the correct
     * position.
     *
     * @param index the index of the element to be removed.
     */
    public void replace(int index) {
        if (index * 2 + 1 >= tree.length) {
            tree[index] = null;
        } else {
            int temp = index;

            if (!hasLeftChild(index) && !hasRightChild(index)) {
                tree[index] = null;

            } else if (hasLeftChild(index) && !hasRightChild(index)) {

                tree[index] = tree[index * 2 + 1];
                replace(index * 2 + 1);

            } else { // caso tenha filho direito, o filho esquerdo mantêm-se e só troca o direito.

                //Encontrar o minímo valor maior ou igual que o valor pai. ir á direita e depois sempre à esquerda.
                index = index * 2 + 2;
                while (index * 2 + 2 < tree.length && tree[index * 2 + 1] != null && tree.length - 1 > index * 2 + 1) {
                    index = index * 2 + 1;
                }

                //substituir o elemento e reconfigurar a subárvore respetiva.
                tree[temp] = tree[index];
                tree[index] = null;
                replace(index);
            }

        }
    }

//    public void replace(int element) {
//        if (element * 2 + 1 >= tree.length) {
//            tree[element] = null;
//        } else {
//            int temp = element;
//            if (tree.length - 1 == element * 2 + 1) {
//                tree[element] = tree[element * 2 + 1];
//                tree[element * 2 + 1] = null;
//            }
//            if (tree[element * 2 + 1] == null && tree[element * 2 + 2] == null) {
//                tree[element] = null;
//
//            } else if (tree[element * 2 + 1] != null && tree[element * 2 + 2] == null) {
//
//                tree[element] = tree[element * 2 + 1];
//                replace(element * 2 + 1);
//
//            } else {
//                element = element * 2 + 2;
//
//                while (element * 2 + 2 < tree.length && tree[element * 2 + 1] != null && tree.length - 1 > element * 2 + 1) {
//                    element = element * 2 + 1;
//                }
//
//                tree[temp] = tree[element];
//                tree[element] = null;
//                replace(element);
//            }
//
//        }
//    }
    /**
     * Finds and removes an element from the Binary Tree.
     *
     * @param targetElement the element to be removed
     * @return the removed element
     * @throws ElementNotFoundException if the element is not in the Binary
     * tree.
     */
    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;
        int index = 0;
        boolean found = false;
        while (!found) {
            if (tree.length - 1 < index || tree[index] == null) {
                throw new ElementNotFoundException("Element not found");
            }
            if (tree[index] == targetElement) {
                found = true;
            } else {
                if (((Comparable) tree[index]).compareTo(targetElement) < 0) {
                    index = index * 2 + 2;
                } else {
                    index = index * 2 + 1;
                }
            }
        }
        result = tree[index];
        replace(index);

        return result;
    }

    /**
     * Removes all occurencies of an element in the tree.
     *
     * @param targetElement the element to be removed.
     */
    @Override
    public void removeAllOccurrences(T targetElement) {
        boolean allRemoved = false;

        while (!allRemoved) {
            try {
                removeElement(targetElement);
            } catch (ElementNotFoundException exception) {
                allRemoved = true;
            }
        }
    }

    /**
     * Removes and returns the smallest element from this tree.
     *
     * @return the smallest element from this tree
     */
    @Override
    public T removeMin() {
        T minimun = null;
        int targetIndex = 0;

        while (this.hasLeftChild(targetIndex)) {
            targetIndex = targetIndex * 2 + 1;
        }

        minimun = tree[targetIndex];
        replace(targetIndex);

        return minimun;
    }

    /**
     * Removes and returns the biggest element from this tree.
     *
     * @return the biggest element from this tree
     */
    @Override
    public T removeMax() {
        T maximum = null;
        int targetIndex = 0;

        while (hasRightChild(targetIndex)) {
            targetIndex = targetIndex * 2 + 2;
        }

        maximum = tree[targetIndex];
        replace(targetIndex);

        return maximum;
    }

    /**
     * Returns a reference to the smallest element in this tree.
     *
     * @return a reference to the smallest element in this tree
     */
    @Override
    public T findMin() {
        int targetIndex = 0;

        while (hasLeftChild(targetIndex)) {
            targetIndex = targetIndex * 2 + 1;
        }

        return tree[targetIndex];
    }

    /**
     * Returns a reference to the largest element in this tree.
     *
     * @return a reference to the largest element in this tree
     */
    @Override
    public T findMax() {
        int targetIndex = 0;

        while (hasRightChild(targetIndex)) {
            targetIndex = targetIndex * 2 + 2;
        }

        return tree[targetIndex];
    }

}
