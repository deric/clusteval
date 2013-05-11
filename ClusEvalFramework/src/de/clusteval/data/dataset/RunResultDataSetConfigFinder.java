package de.clusteval.data.dataset;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;

import utils.ArrayIterator;
import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.repository.RepositoryObject;
import de.clusteval.utils.FileFinder;

/**
 * Objects of this class look for new run-files in the run-directory defined in
 * the corresponding repository.
 * 
 * @author Christian Wiwie
 * 
 * 
 */
public class RunResultDataSetConfigFinder extends FileFinder {

	/**
	 * Instantiates a new dataset configuration finder.
	 * 
	 * @param repository
	 *            The repository to register the new dataset configurations at.
	 * @throws RegisterException
	 */
	public RunResultDataSetConfigFinder(final Repository repository)
			throws RegisterException {
		super(repository, System.currentTimeMillis(), new File(
				repository.getDataSetConfigBasePath()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Finder#getBaseDir()
	 */
	@Override
	protected File getBaseDir() {
		return new File(this.repository.getDataSetConfigBasePath());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Finder#checkFile(java.io.File)
	 */
	@Override
	protected boolean checkFile(File file) {
		return file.isFile() && file.getName().endsWith(".dsconfig");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Finder#getClassToFind()
	 */
	@Override
	protected Class<?> getClassToFind() {
		return DataSetConfig.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Finder#getIterator()
	 */
	@Override
	protected Iterator<File> getIterator() {
		return new ArrayIterator<File>(getBaseDir().listFiles());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.FileFinder#getRegisteredObjectSet()
	 */
	@Override
	protected Collection<? extends RepositoryObject> getRegisteredObjectSet() {
		return this.repository.getDataSetConfigs();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.FileFinder#parseObjectFromFile(java.io.File)
	 */
	@Override
	protected RepositoryObject parseObjectFromFile(File file) throws Exception {
		return RunResultDataSetConfig.parseFromFile(file);
	}
}
