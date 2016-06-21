package learn.java8.business.performance;

import learn.java8.entities.Entry;
import learn.java8.entities.util.CalculationType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigInteger;
import java.util.Date;

/**
 * Class AbstractCalculator
 * <p>
 * Date: 20.06.2016
 * Time: 18:26
 *
 * @author Starostin Konstantin
 */
public abstract class AbstractExecutor {

	/**
	 * The logger.
	 */
	private Log LOG = LogFactory.getLog(AbstractExecutor.class);

	/**
	 * The value.
	 */
	protected Long value;

	/**
	 * The number of iterations to get the average.
	 */
	protected Integer iterations;

	/**
	 * The type of calculation.
	 */
	protected CalculationType calculationType;

	/**
	 * The result.
	 */
	protected BigInteger result;

	/**
	 * The spent time.
	 */
	protected Integer time;

	/**
	 * The flag shows that calculation done.
	 */
	protected boolean isCalculated = false;

	public AbstractExecutor(Entry entry) {
		this.isCalculated = false;
		this.value = entry.getValue();
		this.iterations = entry.getIterations();
		this.calculationType = entry.getType();
	}

	/**
	 * Calculates the function.
	 */
	public void execute() {
		int spentTime = 0;

		warmingUp(calculationType);

		for (int i = 1; i < iterations + 1; i++) {
			LOG.info("Iteration: " + i);

			long startTime = new Date().getTime();
			long endTime;

			LOG.debug("Start: " + startTime + " seconds.");

			doExecution(value, calculationType);

			endTime = new Date().getTime();
			spentTime = (int ) (endTime - startTime);

			LOG.debug("End: " + endTime + " seconds.");
			LOG.debug("Calculation " + value + " result: " + result);
			LOG.debug("Time spent " + spentTime + " seconds.");
		}
		time = spentTime / iterations;
		isCalculated = true;
	}

	/**
	 * Warming up the Java machine.
	 *
	 * @param type  The calculation type.
	 */
	private void warmingUp(CalculationType type) {
		for (int i = 0; i < 5; i++) {
			LOG.info("!!!Warming up!!!");
			doExecution(1000L, type);
		}
	}

	/**
	 * Executes the calculation.
	 *
	 * @param value The value of the calculation.
	 */
	abstract void doExecution(Long value, CalculationType type);

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
