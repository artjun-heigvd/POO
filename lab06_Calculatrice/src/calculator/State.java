package calculator;

import util.Stack;

/**
 * This class holds the current state of a calculator session.
 * This includes the current stack of numbers, the current input or
 * result as a string, and flags indicating if the current input is
 * a result or if there has been an error.
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class State {

    Stack<Double> stack;
    String current;
    boolean isResult;
    boolean error;

    /**
     * Constructs a State object.
     */
    public State() {
        stack    = new Stack<>();
        current  = "0";
        isResult = false;
        error    = false;
    }

    /**
     * @return the current value as a double.
     * @throws NumberFormatException if current isn't a double.
     * @throws NullPointerException if the string is null
     */
    double getCurrentDouble() {
        return Double.parseDouble(current);
    }
}
