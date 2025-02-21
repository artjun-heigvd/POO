package calculator;


/**
 * Transform the value of State.current into it's opposite.
 * Extends Operator and implements execute().
 * {@link Operator}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class Opposite extends Operator {

    public Opposite(State calcState){super(calcState);}

    @Override
    void execute() {
        if(!calcState.error && !calcState.current.equals("0")
                && !calcState.current.equals("NaN")
                && !calcState.current.equals("Infinity")) {
            if(calcState.current.charAt(0) == '-'){
                calcState.current = calcState.current.substring(1);
            }else{
                calcState.current = "-" + calcState.current;
            }
        }
    }
}
