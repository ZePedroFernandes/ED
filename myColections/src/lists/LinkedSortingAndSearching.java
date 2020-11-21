package lists;

import java.util.Iterator;
import nodes.LinkedNode;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class LinkedSortingAndSearching<T> {

    public static <T> boolean linearSearch(Iterator<T> node, T target) {

        if (node.next().equals(target)) {
            return true;
        } else if (!node.hasNext()) {
            return false;

        } else {
            return linearSearch(node, target);
        }
    }

//    public static <T extends Comparable<? super T>>
//            boolean binarySearch(LinkedNode<T> start, LinkedNode<T> end, T target) {
//
//        LinkedNode<T> midle = getMidle(start, end);
//        if () {
//
//        }
//    }

    public static <T> LinkedNode<T> getMidle(LinkedNode<T> start, LinkedNode<T> end) {
        if (start == end) {
            return start;
        }
        LinkedNode<T> midle = start;
        LinkedNode<T> current = start;
        while (true) {
            if (current == end || current.getNext() == end) {
                return midle;
            } else {
                current = current.getNext().getNext();
            }
            midle = midle.getNext();
        }
    }
}
