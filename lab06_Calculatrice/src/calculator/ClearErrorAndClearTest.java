package calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This tests the functions, using junit 4.13, of the class Clear and ClearError
 * {@link Clear}
 * {@link ClearError}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       04/12/2023
 */
public class ClearErrorAndClearTest {

    State state = new State();

    /**
     * Test that ClearError works and does nothing to the stack
     */
    @Test
    public void testClearError(){
        state.current = "1235";
        state.error = true;
        state.isResult = true;
        state.stack.push(234.);
        new ClearError(state).execute();
        assertFalse(state.error);
        assertFalse(state.isResult);
        assertEquals("0", state.current);
        assertEquals(234, state.stack.pop(), 0.001);
    }

    /**
     * Test that Clear works
     */
    @Test
    public void testClear(){
        state.current = "124";
        state.error = true;
        state.isResult = true;
        state.stack.push(2.67);
        new Clear(state).execute();
        assertFalse(state.error);
        assertFalse(state.isResult);
        assertEquals("0", state.current);
        assertTrue(state.stack.empty());
    }
}
