/**
 * 
 */
package de.clusteval.framework.repository;

/**
 * @author Christian Wiwie
 * 
 */
public class NoRepositoryFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1551460196722224155L;

	/**
	 * @param absPath
	 */
	public NoRepositoryFoundException(final String absPath) {
		super(
				"No repository found for path "
						+ absPath
						+ "\nPlease ensure, that you have instanciated a Repository object for the given path.");
	}
}
