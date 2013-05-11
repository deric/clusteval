/**
 * 
 */
package de.clusteval.data.dataset.type;

/**
 * @author Christian Wiwie
 */
public class UnknownDataSetTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -229981758008025814L;

	/**
	 * Instantiates a new unknown data set type exception.
	 * 
	 * @param string
	 *            the string
	 */
	public UnknownDataSetTypeException(String string) {
		super(string);
	}

	/**
	 * @param t
	 */
	public UnknownDataSetTypeException(Throwable t) {
		super(t);
	}
}
