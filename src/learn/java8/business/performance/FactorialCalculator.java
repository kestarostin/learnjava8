package learn.java8.business.performance;

import learn.java8.entities.Entry;
import learn.java8.entities.util.CalculationType;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Class FactorialCalculator
 * <p>
 * Created by Starostin Konstantin
 * on 11.06.2016.
 */
public class FactorialCalculator extends AbstractExecutor {

    /**
     * The constructor
     *
     * @param entry The entry
     */
    public FactorialCalculator(Entry entry) {
	    super(entry);
    }

	/**
	 * Calculates the factorial.
	 *
	 * @param value The end of the factorial.
	 */
	@Override
	void doExecution(Long value, CalculationType type) {
		switch (type) {
			case FACTORIAL:
				doCommonFactorial(value);
				break;
			case FACTORIAL_STREAM:
				doStreamedFactorial(value);
				break;
			case FACTORIAL_PARALLEL_STREAM:
				doParallelStreamedFactorial(value);
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
    private void doCommonFactorial(long value) {
        BigInteger r = BigInteger.valueOf(1);
        for (int i = 2; i <= value; ++i) {
            r = r.multiply(BigInteger.valueOf(i));
        }
        result = r;
    }

	/**
	 * Calculates the factorial using the stream API.
	 *
	 * @param value The end of the factorial.
	 */
	private void doStreamedFactorial(long value) {
		BigInteger r = BigInteger.valueOf(1);
		if(value == 1) {
			result = r;
		} else {
			result = IntStream.rangeClosed(2, (int) value).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
		}
	}

	/**
	 * Calculates the factorial using the parallel stream API.
	 *
	 * @param value The end of the factorial.
	 */
	private void doParallelStreamedFactorial(long value) {
		BigInteger r = BigInteger.valueOf(1);
		if(value == 1) {
			result = r;
		} else {
			result = IntStream.rangeClosed(2, (int) value).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
		}
	}
}
