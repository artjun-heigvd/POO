package calculator.binaryop;

import calculator.State;
import calculator.BinaryOp;

/**
 * Multiplication class that extends the abstract class BinaryOp
 * and implements operate(), it can execute a multiplication.
 * {@link BinaryOp}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class Multiplication extends BinaryOp {

    public Multiplication(State calcState){super(calcState);}
    /**
     * @return the multiplication of the two given numbers.
     */
    protected double operate(double a, double b){
        return a * b;
    }
}