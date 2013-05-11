/**
 * 
 */
package de.clusteval.data.goldstandard;

import de.clusteval.data.DataException;

/**
 * @author Christian Wiwie
 * 
 */
public abstract class GoldStandardException extends DataException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7235966832673486396L;

	/**
	 * @param message
	 */
	public GoldStandardException(String message) {
		super(message);
	}

	/**
	 * @param t
	 */
	public GoldStandardException(Throwable t) {
		super(t);
	}
}
