/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zmain;

import exceptions.EmptyException;
import java.util.Iterator;
import lists.OrderedLists.ArrayOrderedList;
import lists.unorderedLists.ArrayUnorderedList;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class ArrayListTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayUnorderedList<Character> numbers = new ArrayUnorderedList<>(4);
        try {
            numbers.addToRear('c');
            numbers.addToRear('b');
            numbers.addToRear('d');
            numbers.addAfter('a', 'c');
            Iterator numbersIterator = numbers.iterator();
            while (numbersIterator.hasNext()) {
                System.out.println(numbersIterator.next());
            }
            numbers.remove('a');
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        boolean found = numbers.contains(4);
//        System.out.println(numbers.toString());
//        System.out.println(found);
    }

}
