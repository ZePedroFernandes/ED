/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zmain;

import exceptions.InvalidElementException;
import java.util.Random;
import lists.LinkedList;
import lists.LinkedListSorting;
import lists.LinkedNode;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class LinkedListSortTests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();

        Random randomizer = new Random();
        try {
//            for (int i = 0; i < 9; i++) {
//                numbers.add(randomizer.nextInt()/100000000);
//            }

            numbers.add(0);
            numbers.add(1);
            numbers.add(-1);
            numbers.add(2);
            numbers.add(4);
            numbers.add(3);
        } catch (InvalidElementException e) {

        }

        LinkedListSorting.printlist(numbers);
        LinkedListSorting.quickSort(numbers.head, numbers.tail);

        //int pos = LinkedListSorting.findPosition(numbers, numbers.tail.getNext());
        LinkedListSorting.printlist(numbers);

        System.out.println("");
//        LinkedListSorting.printlist(numbers);
//        boolean ordered = true;
//        LinkedNode<Integer> current = numbers.head;
//        while (current.getNext() != null) {
//            if (current.getElement().compareTo(current.getNext().getElement()) > 0) {
//                ordered = false;
//            }
//
//            current = current.getNext();
//        }
//        System.out.println(ordered);
    }

}
