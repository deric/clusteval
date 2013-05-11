/**
 * 
 */
package de.clusteval.data;

import de.clusteval.utils.ClustEvalException;

/**
 * @author Christian Wiwie
 * 
 */
public abstract class DataException extends ClustEvalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5782785078643769340L;

	/**
	 * @param t
	 */
	public DataException(Throwable t) {
		super(t);
	}

	/**
	 * @param message
	 */
	public DataException(String message) {
		super(message);
	}

}
