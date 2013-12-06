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

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalINIConfiguration;
import org.slf4j.LoggerFactory;

import de.clusteval.data.dataset.format.ConversionInputToStandardConfiguration;
import de.clusteval.data.dataset.format.ConversionStandardToInputConfiguration;
import de.clusteval.data.distance.DistanceMeasure;
import de.clusteval.data.distance.UnknownDistanceMeasureException;
import de.clusteval.data.preprocessing.DataPreprocessor;
import de.clusteval.data.preprocessing.UnknownDataPreprocessorException;
import de.clusteval.framework.repository.NoRepositoryFoundException;
import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;

/**
 * @author Christian Wiwie
 * 
 */
public class RunResultDataSetConfig extends DataSetConfig {

	/**
	 * @param repository
	 * @param changeDate
	 * @param absPath
	 * @param ds
	 * @param configInputToStandard
	 * @param configStandardToInput
	 * @throws RegisterException
	 */
	public RunResultDataSetConfig(Repository repository, long changeDate,
			File absPath, DataSet ds,
			ConversionInputToStandardConfiguration configInputToStandard,
			ConversionStandardToInputConfiguration configStandardToInput)
			throws RegisterException {
		super(repository, changeDate, absPath, ds, configInputToStandard,
				configStandardToInput);
	}

	/**
	 * @param datasetConfig
	 * @throws RegisterException
	 */
	public RunResultDataSetConfig(DataSetConfig datasetConfig)
			throws RegisterException {
		super(datasetConfig);
	}

	/**
	 * This method parses a dataset configuration from a file on the filesystem.
	 * 
	 * <p>
	 * A dataset configuration contains several options:
	 * <ul>
	 * <li><b>datasetName</b>: The folder the dataset file lies within.</li>
	 * <li><b>datasetFile</b>: The filename of the dataset file.</li>
	 * <li><b>distanceMeasureAbsoluteToRelative</b>: If the dataset contains
	 * absolute coordinates, this measure is used to calculate the pairwise
	 * distances/similarities between the object pairs.</li>
	 * </ul>
	 * 
	 * @param absConfigPath
	 *            The absolute path to the dataset configuration file.
	 * @throws DataSetConfigurationException
	 * @throws NoRepositoryFoundException
	 * @throws DataSetConfigNotFoundException
	 * @throws UnknownDistanceMeasureException
	 * @throws RegisterException
	 * @throws NumberFormatException
	 * @return The dataset configuration object.
	 * @throws UnknownDataPreprocessorException
	 */
	public static DataSetConfig parseFromFile(final File absConfigPath)
			throws DataSetConfigurationException, NoRepositoryFoundException,
			DataSetConfigNotFoundException, UnknownDistanceMeasureException,
			RegisterException, NumberFormatException,
			UnknownDataPreprocessorException {

		if (!absConfigPath.exists())
			throw new DataSetConfigNotFoundException("Dataset config \""
					+ absConfigPath + "\" does not exist!");

		LoggerFactory.getLogger(DataSetConfig.class).debug(
				"Parsing dataset config \"" + absConfigPath + "\"");

		try {
			HierarchicalINIConfiguration props = new HierarchicalINIConfiguration(
					absConfigPath);
			props.setThrowExceptionOnMissing(true);

			final long changeDate = absConfigPath.lastModified();
			String datasetName = props.getString("datasetName");
			String datasetFile = props.getString("datasetFile");

			Repository repo = Repository.getRepositoryForPath(absConfigPath
					.getAbsolutePath());

			DistanceMeasure distanceMeasure;
			if (props.containsKey("distanceMeasureAbsoluteToRelative")) {
				distanceMeasure = DistanceMeasure.parseFromString(repo,
						props.getString("distanceMeasureAbsoluteToRelative"));
			} else
				distanceMeasure = DistanceMeasure.parseFromString(repo,
						"EuclidianDistanceMeasure");

			// added 12.04.2013
			List<DataPreprocessor> preprocessorBeforeDistance;
			if (props.containsKey("preprocessorBeforeDistance")) {
				preprocessorBeforeDistance = DataPreprocessor.parseFromString(
						repo,
						props.getStringArray("preprocessorBeforeDistance"));
			} else
				preprocessorBeforeDistance = new ArrayList<DataPreprocessor>();

			List<DataPreprocessor> preprocessorAfterDistance;
			if (props.containsKey("preprocessorAfterDistance")) {
				preprocessorAfterDistance = DataPreprocessor
						.parseFromString(repo, props
								.getStringArray("preprocessorAfterDistance"));
			} else
				preprocessorAfterDistance = new ArrayList<DataPreprocessor>();

			ConversionInputToStandardConfiguration configInputToStandard = new ConversionInputToStandardConfiguration(
					distanceMeasure, preprocessorBeforeDistance,
					preprocessorAfterDistance);
			ConversionStandardToInputConfiguration configStandardToInput = new ConversionStandardToInputConfiguration();

			// we take the dataset from the runresult repository
			DataSet dataSet = repo.getObjectWithName(DataSet.class,datasetName + "/"
					+ datasetFile);

			DataSetConfig result = new DataSetConfig(repo, changeDate,
					absConfigPath, dataSet, configInputToStandard,
					configStandardToInput);
			result = repo.getRegisteredObject(result);
			return result;
		} catch (ConfigurationException e) {
			throw new DataSetConfigurationException(e);
		} catch (NoSuchElementException e) {
			throw new DataSetConfigurationException(e);
		}
	}

}
