package calculator;

/**
 * Recall the memory stored when MemoryStore is called.
 * Extends Operator and implements execute().
 * {@link Operator}
 * {@link MemoryStore}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class MemoryRecall extends Operator{

    public MemoryRecall(State calcState) {super(calcState);}

    /**
     * Recalls the stored value by the MemoryStore class and puts it
     * in the current value of the calculator.
     */
    @Override
    void execute(){
        if(!calcState.error) {
            calcState.current = String.valueOf(MemoryStore.getMem());
            if (calcState.current.equals("0")) calcState.isResult = false;
        }
    }




}

