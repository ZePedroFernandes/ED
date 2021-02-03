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

        network.addVertex(A);
        network.addVertex(B);
        network.addVertex(C);
        network.addVertex(D);
        network.addVertex(E);
        network.addVertex(F);
        network.addVertex(G);
        network.addVertex(H);
        network.addVertex(I);
        network.addVertex(J);

        network.addEdge(A, B,1);
        network.addEdge(A, F,1);

        network.addEdge(B, C,1);
        network.addEdge(B, D,1);
        network.addEdge(F, G,1);

        network.addEdge(C, D,1);
        network.addEdge(D, G,1);

        network.addEdge(G, H,1);
        network.addEdge(C, E,1);
        network.addEdge(H, E,1);

        Network<Vertex> mst = network.mstNetwork();

        System.out.println(mst);

    }//Main

}
