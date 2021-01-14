package zmain;

import java.util.Iterator;
import trees.LinkedBinarySearchTree;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Tree_Tests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<>();
        
        tree.addElement(3);
        
        System.out.print("Pre Order: [");
        Iterator<Integer> itrPreOrder = tree.iteratorPreOrder();
        while(itrPreOrder.hasNext()){
            System.out.print(itrPreOrder.next());
            if(itrPreOrder.hasNext()){
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        System.out.print("In Order: [");
        Iterator<Integer> itrInOrder = tree.iteratorInOrder();
        while(itrInOrder.hasNext()){
            System.out.print(itrInOrder.next());
            if(itrInOrder.hasNext()){
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        System.out.print("Post Order: [");
        Iterator<Integer> itrPostOrder = tree.iteratorPostOrder();
        while(itrPostOrder.hasNext()){
            System.out.print(itrPostOrder.next());
            if(itrPostOrder.hasNext()){
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        System.out.print("Level Order: [");
        Iterator<Integer> itrLevelOrder = tree.iteratorLevelOrder();
        while(itrLevelOrder.hasNext()){
            System.out.print(itrLevelOrder.next());
            if(itrLevelOrder.hasNext()){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
}
