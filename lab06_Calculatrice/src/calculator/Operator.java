package calculator;


/**
 * This class is used as a backbone for all the operators and is mainly used to
 * store the current state of the calculator and to give an abstract method to
 * execute the operator.
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       22/11/2023
 */
public abstract class Operator {
    State calcState;

    /**
     * Executes the operator.
     */
    abstract void execute();

    /**
     * Constructs an Operator object.
     * @param calcState the calculator state.
     */
    Operator(State calcState) {
        this.calcState = calcState;
    }

}
