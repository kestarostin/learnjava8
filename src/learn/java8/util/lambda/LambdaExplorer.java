package learn.java8.util.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class LambdaExplorer
 * <p>
 * Date: 23.06.2016
 * Time: 13:56
 *
 * @author Starostin Konstantin
 */
public class LambdaExplorer {

	/**
	 * Simple list of integers.
	 */
	private static final List<Integer> INTEGER_NUMBERS = Arrays.asList(1, 2, 3, 4, 5);

	/**
	 * Simple array of strings.
	 */
	private static final String[] STRING_NUMBERS_ARRAY = {"ONE", "TWO", "THREE", "FOUR", "FIVE"};

	/**
	 * Simple list of strings.
	 */
	private static List<String> STRING_NUMBERS;

	/**
	 * Prints elements of collection.
	 */
	public static void printCollectionElements() {
		System.out.println("Printing:");
		for (Integer number : INTEGER_NUMBERS) {
			System.out.println(number);
		}
	}

	/**
	 * Prints elements of collection using lambda expressions.
	 */
	public static void printCollectionElementsWithLambda() {
		System.out.println("Printing with lambda expressions:");
		INTEGER_NUMBERS.forEach((Integer number) -> System.out.println(number));
	}

	/**
	 * Prints elements of collection using lambda expressions without type declaration.
	 */
	public static void printCollectionElementsWithLambdaWithoutType() {
		System.out.println("Printing with lambda expressions and without type declaration:");
		INTEGER_NUMBERS.forEach(number -> System.out.println(number));
	}

	/**
	 * Prints elements of collection using lambda expressions (shortest variant).
	 */
	public static void printCollectionElementsWithLambdaShortest() {
		System.out.println("Printing with lambda expressions (shortest):");
		INTEGER_NUMBERS.forEach(System.out::println);
	}

	/**
	 * Sorts an array of strings by length using the common implementation of the class Comparator.
	 */
	public static void sortCollectionElements() {
		System.out.println("Sorting with the common implementation of class Comparator:");
		// Initialization
		STRING_NUMBERS = Arrays.asList(STRING_NUMBERS_ARRAY);
		// Sorting
		Collections.sort(STRING_NUMBERS, new LengthStringComparator());
		// Printing
		System.out.println(STRING_NUMBERS);
	}

	/**
	 * Sorts an array of strings by length using the anonymous class.
	 */
	public static void sortCollectionElementsWithAnonymousClass() {
		System.out.println("Sorting with the anonymous implementation of class Comparator:");
		// Initialization
		STRING_NUMBERS = Arrays.asList(STRING_NUMBERS_ARRAY);
		// Sorting
		Collections.sort(STRING_NUMBERS, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return Integer.compare(((String) o1).length(), ((String) o2).length());
			}
		});
		// Printing
		System.out.println(STRING_NUMBERS);
	}

	/**
	 * Sorts an array of strings by length with lambda expressions.
	 */
	public static void sortCollectionElementsWithLambda() {
		System.out.println("Sorting with the lambda expressions:");
		// Initialization
		STRING_NUMBERS = Arrays.asList(STRING_NUMBERS_ARRAY);
		// Sorting
		STRING_NUMBERS.sort((String firstStr, String secondStr) -> Integer.compare(firstStr.length(),secondStr.length()));
		// Printing
		System.out.println(STRING_NUMBERS);
	}

	/**
	 * Sorts an array of strings by length with lambda expressions. Implementation for the several expressions inside.
	 */
	public static void sortCollectionElementsWithLambdaComplexExpression() {
		System.out.println("Sorting with the lambda expression with the several expressions inside:");
		// Initialization
		STRING_NUMBERS = Arrays.asList(STRING_NUMBERS_ARRAY);
		// Sorting
		STRING_NUMBERS.sort((String firstStr, String secondStr) -> {
			if (firstStr.length() < secondStr.length()) {
				return -1;
			} else if (firstStr.length() > secondStr.length()) {
				return 1;
			} else {
				return 0;
			}
		});
		// Printing
		System.out.println(STRING_NUMBERS);
	}

	/**
	 * Provides an implementation of the functional interface Runnable using lambda expression.
	 */
	public static void implementRunnable() {
		Runnable sleepingRunner = () -> {
			System.out.println("Implementation of the interface Runnable as lambda expression");
			//Thread.sleep(1000);   - Wrong!
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Thread t = new Thread(sleepingRunner);
		t.start();
	}

	/**
	 * The LengthStringComparator class.
	 */
	private static class LengthStringComparator implements Comparator<String> {

		/**
		 * Compares strings by length.
		 *
		 * @param firstStr  The first string.
		 * @param secondStr The second string.
		 * @return          The result of comparison.
		 */
		@Override
		public int compare(String firstStr, String secondStr) {
			return Integer.compare(firstStr.length(), secondStr.length());
		}
	}
}
