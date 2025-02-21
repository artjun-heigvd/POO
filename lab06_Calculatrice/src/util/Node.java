package util;
/**
 * This represents a generic node in a linked structure.
 * It is designed to hold data of a specified type, along
 * with a reference to the next node in the structure.
 *
 * @param <T> The type of the data to be stored within the node.
 */
public class Node<T> {

     T data;
     Node<T> next;

    /**
     * Creates a new node with the provided data and the reference
     * to the next node.
     *
     * @param data The data to be stored within the node.
     * @param next The next node in the linked structure or
     *              {@code null} if this is the last node.
     */
    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

}
