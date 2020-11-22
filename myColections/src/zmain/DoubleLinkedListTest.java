/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zmain;

import exceptions.EmptyException;
import exceptions.InvalidElementException;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import lists.DoubleLinkedListSearching;
import lists.LinkedList;
import lists.LinkedListSorting;
import lists.OrderedLists.DoubleLinkedOrderedList;
import lists.OrderedLists.DoubleLinkedOrderedListArrayable;
import lists.unorderedLists.DoubleLinkedUnorderedList;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class DoubleLinkedListTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();

        Random randomizer = new Random();

        for (Integer i = 0; i <= 5; i++) {
            try {
                numbers.add(i);
            } catch (InvalidElementException ex) {
                Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Iterator<Integer> itr1 = numbers.iterator();

        
        System.out.print("[");
        while (itr1.hasNext()) {
            System.out.print(itr1.next());
            if(itr1.hasNext()){
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        LinkedListSorting.swapNodes(numbers, numbers.head, numbers.head.getNext().getNext().getNext());

        Iterator<Integer> itr = numbers.iterator();

        System.out.print("[");
        while (itr.hasNext()) {
            System.out.print(itr.next());
            if(itr.hasNext()){
                System.out.print(", ");
            }
        }
        System.out.println("]");

    }

}
