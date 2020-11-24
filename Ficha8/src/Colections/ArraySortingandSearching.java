package Colections;

import java.util.Arrays;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T>
 */
public class ArraySortingandSearching<T> {

    public static <T extends Comparable<? super T>>
            boolean linearSearch(T[] data, int min, int max, T target) {

        int index = min;
        boolean found = false;
        while (!found && index <= max) {
            if (data[index].compareTo(target) == 0) {
                found = true;
            }
            index++;
        }
        return found;
    }

    public static <T extends Comparable<? super T>>
            boolean binarySearch(T[] data, int min, int max, T target) {

        boolean found = false;
        int midpoint = (min + max) / 2;  // determine the midpoint
        if (data[midpoint].compareTo(target) == 0) {
            found = true;
        } else if (data[midpoint].compareTo(target) > 0) {
            if (min <= midpoint - 1) {
                found = binarySearch(data, min, midpoint - 1, target);
            }
        } else if (midpoint + 1 <= max) {
            found = binarySearch(data, midpoint + 1, max, target);
        }
        return found;
    }

    public static <T extends Comparable<? super T>> void selectionSort(T[] data) {
        int min;
        T temp;
        for (int index = 0; index < data.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < data.length; scan++) {
                if (data[scan].compareTo(data[min]) < 0) {
                    min = scan;
                }
            }

            //Swap the values
            temp = data[min];
            data[min] = data[index];
            data[index] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] data) {
        for (int index = 1; index < data.length; index++) {
            T key = data[index];
            int position = index;

            //Shift larger values to the right
            while (position > 0 && data[position - 1].compareTo(key) > 0) {
                data[position] = data[position - 1];
                position--;
            }
            data[position] = key;
        }
    }

    public static <T extends Comparable<? super T>> void bubbleSort(T[] data) {
        int position, scan;
        T temp;
        for (position = data.length - 1; position >= 0; position--) {
            for (scan = 0; scan <= position - 1; scan++) {
                if (data[scan].compareTo(data[scan + 1]) > 0) {

                    //Swap the values
                    temp = data[scan];
                    data[scan] = data[scan + 1];
                    data[scan + 1] = temp;
                }
            }
        }
    }

    /**
     *
     * Sorts the specified array of objects using the quick sort * algorithm.
     *
     * @param <T>
     * @param data the array to be sorted
     * @param min the integer representation of the minimum value
     * @param max the integer representation of the maximum value
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] data, int min, int max) {
        int indexofpartition;

        if (max - min > 0) {
            /* Create partitions */
            indexofpartition = findPartition(data, min, max);

            /* Sort the left side*/
            quickSort(data, min, indexofpartition - 1);

            /* Sort the right side*/
            quickSort(data, indexofpartition + 1, max);
        }
    }

    private static <T extends Comparable<? super T>> int
            findPartition(T[] data, int min, int max) {
        int left, right;
        T temp, partitionelement;
        int middle = (min + max) / 2;//

        //use the first element as the partition element
        partitionelement = data[middle];//

        left = min;
        right = max;

        while (left < right) {
            System.out.println(Arrays.toString(data));
            System.out.println("Left  " + data[left]);
            System.out.println("Right " + data[right]);
            System.out.println("Midle " + data[middle]);

            // search for an element that is > the partitionelement
            while (data[left].compareTo(partitionelement) <= 0
                    && left < right) {
                left++;
                System.out.println("Left-> " + data[left]);
            }

            //search for an element that is < the partitionelement
            while (data[right].compareTo(partitionelement) > 0
                    && right > 0) {
                right--;
                System.out.println("Right-> " + data[right]);
            }

            //swap the elements 
            if (left < right) {
                if (left == middle) {
                    middle = right;
                    System.out.println("Middle-> " + data[right]);
                } else if (right == middle) {
                    middle = left;
                    System.out.println("Middle-> " + data[left]);
                }

                temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                System.out.println("swap right and left");
            }
        }

        //move partition element to partition index
        temp = data[middle];
        data[middle] = data[right];
        data[right] = temp;
        System.out.println(Arrays.toString(data));
        System.out.println("swap middle and right");

        return right;
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] data, int min, int max) {
        //return on list of length one
        if (min == max) {
            return;
        }

        //find the length and the midpoint of the list
        int pivot = (min + max) / 2;

        mergeSort(data, min, pivot); // sort left half of list      
        mergeSort(data, pivot + 1, max); // sort right half of list      
        merge(data, pivot, min, max); //merges both sides

    }

    private static <T extends Comparable<? super T>> void merge(T[] data, int pivot, int min, int max) {
        int index, left, right;

        int size = max - min + 1;
        T[] workspace = (T[]) (new Comparable[size]);

        System.arraycopy(data, min, workspace, 0, size);

        left = 0;
        right = pivot - min + 1;

        for (index = 0; index < size; index++) {
            if (right <= size - 1) {
                if (left <= pivot - min) { // min <= left <= pivot
                    if (workspace[left].compareTo(workspace[right]) > 0) {
                        data[index + min] = workspace[right++];
                    } else {
                        data[index + min] = workspace[left++];
                    }
                } else {
                    data[index + min] = workspace[right++];
                }
            } else {
                data[index + min] = workspace[left++];
            }
        }
    }
}
