package util;

import java.util.EmptyStackException;

/**
 * Generic stack data structure implementation.
 * @param <T> the type of elements in the stack
 */
public class Stack<T> {

    private Node<T> stackTop;
    private int size;

    /**
     * Constructs an empty stack.
     */
    public Stack() {
        stackTop = null;
        size = 0;
    }

    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise.
     */
    public boolean empty() {
        return stackTop == null;
    }

    /**
     * Pushes an element onto the top of the stack.
     * @param data the element to be pushed.
     */
    public void push(T data) {
        stackTop = new Node<>(data, stackTop);
        size++;
    }

    /**
     * Removes and returns the element at the top of the stack.
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T pop() throws EmptyStackException {
        if (this.empty()) {
            throw new EmptyStackException();
        }
        T tmp = stackTop.data;
        stackTop = stackTop.next;
        size--;
        return tmp;
    }

    /**
     * Removes all elements from the stack.
     */
    public void clear() {
        stackTop = null;
        size = 0;
        //Garbage collector will do the rest...
    }

    /**
     * @return a string representation of the stack
     */
    public String toString() {
        if (stackTop == null) {
            return "";
        }

        StackIterator<T> it = new StackIterator<T>(stackTop);
        StringBuilder res = new StringBuilder(stackTop.data.toString() + " ");

        while (it.hasNext()) {
            res.append(it.next().toString());
            if (it.hasNext()) res.append(" ");
        }
        return res.toString();
    }

    /**
     * @return an array containing all elements in the stack from top to bottom.
     */
    public Object[] array() {
        if (this.empty()) {
            return new Object[size];
        }

        Object[] tmp = new Object[size];
        tmp[0] = stackTop.data;
        StackIterator<T> it = new StackIterator<>(stackTop);
        int ind = 1;

        while (it.hasNext()) {
            tmp[ind] = it.next();
            ind++;
        }
        return tmp;
    }
}