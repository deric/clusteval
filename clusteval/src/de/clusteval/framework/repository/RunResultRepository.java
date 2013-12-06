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
package de.clusteval.framework.repository;

import java.io.FileNotFoundException;
import java.util.concurrent.ConcurrentHashMap;

import de.clusteval.cluster.quality.ClusteringQualityMeasure;
import de.clusteval.data.DataConfig;
import de.clusteval.data.dataset.AbsoluteDataSet;
import de.clusteval.data.dataset.DataSet;
import de.clusteval.data.dataset.DataSetConfig;
import de.clusteval.data.dataset.DataSetRegisterException;
import de.clusteval.data.dataset.RelativeDataSet;
import de.clusteval.data.dataset.RunResultDataSetConfig;
import de.clusteval.data.goldstandard.GoldStandard;
import de.clusteval.data.goldstandard.GoldStandardConfig;
import de.clusteval.data.goldstandard.format.GoldStandardFormat;
import de.clusteval.framework.repository.config.RepositoryConfigNotFoundException;
import de.clusteval.framework.repository.config.RepositoryConfigurationException;
import de.clusteval.framework.threading.RunResultRepositorySupervisorThread;
import de.clusteval.framework.threading.SupervisorThread;
import de.clusteval.program.DoubleProgramParameter;
import de.clusteval.program.IntegerProgramParameter;
import de.clusteval.program.Program;
import de.clusteval.program.ProgramConfig;
import de.clusteval.program.StandaloneProgram;
import de.clusteval.program.StringProgramParameter;
import de.clusteval.program.r.RProgram;
import de.clusteval.run.ClusteringRun;
import de.clusteval.run.DataAnalysisRun;
import de.clusteval.run.InternalParameterOptimizationRun;
import de.clusteval.run.ParameterOptimizationRun;
import de.clusteval.run.Run;
import de.clusteval.run.RunAnalysisRun;
import de.clusteval.run.RunDataAnalysisRun;
import de.clusteval.utils.Finder;
import file.FileUtils;

/**
 * A runresult repository corresponds to a runresult directory in the results
 * directory of its parent repository.
 * 
 * <p>
 * The runresult directories contain copies of the inputs and configurations at
 * the time, the corresponding runs were started. Therefore every runresult
 * directory can be treated as an individual smaller repository which contains a
 * subset of the files as a regular {@link Repository}.
 * 
 * @author Christian Wiwie
 * 
 */
public class RunResultRepository extends Repository {

	// TODO: check, whether all those are needed for a RunResultRepository
	/**
	 * @param basePath
	 *            The absolute path of the root directory of this repository.
	 * @param parent
	 *            The parent repository.
	 * @throws FileNotFoundException
	 * @throws RepositoryAlreadyExistsException
	 * @throws InvalidRepositoryException
	 * @throws RepositoryConfigurationException
	 * @throws RepositoryConfigNotFoundException
	 */
	public RunResultRepository(String basePath, Repository parent)
			throws FileNotFoundException, RepositoryAlreadyExistsException,
			InvalidRepositoryException, RepositoryConfigNotFoundException,
			RepositoryConfigurationException {
		super(basePath, parent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#createSQLCommunicator()
	 */
	@Override
	protected SQLCommunicator createSQLCommunicator() {
		if (this.parent.repositoryConfig.getMysqlConfig().usesMysql())
			return new RunResultSQLCommunicator(this,
					this.parent.repositoryConfig.getMysqlConfig());
		return new StubSQLCommunicator(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#initAttributes()
	 */
	@Override
	protected void initAttributes() {

		this.repositoryObjectEntities = new RepositoryObjectEntityMap();

		this.repositoryObjectEntities.put(
				DataConfig.class,
				new RepositoryObjectEntity<DataConfig>(this,
						this.parent != null
								? this.parent.repositoryObjectEntities
										.get(DataConfig.class) : null,
						FileUtils.buildPath(this.basePath, "configs")));

		this.repositoryObjectEntities.put(
				DataSetConfig.class,
				new RepositoryObjectEntity<DataSetConfig>(this,
						this.parent != null
								? this.parent.repositoryObjectEntities
										.get(DataSetConfig.class) : null,
						FileUtils.buildPath(this.basePath, "configs")));
//		this.repositoryObjectEntities.put(RunResultDataSetConfig.class,
//				this.repositoryObjectEntities.get(DataSetConfig.class));

		this.repositoryObjectEntities.put(
				DataSet.class,
				new RunResultRepositoryDataSetObjectEntity(this,
						this.parent != null
								? this.parent.repositoryObjectEntities
										.get(DataSet.class) : null, FileUtils
								.buildPath(this.basePath, "inputs")));
//		this.repositoryObjectEntities.put(AbsoluteDataSet.class,
//				this.repositoryObjectEntities.get(DataSet.class));
//		this.repositoryObjectEntities.put(RelativeDataSet.class,
//				this.repositoryObjectEntities.get(DataSet.class));

		this.repositoryObjectEntities.put(
				GoldStandardConfig.class,
				new RepositoryObjectEntity<GoldStandardConfig>(this,
						this.parent != null
								? this.parent.repositoryObjectEntities
										.get(GoldStandardConfig.class) : null,
						FileUtils.buildPath(this.basePath, "configs")));

		this.repositoryObjectEntities.put(
				GoldStandard.class,
				new RunResultRepositoryGoldStandardObjectEntity(this,
						this.parent != null
								? this.parent.repositoryObjectEntities
										.get(GoldStandard.class) : null,
						FileUtils.buildPath(this.basePath, "goldstandards")));

		this.repositoryObjectEntities.put(
				ProgramConfig.class,
				new RepositoryObjectEntity<ProgramConfig>(this,
						this.parent != null
								? this.parent.repositoryObjectEntities
										.get(ProgramConfig.class) : null,
						FileUtils.buildPath(this.basePath, "configs")));

		this.repositoryObjectEntities.put(Run.class,
				new RepositoryObjectEntity<Run>(this, this.parent != null
						? this.parent.repositoryObjectEntities.get(Run.class)
						: null, FileUtils.buildPath(this.basePath, "configs")));
//		this.repositoryObjectEntities.put(ClusteringRun.class,
//				this.repositoryObjectEntities.get(Run.class));
//		this.repositoryObjectEntities.put(ParameterOptimizationRun.class,
//				this.repositoryObjectEntities.get(Run.class));
//		this.repositoryObjectEntities.put(
//				InternalParameterOptimizationRun.class,
//				this.repositoryObjectEntities.get(Run.class));
//		this.repositoryObjectEntities.put(DataAnalysisRun.class,
//				this.repositoryObjectEntities.get(Run.class));
//		this.repositoryObjectEntities.put(RunAnalysisRun.class,
//				this.repositoryObjectEntities.get(Run.class));
//		this.repositoryObjectEntities.put(RunDataAnalysisRun.class,
//				this.repositoryObjectEntities.get(Run.class));

		this.repositoryObjectEntities.put(Program.class,
				this.parent.repositoryObjectEntities.get(Program.class));
//		this.repositoryObjectEntities.put(RProgram.class,
//				this.repositoryObjectEntities.get(Program.class));
//		this.repositoryObjectEntities.put(StandaloneProgram.class,
//				this.repositoryObjectEntities.get(Program.class));

		this.contextClasses = this.parent.contextClasses;
		this.contextInstances = this.parent.contextInstances;
		this.dataSetFormatInstances = this.parent.dataSetFormatInstances;
		this.dataSetFormatClasses = this.parent.dataSetFormatClasses;
		this.dataSetGeneratorClasses = this.parent.dataSetGeneratorClasses;
		this.dataSetGeneratorInstances = this.parent.dataSetGeneratorInstances;
		this.dataPreprocessorInstances = this.parent.dataPreprocessorInstances;
		this.dataPreprocessorClasses = this.parent.dataPreprocessorClasses;
		this.dataSetTypeInstances = this.parent.dataSetTypeInstances;
		this.dataSetTypeClasses = this.parent.dataSetTypeClasses;
		this.distanceMeasureClasses = this.parent.distanceMeasureClasses;
		this.distanceMeasureInstances = this.parent.distanceMeasureInstances;
		this.dataStatisticClasses = this.parent.dataStatisticClasses;
		this.dataStatisticInstances = this.parent.dataStatisticInstances;
		this.statisticCalculators = this.parent.statisticCalculators;
		this.runStatisticClasses = this.parent.runStatisticClasses;
		this.runStatisticInstances = this.parent.runStatisticInstances;
		this.runDataStatisticClasses = this.parent.runDataStatisticClasses;
		this.runDataStatisticInstances = this.parent.runDataStatisticInstances;
		this.dataSetFormatParser = this.parent.dataSetFormatParser;
		this.dataStatisticCalculatorClasses = this.parent.dataStatisticCalculatorClasses;
		this.runStatisticCalculatorClasses = this.parent.runStatisticCalculatorClasses;
		this.runDataStatisticCalculatorClasses = this.parent.runDataStatisticCalculatorClasses;
		this.clusteringQualityMeasureClasses = this.parent.clusteringQualityMeasureClasses;
		this.clusteringQualityMeasureInstances = this.parent.clusteringQualityMeasureInstances;
		this.goldStandardFormats = new ConcurrentHashMap<GoldStandardFormat, GoldStandardFormat>();
		this.rProgramClasses = this.parent.rProgramClasses;
		this.rProgramInstances = this.parent.rProgramInstances;
		this.runResults = this.parent.runResults;
		this.runResultIdentifier = this.parent.runResultIdentifier;
		this.runResultFormatClasses = this.parent.runResultFormatClasses;
		this.runResultFormatInstances = this.parent.runResultFormatInstances;
		this.runResultFormatParser = this.parent.runResultFormatParser;
		this.finder = new ConcurrentHashMap<Finder, Finder>();
		this.parameterOptimizationMethodClasses = this.parent.parameterOptimizationMethodClasses;
		this.parameterOptimizationMethodInstances = this.parent.parameterOptimizationMethodInstances;

		this.internalDoubleAttributes = this.parent.internalDoubleAttributes;
		this.internalStringAttributes = this.parent.internalStringAttributes;
		this.internalIntegerAttributes = this.parent.internalIntegerAttributes;

		this.doubleProgramParameters = new ConcurrentHashMap<DoubleProgramParameter, DoubleProgramParameter>();
		this.integerProgramParameters = new ConcurrentHashMap<IntegerProgramParameter, IntegerProgramParameter>();
		this.stringProgramParameters = new ConcurrentHashMap<StringProgramParameter, StringProgramParameter>();

		// added 14.04.2013
		this.dataSetFormatCurrentVersions = this.parent.dataSetFormatCurrentVersions;
		this.knownFinderExceptions = this.parent.knownFinderExceptions;
		this.finderClassLoaders = this.parent.finderClassLoaders;
		this.finderWaitingFiles = this.parent.finderWaitingFiles;
		this.finderLoadedJarFileChangeDates = this.parent.finderLoadedJarFileChangeDates;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#initializePaths()
	 */
	@Override
	protected void initializePaths() throws InvalidRepositoryException {
		if (this.parent == null)
			throw new InvalidRepositoryException(
					"A RunResultRepository needs a valid parent repository");
		this.dataBasePath = this.parent.dataBasePath;

		this.runResultBasePath = this.parent.runResultBasePath;
		// does not work in case of resume run
		this.clusterResultsBasePath = FileUtils.buildPath(this.basePath,
				"clusters");
		this.clusterResultsQualityBasePath = FileUtils.buildPath(this.basePath,
				"clusters");
		this.logsBasePath = FileUtils.buildPath(this.basePath, "logs");
		this.supplementaryBasePath = this.parent.supplementaryBasePath;
		this.contextBasePath = this.parent.contextBasePath;
		this.suppClusteringBasePath = this.parent.suppClusteringBasePath;
		this.parameterOptimizationMethodBasePath = this.parent.parameterOptimizationMethodBasePath;
		this.clusteringQualityMeasureBasePath = this.parent.clusteringQualityMeasureBasePath;
		this.formatsBasePath = this.parent.formatsBasePath;
		this.dataSetFormatBasePath = this.parent.dataSetFormatBasePath;
		this.generatorBasePath = this.parent.generatorBasePath;
		this.dataSetGeneratorBasePath = this.parent.dataSetGeneratorBasePath;
		this.runResultFormatBasePath = this.parent.runResultFormatBasePath;
		this.typesBasePath = this.parent.typesBasePath;
		this.dataSetTypeBasePath = this.parent.dataSetTypeBasePath;
		this.dataStatisticBasePath = this.parent.dataStatisticBasePath;
		this.runStatisticBasePath = this.parent.runStatisticBasePath;
		this.runDataStatisticBasePath = this.parent.runDataStatisticBasePath;
		this.distanceMeasureBasePath = this.parent.distanceMeasureBasePath;
		this.dataPreprocessorBasePath = this.parent.dataPreprocessorBasePath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#getDataSetFormatsInitialized()
	 */
	@Override
	public boolean getDataSetFormatsInitialized() {
		return this.parent.getDataSetFormatsInitialized();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#getDataStatisticsInitialized()
	 */
	@Override
	public boolean getDataStatisticsInitialized() {
		return this.parent.getDataStatisticsInitialized();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#getDistanceMeasuresInitialized()
	 */
	@Override
	public boolean getDistanceMeasuresInitialized() {
		return this.parent.getDistanceMeasuresInitialized();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#getRProgramsInitialized()
	 */
	@Override
	public boolean getRProgramsInitialized() {
		return this.parent.getRProgramsInitialized();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#getClusteringQualityMeasuresInitialized()
	 */
	@Override
	public boolean getClusteringQualityMeasuresInitialized() {
		return this.parent.getClusteringQualityMeasuresInitialized();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#getParameterOptimizationMethodsInitialized()
	 */
	@Override
	public boolean getParameterOptimizationMethodsInitialized() {
		return this.parent.getParameterOptimizationMethodsInitialized();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#getRunDataStatisticsInitialized()
	 */
	@Override
	public boolean getRunDataStatisticsInitialized() {
		return this.parent.getRunDataStatisticsInitialized();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#getRunStatisticsInitialized()
	 */
	@Override
	public boolean getRunStatisticsInitialized() {
		return this.parent.getRunStatisticsInitialized();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.clusteval.framework.repository.Repository#getDataPreprocessorsInitialized
	 * ()
	 */
	@Override
	public boolean getDataPreprocessorsInitialized() {
		return this.parent.getDataPreprocessorsInitialized();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.clusteval.framework.repository.Repository#getContextsInitialized()
	 */
	@Override
	public boolean getContextsInitialized() {
		return this.parent.getContextsInitialized();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#getRunResultFormatsInitialized()
	 */
	@Override
	public boolean getRunResultFormatsInitialized() {
		return this.parent.getRunResultFormatsInitialized();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.repository.Repository#getDataSetGeneratorsInitialized()
	 */
	@Override
	public boolean getDataSetGeneratorsInitialized() {
		return this.parent.getDataSetGeneratorsInitialized();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#log(java.lang.String)
	 */
	@Override
	protected void info(String message) {
		// reduce visibility of log messages
		this.log.debug(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see framework.repository.Repository#warn(java.lang.String)
	 */
	@Override
	protected void warn(String message) {
		// reduce visibility of log messages
		this.log.debug(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#getClusteringQualityMeasureClass(java.lang.String)
	 */
	@Override
	public Class<? extends ClusteringQualityMeasure> getClusteringQualityMeasureClass(
			String clusteringQualityMeasureClassName) {
		return this.parent
				.getClusteringQualityMeasureClass(clusteringQualityMeasureClassName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#registerClusteringQualityMeasure(java.lang.Class)
	 */
	@Override
	public boolean registerClusteringQualityMeasureClass(
			Class<? extends ClusteringQualityMeasure> object) {
		return this.parent.registerClusteringQualityMeasureClass(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * utils.Repository#isClusteringQualityMeasureRegistered(java.lang.Class)
	 */
	@Override
	public boolean isClusteringQualityMeasureRegistered(
			Class<? extends ClusteringQualityMeasure> dsFormat) {
		return this.parent.isClusteringQualityMeasureRegistered(dsFormat);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * utils.Repository#isClusteringQualityMeasureRegistered(java.lang.String)
	 */
	@Override
	public boolean isClusteringQualityMeasureRegistered(String dsFormatClassName) {
		return this.parent
				.isClusteringQualityMeasureRegistered(dsFormatClassName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#createSupervisorThread()
	 */
	@Override
	protected SupervisorThread createSupervisorThread() {
		return new RunResultRepositorySupervisorThread(this,
				this.getParent().repositoryConfig.getThreadSleepTimes());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.Repository#getDataSetFormatsInitialized()
	 */
	@Override
	public boolean getDataSetTypesInitialized() {
		return this.parent.getDataSetTypesInitialized();
	}
}

class RunResultRepositoryDataSetObjectEntity
		extends
			RepositoryObjectEntity<DataSet> {

	/**
	 * @param repository
	 * @param parent
	 * @param basePath
	 */
	public RunResultRepositoryDataSetObjectEntity(Repository repository,
			RepositoryObjectEntity<DataSet> parent, String basePath) {
		super(repository, parent, basePath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.clusteval.framework.repository.RepositoryObjectEntity#register(de.
	 * clusteval.framework.repository.RepositoryObject)
	 */
	@Override
	public boolean register(DataSet object) throws RegisterException {
		DataSet dataSetInParentRepository = object.getRepository().getParent()
				.getObjectWithName(DataSet.class, object.getFullName());
		if (dataSetInParentRepository != null)
			return super.register(object);
		throw new DataSetRegisterException("The dataset '"
				+ object.getAbsolutePath()
				+ "' of a runresult is missing in its parent repository.");
	}
}

class RunResultRepositoryGoldStandardObjectEntity
		extends
			RepositoryObjectEntity<GoldStandard> {

	/**
	 * @param repository
	 * @param parent
	 * @param basePath
	 */
	public RunResultRepositoryGoldStandardObjectEntity(Repository repository,
			RepositoryObjectEntity<GoldStandard> parent, String basePath) {
		super(repository, parent, basePath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.clusteval.framework.repository.RepositoryObjectEntity#register(de.
	 * clusteval.framework.repository.RepositoryObject)
	 */
	@Override
	public boolean register(GoldStandard object) throws RegisterException {
		GoldStandard gsInParentRepository = object.getRepository().getParent()
				.getObjectWithName(GoldStandard.class, object.toString());
		if (gsInParentRepository != null)
			return super.register(object);
		throw new DataSetRegisterException("The goldstandard '"
				+ object.getAbsolutePath()
				+ "' of a runresult is missing in its parent repository.");
	}
}