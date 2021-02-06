package lists.OrderedLists;

import exceptions.InvalidElementException;
import lists.LinkedList;
import lists.LinkedNode;

public class LinkedOrderedList<T> extends LinkedList<T> {

    /**
     * Construct's an instance of {@link LinkedList}
     */
    public LinkedOrderedList() {
    }

    public LinkedOrderedList(T element) {
        super(element);
    }

    private void addFirst(LinkedNode<T> newNode) {
        this.head = newNode;
        this.tail = newNode;
        this.count++;
    }

    /**
     * Adds a node after another node
     */
    private void addAfter(LinkedNode<T> newNode, LinkedNode<T> currentNode){
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        this.count++;
    }

    @SuppressWarnings("unchecked")
    public void add(T element) throws InvalidElementException {

        if (element == null) {
            throw new InvalidElementException("null element");
        }

        if (element instanceof Comparable) {
            Comparable<T> comparableElem = (Comparable<T>) element;
            LinkedNode<T> newNode = new LinkedNode<>(element);
            if (this.isEmpty()) {
                addFirst(newNode);
                return;
            }

            if(comparableElem.compareTo(this.head.getElement()) >=0){
                replaceHead(newNode);
                return;
            }

            LinkedNode<T> currentNode = this.head;

            while (currentNode.getNext() != null) {
                if(comparableElem.compareTo(currentNode.getNext().getElement()) >= 0){
                    addAfter(newNode,currentNode);
                    return;
                }
                currentNode = currentNode.getNext();
            }
            this.tail.setNext(newNode);
            this.tail = newNode;
            this.count++;
        }
    }

    private void replaceHead(LinkedNode<T> node) {
        LinkedNode<T> prevHead = this.head;
        this.head = node;
        this.head.setNext(prevHead);
        this.count++;
    }
}
