/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringcomparatorbysize;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Main class
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class StringComparatorBySize {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Comparator c = new CompareStringsSize();
        //Creating a comparator that compares two Strings by their Sizes.
        ArrayList<String> StringList = new ArrayList<>(4);

        StringList.add("Bye!");
        StringList.add("Hi!");
        StringList.add("Ahoy!");
        StringList.add("See you!");

        Collections.sort(StringList, c);

        Iterator<String> myIterator = StringList.iterator();
        
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }
        
    }

}
