import org.apache.commons.lang3.time.StopWatch;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Fibonacci_StopWatch {

    private static Scanner scanner = new Scanner(System.in);
    private static DecimalFormat format = new DecimalFormat("#.#################");
    private static StopWatch stopwatch_iteration = new StopWatch();
    private static StopWatch stopwatch_recursive = new StopWatch();

    public static void main(String[] args) {
        double result = 0.0;
        double n1 = 0.0;
        double n2 = 1.0;

        //Get input from user -> number of elements
        int your_input = getInput();


        //Calculate by using iteration algorithm
        stopwatch_iteration.start();
        result = iterationFibonacci(your_input, n1, n2, result);
        stopwatch_iteration.stop();
        System.out.print("[Iteration algorithm] { [Result:] " + result);
        System.out.println(" [Operation time:] " +
                format.format(convertTimeToSeconds(
                        stopwatch_iteration.getTime(TimeUnit.NANOSECONDS))) + " seconds }");

        //Reset statistics
        result = 0.0;
        n1 = 0.0;
        n2 = 1.0;

        //Calculate by using recursive algorithm
        stopwatch_recursive.start();
        result = recursiveFibonacci(your_input, n1, n2, result);
        stopwatch_recursive.stop();
        System.out.print("[Recursive algorithm] { [Result:] " + result);
        System.out.println(" [Operation time:] " +
                format.format(convertTimeToSeconds(
                        stopwatch_recursive.getTime(TimeUnit.NANOSECONDS))) + " seconds }");
    }

    private static double convertTimeToSeconds(long time) {
        return 1.0 * (time) / 1000000000.0;
    }

    private static int getInput() {
        return scanner.nextInt();
    }

    private static double iterationFibonacci(int n, double n1, double n2, double result) {
        for (int i = 2; i <= n; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }

    private static double recursiveFibonacci(int n, double n1, double n2, double result) {
        if (n == 1) {
            return result;
        }
        result = n1 + n2;
        n1 = n2;
        n2 = result;
        return recursiveFibonacci(--n, n1, n2, result);
    }
}
