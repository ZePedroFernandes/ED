package graphs;

import ADTs.NetworkADT;
import exceptions.EmptyCollectionException;
import lists.unorderedLists.ArrayUnorderedList;
import queues.LinkedQueue;
import stacks.LinkedStack;
import trees.LinkedHeap;

import java.util.Iterator;

public class Network<T> extends Graph<T> implements NetworkADT<T> {

    protected double[][] adjMatrix;
    protected double DEFAULT_WEIGHT = 1;

    public Network() {
        this.numVertices = 0;
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
        this.adjMatrix = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] expandedVertices = (T[]) new Object[this.numVertices * 2];
        double[][] expandedMatrix = new double[this.numVertices * 2][this.numVertices * 2];

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
            this.adjMatrix[this.numVertices][i] = Double.POSITIVE_INFINITY;
            this.adjMatrix[i][this.numVertices] = Double.POSITIVE_INFINITY;
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

    public void removeVertex(int index) {
        if (isValidIndex(index)) {
            this.numVertices--;
            for (int i = index; i < numVertices; i++) {
                this.vertices[i] = this.vertices[i + 1];
            }

            for (int i = index; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    this.adjMatrix[i][j] = this.adjMatrix[i + 1][j];
                    this.adjMatrix[j][i] = this.adjMatrix[j][i + 1];
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
        this.addEdge(vertex1, vertex2, DEFAULT_WEIGHT);
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
        addEdge(getIndex(vertex1), getIndex(vertex2), weight);
    }

    protected void addEdge(int index1, int index2, double weight) {
        if (isValidIndex(index1) && isValidIndex(index2)) {
            this.adjMatrix[index1][index2] = weight;
            this.adjMatrix[index2][index1] = weight;
        }
    }

    /**
     * Removes an edge between two vertices of this graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    @Override
    public void removeEdge(T vertex1, T vertex2) {
        removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    public void removeEdge(int index1, int index2) {
        if (isValidIndex(index1) && isValidIndex(index2)) {
            this.adjMatrix[index1][index2] = Double.POSITIVE_INFINITY;
            this.adjMatrix[index2][index1] = Double.POSITIVE_INFINITY;
        }
    }

    /**
     * Returns a breadth first iterator starting with the given vertex.
     *
     * @param startVertex the starting vertex
     * @return a breadth first iterator beginning at the given vertex
     */
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
                if ((adjMatrix[x][i] < Double.POSITIVE_INFINITY) && !visited[i]) {
                    transversalQueue.enqueue(i);
                    visited[i] = true;
                }
            }
        }

        return resultList.iterator();
    }

    /**
     * Returns a depth first iterator starting with the given vertex.
     *
     * @param startVertex the starting vertex
     * @return a depth first iterator starting at the given vertex
     */
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
                if ((adjMatrix[x][i] < Double.POSITIVE_INFINITY) && !visited[i]) {
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
        Iterator<Integer> indices = iteratorShortestPathIndices(getIndex(startVertex), getIndex(targetVertex));
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        while (indices.hasNext()) {
            resultList.addToRear(vertices[indices.next()]);
        }
        return resultList.iterator();
    }

    public Iterator<Integer> iteratorShortestPathIndices(int startIndex, int targetIndex) {
        int index;
        double weight;
        int[] predecessor = new int[numVertices];
        LinkedHeap<Double> traversalMinHeap = new LinkedHeap<>();
        ArrayUnorderedList<Integer> resultList =
                new ArrayUnorderedList<>();
        LinkedStack<Integer> stack = new LinkedStack<Integer>();

        double[] pathWeight = new double[numVertices];
        for (int i = 0; i < numVertices; i++)
            pathWeight[i] = Double.POSITIVE_INFINITY;

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++)
            visited[i] = false;

        if (!isValidIndex(startIndex) || !isValidIndex(targetIndex) ||
                (startIndex == targetIndex) || isEmpty())
            return resultList.iterator();

        pathWeight[startIndex] = 0;
        predecessor[startIndex] = -1;
        visited[startIndex] = true;
        weight = 0;

        /* Update the pathWeight for each vertex except the
         startVertex. Notice that all vertices not adjacent
         to the startVertex  will have a pathWeight of
         infinity for now. */
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                pathWeight[i] = pathWeight[startIndex] +
                        adjMatrix[startIndex][i];
                predecessor[i] = startIndex;
                traversalMinHeap.addElement(pathWeight[i]);
            }
        }

        do {
            try {
                weight = (traversalMinHeap.removeMin());
            } catch (EmptyCollectionException ignored) {
            }

            traversalMinHeap.removeAllElements();
            if (weight == Double.POSITIVE_INFINITY)  // no possible path
                return resultList.iterator();
            else {
                index = getIndexOfAdjVertexWithWeightOf(visited, pathWeight,
                        weight);
                visited[index] = true;
            }

            /* Update the pathWeight for each vertex that has has not been
             visited and is adjacent to the last vertex that was visited.
             Also, add each unvisited vertex to the heap. */
            for (int i = 0; i < numVertices; i++) {
                if (!visited[i]) {
                    if ((adjMatrix[index][i] < Double.POSITIVE_INFINITY) &&
                            (pathWeight[index] + adjMatrix[index][i]) < pathWeight[i]) {
                        pathWeight[i] = pathWeight[index] + adjMatrix[index][i];
                        predecessor[i] = index;
                    }
                    traversalMinHeap.addElement(pathWeight[i]);
                }
            }
        } while (!traversalMinHeap.isEmpty() && !visited[targetIndex]);

        index = targetIndex;
        stack.push(index);
        do {
            index = predecessor[index];
            stack.push(index);
        } while (index != startIndex);

        while (!stack.isEmpty())
            resultList.addToRear((stack.pop()));

        return resultList.iterator();
    }

    protected int getIndexOfAdjVertexWithWeightOf(boolean[] visited,
                                                  double[] pathWeight, double weight) {
        for (int i = 0; i < numVertices; i++)
            if ((pathWeight[i] == weight) && !visited[i])
                for (int j = 0; j < numVertices; j++)
                    if ((adjMatrix[i][j] < Double.POSITIVE_INFINITY) &&
                            visited[j])
                        return i;

        return -1;  // should never get to here
    }

    /**
     * Returns true if this graph is empty, false otherwise.
     *
     * @return true if this graph is empty
     */
    @Override
    public boolean isEmpty() {
        return this.numVertices == 0;
    }

    /**
     * Returns true if this graph is connected, false otherwise.
     *
     * @return true if this graph is connected
     */
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
                if ((adjMatrix[x][i] < Double.POSITIVE_INFINITY) && !visited[i]) {
                    transversalQueue.enqueue(i);
                    connectedToFirstVertex++;
                    visited[i] = true;
                }
            }
        }

        return (connectedToFirstVertex == numVertices);
    }

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the integer number of vertices in this graph
     */
    @Override
    public int size() {
        return this.numVertices;
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
        Iterator<Integer> indices = iteratorShortestPathIndices(getIndex(vertex1), getIndex(vertex2));
        double result = 0;

        if (!indices.hasNext()) {
            return result;
        }

        Integer index1;
        Integer index2 = indices.next();

        while (indices.hasNext()) {
            index1 = index2;
            index2 = indices.next();
            result += adjMatrix[index1][index2];
        }

        return result;
    }

    public String toString() {
        if (numVertices == 0)
            return "Graph is empty";

        StringBuilder result = new StringBuilder(new String(""));

        // Print the adjacency Matrix
        result.append("Adjacency Matrix\n");
        result.append("----------------\n");
        result.append("index\t");

        for (int i = 0; i < numVertices; i++) {
            result.append(i);
            if (i < 10)
                result.append(" ");
        }
        result.append("\n\n");

        for (int i = 0; i < numVertices; i++) {
            result.append(i).append("\t\t");

            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j] < Double.POSITIVE_INFINITY)
                    result.append("1 ");
                else
                    result.append("0 ");
            }
            result.append("\n");
        }

        /* Print the vertex values */
        result.append("\n\nVertex Values");
        result.append("\n-------------\n");
        result.append("index\tvalue\n\n");

        for (int i = 0; i < numVertices; i++) {
            result.append(i).append("\t\t");
            result.append(vertices[i].toString()).append("\n");
        }

        /* Print the weights of the edges */
        result.append("\n\nWeights of Edges");
        result.append("\n----------------\n");
        result.append("index\tweight\n\n");

        for (int i = 0; i < numVertices; i++) {
            for (int j = numVertices - 1; j > i; j--) {
                if (adjMatrix[i][j] < Double.POSITIVE_INFINITY) {
                    result.append(((Vertex) vertices[i]).getName()).append(" to ").append(((Vertex) vertices[j]).getName()).append("\t");
                    result.append(adjMatrix[i][j]).append("\n");
                }
            }
        }

        return result.toString();
    }
}
