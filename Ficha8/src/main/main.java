package main;

import Colections.ArraySortingandSearching;
import lists.LinkedSortingAndSearching;
import car.Car;
import exceptions.InvalidElementException;
import lists.LinkedList;
import nodes.LinkedNode;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Car[] cars = new Car[4];
        Car car1 = new Car("Model 3", 50900, "Tesla", 5);
        Car car2 = new Car("Model S", 81990, "Tesla", 5);
        Car car3 = new Car("Model X", 90990, "Tesla", 7);
        Car car4 = new Car("Model Y", 75000, "Tesla", 5);
        Car car5 = new Car("Semi", 150000, "Tesla", 5);
//        cars[0] = new Car("Model 3", 50900, "Tesla", 5);
//        cars[1] = new Car("Model S", 81990, "Tesla", 5);
//        cars[2] = new Car("Model X", 90990, "Tesla", 5);
//        cars[3] = car1;

        LinkedList<Car> cars = new LinkedList<>();
        try {
            cars.add(car5);
            cars.add(car4);
            cars.add(car3);
            cars.add(car2);
            cars.add(car1);
        } catch (InvalidElementException e) {

        }
        boolean found = LinkedSortingAndSearching.linearSearch(cars.iterator(), car4);
        LinkedNode<Car> midle = LinkedSortingAndSearching.getMidle(cars.head, cars.tail);
        System.out.println(midle.getElement().getName());
    }
}
