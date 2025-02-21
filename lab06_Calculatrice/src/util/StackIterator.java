package util;

/**
 * Generic stack iterator, used for the generic stack implementation.
 * @param <T> the type of elements in the stack
 */
public class StackIterator<T> {

    private Node<T> current;

    /**
     * Checks if there is a next element in the iterator.
     * @return true if there is a next element, false otherwise.
     */
    public boolean hasNext() {
        return (current.next != null);
    }

    /**
     * Returns the data of the next element of the iterator and advances it.
     * @return the data of the next element of the iterator.
     */
    public T next() {
        current = current.next;
        return current.data;
    }

    /**
     * Constructs a StackIterator object with the given node.
     * @param current the node
     */
    public StackIterator(Node<T> current) {
        this.current = current;
    }
}