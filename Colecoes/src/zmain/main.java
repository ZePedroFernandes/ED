package zmain;

import Graphs.Graph;
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
        Graph<Vertex> graph = new Graph();
        Vertex vertex1 = new Vertex("A", 3);
        Vertex vertex2 = new Vertex("B", 3);
        Vertex vertex3 = new Vertex("C", 3);
        Vertex vertex4 = new Vertex("D", 3);
        Vertex vertex5 = new Vertex("E", 3);
        Vertex vertex6 = new Vertex("F", 3);
        Vertex vertex7 = new Vertex("G", 3);
        Vertex vertex8 = new Vertex("H", 3);
        Vertex vertex9 = new Vertex("I", 3);
        Vertex vertex10 = new Vertex("J", 3);
        
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addVertex(vertex6);
        graph.addVertex(vertex7);
        graph.addVertex(vertex8);
        graph.addVertex(vertex9);
        graph.addVertex(vertex10);

        System.out.println("");
        
        graph.removeVertex(vertex3);
        
        System.out.println("");
    }//Main

}

class Vertex {

    String name;

    int info;

    public Vertex() {

    }

    public Vertex(String name, int info) {
        this.name = name;
        this.info = info;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertex other = (Vertex) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
}
