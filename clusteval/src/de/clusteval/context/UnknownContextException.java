package de.clusteval.context;

import de.clusteval.utils.ClustEvalException;

/**
 * @author Christian Wiwie
 * 
 */
public class UnknownContextException extends ClustEvalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4796234082667551507L;

	/**
	 * @param message
	 */
	public UnknownContextException(final String message) {
		super(message);
	}
}
