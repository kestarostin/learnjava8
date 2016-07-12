package learn.java8.util.stream;

import java.util.Arrays;
import java.util.List;
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
	 * Simple list of strings.
	 */
	private static List<String> STRING_NUMBERS;

	/**
	 * Prints first element of collection if exists.
	 */
	public static void printFirstElement() {
		STRING_NUMBERS = Arrays.asList(STRING_NUMBERS_ARRAY);
		if (STRING_NUMBERS.size() > 0 && STRING_NUMBERS.get(0) != null) {
			System.out.println(STRING_NUMBERS.get(0));
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
}
