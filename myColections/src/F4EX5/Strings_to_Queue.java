package F4EX5;

import exceptions.EmptyException;
import exceptions.InvalidElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import queues.LinkedQueue;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Strings_to_Queue {

    public static LinkedQueue<LinkedQueue> StringsToQueue(String[] strings) {
        LinkedQueue<LinkedQueue> result = new LinkedQueue<>();

        for (String string : strings) {
            if (string != null) {
                LinkedQueue<String> queue = new LinkedQueue<>();
                try {
                    queue.enqueue(string);
                    result.enqueue(queue);
                } catch (InvalidElementException ex) {
                    return null;
                }
            }
        }

        while (result.size() != 1) {
            String string1 = new String();
            String string2 = new String();
            try {
                string1 = (String) result.dequeue().dequeue();
                string2 = (String) result.dequeue().dequeue();
            } catch (EmptyException ex) {
            }

            if (string1.compareTo(string2) <= 0) {
                string1 += string2;
            } else {
                string1 = string2 + string1;
            }

            LinkedQueue<String> queue = new LinkedQueue<>();
            try {
                queue.enqueue(string1);
                result.enqueue(queue);
            } catch (InvalidElementException ex) {
            }
        }

        return result;
    }
}
