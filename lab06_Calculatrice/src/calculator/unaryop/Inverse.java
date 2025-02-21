package calculator.unaryop;

import calculator.UnaryOp;
import calculator.State;

/**
 * The class implementing the inverse unary operation.
 * {@link UnaryOp}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       04/12/2023
 */
public class Inverse extends UnaryOp {
    public Inverse(State calcState){super(calcState);}
    /**
     * @return the inverse of the given number.
     */
    protected double operate(double a) {
        return 1/a;
    }
}
