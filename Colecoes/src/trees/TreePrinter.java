package trees;

import ADTs.BinaryTreeADT;
import java.util.Iterator;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public abstract class TreePrinter {

    public static <T> void printLevelOrder(BinaryTreeADT<T> tree) {
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

    public static <T> void printPreOrder(BinaryTreeADT<T> tree) {
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

    public static <T> void printInOrder(BinaryTreeADT<T> tree) {
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

    public static <T> void printPostOrder(BinaryTreeADT<T> tree) {
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
