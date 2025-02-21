package calculator;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * This tests the functions, using junit 4.13, of the class AddCurrToStack
 * {@link AddToCurrent}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       04/12/2023
 */
public class AddCurrToStackTest {

    State state = new State();

    /**
     * Test that AddCurrToStack works
     */
    @Test
    public void testAddCurrToStack(){
        state.current = "5.12";
        new AddCurrToStack(state).execute();
        assertEquals("0", state.current);
        assertEquals(5.12, state.stack.pop(), 0.001);
    }

    /**
     * Test that we can't add something to the stack when the error flag is true
     */
    @Test
    public void testError(){
        state.error = true;
        state.current = "6.78";
        new AddCurrToStack(state).execute();
        assertTrue(state.stack.empty());
    }

}
