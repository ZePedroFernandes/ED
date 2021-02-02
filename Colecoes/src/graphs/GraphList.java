package graphs;

import ADTs.GraphADT;

import java.util.Iterator;

import exceptions.EmptyException;
import lists.LinkedList;
import lists.OrderedLists.ArrayList;
import lists.unorderedLists.ArrayUnorderedList;
import queues.LinkedQueue;
import stacks.LinkedStack;

/**
 * @param <T> the type of the vertices
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class GraphList<T> implements GraphADT<T> {

    protected final int DEFAUL_CAPACITY = 4;
    protected LinkedList<Integer>[] adjList;
    protected int numVertices;
    protected T[] vertices;

    public GraphList() {
        this.adjList = new LinkedList[DEFAUL_CAPACITY];
        this.numVertices = 0;
        this.vertices = (T[]) new Object[DEFAUL_CAPACITY];
    }

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
        return ((index < numVertices) && (index >= 0));
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
        removeEdge(getIndex(vertex1), getIndex(vertex2));
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
        return this.iteratorBFS(getIndex(startVertex));
    }

    public Iterator<T> iteratorBFS(int startIndex) {
        LinkedQueue<Integer> transversalQueue = new LinkedQueue<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();

        if (!isValidIndex(startIndex)) {
            return resultList.iterator(); // Return statment
        }

        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }
        Integer x = startIndex;
        transversalQueue.enqueue(x);
        visited[x] = true;

        while (!transversalQueue.isEmpty()) {
            x = transversalQueue.dequeue();
            resultList.addToRear(this.vertices[x]);

            for (int i = 0; i < this.numVertices; i++) {
                if (!visited[i] && this.adjList[x].contains(i)) {
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
        LinkedStack<Integer> traversalStack = new LinkedStack<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();

        if (!isValidIndex(startIndex)) {
            return resultList.iterator(); // Return statement
        }

        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }
        Integer x = startIndex;
        boolean found;
        traversalStack.push(x);
        resultList.addToRear(this.vertices[startIndex]);
        visited[x] = true;

        while (!traversalStack.isEmpty()) {
            x = traversalStack.peek();
            found = false;

            for (int i = 0; i < this.numVertices && !found; i++) {
                if (!visited[i] && this.adjList[x].contains(i)) {
                    traversalStack.push(i);
                    resultList.addToRear(this.vertices[i]);
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
        return iteratorShortestPath(this.getIndex(startVertex), this.getIndex(targetVertex));
    }

    public Iterator<T> iteratorShortestPath(int startIndex, int targetIndex) {
        int index = startIndex;
        int[] predecessor = new int[numVertices];
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();

        if (!isValidIndex(startIndex) || !isValidIndex(targetIndex)
                || (startIndex == targetIndex)) {
            return resultList.iterator();
        }

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
                if (!visited[i] && this.adjList[index].contains(i)) {
                    predecessor[i] = index;
                    traversalQueue.enqueue(i);
                    visited[i] = true;
                }
            }
        }
        if (index != targetIndex) // there is no possible path
        {
            return resultList.iterator();
        }

        resultList.addToFront(vertices[index]);

        while(index != startIndex) {
            index = predecessor[index];
            resultList.addToFront(vertices[index]);
        }

        return resultList.iterator();
    }

    @Override
    public boolean isEmpty() {
        return numVertices == 0;
    }

    @Override
    public boolean isConnected() {
        Integer index;
        LinkedQueue<Integer> transversalQueue = new LinkedQueue<>();

        if (!isEmpty()) {
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
            index = transversalQueue.dequeue();

            for (int i = 0; i < numVertices; i++) {
                if (!visited[i] && this.adjList[index].contains(i)) {
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
        return numVertices;
    }

    @Override
    public String toString() {
        if (numVertices == 0) {
            return "Graph is empty";
        }
        StringBuilder s = new StringBuilder("\nVertex Values\n");
        s.append("-------------------------------\n");
        s.append("index\tvalue\n\n");

        for (int i = 0; i < this.numVertices - 1; i++) {
            s.append(i).append("\t\t").append(this.vertices[i].toString()).append("\n");
        }
        s.append(this.numVertices - 1).append("\t\t").append(this.vertices[this.numVertices - 1].toString()).append("\n\n");

        s.append("-------------------------------\n");
        s.append("-------------------------------\n");
        s.append("\nAdjencyList\n");
        s.append("-------------------------------\n");

        for (int i = 0; i < this.numVertices - 1; i++) {
            s.append(i);
            Iterator<Integer> itr = this.adjList[i].iterator();
            while (itr.hasNext()) {
                s.append(" -> ").append(itr.next());
            }

            s.append("\n");
        }

        s.append(this.numVertices - 1);
        Iterator<Integer> itr = this.adjList[this.numVertices - 1].iterator();
        while (itr.hasNext()) {
            s.append(" -> ").append(itr.next());
        }
        s.append("\n");

        return s.toString();
    }

}
