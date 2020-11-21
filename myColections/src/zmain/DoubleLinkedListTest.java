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
        DoubleLinkedUnorderedList<Integer> numbers = new DoubleLinkedUnorderedList<>();

        numbers.addToRear(3);
        numbers.addToRear(2);
        numbers.addToRear(1);

        Object[] array = numbers.getInverted();
        
        for(Object i : array){
            System.out.println(i);
        }
    }

}
