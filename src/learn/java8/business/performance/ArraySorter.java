package learn.java8.business.performance;

import learn.java8.entities.Entry;
import learn.java8.entities.util.CalculationType;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Class ArraySorter
 * <p>
 * Date: 20.06.2016
 * Time: 18:50
 *
 * @author Starostin Konstantin
 */
public class ArraySorter extends AbstractExecutor {

	/**
	 * The constructor
	 *
	 * @param entry The entry
	 */
	public ArraySorter(Entry entry) {
		super(entry);
	}

	/**
	 * Creates and sorts the array using common tools.
	 *
	 * @param value The size of the array.
	 */
	@Override
	void doExecution(Long value, CalculationType type) {
		switch (type) {
			case SORTER:
				doCommonSort(value);
				break;
			case SORTER_STREAM:
				doStreamedSort(value);
				break;
			case SORTER_PARALLEL_STREAM:
				doParallelStreamedSort(value);
				break;
			default:
				break;
		}
	}

	/**
	 * Creates and sorts the array, then finds the average value of the array.
	 *
	 * @param size The value.
	 */
	private void doCommonSort(long size) {
		//  Initialization
		List<Long> array = new ArrayList<>((int) size);
		Random random = new Random();
		for (long i = 0; i < size; i++) {
			array.add(random.nextLong());
		}

		//  Sorting
		Collections.sort(array);

		//  The average
		BigInteger sum = BigInteger.valueOf(0);
		for (Long val : array) {
			sum = sum.add(BigInteger.valueOf(val));
		}
		result = sum.divide(BigInteger.valueOf(size));
	}

	/**
	 * Creates and sorts the array using the stream API.
	 *
	 * @param size  The initial size of the array.
	 */
	private void doStreamedSort(long size) {
		// Initialization
		List<Long> list = Arrays.stream(new Random()
				.longs(size, Long.MIN_VALUE, Long.MAX_VALUE)
				.toArray())
				.boxed()
				.collect(Collectors.toList());

		// Sorting and the average
		result = BigInteger.valueOf((long) list
				.stream()
				.sorted()
				.mapToLong((l) -> (l))
				.average()
				.getAsDouble());
	}

	/**
	 * Creates and sorts the array using the parallel stream API.
	 *
	 * @param size  The initial size of the array.
	 */
	private void doParallelStreamedSort(long size) {
		// Initialization
		List<Long> list = Arrays.stream(new Random()
				.longs(size, Long.MIN_VALUE, Long.MAX_VALUE)
				.toArray())
				.boxed()
				.collect(Collectors.toList());

		// Sorting and the average
		result = BigInteger.valueOf((long) list
				.stream()
				.parallel()
				.sorted()
				.mapToLong((l) -> (l))
				.average()
				.getAsDouble());
	}

	/**
	 * Creates and sorts in line the array using the parallel stream API.
	 *
	 * @param size  The initial size of the array.
	 */
	private void doParallelStreamedSortInLine(long size) {
		result = BigInteger.valueOf((long) new Random()
				.longs(size, Long.MIN_VALUE, Long.MAX_VALUE)
				.parallel()
				.sorted()
				.average()
				.getAsDouble());
	}
}
