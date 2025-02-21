package calculator.binaryop;

import calculator.State;
import calculator.BinaryOp;

/**
 * Addition class that extends the abstract class BinaryOp and implements operate(),
 * it can execute an addition.
 * {@link BinaryOp}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class Addition extends BinaryOp {

    public Addition(State calcState){super(calcState);}

    /**
     * @return the sum of the two given numbers.
     */
     protected double operate(double a, double b){
        return a + b;
    }
}
