/**
 * 
 */
package de.clusteval.framework.repository;

/**
 * @author Christian Wiwie
 * 
 */
public class InvalidRepositoryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5104663695934935810L;

	/**
	 * @param message
	 */
	public InvalidRepositoryException(final String message) {
		super(message);
	}
}
