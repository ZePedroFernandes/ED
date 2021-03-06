package graphs;

import ADTs.GraphADT;

import java.util.Iterator;

import lists.unorderedLists.ArrayUnorderedList;
import queues.LinkedQueue;
import stacks.LinkedStack;

/**
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
    @SuppressWarnings("unchecked")
    public Graph() {
        numVertices = 0;
        adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    @SuppressWarnings("unchecked")
    protected void expandCapacity() {
        T[] expandedVertices = (T[]) new Object[vertices.length * 2];
        boolean[][] expandedMatrix = new boolean[vertices.length * 2][vertices.length * 2];

        for (int i = 0; i < vertices.length; i++) {

            System.arraycopy(adjMatrix[i], 0, expandedMatrix[i], 0, vertices.length);

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

    protected boolean indexIsValid(int index) {
        return ((index < numVertices) && (index >= 0));
    }

    protected int getIndex(T targetVertex) {
        for (int i = 0; i < numVertices; i++) {
            if (this.vertices[i].equals(targetVertex)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void removeVertex(T vertex) {
        removeVertex(getIndex(vertex));
    }

    public void removeVertex(int index) {
        if (indexIsValid(index)) {
            this.numVertices--;
            if (numVertices - index >= 0)
                System.arraycopy(this.vertices, index + 1, this.vertices, index, numVertices - index);

            for(int i = index; i < numVertices; i++){
                for(int j = 0; j < numVertices; j++){
                    this.adjMatrix[i][j] = this.adjMatrix[i+1][j];
                    this.adjMatrix[j][i] = this.adjMatrix[j][i+1];
                }
            }
        }
    }

    @Override
    public void addEdge(T vertex1, T vertex2) {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    public void addEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
        }
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    public void removeEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = false;
            adjMatrix[index2][index1] = false;
        }
    }

    @Override
    public Iterator<T> iteratorBFS(T startVertex) {
        return iteratorBFS(getIndex(startVertex));
    }

    public Iterator<T> iteratorBFS(int startIndex) {
        Integer x;
        LinkedQueue<Integer> transversalQueue = new LinkedQueue<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[this.numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        transversalQueue.enqueue(startIndex);
        visited[startIndex] = true;

        while (!transversalQueue.isEmpty()) {
            x = transversalQueue.dequeue();
            resultList.addToRear(vertices[x]);

            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x][i] && !visited[i]) {
                    transversalQueue.enqueue(i);
                    visited[i] = true;
                }
            }
        }

        return resultList.iterator();
    }

    @Override
    public Iterator<T> iteratorDFS(T startVertex) {
        return iteratorDFS(getIndex(startVertex));
    }

    public Iterator<T> iteratorDFS(int startIndex) {
        Integer x;
        boolean found;
        LinkedStack<Integer> traversalStack = new LinkedStack<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalStack.push(startIndex);
        resultList.addToRear(vertices[startIndex]);
        visited[startIndex] = true;

        while (!traversalStack.isEmpty()) {
            x = traversalStack.peek();
            found = false;

            for (int i = 0; (i < numVertices) && !found; i++) {
                if (adjMatrix[x][i] && !visited[i]) {
                    traversalStack.push(i);
                    resultList.addToRear(vertices[i]);
                    visited[i] = true;
                    found = true;
                }
            }
            if (!found && !traversalStack.isEmpty()) {
                traversalStack.pop();
            }
        }
        return resultList.iterator();
    }

    @Override
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) {
        Iterator<Integer> indices = iteratorShortestPathIndices(getIndex(startVertex),getIndex(targetVertex));
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        while(indices.hasNext()){
            resultList.addToRear(vertices[indices.next()]);
        }
        return resultList.iterator();
    }

    public Iterator<Integer> iteratorShortestPathIndices(int startIndex, int targetIndex) {
        ArrayUnorderedList<Integer> resultList = new ArrayUnorderedList<>();

        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)
                || (startIndex == targetIndex)) {
            return resultList.iterator();
        }
        int index = startIndex;
        int[] predecessor = new int[numVertices];
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<>();
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(startIndex);
        visited[startIndex] = true;
        predecessor[startIndex] = -1;

        while (!traversalQueue.isEmpty() && (index != targetIndex)) {
            index = (traversalQueue.dequeue());

            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[index][i] && !visited[i]) {
                    predecessor[i] = index;
                    traversalQueue.enqueue(i);
                    visited[i] = true;
                }
            }
        }
        if (index != targetIndex) { // there is no possible path
            return resultList.iterator();
        }

        resultList.addToFront(index);

        while (index != startIndex) {
            index = predecessor[index];
            resultList.addToFront(index);
        }

        return resultList.iterator();
    }

    public int shortestPathLength(T vertex1, T vertex2) {
        return (shortestPathLength(getIndex(vertex1), getIndex(vertex2)));
    }

    public int shortestPathLength(int startIndex, int targetIndex) {
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)) {
            return 0;
        }

        Iterator<Integer> itr = this.iteratorShortestPathIndices(startIndex, targetIndex);
        int size = 0;

        if (!itr.hasNext()) {
            return 0;
        }

        itr.next();

        while (itr.hasNext()) {
            size++;
            itr.next();
        }

        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.numVertices == 0;
    }

    @Override
    public boolean isConnected() {
        Integer x;
        LinkedQueue<Integer> transversalQueue = new LinkedQueue<>();

        if (isEmpty()) {
            return false;
        }

        if (this.size() == 1) {
            return true;
        }

        int connectedToFirstVertex = 1;
        boolean[] visited = new boolean[this.numVertices];

        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        transversalQueue.enqueue(0);
        visited[0] = true;

        while (!transversalQueue.isEmpty()) {
            x = transversalQueue.dequeue();

            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x][i] && !visited[i]) {
                    transversalQueue.enqueue(i);
                    connectedToFirstVertex++;
                    visited[i] = true;
                }
            }
        }

        return (connectedToFirstVertex == numVertices);
    }

    @Override
    public int size() {
        return this.numVertices;
    }

    @Override
    public String toString() {
        if (numVertices == 0) {
            return "Graph is empty";
        }

        StringBuilder result = new StringBuilder();

        result.append("Adjacency Matrix\n");
        result.append("----------------\n");
        result.append("Index\t");

        for (int i = 0; i < numVertices; i++) {
            result.append(i);
            if (i < 10) {
                result.append(" ");
            }
        }
        result.append("\n\n");

        for (int i = 0; i < numVertices; i++) {
            result.append(" ").append(i).append("\t\t");

            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j]) {
                    result.append("1 ");
                } else {
                    result.append("0 ");
                }
            }
            result.append("\n");
        }

        result.append("\n\nVertex Values");
        result.append("\n-------------\n");
        result.append("Index\ttoString\n\n");

        for (int i = 0; i < numVertices; i++) {
            result.append(i).append("\t\t");
            result.append(vertices[i].toString());
            if(i < numVertices - 1){
                result.append("\n");
            }
        }
        return result.toString();
    }
}
