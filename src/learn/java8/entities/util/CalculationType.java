package learn.java8.entities.util;

/**
 * Class CalculationType
 * <p>
 * Date: 06.06.2016
 * Time: 17:19
 *
 * @author Starostin Konstantin
 */
public enum CalculationType {
	FACTORIAL("Common factorial"),
	FACTORIAL_STREAM("Factorial with streams"),
	FACTORIAL_PARALLEL_STREAM("Factorial with parallel streams"),
	SORTER("Common sorter"),
	SORTER_STREAM("Sorting with streams"),
	SORTER_PARALLEL_STREAM("Sorting with parallel streams");

	String type;

	CalculationType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}
}
