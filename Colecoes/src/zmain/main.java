package zmain;

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
    public static void main(String[] args) {
        ArrayBinarySearchTree<Integer> tree = new ArrayBinarySearchTree<>();

        tree.addElement(5);
        tree.addElement(1);
        tree.addElement(3);
        tree.addElement(4);
        tree.addElement(10);
        tree.addElement(6);
        tree.addElement(-1);
        tree.addElement(0);
        tree.addElement(11);
        tree.addElement(-2);
        tree.addElement(2);
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

        int min = tree.findMax();
        System.out.println(min);
    }

}
