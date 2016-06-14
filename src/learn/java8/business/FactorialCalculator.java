package learn.java8.business;

import learn.java8.entities.Entry;
import learn.java8.entities.util.CalculationType;
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
    private Long value;

    /**
     * The number of iterations to get the average.
     */
    private Integer iterations;

	/**
	 * The type of factorial calculation.
	 */
	private CalculationType calculationType;

    /**
     * The result.
     */
    private BigInteger result;

    /**
     * The spent time.
     */
    private Integer time;

	/**
	 * The flag shows that calculation done.
	 */
	private boolean isCalculated = false;

    /**
     * The constructor
     *
     * @param entry The entry
     */
    public FactorialCalculator(Entry entry) {
	    this.isCalculated = false;
        this.value = entry.getValue();
        this.iterations = entry.getIterations();
	    this.calculationType = entry.getType();
    }

    /**
     * Calculates the factorial.
     */
    public void calculate() {
        int spentTime = 0;

        for (int i = 0; i < iterations; i++) {
            LOG.info("Iteration: " + (i + 1));

	        long startTime = new Date().getTime();
	        long endTime;

	        LOG.debug("Start: " + startTime + " seconds.");

	        doFactorial(value, calculationType);

	        endTime = new Date().getTime();
	        spentTime = (int ) (endTime - startTime);

			LOG.debug("End: " + endTime + " seconds.");
	        LOG.debug("Factorial " + value + " result: " + result);
	        LOG.debug("Time spent " + spentTime + " seconds.");
        }
        time = spentTime / iterations;
	    isCalculated = true;
    }

	/**
	 * Calculates the factorial.
	 *
	 * @param value The end of the factorial.
	 */
	private void doFactorial(Long value, CalculationType type) {
		switch (type) {
			case FACTORIAL:
				doFactorialWithOldJava(value);
				break;
			case FACTORIAL_8:
				doFactorialWithJava8(value);
				break;
			default:
				break;
		}
	}

    /**
     * Calculates the factorial using the common multiplication in the "for each" cycle.
     *
     * @param value The end of the factorial.
     */
    private void doFactorialWithOldJava(long value) {
        BigInteger r = BigInteger.valueOf(1);
        for (int i = 2; i <= value; ++i) {
            r = r.multiply(BigInteger.valueOf(i));
        }
        result = r;
    }

	/**
	 * Calculates the factorial using the common multiplication in the "for each" cycle.
	 *
	 * @param value The end of the factorial.
	 */
	private int doFactorialWithJava8(long value) {
		// The stub
		return 0;
	}

    /**
     * Gets the result of calculation.
     *
     * @return  The result.
     */
    public BigInteger getResult() {
        return isCalculated ? result : null;
    }

    /**
     * Gets the average time of calculation.
     *
     * @return  The time.
     */
    public Integer getTime() {
        return isCalculated ? time : null;
    }
}
