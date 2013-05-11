/**
 * 
 */
package de.clusteval.data.dataset.format;

import de.clusteval.data.dataset.DataSetException;

/**
 * 
 * @author Christian Wiwie
 */
public class UnknownDataSetFormatException extends DataSetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1233665166180254125L;

	/**
	 * Instantiates a new unknown data set format exception.
	 * 
	 * @param string
	 *            the string
	 */
	public UnknownDataSetFormatException(String string) {
		super(string);
	}

	/**
	 * @param t
	 */
	public UnknownDataSetFormatException(Throwable t) {
		super(t);
	}
}
