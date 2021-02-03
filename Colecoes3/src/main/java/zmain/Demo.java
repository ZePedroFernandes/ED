package zmain;

import graphs.Network;
import graphs.Vertex;

import java.util.Iterator;

/**
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Demo {
    static final Vertex A = new Vertex("A", 3);
    static final Vertex B = new Vertex("B", 3);
    static final Vertex C = new Vertex("C", 3);
    static final Vertex D = new Vertex("D", 3);
    static final Vertex E = new Vertex("E", 3);
    static final Vertex F = new Vertex("F", 3);
    static final Vertex G = new Vertex("G", 3);
    static final Vertex H = new Vertex("H", 3);
    static final Vertex I = new Vertex("I", 3);
    static final Vertex J = new Vertex("J", 3);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Network<Vertex> network = new Network<>();

        network.addVertex(A);//1
        network.addVertex(B);//2
        network.addVertex(C);//3
        network.addVertex(D);//4
        network.addVertex(E);//5
        network.addVertex(F);
        network.addVertex(G);
        network.addVertex(H);

        /*network.addEdge(A, B,12);
        network.addEdge(A, D,6);

        network.addEdge(B, D,8);
        network.addEdge(B, E,3);

        network.addEdge(D, C,11);

        network.addEdge(E, C,1);*/

        network.addEdge(A, B,3);
        network.addEdge(A, F,3);

        network.addEdge(B, C,2);
        network.addEdge(B, D);
        network.addEdge(F, G,2);

        network.addEdge(C, D,4);
        network.addEdge(D, G,10);

        network.addEdge(G, H,1);
        network.addEdge(C, E,2);
        network.addEdge(H, E,2);

        Network<Vertex> mst = network.mstNetwork();

        System.out.println(mst);

    }//Main

}
