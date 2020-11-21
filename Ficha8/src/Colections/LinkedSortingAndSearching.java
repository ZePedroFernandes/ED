package Colections;

import java.util.Iterator;

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

}
