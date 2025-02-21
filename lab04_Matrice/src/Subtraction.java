/**
 * This subtracts operand B from operand A.
 * Children of the abstract class Operation : {@link Operation}
 * Operand A and operand B must be integers
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       13/11/2023
 */
public class Subtraction extends Operation {

    /**
     * Subtract the second operand to the first.
     * @param opA first operand
     * @param opB second operand
     * @return the first operand minus the second
     */
    @Override
    public int operate(int opA, int opB) {
        return opA - opB;
    }
}
