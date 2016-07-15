package learn.java8.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class StreamExplorer.
 * <p>
 * Date: 11.07.2016
 * Time: 17:59
 *
 * @author Starostin Konstantin
 */
public class StreamExplorer {

	/**
	 * Simple array of strings.
	 */
	private static final String[] STRING_NUMBERS_ARRAY = {"ONE", "TWO", "THREE", "FOUR", "FIVE"};

	/**
	 * Prints first element of collection if exists.
	 */
	public static void printFirstElement() {
		List<String> numbersList = Arrays.asList(STRING_NUMBERS_ARRAY);
		if (numbersList.size() > 0 && numbersList.get(0) != null) {
			System.out.println(numbersList.get(0));
		}
	}

	/**
	 * Prints first element of collection if exists using stream API.
	 */
	public static void printFirstElementWithStreams() {
        //Arrays.asList(STRING_NUMBERS_ARRAY).stream()
        //Arrays.stream(STRING_NUMBERS_ARRAY)
        //Stream.builder().add(STRING_NUMBERS_ARRAY[0]).add(STRING_NUMBERS_ARRAY[1]).add(STRING_NUMBERS_ARRAY[2]).build()
        Stream.of(STRING_NUMBERS_ARRAY)
                .findFirst()
                .ifPresent(System.out::println);
    }

	/**
	 * Printing the elements of the array with streams except the first one
	 */
	public static void printElementsExceptTheFirstOne() {
		Stream.of(STRING_NUMBERS_ARRAY)
				.skip(1)
				.forEach(s -> System.out.println("forEach: " + s));
	}

	/**
	 * Printing the elements of the array with streams except the last one
	 */
	public static void printElementsExceptTheLastOne() {
		Stream.of(STRING_NUMBERS_ARRAY)
				.limit(STRING_NUMBERS_ARRAY.length - 1)
				.forEach(s -> System.out.println("forEach: " + s));
	}

	/**
	 * Printing the array length
	 */
	public static void printLength() {
		Predicate<String> predicate = s -> s.startsWith("T");
		Long l = Stream.of(STRING_NUMBERS_ARRAY)
				//.filter(predicate)
				.count();
		System.out.println("Array length: " + l);
	}

	/**
	 * Filtered printing in non optimized order
	 */
	public static void printFirstElementFiltered() {
		Stream.of(STRING_NUMBERS_ARRAY)
				.sorted((s1, s2) -> {
					System.out.printf("sort: %s; %s\n", s1, s2);
					return s1.compareTo(s2);
				})
				.filter(s -> {
					System.out.println("filter: " + s);
					return s.startsWith("O");
				})
				.map(s -> {
					System.out.println("map: " + s);
					return s.toLowerCase();
				})
				.forEach(s -> System.out.println("forEach: " + s));
	}

	/**
	 * Filtered printing in optimized order
	 */
	public static void printFirstElementFilteredOptimized() {
		Stream.of(STRING_NUMBERS_ARRAY)
				.filter(s -> {
					System.out.println("filter: " + s);
					return s.startsWith("O");
				})
				.sorted((s1, s2) -> {
					System.out.printf("sort: %s; %s\n", s1, s2);
					return s1.compareTo(s2);
				})
				.map(s -> {
					System.out.println("map: " + s);
					return s.toLowerCase();
				})
				.forEach(s -> System.out.println("forEach: " + s));
	}

	/**
	 * Print all elements filtered and collected as one string
	 */
	public static void printAllElementsFiltered() {
		System.out.println(Stream.of(STRING_NUMBERS_ARRAY)
				.filter(s -> s.length() >= 4)
				.collect(Collectors.joining(" & ", "In this collection elements ", " have length bigger than 4.")));
	}

	/**
	 * Print the average using collector
	 */
	public static void printAllElementsWithCollector() {
		System.out.println("The average is: " +
				Stream.of(1, 2, 3, 4, 5)
				.collect(Collectors.averagingInt(i -> i))
		);
	}

	/**
	 * Print all elements filtered in parallel
	 */
	public static void printAllElementsFilteredParallel() {
		Arrays.asList(STRING_NUMBERS_ARRAY)
				.parallelStream()
				.filter(s -> {
					System.out.format("filter: %s [%s]\n",
							s, Thread.currentThread().getName());
					return s.contains("O");
				})
				.map(s -> {
					System.out.format("map: %s [%s]\n",
							s, Thread.currentThread().getName());
					return s.toLowerCase();
				})
				.forEach(s -> System.out.format("forEach: %s [%s]\n",
						s, Thread.currentThread().getName()));
	}
}
