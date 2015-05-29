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
package de.clusteval.data.randomizer;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.configuration.ConfigurationException;

import utils.Pair;
import de.clusteval.cluster.paramOptimization.IncompatibleParameterOptimizationMethodException;
import de.clusteval.cluster.paramOptimization.InvalidOptimizationParameterException;
import de.clusteval.cluster.paramOptimization.UnknownParameterOptimizationMethodException;
import de.clusteval.cluster.quality.UnknownClusteringQualityMeasureException;
import de.clusteval.context.IncompatibleContextException;
import de.clusteval.context.UnknownContextException;
import de.clusteval.data.DataConfig;
import de.clusteval.data.DataConfigNotFoundException;
import de.clusteval.data.DataConfigurationException;
import de.clusteval.data.dataset.DataSet;
import de.clusteval.data.dataset.DataSetConfig;
import de.clusteval.data.dataset.DataSetConfigNotFoundException;
import de.clusteval.data.dataset.DataSetConfigurationException;
import de.clusteval.data.dataset.DataSetNotFoundException;
import de.clusteval.data.dataset.IncompatibleDataSetConfigPreprocessorException;
import de.clusteval.data.dataset.NoDataSetException;
import de.clusteval.data.dataset.format.UnknownDataSetFormatException;
import de.clusteval.data.dataset.generator.DataSetGenerationException;
import de.clusteval.data.dataset.type.UnknownDataSetTypeException;
import de.clusteval.data.distance.UnknownDistanceMeasureException;
import de.clusteval.data.goldstandard.GoldStandard;
import de.clusteval.data.goldstandard.GoldStandardConfig;
import de.clusteval.data.goldstandard.GoldStandardConfigNotFoundException;
import de.clusteval.data.goldstandard.GoldStandardConfigurationException;
import de.clusteval.data.goldstandard.GoldStandardNotFoundException;
import de.clusteval.data.preprocessing.UnknownDataPreprocessorException;
import de.clusteval.data.statistics.UnknownDataStatisticException;
import de.clusteval.framework.repository.NoRepositoryFoundException;
import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.repository.RepositoryObject;
import de.clusteval.framework.repository.RepositoryObjectDumpException;
import de.clusteval.framework.repository.parse.Parser;
import de.clusteval.program.NoOptimizableProgramParameterException;
import de.clusteval.program.UnknownParameterType;
import de.clusteval.program.UnknownProgramParameterException;
import de.clusteval.program.UnknownProgramTypeException;
import de.clusteval.program.r.RLibraryInferior;
import de.clusteval.program.r.UnknownRProgramException;
import de.clusteval.run.RunException;
import de.clusteval.run.result.format.UnknownRunResultFormatException;
import de.clusteval.run.result.postprocessing.UnknownRunResultPostprocessorException;
import de.clusteval.run.statistics.UnknownRunDataStatisticException;
import de.clusteval.run.statistics.UnknownRunStatisticException;
import file.FileUtils;

/**
 * @author Christian Wiwie
 * 
 */
public abstract class DataRandomizer extends RepositoryObject
		implements
			RLibraryInferior {

	/**
	 * This attribute holds the name of the data configuration to randomize.
	 */
	protected DataConfig dataConfig;

	protected String uniqueId;

	protected boolean onlySimulate;

	/**
	 * @param repository
	 * @param register
	 * @param changeDate
	 * @param absPath
	 * @throws RegisterException
	 */
	public DataRandomizer(Repository repository, boolean register,
			long changeDate, File absPath) throws RegisterException {
		super(repository, register, changeDate, absPath);
	}

	/**
	 * The copy constructor of dataset randomizer.
	 * 
	 * @param other
	 *            The object to clone.
	 * @throws RegisterException
	 */
	public DataRandomizer(DataRandomizer other) throws RegisterException {
		super(other);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.repository.RepositoryObject#clone()
	 */
	@Override
	public DataRandomizer clone() {
		try {
			return this.getClass().getConstructor(this.getClass())
					.newInstance(this);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		this.log.warn("Cloning instance of class "
				+ this.getClass().getSimpleName() + " failed");
		return null;
	}

	/**
	 * @return A wrapper object keeping all options of your dataset generator
	 *         together with the default options of all dataset generators. The
	 *         options returned by this method are going to be used and
	 *         interpreted in your subclass implementation in
	 *         {@link #randomizeDataConfig()} .
	 */
	public Options getAllOptions() {
		// options of actual generator implementation
		Options options = this.getOptions();

		// default options of all generators
		this.addDefaultOptions(options);
		return options;
	}

	/**
	 * @return A wrapper object keeping the options of your dataset generator.
	 *         The options returned by this method are going to be used and
	 *         interpreted in your subclass implementation in
	 *         {@link #generateDataSet()} .
	 */
	protected abstract Options getOptions();

	public DataConfig randomize(final String[] cliArguments)
			throws DataRandomizeException {
		return randomize(cliArguments, false);
	}

	/**
	 * This method has to be invoked with command line arguments for this
	 * generator. Valid arguments are defined by the options returned by
	 * {@link #getOptions()}.
	 * 
	 * @param cliArguments
	 * @return The generated {@link DataSet}.
	 * @throws DataRandomizeException
	 *             This exception is thrown, if the passed arguments are not
	 *             valid, or parsing of the written data set/ gold standard or
	 *             config files fails.
	 * @throws DataRandomizeException
	 */
	// TODO: remove onlySimulate attribute
	public DataConfig randomize(final String[] cliArguments,
			final boolean onlySimulate) throws DataRandomizeException {
		try {
			this.onlySimulate = onlySimulate;
			CommandLineParser parser = new PosixParser();

			Options options = this.getAllOptions();

			CommandLine cmd = parser.parse(options, cliArguments);

			// get data config with the specified name
			String absFilePath = FileUtils.buildPath(
					this.repository.getBasePath(DataConfig.class),
					cmd.getOptionValue("dataConfig") + ".dataconfig");
			this.dataConfig = (DataConfig) this.repository
					.getRegisteredObject(new File(absFilePath));

			this.uniqueId = cmd.getOptionValue("uniqueId");

			this.handleOptions(cmd);

			Pair<DataSet, GoldStandard> newObjects = randomizeDataConfig();

			DataConfig dataConfig = this.writeConfigFiles(
					newObjects.getFirst(), newObjects.getSecond());

			return dataConfig;
		} catch (Exception e) {
			throw new DataRandomizeException(e);
		}
	}

	protected DataConfig writeConfigFiles(final DataSet newDataSet,
			final GoldStandard newGoldStandard) throws IOException,
			UnknownDataSetFormatException, GoldStandardNotFoundException,
			GoldStandardConfigurationException, DataSetConfigurationException,
			DataSetNotFoundException, DataSetConfigNotFoundException,
			GoldStandardConfigNotFoundException, NoDataSetException,
			DataConfigurationException, DataConfigNotFoundException,
			NumberFormatException, ConfigurationException,
			UnknownContextException, RegisterException, UnknownParameterType,
			NoRepositoryFoundException,
			UnknownClusteringQualityMeasureException, RunException,
			IncompatibleContextException, UnknownRunResultFormatException,
			InvalidOptimizationParameterException,
			UnknownProgramParameterException, UnknownProgramTypeException,
			UnknownRProgramException, UnknownDistanceMeasureException,
			UnknownDataSetTypeException, UnknownDataPreprocessorException,
			IncompatibleDataSetConfigPreprocessorException,
			IncompatibleParameterOptimizationMethodException,
			UnknownParameterOptimizationMethodException,
			NoOptimizableProgramParameterException,
			UnknownDataStatisticException, UnknownRunStatisticException,
			UnknownRunDataStatisticException,
			UnknownRunResultPostprocessorException,
			UnknownDataRandomizerException, RepositoryObjectDumpException {
		// write dataset config file
		File dsConfigFile = new File(FileUtils.buildPath(
				repository.getBasePath(DataSetConfig.class), this.uniqueId
						+ "_" + this.dataConfig.getDatasetConfig().toString()
						+ getDataSetFileNamePostFix() + ".dsconfig"));
		DataSetConfig dsConfig = new DataSetConfig(this.repository,
				System.currentTimeMillis(), dsConfigFile, newDataSet,
				this.dataConfig.getDatasetConfig()
						.getConversionInputToStandardConfiguration().clone(),
				this.dataConfig.getDatasetConfig()
						.getConversionStandardToInputConfiguration().clone());
		if (!this.onlySimulate)
			dsConfig.dumpToFile();

		File gsConfigFile = new File(FileUtils.buildPath(
				repository.getBasePath(GoldStandardConfig.class), this.uniqueId
						+ "_"
						+ this.dataConfig.getGoldstandardConfig().toString()
						+ getDataSetFileNamePostFix() + ".gsconfig"));

		// write goldstandard config file
		GoldStandardConfig gsConfig = new GoldStandardConfig(this.repository,
				System.currentTimeMillis(), gsConfigFile, newGoldStandard);
		if (!this.onlySimulate)
			gsConfig.dumpToFile();

		// write data config file
		File dataConfigFile = new File(FileUtils.buildPath(
				repository.getBasePath(DataConfig.class), this.uniqueId + "_"
						+ this.dataConfig.getName()
						+ getDataSetFileNamePostFix() + ".dataconfig"));
		DataConfig dataConfig = new DataConfig(this.repository,
				System.currentTimeMillis(), dataConfigFile, dsConfig, gsConfig);
		if (!this.onlySimulate)
			dataConfig.dumpToFile();

		return dataConfig;
	}

	protected abstract String getDataSetFileNamePostFix();

	/**
	 * Adds the default options of dataset generators to the given Options
	 * attribute
	 * 
	 * @param options
	 *            The existing Options attribute, holding already the options of
	 *            the actual generator implementation.
	 */
	private void addDefaultOptions(final Options options) {
		OptionBuilder.withArgName("dataConfig");
		OptionBuilder.isRequired();
		OptionBuilder.hasArg();
		OptionBuilder
				.withDescription("The name of the data configuration to randomize");
		Option option = OptionBuilder.create("dataConfig");
		options.addOption(option);

		OptionBuilder.withArgName("uniqueId");
		OptionBuilder.isRequired();
		OptionBuilder.hasArg();
		OptionBuilder
				.withDescription("A unique id (infix) for the generated files.");
		option = OptionBuilder.create("uniqueId");
		options.addOption(option);
	}

	/**
	 * This method is reponsible for interpreting the arguments passed to this
	 * generator call and to initialize possibly needed member variables.
	 * 
	 * <p>
	 * If you want to react to certain options in your implementation of
	 * {@link #generateDataSet()}, initialize member variables in this method.
	 * 
	 * @param cmd
	 *            A wrapper object for the arguments passed to this generator.
	 * @throws ParseException
	 */
	protected abstract void handleOptions(final CommandLine cmd)
			throws ParseException;

	/**
	 * This method needs to be implemented in subclasses and is a helper method
	 * for {@link #randomize(String[])}. It provides the core of a dataset
	 * generator by generating the dataset file and creating a {@link DataSet}
	 * wrapper object for it.
	 * 
	 * @throws DataSetGenerationException
	 *             If something goes wrong during the generation process, this
	 *             exception is thrown.
	 */
	protected abstract Pair<DataSet, GoldStandard> randomizeDataConfig();

	/**
	 * Parses a dataconfig randomizer from string.
	 * 
	 * @param repository
	 *            the repository
	 * @param dataRandomizer
	 *            The simple name of the dataset randomizer class.
	 * @return the clustering quality measure
	 * @throws UnknownDataRandomizerException
	 */
	public static DataRandomizer parseFromString(final Repository repository,
			String dataRandomizer) throws UnknownDataRandomizerException {

		Class<? extends DataRandomizer> c = repository.getRegisteredClass(
				DataRandomizer.class, "de.clusteval.data.randomizer."
						+ dataRandomizer);
		try {
			DataRandomizer generator = c.getConstructor(Repository.class,
					boolean.class, long.class, File.class).newInstance(
					repository, false, System.currentTimeMillis(),
					new File(dataRandomizer));
			return generator;

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {

		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		}
		throw new UnknownDataRandomizerException("\"" + dataRandomizer
				+ "\" is not a known data randomizer.");
	}
}
