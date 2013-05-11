package de.clusteval.data.dataset;

import java.io.File;
import java.util.Iterator;

import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.utils.SubSubDirectoryIterator;

/**
 * Objects of this class look for new run-files in the run-directory defined in
 * the corresponding repository.
 * 
 * @author Christian Wiwie
 * 
 * 
 */
public class RunResultDataSetFinder extends DataSetFinder {

	/**
	 * Instantiates a new run finder.
	 * 
	 * @param repository
	 *            the repository
	 * @param changeDate
	 * @param absPath
	 * @throws RegisterException
	 */
	public RunResultDataSetFinder(final Repository repository,
			final long changeDate, final File absPath) throws RegisterException {
		super(repository, changeDate, absPath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Finder#getIterator()
	 */
	@Override
	protected Iterator<File> getIterator() {
		return new SubSubDirectoryIterator(getBaseDir());
	}
}
