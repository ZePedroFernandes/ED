package lists;

import java.util.Iterator;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class DoubleLinkedListSearching<T> {

    public static <T> boolean linearSearch(Iterator<T> node, T target) {

        if (node.next().equals(target)) {
            return true;
        } else if (!node.hasNext()) {
            return false;

        } else {
            return linearSearch(node, target);
        }
    }

//    public static <T extends Comparable<? super T>> boolean binnarySearch(DoubleLinkedList<T> list, T target) {
//        return binarySearch(list.head.getNext(), list.tail.getPrevious(), target);
//    }
//
//    private static <T extends Comparable<? super T>>
//            boolean binarySearch(DoubleLinkedNode<T> start, DoubleLinkedNode<T> end, T target) {
//
//        DoubleLinkedNode<T> midle = getMidle(start, end);
//        if (midle.getElement().compareTo(target) == 0) {
//            return true;
//        } else if (start == end) {
//            return false;
//        } else if (midle.getElement().compareTo(target) > 0) {
//            return binarySearch(start, midle.getPrevious(), target);
//        } else {
//            return binarySearch(midle.getNext(), end, target);
//        }
//
//    }

//    public static <T> DoubleLinkedNode<T> getMidle(DoubleLinkedNode<T> start, DoubleLinkedNode<T> end) {
//        if (start == end) {
//            return start;
//        }
//        DoubleLinkedNode<T> midle = start;
//        DoubleLinkedNode<T> current = start;
//        while (current != end) {
//            current = current.getNext();
//            if (current != end) {
//                current = current.getNext();
//                midle = midle.getNext();
//            }
//        }
//        return midle;
//    }
}
