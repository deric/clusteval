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
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import de.clusteval.data.DataConfig;
import de.clusteval.data.dataset.DataSet;
import de.clusteval.data.dataset.generator.DataSetGenerationException;
import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.repository.RepositoryObject;
import de.clusteval.program.r.RLibraryInferior;
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
	public RepositoryObject clone() {
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

	/**
	 * This method has to be invoked with command line arguments for this
	 * generator. Valid arguments are defined by the options returned by
	 * {@link #getOptions()}.
	 * 
	 * @param cliArguments
	 * @return The generated {@link DataSet}.
	 * @throws ParseException
	 *             This exception is thrown, if the passed arguments are not
	 *             valid.
	 */
	public DataConfig randomize(final String[] cliArguments)
			throws ParseException {
		CommandLineParser parser = new PosixParser();

		Options options = this.getAllOptions();

		CommandLine cmd = parser.parse(options, cliArguments);

		// get data config with the specified name
		String absFilePath = FileUtils.buildPath(
				this.repository.getBasePath(DataConfig.class),
				cmd.getOptionValue("dataConfig") + ".dataconfig");
		this.dataConfig = (DataConfig) this.repository
				.getRegisteredObject(new File(absFilePath));

		this.handleOptions(cmd);

		DataConfig dataConfig = randomizeDataConfig();

		return dataConfig;
	}

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
	 * @return A {@link DataConfig} wrapper object for the randomized
	 *         dataconfig.
	 * @throws DataSetGenerationException
	 *             If something goes wrong during the generation process, this
	 *             exception is thrown.
	 */
	protected abstract DataConfig randomizeDataConfig();

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
