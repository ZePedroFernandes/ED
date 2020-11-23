/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.Iterator;
import nodes.LinkedNode;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class LinkedListSorting {

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

    private static <T extends Comparable<? super T>>
            void swapNodes(LinkedList<T> list, LinkedNode<T> first, LinkedNode<T> second) {
        if (first == second) {
            return;
        }
        LinkedNode<T> current = second;
        while (current != null) {
            if (current == first) {
                LinkedNode<T> tmp = first;
                first = second;
                second = tmp;
                break;
            }
            current = current.getNext();
        }
        LinkedNode<T> prevSecond = list.head;
        while (prevSecond.getNext() != second) {
            prevSecond = prevSecond.getNext();
        }

        if (first == list.head) {
            LinkedNode<T> tmp = second.getNext();
            prevSecond.setNext(first);
            list.head = second;
            second.setNext(first.getNext());
            first.setNext(tmp);

        } else {

            LinkedNode<T> prevFirst = list.head;
            LinkedNode<T> tmp;

            while (prevFirst.getNext() != first) {
                prevFirst = prevFirst.getNext();
            }

            tmp = prevFirst.getNext();
            prevFirst.setNext(prevSecond.getNext());
            prevSecond.setNext(tmp);

            tmp = prevFirst.getNext().getNext();
            prevFirst.getNext().setNext(prevSecond.getNext().getNext());
            prevSecond.getNext().setNext(tmp);
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

    private static <T extends Comparable<? super T>>
            void swapNodes2(LinkedList<T> list, LinkedNode<T> first, LinkedNode<T> second) {

    }
}
