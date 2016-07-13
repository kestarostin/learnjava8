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
		//Consumer<Integer> c = number -> System.out.println(number);
		//INTEGER_NUMBERS.forEach(c);
	}

	/**
	 * Prints elements of collection using lambda expressions (method reference).
	 */
	public static void printCollectionElementsWithLambdaMethodReference() {
		System.out.println("Printing with lambda expressions using method reference:");
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
		STRING_NUMBERS.sort((String firstStr, String secondStr) -> Integer.compare(firstStr.length(), secondStr.length()));
		// Printing
		System.out.println(STRING_NUMBERS);
	}

	/**
	 * Sorts a list of integers using method reference.
	 */
	public static void sortCollectionElementsWithLambdaMethodReference() {
		System.out.println("Sorting with the lambda expressions:");
		// Initialization
		List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
		// Sorting
		list.sort(Integer::compareTo);
		// Printing
		System.out.println(list);
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
			System.out.println("Implementation of the interface Runnable as lambda expression\n...");
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
	 * Prints elements using this as method reference.
	 */
	public static void printCollectionElementsWithLambdaThis() {
		System.out.println("Printing with lambda expression using method reference to another method of this class:");
		AnotherPrinter anotherPrinter = new AnotherPrinter();
		anotherPrinter.printAgain();
	}

	/**
	 * Prints elements using super as method reference.
	 */
	public static void printCollectionElementsWithLambdaSuper() {
		System.out.println("Printing with lambda expression using method reference to the superclass method:");
		AnotherPrinter anotherPrinter = new AnotherPrinter();
		anotherPrinter.print();
	}

	/**
	 * Prints elements using final external variables for the lambda expression.
	 */
	public static void printCollectionElementsWithLambdaExternalVariables() {
		System.out.println("Printing with lambda expression using final external variables for the lambda expression:");
		AnotherPrinter anotherPrinter = new AnotherPrinter();
		anotherPrinter.print(INTEGER_NUMBERS, INTEGER_NUMBERS.size());
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

	/**
	 * The local inner class Printer.
	 */
	private static class Printer implements First, Second, Third {

		/**
		 * Prints the collection of elements.
		 */
		@Override
		public void print() {
			//INTEGER_NUMBERS.forEach(System.out::println);
			First.super.print();
		}
	}

	/**
	 * The local inner class NewPrinter.
	 */
	private static class AnotherPrinter extends Printer {

		/**
		 * Prints the collection of elements using method reference on the superclass.
		 */
		@Override
		public void print() {
			new Thread(super::print).start();
		}

		/**
		 * Prints the collection of elements using method reference on another method of this class.
		 */
		public void printAgain() {
			new Thread(this::print).start();
		}

		/**
		 * Prints elements of the list.
		 *
		 * @param list  The list for printing. Shouldn't be changed for thread safety!
		 * @param count The size of the list. Shouldn't be changed for thread safety!
		 */
		public void print(final List<Integer> list, final int count) {
			Runnable r = () -> {
				for (int i = 0; i < count; i++) {
					System.out.println(list.get(i));
					Thread.yield();
				}
			};
			new Thread(r).start();
		}
	}

	/**
	 * Interface First. Provides default method print().
	 */
	interface First {

		/**
		 * Prints the array list.
		 */
		default void print() {
			INTEGER_NUMBERS.forEach(System.out::println);
		}
	}

	/**
	 * Interface Second. Provides default method print().
	 */
	interface Second {

		/**
		 * Prints only first element of the array list.
		 */
		default void print() {
			System.out.println(INTEGER_NUMBERS.get(0));
		}
	}

	/**
	 * Interface Second. Doesn't provide any default methods.
	 */
	interface Third {

		/**
		 * Prints something.
		 */
		void print();
	}
}
