/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zmain;

import exceptions.EmptyException;
import exceptions.InvalidElementException;
import queues.LinkedQueue;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class ExemploClientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            LinkedQueue<String> Clients = new LinkedQueue<>();

            Clients.enqueue("Manel");
            Clients.enqueue("Luis");
            Clients.enqueue("Maria");
            Clients.dequeue();
            Clients.enqueue("Ana");

            System.out.println(Clients.toString());
            System.out.println("First: " + Clients.first());
            System.out.println("Empty: " + Clients.isEmpty());
            System.out.println("Size: " + Clients.size());

        } catch (EmptyException | InvalidElementException expection) {
            System.out.println(expection.getMessage());
        }
    }

}
