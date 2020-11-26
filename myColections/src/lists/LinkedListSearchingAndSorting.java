package lists;

import java.util.Iterator;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class LinkedListSearchingAndSorting<T> {

    public static <T> boolean linearSearch(Iterator<T> node, T target) {

        if (node.next().equals(target)) {
            return true;
        } else if (!node.hasNext()) {
            return false;

        } else {
            return linearSearch(node, target);
        }
    }

    /**
     * Finds the position of a node in a linked list. Returns -1 if the node was
     * not found or is null.
     *
     * @param <T> type of the stored elements
     * @param list list where the node is
     * @param node node wich position will be returned.
     * @return the position of the node in the list, if the node is not found or
     * is null -1 will be returned.
     */
    public static <T> int findPosition(LinkedList<T> list, LinkedNode<T> node) {
        if (node == null) {
            return -1;
        }

        LinkedNode<T> current = list.head;
        int count = 0;

        while (current != node && current != null) {
            current = current.getNext();
            count++;
        }
        if (count < list.size()) {
            return count;
        } else {
            return -1;
        }
    }

    private static <T> LinkedNode<T> findPrevious(LinkedList<T> list, LinkedNode<T> node) {
        if (node == list.head) {
            return null;
        }
        LinkedNode<T> previous = list.head;

        while (previous != null && previous.getNext() != node) {
            previous = previous.getNext();
        }
        return previous;
    }

    private static <T extends Comparable<? super T>>
            void swapNodes(LinkedList<T> list, LinkedNode<T> first, LinkedNode<T> second) {
        if (first == second) {
            return;
        }

        if (second == list.head) {
            LinkedNode<T> tmp = second;
            second = first;
            first = tmp;
        }
        if (second == list.tail) {
            list.tail = first;
        }

        LinkedNode<T> prevFirst = list.head;
        LinkedNode<T> prevSecond = list.head;
        LinkedNode<T> tmp;

        while (prevSecond.getNext() != second) {
            prevSecond = prevSecond.getNext();
        }

        if (first == list.head) {
            tmp = second.getNext();
            prevSecond.setNext(first);
            list.head = second;
            second.setNext(first.getNext());
            first.setNext(tmp);

        } else {

            while (prevFirst.getNext() != first) {
                prevFirst = prevFirst.getNext();
            }

            tmp = prevSecond.getNext();//
            prevSecond.setNext(prevFirst.getNext());
            prevFirst.setNext(tmp);

            tmp = prevSecond.getNext().getNext();
            prevSecond.getNext().setNext(prevFirst.getNext().getNext());
            prevFirst.getNext().setNext(tmp);
        }
    }

    public static <T extends Comparable<? super T>> void insertionSort(LinkedList<T> list) {

        LinkedNode<T> current = list.head.getNext();
        LinkedNode<T> prev = list.head;
        LinkedNode<T> auxprev;
        LinkedNode<T> aux;

        while (current != null) {

            auxprev = prev;
            aux = current;

            while (auxprev != null && auxprev.getElement().compareTo(aux.getElement()) > 0) {
                swapNodes(list, auxprev, aux);
                auxprev = findPrevious(list, aux);
            }
            prev = current;
            current = current.getNext();
        }
    }

    public static <T extends Comparable<? super T>> void selectionSort(LinkedList<T> list) {
        LinkedNode<T> startNode = list.head;
        LinkedNode<T> currentNode = list.head;
        LinkedNode<T> smaller = list.head;
        LinkedNode<T> aux;

        while (startNode != null) {
            smaller = startNode;
            currentNode = startNode;

            while (currentNode != null) {
                if (currentNode.getElement().compareTo(smaller.getElement()) < 0) {
                    smaller = currentNode;
                }
                currentNode = currentNode.getNext();
            }
            aux = startNode.getNext();
            if (smaller != startNode) {
                swapNodes(list, smaller, startNode);
            }
            startNode = aux;
        }
    }

    public static <T extends Comparable<? super T>>
            void bubbleSort(LinkedList<T> list, LinkedNode<T> end) {

        if (end == list.head) {

        } else {
            LinkedNode<T> current = list.head;
            LinkedNode<T> greater = list.head;

            while (current != end.getNext()) {
                if (current.getElement().compareTo(greater.getElement()) > 0) {
                    greater = current;
                }
                current = current.getNext();
            }
            swapNodes(list, greater, end);
            bubbleSort(list, findPrevious(list, greater));
        }
    }

    public static <T> void printlist(LinkedList<T> lista) {
        Iterator<T> itr1 = lista.iterator();

        System.out.print("[");
        while (itr1.hasNext()) {
            System.out.print(itr1.next());
            if (itr1.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
