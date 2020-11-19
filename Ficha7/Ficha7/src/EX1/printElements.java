/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;

import java.util.Iterator;
import lists.LinkedList;
import lists.OrderedLists.DoubleLinkedList;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class printElements {

    public static void printListElements(LinkedList list) {
        printElements(list.iterator());
    }

    public static void printListElements(DoubleLinkedList list) {
        printElements(list.iterator());
    }
    
    private static void printElements(Iterator collection) {
        if (!collection.hasNext()) {
        } else {
            System.out.println(collection.next());
            printElements(collection);
        }
    }
}
