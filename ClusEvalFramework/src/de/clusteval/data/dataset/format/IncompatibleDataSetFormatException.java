package de.clusteval.data.dataset.format;

import de.clusteval.data.dataset.DataSetException;

/**
 * @author Christian Wiwie
 * 
 */
public class IncompatibleDataSetFormatException extends DataSetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5356568704488024628L;

	/**
	 * Instantiates a new incompatible data set format exception.
	 * 
	 * @param string
	 *            the string
	 */
	public IncompatibleDataSetFormatException(String string) {
		super(string);
	}

}
