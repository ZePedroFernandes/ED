package trees;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class HeapNode<T> extends  BinaryTreeNode<T>{
    protected HeapNode<T> parent;
    
    public HeapNode(T element){
        super(element);
        parent = null;
    }
}
