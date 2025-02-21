package calculator.binaryop;

import calculator.State;
import calculator.BinaryOp;

/**
 * Division class that extends the abstract class BinaryOp and implements operate(),
 * it can execute a division.
 * {@link BinaryOp}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class Division extends BinaryOp {

    public Division(State calcState){super(calcState);}

    /**
     * @return the division of the two given numbers.
     */
    protected double operate(double a, double b){
        return a / b;
    }
}