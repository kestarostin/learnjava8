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
	FACTORIAL_8("Factorial on Java 8");

	String type;

	CalculationType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}
}
