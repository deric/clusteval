/**
 * 
 */
package de.clusteval.data.dataset.format;

import de.clusteval.data.dataset.DataSetException;

/**
 * @author Christian Wiwie
 * 
 */
public class InvalidDataSetFormatVersionException extends DataSetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6502244551092326961L;

	/**
	 * @param message
	 */
	public InvalidDataSetFormatVersionException(final String message) {
		super(message);
	}
}
