/**
 * 
 */
package de.clusteval.data.goldstandard.format;

import de.clusteval.data.goldstandard.GoldStandardException;

/**
 * @author Christian Wiwie
 */
public class UnknownGoldStandardFormatException extends GoldStandardException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5160151162340633793L;

	/**
	 * Instantiates a new unknown gold standard format exception.
	 * 
	 * @param message
	 *            the message
	 */
	public UnknownGoldStandardFormatException(final String message) {
		super(message);
	}
}
