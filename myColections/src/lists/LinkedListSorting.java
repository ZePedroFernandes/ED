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
            LinkedNode<T> newHead = new LinkedNode<>(second.getElement());
            LinkedNode<T> newSecond = new LinkedNode<>(first.getElement());
            prevSecond.setNext(newSecond);
            newSecond.setNext(second.getNext());
            newHead.setNext(first.getNext());
            list.head = newHead;

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
}
