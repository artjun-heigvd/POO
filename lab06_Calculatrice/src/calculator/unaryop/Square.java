package calculator.unaryop;

import calculator.State;
import calculator.UnaryOp;

/**
 * The class implementing the square unary operation.
 * {@link UnaryOp}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class Square extends UnaryOp {
    public Square(State calcState) {
        super(calcState);
    }
    /**
     * @return the square of the given number.
     */
    protected double operate(double a) {

        return a * a;
    }
}