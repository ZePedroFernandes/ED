package Graphs;

import static Graphs.GraphMatrixTest.A;
import static Graphs.GraphMatrixTest.B;
import static Graphs.GraphMatrixTest.C;
import static Graphs.GraphMatrixTest.D;
import static Graphs.GraphMatrixTest.E;
import static Graphs.GraphMatrixTest.F;
import static Graphs.GraphMatrixTest.G;
import static Graphs.GraphMatrixTest.H;
import static Graphs.GraphMatrixTest.graph;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class GraphMatrixTest {
    
    static GraphMatrix<Vertex> graph = new GraphMatrix<>();

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
    
    public GraphMatrixTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test_1(){
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

        Iterator<Vertex> itr = graph.iteratorShortestPath(A, E);
        
        String a = A.toString();
        String itra = itr.next().toString();
        assertEquals("A","A");
//        assertEquals(B.toString(), itr.next().toString());
//        assertEquals(C.toString(), itr.next().toString());
//        assertEquals(E.toString(), itr.next().toString());
    }
    
}
