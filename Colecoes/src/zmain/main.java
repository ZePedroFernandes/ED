package zmain;

import java.util.Iterator;
import lists.LinkedList;
import lists.unorderedLists.ArrayUnorderedList;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayUnorderedList<Integer> a = new ArrayUnorderedList<>();
        a.addToRear(null);
        a.addToRear(1);
        
        Iterator<Integer> itr = a.iterator();
        
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
    
}
