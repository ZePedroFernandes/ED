package zmain;

import exceptions.ElementNotFoundException;
import java.util.Iterator;
import trees.AVLTree;
import trees.ArrayBinarySearchTree;

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
        tree.addElement(30);
        tree.addElement(5);
//        tree.addElement(4);
        tree.addElement(40);

        printLevelOrder(tree);

        tree.removeElement(20);
        
        printLevelOrder(tree);

    }//Main

    public static <T> void printLevelOrder(AVLTree<T> tree) {
        System.out.print("Level Order: [");
        Iterator<T> itrLevelOrder = tree.iteratorLevelOrder();
        while (itrLevelOrder.hasNext()) {
            System.out.print(itrLevelOrder.next());
            if (itrLevelOrder.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static <T> void printPreOrder(AVLTree<T> tree) {
        System.out.print("Pre Order: [");
        Iterator<T> itrPreOrder = tree.iteratorPreOrder();
        while (itrPreOrder.hasNext()) {
            System.out.print(itrPreOrder.next());
            if (itrPreOrder.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static <T> void printInOrder(AVLTree<T> tree) {
        System.out.print("In Order: [");
        Iterator<T> itrInOrder = tree.iteratorInOrder();
        while (itrInOrder.hasNext()) {
            System.out.print(itrInOrder.next());
            if (itrInOrder.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static <T> void printPostOrder(AVLTree<T> tree) {
        System.out.print("Post Order: [");
        Iterator<T> itrPostOrder = tree.iteratorPostOrder();
        while (itrPostOrder.hasNext()) {
            System.out.print(itrPostOrder.next());
            if (itrPostOrder.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
