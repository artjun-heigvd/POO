package calculator;

import calculator.binaryop.Addition;
import calculator.binaryop.Division;
import calculator.binaryop.Multiplication;
import calculator.binaryop.Subtraction;
import calculator.unaryop.Inverse;
import calculator.unaryop.Square;
import calculator.unaryop.SquareRoot;

import java.util.HashMap;
import java.util.Scanner;

/**
 * This class allow us to launch the calculator in the terminal.
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       28/11/2023
 */
public class Calculator {

    private final State calcState = new State();
    private final Scanner sin = new Scanner(System.in);
    private final HashMap<String, Operator> operations;

    public Calculator(){
        operations = new HashMap<>();
        operations.put("+",    new Addition(calcState));
        operations.put("-",    new Subtraction(calcState));
        operations.put("*",    new Multiplication(calcState));
        operations.put("/",    new Division(calcState));
        operations.put("sqrt", new SquareRoot(calcState));
        operations.put("inv",  new Inverse(calcState));
        operations.put("sq",   new Square(calcState));
        operations.put("c",    new Clear(calcState));
        operations.put("ce",   new ClearError(calcState));
        operations.put("ms",   new MemoryStore(calcState));
        operations.put("mr",   new MemoryRecall(calcState));
    }

    /**
     * This function runs the calculator in the terminal
     */
    public void run() {
        System.out.println("Java Calculator");

        while (true) {
            String in = sin.nextLine();
            if (in.equals("exit")) break;

            // Verify if the user input is an operation
            if (operations.containsKey(in)) {
                operations.get(in).execute();
            } else {
                // The try{}catch{} verifies if the user input is a double
                try {
                    // Append the entier user input in the State.current
                    // and then set it as a result so that it will
                    // be pushed to the State.stack next time we enter a number.
                    new AddToCurrent(calcState,
                            String.valueOf(Double.parseDouble(in))).execute();
                    calcState.isResult = true;
                } catch (NumberFormatException ignore) {
                    System.out.println("Invalid input");
                    continue; // Ask an input again if it's invalid
                }
            }

            display();
        }
    }

    /**
     * Display the calculator in the terminal.
     */
    private void display()
    {
        String res;
        if (calcState.error) res = "ERROR :3";
        else res = calcState.current;
        System.out.println(res + " " + calcState.stack.toString());
    }

}
