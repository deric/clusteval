/**
 * 
 */
package de.clusteval.framework.repository;

import de.clusteval.utils.ClustEvalException;

/**
 * @author Christian Wiwie
 * 
 */
public class RegisterException extends ClustEvalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8871660430700192812L;

	/**
	 * @param message
	 */
	public RegisterException(String message) {
		super(message);
	}
}
