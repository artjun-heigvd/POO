package calculator;
/**
 * Append the toAdd attribute to the State.current.
 * Extends Operator and implements execute().
 * {@link Operator}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class AddToCurrent extends Operator {

    private final String toAdd;
    /**
     * Constructs a AddToCurrent object.
     * @param calcState the calculator state
     * @param toAdd the number to add to the current value of the calculator
     */
    public AddToCurrent(State calcState, String toAdd) {
        super(calcState);
        this.toAdd = toAdd;
    }

    /**
     * Append a number or a dot to the current value of the calculator.
     */
    @Override
     void execute() {
        if(calcState.error) return;

        if(calcState.isResult){
            calcState.isResult = false;
            calcState.stack.push(calcState.getCurrentDouble());
            calcState.current = "";
        }
        //Remove the 0 if adding number, else keep it
        if(calcState.current.equals("0") && !toAdd.equals(".")){
            calcState.current = "";
        }
        //If the current value already contains a dot, don't add another one
        if(!calcState.current.contains(".") || !toAdd.equals(".")) {
            calcState.current += toAdd;
        }
    }
}
