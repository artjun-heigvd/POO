package calculator.binaryop;

import calculator.State;
import calculator.BinaryOp;

/**
 * Subtraction class that extends the abstract class BinaryOp and implements operate(),
 * it can execute a subtraction.
 * {@link BinaryOp}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class Subtraction extends BinaryOp {

    public Subtraction(State calcState){super(calcState);}
    /**
     * @return the difference of the two given numbers.
     */
    protected double operate(double a, double b){
        return a - b;
    }
}