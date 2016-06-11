package learn.java8.util;

/**
 * Class OopsException
 * <p>
 * Date: 09.06.2016
 * Time: 14:15
 *
 * @author Starostin Konstantin
 */
public class OopsException extends Exception {

	/**
	 * The message of the exception.
	 */
	private String message;

    /**
     * The "." constant.
     */
    private final String DOT = ".";

    /**
     * The "Oops ..." constant.
     */
    private final String OOPS = " Oops...";

	/**
	 * The parent exception.
	 */
	Throwable parentException;

	/**
	 * The Constructor.
	 *
	 * @param message   The message of the exception.
	 */
	public OopsException(String message) {
		super(message);
		this.message = addOops(message);
	}

	/**
	 * The Constructor.
	 *
	 * @param message   The message of the exception.
	 * @param e         The parent exception.
	 */
	public OopsException(String message, Throwable e) {
		super(message, e);
		this.message = addOops(message);
	}

	/**
	 * Gets the message of the exception.
	 *
	 * @return  The message.
	 */
	@Override
	public String getMessage() {
		return message;
	}

	private String addOops(String message) {
		StringBuilder newMessage = new StringBuilder(message);
		if (!message.endsWith(DOT)) {
			newMessage.append(DOT);
		}
		newMessage.append(OOPS);
		return newMessage.toString();
	}
}
