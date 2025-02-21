/**
 * This adds operand A and operand B.
 * Children of the abstract class Operation : {@link Operation}
 * Operand A and operand B must be integers
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       13/11/2023
 */

public class Addition extends Operation{

    /**
     * Add the second operand to the first
     * @param opA first operand
     * @param opB second operand
     * @return the first plus the second operand
     */
    @Override
    public int operate(int opA, int opB) {
        return opA + opB;
    }
}
