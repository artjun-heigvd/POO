package calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This tests the functions, using junit 4.13, of the class AddToCurrent
 * {@link AddToCurrent}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       04/12/2023
 */
public class AddToCurrentTest {
    State state = new State();

    /**
     * Test if the execute() of AddToCurrent works
     */
    @Test
    public void testAddToCurrent(){
        new AddToCurrent(state, "5").execute();
        assertEquals("5", state.current);
    }

    /**
     * Test if we can make 0.* numbers
     */
    @Test
    public void testDoubleWithZeroAtStart(){
        new AddToCurrent(state, ".").execute();
        new AddToCurrent(state, "5").execute();
        assertEquals("0.5", state.current);
    }

    /**
     * Test if we prohibit the addition of multiple points
     */
    @Test
    public void testMultiplePoints(){
        new AddToCurrent(state, "4").execute();
        new AddToCurrent(state, ".").execute();
        new AddToCurrent(state, "3").execute();
        new AddToCurrent(state, ".").execute();
        assertEquals("4.3", state.current);
    }

    /**
     * Test if we prohibit the addition of multiple zeros
     */
    @Test
    public void testAddMultipleZeros(){
        new AddToCurrent(state, "0").execute();
        new AddToCurrent(state, "0").execute();
        new AddToCurrent(state, "0").execute();
        assertEquals("0", state.current);
    }

    /**
     * Test that we can't change current when error flag of State is true
     */
    @Test
    public void testAddError(){
        state.error = true;
        new AddToCurrent(state, "5").execute();
        assertEquals("0", state.current);
    }

    /**
     * Test that we put the current into the stack when it's a result,
     * and we add a new number
     */
    @Test
    public void testAddWhenResult(){
        state.current = "134.5";
        state.isResult = true;
        new AddToCurrent(state, "8").execute();
        assertEquals("8", state.current);
        assertEquals(134.5, state.stack.pop(), 0.001);
    }
}
