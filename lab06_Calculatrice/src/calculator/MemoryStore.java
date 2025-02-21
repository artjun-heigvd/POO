package calculator;

/**
 * Store the State.current in a memory inside this class so that it can be called later.
 * Extends Operator and implements execute().
 * {@link Operator}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public class MemoryStore extends Operator {

    static private double mem;

    /**
     * Constructs a MemoryStore object.
     * @param calcState the calculator state
     */
    public MemoryStore(State calcState) {
        super(calcState);
    }

    /**
     * Stores the current value of the calculator in a static variable.
     */
    @Override
    void execute() {
        if(!calcState.current.isEmpty() && !calcState.error) {
            mem = calcState.getCurrentDouble();
        }
    }

    /**
     * @return the value stored in the static variable.
     */
    static double getMem() {
        return mem;
    }


}
