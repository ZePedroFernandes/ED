/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zmain;

import exceptions.InvalidElementException;
import lists.*;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class recursiveTests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        try {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.invert();
            System.out.println(list.toString());
        } catch (InvalidElementException e) {
            System.out.println(e.getMessage());
        }
    }

}
