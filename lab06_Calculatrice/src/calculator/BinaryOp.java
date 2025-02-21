package calculator;

/**
 * This class is used as a backbone for all the binary operators.
 * It is then required to implement the operate method with the desired operator.
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       28/11/2023
 */
public abstract class BinaryOp extends Operator {
    public BinaryOp(State calcState) {
        super(calcState);
    }

    /**
     * Executes the binary operation by popping an operand from the stack
     * and using it with the current. The result is then put back in the current.
     * If the stack is empty the error flag is set to true.
     */
    @Override
    protected void execute() {

        if (calcState.stack.empty() || calcState.error) {
            calcState.error = true;
        } else {

            double d = calcState.stack.pop();

            //To cast the double to String
            calcState.current = String.valueOf(operate(d, calcState.getCurrentDouble()));
            calcState.isResult = true;
        }

    }

    /**
     * Performs the binary operation on the given values.
     * @param a the first value.
     * @param b the second value.
     * @return the result of the operation.
     */
    protected abstract double operate(double a, double b);

}
