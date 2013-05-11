/**
 * 
 */
package de.clusteval.utils;

/**
 * @author Christian Wiwie
 * 
 */
public class ClustEvalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2371618638043608163L;

	/**
	 * @param message
	 */
	public ClustEvalException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ClustEvalException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ClustEvalException(String message, Throwable cause) {
		super(message, cause);
	}

}
