package zmain;

import graphs.GraphList;
import graphs.GraphMatrix;
import graphs.Vertex;

import java.util.Iterator;

/**
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class main {
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

        GraphMatrix<Vertex> graph = new GraphMatrix();

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);
        graph.addVertex(F);
        graph.addVertex(G);
        graph.addVertex(H);

        graph.addEdge(A, B);
        graph.addEdge(A, F);

        graph.addEdge(B, C);
        graph.addEdge(B, D);
        graph.addEdge(F, G);

        graph.addEdge(C, D);
        graph.addEdge(D, G);

        graph.addEdge(G, H);
        graph.addEdge(C, E);
        graph.addEdge(H, E);

        Iterator<Vertex> itr = graph.iteratorShortestPath(A,E);
        
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }//Main

}
