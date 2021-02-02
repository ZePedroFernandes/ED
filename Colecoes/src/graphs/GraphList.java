package graphs;

import ADTs.GraphADT;

import java.util.Iterator;

import exceptions.EmptyException;
import lists.LinkedList;

/**
 * @param <T> the type of the vertices
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class GraphList<T> implements GraphADT<T> {

    protected final int DEFAUL_CAPACITY = 2;
    protected LinkedList<Integer>[] adjList;
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
        LinkedList<Integer>[] largerAdjList = new LinkedList[vertices.length * 2];

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
        adjList[numVertices] = new LinkedList<>();
        numVertices++;
    }

    private boolean isValidIndex(int index) {
        return (index < numVertices) && (index >= 0);
    }

    private int getIndex(T vertex) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void removeVertex(T vertex) {
        int index = getIndex(vertex);
        removeVertex(index);

    }

    public void removeVertex(int index) {
        if (isValidIndex(index)) {
            for (int i = index; i < numVertices; i++) {
                vertices[i] = vertices[i + 1];
                adjList[i] = adjList[i + 1];
            }
            numVertices--;
        }
    }

    @Override
    public void addEdge(T vertex1, T vertex2) {
        this.addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    protected void addEdge(int index1, int index2) {
        if (this.isValidIndex(index1) && this.isValidIndex(index2)) {
            this.adjList[index1].add(index2);
            this.adjList[index2].add(index1);
        }
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        removeEdge(getIndex(vertex1),getIndex(vertex2));
    }

    protected void removeEdge(int vertex1, int vertex2) {
        if (isValidIndex(vertex1) && isValidIndex(vertex2)) {
            try {
                this.adjList[vertex1].remove(vertex2);
                this.adjList[vertex2].remove(vertex1);
            } catch (EmptyException ignored) {
            }
        }
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


    @Override
    public String toString() {
        if (numVertices == 0) {
            return "Graph is empty";
        }
        String s = "\nVertex Values\n";
        s += "-------------------------------\n";
        s += "index\tvalue\n\n";

        for (int i = 0; i < this.numVertices - 1; i++) {
            s += i + "\t\t" + this.vertices[i].toString() + "\n";
        }
        s += (this.numVertices - 1) + "\t\t" + this.vertices[this.numVertices - 1].toString() + "\n\n";

        s += "-------------------------------\n";
        s += "-------------------------------\n";
        s += "\nAdjencyList\n";
        s += "-------------------------------\n";

        for (int i = 0; i < this.numVertices - 1; i++) {
            s += i;
            Iterator itr = this.adjList[i].iterator();
            while (itr.hasNext()) {
                s += " -> " + itr.next();
            }

            s += "\n";
        }

        s += (this.numVertices - 1);
        Iterator itr = this.adjList[this.numVertices - 1].iterator();
        while (itr.hasNext()) {
            s += " -> " + itr.next();
        }
        s += "\n";

        return s;
    }

}
