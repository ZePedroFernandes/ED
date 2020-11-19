/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import doublequeueorganizer.QueueMerger;
import exceptions.EmptyException;
import exceptions.InvalidElementException;
import queues.LinkedQueue;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class DoubleQueueOrganizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedQueue<Integer> firstQueue = new LinkedQueue<>();
        LinkedQueue<Integer> secondQueue = new LinkedQueue<>();
        QueueMerger<Integer> merger = new QueueMerger<>();

        try {
            firstQueue.enqueue(1);
            firstQueue.enqueue(5);
            firstQueue.enqueue(7);
            firstQueue.enqueue(7);

            secondQueue.enqueue(2);
            secondQueue.enqueue(5);
            secondQueue.enqueue(8); 
            //System.out.println(firstQueue.toString());
            //System.out.println(secondQueue.toString());

            LinkedQueue<Integer> mergedQueues = merger.mergeQueues(firstQueue, secondQueue);

            System.out.println(mergedQueues.toString());
        } catch (InvalidElementException | EmptyException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
