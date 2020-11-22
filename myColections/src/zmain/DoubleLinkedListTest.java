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
        try {
//            for(int i = 0; i < 9 ; i++){
//                numbers.add(randomizer.nextInt() /100000000);
//            }

            /*[2027, -1093, -1850, -1442, 1173, -1827, -417, 211, -1979]*/
            numbers.add(-1979);
            numbers.add(211);
            numbers.add(-417);
            numbers.add(-1827);
            numbers.add(1173);
            numbers.add(-1442);
            numbers.add(-1850);
            numbers.add(-1093);
            numbers.add(2027);

        } catch (InvalidElementException e) {

        }

        LinkedListSorting.printlist(numbers);

        LinkedListSorting.insertionSort(numbers);
        
        LinkedListSorting.printlist(numbers);

    }

}
