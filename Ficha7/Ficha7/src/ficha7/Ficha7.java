package ficha7;

import EX1_EX2.printElements;
import exceptions.InvalidElementException;
import lists.OrderedLists.DoubleLinkedOrderedList;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Ficha7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoubleLinkedOrderedList<Integer> lista = new DoubleLinkedOrderedList<>();
        try {
            lista.add(1);
            lista.add(3);
            lista.add(2);
            lista.add(5);
            lista.add(4);
            
            //Iterator<Integer> itr = lista.iterator();
            
//            while(itr.hasNext()){
//                Integer e = itr.next();
//                System.out.println(e);
//            }
            printElements.printListElements(lista);
            
            
            
        } catch (InvalidElementException e) {
            System.out.println(e.getMessage());
        }
    }

}
