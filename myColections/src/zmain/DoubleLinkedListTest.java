/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zmain;

import exceptions.EmptyException;
import exceptions.InvalidElementException;
import java.util.Iterator;
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
        DoubleLinkedOrderedListArrayable<Integer> numbers = new DoubleLinkedOrderedListArrayable<>();
        
        try {
            numbers.add(3);
            numbers.add(2);
            numbers.add(0);
            numbers.add(1);
            Object[] numbersArray = numbers.toArray();
            for (Object numbersArray1 : numbersArray) {
                System.out.println(numbersArray1.toString());
            }
            
        } catch (InvalidElementException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
