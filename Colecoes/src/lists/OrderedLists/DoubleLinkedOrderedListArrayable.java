/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists.OrderedLists;

import nodes.DoubleLinkedNode;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class DoubleLinkedOrderedListArrayable<T> extends DoubleLinkedOrderedList<T> {

    public DoubleLinkedOrderedListArrayable() {
        super();
    }

    public T[] toArray() {
        T[] result = (T[]) new Object[this.size];

        DoubleLinkedNode<T> current = this.head.getNext();

        for (int i = 0; i < this.size; i++) {
            result[i] = current.getElement();
            current = current.getNext();
        }
        return result;
    }
    
}
