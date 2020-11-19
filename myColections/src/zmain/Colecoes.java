package zmain;

import exceptions.InvalidElementException;
import exceptions.EmptyException;
import queues.CircularArrayQueue;
import queues.DoubleStackQueue;
import queues.LinkedQueue;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Colecoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            DoubleStackQueue<String> Compras = new DoubleStackQueue<>();
            Compras.enqueue("Alface");
            Compras.enqueue("2x Pão");
            Compras.enqueue("Cereais Chocapic");
            Compras.enqueue("Pizza Familiar n3");
            Compras.enqueue("6x Garrafões de água 6L");
            Compras.enqueue("Barra de chocolate Snickers");
            Compras.enqueue("M&M's");
            Compras.enqueue("250g Fiambre");
            Compras.enqueue("200g Queijo");
            Compras.enqueue("Frago Assado");

            Compras.dequeue();
            Compras.dequeue();
            Compras.dequeue();
            Compras.dequeue();
            Compras.dequeue();

//            for (int i = 0; i < 3; i++) {
//                String compra = Compras.dequeue();
//                System.out.println(compra);
//            }
            Compras.enqueue("Sumo natural Laranja");
            Compras.enqueue("Sumo natural Pessego");
            Compras.enqueue("Batatas fritas");

            System.out.println("\nFrist element: " + Compras.first());
            String clientsStrig = Compras.toString();
            System.out.println("\n" + clientsStrig + "\n");
            System.out.println("Empty: " + Compras.isEmpty());
            System.out.println("Number of elements: " + Compras.size());

        } catch (EmptyException | InvalidElementException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
