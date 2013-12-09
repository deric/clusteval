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
import de.clusteval.data.dataset.format.UnknownDataSetFormatException;
import de.clusteval.data.dataset.type.UnknownDataSetTypeException;
import de.clusteval.data.distance.DistanceMeasure;
import de.clusteval.data.distance.UnknownDistanceMeasureException;
import de.clusteval.data.preprocessing.DataPreprocessor;
import de.clusteval.data.preprocessing.UnknownDataPreprocessorException;
import de.clusteval.framework.repository.NoRepositoryFoundException;
import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.repository.RepositoryEvent;
import de.clusteval.framework.repository.RepositoryObject;
import de.clusteval.framework.repository.RepositoryRemoveEvent;
import de.clusteval.framework.repository.RepositoryReplaceEvent;
import file.FileUtils;

/**
 * 
 * A dataset configuration encapsulates options and settings for a dataset.
 * During the execution of a run, when programs are applied to datasets,
 * settings are required that control the behaviour of how the dataset has to be
 * handled.
 * 
 * <p>
 * A dataset configuration corresponds to and is parsed from a file on the
 * filesystem in the corresponding folder of the repository (see
 * {@link Repository#dataSetConfigBasePath} and {@link DataSetConfigFinder}).
 * 
 * <p>
 * There are several options, that can be specified in the dataset configuration
 * file (see {@link #parseFromFile(File)}).
 * 
 * @author Christian Wiwie
 * 
 */
public class DataSetConfig extends RepositoryObject {

	/**
	 * A dataset configuration encapsulates a dataset. This attribute stores a
	 * reference to the dataset wrapper object.
	 */
	protected DataSet dataset;

	/**
	 * This variable holds the configuration needed, when {@link #dataset} is
	 * converted from its original input format to the internal standard format
	 * of the framework.
	 */
	protected ConversionInputToStandardConfiguration configInputToStandard;

	/**
	 * This variable holds the configuration needed, when {@link #dataset} is
	 * converted from the internal standard format of the framework to the input
	 * format of a program.
	 */
	protected ConversionStandardToInputConfiguration configStandardToInput;

	/**
	 * Instantiates a new dataset configuration.
	 * 
	 * @param repository
	 *            The repository this dataset configuration should be registered
	 *            at.
	 * @param changeDate
	 *            The change date of this dataset configuration is used for
	 *            equality checks.
	 * @param absPath
	 *            The absolute path of this dataset configuration.
	 * @param ds
	 *            The encapsulated dataset.
	 * @param configInputToStandard
	 *            The configuration needed, when {@link #dataset} is converted
	 *            from its original input format to the internal standard format
	 *            of the framework.
	 * @param configStandardToInput
	 *            The configuration needed, when {@link #dataset} is converted
	 *            from the internal standard format of the framework to the
	 *            input format of a program.
	 * @throws RegisterException
	 */
	public DataSetConfig(final Repository repository, final long changeDate,
			final File absPath, final DataSet ds,
			final ConversionInputToStandardConfiguration configInputToStandard,
			final ConversionStandardToInputConfiguration configStandardToInput)
			throws RegisterException {
		super(repository, false, changeDate, absPath);

		this.dataset = ds;
		this.configInputToStandard = configInputToStandard;
		this.configStandardToInput = configStandardToInput;

		if (this.register()) {
			this.dataset.addListener(this);

			// added 21.03.2013: register only, if this dataset config has been
			// registered before
			this.configInputToStandard.getDistanceMeasureAbsoluteToRelative()
					.register();
			this.configInputToStandard.getDistanceMeasureAbsoluteToRelative()
					.addListener(this);
		}
	}

	/**
	 * The copy constructor for dataset configurations.
	 * 
	 * @param datasetConfig
	 *            The dataset configuration to be cloned.
	 * @throws RegisterException
	 */
	public DataSetConfig(DataSetConfig datasetConfig) throws RegisterException {
		super(datasetConfig);

		this.dataset = datasetConfig.dataset.clone();
		this.configInputToStandard = datasetConfig.configInputToStandard
				.clone();
		this.configStandardToInput = datasetConfig.configStandardToInput
				.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.repository.RepositoryObject#clone()
	 */
	@Override
	public DataSetConfig clone() {
		try {
			return new DataSetConfig(this);
		} catch (RegisterException e) {
			// should not occur
			e.printStackTrace();
		}
		return null;
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
	 * <li><b>preprocessorBeforeDistance</b>: A comma seperated list of data
	 * preprocessors to apply, before the data is converted to pairwise
	 * similarities (the standard input format)</li>
	 * <li><b>preprocessorAfterDistance</b>: A comma seperated list of data
	 * preprocessors to apply, after the data is converted to pairwise
	 * similarities (the standard input format)</li>
	 * </ul>
	 * 
	 * @param absConfigPath
	 *            The absolute path to the dataset configuration file.
	 * @throws DataSetConfigurationException
	 * @throws UnknownDataSetFormatException
	 * @throws NoRepositoryFoundException
	 * @throws DataSetNotFoundException
	 * @throws DataSetConfigNotFoundException
	 * @throws UnknownDistanceMeasureException
	 * @throws RegisterException
	 * @throws UnknownDataSetTypeException
	 * @throws NumberFormatException
	 * @throws NoDataSetException
	 * @return The dataset configuration object.
	 * @throws UnknownDataPreprocessorException
	 * @throws IncompatibleDataSetConfigPreprocessorException
	 */
	public static DataSetConfig parseFromFile(final File absConfigPath)
			throws DataSetConfigurationException,
			UnknownDataSetFormatException, NoRepositoryFoundException,
			DataSetNotFoundException, DataSetConfigNotFoundException,
			UnknownDistanceMeasureException, RegisterException,
			UnknownDataSetTypeException, NumberFormatException,
			NoDataSetException, UnknownDataPreprocessorException,
			IncompatibleDataSetConfigPreprocessorException {

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

			DataSet dataSet = DataSet.parseFromFile(new File(FileUtils
					.buildPath(repo.getBasePath(DataSet.class), datasetName,
							datasetFile)));

			// added 12.04.2013
			List<DataPreprocessor> preprocessorBeforeDistance;
			if (props.containsKey("preprocessorBeforeDistance")) {
				preprocessorBeforeDistance = DataPreprocessor.parseFromString(
						repo,
						props.getStringArray("preprocessorBeforeDistance"));

				for (DataPreprocessor proc : preprocessorBeforeDistance) {
					if (!proc.getCompatibleDataSetFormats().contains(
							dataSet.getDataSetFormat().getClass()
									.getSimpleName())) {
						throw new IncompatibleDataSetConfigPreprocessorException(
								"The data preprocessor "
										+ proc.getClass().getSimpleName()
										+ " cannot be applied to a dataset with format "
										+ dataSet.getDataSetFormat().getClass()
												.getSimpleName());
					}
				}
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

	/**
	 * @return The dataset, this configuration belongs to.
	 */
	public DataSet getDataSet() {
		return dataset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.RepositoryObject#notify(utils.RepositoryEvent)
	 */
	@Override
	public void notify(RepositoryEvent e) throws RegisterException {
		if (e instanceof RepositoryReplaceEvent) {
			RepositoryReplaceEvent event = (RepositoryReplaceEvent) e;
			if (event.getOld().equals(this)) {
				super.notify(event);
			} else {
				if (event.getOld().equals(dataset)) {
					event.getOld().removeListener(this);
					this.log.info("DataSetConfig "
							+ this.absPath.getName()
							+ ": Dataset reloaded due to modifications in filesystem");
					event.getReplacement().addListener(this);
					// added 06.07.2012
					this.dataset = (DataSet) event.getReplacement();
				}
			}
		} else if (e instanceof RepositoryRemoveEvent) {
			RepositoryRemoveEvent event = (RepositoryRemoveEvent) e;
			if (event.getRemovedObject().equals(this))
				super.notify(event);
			else {
				if (event.getRemovedObject().equals(dataset)) {
					event.getRemovedObject().removeListener(this);
					this.log.info("DataSetConfig " + this
							+ ": Removed, because DataSet " + dataset
							+ " was removed.");
					RepositoryRemoveEvent newEvent = new RepositoryRemoveEvent(
							this);
					this.unregister();
					this.notify(newEvent);
				} else if (this.configInputToStandard
						.getDistanceMeasureAbsoluteToRelative().equals(
								event.getRemovedObject())) {
					event.getRemovedObject().removeListener(this);
					this.log.info("DataSetConfig " + this
							+ ": Removed, because DistanceMeasure "
							+ event.getRemovedObject() + " was removed.");
					RepositoryRemoveEvent newEvent = new RepositoryRemoveEvent(
							this);
					this.unregister();
					this.notify(newEvent);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.absPath.getName().replace(".dsconfig", "");
	}

	/**
	 * @return The configuration for conversion from the original input format
	 *         to the standard format.
	 * @see #configInputToStandard
	 */
	public ConversionInputToStandardConfiguration getConversionInputToStandardConfiguration() {
		return this.configInputToStandard;
	}

	/**
	 * @return The configuration for conversion from standard format to the
	 *         input format of the clustering method.
	 * @see #configStandardToInput
	 */
	public ConversionStandardToInputConfiguration getConversionStandardToInputConfiguration() {
		return this.configStandardToInput;
	}

	/**
	 * @param dataset
	 *            The new dataset
	 */
	public void setDataSet(DataSet dataset) {
		this.dataset = dataset;
	}
}
