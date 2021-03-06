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

    private String getBFSActualString(Vertex vertex) {
        Iterator<Vertex> itr = graph.iteratorBFS(vertex);
        return buildString(itr);
    }

    private String getDFSActualString(Vertex vertex) {
        Iterator<Vertex> itr = graph.iteratorDFS(vertex);
        return buildString(itr);
    }

    private String buildString(Iterator<Vertex> itr) {
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
    public void test_BFS_1() {
        setDefaultGraph();
        String actual = getBFSActualString(A);
        String expected = "A->B->F->C->D->G->E->H";
        assertEquals(expected,actual);
    }

    @Test
    public void test_BFS_2() {
        setDefaultGraph();
        String actual = getBFSActualString(B);
        String expected = "B->A->C->D->F->E->G->H";
        assertEquals(expected,actual);
    }

    @Test
    public void test_BFS_3() {
        setDefaultGraph();
        String actual = getBFSActualString(C);
        String expected = "C->B->D->E->A->G->H->F";
        assertEquals(expected,actual);
    }

    @Test
    public void test_BFS_4() {
        setDefaultGraph();
        String actual = getBFSActualString(D);
        String expected = "D->B->C->G->A->E->F->H";
        assertEquals(expected,actual);
    }

    @Test
    public void test_BFS_5() {
        setDefaultGraph();
        String actual = getBFSActualString(E);
        String expected = "E->C->H->B->D->G->A->F";
        assertEquals(expected,actual);
    }

    @Test
    public void test_BFS_6() {
        setDefaultGraph();
        String actual = getBFSActualString(F);
        String expected = "F->A->G->B->D->H->C->E";
        assertEquals(expected,actual);
    }

    @Test
    public void test_BFS_7() {
        setDefaultGraph();
        String actual = getBFSActualString(G);
        String expected = "G->D->F->H->B->C->A->E";
        assertEquals(expected,actual);
    }

    @Test
    public void test_BFS_8() {
        setDefaultGraph();
        String actual = getBFSActualString(H);
        String expected = "H->E->G->C->D->F->B->A";
        assertEquals(expected,actual);
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

    @Test
    public void test_shortestPath_1() {
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
    public void test_shortestPath_2() {
        graph.addVertex(A);

        Iterator<Vertex> iterator = graph.iteratorShortestPath(A, A);

        assertFalse(iterator.hasNext());
    }

    @Test
    public void test_shortestPath_3() {
        graph.addVertex(A);
        graph.addVertex(B);

        graph.addEdge(A, B);

        Iterator<Vertex> itr = graph.iteratorShortestPath(A, B);

        assertEquals(A, itr.next());
        assertEquals(B, itr.next());
    }

    @Test
    public void test_shortestPath_4() {
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
    public void test_shortestPath_5() {
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
}
