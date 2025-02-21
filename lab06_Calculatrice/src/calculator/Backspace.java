package calculator;

/**
 * Erase the char at the far right of State.curent.
 * Extends Operator and implements execute().
 * {@link Operator}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class Backspace extends Operator {

    /**
     * Constructs a Backspace object.
     * @param calcState the calculator state
     */
    public Backspace(State calcState) {super(calcState);}

    /**
     * Removes the last character from the current value of the calculator.
     */
    @Override
    void execute() {
        if(!calcState.error && !calcState.current.equals("Infinity")
                && !calcState.current.equals("NaN")){
            if (calcState.current.length() > 1) {
                String cur = calcState.current;
                calcState.current = cur.substring(0, cur.length() - 1);
            } else {
                calcState.current = "0";
            }
        }
    }


}
