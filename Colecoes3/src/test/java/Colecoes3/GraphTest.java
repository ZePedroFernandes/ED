package Colecoes3;

import graphs.Graph;
import graphs.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    static final Vertex A = new Vertex("A", 3);
    static final Vertex B = new Vertex("B", 3);
    static final Vertex C = new Vertex("C", 3);
    static final Vertex D = new Vertex("D", 3);
    static final Vertex E = new Vertex("E", 3);
    static final Vertex F = new Vertex("F", 3);
    static final Vertex G = new Vertex("G", 3);
    static final Vertex H = new Vertex("H", 3);
    static Graph<Vertex> graph;

    @BeforeEach
    public void setUp() {
        graph = new Graph<>();
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
    public void test_connected_1(){
        setDefaultGraph();
        assertTrue(graph.isConnected());
    }

    @Test
    public void test_connected_2(){
        assertFalse(graph.isConnected());
    }

    @Test
    public void test_connected_3(){
        graph.addVertex(A);
        assertTrue(graph.isConnected());
    }

    @Test
    public void test_connected_4(){
        graph.addVertex(A);
        graph.addVertex(B);
        assertFalse(graph.isConnected());
    }

    @Test
    public void test_connected_5(){
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addEdge(A,B);
        graph.addVertex(C);
        assertFalse(graph.isConnected());
    }

    @Test
    public void test_connected_6(){
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addEdge(A,B);
        assertTrue(graph.isConnected());
    }

    @Test
    public void test_connected_7(){
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);
        graph.addVertex(F);
        graph.addVertex(G);
        graph.addVertex(H);

        graph.addEdge(A, B);
        //graph.addEdge(A, F);

        graph.addEdge(B, C);
        graph.addEdge(B, D);
        graph.addEdge(F, G);

        graph.addEdge(C, D);
        //graph.addEdge(D, G);

        graph.addEdge(G, H);
        graph.addEdge(C, E);
        //graph.addEdge(H, E);

        assertFalse(graph.isConnected());
    }

    @Test
    public void test_connected_8(){
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addEdge(A,B);
        graph.addEdge(A,C);

        assertTrue(graph.isConnected());
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
    public void test_6(){
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);
        graph.addVertex(F);

        graph.addEdge(A, B);
        graph.addEdge(A, C);

        Iterator<Vertex> itr = graph.iteratorShortestPath(A,E);
        Iterator<Vertex> itr2 = graph.iteratorShortestPath(C,E);
        assertFalse(itr.hasNext());
        assertFalse(itr2.hasNext());
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
        StringBuilder actual = new StringBuilder();
        while (itr.hasNext()) {
            actual.append(itr.next().getName());
            if (itr.hasNext()) {
                actual.append("->");
            }
        }
        return actual.toString();
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
