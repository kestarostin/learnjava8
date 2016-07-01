package learn.java8.business.performance;

import learn.java8.entities.Entry;
import learn.java8.entities.Result;
import org.junit.After;
import org.junit.Before;

import java.util.Date;

/**
 * Class AbstractTest
 * <p>
 * Date: 01.07.2016
 * Time: 16:18
 *
 * @author Starostin Konstantin
 */
public class AbstractTest {

	/**
	 * The tested entry.
	 */
	protected Entry entry;

	/**
	 * The array sorter.
	 */
	protected AbstractExecutor executor;

	/**
	 * Set up.
	 */
	@Before
	public void before() {
		entry = new Entry(null, 5000000L, 30);
	}

	/**
	 * Shows the result.
	 */
	@After
	public void after() {
		Result result = new Result(entry, executor.getResult(), executor.getTime(), new Date());
		System.out.println(result);
	}
}
