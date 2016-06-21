package learn.java8.business.performance;

import learn.java8.entities.Entry;
import learn.java8.entities.Result;
import learn.java8.entities.util.CalculationType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Class ArraySorterTest
 * <p>
 * Date: 21.06.2016
 * Time: 13:45
 *
 * @author Starostin Konstantin
 */
public class ArraySorterTest {

	/**
	 * The tested entry and result.
	 */
	private Entry entry;
	private Result result;

	/**
	 * The initial values for the entry.
	 */
	private final Long VALUE = 2000000L;
	private final Integer ITERATIONS = 30;

	/**
	 * The array sorter.
	 */
	private ArraySorter sorter;

	/**
	 * Set up.
	 */
	@Before
	public void before() {
		entry = new Entry(null, VALUE, ITERATIONS);
	}

	/**
	 * Tests the array sorting with common tools.
	 */
	@Test
	public void executeCommonTest() {
		entry.setType(CalculationType.SORTER);
		System.out.println(entry);
		sorter = new ArraySorter(entry);
		sorter.execute();
	}

	/**
	 * Tests the array sorting with stream API.
	 */
	@Test
	public void executeStreamedTest() {
		entry.setType(CalculationType.SORTER_STREAM);
		System.out.println(entry);
		sorter = new ArraySorter(entry);
		sorter.execute();
	}

	/**
	 * Tests the the array sorting with parallel stream API.
	 */
	@Test
	public void executeParallelStreamedTest() {
		entry.setType(CalculationType.SORTER_PARALLEL_STREAM);
		System.out.println(entry);
		sorter = new ArraySorter(entry);
		sorter.execute();
	}

	/**
	 * Shows the result.
	 */
	@After
	public void after() {
		result = new Result(entry, sorter.getResult(), sorter.getTime(), new Date());
		System.out.println(result);
	}
}
