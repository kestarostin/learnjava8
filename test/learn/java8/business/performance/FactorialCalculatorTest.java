package learn.java8.business.performance;

import learn.java8.entities.Entry;
import learn.java8.entities.util.CalculationType;
import org.junit.Before;
import org.junit.Test;

/**
 * Class FactorialCalculatorTest
 * <p>
 * Date: 21.06.2016
 * Time: 13:16
 *
 * @author Starostin Konstantin
 */
public class FactorialCalculatorTest extends AbstractTest {

	/**
	 * Set up.
	 */
	@Override
	@Before
	public void before() {
		entry = new Entry(null, 50000L, 30);
	}

	/**
	 * Tests the factorial calculation with common tools.
	 */
	@Test
	public void executeCommonTest() {
		entry.setType(CalculationType.FACTORIAL);
		System.out.println(entry);
		executor = new FactorialCalculator(entry);
		executor.execute();
	}

	/**
	 * Tests the factorial calculation with stream API.
	 */
	@Test
	public void executeStreamedTest() {
		entry.setType(CalculationType.FACTORIAL_STREAM);
		System.out.println(entry);
		executor = new FactorialCalculator(entry);
		executor.execute();
	}

	/**
	 * Tests the factorial calculation with parallel stream API.
	 */
	@Test
	public void executeParallelStreamedTest() {
		entry.setType(CalculationType.FACTORIAL_PARALLEL_STREAM);
		System.out.println(entry);
		executor = new FactorialCalculator(entry);
		executor.execute();
	}
}
