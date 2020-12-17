package trees.heaps;

import trees.BinaryTreeNode;

/**
 * This class represents a priority queue node.
 * 
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 * @param <T> the type of elements in this node.
 */
public class PriorityQueueNode<T> extends BinaryTreeNode<T> implements Comparable<PriorityQueueNode> {

    public static int nextOrder = 0;
    private int priority;
    private int order;

    /**
     * Creates a new PriorityQueueNode with the specified data.
     *
     * @param obj the element of the new priority queue node
     * @param prio the integer priority of the new queue node
     */
    public PriorityQueueNode(T obj, int prio) {
        element = obj;
        priority = prio;
        order = nextOrder;
        nextOrder++;
    }

    /**
     * Returns the priority value for this node.
     *
     * @return the integer priority for this node
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns the order for this node.
     *
     * @return the integer order for this node
     */
    public int getOrder() {
        return order;
    }

    /**
     * Returns a string representation for this node.
     */
    @Override
    public String toString() {
        String temp = (element.toString() + priority + order);
        return temp;
    }

    /**
     * Returns the 1 if the current node has higher priority than the given node
     * and -1 otherwise.
     *
     * @param obj the node to compare to this node
     * @return the integer result of the comparison of the obj node and this one
     */
    @Override
    public int compareTo(PriorityQueueNode obj) {
        int result;
        if (this.priority > obj.getPriority()) {
            result = 1;
        } else if (this.priority < obj.getPriority()) {
            result = -1;
        } else if (this.order > obj.getOrder()) {
            result = 1;
        } else {
            result = -1;
        }
        return result;
    }

}
