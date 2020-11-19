package Colections;

import lists.OrderedLists.ArrayOrderedList;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T>
 */
public class ArrayListSearchable<T> extends ArrayOrderedList<T> {

    public boolean linearSearch(T element) {
        return this.contains(element);
    }

    public boolean binarySearch(T element) {
        if (element == null) {
            return false;
        }

        if (!(element instanceof Comparable)) {
            return false;
        }

        return this.find(0, this.size(), (Comparable<T>) element);
    }

    private boolean find(int start, int end, Comparable element) {
        boolean found = false;
        int midpoint = (end + start) / 2;

        if (element.compareTo(this.elements[midpoint]) == 0) {
            found = true;
        } else if (element.compareTo(this.elements[midpoint]) < 0) {
            if (start <= midpoint - 1) {
                found = find(start, midpoint - 1, element);
            }
        } else if (end >= midpoint + 1) {
            found = find(midpoint + 1, end, element);
        }

        return found;
    }

}
