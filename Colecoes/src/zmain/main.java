package zmain;

import exceptions.ElementNotFoundException;
import java.util.Iterator;
import queues.LinkedQueue;
import trees.ArrayBinarySearchTree;
import trees.LinkedBinarySearchTree;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ElementNotFoundException{
        ArrayBinarySearchTree<Integer> tree = new ArrayBinarySearchTree<>();

        tree.addElement(10);
        tree.addElement(5);
        tree.addElement(20);
        tree.addElement(0);
        tree.addElement(8);
        tree.addElement(15);
        tree.addElement(15);
        tree.addElement(25);
//        tree.removeAllOccurrences(4);
//        tree.removeAllOccurrences(3);
//        System.out.println(tree.findMax());

        System.out.print("Pre Order: [");
        Iterator<Integer> itrPreOrder = tree.iteratorPreOrder();
        while (itrPreOrder.hasNext()) {
            System.out.print(itrPreOrder.next());
            if (itrPreOrder.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.print("In Order: [");
        Iterator<Integer> itrInOrder = tree.iteratorInOrder();
        while (itrInOrder.hasNext()) {
            System.out.print(itrInOrder.next());
            if (itrInOrder.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.print("Post Order: [");
        Iterator<Integer> itrPostOrder = tree.iteratorPostOrder();
        while (itrPostOrder.hasNext()) {
            System.out.print(itrPostOrder.next());
            if (itrPostOrder.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.print("Level Order: [");
        Iterator<Integer> itrLevelOrder = tree.iteratorLevelOrder();
        while (itrLevelOrder.hasNext()) {
            System.out.print(itrLevelOrder.next());
            if (itrLevelOrder.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int removed = tree.removeElement(25);
        System.out.println(removed);
        System.out.print("Level Order: [");
        
        Iterator<Integer> itrLevelOrder2 = tree.iteratorInOrder();
        while (itrLevelOrder2.hasNext()) {
            System.out.print(itrLevelOrder2.next());
            if (itrLevelOrder2.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("");
    }

}
