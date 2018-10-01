import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Sumowanie {

    public static void main(String[] args) {

        long start, stop;
        double operation_time;
        int result = 0;


        int your_input = getInput();

        start = System.nanoTime();
        result = iterationSumAlgorithm(your_input, result);
        stop = System.nanoTime();
        System.out.println("[Iteration algorithm]\nResult: " + result);
        operation_time = computeTime(start, stop);
        System.out.println("Operation time: " + operation_time + "ms");

        result = 0;

        start = System.nanoTime();
        result = recursiveSumAlgorithm(your_input, result);
        stop = System.nanoTime();
        System.out.println("[Recursive algorithm]\nResult: " + result);
        operation_time = computeTime(start, stop);
        System.out.println("Operation time: " + operation_time + "ms");

    }

    private static double computeTime(long start, long stop) {
        return (double) 1.0 * (stop - start) / 1000000;
    }


    private static int getInput() {
        int input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextInt();
        return input;
    }

    private static int iterationSumAlgorithm(int n, int result) {
        for (int i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    private static int recursiveSumAlgorithm(int n, int result) {
        if (n == 0) {
            return result;
        } else {
            result += n;
            return recursiveSumAlgorithm(--n, result);
        }

    }
}
