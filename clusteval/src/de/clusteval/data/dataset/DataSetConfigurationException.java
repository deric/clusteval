/**
 * 
 */
package de.clusteval.data.dataset;

/**
 * @author Christian Wiwie
 * 
 */
public class DataSetConfigurationException extends DataSetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3281232015350571965L;

	/**
	 * @param message
	 */
	public DataSetConfigurationException(String message) {
		super(message);
	}

	/**
	 * @param t
	 */
	public DataSetConfigurationException(Throwable t) {
		super(t);
	}

}
