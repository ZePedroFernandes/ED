package doublequeueorganizer;

import exceptions.EmptyException;
import exceptions.InvalidElementException;
import queues.LinkedQueue;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> type of the queues.
 */
public class QueueMerger<T extends Comparable> {

    public LinkedQueue<T> mergeQueues(LinkedQueue<T> firstQueue, LinkedQueue<T> secondQueue) throws EmptyException, InvalidElementException {
        LinkedQueue<T> mergedQueues = new LinkedQueue<>();

        if (firstQueue.isEmpty()) {
            throw new EmptyException("First collection is empty");
        }
        if (secondQueue.isEmpty()) {
            throw new EmptyException("Second collection is empty");
        }

        while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
            if (firstQueue.first().compareTo(secondQueue.first()) <= 0) {
                mergedQueues.enqueue(firstQueue.dequeue());
            } else {
                mergedQueues.enqueue(secondQueue.dequeue());
            }
        }
        //At the end of this cicle only one queue will be empty.

        while (!firstQueue.isEmpty()) {
            mergedQueues.enqueue(firstQueue.dequeue());
        }

        while (!secondQueue.isEmpty()) {
            mergedQueues.enqueue(secondQueue.dequeue());
        }

        return mergedQueues;
    }
}
