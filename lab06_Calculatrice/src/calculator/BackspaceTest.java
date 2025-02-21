package calculator;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * This tests the functions, using junit 4.13, of the class Backspace
 * {@link Backspace}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       04/12/2023
 */
public class BackspaceTest {
    State state = new State();

    /**
     * Test the backspace
     */
    @Test
    public void testBackspace(){
        state.current = "123.45";
        new Backspace(state).execute();
        assertEquals("123.4", state.current);
    }

    /**
     * Test that if we backspace when at State.current.length = 1 it just put 0
     */
    @Test
    public void testLengthAt1(){
        state.current = "1";
        new Backspace(state).execute();
        new Backspace(state).execute();
        new Backspace(state).execute();
        assertEquals("0", state.current);
    }

    /**
     * Test that we cannot backspace when the error flag is true
     */
    @Test
    public void testError(){
        state.current = "31";
        state.error = true;
        new Backspace(state).execute();
        assertEquals("31", state.current);
    }

    /**
     * Test that we cannot backspace when there's "Infinity" in State.current
     * so that we can't have invalid values
     */
    @Test
    public void testInfinity(){
        state.current = "Infinity";
        new Backspace(state).execute();
        assertEquals("Infinity", state.current);
    }

    /**
     * Test that we cannot backspace when there's "NaN" in State.current
     * so that we can't have invalid values
     */
    @Test
    public void testNaN(){
        state.current = "NaN";
        new Backspace(state).execute();
        assertEquals("NaN", state.current);
    }
}
