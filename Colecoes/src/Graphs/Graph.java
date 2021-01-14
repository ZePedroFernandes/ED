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
     * Creates an empty graph.
     */
    public Graph() {
        numVertices = 0;
        adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    private boolean indexIsValid(int index) {
        return ((index < numVertices) && (index >= 0));
    }

    private int getIndex(T targetVertex) {
        for (int i = 0; i < numVertices; i++) {
            if (this.vertices[i].equals(targetVertex)) {
                return i;
            }
        }

        return -1;
    }

    public void addEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
        }
    }

    @Override
    public void addEdge(T vertex1, T vertex2) {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    private void expandCapacity() {
        T[] expandedVertices = (T[]) new Object[vertices.length * 2];
        boolean[][] expandedMatrix = new boolean[vertices.length * 2][vertices.length * 2];

        for (int i = 0; i < vertices.length; i++) {

            for (int j = 0; j < vertices.length; j++) {
                expandedMatrix[i][j] = adjMatrix[i][j];
            }

            expandedVertices[i] = vertices[i];
        }
        vertices = expandedVertices;
        adjMatrix = expandedMatrix;
    }

    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }
        vertices[numVertices] = vertex;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
    }

    @Override
    public void removeVertex(T vertex) {
        removeVertex(getIndex(vertex));
    }

    public void removeVertex(int index) {
        if (indexIsValid(index)) {
            this.numVertices--;

            for (int i = index; i < this.numVertices; i++) {
                this.vertices[i] = this.vertices[i + 1];
            }

            for (int i = index; i < this.numVertices; i++) {
                for (int j = 0; j <= this.numVertices; j++) {
                    adjMatrix[i][j] = adjMatrix[i + 1][j];
                }
            }
            //Lines shifted

            for (int i = index; i < this.numVertices; i++) {
                for (int j = 0; j < this.numVertices; j++) {
                    adjMatrix[j][i] = adjMatrix[j][i + 1];
                }
            }
            //Columes shifted

        }
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
