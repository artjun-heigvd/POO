package calculator;
/**
 * Clear everything that ClearError does but also empties the stack.
 * Extends Operator and implements execute().
 * {@link ClearError}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class Clear extends ClearError {
    public Clear(State calcState) {
        super(calcState);
    }

    /**
     * Clears the current value of the calculator and removes errors if any.
     */
    @Override
    void execute() {

        super.execute();
        calcState.stack.clear();

    }
}
