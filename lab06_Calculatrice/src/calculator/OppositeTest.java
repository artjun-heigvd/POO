package calculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This tests the functions, using junit 4.13, of the class Opposite
 * {@link Opposite}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       04/12/2023
 */
public class OppositeTest {
    State state = new State();

    /**
     * Test that Opposite works
     */
    @Test
    public void testOpposite(){
        state.current = "-1267";
        new Opposite(state).execute();
        assertEquals("1267", state.current);
    }

    /**
     * Test that it does nothing when there's a zero in State.current
     */
    @Test
    public void testZero(){
        new Opposite(state).execute();
        assertEquals("0", state.current);
    }

    /**
     * Test that it does nothing when the error flag is true
     */
    @Test
    public void testError(){
        state.current = "589";
        state.error = true;
        new Opposite(state).execute();
        assertEquals("589", state.current);
    }

    /**
     * Test that it does nothing when the State.current = "NaN"
     */
    @Test
    public void testNaN(){
        state.current = "NaN";
        new Opposite(state).execute();
        assertEquals("NaN", state.current);
    }

    /**
     * Test that it does nothing when the State.current = "Infinity"
     */
    @Test
    public void testInfinity(){
        state.current = "Infinity";
        new Opposite(state).execute();
        assertEquals("Infinity", state.current);
    }
}