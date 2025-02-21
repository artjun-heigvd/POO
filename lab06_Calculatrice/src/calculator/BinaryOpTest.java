package calculator;

import calculator.binaryop.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This tests the functions, using junit 4.13,
 * of the class Addition, Division, Subtraction and Multiplication
 * inheriting the abstract class BinaryOp.
 * {@link BinaryOp}
 * {@link Addition}
 * {@link Subtraction}
 * {@link Division}
 * {@link Multiplication}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       04/12/2023
 */
public class BinaryOpTest {

    private final State state = new State();

    /**
     * Call execute() on the binary operation given.
     *
     * @param state State of the binary operation.
     * @param op Binary operation given.
     * @param curr Value the State.current will be set (second operand of operation).
     * @param stackTop Value of the top of the State.stack
     *                 (first operand of the operation).
     * @return The result of the binary operation in Double
     */
    private double testBOpExecute(State state, BinaryOp op,
                                  String curr, String stackTop){
        state.current = curr;
        state.stack.push(Double.parseDouble(stackTop));
        op.execute();
        return state.getCurrentDouble();
    }


    /**
     * Test the Addition with valid inputs
     */
    @Test
    public void testAddition(){
        assertEquals(17, testBOpExecute(state, new Addition(state), "9", "8"), 0.001);
    }

    /**
     * Test the Division with valid inputs
     */
    @Test
    public void testDivision(){
        assertEquals(4, testBOpExecute(state, new Division(state), "4", "16"), 0.001);
    }

    /**
     * Test the Multiplication with valid inputs
     */
    @Test
    public void testMultiplication(){
        assertEquals(56,
                testBOpExecute(state, new Multiplication(state), "7", "8"), 0.001);
    }

    /**
     * Test the Subtraction with valid inputs
     */
    @Test
    public void testSubtraction(){
        assertEquals(3, testBOpExecute(state, new Subtraction(state), "4", "7"), 0.001);
    }

    /**
     * Test that the operation do nothing when error flag of State is true
     */
    @Test
    public void testExecuteError(){
        state.error = true;
        assertEquals(1, testBOpExecute(state, new Subtraction(state), "1", "1"), 0.001);
        assertEquals(1, testBOpExecute(state, new Addition(state), "1", "1"), 0.001);
        assertEquals(1,
                testBOpExecute(state, new Multiplication(state), "1", "1"), 0.001);
        assertEquals(1, testBOpExecute(state, new Division(state), "1", "1"), 0.001);
    }

    /**
     * Test the error flag of State is put to true when using
     * a binary operation on an empty stack
     */
    @Test
    public void testStackEmptyError(){
        new Subtraction(state).execute();
        assertTrue(state.error);
    }

    /**
     * Test that we get "Infinity" when dividing by 0 >:(
     */
    @Test
    public void testDivideByZero(){
        state.stack.push(14.);
        new Division(state).execute();
        assertEquals("Infinity", state.current);
    }

    /**
     * Test we get "NaN" when dividing two zeros together
     */
    @Test
    public void testDivideZeros(){
        state.stack.push(0.);
        new Division(state).execute();
        assertEquals("NaN", state.current);
    }
}
