package trees;

import ADTs.HeapADT;

/**
 * This class represents a array implementation of a min Heap.
 * 
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> the type of elements in the heap
 */
public class ArrayHeap<T> extends ArrayBinaryTree<T> implements HeapADT<T> {

    private int lastIndex;

    public ArrayHeap() {
        super();
    }

    public ArrayHeap(T element) {
        super(element);
        this.lastIndex = 0;
    }

    private boolean isFull() {
        return (this.tree.length == this.lastIndex + 1);
    }

    private void expandSize() {
        T[] treeCopy = this.tree;
        this.tree = (T[]) new Object[this.size() * 2];

        for (int i = 0; i < treeCopy.length; i++) {
            this.tree[i] = treeCopy[i];
        }
    }

    private void addFirstElement(T element) {
        this.tree[0] = element;
        this.lastIndex = 0;
    }

    private int findNextAvailableIndex() {
        return lastIndex + 1;
    }

    private void swapElements(int firstIndex, int secondIndex) {
        T tmp = this.tree[firstIndex];
        this.tree[firstIndex] = this.tree[secondIndex];
        this.tree[secondIndex] = tmp;
    }

    /**
     * Reorders the heap in a ascending way. usefull when a new element is added.
     * 
     * @param index the index where the reordering will start.
     */
    private void reorderUp(int index) {
        if (index <= 0) {
            return;
        }
        int parentIndex = (index - 1) / 2;

        if (((Comparable<T>) this.tree[parentIndex]).compareTo(this.tree[index]) > 0) {
            swapElements(parentIndex, index);
            reorderUp(parentIndex);
        }
    }

    @Override
    public void addElement(T element) {
        if (this.isEmpty()) {
            addFirstElement(element);
        } else {
            int targetIndex = findNextAvailableIndex();

            if (this.isFull()) {
                this.expandSize();
            }

            this.tree[targetIndex] = element;
            this.reorderUp(targetIndex);
            this.lastIndex = targetIndex;
        }
        this.count++;
    }

    /**
     * Compares the left an right childs returning if the left one is greater
     * than the right one
     *
     * @param index the index at wich childs will be compared.
     * @return if the left child is greater than the right one.
     */
    private boolean LeftChildSmallerThanRight(int index) {
        return (((Comparable<T>) this.tree[index * 2 + 1]).compareTo(this.tree[index * 2 + 2]) < 0);
    }

    /**
     * Finds the smaller child for a element, returns -1 if the element has no
     * childs, otherwise returns the index of the smaller child.
     *
     * @param index the index at wich childs will be compared.
     * @return the index of the smalles child.
     */
    private int findSmallerChild(int index) {
        int smallerChild;

        //Não há espaço para o filho esquerdo
        if (this.tree.length - 1 < index * 2 + 1) {
            return -1;
        }

        //Há espaço para o filho esquerdo mas não há para o direito.
        if (this.tree.length - 1 < index * 2 + 2) {
            if (this.tree[index * 2 + 1] != null) {
                smallerChild = index * 2 + 1;
            } else {
                return -1;
            }

        } else {

            if (this.tree[index * 2 + 1] == null && this.tree[index * 2 + 2] == null) {
                return -1;
            }

            if (this.tree[index * 2 + 1] == null) {
                smallerChild = index * 2 + 2;
            } else if (this.tree[index * 2 + 2] == null) {
                smallerChild = index * 2 + 1;
            } else {

                if (this.LeftChildSmallerThanRight(index)) {
                    smallerChild = index * 2 + 1;
                } else {
                    smallerChild = index * 2 + 2;
                }
            }
        }

        return smallerChild;
    }

    /**
     * Reorders the heap descending based on a specific index.
     *
     * @param index the index at wich the heap will start to be reorder.
     */
    private void reorderDown(int index) {
        int smallerChild = this.findSmallerChild(index);

        if (smallerChild == -1) {
            return;
        }

        if (((Comparable<T>) this.tree[smallerChild]).compareTo(this.tree[index]) < 0) {
            swapElements(smallerChild, index);
            reorderDown(smallerChild);
        }
    }

    /**
     * Reorders the heap starting on the root element.
     */
    private void reorderFromRoot() {
        reorderDown(0);
    }

    @Override
    public T removeMin() {
        T removedElement = this.tree[0];

        this.tree[0] = this.tree[lastIndex];
        this.tree[this.lastIndex] = null;
        this.reorderFromRoot();
        this.lastIndex--;
        this.count--;
        
        return removedElement;
    }

    @Override
    public T findMin() {
        return this.getRoot();
    }

}
