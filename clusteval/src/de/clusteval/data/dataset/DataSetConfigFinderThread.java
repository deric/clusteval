/*******************************************************************************
 * Copyright (c) 2013 Christian Wiwie.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Christian Wiwie - initial API and implementation
 ******************************************************************************/
/**
 * 
 */
package de.clusteval.data.dataset;

import de.clusteval.data.distance.DistanceMeasure;
import de.clusteval.data.distance.DistanceMeasureFinderThread;
import de.clusteval.data.preprocessing.DataPreprocessorFinderThread;
import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.threading.SupervisorThread;
import de.clusteval.utils.Finder;
import de.clusteval.utils.FinderThread;

/**
 * @author Christian Wiwie
 * 
 */
public class DataSetConfigFinderThread extends FinderThread {

	/**
	 * @param supervisorThread
	 * @param repository
	 *            The repository to check for new dataset configurations.
	 * @param checkOnce
	 *            If true, this thread only checks once for new dataset
	 *            configurations.
	 * 
	 */
	public DataSetConfigFinderThread(final SupervisorThread supervisorThread,
			final Repository repository, final boolean checkOnce) {
		super(supervisorThread, repository, 30000, checkOnce);
	}

	/**
	 * @param supervisorThread
	 * @param repository
	 *            The repository to check for new dataset configurations.
	 * @param sleepTime
	 *            The time between two checks.
	 * @param checkOnce
	 *            If true, this thread only checks once for new dataset
	 *            configurations.
	 * 
	 */
	public DataSetConfigFinderThread(final SupervisorThread supervisorThread,
			final Repository repository, final long sleepTime,
			final boolean checkOnce) {
		super(supervisorThread, repository, sleepTime, checkOnce);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.FinderThread#beforeFind()
	 */
	@Override
	protected void beforeFind() {
		if (!this.repository.isInitialized(DataSet.class))
			this.supervisorThread.getThread(DataSetFinderThread.class)
					.waitFor();

		if (!this.repository.isInitialized(DistanceMeasure.class))
			this.supervisorThread.getThread(DistanceMeasureFinderThread.class)
					.waitFor();

		if (!this.repository.getDataPreprocessorsInitialized())
			this.supervisorThread.getThread(DataPreprocessorFinderThread.class)
					.waitFor();
		this.log.debug("Checking for DataSetConfigs...");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.FinderThread#afterFind()
	 */
	@Override
	protected void afterFind() {
		this.repository.setInitialized(DataSetConfig.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.FinderThread#getFinder()
	 */
	@Override
	protected Finder getFinder() throws RegisterException {
		return new DataSetConfigFinder(repository);
	}
}
