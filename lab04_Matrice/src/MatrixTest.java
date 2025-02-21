/**
 * This tests the functions of the class Matrix using junit. {@link Matrix}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       13/11/2023
 */


import junit.extensions.RepeatedTest;
import org.junit.Test;

import java.lang.annotation.Repeatable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
public class MatrixTest {

    private static final int[][] MATRIX_NOT_FULL = {{1},
                                                    {3,2,4},
                                                    {},
                                                    {1,0,2,3,1,2,1}};

    private static final int[][] MATRIX_NOT_FULL_RES = {{1,0,0,0,0,0,0},
                                                        {3,2,4,0,0,0,0},
                                                        {0,0,0,0,0,0,0},
                                                        {1,0,2,3,1,2,1}};

    private static final int[][] MATRIX_ONE = {{1,3,1,1},
                                                {3,2,4,2},
                                                {1,0,1,0}};

    private static final int[][] MATRIX_TWO = {{1,4,2,3,2},
                                                {0,1,0,4,2},
                                                {0,0,2,0,2}};

    private static final int[][] MATRIX_RESULT_ADD = {{2,2,3,4,2},
                                                    {3,3,4,1,2},
                                                    {1,0,3,0,2}};

    private static final int[][] MATRIX_RESULT_SUB = {{0,4,4,3,3},
                                                        {3,1,4,3,3},
                                                        {1,0,4,0,3}};
    private static final int[][] MATRIX_RESULT_MULT = {{1,2,2,3,0},
                                                    {0,2,0,3,0},
                                                    {0,0,2,0,0}};
    private static final int[][] MATRIX_MOD = {{-1,2,-2,3,0},
                                            {0,2,0,3,-465},
                                            {-9,0,2,0,0},
                                            {-7,-8,345,0,1}};
    private static final int[][] MATRIX_RESULT_MOD =  {{7,2,6,3,0},
                                                    {0,2,0,3,7},
                                                    {7,0,2,0,0},
                                                    {1,0,1,0,1}};
    @Test
    public void testAdd(){

        Matrix matrixA = new Matrix(MATRIX_ONE,5);
        Matrix matrixB = new Matrix(MATRIX_TWO,5);

        Matrix matrixResAdd = new Matrix(MATRIX_RESULT_ADD,5);

        assertEquals("Test: add Matrix FAILED",
           matrixResAdd.toString(), matrixA.add(matrixB).toString());
    }

    @Test
    public void testSub(){

        Matrix matrixA = new Matrix(MATRIX_ONE,5);
        Matrix matrixB = new Matrix(MATRIX_TWO,5);

        Matrix matrixResSub = new Matrix(MATRIX_RESULT_SUB,5);

        assertEquals("Test: sub Matrix FAILED",
           matrixResSub.toString(),matrixA.sub(matrixB).toString());
    }

    @Test
    public void testMult(){

        Matrix matrixA = new Matrix(MATRIX_ONE,5);
        Matrix matrixB = new Matrix(MATRIX_TWO,5);

        Matrix matrixResMult = new Matrix(MATRIX_RESULT_MULT,5);

        assertEquals("Test: mult Matrix FAILED",
           matrixResMult.toString(),matrixA.mult(matrixB).toString());1
    }
    @Test
    public void testMod(){
        Matrix matrix = new Matrix(MATRIX_MOD,8);
        Matrix matrixResMod = new Matrix(MATRIX_RESULT_MOD,8);

    assertEquals("Test: mod negative Matrix FAILED",
                 matrixResMod.toString(),matrix.toString());
}

    @Test
    public void testMatrixNotFull(){
        Matrix matrix = new Matrix(MATRIX_NOT_FULL,5);
        Matrix matrixRes = new Matrix(MATRIX_NOT_FULL_RES,5);

        assertEquals("Test: matrix not full FAILED",
                matrixRes.toString(),matrix.toString());
    }


    @Test
    public void testInitDimMod(){
        Exception e = assertThrows(RuntimeException.class,
                ()-> new Matrix(1, 3, 0));
        assertEquals("Test: mod equal to zero when init with dim FAILED"
                , "The modulo cannot be negative or equal to 0",
                e.getMessage());
    }

    @Test
    public void testInitMatrixMod(){
        Exception e = assertThrows(RuntimeException.class,
                ()->new Matrix(new int[][] {{1,3}, {1,4,5,6}}, 0));
        assertEquals("Test: mod equal to zero when init" +
                        " with matrix FAILED",
                     "The modulo cannot be negative or equal to 0",
                     e.getMessage());
    }

    @Test
    public void testVerifyMod(){
        Matrix matrixA = new Matrix(MATRIX_ONE,5);
        Matrix matrixB = new Matrix(MATRIX_TWO,8);

        Exception e = assertThrows(RuntimeException.class,
                ()->matrixA.add(matrixB));
        assertEquals("Test: same mod when operating FAILED",
                "The moduli of the 2 matrices are not equal",
                e.getMessage());
    }

    @Test
    public void testInitDimZero(){
        Exception em = assertThrows(RuntimeException.class,
                ()->new Matrix(0, 3, 4));
        assertEquals("Test: dim m not equal to zero FAILED",
                "One of the dimension is lower or equal to 0",
                em.getMessage());
        Exception en = assertThrows(RuntimeException.class,
                ()->new Matrix(4, 0, 4));
        assertEquals("Test: dim n not equal to zero FAILED",
                "One of the dimension is lower or equal to 0",
                en.getMessage());
    }

    @Test
    public void testInitEmptyMatrix(){
        Exception e = assertThrows(RuntimeException.class,
                ()->new Matrix(new int[][]{{}}, 9));
        assertEquals("Test: init with an empty matrix FAILED",
                "The array passed as parameter isn't valid",
                e.getMessage());

    }
}
