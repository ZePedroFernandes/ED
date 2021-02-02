package graphs;

import ADTs.NetworkADT;

import java.util.Iterator;

public class Network<T> implements NetworkADT<T> {

    final int DEFAULT_CAPACITY = 10;
    protected int numVertices;
    protected T[] vertices;
    protected int[][] adjMatrix;
    protected int DEFAULT_WEIGHT = 1;

    @SuppressWarnings("unchecked")
    public Network() {
        this.numVertices = 0;
        this.vertices = (T[]) new Object[DEFAULT_CAPACITY];
        this.adjMatrix = new int[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public void expandCapacity() {
        T[] expandedVertices = (T[]) new Object[this.numVertices * 2];
        int[][] expandedMatrix = new int[this.numVertices * 2][this.numVertices * 2];

        for (int i = 0; i < vertices.length; i++) {

            System.arraycopy(adjMatrix[i], 0, expandedMatrix[i], 0, vertices.length);

            expandedVertices[i] = vertices[i];
        }

        this.vertices = expandedVertices;
        this.adjMatrix = expandedMatrix;
    }

    private boolean isValidIndex(int index) {
        return ((index < numVertices) && (index >= 0));
    }

    private int getIndex(T vertex) {
        for (int i = 0; i < this.numVertices; i++) {
            if (this.vertices[i].equals(vertex)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Adds a vertex to this graph, associating object with vertex.
     *
     * @param vertex the vertex to be added to this graph
     */
    @Override
    public void addVertex(T vertex) {
        if (this.vertices.length == this.numVertices) {
            expandCapacity();
        }

        this.vertices[this.numVertices] = vertex;

        for (int i = 0; i < this.numVertices; i++) {
            this.adjMatrix[this.numVertices][i] = 0;
            this.adjMatrix[i][this.numVertices] = 0;
        }

        this.numVertices++;
    }

    /**
     * Removes a single vertex with the given value from this graph.
     *
     * @param vertex the vertex to be removed from this graph
     */
    @Override
    public void removeVertex(T vertex) {
        removeVertex(this.getIndex(vertex));
    }

    protected void removeVertex(int index) {
        if (isValidIndex(index)) {
            this.numVertices--;
            for (int i = index; i < numVertices; i++) {
                this.vertices[i] = this.vertices[i + 1];
            }

            for(int i = index; i < numVertices; i++){
                for(int j = 0; j < numVertices; j++){
                    this.adjMatrix[i][j] = this.adjMatrix[i+1][j];
                    this.adjMatrix[j][i] = this.adjMatrix[j][i+1];
                }
            }
        }
    }

    /**
     * Inserts an edge between two vertices of this graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    @Override
    public void addEdge(T vertex1, T vertex2) {

    }

    /**
     * Removes an edge between two vertices of this graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    @Override
    public void removeEdge(T vertex1, T vertex2) {

    }

    /**
     * Returns a breadth first iterator starting with the given vertex.
     *
     * @param startVertex the starting vertex
     * @return a breadth first iterator beginning at the given vertex
     */
    @Override
    public Iterator<T> iteratorBFS(T startVertex) {
        return null;
    }

    /**
     * Returns a depth first iterator starting with the given vertex.
     *
     * @param startVertex the starting vertex
     * @return a depth first iterator starting at the given vertex
     */
    @Override
    public Iterator<T> iteratorDFS(T startVertex) {
        return null;
    }

    /**
     * Returns an iterator that contains the shortest path between the two
     * vertices.
     *
     * @param startVertex  the starting vertex
     * @param targetVertex the ending vertex
     * @return an iterator that contains the shortest path between the two
     * vertices
     */
    @Override
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) {
        return null;
    }

    /**
     * Returns true if this graph is empty, false otherwise.
     *
     * @return true if this graph is empty
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns true if this graph is connected, false otherwise.
     *
     * @return true if this graph is connected
     */
    @Override
    public boolean isConnected() {
        return false;
    }

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the integer number of vertices in this graph
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Inserts an edge between two vertices of this graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @param weight  the weight
     */
    @Override
    public void addEdge(T vertex1, T vertex2, double weight) {

    }

    /**
     * Returns the weight of the shortest path in this network.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return the weight of the shortest path in this network
     */
    @Override
    public double shortestPathWeight(T vertex1, T vertex2) {
        return 0;
    }
}
