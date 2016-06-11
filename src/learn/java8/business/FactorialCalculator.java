package learn.java8.business;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigInteger;
import java.util.Date;

/**
 * Class FactorialCalculator
 * <p>
 * Created by Starostin Konstantin
 * on 11.06.2016.
 */
public class FactorialCalculator {

    /**
     * The logger.
     */
    private Log LOG = LogFactory.getLog(FactorialCalculator.class);

    /**
     * The value.
     */
    private Integer value;

    /**
     * The number of iterations to get the average.
     */
    private Integer iterations;

    /**
     * The result.
     */
    private BigInteger result;

    /**
     * The spent time.
     */
    private Integer time;

    /**
     * The constructor
     *
     * @param value         The value.
     * @param iterations    The number of iterations.
     */
    public FactorialCalculator(Integer value, Integer iterations) {
        this.value = value;
        this.iterations = iterations;
    }

    /**
     * Calculates the factorial.
     */
    public void calculate() {
        int[] times = new int[iterations];
        int spentTime = 0;

        for (int i = 0; i < iterations; i++) {
            LOG.info("Iteration: " + (i + 1));
            times[i] = doFactorial(value);
            spentTime = times[i];
        }
        time = spentTime / iterations;
    }

    /**
     * Calculates the factorial.
     *
     * @param value The end of the factorial.
     */
    private int doFactorial(int value) {
        long startTime = new Date().getTime();
        long endTime;
        int spentTime;

        LOG.info("Start: " + startTime + " seconds.");

        BigInteger r = BigInteger.valueOf(1);
        for (int i = 2; i <= value; ++i) {
            r = r.multiply(BigInteger.valueOf(i));
        }
        result = r;
        endTime = new Date().getTime();
        spentTime = (int ) (endTime - startTime);

        LOG.info("End: " + endTime + " seconds.");
        LOG.info("Factorial " + value + " result: " + result);
        LOG.info("Time spent " + spentTime + " seconds.");

        return spentTime;
    }

    /**
     * Gets the result of calculation.
     *
     * @return  The result.
     */
    public BigInteger getResult() {
        return result;
    }

    /**
     * Gets the average time of calculation.
     *
     * @return  The time.
     */
    public Integer getTime() {
        return time;
    }
}
