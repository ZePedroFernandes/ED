/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import nodes.DoubleLinkedNode;
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

        while (startNode != null) {
            smaller = currentNode;

            while (currentNode != null) {
                if (currentNode.getElement().compareTo(smaller.getElement()) < 0) {
                    smaller = currentNode;
                }
                currentNode = currentNode.getNext();
            }
            swapNodes(list, smaller, startNode);

        }
    }

    public static <T extends Comparable<? super T>>
            void swapNodes(LinkedList<T> list, LinkedNode<T> first, LinkedNode<T> second) {
        if (first == second) {
            return;
        }
        LinkedNode<T> current = second;
        while (current != null) {
            if (current == first) {
                swapNodes(list, second, first);
                return;
            }
            current = current.getNext();
        }

        LinkedNode<T> firsNext = first.getNext();
        LinkedNode<T> secondNext = second.getNext();
        LinkedNode<T> prevFirst = null;
        LinkedNode<T> prevSecond = null;

        if (second != list.head) {
            prevSecond = list.head;
            while (prevSecond.getNext() != second) {
                prevSecond = prevSecond.getNext();
            }
        }

        if (first != list.head) {
            prevFirst = list.head;
            while (prevFirst.getNext() != first) {
                prevFirst = prevFirst.getNext();
            }
        }

        if (list.tail == second) {
            list.tail = first;
        } else if (list.tail == first) {
            list.tail = second;
        }

        if (list.head == first) {
            list.head = second;
        } else if (list.head == second) {
            list.head = first;
        }

        second.setNext(null);
        first.setNext(null);
        if (prevFirst != null) {
            prevFirst.setNext(null);
        }
        if (prevSecond != null) {
            prevSecond.setNext(null);
        }
        if (prevFirst != null) {
            prevFirst.setNext(second);
        }
        if (prevSecond != null) {
            prevSecond.setNext(first);
        }

        second.setNext(firsNext);
        first.setNext(secondNext);

    }
}
