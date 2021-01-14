package Graphs;

import ADTs.GraphADT;

import java.util.Iterator;

import lists.LinkedList;

/**
 * @param <T> the type of the vertices
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class GraphList<T> implements GraphADT<T> {

    protected final int DEFAUL_CAPACITY = 2;
    protected LinkedList<T>[] adjList;
    protected int numVertices;
    protected T[] vertices;

    @SuppressWarnings("unchecked")
    public GraphList() {
        this.adjList = new LinkedList[DEFAUL_CAPACITY];
        this.numVertices = 0;
        this.vertices = (T[]) new Object[DEFAUL_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] largerVertices = (T[]) new Object[vertices.length * 2];
        LinkedList<T>[] largerAdjList = new LinkedList[vertices.length * 2];

        System.arraycopy(vertices, 0, largerVertices, 0, numVertices);
        System.arraycopy(adjList, 0, largerAdjList, 0, numVertices);

        vertices = largerVertices;
        adjList = largerAdjList;
    }

    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }
        vertices[numVertices] = vertex;
        adjList[numVertices] = new LinkedList<>(vertex);
        numVertices++;
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
    public Iterator<T> iteratorBFS(T startVertex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<T> iteratorDFS(T startVertex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        return numVertices == 0;
    }

    @Override
    public boolean isConnected() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        return numVertices;
    }

}
