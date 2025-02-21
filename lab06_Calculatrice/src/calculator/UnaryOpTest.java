package calculator;

import calculator.unaryop.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This tests the functions, using junit 4.13,
 * of the class Inverse, Square and SquareRoot
 * inheriting the abstract class UnaryOp.
 * {@link UnaryOp}
 * {@link Inverse}
 * {@link Square}
 * {@link SquareRoot}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       04/12/2023
 */
public class UnaryOpTest {
    private final State state = new State();

    /**
     * Call execute() on the unary operation given.
     *
     * @param state The state which is the same the unary op initialized with
     * @param op The unary operation we want to execute on the state
     * @param curr Value that we want to give to the State.current
     *             (execute() is used on it)
     * @return The result of the unary operation in Double
     */
    private double testUOpExecute(State state, UnaryOp op, String curr){
        state.current = curr;
        op.execute();
        return state.getCurrentDouble();
    }

    /**
     * Test if the inverse works normally
     */
    @Test
    public void inverseTest(){
        assertEquals(0.25, testUOpExecute(state, new Inverse(state), "4"), 0.001);
    }

    /**
     * Test if the square operation works
     */
    @Test
    public void squareTest(){
        assertEquals(4, testUOpExecute(state, new Square(state), "2"), 0.001);
    }

    /**
     * Test if the square root operation works
     */
    @Test
    public void squareRootTest(){
        assertEquals(4, testUOpExecute(state, new SquareRoot(state), "16"), 0.001);
    }

    /**
     * Test if that we do not execute() anything if the error flag is true in the state
     */
    @Test
    public void testErrorExecute(){
        State state = new State();
        state.error = true;
        // We don't execute anything so the state will stay with current = 1.
        assertEquals(1, testUOpExecute(state, new Inverse(state), "1"), 0.001);
        assertEquals(1, testUOpExecute(state, new Square(state), "1"), 0.001);
        assertEquals(1, testUOpExecute(state, new SquareRoot(state), "1"), 0.001);
    }

    /**
     * Test that we return "Infinity if we do 1/0
     */
    @Test
    public void testZeroInverse(){
        new Inverse(state).execute();
        assertEquals("Infinity", state.current);
    }

    /**
     * Test that if we take the square root of a negative number
     * the error flag is set to true.
     */
    @Test
    public void testNegSquareRoot(){
        state.current = "-3";
        new SquareRoot(state).execute();
        assertTrue(state.error);
    }
}

