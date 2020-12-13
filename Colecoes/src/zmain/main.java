package zmain;

import exceptions.ElementNotFoundException;
import java.util.Iterator;
import trees.AVLTree;
import trees.TreePrinter;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ElementNotFoundException {
        AVLTree<Integer> tree = new AVLTree<>();

        tree.addElement(20);
        tree.addElement(10);
        tree.addElement(15);
        tree.addElement(12);
        tree.addElement(17);
        tree.addElement(30);
        tree.addElement(40);
        tree.addElement(5);
        tree.addElement(5);

        TreePrinter.printLevelOrder(tree);

        tree.removeAllOccurrences(5);
//        tree.removeElement(40);
        
        TreePrinter.printLevelOrder(tree);
    }//Main

}
