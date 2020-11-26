/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zmain;

import exceptions.EmptyException;
import exceptions.InvalidElementException;
import queues.CircularArrayQueue;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Slide27_Test {

    public static void main(String[] args) {
        try {
            CircularArrayQueue<Character> alphabet = new CircularArrayQueue<>();
            alphabet.enqueue('A');
            alphabet.enqueue('B');
            alphabet.enqueue('C');
            alphabet.enqueue('D');
            alphabet.enqueue('E');
            alphabet.enqueue('F');
            alphabet.enqueue('G');
            alphabet.enqueue('H');
            alphabet.dequeue();
            alphabet.dequeue();
            alphabet.dequeue();
            alphabet.dequeue();
            alphabet.enqueue('I');
            alphabet.enqueue('J');
            alphabet.enqueue('K');
            alphabet.enqueue('L');

            System.out.println(alphabet.toString());
        } catch (EmptyException | InvalidElementException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
