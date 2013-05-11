/**
 * 
 */
package de.clusteval.run.result.format;

import java.io.File;

import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;


/**
 * @author Christian Wiwie
 * 
 */
public class TransClustRunResultFormat extends RunResultFormat {

	/**
	 * @param repo
	 * @param register
	 * @param changeDate
	 * @param absPath
	 * @throws RegisterException
	 */
	public TransClustRunResultFormat(Repository repo, boolean register,
			long changeDate, File absPath) throws RegisterException {
		super(repo, register, changeDate, absPath);
	}

	/**
	 * The copy constructor for this format.
	 * 
	 * @param other
	 *            The object to clone.
	 * @throws RegisterException
	 */
	public TransClustRunResultFormat(final TransClustRunResultFormat other)
			throws RegisterException {
		super(other);
	}

}