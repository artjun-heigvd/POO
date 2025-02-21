package calculator;

/**
 * This class is used as a backbone for all the unary operators.
 *  * It is then required to implement the operate method with the desired operator.
 * {@link Operator}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public abstract class UnaryOp extends Operator {

    /**
     * Constructs a UnaryOp object.
     * @param calcState the calculator state
     */
    public UnaryOp(State calcState) {
        super(calcState);
    }

    /**
     * Executes the unary operation on the current double value.
     * The result is stored in the current String from calcState,
     * and the isResult flag is set to true.
     */
    protected void execute() {
        if(!calcState.current.isEmpty() && !calcState.error) {
            calcState.current = String.valueOf(operate(calcState.getCurrentDouble()));
            calcState.isResult = true;
        }
    }

    protected void setError(){
        calcState.error = true;
    }

    /**
     * Performs the unary operation on the given value.
     *
     * @param value the value to operate on
     * @return the result of the operation
     */
    protected abstract double operate(double value);
}