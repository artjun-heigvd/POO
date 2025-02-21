import calculator.Calculator;
import calculator.JCalculator;

public class Main
{
  public static void main(String ... args) {
    if(args.length > 0 && args[0].equals("-t")) {
        new Calculator().run();
    } else new JCalculator();
  }
}
