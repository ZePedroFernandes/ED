package zmain;

import Graphs.GraphList;
import Graphs.GraphMatrix;
import Graphs.Vertex;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraphMatrix<Vertex> graph = new GraphMatrix();
        
        Vertex A = new Vertex("A", 3);
        Vertex B = new Vertex("B", 3);
        Vertex C = new Vertex("C", 3);
        Vertex D = new Vertex("D", 3);
        Vertex E = new Vertex("E", 3);
        Vertex F = new Vertex("F", 3);
        Vertex G = new Vertex("G", 3);
        Vertex H = new Vertex("H", 3);
        Vertex I = new Vertex("I", 3);
        Vertex J = new Vertex("J", 3);

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
        
        //DFS->A - B - C - D - G - F - H - E
        //BFS->A - B - F - C - D - G - E - H
//        
//        Iterator itr = graph.iteratorBFS(A);
//
//        while (itr.hasNext()) {
//            System.out.println(itr.next());
//        }
        Iterator<Vertex> itr = graph.iteratorShortestPath(A, E);
        
        while(itr.hasNext()){
            System.out.print(itr.next());
            if(itr.hasNext()){
                System.out.print(" -> ");
            }
        }
        System.out.println("");
    }//Main

}
