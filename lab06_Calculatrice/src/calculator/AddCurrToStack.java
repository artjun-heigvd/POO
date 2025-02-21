package calculator;

/**
 * Push the State.current string into the State.stack.
 * Extends Operator and implements execute().
 * {@link Operator}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class AddCurrToStack extends Operator {

    public AddCurrToStack(State calcState){super(calcState);}

    /**
     * Adds the current value of the calculator to the stack.
     */
    @Override
    void execute() {
        if(!calcState.error) {
            calcState.stack.push(calcState.getCurrentDouble());
            calcState.current = "0";
            calcState.isResult = false;
        }
    }
}
