/**
 * 
 */
package de.clusteval.data;

/**
 * @author Christian Wiwie
 * 
 */
public class DataConfigurationException extends DataException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3499581646376240590L;

	/**
	 * @param t
	 */
	public DataConfigurationException(Throwable t) {
		super(t);
	}

	/**
	 * @param message
	 */
	public DataConfigurationException(String message) {
		super(message);
	}
}
