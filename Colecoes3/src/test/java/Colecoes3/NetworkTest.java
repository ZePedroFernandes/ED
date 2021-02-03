package Colecoes3;

import graphs.Network;
import graphs.Vertex;
import org.junit.jupiter.api.*;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetworkTest {
    static final Vertex A = new Vertex("A", 3);
    static final Vertex B = new Vertex("B", 3);
    static final Vertex C = new Vertex("C", 3);
    static final Vertex D = new Vertex("D", 3);
    static final Vertex E = new Vertex("E", 3);
    static final Vertex F = new Vertex("F", 3);
    static final Vertex G = new Vertex("G", 3);
    static final Vertex H = new Vertex("H", 3);
    static Network<Vertex> network;

    @BeforeEach
    public void setUp() {
        network = new Network<>();
    }

    public void addVertices(){
        network.addVertex(A);
        network.addVertex(B);
        network.addVertex(C);
        network.addVertex(D);
        network.addVertex(E);
        network.addVertex(F);
        network.addVertex(G);
        network.addVertex(H);
    }

    public void setDefaultNetwork() {
        addVertices();

        network.addEdge(A, B);
        network.addEdge(A, F);

        network.addEdge(B, C);
        network.addEdge(B, D);
        network.addEdge(F, G);

        network.addEdge(C, D);
        network.addEdge(D, G);

        network.addEdge(G, H);
        network.addEdge(C, E);
        network.addEdge(H, E);
    }

    public void setDefaultNetwork2(){
        addVertices();

        network.addEdge(A, B,2);
        network.addEdge(A, F);

        network.addEdge(B, C,2);
        network.addEdge(B, D);
        network.addEdge(F, G);

        network.addEdge(C, D);
        network.addEdge(D, G);

        network.addEdge(G, H);
        network.addEdge(C, E,2);
        network.addEdge(H, E);
    }

    public void setDefaultNetwork3(){
        addVertices();

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
    }

    private String getBFSActualString(Vertex vertex) {
        Iterator<Vertex> itr = network.iteratorBFS(vertex);
        return buildString(itr);
    }

    private String getDFSActualString(Vertex vertex) {
        Iterator<Vertex> itr = network.iteratorDFS(vertex);
        return buildString(itr);
    }

    private String getShortestPathActualString(Vertex vertex1, Vertex vertex2){
        Iterator<Vertex> itr = network.iteratorShortestPath(vertex1,vertex2);
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
        setDefaultNetwork();
        String actual = getBFSActualString(A);
        String expected = "A->B->F->C->D->G->E->H";
        assertEquals(expected,actual);
    }

    @Test
    public void test_BFS_2() {
        setDefaultNetwork();
        String actual = getBFSActualString(B);
        String expected = "B->A->C->D->F->E->G->H";
        assertEquals(expected,actual);
    }

    @Test
    public void test_BFS_3() {
        setDefaultNetwork();
        String actual = getBFSActualString(C);
        String expected = "C->B->D->E->A->G->H->F";
        assertEquals(expected,actual);
    }

    @Test
    public void test_BFS_4() {
        setDefaultNetwork();
        String actual = getBFSActualString(D);
        String expected = "D->B->C->G->A->E->F->H";
        assertEquals(expected,actual);
    }

    @Test
    public void test_BFS_5() {
        setDefaultNetwork();
        String actual = getBFSActualString(E);
        String expected = "E->C->H->B->D->G->A->F";
        assertEquals(expected,actual);
    }

    @Test
    public void test_BFS_6() {
        setDefaultNetwork();
        String actual = getBFSActualString(F);
        String expected = "F->A->G->B->D->H->C->E";
        assertEquals(expected,actual);
    }

    @Test
    public void test_BFS_7() {
        setDefaultNetwork();
        String actual = getBFSActualString(G);
        String expected = "G->D->F->H->B->C->A->E";
        assertEquals(expected,actual);
    }

    @Test
    public void test_BFS_8() {
        setDefaultNetwork();
        String actual = getBFSActualString(H);
        String expected = "H->E->G->C->D->F->B->A";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_1() {
        setDefaultNetwork();
        String actual = getDFSActualString(A);
        String expected = "A->B->C->D->G->F->H->E";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_2() {
        setDefaultNetwork();
        String actual = getDFSActualString(B);
        String expected = "B->A->F->G->D->C->E->H";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_3() {
        setDefaultNetwork();
        String actual = getDFSActualString(C);
        String expected = "C->B->A->F->G->D->H->E";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_4() {
        setDefaultNetwork();
        String actual = getDFSActualString(D);
        String expected = "D->B->A->F->G->H->E->C";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_5() {
        setDefaultNetwork();
        String actual = getDFSActualString(E);
        String expected = "E->C->B->A->F->G->D->H";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_6() {
        setDefaultNetwork();
        String actual = getDFSActualString(F);
        String expected = "F->A->B->C->D->G->H->E";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_7() {
        setDefaultNetwork();
        String actual = getDFSActualString(G);
        String expected = "G->D->B->A->F->C->E->H";
        assertEquals(expected,actual);
    }

    @Test
    public void test_DFS_8() {
        setDefaultNetwork();
        String actual = getDFSActualString(H);
        String expected = "H->E->C->B->A->F->G->D";
        assertEquals(expected,actual);
    }

    @Test
    public void test_ShortestPath_1(){
        setDefaultNetwork();
        String actual = getShortestPathActualString(A,E);
        String expected = "A->B->C->E";
        assertEquals(expected,actual);
    }

    @Test
    public void test_ShortestPath_2(){
        setDefaultNetwork2();
        String actual = getShortestPathActualString(A,E);
        String expected = "A->F->G->H->E";
        assertEquals(expected,actual);
    }

    @Test
    public void test_ShortestPath_3(){
        addVertices();

        network.addEdge(A, B,2);
        network.addEdge(A, F,3);

        network.addEdge(B, C,2);
        network.addEdge(B, D);
        network.addEdge(F, G);

        network.addEdge(C, D,4);
        network.addEdge(D, G);

        network.addEdge(G, H,5);
        network.addEdge(C, E,2);
        network.addEdge(H, E,2);

        String actual = getShortestPathActualString(F,C);
        String expected = "F->G->D->B->C";
        assertEquals(expected,actual);
    }

    @Test
    public void test_ShortestPath_4(){
        addVertices();

        network.addEdge(A, B,2);
        network.addEdge(A, F,3);

        network.addEdge(B, C,2);
        network.addEdge(B, D);
        network.addEdge(F, G);

        network.addEdge(C, D,4);
        network.addEdge(D, G);

        network.addEdge(G, H,1);
        network.addEdge(C, E,2);
        network.addEdge(H, E,2);

        String actual = getShortestPathActualString(E,D);
        String expected = "E->H->G->D";
        assertEquals(expected,actual);
    }

    @Test
    public void test_ShortestPath_5(){
        setDefaultNetwork3();

        String actual = getShortestPathActualString(G,D);
        String expected = "G->H->E->C->B->D";
        assertEquals(expected,actual);
    }
}
