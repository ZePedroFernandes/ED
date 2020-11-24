package main;

import Colections.ArraySortingandSearching;
import Colections.Contact;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class TestContact {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contact[] friends = new Contact[7];

        friends[0] = new Contact("Clark", "Kent", "610-555-7384");
        friends[1] = new Contact("Bruce", "Wayne", "215-555-3827");
        friends[2] = new Contact("Peter", "Parker", "733-555-2969");
        friends[3] = new Contact("James", "Howlett", "663-555-3984");
        friends[4] = new Contact("Steven", "Rogers", "464-555-3489");
        friends[5] = new Contact("Britt", "Reid", "322-555-2284");
        friends[6] = new Contact("Matt", "Murdock", "243-555-2837");

        Integer[] numbers = new Integer[6];
        numbers[0] = 3;
        numbers[1] = 4;
        numbers[2] = 2;
        numbers[3] = -1;
        numbers[4] = 1;
        numbers[5] = 0;
//
//        Random rd = new Random();
//        
//        for(int i = 0; i < numbers.length;i++){
//            numbers[i] = rd.nextInt()/100000000;
//        }
        
        System.out.println(Arrays.toString(numbers));

        ArraySortingandSearching.quickSort(numbers, 0, numbers.length - 1);

        System.out.println(Arrays.toString(numbers));

        boolean ordered = true;
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] < numbers[i-1]){
                ordered = false;
            }
        }
        System.out.println(ordered);
        
//        for(Integer number : numbers){
//            System.out.println(number);
//        }
    }

}
