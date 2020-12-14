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

        tree.addElement(10);
        tree.addElement(5);
        tree.addElement(2);
        tree.addElement(8);
        tree.addElement(6);
        tree.addElement(9);
        tree.addElement(7);


        TreePrinter.printLevelOrder(tree);

    }//Main

}
