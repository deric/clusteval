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
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.rosuda.REngine.REngineException;

import utils.ProgressPrinter;
import de.clusteval.data.dataset.format.InvalidDataSetFormatVersionException;
import de.clusteval.data.dataset.format.UnknownDataSetFormatException;
import de.clusteval.data.statistics.DataStatistic;
import de.clusteval.data.statistics.StatisticCalculateException;
import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.run.AnalysisRun;
import de.clusteval.run.Run;
import de.clusteval.run.result.RunResult;
import de.clusteval.run.statistics.RunStatistic;
import de.clusteval.utils.FormatConversionException;
import de.clusteval.utils.RNotAvailableException;
import de.clusteval.utils.Statistic;
import de.clusteval.utils.StatisticCalculator;
import file.FileUtils;

/**
 * A type of a runnable, that corresponds to {@link AnalysisRun} and is
 * therefore responsible for analysing a object of interest. This can be for
 * example analysis of a dataset (in case of {@link DataAnalysisRunRunnable}) or
 * of run results ({@link RunAnalysisRunRunnable}).
 * 
 * @author Christian Wiwie
 * @param <T>
 *            A type of statistic, that should be assessed and stored during
 *            execution of this runnable, e.g. {@link DataStatistic}.
 * @param <R>
 *            A type of run result, that the results of this runnable will be
 *            of.
 * 
 */
public abstract class AnalysisRunRunnable<T extends Statistic, R extends RunResult>
		extends
			RunRunnable {

	/**
	 * A list of all statistic-classes that should be assessed during execution
	 * of this runnable.
	 */
	protected List<T> statistics;

	/**
	 * The results of this runnables are stored in a list. Every result is a
	 * single statistic object. A statistic object encapsulates its assessed
	 * value itself.
	 */
	protected List<T> results;

	/**
	 * The runresult object is a wrapper object that tells the framework, that
	 * the result folder of this runnable in the repository results directory
	 * (see {@link Repository#runResultBasePath}) holds a run result.
	 */
	protected R result;

	/**
	 * A temporary variable needed during execution of this runnable.
	 */
	protected T currentStatistic;

	/**
	 * A temporary variable needed during execution of this runnable.
	 */
	protected String analysesFolder;

	/**
	 * A temporary variable needed during execution of this runnable.
	 */
	protected File calcFile;

	/**
	 * A temporary variable needed during execution of this runnable.
	 */
	protected Repository repo;

	/**
	 * @param run
	 *            The run this runnable belongs to.
	 * @param runIdentString
	 *            The unique identification string of the run which is used to
	 *            store the results in a unique folder to avoid overwriting.
	 * @param statistics
	 *            The statistics that should be assessed during execution of
	 *            this runnable.
	 * @param isResume
	 *            True, if this run is a resumption of a previous execution or a
	 *            completely new execution.
	 */
	public AnalysisRunRunnable(final Run run, final String runIdentString,
			List<T> statistics, final boolean isResume) {
		super(run, runIdentString, isResume);
		this.statistics = statistics;
		this.progress = new ProgressPrinter(100, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see run.runnable.RunRunnable#beforeRun()
	 */
	@Override
	public void beforeRun() {
		if (!isResume)
			this.repo = this.getRun().getRepository();
		else
			this.repo = this.getRun().getRepository().getParent();

		new File(this.repo.getAnalysisResultsBasePath().replace(
				"%RUNIDENTSTRING", runThreadIdentString)).mkdirs();
		this.results = new ArrayList<T>();
		this.analysesFolder = FileUtils.buildPath(this.repo
				.getAnalysisResultsBasePath().replace("%RUNIDENTSTRING",
						runThreadIdentString));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see run.runnable.RunRunnable#afterRun()
	 */
	@Override
	public void afterRun() {
		try {
			this.result = createRunResult();
		} catch (RegisterException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see run.runnable.RunRunnable#doRun()
	 */
	@Override
	public void doRun() {
		int currentPos = 0;
		for (T statistic : statistics) {
			try {
				this.currentStatistic = statistic;
				String output = getOutputPath();

				final File outputFile = new File(output);
				if (isResume && outputFile.exists())
					continue;

				BufferedWriter bw;
				bw = new BufferedWriter(new FileWriter(outputFile));

				this.calcFile = new File(FileUtils.buildPath(
						repo.getBasePath(RunStatistic.class),
						statistic.getIdentifier() + ".jar")).getAbsoluteFile();

				StatisticCalculator<T> calc = getStatisticCalculator();

				this.beforeStatisticCalculate();
				results.add(calc.calculate());

				bw.write(results.get(results.size() - 1).toString());

				bw.close();

				calc.writeOutputTo(new File(output));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (FormatConversionException e) {
				e.printStackTrace();
			} catch (InvalidDataSetFormatVersionException e) {
				e.printStackTrace();
			} catch (RegisterException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (StatisticCalculateException e) {
				e.printStackTrace();
			} catch (RNotAvailableException e) {
				e.printStackTrace();
			} catch (REngineException e) {
				e.printStackTrace();
			} catch (UnknownDataSetFormatException e) {
				e.printStackTrace();
			} finally {
				currentPos++;
				int iterationPercent = Math.min((int) (currentPos
						/ (double) this.statistics.size() * 100), 100);
				this.progress.update(iterationPercent);
			}
		}
	}

	/**
	 * A helper method for {@link #doRun()}. It returns the absolute path to the
	 * result file for the current statistic to be calculated.
	 * 
	 * <p>
	 * This method is abstract since it has to provide different behaviour for
	 * different subtypes of this class.
	 * 
	 * @return Abstract path to the output file.
	 */
	protected abstract String getOutputPath();

	/**
	 * A helper method for {@link #doRun()} which returns the statistic
	 * calculator for the current statistic to be calculated.
	 * 
	 * <p>
	 * This method is abstract since it has to provide different behaviour for
	 * different subtypes of this class.
	 * 
	 * @return
	 * @throws FormatConversionException
	 * @throws IOException
	 * @throws InvalidDataSetFormatVersionException
	 * @throws RegisterException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws UnknownDataSetFormatException
	 */
	protected abstract StatisticCalculator<T> getStatisticCalculator()
			throws FormatConversionException, IOException,
			InvalidDataSetFormatVersionException, RegisterException,
			SecurityException, NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, UnknownDataSetFormatException;

	/**
	 * A helper method of {@link #doRun()}, which can be overridden to do any
	 * kind of precalculations and operations needed before a statistic is
	 * assessed.
	 */
	protected abstract void beforeStatisticCalculate();

	/**
	 * This method creates a run result object encapsulating the results of this
	 * runnable which has the right subtype depending on the dynamic type of
	 * this class.
	 * 
	 * @return A runresult object encapsulating the results of this runnable.
	 * @throws RegisterException
	 */
	protected abstract R createRunResult() throws RegisterException;
}
