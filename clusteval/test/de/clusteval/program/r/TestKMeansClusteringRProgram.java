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
package de.clusteval.program.r;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.qos.logback.classic.Level;
import de.clusteval.data.dataset.format.IncompatibleDataSetFormatException;
import de.clusteval.framework.ClustevalBackendServer;
import de.clusteval.framework.repository.InvalidRepositoryException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.repository.RepositoryAlreadyExistsException;
import de.clusteval.framework.repository.config.RepositoryConfigNotFoundException;
import de.clusteval.framework.repository.config.RepositoryConfigurationException;
import de.clusteval.framework.threading.RunSchedulerThread;
import de.clusteval.run.Run;
import de.clusteval.run.runnable.RunRunnable;
import de.clusteval.run.runnable.RunRunnableInitializationException;
import file.FileUtils;

/**
 * @author Christian Wiwie
 * 
 */
public class TestKMeansClusteringRProgram {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * @throws RepositoryAlreadyExistsException
	 * @throws InvalidRepositoryException
	 * @throws RepositoryConfigNotFoundException
	 * @throws RepositoryConfigurationException
	 * @throws IOException
	 * @throws RunRunnableInitializationException
	 */
	@Test
	public void testApplyToRelativeDataSet()
			throws RepositoryAlreadyExistsException,
			InvalidRepositoryException, RepositoryConfigNotFoundException,
			RepositoryConfigurationException, IOException,
			RunRunnableInitializationException {
		ClustevalBackendServer.logLevel(Level.INFO);
		Repository repo = new Repository(
				new File("testCaseRepository").getAbsolutePath(), null);
		repo.initialize();

		RunSchedulerThread scheduler = repo.getSupervisorThread()
				.getRunScheduler();

		Run run = repo.getRunWithName("test_kmeans_sfld_layered_f2");
		try {
			run.perform(scheduler);

			List<RunRunnable> runnables = run.getRunRunnables();
			Assert.assertEquals(1, runnables.size());
			RunRunnable runnable = runnables.get(0);
			List<Throwable> exceptions = runnable.getExceptions();
			Assert.assertEquals(1, exceptions.size());

			Throwable t = exceptions.get(0);
			Assert.assertEquals(IncompatibleDataSetFormatException.class, t.getClass());
		} finally {
			FileUtils.delete(new File(FileUtils.buildPath(
					repo.getRunResultBasePath(),
					run.getRunIdentificationString())));
		}
	}
}
