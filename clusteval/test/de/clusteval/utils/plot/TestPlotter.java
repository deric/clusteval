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
package de.clusteval.utils.plot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.rosuda.REngine.REngineException;

import ch.qos.logback.classic.Level;
import de.clusteval.context.Context;
import de.clusteval.context.UnknownContextException;
import de.clusteval.data.DataConfig;
import de.clusteval.data.dataset.DataSet;
import de.clusteval.data.dataset.DataSetConfig;
import de.clusteval.data.dataset.DataSetConfigurationException;
import de.clusteval.data.dataset.DataSetNotFoundException;
import de.clusteval.data.dataset.NoDataSetException;
import de.clusteval.data.dataset.format.ConversionInputToStandardConfiguration;
import de.clusteval.data.dataset.format.ConversionStandardToInputConfiguration;
import de.clusteval.data.dataset.format.DataSetFormat;
import de.clusteval.data.dataset.format.InvalidDataSetFormatVersionException;
import de.clusteval.data.dataset.format.UnknownDataSetFormatException;
import de.clusteval.data.dataset.type.UnknownDataSetTypeException;
import de.clusteval.data.distance.DistanceMeasure;
import de.clusteval.data.distance.UnknownDistanceMeasureException;
import de.clusteval.data.preprocessing.DataPreprocessor;
import de.clusteval.framework.ClustevalBackendServer;
import de.clusteval.framework.repository.InvalidRepositoryException;
import de.clusteval.framework.repository.NoRepositoryFoundException;
import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.repository.RepositoryAlreadyExistsException;
import de.clusteval.framework.repository.config.RepositoryConfigNotFoundException;
import de.clusteval.framework.repository.config.RepositoryConfigurationException;
import de.clusteval.utils.FormatConversionException;
import de.clusteval.utils.RNotAvailableException;

/**
 * @author Christian Wiwie
 * 
 */
public class TestPlotter {

	Repository parent;

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
		ClustevalBackendServer.logLevel(Level.INFO);
		parent = new Repository(
				new File("testCaseRepository").getAbsolutePath(), null);
		parent.initialize();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		parent.terminateSupervisorThread();
	}

	@Test
	public void testIsoMDS() throws RepositoryAlreadyExistsException,
			InvalidRepositoryException, RepositoryConfigNotFoundException,
			RepositoryConfigurationException, UnknownDataSetFormatException,
			RegisterException, UnknownDataSetTypeException,
			UnknownDistanceMeasureException,
			InvalidDataSetFormatVersionException, IllegalArgumentException,
			IOException, REngineException, FormatConversionException,
			DataSetNotFoundException, DataSetConfigurationException,
			NoDataSetException, NoRepositoryFoundException,
			UnknownContextException, RNotAvailableException,
			InterruptedException {
		Context context = Context.parseFromString(parent, "ClusteringContext");

		DataSet ds = DataSet
				.parseFromFile(new File(
						"testCaseRepository/results/04_07_2013-14_41_00_paper_run_synthetic/inputs/TransClust_2_synthetic_cassini250/synthetic/cassini250"));

		File targetFile = new File(
				"testCaseRepository/results/04_07_2013-14_41_00_paper_run_synthetic/inputs/TransClust_2_synthetic_cassini250/synthetic/cassini250.strip.isoMDS");
		if (targetFile.exists())
			targetFile.delete();

		ds = ds.preprocessAndConvertTo(
				context,
				DataSetFormat.parseFromString(parent, "SimMatrixDataSetFormat"),
				new ConversionInputToStandardConfiguration(DistanceMeasure
						.parseFromString(parent, "EuclidianDistanceMeasure"),
						new ArrayList<DataPreprocessor>(),
						new ArrayList<DataPreprocessor>()),
				new ConversionStandardToInputConfiguration());

		DataSetConfig dsc = new DataSetConfig(
				parent,
				System.currentTimeMillis(),
				new File(
						"testCaseRepository/results/04_07_2013-14_41_00_paper_run_synthetic/configs/synthetic_cassini250.dsconfig"),
				ds, new ConversionInputToStandardConfiguration(DistanceMeasure
						.parseFromString(parent, "EuclidianDistanceMeasure"),
						new ArrayList<DataPreprocessor>(),
						new ArrayList<DataPreprocessor>()),
				new ConversionStandardToInputConfiguration());

		DataConfig dc = new DataConfig(
				parent,
				System.currentTimeMillis(),
				new File(
						"testCaseRepository/results/04_07_2013-14_41_00_paper_run_synthetic/configs/synthetic_cassini250.dataconfig"),
				dsc, null);

		Plotter.assessAndWriteIsoMDSCoordinates(dc);
		Assert.assertTrue(targetFile.exists());
	}

	@Test
	public void testPCA() throws RepositoryAlreadyExistsException,
			InvalidRepositoryException, RepositoryConfigNotFoundException,
			RepositoryConfigurationException, UnknownDataSetFormatException,
			RegisterException, UnknownDataSetTypeException,
			UnknownDistanceMeasureException,
			InvalidDataSetFormatVersionException, IllegalArgumentException,
			IOException, REngineException, FormatConversionException,
			DataSetNotFoundException, DataSetConfigurationException,
			NoDataSetException, NoRepositoryFoundException,
			UnknownContextException, RNotAvailableException,
			InterruptedException {
		Context context = Context.parseFromString(parent, "ClusteringContext");

		DataSet ds = DataSet
				.parseFromFile(new File(
						"testCaseRepository/results/04_07_2013-14_41_00_paper_run_synthetic/inputs/TransClust_2_synthetic_cassini250/synthetic/cassini250"));

		File targetFile = new File(
				"testCaseRepository/results/04_07_2013-14_41_00_paper_run_synthetic/inputs/TransClust_2_synthetic_cassini250/synthetic/cassini250.strip.PCA");
		if (targetFile.exists())
			targetFile.delete();

		ds = ds.preprocessAndConvertTo(
				context,
				DataSetFormat.parseFromString(parent, "SimMatrixDataSetFormat"),
				new ConversionInputToStandardConfiguration(DistanceMeasure
						.parseFromString(parent, "EuclidianDistanceMeasure"),
						new ArrayList<DataPreprocessor>(),
						new ArrayList<DataPreprocessor>()),
				new ConversionStandardToInputConfiguration());

		DataSetConfig dsc = new DataSetConfig(
				parent,
				System.currentTimeMillis(),
				new File(
						"testCaseRepository/results/04_07_2013-14_41_00_paper_run_synthetic/configs/synthetic_cassini250.dsconfig"),
				ds, new ConversionInputToStandardConfiguration(DistanceMeasure
						.parseFromString(parent, "EuclidianDistanceMeasure"),
						new ArrayList<DataPreprocessor>(),
						new ArrayList<DataPreprocessor>()),
				new ConversionStandardToInputConfiguration());

		DataConfig dc = new DataConfig(
				parent,
				System.currentTimeMillis(),
				new File(
						"testCaseRepository/results/04_07_2013-14_41_00_paper_run_synthetic/configs/synthetic_cassini250.dataconfig"),
				dsc, null);

		Plotter.assessAndWritePCACoordinates(dc);
		Assert.assertTrue(targetFile.exists());
	}
}
