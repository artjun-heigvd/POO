/**
 * Abstract class Operation used to operate two operands.
 * Operand A and operand B must be integers
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       13/11/2023
 */
public abstract class Operation {

    /**
     * Applies the operation on the two operands.
     * @param opA first operand
     * @param opB second operand
     * @return the result of the operation
     */
    abstract int operate(int opA,int opB);
}
