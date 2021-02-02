package Colecoes3;

import graphs.GraphMatrix;
import graphs.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class GraphMatrixTest {
    static final Vertex A = new Vertex("A", 3);
    static final Vertex B = new Vertex("B", 3);
    static final Vertex C = new Vertex("C", 3);
    static final Vertex D = new Vertex("D", 3);
    static final Vertex E = new Vertex("E", 3);
    static final Vertex F = new Vertex("F", 3);
    static final Vertex G = new Vertex("G", 3);
    static final Vertex H = new Vertex("H", 3);
    static GraphMatrix<Vertex> graph;

    @BeforeEach
    public void setUp() {
        graph = new GraphMatrix<>();
    }

    public void setDefaultGraph() {
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
    }

    @Test
    public void test_1() {
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

        assertEquals(A, itr.next());
        assertEquals(B, itr.next());
        assertEquals(C, itr.next());
        assertEquals(E, itr.next());
    }

    @Test
    public void test_2() {
        graph.addVertex(A);

        Iterator<Vertex> iterator = graph.iteratorShortestPath(A, A);

        assertFalse(iterator.hasNext());
    }

    @Test
    public void test_3() {
        graph.addVertex(A);
        graph.addVertex(B);

        graph.addEdge(A, B);

        Iterator<Vertex> itr = graph.iteratorShortestPath(A, B);

        assertEquals(A, itr.next());
        assertEquals(B, itr.next());
    }

    @Test
    public void test_4() {
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);
        graph.addVertex(F);

        graph.addEdge(A, B);
        graph.addEdge(A, C);
        graph.addEdge(A, F);
        graph.addEdge(C, D);
        graph.addEdge(D, E);
        graph.addEdge(E, F);

        Iterator<Vertex> itr = graph.iteratorShortestPath(A, F);

        assertEquals(A, itr.next());
        assertEquals(F, itr.next());
    }

    @Test
    public void test_5() {
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);
        graph.addVertex(F);

        graph.addEdge(A, B);
        graph.addEdge(A, C);
        //graph.addEdge(A,F);
        graph.addEdge(C, D);
        graph.addEdge(D, E);
        graph.addEdge(E, F);

        Iterator<Vertex> itr = graph.iteratorShortestPath(A, F);

        assertEquals(A, itr.next());
        assertEquals(C, itr.next());
        assertEquals(D, itr.next());
        assertEquals(E, itr.next());
        assertEquals(F, itr.next());
    }

    @Test
    public void test_ShortestPathLength_1() {
        this.setDefaultGraph();

        assertEquals(1, graph.shortestPathLength(A, B));
        assertEquals(1, graph.shortestPathLength(0, 1));
    }

    @Test
    public void test_ShortestPathLength_2() {
        this.setDefaultGraph();

        assertEquals(2, graph.shortestPathLength(A, C));
    }

    @Test
    public void test_ShortestPathLength_2_1() {
        this.setDefaultGraph();

        assertEquals(2, graph.shortestPathLength(0, 2));
    }

    @Test
    public void test_ShortestPathLength_3() {
        this.setDefaultGraph();

        assertEquals(2, graph.shortestPathLength(A, D));
    }

    @Test
    public void test_ShortestPathLength_3_1() {
        this.setDefaultGraph();

        assertEquals(2, graph.shortestPathLength(0, 3));
    }

    @Test
    public void test_ShortestPathLength_4() {
        this.setDefaultGraph();

        assertEquals(3, graph.shortestPathLength(A, E));
    }

    @Test
    public void test_ShortestPathLength_4_1() {
        this.setDefaultGraph();

        assertEquals(3, graph.shortestPathLength(0, 4));
    }

    @Test
    public void test_ShortestPathLength_5_1() {
        this.setDefaultGraph();

        assertEquals(3, graph.shortestPathLength(A, H));
    }

    @Test
    public void test_ShortestPathLength_5() {
        this.setDefaultGraph();

        assertEquals(3, graph.shortestPathLength(0, 7));
    }

    @Test
    public void test_ShortestPathLength_6() {
        this.setDefaultGraph();

        assertEquals(2, graph.shortestPathLength(A, G));
    }

    @Test
    public void test_ShortestPathLength_6_1() {
        this.setDefaultGraph();

        assertEquals(2, graph.shortestPathLength(0, 6));
    }

    @Test
    public void test_ShortestPathLength_7() {
        this.setDefaultGraph();

        assertEquals(3, graph.shortestPathLength(E, F));
    }

    @Test
    public void test_ShortestPathLength_7_1() {
        this.setDefaultGraph();

        assertEquals(3, graph.shortestPathLength(4, 5));
    }

    @Test
    public void test_ShortestPathLength_8() {
        this.setDefaultGraph();

        assertEquals(2, graph.shortestPathLength(C, H));
    }

    @Test
    public void test_ShortestPathLength_8_1() {
        this.setDefaultGraph();

        assertEquals(2, graph.shortestPathLength(2, 7));
    }

}
