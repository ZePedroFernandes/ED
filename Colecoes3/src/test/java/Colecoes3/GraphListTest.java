package Colecoes3;

import graphs.GraphList;
import graphs.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class GraphListTest {
    static final Vertex A = new Vertex("A", 3);
    static final Vertex B = new Vertex("B", 3);
    static final Vertex C = new Vertex("C", 3);
    static final Vertex D = new Vertex("D", 3);
    static final Vertex E = new Vertex("E", 3);
    static final Vertex F = new Vertex("F", 3);
    static final Vertex G = new Vertex("G", 3);
    static final Vertex H = new Vertex("H", 3);
    static GraphList<Vertex> graph;

    @BeforeEach
    public void setUp() {
        graph = new GraphList<>();
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
    public void test_BFS_1() {
        setDefaultGraph();
        Iterator<Vertex> itr = graph.iteratorBFS(A);
        assertEquals(A, itr.next());
        assertEquals(B, itr.next());
        assertEquals(F, itr.next());
        assertEquals(C, itr.next());
        assertEquals(D, itr.next());
        assertEquals(G, itr.next());
        assertEquals(E, itr.next());
        assertEquals(H, itr.next());
    }

    @Test
    public void test_BFS_2() {
        setDefaultGraph();
        Iterator<Vertex> itr = graph.iteratorBFS(B);
        assertEquals(B, itr.next());
        assertEquals(A, itr.next());
        assertEquals(C, itr.next());
        assertEquals(D, itr.next());
        assertEquals(F, itr.next());
        assertEquals(E, itr.next());
        assertEquals(G, itr.next());
        assertEquals(H, itr.next());
    }

    @Test
    public void test_BFS_3() {
        setDefaultGraph();
        Iterator<Vertex> itr = graph.iteratorBFS(C);
        assertEquals(C, itr.next());
        assertEquals(B, itr.next());
        assertEquals(D, itr.next());
        assertEquals(E, itr.next());
        assertEquals(A, itr.next());
        assertEquals(G, itr.next());
        assertEquals(H, itr.next());
        assertEquals(F, itr.next());
    }

    @Test
    public void test_BFS_4() {
        setDefaultGraph();
        Iterator<Vertex> itr = graph.iteratorBFS(D);
        assertEquals(D, itr.next());
        assertEquals(B, itr.next());
        assertEquals(C, itr.next());
        assertEquals(G, itr.next());
        assertEquals(A, itr.next());
        assertEquals(E, itr.next());
        assertEquals(F, itr.next());
        assertEquals(H, itr.next());
    }

    @Test
    public void test_BFS_5() {
        setDefaultGraph();
        Iterator<Vertex> itr = graph.iteratorBFS(E);
        assertEquals(E, itr.next());
        assertEquals(C, itr.next());
        assertEquals(H, itr.next());
        assertEquals(B, itr.next());
        assertEquals(D, itr.next());
        assertEquals(G, itr.next());
        assertEquals(A, itr.next());
        assertEquals(F, itr.next());
    }

    @Test
    public void test_BFS_6() {
        setDefaultGraph();
        Iterator<Vertex> itr = graph.iteratorBFS(F);
        assertEquals(F, itr.next());
        assertEquals(A, itr.next());
        assertEquals(G, itr.next());
        assertEquals(B, itr.next());
        assertEquals(D, itr.next());
        assertEquals(H, itr.next());
        assertEquals(C, itr.next());
        assertEquals(E, itr.next());
    }

    @Test
    public void test_BFS_7() {
        setDefaultGraph();
        Iterator<Vertex> itr = graph.iteratorBFS(G);
        assertEquals(G, itr.next());
        assertEquals(D, itr.next());
        assertEquals(F, itr.next());
        assertEquals(H, itr.next());
        assertEquals(B, itr.next());
        assertEquals(C, itr.next());
        assertEquals(A, itr.next());
        assertEquals(E, itr.next());
    }

    @Test
    public void test_BFS_8() {
        setDefaultGraph();
        Iterator<Vertex> itr = graph.iteratorBFS(H);
        assertEquals(H, itr.next());
        assertEquals(E, itr.next());
        assertEquals(G, itr.next());
        assertEquals(C, itr.next());
        assertEquals(D, itr.next());
        assertEquals(F, itr.next());
        assertEquals(B, itr.next());
        assertEquals(A, itr.next());
    }

    public String getDFSActualString(Vertex vertex){
        Iterator<Vertex> itr = graph.iteratorDFS(vertex);
        String actual = "";
        while (itr.hasNext()) {
            actual += itr.next().getName();
            if (itr.hasNext()) {
                actual += "->";
            }
        }
        return actual;
    }

    @Test
    public void test_DFS_1() {
        setDefaultGraph();
        String actual = getDFSActualString(A);
        String expected = "A->B->C->D->G->F->H->E";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_2() {
        setDefaultGraph();
        String actual = getDFSActualString(B);
        String expected = "B->A->F->G->D->C->E->H";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_3() {
        setDefaultGraph();
        String actual = getDFSActualString(C);
        String expected = "C->B->A->F->G->D->H->E";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_4() {
        setDefaultGraph();
        String actual = getDFSActualString(D);
        String expected = "D->B->A->F->G->H->E->C";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_5() {
        setDefaultGraph();
        String actual = getDFSActualString(E);
        String expected = "E->C->B->A->F->G->D->H";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_6() {
        setDefaultGraph();
        String actual = getDFSActualString(F);
        String expected = "F->A->B->C->D->G->H->E";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_7() {
        setDefaultGraph();
        String actual = getDFSActualString(G);
        String expected = "G->D->B->A->F->C->E->H";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_8() {
        setDefaultGraph();
        String actual = getDFSActualString(H);
        String expected = "H->E->C->B->A->F->G->D";
        assertEquals(expected,actual);
    }
}
