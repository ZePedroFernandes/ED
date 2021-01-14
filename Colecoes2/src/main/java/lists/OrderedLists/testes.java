/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists.OrderedLists;

import exceptions.EmptyException;
import java.util.Iterator;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class testes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyException{
        BinarySearchTreeList<Integer> list = new BinarySearchTreeList<>();
        
        list.add(2);
        list.add(1);
        list.add(10);
        list.add(4);
        list.add(0);
        System.out.println(list.size());
        
        Iterator<Integer> itr = list.iterator();
        
        System.out.print("List: [");
        while(itr.hasNext()){
            System.out.print(itr.next());
            if(itr.hasNext()){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
    
}
