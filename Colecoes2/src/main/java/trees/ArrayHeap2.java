package trees;

import ADTs.HeapADT;
import exceptions.EmptyCollectionException;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class ArrayHeap2<T> extends ArrayBinaryTree<T> implements HeapADT<T> {

    public ArrayHeap2() {
        super();
    }

    private void heapifyAdd() {
        T temp;
        int next = count - 1;
        temp = tree[next];
        while ((next != 0) && (((Comparable) temp).compareTo(tree[(next - 1) / 2]) < 0)) {
            tree[next] = tree[(next - 1) / 2];
            next = (next - 1) / 2;
        }
        tree[next] = temp;
    }

    private void expandCapacity() {
        T[] treeCopy = this.tree;
        this.tree = (T[]) new Object[this.size() * 2];

        for (int i = 0; i < treeCopy.length; i++) {
            this.tree[i] = treeCopy[i];
        }
    }

    @Override
    public void addElement(T obj) {
        if (count == tree.length) {
            expandCapacity();
        }
        tree[count] = obj;
        count++;

        if (count > 1) {
            heapifyAdd();
        }
    }

    @Override
    public T removeMin() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty Heap");
        }
        T minElement = tree[0];
        tree[0] = tree[count - 1];
        heapifyRemove();
        count--;
        return minElement;
    }

    private void heapifyRemove() {
        T temp;
        int node = 0;
        int left = 1;
        int right = 2;
        int next;
        if ((tree[left] == null) && (tree[right] == null)) {
            next = count;
        } else if (tree[left] == null) {
            next = right;
        } else if (tree[right] == null) {
            next = left;
        } else if (((Comparable) tree[left]).compareTo(tree[right]) < 0) {
            next = left;
        } else {
            next = right;
        }
        temp = tree[node];
        while ((next < count) && (((Comparable) tree[next]).compareTo(temp) < 0)) {
            tree[node] = tree[next];
            node = next;
            left = 2 * node + 1;
            right = 2 * (node + 1);
            if ((tree[left] == null) && (tree[right] == null)) {
                next = count;
            } else if (tree[left] == null) {
                next = right;
            } else if (tree[right] == null) {
                next = left;
            } else if (((Comparable) tree[left]).compareTo(tree[right]) < 0) {
                next = left;
            } else {
                next = right;
            }
        }
        tree[node] = temp;
    }

    @Override
    public T findMin() {
        return tree[0];
    }

}
