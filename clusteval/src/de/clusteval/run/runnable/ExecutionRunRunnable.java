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
package de.clusteval.run.runnable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.slf4j.LoggerFactory;

import utils.Pair;
import utils.StringExt;
import utils.Triple;
import utils.parse.TextFileParser;
import utils.parse.TextFileParser.OUTPUT_MODE;
import de.clusteval.cluster.ClusterItem;
import de.clusteval.cluster.Clustering;
import de.clusteval.cluster.paramOptimization.NoParameterSetFoundException;
import de.clusteval.cluster.quality.ClusteringQualityMeasure;
import de.clusteval.cluster.quality.ClusteringQualitySet;
import de.clusteval.data.DataConfig;
import de.clusteval.data.dataset.AbsoluteDataSet;
import de.clusteval.data.dataset.DataSet;
import de.clusteval.data.dataset.DataSetConfig;
import de.clusteval.data.dataset.RelativeDataSet;
import de.clusteval.data.dataset.format.ConversionInputToStandardConfiguration;
import de.clusteval.data.dataset.format.ConversionStandardToInputConfiguration;
import de.clusteval.data.dataset.format.DataSetFormat;
import de.clusteval.data.dataset.format.IncompatibleDataSetFormatException;
import de.clusteval.data.dataset.format.InvalidDataSetFormatVersionException;
import de.clusteval.data.dataset.format.UnknownDataSetFormatException;
import de.clusteval.data.goldstandard.GoldStandard;
import de.clusteval.data.goldstandard.GoldStandardConfig;
import de.clusteval.data.goldstandard.IncompleteGoldStandardException;
import de.clusteval.data.goldstandard.format.UnknownGoldStandardFormatException;
import de.clusteval.framework.ClustevalBackendServer;
import de.clusteval.framework.RLibraryNotLoadedException;
import de.clusteval.framework.RProcess;
import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.framework.repository.RunResultRepository;
import de.clusteval.framework.threading.RunSchedulerThread;
import de.clusteval.program.ParameterSet;
import de.clusteval.program.ProgramConfig;
import de.clusteval.program.ProgramParameter;
import de.clusteval.program.r.RProgram;
import de.clusteval.run.ExecutionRun;
import de.clusteval.run.MissingParameterValueException;
import de.clusteval.run.Run;
import de.clusteval.run.result.ClusteringRunResult;
import de.clusteval.run.result.NoRunResultFormatParserException;
import de.clusteval.run.result.format.RunResultFormat;
import de.clusteval.run.result.format.RunResultNotFoundException;
import de.clusteval.run.result.postprocessing.RunResultPostprocessor;
import de.clusteval.utils.FormatConversionException;
import de.clusteval.utils.InternalAttributeException;
import de.clusteval.utils.RNotAvailableException;
import de.clusteval.utils.plot.Plotter;
import file.FileUtils;
import format.Formatter;

/**
 * A type of a runnable, that corresponds to {@link ExecutionRun}s and is
 * therefore responsible for performing program configurations and certain data
 * configurations.
 * 
 * @author Christian Wiwie
 * 
 */
public abstract class ExecutionRunRunnable extends RunRunnable {

	/**
	 * The program configuration this thread combines with a data configuration.
	 */
	protected ProgramConfig programConfig;

	/**
	 * The data configuration this thread combines with a program configuration.
	 */
	protected DataConfig dataConfig;

	/**
	 * This is the run result format of the program that is being executed by
	 * this runnable.
	 */
	protected RunResultFormat format;

	/**
	 * A map containing all the parameter values set in the run.
	 */
	protected Map<ProgramParameter<?>, String> runParams;

	/**
	 * A temporary variable holding the absolute path to the current complete
	 * quality output file during execution of the runnable.
	 */
	protected String completeQualityOutput;

	/**
	 * This list holds wrapper objects for each iteration runnable started.
	 */
	protected List<Future<?>> futures;
	protected List<IterationRunnable> iterationRunnables;

	//
	// /**
	// * A temporary variable holding a file object pointing to the absolute
	// path
	// * of the current log output file during execution of the runnable
	// */
	// protected File logFile;

	// /**
	// * A temporary variable holding a file object pointing to the absolute
	// path
	// * of the current clustering output file during execution of the runnable
	// */
	// protected File clusteringResultFile;
	//
	// /**
	// * A temporary variable holding a file object pointing to the absolute
	// path
	// * of the current clustering quality output file during execution of the
	// * runnable
	// */
	// protected File resultQualityFile;

	// /**
	// * This number indicates the current iteration performed by the runnable
	// * object.
	// *
	// * <p>
	// * This is only larger than 1, if we are in PARAMETER_OPTIMIZATION mode.
	// * Then the optimization method will determine, how often we iterate in
	// * total and this attribute will be increased by the runnable after every
	// * iteration.
	// */
	// protected int optId;

	/**
	 * @param run
	 *            The run this runnable belongs to.
	 * @param runIdentString
	 *            The unique identification string of the run which is used to
	 *            store the results in a unique folder to avoid overwriting.
	 * @param programConfig
	 *            The program configuration encapsulating the program executed
	 *            by this runnable.
	 * @param dataConfig
	 *            The data configuration used by this runnable.
	 * @param isResume
	 *            True, if this run is a resumption of a previous execution or a
	 *            completely new execution.
	 */
	public ExecutionRunRunnable(Run run, ProgramConfig programConfig,
			DataConfig dataConfig, String runIdentString, boolean isResume) {
		super(run, runIdentString, isResume);

		this.programConfig = programConfig;
		this.dataConfig = dataConfig;
		this.futures = new ArrayList<Future<?>>();
		this.iterationRunnables = new ArrayList<IterationRunnable>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see run.getRun()nable.RunRunnable#getRun()
	 */
	@Override
	public ExecutionRun getRun() {
		return (ExecutionRun) super.getRun();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.clusteval.run.runnable.RunRunnable#terminate()
	 */
	@Override
	public void terminate() {
		// TODO: cancel all the iteration threads
		for (Future<?> f : this.futures)
			f.cancel(true);

		super.terminate();
	}

	/**
	 * A helper method to write a header into the complete quality output in the
	 * beginning.
	 * 
	 * <p>
	 * If at all, then this method is invoked by {@link #beginRun()} before
	 * anything has been executed by the runnable.
	 */
	protected void writeHeaderIntoCompleteFile(
			final String completeQualityOutput) {
		StringBuilder sb = new StringBuilder();
		// 04.04.2013: adding iteration numbers into complete file
		sb.append("iteration\t");
		for (int p = 0; p < programConfig.getOptimizableParams().size(); p++) {
			ProgramParameter<?> param = programConfig.getOptimizableParams()
					.get(p);
			if (p > 0)
				sb.append(",");
			sb.append(param);
		}
		sb.append("\t");
		for (ClusteringQualityMeasure measure : this.getRun()
				.getQualityMeasures()) {
			sb.append(measure.getClass().getSimpleName());
			sb.append("\t");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("\n");

		FileUtils.appendStringToFile(completeQualityOutput, sb.toString());
	}

	/**
	 * This method checks, whether the format of the data input is compatible to
	 * the input formats of the program configuration.
	 * 
	 * @return True, if compatible, false otherwise.
	 * @throws IOException
	 * @throws RegisterException
	 */
	protected boolean preprocessAndCheckCompatibleDataSetFormat()
			throws IOException, RegisterException {

		ConversionInputToStandardConfiguration configInputToStandard = dataConfig
				.getDatasetConfig().getConversionInputToStandardConfiguration();
		ConversionStandardToInputConfiguration configStandardToInput = dataConfig
				.getDatasetConfig().getConversionStandardToInputConfiguration();

		/*
		 * Added 18.09.2012: only one conversion operation per dataset at a
		 * time. otherwise we can have problems
		 */
		File datasetFile = ClustevalBackendServer.getCommonFile(new File(
				dataConfig.getDatasetConfig().getDataSet().getAbsolutePath()));
		synchronized (datasetFile) {
			/*
			 * Check, whether this program can be applied to this dataset, i.e.
			 * either they are directly compatible or the dataset can be
			 * converted to another compatible DataSetFormat.
			 */
			List<DataSetFormat> compatibleDsFormats = programConfig
					.getCompatibleDataSetFormats();
			boolean found = false;
			// try to find a compatible format we can use and convert
			for (DataSetFormat compFormat : compatibleDsFormats) {
				try {
					DataSet ds = dataConfig
							.getDatasetConfig()
							.getDataSet()
							.preprocessAndConvertTo(this.run.getContext(),
									compFormat, configInputToStandard,
									configStandardToInput);

					// added 23.01.2013: rename the new dataset, unique for the
					// program configuration
					int indexOfLastExt = ds.getAbsolutePath().lastIndexOf(".");
					if (indexOfLastExt == -1)
						indexOfLastExt = ds.getAbsolutePath().length();
					String newFileName = ds.getAbsolutePath().substring(0,
							indexOfLastExt)
							+ "_"
							+ programConfig.getName()
							+ ds.getAbsolutePath().substring(indexOfLastExt);
					// if the new dataset file is the same file as the old one,
					// we copy it instead of moving
					if (ds.getAbsolutePath().equals(
							dataConfig.getDatasetConfig().getDataSet()
									.getAbsolutePath())) {
						ds.copyTo(new File(newFileName), false, true);
					} else
						ds.move(new File(newFileName), false);

					dataConfig.getDatasetConfig().setDataSet(ds);
					// found a convertable compatible format
					found = true;
					break;
				} catch (FormatConversionException e) {
				} catch (InvalidDataSetFormatVersionException e) {
					e.printStackTrace();
				} catch (RNotAvailableException e) {
					e.printStackTrace();
				}
			}
			return found;
		}
	}

	/**
	 * This method checks, whether the dataset is compatible to the
	 * goldstandard, by verifying, that all objects contained in the dataset
	 * have an entry in the goldstandard and vice versa.
	 * 
	 * @param dataSetConfig
	 *            The dataset configuration encapsulating the dataset to be
	 *            checked.
	 * @param goldStandardConfig
	 *            The goldstandard configuration encapsulating the
	 *            goldstandardto be checked.
	 * @throws IOException
	 * @throws UnknownGoldStandardFormatException
	 * @throws UnknownDataSetFormatException
	 * @throws IncompleteGoldStandardException
	 * @throws InvalidDataSetFormatVersionException
	 * @throws IllegalArgumentException
	 */
	protected void checkCompatibilityDataSetGoldStandard(
			DataSetConfig dataSetConfig, GoldStandardConfig goldStandardConfig)
			throws UnknownGoldStandardFormatException,
			IncompleteGoldStandardException, IllegalArgumentException {
		this.log.info("Checking compatibility of goldstandard and dataset ...");
		DataSet dataSet = dataSetConfig.getDataSet().getInStandardFormat();
		File dataSetFile = ClustevalBackendServer.getCommonFile(new File(
				dataSet.getAbsolutePath()));
		synchronized (dataSetFile) {
			GoldStandard goldStandard = goldStandardConfig.getGoldstandard();
			File goldStandardFile = ClustevalBackendServer
					.getCommonFile(new File(goldStandard.getAbsolutePath()));
			synchronized (goldStandardFile) {

				/*
				 * Check whether all ids in the dataset have a corresponding
				 * entry in the gold standard
				 */
				// dataSet.loadIntoMemory();
				goldStandard.loadIntoMemory();

				final Set<String> ids = new HashSet<String>(dataSet.getIds());
				final Set<ClusterItem> gsItems = goldStandard.getClustering()
						.getClusterItems();
				final Set<String> gsIds = new HashSet<String>();
				for (ClusterItem item : gsItems)
					gsIds.add(item.getId());

				if (!gsIds.containsAll(ids)) {
					ids.removeAll(gsIds);
					throw new IncompleteGoldStandardException(ids);
				}
			}
		}
	}

	/**
	 * @return The program configuration of this runnable.
	 */
	public ProgramConfig getProgramConfig() {
		return this.programConfig;
	}

	/**
	 * @return The data configuration of this runnable.
	 */
	public DataConfig getDataConfig() {
		return this.dataConfig;
	}

	/**
	 * Helper method for
	 * {@link #parseInvocationLineAndEffectiveParameters(String, String, Map, Map, Map, StringBuilder)}
	 * <p>
	 * Get the original invocation line format from the program configuration
	 * without replacing of any parameters.
	 * 
	 * @return The invocation line.
	 */
	protected String getInvocationFormat() {
		// added 16.01.2013
		if (programConfig.getProgram() instanceof RProgram) {
			return ((RProgram) programConfig.getProgram())
					.getInvocationFormat();
		}
		return programConfig.getInvocationFormat(!dataConfig
				.hasGoldStandardConfig());
	}

	/**
	 * Helper method for
	 * {@link #parseInvocationLineAndEffectiveParameters(String, String, Map, Map, Map, StringBuilder)}
	 * 
	 * <p>
	 * Replace the executable parameter %e% in the invocation line by the
	 * absolute path to the executable.
	 * 
	 * @param invocation
	 *            The invocation line without replaced executable parameter.
	 * @param internalParams
	 *            The map containing all internal parameters, e.g. the
	 *            executable path.
	 * @return The invocation line with replaced executable parameter.
	 */
	protected String[] parseExecutable(final String[] invocation,
			final Map<String, String> internalParams) {
		internalParams.put("e", programConfig.getProgram().getExecutable());
		String[] parsed = invocation.clone();
		for (int i = 0; i < parsed.length; i++)
			parsed[i] = parsed[i].replace("%e%", programConfig.getProgram()
					.getExecutable());
		return parsed;
	}

	/**
	 * Helper method for
	 * {@link #parseInvocationLineAndEffectiveParameters(String, String, Map, Map, Map, StringBuilder)}
	 * 
	 * <p>
	 * Replace the input parameter %i% in the invocation line by the absolute
	 * path to the input file.
	 * 
	 * @param invocation
	 *            The invocation line without replaced input parameter.
	 * @param internalParams
	 *            The map containing all internal parameters, e.g. the input
	 *            path.
	 * @return The invocation line with replaced input parameter.
	 */
	protected String[] parseInput(final String[] invocation,
			final Map<String, String> internalParams) {
		internalParams.put("i", dataConfig.getDatasetConfig().getDataSet()
				.getAbsolutePath());
		String[] parsed = invocation.clone();
		for (int i = 0; i < parsed.length; i++)
			parsed[i] = parsed[i].replace("%i%", dataConfig.getDatasetConfig()
					.getDataSet().getAbsolutePath());
		return parsed;
	}

	/**
	 * Helper method for
	 * {@link #parseInvocationLineAndEffectiveParameters(String, String, Map, Map, Map, StringBuilder)}
	 * 
	 * <p>
	 * Replace the goldstandard parameter %gs% in the invocation line by the
	 * absolute path to the goldstandard.
	 * 
	 * @param invocation
	 *            The invocation line without replaced goldstandard parameter.
	 * @param internalParams
	 *            The map containing all internal parameters, e.g. the
	 *            goldstandard path.
	 * @return The invocation line with replaced goldstandard parameter.
	 */
	protected String[] parseGoldStandard(final String[] invocation,
			final Map<String, String> internalParams) {
		if (!dataConfig.hasGoldStandardConfig())
			return invocation;
		internalParams.put("gs", dataConfig.getGoldstandardConfig()
				.getGoldstandard().getAbsolutePath());
		String[] parsed = invocation.clone();
		for (int i = 0; i < parsed.length; i++)
			parsed[i] = parsed[i].replace("%gs%", dataConfig
					.getGoldstandardConfig().getGoldstandard()
					.getAbsolutePath());
		return parsed;
	}

	/**
	 * Helper method for
	 * {@link #parseInvocationLineAndEffectiveParameters(String, String, Map, Map, Map, StringBuilder)}
	 * 
	 * <p>
	 * Replace the output parameter %o% in the invocation line by the absolute
	 * path to the output file.
	 * 
	 * @param invocation
	 *            The invocation line without replaced output parameter.
	 * @param internalParams
	 *            The map containing all internal parameters, e.g. the output
	 *            file path.
	 * @return The invocation line with replaced output parameter.
	 */
	protected String[] parseOutput(final String clusteringOutput,
			final String qualityOutput, final String[] invocation,
			final Map<String, String> internalParams) {
		internalParams.put("o", clusteringOutput);
		internalParams.put("q", qualityOutput);
		String[] parsed = invocation.clone();
		for (int i = 0; i < parsed.length; i++)
			parsed[i] = parsed[i].replace("%o%", clusteringOutput);
		return parsed;
	}

	/**
	 * This method builds up the invocation line by replacing placeholders of
	 * internal parameters by their actual runtime values:
	 * <ul>
	 * <li><b>%e%</b>: The absolute path to the executable</li>
	 * <li><b>%i%</b>: The absolute path to the input file</li>
	 * <li><b>%gs%</b>: The absolute path to the goldstandard file</li>
	 * <li><b>%o%</b>: The absolute path to the output file</li>
	 * </ul>
	 * <p>
	 * Afterwards, non-internal parameters are replaced, that means parameters,
	 * that are defined in the configuration files of the run or program in
	 * {@link #replaceRunParameters(String[])}, e.g.:
	 * <ul>
	 * <li><b>%T%</b> is replaced by 2.0</li>
	 * </ul>
	 * <p>
	 * All placeholders that are not replaced at this point are replaced by the
	 * default values of the corresponding parameters by invoking
	 * {@link #replaceDefaultParameters(String[])}. If the invocation line
	 * contains placeholders that cannot be mapped to a parameter, an exception
	 * is thrown and the process is terminated.
	 * 
	 * @return The parsed invocation line.
	 * 
	 * @throws InternalAttributeException
	 * @throws RegisterException
	 * @throws NoParameterSetFoundException
	 *             This exception is thrown, if no parameter set was found that
	 *             was not already evaluated before.
	 * 
	 */
	protected String[] parseInvocationLineAndEffectiveParameters(
			final IterationWrapper iterationWrapper)
			throws InternalAttributeException, RegisterException,
			NoParameterSetFoundException {

		final Map<String, String> internalParams = iterationWrapper
				.getInternalParams();
		final Map<String, String> effectiveParams = iterationWrapper
				.getEffectiveParams();

		/*
		 * We take the invocation line from the ProgramConfig and replace the
		 * variables %e%, %i%, %gs%, %o% by the absolute path to the executable,
		 * the input, the goldstandard and the output respectively.
		 */
		// split by spaces. this ensures compatibility for spaces in pathes that
		// might be inserted later.
		String[] invocation = getInvocationFormat().split(" ");

		/*
		 * Executable %e%
		 */
		invocation = parseExecutable(invocation, internalParams);

		/*
		 * input %i%
		 */
		invocation = parseInput(invocation, internalParams);

		/*
		 * goldstandard %gs%
		 */
		invocation = parseGoldStandard(invocation, internalParams);
		/*
		 * output %o%
		 */
		invocation = parseOutput(iterationWrapper.getClusteringResultFile()
				.getAbsolutePath(), iterationWrapper.getResultQualityFile()
				.getAbsolutePath(), invocation, internalParams);

		invocation = replaceRunParameters(invocation, effectiveParams);

		try {
			invocation = replaceDefaultParameters(invocation, effectiveParams);
		} catch (MissingParameterValueException e) {
			this.exceptions.add(e);
			return null;
		}

		return invocation;
	}

	/**
	 * Helper method for {@link #parseInvocationLineAndEffectiveParameters()}.
	 * 
	 * <p>
	 * All remaining parameters in the invocation line, that are not set to an
	 * actual value in the run configuration will be set to the default values
	 * of the corresponding parameters defined in the program configuration.
	 * Throw an exception if no value is set for a certain parameter-string.
	 * 
	 * @param invocation
	 * @return The invocation line with all parameters replaced.
	 * @throws MissingParameterValueException
	 * @throws InternalAttributeException
	 */
	protected String[] replaceDefaultParameters(String[] invocation,
			final Map<String, String> effectiveParams)
			throws MissingParameterValueException, InternalAttributeException {
		String[] parsed = invocation.clone();
		for (int i = 0; i < parsed.length; i++) {
			while (parsed[i].contains("%")) {
				int pos = parsed[i].indexOf("%");
				int endPos = parsed[i].indexOf("%", pos + 1);
				// variable string at very end of invocation line
				if (endPos < 0)
					endPos = parsed[i].length();

				String param = parsed[i].substring(pos + 1, endPos);
				ProgramParameter<?> pa = programConfig
						.getParameterForName(param);
				int arrPos = programConfig.getParams().indexOf(pa);
				if (arrPos < 0) {
					throw new MissingParameterValueException(
							"No value for parameter \"" + param + "\" given");
				}

				String def = programConfig.getParams().get(arrPos)
						.evaluateDefaultValue(dataConfig, programConfig)
						.toString();
				parsed[i] = parsed[i].replace("%" + param + "%", def);

				effectiveParams.put(pa.getName(), def);
			}
		}
		return parsed;
	}

	/**
	 * Helper method for {@link #parseInvocationLineAndEffectiveParameters()}.
	 * 
	 * <p>
	 * Non-internal parameters are replaced, that means parameters, that are
	 * defined in the configuration files of the run or program in
	 * {@link #replaceRunParameters(String)}.
	 * 
	 * @param invocation
	 * @return The invocation line with replaced run parameters.
	 * @throws InternalAttributeException
	 * @throws RegisterException
	 * @throws NoParameterSetFoundException
	 *             This exception is thrown, if no parameter set was found that
	 *             was not already evaluated before.
	 */
	@SuppressWarnings("unused")
	protected String[] replaceRunParameters(String[] invocation,
			final Map<String, String> effectiveParams)
			throws InternalAttributeException, RegisterException,
			NoParameterSetFoundException {
		/*
		 * Now, replace the remaining parameters given in the run configuration.
		 */

		String[] parsed = invocation.clone();
		for (int i = 0; i < parsed.length; i++)
			for (ProgramParameter<?> param : runParams.keySet()) {
				parsed[i] = parsed[i].replace("%" + param.getName() + "%",
						runParams.get(param));
				effectiveParams.put(param.getName(), runParams.get(param));
			}
		return parsed;
	}

	/**
	 * Method invoked by {@link #doRun()} which performs a single iteration of
	 * the run. If this runnable is of type parameter optimization, this method
	 * is invoked several times. In case of a clustering run, it is invoked only
	 * once.
	 * 
	 * <p>
	 * First this method initializes all files and folder structures in
	 * {@link #initAndEnsureIterationFilesAndFolders()} such that the following
	 * computations can be performed smoothly.
	 * <p>
	 * It initializes all attribute variables needed throughout the process
	 * itself and by invoking
	 * {@link #parseInvocationLineAndEffectiveParameters()}.
	 * <p>
	 * The clustering method is executed with the given parameter values and
	 * settings asynchronously. It waits until the second process finishes.
	 * <p>
	 * The result file of the clustering method is converted to the standard
	 * result format by invoking {@link #convertResult()}.
	 * <p>
	 * Next the qualities of the converted result file are assessed in
	 * {@link #assessQualities(ClusteringRunResult)}.
	 * <p>
	 * Then it invokes {@link #writeQualitiesToFile(List)}, which writes the
	 * assessed cluster qualities into files on the filesystem.
	 * <p>
	 * In {@link #afterClustering(ClusteringRunResult)} all actions are
	 * performed, that require the clustering process to be finished beforehand.
	 * <p>
	 * Last the result is added to the list of run results of the corresponding
	 * run of this runnable.
	 * <p>
	 * In case the run result is missing or cannot be parsed successfully,
	 * {@link #handleMissingRunResult()} is responsible for performing actions
	 * ensuring, that the next iterations can be executed without problems.
	 * 
	 * @throws InternalAttributeException
	 * @throws RegisterException
	 * @throws IOException
	 * @throws NoRunResultFormatParserException
	 * @throws NoParameterSetFoundException
	 *             This exception is thrown, if no parameter set was found that
	 *             was not already evaluated before.
	 * @throws REXPMismatchException
	 * @throws REngineException
	 * @throws RLibraryNotLoadedException
	 * @throws RNotAvailableException
	 * @throws InterruptedException
	 */
	protected void doRunIteration(final IterationWrapper iterationWrapper)
			throws InternalAttributeException, RegisterException, IOException,
			NoRunResultFormatParserException, NoParameterSetFoundException,
			RNotAvailableException, RLibraryNotLoadedException,
			InterruptedException {
		if (this.isPaused()) {
			log.info("Pausing...");
			this.runningTime += System.currentTimeMillis() - this.lastStartTime;
			while (this.isPaused()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
			log.info("Resuming...");
			this.lastStartTime = System.currentTimeMillis();
		}

		/*
		 * We check from time to time, whether this run got the order to
		 * terminate.
		 */
		if (checkForInterrupted())
			return;

		iterationWrapper.setRunnable(this);
		iterationWrapper.setDataConfig(dataConfig);
		iterationWrapper.setProgramConfig(programConfig.clone());

		this.initAndEnsureIterationFilesAndFolders(iterationWrapper);

		final String[] invocation = this
				.parseInvocationLineAndEffectiveParameters(iterationWrapper);

		/*
		 * An object that wraps up all results calculated during the execution
		 * of this runnable. The runnable is responsible for adding new results
		 * to this object during the execution.
		 */
		iterationWrapper.setClusteringRunResult(new ClusteringRunResult(this
				.getRun().getRepository(), System.currentTimeMillis(),
				iterationWrapper.getClusteringResultFile(), iterationWrapper
						.getDataConfig(), iterationWrapper.getProgramConfig(),
				format, runThreadIdentString, run));
		/*
		 * We check from time to time, whether this run got the order to
		 * terminate.
		 */
		if (checkForInterrupted())
			return;

		// only create new iteration runnables, if none of the old iteration
		// runnables threw exceptions
		for (IterationRunnable prevItRunnable : this.iterationRunnables)
			if (prevItRunnable.getIoException() != null)
				throw prevItRunnable.getIoException();
			else if (prevItRunnable.getNoRunResultException() != null)
				throw prevItRunnable.getNoRunResultException();
			else if (prevItRunnable.getrLibraryException() != null)
				throw prevItRunnable.getrLibraryException();
			else if (prevItRunnable.getrNotAvailableException() != null)
				throw prevItRunnable.getrNotAvailableException();

		IterationRunnable iterationRunnable = new IterationRunnable(
				iterationWrapper) {

			@Override
			public void run() {
				super.run();
				try {
					RunSchedulerThread scheduler = null;
					Repository repo = getRun().getRepository();
					if (repo instanceof RunResultRepository)
						repo = repo.getParent();
					scheduler = repo.getSupervisorThread().getRunScheduler();
					scheduler.informOnStartedIterationRunnable(
							Thread.currentThread(), this);
					try {
						if (isInterrupted())
							return;

						ProgramConfig programConfig = iterationWrapper
								.getProgramConfig();
						DataConfig dataConfig = iterationWrapper
								.getDataConfig();

						this.log.info(String.format(
								"%s (%s,%s, Iteration %d) %s", getRun(),
								programConfig, dataConfig,
								iterationWrapper.getOptId(),
								iterationWrapper.getEffectiveParams()));

						this.log.debug(getRun() + " (" + programConfig + ","
								+ dataConfig + ") Invoking command line: "
								+ StringExt.paste(" ", invocation));
						this.log.debug(getRun()
								+ " ("
								+ programConfig
								+ ","
								+ dataConfig
								+ ") Log-File is located at: \""
								+ iterationWrapper.getLogfile()
										.getAbsolutePath() + "\"");

						final BufferedWriter bw = new BufferedWriter(
								new FileWriter(iterationWrapper.getLogfile()));

						this.log = LoggerFactory.getLogger(this.getClass());
						Process proc = null;
						try {
							proc = programConfig.getProgram().exec(dataConfig,
									programConfig, invocation,
									iterationWrapper.getEffectiveParams(),
									iterationWrapper.getInternalParams());

							if (proc != null && !(proc instanceof RProcess)) {
								new StreamGobbler(proc.getInputStream(), bw)
										.start();
								new StreamGobbler(proc.getErrorStream(), bw)
										.start();

								try {
									proc.waitFor();
								} catch (InterruptedException e) {
								}
							}

							/*
							 * We check from time to time, whether this run got
							 * the order to terminate.
							 */
							if (checkForInterrupted())
								return;

							iterationWrapper
									.setConvertedClusteringRunResult(convertResult(
											iterationWrapper
													.getClusteringRunResult(),
											iterationWrapper
													.getEffectiveParams(),
											iterationWrapper
													.getInternalParams()));

							if (iterationWrapper
									.getConvertedClusteringRunResult() != null) {
								this.log.debug(getRun() + " (" + programConfig
										+ "," + dataConfig
										+ ") Finished converting result files");

								// execute runresult postprocessors
								ExecutionRun run = (ExecutionRun) this.iterationWrapper.runnable.run;
								ClusteringRunResult tmpResult = iterationWrapper
										.getConvertedClusteringRunResult();
								for (RunResultPostprocessor postprocessor : run
										.getPostProcessors()) {
									try {
										tmpResult.loadIntoMemory();

										final Clustering cl = postprocessor
												.postprocess(tmpResult
														.getClustering()
														.getSecond());
										tmpResult.unloadFromMemory();

										String targetFile = tmpResult
												.getAbsolutePath()
												+ "."
												+ postprocessor.getClass()
														.getSimpleName();

										TextFileParser p = new TextFileParser(
												tmpResult.getAbsolutePath(),
												new int[0], new int[0],
												targetFile, OUTPUT_MODE.STREAM) {

											@Override
											protected void processLine(
													String[] key, String[] value) {
											}

											@Override
											protected String getLineOutput(
													String[] key, String[] value) {
												if (currentLine == 0)
													return this
															.combineColumns(value)
															+ "\n";
												return String.format(
														"%s%s%s\n", value[0],
														this.inSplit,
														cl.toFormattedString());
											};
										};
										p.process();

										tmpResult = new ClusteringRunResult(
												tmpResult.getRepository(),
												System.currentTimeMillis(),
												new File(targetFile),
												tmpResult.getDataConfig(),
												tmpResult.getProgramConfig(),
												format,
												tmpResult.getIdentifier(), run);
									} catch (Exception e) {
										throw new RunResultConversionException(
												"An error occurred when applying postprocessor "
														+ postprocessor);
									}
								}

								iterationWrapper
										.setConvertedClusteringRunResult(tmpResult);

								/*
								 * We check from time to time, whether this run
								 * got the order to terminate.
								 */
								if (checkForInterrupted())
									return;

								List<Pair<ParameterSet, ClusteringQualitySet>> qualities = assessQualities(
										iterationWrapper
												.getConvertedClusteringRunResult(),
										iterationWrapper.getInternalParams());
								for (Pair<ParameterSet, ClusteringQualitySet> clustSet : qualities)
									this.log.info(String.format(
											"%s (%s,%s, Iteration %d) %s",
											getRun(), programConfig,
											dataConfig,
											iterationWrapper.getOptId(),
											clustSet.getSecond().toString()));
								synchronized (completeQualityOutput) {
									// 04.04.2013: adding iteration number to
									// qualities
									List<Triple<ParameterSet, ClusteringQualitySet, Long>> qualitiesWithIterations = new ArrayList<Triple<ParameterSet, ClusteringQualitySet, Long>>();
									for (Pair<ParameterSet, ClusteringQualitySet> pair : qualities)
										qualitiesWithIterations
												.add(Triple.getTriple(
														pair.getFirst(),
														pair.getSecond(),
														new Long(
																iterationWrapper
																		.getOptId())));

									writeQualitiesToFile(qualitiesWithIterations);
								}
								// synchronized!
								// afterClustering(
								// iterationWrapper
								// .getConvertedClusteringRunResult(),
								// qualities);
							}

							/*
							 * Add this RunResult to the list. The RunResult
							 * only encapsulates the path to the result-file and
							 * does not hold any actual values, so we do not
							 * need to wait until the thread is finished.
							 */
							synchronized (getRun().getResults()) {
								// changed 16.04.2014: before we added the old
								// not
								// converted
								// result
								getRun().getResults()
										.add(iterationWrapper
												.getConvertedClusteringRunResult());
							}
						} catch (RunResultNotFoundException e) {
							handleMissingRunResult(iterationWrapper);
						} catch (RunResultConversionException e) {
							handleMissingRunResult(iterationWrapper);
						} catch (REngineException e1) {
							handleMissingRunResult(iterationWrapper);
						} catch (REXPMismatchException e1) {
							handleMissingRunResult(iterationWrapper);
						} finally {
							if (programConfig.getProgram() instanceof RProgram) {
								synchronized (bw) {
									// BufferedWriter bw = new
									// BufferedWriter(new
									// FileWriter(logFile));
									bw.append(((RProgram) (programConfig
											.getProgram())).getRengine()
											.getLastError());
									bw.close();
								}
							}
						}
					} catch (InterruptedException e) {
						// don't do anything
					} catch (NoRunResultFormatParserException e) {
						noRunResultException = e;
					} catch (IOException e) {
						ioException = e;
					} catch (RLibraryNotLoadedException e) {
						rLibraryException = e;
					} catch (RNotAvailableException e) {
						rNotAvailableException = e;
					} catch (Throwable t) {
						t.printStackTrace();
					} finally {
						scheduler.informOnFinishedIterationRunnable(
								Thread.currentThread(), this);
					}
				} catch (Throwable t) {
					// print and catch all throwables, otherwise we will see odd
					// behaviour in the thread pool
					t.printStackTrace();
				}
			}
		};

		this.iterationRunnables.add(iterationRunnable);

		final RunSchedulerThread runScheduler;
		if (this.getRun().getRepository() instanceof RunResultRepository)
			runScheduler = this.getRun().getRepository().getParent()
					.getSupervisorThread().getRunScheduler();
		else
			runScheduler = this.getRun().getRepository().getSupervisorThread()
					.getRunScheduler();
		this.futures.add(runScheduler
				.registerIterationRunnable(iterationRunnable));
	}

	/**
	 * This method is responsible for assessing the qualities of a clustering
	 * run result. It takes the clusterings and passes them to
	 * {@link ClusteringRunResult#assessQuality(List)}.
	 * 
	 * @param convertedResult
	 *            The clustering result converted to the default format, such
	 *            that it can be parsed.
	 * @throws InvalidDataSetFormatVersionException
	 * @throws RunResultNotFoundException
	 */
	private List<Pair<ParameterSet, ClusteringQualitySet>> assessQualities(
			final ClusteringRunResult convertedResult,
			final Map<String, String> internalParams)
			throws RunResultNotFoundException {
		this.log.debug(this.getRun() + " (" + this.programConfig + ","
				+ this.dataConfig + ") Assessing quality of results...");
		List<Pair<ParameterSet, ClusteringQualitySet>> qualities = new ArrayList<Pair<ParameterSet, ClusteringQualitySet>>();
		try {
			final String qualityFile = internalParams.get("q");
			convertedResult.loadIntoMemory();
			try {
				final Pair<ParameterSet, Clustering> pair = convertedResult
						.getClustering();
				ClusteringQualitySet quals = pair.getSecond().assessQuality(
						dataConfig, this.getRun().getQualityMeasures());
				qualities.add(Pair.getPair(pair.getFirst(), quals));
				for (ClusteringQualityMeasure qualityMeasure : quals.keySet()) {
					FileUtils.appendStringToFile(qualityFile,
							qualityMeasure.getClass().getSimpleName() + "\t"
									+ quals.get(qualityMeasure) + "\n");
				}
			} finally {
				convertedResult.unloadFromMemory();
			}

			this.log.debug(this.getRun() + " (" + this.programConfig + ","
					+ this.dataConfig + ") Finished quality calculations");
			return qualities;
		} catch (Exception e) {
			throw new RunResultNotFoundException("The result file "
					+ convertedResult.getAbsolutePath()
					+ " does not exist or could not been parsed!");
		}
	}

	/**
	 * Helper method of {@link #assessQualities(ClusteringRunResult)}, invoked
	 * to write the assessed clustering qualities into files.
	 * 
	 * @param qualities
	 *            A list containing pairs of parameter sets and corresponding
	 *            clustering qualities of different measures.
	 */
	protected void writeQualitiesToFile(
			List<Triple<ParameterSet, ClusteringQualitySet, Long>> qualities) {
		// 04.04.2013: adding iteration number into first column
		/*
		 * Write the qualities into the complete file
		 */
		for (Triple<ParameterSet, ClusteringQualitySet, Long> clustSet : qualities) {
			StringBuilder sb = new StringBuilder();
			sb.append(clustSet.getThird());
			sb.append("\t");
			for (int p = 0; p < programConfig.getOptimizableParams().size(); p++) {
				ProgramParameter<?> param = programConfig
						.getOptimizableParams().get(p);
				if (p > 0)
					sb.append(",");
				sb.append(clustSet.getFirst().get(param.getName()));
			}
			sb.append("\t");
			for (ClusteringQualityMeasure measure : this.getRun()
					.getQualityMeasures()) {
				sb.append(clustSet.getSecond().get(measure));
				sb.append("\t");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("\n");

			FileUtils.appendStringToFile(completeQualityOutput, sb.toString());
		}
	}

	/**
	 * A wrapper method for the conversion of the run result, which handles
	 * logging and adding the converted result to the results of the run.
	 * 
	 * @return The result of the last iteration converted to the standard
	 *         format.
	 * @throws NoRunResultFormatParserException
	 * @throws RunResultNotFoundException
	 * @throws SecurityException
	 * @throws RunResultConversionException
	 */
	protected ClusteringRunResult convertResult(
			final ClusteringRunResult result,
			final Map<String, String> effectiveParams,
			final Map<String, String> internalParams)
			throws NoRunResultFormatParserException,
			RunResultNotFoundException, RunResultConversionException {
		/*
		 * Converting and Quality of result
		 */
		this.log.debug(this.getRun() + " (" + this.programConfig + ","
				+ this.dataConfig + ") Converting result files...");

		try {
			ClusteringRunResult convertedResult = result.convertTo(this
					.getRun().getContext().getStandardOutputFormat(),
					internalParams, effectiveParams);
			synchronized (this.getRun().getResults()) {
				this.getRun().getResults().add(convertedResult);
			}
			return convertedResult;
		} catch (NoRunResultFormatParserException e) {
			throw e;
		} catch (RunResultNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new RunResultConversionException(
					"The runresult could not be converted");
		}
	}

	/**
	 * This method is invoked by {@link #doRunIteration()} before any
	 * calculations are done, to ensure, that all folders and files are created
	 * such that the remainder process can be performed without problems.
	 * 
	 * <p>
	 * This method also initializes the file object attribute variables that are
	 * used throughout the process: {@link #logFile},
	 * {@link #clusteringResultFile} and {@link #resultQualityFile}.
	 */
	protected void initAndEnsureIterationFilesAndFolders(
			final IterationWrapper iterationWrapper) {

		int optId = iterationWrapper.getOptId();
		/*
		 * Insert the unique identifier created earlier into the result paths by
		 * replacing the string "%RUNIDENTSTRING". And replace the %OPTID
		 * placeholder by the id corresponding to this optimization iteration
		 */
		String clusteringOutput;
		if (!isResume)
			clusteringOutput = FileUtils
					.buildPath(
							this.getRun()
									.getRepository()
									.getClusterResultsBasePath()
									.replace("%RUNIDENTSTRING",
											runThreadIdentString),
							programConfig + "_" + dataConfig + "." + optId
									+ ".results");
		else
			clusteringOutput = FileUtils
					.buildPath(
							this.getRun()
									.getRepository()
									.getParent()
									.getClusterResultsBasePath()
									.replace("%RUNIDENTSTRING",
											runThreadIdentString),
							programConfig + "_" + dataConfig + "." + optId
									+ ".results");

		String qualityOutput;
		if (!isResume)
			qualityOutput = FileUtils.buildPath(
					this.getRun().getRepository()
							.getClusterResultsQualityBasePath()
							.replace("%RUNIDENTSTRING", runThreadIdentString),
					programConfig + "_" + dataConfig + "." + optId
							+ ".results.qual");
		else
			qualityOutput = FileUtils.buildPath(
					this.getRun().getRepository().getParent()
							.getClusterResultsQualityBasePath()
							.replace("%RUNIDENTSTRING", runThreadIdentString),
					programConfig + "_" + dataConfig + "." + optId
							+ ".results.qual");

		String logOutput;
		if (!isResume)
			logOutput = FileUtils.buildPath(
					this.getRun().getRepository().getLogBasePath()
							.replace("%RUNIDENTSTRING", runThreadIdentString),
					programConfig + "_" + dataConfig + "." + optId + ".log");
		else
			logOutput = FileUtils.buildPath(
					this.getRun().getRepository().getParent().getLogBasePath()
							.replace("%RUNIDENTSTRING", runThreadIdentString),
					programConfig + "_" + dataConfig + "." + optId + ".log");

		/*
		 * if the output already exists, delete it to avoid complications safety
		 */
		if (new File(clusteringOutput).exists())
			FileUtils.delete(new File(clusteringOutput));
		if (new File(qualityOutput).exists())
			FileUtils.delete(new File(qualityOutput));

		/*
		 * Ensure that the directories to the result and log files exist.
		 */
		iterationWrapper.setLogfile(new File(logOutput));
		iterationWrapper.getLogfile().getParentFile().mkdirs();
		iterationWrapper.setClusteringResultFile(new File(clusteringOutput));
		iterationWrapper.getClusteringResultFile().getParentFile().mkdirs();
		iterationWrapper.setResultQualityFile(new File(qualityOutput));
		iterationWrapper.getResultQualityFile().getParentFile().mkdirs();
	}

	/**
	 * Overwrite this method in your subclass, if you want to handle missing run
	 * results individually.
	 * 
	 * <p>
	 * This can comprise actions ensuring that further iterations can be
	 * executed smoothly.
	 */
	protected abstract void handleMissingRunResult(
			final IterationWrapper iterationWrapper);

	// /**
	// * After a clustering has been calculated by the program, converted to the
	// * standard format by the framework, and quality-assessed, this method
	// * performs all final actions that need to be done at the end of every
	// * iteration after successful clustering, e.g. create plots of the results
	// * of this iteration.
	// *
	// * @param clusteringRunResult
	// * The clustering run result of the last iteration in standard
	// * format.
	// * @param qualities
	// * The assessed qualities of the clustering of the last
	// * iteration.
	// */
	// @SuppressWarnings("unused")
	// protected void afterClustering(final ClusteringRunResult result,
	// final List<Pair<ParameterSet, ClusteringQualitySet>> qualities) {
	// }

	/**
	 * Set the internal attributes of the framework, e.g. the meanSimilarity
	 * attribute which holds the mean similarity of the input dataset. These
	 * internal attributes are then used later on, to replace parameter
	 * placeholders in the invocation line in
	 * {@link #parseInvocationLineAndEffectiveParameters()}.
	 * 
	 * <p>
	 * This method is invoked in {@link #beforeRun()}, thus is only evaluated
	 * once.
	 * 
	 * <p>
	 * The dataset in standard format is assumed to be loaded before this method
	 * is invoked and to be unloaded after return of this method.
	 * 
	 * @throws UnknownDataSetFormatException
	 * @throws InvalidDataSetFormatVersionException
	 * @throws IOException
	 * @throws IllegalArgumentException
	 */
	protected void setInternalAttributes() throws IllegalArgumentException {
		// TODO; make use of inheritance! (relative and absolute datasets)
		// TODO: move to place, where dataset is loaded?
		DataSet ds = this.dataConfig.getDatasetConfig().getDataSet()
				.getInStandardFormat();

		if (ds instanceof RelativeDataSet) {
			RelativeDataSet dataSet = (RelativeDataSet) ds;
			this.dataConfig
					.getRepository()
					.getInternalDoubleAttribute(
							"$("
									+ this.dataConfig.getDatasetConfig()
											.getDataSet().getOriginalDataSet()
											.getAbsolutePath()
									+ ":minSimilarity)")
					.setValue(dataSet.getDataSetContent().getMinValue());
			this.dataConfig
					.getRepository()
					.getInternalDoubleAttribute(
							"$("
									+ this.dataConfig.getDatasetConfig()
											.getDataSet().getOriginalDataSet()
											.getAbsolutePath()
									+ ":maxSimilarity)")
					.setValue(dataSet.getDataSetContent().getMaxValue());
			this.dataConfig
					.getRepository()
					.getInternalDoubleAttribute(
							"$("
									+ this.dataConfig.getDatasetConfig()
											.getDataSet().getOriginalDataSet()
											.getAbsolutePath()
									+ ":meanSimilarity)")
					.setValue(dataSet.getDataSetContent().getMean());
		}
		this.dataConfig
				.getRepository()
				.getInternalIntegerAttribute(
						"$("
								+ this.dataConfig.getDatasetConfig()
										.getDataSet().getOriginalDataSet()
										.getAbsolutePath()
								+ ":numberOfElements)")
				.setValue(ds.getIds().size());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see run.runnable.RunRunnable#beforeRun()
	 */
	@SuppressWarnings("unused")
	@Override
	protected void beforeRun() throws UnknownDataSetFormatException,
			InvalidDataSetFormatVersionException, IllegalArgumentException,
			IOException, RegisterException, InternalAttributeException,
			IncompatibleDataSetFormatException,
			UnknownGoldStandardFormatException,
			IncompleteGoldStandardException, InterruptedException {
		this.log.info("Run " + this.getRun() + " (" + this.programConfig + ","
				+ this.dataConfig + ") " + (!isResume ? "started" : "RESUMED")
				+ " (asynchronously)");

		if (checkForInterrupted())
			throw new InterruptedException();

		lastStartTime = System.currentTimeMillis();

		FileUtils.appendStringToFile(
				this.getRun().getLogFilePath(),
				Formatter.currentTimeAsString(true, "MM_dd_yyyy-HH_mm_ss",
						Locale.UK)
						+ "\tStarting runThread \""
						+ this.getRun()
						+ " ("
						+ this.programConfig
						+ ","
						+ this.dataConfig
						+ ")\"" + System.getProperty("line.separator"));

		this.format = programConfig.getOutputFormat();

		/*
		 * A Run holds actual values for the parameters of the program. If a
		 * parameter is set to a value here, this will overwrite the default
		 * value of the parameter defined in the program configuration.
		 */
		// 06.04.2013: changed from indexOf to manual search, because
		// programConfig of this runnable and of the run are not identical
		int p = -1;
		for (int i = 0; i < this.getRun().getProgramConfigs().size(); i++) {
			ProgramConfig programConfig = this.getRun().getProgramConfigs()
					.get(i);
			if (programConfig.getName().equals(this.programConfig.getName())) {
				p = i;
				break;
			}
		}
		this.runParams = this.getRun().getParameterValues().get(p);
		this.log.info("Converting and preprocessing dataset ...");
		boolean found = preprocessAndCheckCompatibleDataSetFormat();
		if (!found) {
			IncompatibleDataSetFormatException ex = new IncompatibleDataSetFormatException(
					"The program \""
							+ programConfig.getProgram()
							+ "\" cannot be run with the dataset format \""
							+ dataConfig.getDatasetConfig().getDataSet()
									.getDataSetFormat() + "\"");
			// otherwise throw exception
			throw ex;
		}

		if (checkForInterrupted())
			return;

		try {
			this.log.info("Loading the input similarities into memory ...");
			// Load the dataset into memory
			DataSet dataSet = this.dataConfig.getDatasetConfig().getDataSet()
					.getInStandardFormat();
			dataSet.loadIntoMemory(this.dataConfig.getDatasetConfig()
					.getConversionInputToStandardConfiguration()
					.getSimilarityPrecision());
			// if the original dataset is an absolute dataset, load it into
			// memory as well
			dataSet = this.dataConfig.getDatasetConfig().getDataSet()
					.getOriginalDataSet();
			if (dataSet instanceof AbsoluteDataSet) {
				this.log.info("Loading the input coordinates into memory ...");
				dataSet.loadIntoMemory();
			}

			if (checkForInterrupted())
				return;

			/*
			 * Check compatibility of dataset with goldstandard
			 */
			if (this.dataConfig.hasGoldStandardConfig())
				checkCompatibilityDataSetGoldStandard(
						this.dataConfig.getDatasetConfig(),
						this.dataConfig.getGoldstandardConfig());

			assert !this.dataConfig.hasGoldStandardConfig()
					|| this.dataConfig.getGoldstandardConfig()
							.getGoldstandard().isInMemory();
		} catch (IncompleteGoldStandardException e1) {
			// this.exceptions.add(e1);
			// 15.11.2012: missing entries in the goldstandard is no longer
			// a termination criterion. maybe introduce option
			// return;
			// 15.04.2013: since missing entries in the goldstandard distort
			// result qualities, we interrupt again when such an exception is
			// thrown. The user has the possibility of removing samples from the
			// data if this is the case.
			// 12.08.2014: removed again, because of randomized data sets which
			// have points in data set but not in gold standard. -> make it an
			// option definitely
			// throw e1;
		}
		if (checkForInterrupted())
			return;

		// 30.06.2014: performing isoMDS calculations in parallel
		final DataConfig dcMDS = this.dataConfig;

		IterationWrapper wrapper = new IterationWrapper();
		wrapper.setDataConfig(dcMDS);
		wrapper.setProgramConfig(programConfig);
		wrapper.setRunnable(this);
		wrapper.setOptId(-1);

		IterationRunnable iterationRunnable = new IterationRunnable(wrapper) {

			@Override
			public void run() {
				super.run();

				RunSchedulerThread scheduler = null;
				Repository repo = getRun().getRepository();
				if (repo instanceof RunResultRepository)
					repo = repo.getParent();
				scheduler = repo.getSupervisorThread().getRunScheduler();
				scheduler.informOnStartedIterationRunnable(
						Thread.currentThread(), this);

				try {
					this.log.info("Assessing isoMDS coordinates of dataset samples ...");
					// Plotter.assessAndWriteIsoMDSCoordinates(dcMDS);
				} catch (Throwable e) {
					e.printStackTrace();
				} finally {
					scheduler.informOnFinishedIterationRunnable(
							Thread.currentThread(), this);
				}
			}
		};

		this.iterationRunnables.add(iterationRunnable);

		final RunSchedulerThread runScheduler;
		if (this.getRun().getRepository() instanceof RunResultRepository)
			runScheduler = this.getRun().getRepository().getParent()
					.getSupervisorThread().getRunScheduler();
		else
			runScheduler = this.getRun().getRepository().getSupervisorThread()
					.getRunScheduler();
		this.futures.add(runScheduler
				.registerIterationRunnable(iterationRunnable));

		if (checkForInterrupted())
			return;

		// 30.06.2014: performing isoMDS calculations in parallel
		final DataConfig dcPCA = this.dataConfig;

		wrapper = new IterationWrapper();
		wrapper.setDataConfig(dcPCA);
		wrapper.setProgramConfig(programConfig);
		wrapper.setRunnable(this);
		wrapper.setOptId(-2);

		iterationRunnable = new IterationRunnable(wrapper) {

			@Override
			public void run() {
				super.run();

				RunSchedulerThread scheduler = null;
				Repository repo = getRun().getRepository();
				if (repo instanceof RunResultRepository)
					repo = repo.getParent();
				scheduler = repo.getSupervisorThread().getRunScheduler();
				scheduler.informOnStartedIterationRunnable(
						Thread.currentThread(), this);

				try {
					this.log.info("Assessing PCA coordinates of dataset samples ...");
					Plotter.assessAndWritePCACoordinates(dcPCA);
				} catch (Throwable e) {
					e.printStackTrace();
				} finally {
					scheduler.informOnFinishedIterationRunnable(
							Thread.currentThread(), this);
				}
			}
		};

		this.iterationRunnables.add(iterationRunnable);

		this.futures.add(runScheduler
				.registerIterationRunnable(iterationRunnable));

		setInternalAttributes();

		/*
		 * Ensure that the target directory exists
		 */
		if (!isResume)
			new File(this.getRun().getRepository()
					.getClusterResultsQualityBasePath()
					.replace("%RUNIDENTSTRING", runThreadIdentString)).mkdirs();
		else
			new File(this.getRun().getRepository().getParent()
					.getClusterResultsQualityBasePath()
					.replace("%RUNIDENTSTRING", runThreadIdentString)).mkdirs();

		/*
		 * Writing all the qualities of the optimization process into one file
		 */
		if (!isResume)
			completeQualityOutput = FileUtils
					.buildPath(
							this.getRun()
									.getRepository()
									.getClusterResultsQualityBasePath()
									.replace("%RUNIDENTSTRING",
											runThreadIdentString),
							programConfig + "_" + dataConfig
									+ ".results.qual.complete");
		else
			completeQualityOutput = FileUtils
					.buildPath(
							this.getRun()
									.getRepository()
									.getParent()
									.getClusterResultsQualityBasePath()
									.replace("%RUNIDENTSTRING",
											runThreadIdentString),
							programConfig + "_" + dataConfig
									+ ".results.qual.complete");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see run.runnable.RunRunnable#afterRun()
	 */
	@Override
	protected void afterRun() {
		try {
			// wait for all iteration runnables to finish
			for (Future<?> f : this.futures)
				try {
					f.get();
				} catch (InterruptedException e) {
					// we don't care about those interrupted exceptions
				} catch (ExecutionException e) {
					e.printStackTrace();
				}

			super.afterRun();
		} finally {
			// unload the dataset from memory
			DataSet dataSet = this.dataConfig.getDatasetConfig().getDataSet()
					.getInStandardFormat();
			if (dataSet != null)
				dataSet.unloadFromMemory();
			// if the original dataset is an absolute dataset, unload it from
			// memory
			// as well
			dataSet = this.dataConfig.getDatasetConfig().getDataSet()
					.getOriginalDataSet();
			if (dataSet != null && dataSet instanceof AbsoluteDataSet)
				dataSet.unloadFromMemory();

			if (dataConfig.hasGoldStandardConfig())
				dataConfig.getGoldstandardConfig().getGoldstandard()
						.unloadFromMemory();
		}

		FileUtils.appendStringToFile(
				this.getRun().getLogFilePath(),
				Formatter.currentTimeAsString(true, "MM_dd_yyyy-HH_mm_ss",
						Locale.UK)
						+ "\tFinished runThread \""
						+ this.getRun()
						+ " ("
						+ this.programConfig
						+ ","
						+ this.dataConfig
						+ ")\" (Duration "
						+ Formatter.formatMsToDuration(runningTime
								+ (System.currentTimeMillis() - lastStartTime))
						+ ")" + System.getProperty("line.separator"));

		this.log.info("Run " + this.getRun() + " (" + this.programConfig + ","
				+ this.dataConfig + ") finished");
	}
}

class IterationWrapper {

	/**
	 * A temporary variable holding a file object pointing to the absolute path
	 * of the current clustering output file during execution of the runnable
	 */
	private File clusteringResultFile;

	/**
	 * A temporary variable holding a file object pointing to the absolute path
	 * of the current log output file during execution of the runnable
	 */
	private File logfile;

	/**
	 * A temporary variable holding a file object pointing to the absolute path
	 * of the current clustering quality output file during execution of the
	 * runnable
	 */
	private File resultQualityFile;

	/**
	 * This number indicates the current iteration performed by the runnable
	 * object.
	 * 
	 * <p>
	 * This is only larger than 1, if we are in PARAMETER_OPTIMIZATION mode.
	 * Then the optimization method will determine, how often we iterate in
	 * total and this attribute will be increased by the runnable after every
	 * iteration.
	 */
	private int optId;

	/**
	 * A map containing the parameters of {@link #runParams} and additionally
	 * internal parameters like file paths that are used throughout execution of
	 * this runnable.
	 */
	final private Map<String, String> effectiveParams;

	/**
	 * The internal parameters are parameters, that cannot be directly
	 * influenced by the user, e.g. the absolute input or output path.
	 */
	final private Map<String, String> internalParams;
	private ClusteringRunResult clusteringRunResult;
	private ClusteringRunResult convertedClusteringRunResult;

	private ParameterSet parameterSet;
	protected RunRunnable runnable;
	protected ProgramConfig programConfig;
	protected DataConfig dataConfig;

	public IterationWrapper() {
		super();
		this.internalParams = new HashMap<String, String>();
		this.effectiveParams = new HashMap<String, String>();
	}

	protected File getClusteringResultFile() {
		return clusteringResultFile;
	}

	protected void setClusteringResultFile(File clusteringResultFile) {
		this.clusteringResultFile = clusteringResultFile;
	}

	protected File getLogfile() {
		return logfile;
	}

	protected void setLogfile(File logfile) {
		this.logfile = logfile;
	}

	protected File getResultQualityFile() {
		return resultQualityFile;
	}

	protected void setResultQualityFile(File resultQualityFile) {
		this.resultQualityFile = resultQualityFile;
	}

	protected int getOptId() {
		return optId;
	}

	protected void setOptId(int optId) {
		this.optId = optId;
	}

	protected Map<String, String> getEffectiveParams() {
		return effectiveParams;
	}

	protected Map<String, String> getInternalParams() {
		return internalParams;
	}

	protected ClusteringRunResult getClusteringRunResult() {
		return clusteringRunResult;
	}

	protected ClusteringRunResult getConvertedClusteringRunResult() {
		return convertedClusteringRunResult;
	}

	protected void setClusteringRunResult(
			ClusteringRunResult clusteringRunResult) {
		this.clusteringRunResult = clusteringRunResult;
	}

	protected ProgramConfig getProgramConfig() {
		return programConfig;
	}

	protected void setProgramConfig(ProgramConfig programConfig) {
		this.programConfig = programConfig;
	}

	protected DataConfig getDataConfig() {
		return dataConfig;
	}

	protected void setDataConfig(DataConfig dataConfig) {
		this.dataConfig = dataConfig;
	}

	protected void setConvertedClusteringRunResult(
			ClusteringRunResult clusteringRunResult) {
		this.convertedClusteringRunResult = clusteringRunResult;
	}

	protected RunRunnable getRunnable() {
		return runnable;
	}

	protected void setRunnable(RunRunnable runnable) {
		this.runnable = runnable;
	}

	protected ParameterSet getParameterSet() {
		return parameterSet;
	}

	protected void setParameterSet(ParameterSet parameterSet) {
		this.parameterSet = parameterSet;
	}
}