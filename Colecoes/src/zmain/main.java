package zmain;

import exceptions.ElementNotFoundException;
import java.util.Iterator;
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
        ArrayBinarySearchTree<Integer> tree = new ArrayBinarySearchTree<>();

        tree.addElement(10);
        tree.addElement(0);
        tree.addElement(20);
        tree.addElement(5);
        tree.addElement(11);
        tree.addElement(10);
        tree.addElement(10);
        tree.addElement(10);
        tree.addElement(0);
        tree.addElement(-1);
        tree.addElement(-2);
        tree.addElement(8);
        tree.addElement(15);
        tree.addElement(15);
        tree.addElement(25);
        tree.addElement(26);
//        tree.removeAllOccurrences(15);
//        tree.removeAllOccurrences(3);
//        System.out.println(tree.findMax());

//        printPreOrder(tree);
//        
//        printInOrder(tree);
//        
//        printPostOrder(tree);
//        printLevelOrder(tree);
//        tree.removeElement(10);
//        tree.addElement(3);
//        tree.addElement(2);
//        tree.addElement(3);
        printLevelOrder(tree);

//        System.out.println("remover min");
        int removed = tree.findMax();
        System.out.println(removed);
        printLevelOrder(tree);

//        System.out.println("remover 2");
//        tree.removeAllOccurrences(2);
//        printLevelOrder(tree);
    }//Main

    public static <T> void printLevelOrder(ArrayBinarySearchTree<T> tree) {
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

    public static <T> void printPreOrder(ArrayBinarySearchTree<T> tree) {
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

    public static <T> void printInOrder(ArrayBinarySearchTree<T> tree) {
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

    public static <T> void printPostOrder(ArrayBinarySearchTree<T> tree) {
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
