package learn.java8.business.performance;

import learn.java8.entities.util.CalculationType;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Class ArraySorterTest
 * <p>
 * Date: 21.06.2016
 * Time: 13:45
 *
 * @author Starostin Konstantin
 */
@FixMethodOrder(MethodSorters.JVM)
public class ArraySorterTest extends AbstractTest {

	/**
	 * Tests the array sorting with common tools.
	 */
	@Test
	public void executeCommonTest() {
		entry.setType(CalculationType.SORTER);
		System.out.println(entry);
		executor = new ArraySorter(entry);
		executor.execute();
	}

	/**
	 * Tests the array sorting with stream API.
	 */
	@Test
	public void executeStreamedTest() {
		entry.setType(CalculationType.SORTER_STREAM);
		System.out.println(entry);
		executor = new ArraySorter(entry);
		executor.execute();
	}

	/**
	 * Tests the the array sorting with parallel stream API.
	 */
	@Test
	public void executeParallelStreamedTest() {
		entry.setType(CalculationType.SORTER_PARALLEL_STREAM);
		System.out.println(entry);
		executor = new ArraySorter(entry);
		executor.execute();
	}
}
