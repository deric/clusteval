/**
 * 
 */
package de.clusteval.framework.repository;

/**
 * @author Christian Wiwie
 * 
 */
public class RepositoryAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3511110226517347441L;

	/**
	 * @param absPath
	 */
	public RepositoryAlreadyExistsException(final String absPath) {
		super("A repository already exists at " + absPath);
	}
}
