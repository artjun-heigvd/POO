package util.test;

import org.junit.Test;
import java.util.EmptyStackException;

import static org.junit.Assert.*;

import util.*;

/**
 * This tests the functions of the class Stack using junit. {@link Stack}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       13/11/2023
 */
public class StackTest {
    /**
     * Test the empty() method of the implemented stack
     */
    @Test
    public void testEmptyStack() {
        Stack<Integer> stack = new Stack<Integer>();
        assertTrue(stack.empty());
    }

    /**
     * Test the push() and pop() methods of the implemented stack
     */
    @Test
    public void testPushAndPop() {
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertFalse(stack.empty());
        assertEquals((Integer)3, stack.pop());
        assertEquals((Integer)2, stack.pop());
        assertEquals((Integer)1, stack.pop());
        assertTrue(stack.empty());
    }

    /**
     * Test if the Stack throw an exception when using pop() on an empty one
     */
    @Test
    public void testPopEmptyStack() {
        Stack<Integer> stack = new Stack<Integer>();
        assertThrows(EmptyStackException.class, stack::pop);
    }

    /**
     * Test if the print of the stack is correct
     */
    @Test
    public void testToString() {
        Stack<Integer> stack = new Stack<Integer>();
        assertEquals("",stack.toString());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        String expected = "3 2 1";
        assertEquals(expected, stack.toString());
    }

    /**
     * Test the transformation to an array of the Stack
     */
    @Test
    public void testArray() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Object[] expected = {3, 2, 1};
        assertArrayEquals(expected, stack.array());
    }

}
