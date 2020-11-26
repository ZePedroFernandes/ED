package zmain;

import java.util.Iterator;
import lists.LinkedList;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        
        Iterator<Integer> itr = list.iterator();
        
        System.out.println(itr.next());
    }
    
}
