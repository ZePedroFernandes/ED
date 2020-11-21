/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colections;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class SortingAndSearching<T> {

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
            /**
             * Swap the values
             */
            temp = data[min];
            data[min] = data[index];
            data[index] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] data) {
        for (int index = 1; index < data.length; index++) {
            T key = data[index];
            int position = index;
            /**
             * Shift larger values to the right
             */
            while (position > 0 && data[position - 1].compareTo(key) > 0) {
                data[position] = data[position - 1];
                position--;
            }
            data[position] = key;
        }
    }

}
