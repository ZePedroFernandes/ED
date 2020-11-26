package main;

import Colections.ArraySortingandSearching;
import lists.DoubleLinkedListSearching;
import car.Car;
import exceptions.InvalidElementException;
import lists.LinkedList;
import lists.OrderedLists.DoubleLinkedOrderedList;
import lists.LinkedNode;

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
        Car car3 = new Car("Model 3", 50900, "Tesla", 5);
        Car carS = new Car("Model S", 81990, "Tesla", 5);
        Car carX = new Car("Model X", 90990, "Tesla", 7);
        Car carY = new Car("Model Y", 75000, "Tesla", 5);
        Car semi = new Car("Semi", 150000, "Tesla", 5);
//        cars[0] = new Car("Model 3", 50900, "Tesla", 5);
//        cars[1] = new Car("Model S", 81990, "Tesla", 5);
//        cars[2] = new Car("Model X", 90990, "Tesla", 5);
//        cars[3] = car1;

        DoubleLinkedOrderedList<Car> cars = new DoubleLinkedOrderedList<>();
        try {
            cars.add(semi);
//            cars.add(carY);
            cars.add(carX);
            cars.add(carS);
            cars.add(car3);
        } catch (InvalidElementException e) {

        }
        //LinkedNode<Car> midle = DoubleLinkedListSearching.getMidle(cars.head, cars.tail);
        //System.out.println(midle.getElement().getName());
    }
}
