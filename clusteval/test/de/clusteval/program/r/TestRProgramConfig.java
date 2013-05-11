/**
 * 
 */
package de.clusteval.program.r;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.qos.logback.classic.Level;
import de.clusteval.data.dataset.format.DataSetFormat;
import de.clusteval.framework.ClustevalBackendServer;
import de.clusteval.framework.repository.InvalidRepositoryException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.repository.RepositoryAlreadyExistsException;
import de.clusteval.framework.repository.config.RepositoryConfigNotFoundException;
import de.clusteval.framework.repository.config.RepositoryConfigurationException;
import de.clusteval.program.ProgramConfig;
import de.clusteval.run.result.format.RunResultFormat;

/**
 * @author Christian Wiwie
 * 
 */
public class TestRProgramConfig {

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

	@Test
	public void testKMeansCompatibleDataSetFormats()
			throws FileNotFoundException, RepositoryAlreadyExistsException,
			InvalidRepositoryException, RepositoryConfigNotFoundException,
			RepositoryConfigurationException {

		ClustevalBackendServer.logLevel(Level.INFO);
		Repository repo = new Repository(
				new File("testCaseRepository").getAbsolutePath(), null);
		repo.initialize();

		ProgramConfig programConfig = repo
				.getProgramConfigWithName("KMeans_Clustering.config");
		List<DataSetFormat> dataSetFormats = programConfig
				.getCompatibleDataSetFormats();
		Assert.assertEquals(1, dataSetFormats.size());
		DataSetFormat format = dataSetFormats.get(0);
		Assert.assertEquals("MatrixDataSetFormat", format.getClass()
				.getSimpleName());
	}

	@Test
	public void testKMeansRunResultFormat() throws FileNotFoundException,
			RepositoryAlreadyExistsException, InvalidRepositoryException,
			RepositoryConfigNotFoundException, RepositoryConfigurationException {

		ClustevalBackendServer.logLevel(Level.INFO);
		Repository repo = new Repository(
				new File("testCaseRepository").getAbsolutePath(), null);
		repo.initialize();

		ProgramConfig programConfig = repo
				.getProgramConfigWithName("KMeans_Clustering.config");
		RunResultFormat format = programConfig.getOutputFormat();
		Assert.assertEquals("TabSeparatedRunResultFormat", format.getClass()
				.getSimpleName());
	}
}
