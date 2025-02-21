/**
 * Class Matrix used to store a matrix, display this matrix and make operations between two matrices.
 * The matrix is made of integers
 * This uses another class named "Operation" to operate each element of the matrix : {@link Operation}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       13/11/2023
 */

public class Matrix {
    private final int m;
    private int n;
    private final int modValue;
    private final int[][] matrix;

    /**
     * Create a randomly filled Matrix by giving its dimensions.
     * @param m number of row
     * @param n number of columns
     * @param modValue value of the modulo
     */
    public Matrix(int m, int n, int modValue) {
        verifyDim(m, n);
        modPos(modValue);
        this.n = n;
        this.m = m;
        this.modValue = modValue;

        this.matrix = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = (int) Math.floor(Math.random()
                                * modValue);
            }
        }
    }

    /**
     * Create a Matrix from a given 2d array of int.
     * @param matrix 2d array for the matrix
     * @param modValue value of the modulo
     */
    public Matrix(int[][] matrix, int modValue){

        arrayCheck(matrix);
        modPos(modValue);


        this.m = matrix.length;
        this.n = matrix[0].length;

        //Searching for the longest array in the given matrix
        for(int i = 0; i < m;++i){
            if (this.n < matrix[i].length)
                this.n = matrix[i].length;
        }

        this.matrix = new int[m][n];
        this.modValue = modValue;

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(j >= matrix[i].length) continue;
                this.matrix[i][j] = Math.floorMod(matrix[i][j],
                                    modValue);
            }
        }
    }

    public String toString(){
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                out.append(matrix[i][j]).append(" ");
            }
            out.append('\n');
        }
        return out.toString();
    }

    /**
     * Applies an operation to all the elements of 2 matrix
     * @param b Other Matrix for the operation
     * @param operation Operation to apply
     * @return  A new Matrix from the application ot
     *          the chosen operation.
     */
    private Matrix matrixOp(Matrix b, Operation operation) {

        verifyMod(b);
        int newM = Math.max(this.m,b.m);
        int newN = Math.max(this.n,b.n);

        int operandA;
        int operandB;

        int[][] newMatrix = new int[newM][newN];

        for(int i = 0; i < newM; ++i){
            for(int j = 0; j < newN; ++j){
                //If a matrix is bigger in the n or m dimension
                // than the other one, the smaller matrix sends
                // 0 to avoid out of range error.
                operandA = (i >= this.m || j >= this.n) ?
                            0 : this.matrix[i][j];

                operandB = (i >= b.m|| j >= b.n) ?
                            0 : b.matrix[i][j];

                newMatrix[i][j] =
                        Math.floorMod(operation.operate(operandA,
                                      operandB),modValue);
            }
        }

        return new Matrix(newMatrix, modValue);
    }

    /**
     * Add 2 Matrix together.
     * @param b The other Matrix
     * @return A new Matrix created from the addition
     */
    public Matrix add(Matrix b){
        return matrixOp(b, new Addition());
    }

    /**
     * Subtract 1 Matrix from another.
     * @param b The other Matrix
     * @return  A new Matrix created from the subtraction
     */
    public Matrix sub(Matrix b){
        return matrixOp(b, new Subtraction());
    }

    /**
     * Multiply 2 matrix together.
     * @param b The other Matrix
     * @return A new Matrix created from the multiplication
     */
    public Matrix mult(Matrix b){
        return matrixOp(b, new Multiplication());
    }

    /**
     * Verify that the moduli of this Matrix and another
     * are equals, else it throws and exception.
     * @param b The other Matrix
     * @throws RuntimeException if the moduli of the 2 matrices
     *                          are not equal.
     */
    private void verifyMod(Matrix b) {
        if(modValue != b.modValue)
            throw new RuntimeException("The moduli of the 2 " +
                                       "matrices are not equal");
    }

    /**
     * Verify that a 2d array of int isn't null or empty,
     * else it throws an exception.
     * @param a The 2d array to check
     * @throws RuntimeException if the array passed as parameter
     *                          isn't valid.
     */
    private void arrayCheck(int[][] a){
        if(a == null || a.length == 0 || a[0].length == 0)
            throw new RuntimeException("The array passed as parameter" +
                                       " isn't valid");
    }

    /**
     * Verify that a modulo isn't negative or equal to 0,
     * else it throws an exception.
     * @param mod The modulo to check
     * @throws RuntimeException if the modulo cannot be negative
     *                          or equal to 0.
     */
    private void modPos(int mod){
        if(mod <= 0)
            throw new RuntimeException("The modulo cannot be negative" +
                                       " or equal to 0");
    }

    /**
     * Verify that two int aren't negative or equal to 0,
     * else it throws an exception.
     * @param m One of the int to check
     * @param n The second int to check
     * @throws RuntimeException if one of the dimension
     *                          is lower or equal to 0.
     */
    private void verifyDim(int m, int n){
        if (n <= 0 || m <= 0)
            throw new RuntimeException("One of the dimension is" +
                                       " lower or equal to 0");
    }
}
