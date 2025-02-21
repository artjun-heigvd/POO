/**
 * This multiplies operand A and operand B.
 * Children of the abstract class Operation : {@link Operation}
 * Operand A and operand B must be integers
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       13/11/2023
 */
public class Multiplication extends Operation{

    /**
     * Multiply the second and first operands.
     * @param opA first operand
     * @param opB second operand
     * @return first * second
     */
    @Override
    public int operate(int opA, int opB) {
        return opA * opB;
    }
}
