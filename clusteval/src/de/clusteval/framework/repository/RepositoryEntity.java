/**
 * 
 */
package de.clusteval.framework.repository;

import de.clusteval.data.dataset.DataSetFinderThread;

//TODO: rename
public abstract class RepositoryEntity<T extends RepositoryObject> {

	protected Repository repository;

	/**
	 * A boolean attribute indicating whether the datasets have been initialized
	 * by the {@link DataSetFinderThread}.
	 */
	private boolean initialized;

	/**
	 * The absolute path to the directory within this repository, where all
	 * datasets are stored.
	 */
	protected String basePath;

	public RepositoryEntity(final Repository repository, final String basePath) {
		super();
		this.repository = repository;
		this.initialized = false;
		this.basePath = basePath;
	}

	public void setInitialized() {
		this.initialized = true;
	}

	public boolean isInitialized() {
		return this.initialized;
	}

	public String getBasePath() {
		return this.basePath;
	}
}