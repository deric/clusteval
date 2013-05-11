/**
 * 
 */
package de.clusteval.run.statistics;

import java.io.File;

import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.threading.SupervisorThread;
import de.clusteval.utils.Finder;
import de.clusteval.utils.FinderThread;

/**
 * @author Christian Wiwie
 * 
 */
public class RunDataStatisticFinderThread extends FinderThread {

	/**
	 * @param supervisorThread
	 * @param framework
	 * @param checkOnce
	 * 
	 */
	public RunDataStatisticFinderThread(
			final SupervisorThread supervisorThread,
			final Repository framework, final boolean checkOnce) {
		super(supervisorThread, framework, 30000, checkOnce);
	}

	/**
	 * @param supervisorThread
	 * @param framework
	 * @param sleepTime
	 * @param checkOnce
	 * 
	 */
	public RunDataStatisticFinderThread(
			final SupervisorThread supervisorThread,
			final Repository framework, final long sleepTime,
			final boolean checkOnce) {
		super(supervisorThread, framework, sleepTime, checkOnce);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.FinderThread#runStart()
	 */
	@Override
	protected void beforeFind() {
		this.log.debug("Checking for new RunDataStatistics...");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.FinderThread#getFinder()
	 */
	@Override
	protected Finder getFinder() throws RegisterException {
		return new RunDataStatisticFinder(repository,
				System.currentTimeMillis(), new File(
						repository.getRunDataStatisticBasePath()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.FinderThread#runEnd()
	 */
	@Override
	protected void afterFind() {
		repository.setRunDataStatisticsInitialized();
	}
}