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
package de.clusteval.utils;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import ch.qos.logback.classic.Level;
import de.clusteval.context.Context;
import de.clusteval.framework.ClustevalBackendServer;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.repository.RepositoryObject;
import de.clusteval.framework.repository.StubSQLCommunicator;
import de.clusteval.run.result.RunResult;

/**
 * @author Christian Wiwie
 * 
 */
public abstract class AbstractClustEvalTest {

	private Repository repository;
	protected RepositoryObject repositoryObject;
	protected Context context;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClustevalBackendServer.logLevel(Level.INFO);
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
		this.repository = new Repository(
				new File("testCaseRepository").getAbsolutePath(), null);
		getRepository().setSQLCommunicator(
				new StubSQLCommunicator(getRepository()));
		// ClustevalBackendServer.getBackendServerConfiguration()
		// .setCheckForRunResults(false);
		getRepository().initialize();

		if (ClustevalBackendServer.getBackendServerConfiguration()
				.getCheckForRunResults()) {
			while (!getRepository().isInitialized(RunResult.class)) {
				Thread.sleep(100);
			}
		}

		repositoryObject = new StubRepositoryObject(this.getRepository(),
				false, System.currentTimeMillis(), new File("test"));
		context = Context.parseFromString(getRepository(), "ClusteringContext");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.repositoryObject = null;
		getRepository().terminateSupervisorThread();
		while (getRepository().getSupervisorThread().isAlive()) {
			Thread.sleep(100);
		}
		Repository.unregister(getRepository());
	}

	protected Repository getRepository() {
		return repository;
	}
}
