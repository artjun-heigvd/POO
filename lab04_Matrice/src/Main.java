/**
 * This tests roughly the functions of the class Matrix. {@link Matrix}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       13/11/2023
 */

public class Main {
    public static void main(String[] args) {
        int modulo = 5;
        System.out.println("The modulus is " + modulo);

        Matrix one = new Matrix(new int[][]{{1,3,1,1},
                                            {3,2,4,2},
                                            {1,0,1,0}}, modulo);

        Matrix two = new Matrix(new int[][]{{1,4,2,3,2},
                                            {0,1,0,4,2},
                                            {0,0,2,0,2}}, modulo);

        System.out.println("one");
        System.out.println(one);

        System.out.println("two");
        System.out.println(two);

        System.out.println("one + two");
        System.out.println(one.add(two));

        System.out.println("one - two");
        System.out.println(one.sub(two));

        System.out.println("one x two");
        System.out.println(one.mult(two));

        System.out.println("Test randomness: ");
        System.out.println(new Matrix(4, 4, 7));
        System.out.println(new Matrix(4, 4, 7));
        System.out.println(new Matrix(4, 4, 7));
    }
}