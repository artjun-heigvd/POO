package calculator.unaryop;

import calculator.State;
import calculator.UnaryOp;

import static java.lang.Math.sqrt;

/**
 * The class implementing the square root unary operation.
 * {@link UnaryOp}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class SquareRoot extends UnaryOp {
    public SquareRoot(State calcState) {
        super(calcState);
    }

    /**
     * @return the square root of the given number.
     */
    protected double operate(double a) {
        if(a < 0) setError();
        return sqrt(a);
    }
}