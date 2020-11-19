/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Colections.ArrayListSearchable;
import exceptions.InvalidElementException;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayListSearchable<Integer> arrayList = new ArrayListSearchable();

        try {
            arrayList.add(1);
            arrayList.add(3);
            arrayList.add(2);
            arrayList.add(5);
            arrayList.add(0);
            arrayList.add(4);
        } catch (InvalidElementException e) {
            System.out.println(e.getMessage());
        }
        
        boolean s = arrayList.binarySearch(6);
        System.out.println(s);
    }

}
