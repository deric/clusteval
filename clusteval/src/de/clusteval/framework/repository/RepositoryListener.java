/**
 * 
 */
package de.clusteval.framework.repository;

/**
 * @author Christian Wiwie
 * 
 */
public interface RepositoryListener {

	/**
	 * This method is invoked either by a listener itself when it wants to
	 * inform all other objects listening about its removal from the repository
	 * or when another object wants to notify this object about repositoral
	 * changes.
	 * 
	 * @param event
	 * @throws RegisterException
	 */
	public void notify(RepositoryEvent event) throws RegisterException;
}
