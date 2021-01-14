package Graphs;

import ADTs.GraphADT;
import java.util.Iterator;
import lists.unorderedLists.ArrayUnorderedList;
import queues.LinkedQueue;
import stacks.LinkedStack;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class GraphMatrix<T> implements GraphADT<T> {

    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices;   // number of vertices in the graph 
    protected boolean[][] adjMatrix;   // adjacency matrix 
    protected T[] vertices;   // values of vertices

    /**
     * Creates an empty graph.
     */
    @SuppressWarnings("unchecked")
    public GraphMatrix() {
        numVertices = 0;
        adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    private boolean isValidIndex(int index) {
        return (index < numVertices) && (index >= 0);
    }

    private int getIndex(T targetVertex) {
        for (int i = 0; i < numVertices; i++) {
            if (this.vertices[i].equals(targetVertex)) {
                return i;
            }
        }

        return -1;
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

    public void addEdge(int index1, int index2) {
        if (isValidIndex(index1) && isValidIndex(index2)) {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
        }
    }

    @Override
    public void addEdge(T vertex1, T vertex2) {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    @SuppressWarnings("unchecked")
    private void expandCapacity() {
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
    public void removeVertex(T vertex) {
        removeVertex(getIndex(vertex));
    }

    public void removeVertex(int index) {
        if (isValidIndex(index)) {
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
        removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    public void removeEdge(int index1, int index2) {
        if (isValidIndex(index1) && isValidIndex(index2)) {
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

        if (!isValidIndex(startIndex)) {
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

        if (!isValidIndex(startIndex)) {
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
        return (iteratorShortestPath(getIndex(startVertex), getIndex(targetVertex)));
    }

    public Iterator<T> iteratorShortestPath(int startIndex, int targetIndex) {
        Integer x;
        LinkedQueue<Integer> transversalQueue = new LinkedQueue<>();
        LinkedStack<Pair<Integer, Integer>> pairs = new LinkedStack<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();

        if (!isValidIndex(startIndex) || !isValidIndex(targetIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[this.numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        transversalQueue.enqueue(startIndex);
        visited[startIndex] = true;
        
        while (!transversalQueue.isEmpty() && !transversalQueue.first().equals(targetIndex)) {
            x = transversalQueue.dequeue();

            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x][i] && !visited[i]) {
                    transversalQueue.enqueue(i);
                    pairs.push(new Pair<>(x,i));
                    visited[i] = true;
                }
            }
        }
        Pair<Integer, Integer> pair;
        Integer destination = targetIndex;
        
        while(destination != startIndex){
            pair = pairs.pop();
            if(pair.end.equals(destination)){
                destination = pair.start;
                resultList.addToFront(vertices[pair.start]);
            }
        }
        if(!resultList.isEmpty()){
            resultList.addToRear(vertices[targetIndex]);
        }
        
        return resultList.iterator();
    }

    @Override
    public boolean isEmpty() {
        return this.numVertices == 0;
    }

    @Override
    public boolean isConnected() {
        Integer x;
        LinkedQueue<Integer> transversalQueue = new LinkedQueue<>();

        if (!isEmpty() && size() == 1) {
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
        result.append("index\t");

        for (int i = 0; i < numVertices; i++) {
            result.append("").append(i);
            if (i < 10) {
                result.append(" ");
            }
        }
        result.append("\n\n");

        for (int i = 0; i < numVertices; i++) {
            result.append("").append(i).append("\t");

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
        result.append("index\tvalue\n\n");

        for (int i = 0; i < numVertices; i++) {
            result.append("").append(i).append("\t");
            result.append(vertices[i].toString()).append("\n");
        }
        result.append("\n");
        return result.toString();
    }
}
