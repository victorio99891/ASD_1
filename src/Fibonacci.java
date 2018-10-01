import org.apache.commons.lang3.time.StopWatch;

import java.text.DecimalFormat;
import java.time.Instant;
import java.util.Scanner;

public class Fibonacci {
    private static DecimalFormat format = new DecimalFormat("#.##############");
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        long start, stop;
        double operation_time1, operation_time2;
        double result = 0.0;
        double n1 = 0.0;
        double n2 = 1.0;


        int your_input = getInput();

        start = System.nanoTime();
        result = iterationFibonacci(your_input, n1, n2, result);
        stop = System.nanoTime();
        System.out.print("[Iteration algorithm] { [Result:] " + result);
        operation_time1 = computeTime(start, stop);
        System.out.println(" [Operation time:] " + format.format(operation_time1) + " seconds }");

        result = 0.0;
        n1 = 0.0;
        n2 = 1.0;
        start = 0;
        stop = 0;

        start = System.nanoTime();
        result = recursiveFibonacci(your_input, n1, n2, result);
        stop = System.nanoTime();
        System.out.print("[Recursive algorithm] { [Result:] " + result);
        operation_time2 = computeTime(start, stop);
        System.out.println(" [Operation time:] " + format.format(operation_time2) + " seconds }");


        System.out.println("The winner is: " + whichWin(operation_time1, operation_time2) + " algorithm!");

    }

    private static String whichWin(double one, double two) {
        if (one < two) {
            return "ITERATION";
        } else {
            return "RECURISVE";

        }
    }

    private static double computeTime(long start, long stop) {
        return 1.0 * (stop - start) / 1000000000;
    }

    private static double convertTimeToSeconds(long start) {
        return 1.0 * (start) / 1000000000;
    }


    private static int getInput() {
        return scan.nextInt();
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
