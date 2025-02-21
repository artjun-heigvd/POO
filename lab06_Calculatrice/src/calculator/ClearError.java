package calculator;

/**
 * Put the 2 flag (error, isResult) to false and put tue State.current back to "0".
 * Extends Operator and implements execute().
 * {@link Operator}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class ClearError extends Operator {

    public ClearError(State calcState) {
        super(calcState);
    }

    @Override
    void execute() {

        calcState.current  = "0";
        calcState.error    = false;
        calcState.isResult = false;

    }
}
