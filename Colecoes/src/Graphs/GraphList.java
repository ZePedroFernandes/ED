package Graphs;

import ADTs.GraphADT;
import java.util.Iterator;
import lists.LinkedList;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> the type of the vertices
 */
public class GraphList<T> implements GraphADT<T> {

    protected final int DEFAUL_CAPACITY = 10;
    protected LinkedList<T>[] adjList;
    protected int numVertices;
    protected T[] vertices;

    public GraphList() {
        this.adjList = (LinkedList<T>[]) new Object[DEFAUL_CAPACITY];
        this.numVertices = 0;
        this.vertices = (T[]) new Object[DEFAUL_CAPACITY];
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

}
