package Graphs;

import ADTs.GraphADT;
import java.util.Iterator;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Graph<T> implements GraphADT<T> {

    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices;   // number of vertices in the graph 
    protected boolean[][] adjMatrix;   // adjacency matrix 
    protected T[] vertices;   // values of vertices

    /**
     * * Creates an empty graph.
     */
    public Graph {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    @Override
    public void addVertex(T vertex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeVertex(T vertex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addEdge(T vertex1, T vertex2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator iteratorBFS(T startVertex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator iteratorDFS(T startVertex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isConnected() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
