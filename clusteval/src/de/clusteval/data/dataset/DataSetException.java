/**
 * 
 */
package de.clusteval.data.dataset;

import de.clusteval.data.DataException;

/**
 * @author Christian Wiwie
 * 
 */
public class DataSetException extends DataException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3887443647211844114L;

	/**
	 * @param message
	 */
	public DataSetException(String message) {
		super(message);
	}

	/**
	 * @param t
	 */
	public DataSetException(Throwable t) {
		super(t);
	}
}
