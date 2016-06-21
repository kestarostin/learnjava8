package learn.java8.business.performance;

import learn.java8.entities.Entry;
import learn.java8.entities.Result;
import learn.java8.entities.util.CalculationType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Class FactorialCalculatorTest
 * <p>
 * Date: 21.06.2016
 * Time: 13:16
 *
 * @author Starostin Konstantin
 */
public class FactorialCalculatorTest {

	/**
	 * The tested entry and result.
	 */
	private Entry entry;
	private Result result;

	/**
	 * The initial values for the entry.
	 */
	private final Long VALUE = 50000L;
	private final Integer ITERATIONS = 30;

	/**
	 * The factorial calculator.
	 */
	private FactorialCalculator calculator;

	/**
	 * Set up.
	 */
	@Before
	public void before() {
		entry = new Entry(null, VALUE, ITERATIONS);
	}

	/**
	 * Tests the factorial calculation with common tools.
	 */
	@Test
	public void executeCommonTest() {
		entry.setType(CalculationType.FACTORIAL);
		System.out.println(entry);
		calculator = new FactorialCalculator(entry);
		calculator.execute();
	}

	/**
	 * Tests the factorial calculation with stream API.
	 */
	@Test
	public void executeStreamedTest() {
		entry.setType(CalculationType.FACTORIAL_STREAM);
		System.out.println(entry);
		calculator = new FactorialCalculator(entry);
		calculator.execute();
	}

	/**
	 * Tests the factorial calculation with parallel stream API.
	 */
	@Test
	public void executeParallelStreamedTest() {
		entry.setType(CalculationType.FACTORIAL_PARALLEL_STREAM);
		System.out.println(entry);
		calculator = new FactorialCalculator(entry);
		calculator.execute();
	}

	/**
	 * Shows the result.
	 */
	@After
	public void after() {
		result = new Result(entry, calculator.getResult(), calculator.getTime(), new Date());
		System.out.println(result);
	}
}
