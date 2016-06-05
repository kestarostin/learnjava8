package learn.java8.main;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

/**
 * Class Main
 * <p>
 * Created by Starostin Konstantin
 * on 05.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("The average factorial calculation time is: " + makeFactorialTest(40000, 25) + " seconds.");
    }

    /**
     * Calculates the average value of time spent on the factorial calculation.
     *
     * @param n             The end of the factorial.
     * @param iterations    The amount of iterations.
     * @return              The result.
     */
    private static double makeFactorialTest(int n, int iterations) {

        int[] times = new int[iterations];

        for (int i = 0; i < iterations; i++) {
            System.out.println("Iteration: " + (i + 1));
            times[i] = doFactorial(n);
            System.out.println("");
        }

        return Arrays.stream(times).average().getAsDouble();
    }

    /**
     * Calculates the factorial.
     *
     * @param n The end of the factorial.
     * @return  The result.
     */
    private static int doFactorial(int n) {
        long startTime = new Date().getTime();
        long endTime;
        int spentTime;

        System.out.println("Start: " + startTime + " seconds.");

        BigInteger r = BigInteger.valueOf(1);
        for (int i = 2; i <= n; ++i) {
            r = r.multiply(BigInteger.valueOf(i));
        }
        endTime = new Date().getTime();
        spentTime = (int ) (endTime - startTime);

        System.out.println("End: " + endTime + " seconds.");
        System.out.println("Factorial " + n + " result: " + r);
        System.out.println("Time spent " + spentTime + " seconds.");

        return spentTime;
    }
}
