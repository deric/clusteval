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
package de.clusteval.framework.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.rosuda.REngine.Rserve.RserveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.clusteval.cluster.Cluster;
import de.clusteval.cluster.ClusterItem;
import de.clusteval.cluster.Clustering;
import de.clusteval.cluster.paramOptimization.ParameterOptimizationMethod;
import de.clusteval.cluster.paramOptimization.ParameterOptimizationMethodFinderThread;
import de.clusteval.cluster.quality.ClusteringQualityMeasure;
import de.clusteval.cluster.quality.ClusteringQualityMeasureFinderThread;
import de.clusteval.cluster.quality.UnknownClusteringQualityMeasureException;
import de.clusteval.context.Context;
import de.clusteval.context.ContextFinderThread;
import de.clusteval.data.DataConfig;
import de.clusteval.data.dataset.DataSet;
import de.clusteval.data.dataset.DataSetConfig;
import de.clusteval.data.dataset.format.DataSetFormat;
import de.clusteval.data.dataset.format.DataSetFormatFinderThread;
import de.clusteval.data.dataset.format.DataSetFormatParser;
import de.clusteval.data.dataset.format.UnknownDataSetFormatException;
import de.clusteval.data.dataset.generator.DataSetGenerator;
import de.clusteval.data.dataset.generator.DataSetGeneratorFinderThread;
import de.clusteval.data.dataset.generator.UnknownDataSetGeneratorException;
import de.clusteval.data.dataset.type.DataSetType;
import de.clusteval.data.dataset.type.DataSetTypeFinderThread;
import de.clusteval.data.distance.DistanceMeasure;
import de.clusteval.data.distance.DistanceMeasureFinderThread;
import de.clusteval.data.distance.UnknownDistanceMeasureException;
import de.clusteval.data.goldstandard.GoldStandard;
import de.clusteval.data.goldstandard.GoldStandardConfig;
import de.clusteval.data.goldstandard.format.GoldStandardFormat;
import de.clusteval.data.preprocessing.DataPreprocessor;
import de.clusteval.data.preprocessing.DataPreprocessorFinderThread;
import de.clusteval.data.preprocessing.UnknownDataPreprocessorException;
import de.clusteval.data.statistics.DataStatistic;
import de.clusteval.data.statistics.DataStatisticCalculator;
import de.clusteval.data.statistics.DataStatisticFinderThread;
import de.clusteval.data.statistics.UnknownDataStatisticException;
import de.clusteval.framework.ClustevalBackendServer;
import de.clusteval.framework.MyRengine;
import de.clusteval.framework.RLibraryNotLoadedException;
import de.clusteval.framework.repository.config.DefaultRepositoryConfig;
import de.clusteval.framework.repository.config.RepositoryConfig;
import de.clusteval.framework.repository.config.RepositoryConfigNotFoundException;
import de.clusteval.framework.repository.config.RepositoryConfigurationException;
import de.clusteval.framework.threading.RepositorySupervisorThread;
import de.clusteval.framework.threading.RunResultRepositorySupervisorThread;
import de.clusteval.framework.threading.SupervisorThread;
import de.clusteval.program.DoubleProgramParameter;
import de.clusteval.program.IntegerProgramParameter;
import de.clusteval.program.Program;
import de.clusteval.program.ProgramConfig;
import de.clusteval.program.ProgramParameter;
import de.clusteval.program.StringProgramParameter;
import de.clusteval.program.r.RLibraryInferior;
import de.clusteval.program.r.RProgram;
import de.clusteval.program.r.RProgramFinderThread;
import de.clusteval.program.r.UnknownRProgramException;
import de.clusteval.run.Run;
import de.clusteval.run.result.RunResult;
import de.clusteval.run.result.format.RunResultFormat;
import de.clusteval.run.result.format.RunResultFormatFinder;
import de.clusteval.run.result.format.RunResultFormatFinderThread;
import de.clusteval.run.result.format.RunResultFormatParser;
import de.clusteval.run.statistics.RunDataStatistic;
import de.clusteval.run.statistics.RunDataStatisticCalculator;
import de.clusteval.run.statistics.RunDataStatisticFinderThread;
import de.clusteval.run.statistics.RunStatistic;
import de.clusteval.run.statistics.RunStatisticCalculator;
import de.clusteval.run.statistics.RunStatisticFinderThread;
import de.clusteval.run.statistics.UnknownRunDataStatisticException;
import de.clusteval.run.statistics.UnknownRunStatisticException;
import de.clusteval.utils.Finder;
import de.clusteval.utils.InternalAttributeException;
import de.clusteval.utils.NamedDoubleAttribute;
import de.clusteval.utils.NamedIntegerAttribute;
import de.clusteval.utils.NamedStringAttribute;
import de.clusteval.utils.Statistic;
import de.clusteval.utils.StatisticCalculator;
import de.clusteval.utils.UnsatisfiedRLibraryException;
import file.FileUtils;

/**
 * The repository is the central object of the backend, where objects are
 * registered and centrally controlled. Objects can be registered and
 * unregistered and get certain functions for free. For example duplication
 * recognition, automatic detection of changes of objects and informing other
 * objects (as listeners) about changes of other objects.
 * 
 * <p>
 * General hint: This class contains a lot of hashmaps for performance reasons.
 * All the hashmaps of this class are updated with current objects. The maps
 * then contain old key objects and current value objects. Therefore you should
 * never iterate over the result of keySet() of the maps, but instead use
 * values().
 * 
 * @author Christian Wiwie
 * 
 */
// Repository class before: 7312 lines
// Repository class after 1st part: 5465 lines
public class Repository {

	/**
	 * A map containing all repository objects. This includes this repository
	 * but also all run result repositories or other child repositories, that
	 * are contained within this repository.
	 */
	protected static Map<String, Repository> repositories = new HashMap<String, Repository>();

	/**
	 * This method returns a repository (if available) with the given root path.
	 * 
	 * @param absFilePath
	 *            The absolute root path of the repository.
	 * @return The repository with the given root path.
	 */
	public static Repository getRepositoryForExactPath(final String absFilePath) {
		return Repository.repositories.get(absFilePath);
	}

	/**
	 * This method returns the lowest repository in repository-hierarchy, that
	 * contains the given path. That means, if there are several nested
	 * repositories for the given path, this method will return the lowest one
	 * of the hierarchy.
	 * 
	 * @param absFilePath
	 *            The absolute file path we want to find the repository for.
	 * @return The repository for the given path, which is lowest in the
	 *         repository-hierarchy.
	 * @throws NoRepositoryFoundException
	 */
	public static Repository getRepositoryForPath(final String absFilePath)
			throws NoRepositoryFoundException {
		String resultPath = null;
		for (String repoPath : Repository.repositories.keySet())
			if (absFilePath.startsWith(repoPath
					+ System.getProperty("file.separator")))
				if (resultPath == null
						|| repoPath.length() > resultPath.length())
					resultPath = repoPath;
		if (resultPath == null)
			throw new NoRepositoryFoundException(absFilePath);
		return Repository.repositories.get(resultPath);
	}

	/**
	 * This method checks, whether the given string represents an internal
	 * attribute placeholder, that means it follows the format of
	 * {@value #internalAttributePattern}.
	 * 
	 * @param value
	 *            The string to check whether it is a internal attribute.
	 * @return True, if the given string is an internal attribute, false
	 *         otherwise.
	 */
	public static boolean isInternalAttribute(final String value) {
		Pattern p = internalAttributePattern;
		return p.matcher(value).matches();
	}

	/**
	 * Register a new repository.
	 * 
	 * @param repository
	 *            The new repository to register.
	 * @return The old repository, if the new repository replaced an old one
	 *         with equal root path. Null otherwise.
	 * @throws RepositoryAlreadyExistsException
	 * @throws InvalidRepositoryException
	 */
	public static Repository register(Repository repository)
			throws RepositoryAlreadyExistsException, InvalidRepositoryException {
		Repository other = null;
		try {
			other = Repository.getRepositoryForPath(repository.basePath);
		} catch (NoRepositoryFoundException e) {
		}
		if (other == null)
			return Repository.repositories.put(repository.basePath, repository);
		if (other.basePath.equals(repository.basePath))
			throw new RepositoryAlreadyExistsException(other.basePath);
		if (repository.parent == null || !repository.parent.equals(other))
			throw new InvalidRepositoryException(
					"Repositories must not be nested without parental relationship");
		return Repository.repositories.put(repository.basePath, repository);
	}

	/**
	 * Unregister the given repository.
	 * 
	 * @param repository
	 *            The repository to remove.
	 * @return The removed repository. If null, the given repository was not
	 *         registered.
	 */
	public static Repository unregister(Repository repository) {
		return Repository.repositories.remove(repository.basePath);
	}

	/**
	 * In case the backend is connected to a mysql database in the frontend,
	 * this attribute is set to a sql communicator, which updates the database
	 * after changes of repository objects (removal, addition).
	 */
	protected SQLCommunicator sqlCommunicator;

	/**
	 * The supervisor thread is responsible for starting and keeping alive all
	 * threads that check the repository on the filesystem for changes.
	 */
	protected SupervisorThread supervisorThread;

	/**
	 * A repository can have a parent repository, which means, that the root
	 * folder of this repository is located inside the parent repository.
	 * 
	 * <p>
	 * As a consequence if a child repository cannot complete a lookup operation
	 * sucessfully, that means cannot find a certain object, it will also look
	 * for this object in the parent repository.
	 * 
	 * <p>
	 * This relationship is only allowed (located inside a subfolder), if the
	 * parental relationship is indicated by setting this parent repository
	 * attribute.
	 */
	protected Repository parent;

	/**
	 * A boolean attribute indicating whether the dataset formats have been
	 * initialized by the {@link DataSetFormatFinderThread}.
	 */
	private boolean dataSetFormatsInitialized;

	/**
	 * A boolean attribute indicating whether the data preprocessors have been
	 * initialized by the {@link DataPreprocessorFinderThread}.
	 */
	private boolean dataPreprocessorsInitialized;

	/**
	 * A boolean attribute indicating whether the dataset types have been
	 * initialized by the {@link DataSetTypeFinderThread}.
	 */
	private boolean dataSetTypesInitialized;

	/**
	 * A boolean attribute indicating whether the distance measures have been
	 * initialized by the {@link DistanceMeasureFinderThread}.
	 */
	private boolean distanceMeasuresInitialized;

	/**
	 * A boolean attribute indicating whether the data statistics have been
	 * initialized by the {@link DataStatisticFinderThread}.
	 */
	private boolean dataStatisticsInitialized;

	/**
	 * A boolean attribute indicating whether the run statistics have been
	 * initialized by the {@link RunStatisticFinderThread}.
	 */
	private boolean runStatisticsInitialized;

	/**
	 * A boolean attribute indicating whether the run data statistics have been
	 * initialized by the {@link RunDataStatisticFinderThread}.
	 */
	private boolean runDataStatisticsInitialized;

	/**
	 * A boolean attribute indicating whether the runresult formats have been
	 * initialized by the {@link RunResultFormatFinderThread}.
	 */
	private boolean runResultFormatsInitialized;

	/**
	 * A boolean attribute indicating whether the clustering quality measures
	 * have been initialized by the {@link ClusteringQualityMeasureFinderThread}
	 * .
	 */
	private boolean clusteringQualityMeasuresInitialized;

	/**
	 * A boolean attribute indicating whether the parameter optimization methods
	 * have been initialized by the
	 * {@link ParameterOptimizationMethodFinderThread}.
	 */
	private boolean parameterOptimizationMethodsInitialized;

	/**
	 * A boolean attribute indicating whether the RPrograms have been
	 * initialized by the {@link RProgramFinderThread}.
	 */
	private boolean rProgramsInitialized;

	/**
	 * The absolute path of the root of this repository.
	 */
	protected String basePath;

	/**
	 * The absolute path to the directory within this repository, where all data
	 * related files are stored.
	 */
	protected String dataBasePath;

	/**
	 * This map holds the current versions of the available dataset formats.
	 */
	protected Map<String, Integer> dataSetFormatCurrentVersions;

	/**
	 * The absolute path to the directory within this repository, where all
	 * dataset formats are stored.
	 */
	protected String dataSetFormatBasePath;

	/**
	 * The absolute path to the directory within this repository, where all
	 * generators are stored.
	 */
	protected String generatorBasePath;

	/**
	 * The absolute path to the directory within this repository, where all
	 * dataset generators are stored.
	 */
	protected String dataSetGeneratorBasePath;

	/**
	 * The absolute path to the directory within this repository, where all
	 * dataset types are stored.
	 */
	protected String dataSetTypeBasePath;

	/**
	 * The absolute path to the directory within this repository, where all
	 * distance measures are stored.
	 */
	protected String distanceMeasureBasePath;

	/**
	 * The absolute path to the directory within this repository, where all data
	 * statistics are stored.
	 */
	protected String dataStatisticBasePath;

	/**
	 * The absolute path to the directory within this repository, where all run
	 * statistics are stored.
	 */
	protected String runStatisticBasePath;

	/**
	 * The absolute path to the directory within this repository, where all run
	 * data statistics are stored.
	 */
	protected String runDataStatisticBasePath;

	/**
	 * The absolute path to the directory within this repository, where all
	 * runresult formats are stored.
	 */
	protected String runResultFormatBasePath;

	/**
	 * The absolute path to the directory, where for a certain runresult
	 * (identified by its unique run identifier) all analysis results are
	 * stored.
	 */
	protected String analysisResultsBasePath;

	/**
	 * The absolute path to the directory within this repository, where all
	 * supplementary materials are stored.
	 * 
	 * <p>
	 * Supplementary materials contain e.g. jar files of parameter optimization
	 * methods or clustering quality measures.
	 */
	protected String supplementaryBasePath;

	/**
	 * The absolute path to the directory within this repository, where all
	 * supplementary materials related to clustering are stored.
	 */
	protected String suppClusteringBasePath;

	/**
	 * The absolute path to the directory within this repository, where all
	 * parameter optimization method jars are stored.
	 */
	protected String parameterOptimizationMethodBasePath;

	/**
	 * The absolute path to the directory within this repository, where all
	 * clustering quality measure jars are stored.
	 */
	protected String clusteringQualityMeasureBasePath;

	/**
	 * The absolute path to the directory within this repository, where all type
	 * jars are stored.
	 */
	protected String typesBasePath;

	/**
	 * The absolute path to the directory within this repository, where all
	 * format jars are stored, e.g. dataset formats.
	 */
	protected String formatsBasePath;

	/**
	 * This map contains the absolute path of every repository object registered
	 * in this repository and maps it to the object itself.
	 */
	protected Map<File, RepositoryObject> pathToRepositoryObject;

	// TODO: test
	protected RepositoryObjectEntityMap repositoryObjectEntities;

	/**
	 * A map containing all classes of dataset generators registered in this
	 * repository. Mapping from Class.getName() to the class.
	 */
	protected Map<String, Class<? extends DataSetGenerator>> dataSetGeneratorClasses;

	/**
	 * A map mapping from the simple name of the class to all of its
	 * instances.Mapping from Class.getSimpleName() to the instances.
	 */
	protected Map<String, List<DataSetGenerator>> dataSetGeneratorInstances;

	/**
	 * A map containing all classes of dataset types registered in this
	 * repository. Mapping from Class.getName() to the class.
	 */
	protected Map<String, Class<? extends DataSetType>> dataSetTypeClasses;

	/**
	 * A map mapping from the simple name of the class to all of its instances.
	 * Mapping from Class.getSimpleName() to the instances.
	 */
	protected Map<String, List<DataSetType>> dataSetTypeInstances;

	/**
	 * A map containing all classes of distance measures registered in this
	 * repository. Mapping from Class.getName() to the class.
	 */
	protected Map<String, Class<? extends DistanceMeasure>> distanceMeasureClasses;

	/**
	 * A map mapping from the simple name of the class to all of its
	 * instances.Mapping from Class.getSimpleName() to the instances.
	 */
	protected Map<String, List<DistanceMeasure>> distanceMeasureInstances;

	/**
	 * A map containing all classes of data statistics registered in this
	 * repository. Mapping from Class.getName() to the class.
	 */
	protected Map<String, Class<? extends DataStatistic>> dataStatisticClasses;

	/**
	 * A map mapping from the simple name of the class to all of its
	 * instances.Mapping from Class.getSimpleName() to the instances.
	 */
	protected Map<String, List<DataStatistic>> dataStatisticInstances;

	/**
	 * A map containing all classes of data statistic calculators registered in
	 * this repository.
	 */
	protected Map<String, Class<? extends DataStatisticCalculator<? extends DataStatistic>>> dataStatisticCalculatorClasses;

	/**
	 * A map containing all statistic calculators registered in this repository.
	 */
	// TODO
	protected Map<StatisticCalculator<? extends Statistic>, StatisticCalculator<? extends Statistic>> statisticCalculators;

	/**
	 * A map containing all classes of clustering quality measure registered in
	 * this repository. Mapping from Class.getName() to the class.
	 */
	protected Map<String, Class<? extends ClusteringQualityMeasure>> clusteringQualityMeasureClasses;

	/**
	 * A map mapping from the simple name of the class to all of its
	 * instances.Mapping from Class.getSimpleName() to the instances.
	 */
	protected Map<String, List<ClusteringQualityMeasure>> clusteringQualityMeasureInstances;

	/**
	 * A map containing all classes of parameter optimization methods registered
	 * in this repository. Mapping from Class.getName() to the class.
	 */
	protected Map<String, Class<? extends ParameterOptimizationMethod>> parameterOptimizationMethodClasses;

	/**
	 * A map containing all classes of dataset formats registered in this
	 * repository. Mapping from Class.getName() to the class.
	 */
	protected Map<String, Class<? extends DataSetFormat>> dataSetFormatClasses;

	/**
	 * A map mapping from the simple name of the class to all of its
	 * instances.Mapping from Class.getSimpleName() to the instances.
	 */
	protected Map<String, List<DataSetFormat>> dataSetFormatInstances;

	/**
	 * A map containing all classes of dataset format parsers registered in this
	 * repository.
	 */
	protected Map<String, Class<? extends DataSetFormatParser>> dataSetFormatParser;

	/**
	 * A map mapping from the simple name of the class to all of its
	 * instances.Mapping from Class.getSimpleName() to the instances.
	 */
	// TODO
	protected Map<String, Map<ParameterOptimizationMethod, ParameterOptimizationMethod>> parameterOptimizationMethodInstances;
	/**
	 * A map containing all classes of run statistics registered in this
	 * repository. Mapping from Class.getName() to the class.
	 */
	protected Map<String, Class<? extends RunStatistic>> runStatisticClasses;

	/**
	 * A map mapping from the simple name of the class to all of its
	 * instances.Mapping from Class.getSimpleName() to the instances.
	 */
	protected Map<String, List<RunStatistic>> runStatisticInstances;

	/**
	 * A map containing all classes of run data statistics registered in this
	 * repository. Mapping from Class.getName() to the class.
	 */
	protected Map<String, Class<? extends RunDataStatistic>> runDataStatisticClasses;

	/**
	 * A map mapping from the simple name of the class to all of its
	 * instances.Mapping from Class.getSimpleName() to the instances.
	 */
	protected Map<String, List<RunDataStatistic>> runDataStatisticInstances;

	/**
	 * A map containing all classes of run statistic calculators registered in
	 * this repository.
	 */
	protected Map<String, Class<? extends RunStatisticCalculator<? extends RunStatistic>>> runStatisticCalculatorClasses;

	/**
	 * A map containing all classes of run data statistic calculators registered
	 * in this repository.
	 */
	protected Map<String, Class<? extends RunDataStatisticCalculator<? extends RunDataStatistic>>> runDataStatisticCalculatorClasses;

	/**
	 * A map containing all goldstandard formats registered in this repository.
	 */
	protected Map<GoldStandardFormat, GoldStandardFormat> goldStandardFormats;

	/**
	 * A map containing all classes of RPrograms registered in this repository.
	 * Mapping from Class.getName() to the class.
	 */
	protected Map<String, Class<? extends RProgram>> rProgramClasses;

	/**
	 * A map mapping from the simple name of the class to all of its
	 * instances.Mapping from Class.getSimpleName() to the instances.
	 */
	protected Map<String, List<RProgram>> rProgramInstances;

	/**
	 * A map containing all clusterings registered in this repository.
	 */
	protected Map<Clustering, Clustering> clusterings;

	/**
	 * A map containing all clusters registered in this repository.
	 */
	protected Map<Cluster, Cluster> clusters;

	/**
	 * A map containing all clusteritems registered in this repository.
	 */
	protected Map<ClusterItem, ClusterItem> clusterItems;

	/**
	 * A map containing all classes of runresult formats registered in this
	 * repository. Mapping from Class.getName() to the class.
	 */
	protected Map<String, Class<? extends RunResultFormat>> runResultFormatClasses;

	/**
	 * A map mapping from the simple name of the class to all of its
	 * instances.Mapping from Class.getSimpleName() to the instances.
	 */
	protected Map<String, List<RunResultFormat>> runResultFormatInstances;

	/**
	 * A map containing all runresult format parsers registered in this
	 * repository.
	 */
	protected Map<String, Class<? extends RunResultFormatParser>> runResultFormatParser;

	/**
	 * A map containing all finder instances registered in this repository.
	 */
	protected Map<Finder, Finder> finder;

	/**
	 * The pattern that is used to scan a string ofr internal attribute
	 * placeholders in {@link #isInternalAttribute(String)}.
	 */
	protected static Pattern internalAttributePattern = Pattern
			.compile("\\$\\([^\\$)]*\\)");

	/**
	 * This map holds all available internal float attributes, which can be used
	 * by any kind of configuration file as a option value, which is not
	 * available before starting of a run.
	 */
	protected Map<String, NamedDoubleAttribute> internalDoubleAttributes;

	/**
	 * This map holds all available internal string attributes, which can be
	 * used by any kind of configuration file as a option value, which is not
	 * available before starting of a run.
	 */
	protected Map<String, NamedStringAttribute> internalStringAttributes;

	/**
	 * This map holds all available internal integer attributes, which can be
	 * used by any kind of configuration file as a option value, which is not
	 * available before starting of a run.
	 */
	protected Map<String, NamedIntegerAttribute> internalIntegerAttributes;

	/**
	 * This map contains all double program parameters. These program parameters
	 * are defined in program configurations.
	 */
	protected Map<DoubleProgramParameter, DoubleProgramParameter> doubleProgramParameters;

	/**
	 * This map contains all integer program parameters. These program
	 * parameters are defined in program configurations.
	 */
	protected Map<IntegerProgramParameter, IntegerProgramParameter> integerProgramParameters;

	/**
	 * This map contains all string program parameters. These program parameters
	 * are defined in program configurations.
	 */
	protected Map<StringProgramParameter, StringProgramParameter> stringProgramParameters;

	protected Logger log;

	/**
	 * The configuration of this repository holds options that can specify the
	 * behaviour of this repository. For example it can be specified, whether
	 * the repository should communicate and insert its information into a sql
	 * database.
	 */
	protected RepositoryConfig repositoryConfig;

	/**
	 * This attribute maps the names of a class to all exceptions of required R
	 * libraries that could not be loaded.
	 */
	protected Map<String, Set<RLibraryNotLoadedException>> missingRLibraries;

	/**
	 * The absolute path to the directory within this repository, where all data
	 * preprocessors are stored.
	 */
	protected String dataPreprocessorBasePath;

	/**
	 * A map containing all classes of data preprocessors registered in this
	 * repository. Mapping from Class.getName() to the class.
	 */
	protected Map<String, Class<? extends DataPreprocessor>> dataPreprocessorClasses;

	/**
	 * A map mapping from the simple name of the class to all of its
	 * instances.Mapping from Class.getSimpleName() to the instances.
	 */
	protected Map<String, List<DataPreprocessor>> dataPreprocessorInstances;

	/**
	 * A boolean attribute indicating whether the dataset generators have been
	 * initialized by the {@link DataSetGeneratorFinderThread}.
	 */
	private boolean dataSetGeneratorsInitialized;

	/**
	 * All exceptions thrown during parsing of finder instances are being
	 * inserted into this map. New exceptions with messages equal to messages of
	 * exceptions in this list will not be thrown again.
	 */
	protected Map<String, List<Throwable>> knownFinderExceptions;

	/**
	 * The class loaders used by the finders to load classes dynamically.
	 */
	protected Map<URL, URLClassLoader> finderClassLoaders;

	/**
	 * A map containing dependencies between jar files that are loaded
	 * dynamically.
	 */
	protected Map<File, List<File>> finderWaitingFiles;

	/**
	 * The change dates of the jar files that were loaded dynamically by jar
	 * finder instances.
	 */
	protected Map<String, Long> finderLoadedJarFileChangeDates;

	/**
	 * A map containing all classes of contexts registered in this repository.
	 * Mapping from Class.getName() to the class.
	 */
	protected Map<String, Class<? extends Context>> contextClasses;

	/**
	 * A map mapping from the simple name of the class to all of its
	 * instances.Mapping from Class.getSimpleName() to the instances.
	 */
	protected Map<String, List<Context>> contextInstances;

	/**
	 * A boolean attribute indicating whether the contexts have been initialized
	 * by the {@link ContextFinderThread}.
	 */
	// TODO initialize
	private boolean contextsInitialized;

	/**
	 * The absolute path to the directory within this repository, where all
	 * contexts are stored.
	 */
	// TODO: initialize
	protected String contextBasePath;

	private Map<Thread, MyRengine> rEngines;

	/**
	 * Instantiates a new repository.
	 * 
	 * @param parent
	 *            Can be null, if this repository has no parent repository.
	 * @param basePath
	 *            The absolute path of the root of this repository.
	 * @throws FileNotFoundException
	 * @throws InvalidRepositoryException
	 * @throws RepositoryAlreadyExistsException
	 * @throws RepositoryConfigurationException
	 * @throws RepositoryConfigNotFoundException
	 */
	public Repository(final String basePath, final Repository parent)
			throws FileNotFoundException, RepositoryAlreadyExistsException,
			InvalidRepositoryException, RepositoryConfigNotFoundException,
			RepositoryConfigurationException {
		this(basePath, parent, null);
	}

	/**
	 * Instantiates a new repository.
	 * 
	 * @param parent
	 *            Can be null, if this repository has no parent repository.
	 * @param basePath
	 *            The absolute path of the root of this repository.
	 * @param overrideConfig
	 *            Set this parameter != null, if you want to override the
	 *            repository.config file.
	 * @throws FileNotFoundException
	 * @throws InvalidRepositoryException
	 * @throws RepositoryAlreadyExistsException
	 * @throws RepositoryConfigurationException
	 * @throws RepositoryConfigNotFoundException
	 */
	public Repository(final String basePath, final Repository parent,
			final RepositoryConfig overrideConfig)
			throws FileNotFoundException, RepositoryAlreadyExistsException,
			InvalidRepositoryException, RepositoryConfigNotFoundException,
			RepositoryConfigurationException {
		super();

		this.log = LoggerFactory.getLogger(this.getClass());

		this.basePath = basePath;
		// remove trailing file separator
		if (this.basePath.length() > 1
				&& this.basePath.endsWith(System.getProperty("file.separator")))
			this.basePath = this.basePath.substring(0, this.basePath.length()
					- System.getProperty("file.separator").length());
		this.parent = parent;
		this.missingRLibraries = new ConcurrentHashMap<String, Set<RLibraryNotLoadedException>>();

		this.initializePaths();

		this.initAttributes();

		this.ensureFolderStructure();

		this.pathToRepositoryObject = new ConcurrentHashMap<File, RepositoryObject>();

		File repositoryConfigFile = new File(FileUtils.buildPath(this.basePath,
				"repository.config"));

		Repository.register(this);

		if (overrideConfig != null)
			this.repositoryConfig = overrideConfig;
		else if (repositoryConfigFile.exists()) {
			/*
			 * Parsing the configuration file (if it exists)
			 */
			this.repositoryConfig = RepositoryConfig
					.parseFromFile(repositoryConfigFile);
			this.log.debug("Using repository configuration: "
					+ repositoryConfigFile);
		} else {
			this.repositoryConfig = new DefaultRepositoryConfig();
			this.log.debug("Using default repository configuration");
		}

		this.sqlCommunicator = createSQLCommunicator();

		// try {
		// this.rEngineForLibraryInstalledChecks = new REnginePool(5);
		// } catch (RserveException e) {
		// // if there is no R, we will not be using this field in the future
		// this.rEngineForLibraryInstalledChecks = null;
		// this.rEngineException = e;
		// }
		this.rEngines = new HashMap<Thread, MyRengine>();
	}

	/**
	 * @param e
	 *            The new exception to add.
	 * @return A boolean indicating, whether the exception was new.
	 */
	public boolean addMissingRLibraryException(RLibraryNotLoadedException e) {
		if (!(this.missingRLibraries.containsKey(e.getClassName())))
			this.missingRLibraries
					.put(e.getClassName(),
							Collections
									.synchronizedSet(new HashSet<RLibraryNotLoadedException>()));
		return this.missingRLibraries.get(e.getClassName()).add(e);
	}

	/**
	 * This method clears the existing exceptions for missing R libraries for
	 * the given class name.
	 * 
	 * @param className
	 *            The class name for which we want to clear the missing
	 *            libraries.
	 * @return The old exceptions that were present for this class.
	 */
	public Set<RLibraryNotLoadedException> clearMissingRLibraries(
			String className) {
		return this.missingRLibraries.remove(className);
	}

	/**
	 * This method is a helper method for sql communication. The sql
	 * communicator usually does not commit after every change. Therefore we
	 * provide this method, to allow for commiting at certain points such that
	 * we can afterwards guarantee a certain state of the DB and operate on it.
	 */
	public void commitDB() {
		synchronized (this.sqlCommunicator) {
			this.sqlCommunicator.commitDB();
		}
	}

	/**
	 * This method creates a sql communicator for this repository depending on
	 * the fact, whether mysql should be used by this repository.
	 * 
	 * <p>
	 * Override this method in subclasses, if you want to change the type of sql
	 * communicator for your subtype. You can see an example in
	 * {@link RunResultRepository#createSQLCommunicator()}, where instead of
	 * {@link DefaultSQLCommunicator} a {@link RunResultSQLCommunicator} is
	 * created.
	 * 
	 * @return A new instance of sql communicator.
	 */
	protected SQLCommunicator createSQLCommunicator() {
		if (this.repositoryConfig.getMysqlConfig().usesMysql())
			return new DefaultSQLCommunicator(this,
					this.repositoryConfig.getMysqlConfig());

		return new StubSQLCommunicator(this);
	}

	/**
	 * This method creates the supervisor thread object for this repository.
	 * 
	 * <p>
	 * Override this method in subclasses, if you want to change the type of
	 * supervisor thread for your subtype. You can see an example in
	 * {@link RunResultRepository#createSupervisorThread()}, where instead of a
	 * {@link RepositorySupervisorThread} a
	 * {@link RunResultRepositorySupervisorThread} is created.
	 * 
	 * @return
	 */
	protected SupervisorThread createSupervisorThread() {
		return new RepositorySupervisorThread(this,
				this.repositoryConfig.getThreadSleepTimes(), false,
				ClustevalBackendServer.getBackendServerConfiguration()
						.getCheckForRunResults());
	}

	/**
	 * Helper method of {@link #ensureFolderStructure()}, which ensures that a
	 * single folder exists.
	 * 
	 * @param absFolderPath
	 *            The absolute path of the folder to ensure.
	 * @return true, if successful
	 * @throws FileNotFoundException
	 */
	private boolean ensureFolder(final String absFolderPath)
			throws FileNotFoundException {
		final File folder = new File(absFolderPath);
		if (!(folder.exists())) {
			folder.mkdirs();
			this.info("Recreating repository folder " + folder);
		}
		if (!(folder.exists()))
			throw new FileNotFoundException("Could not create folder "
					+ folder.getAbsolutePath());
		return true;
	}

	/**
	 * This method ensures the complete folder structure of this repository. If
	 * a folder does not exist, it is recreated. In case a folder creation is
	 * not successful an exception is thrown.
	 * 
	 * <p>
	 * A helper method of
	 * {@link #Repository(String, Repository, long, long, long, long, long, long, long)}.
	 * 
	 * @return true, if successful
	 * @throws FileNotFoundException
	 */
	private boolean ensureFolderStructure() throws FileNotFoundException {
		// TODO: replace by for loop over entries of #repositoryObjectEntities
		this.ensureFolder(this.basePath);
		this.ensureFolder(this.dataBasePath);
		this.ensureFolder(this.getBasePath(DataConfig.class));
		this.ensureFolder(this.getBasePath(DataSet.class));
		this.ensureFolder(this.dataSetFormatBasePath);
		this.ensureFolder(this.dataSetTypeBasePath);
		this.ensureFolder(this.getBasePath(DataSetConfig.class));
		this.ensureFolder(this.getBasePath(GoldStandard.class));
		this.ensureFolder(this.getBasePath(GoldStandardConfig.class));
		this.ensureFolder(this.getBasePath(Program.class));
		this.ensureFolder(this.getBasePath(ProgramConfig.class));
		this.ensureFolder(this.getBasePath(Run.class));
		this.ensureFolder(this.getBasePath(RunResult.class));
		this.ensureFolder(this.runResultFormatBasePath);
		this.ensureFolder(this.supplementaryBasePath);
		this.ensureFolder(this.suppClusteringBasePath);
		this.ensureFolder(this.contextBasePath);
		this.ensureFolder(this.parameterOptimizationMethodBasePath);
		this.ensureFolder(this.dataStatisticBasePath);
		this.ensureFolder(this.runStatisticBasePath);
		this.ensureFolder(this.runDataStatisticBasePath);
		this.ensureFolder(this.distanceMeasureBasePath);
		this.ensureFolder(this.generatorBasePath);
		this.ensureFolder(this.dataSetGeneratorBasePath);
		this.ensureFolder(this.dataPreprocessorBasePath);

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Repository))
			return false;

		Repository repo = (Repository) obj;

		return this.basePath.equals(repo.basePath);
	}

	/**
	 * This method evaluates all internal attribute placeholders contained in
	 * the passed string.
	 * 
	 * @param old
	 *            The string which might contain internal attribute
	 *            placeholders.
	 * @param dataConfig
	 *            The data configuration which might be needed to evaluate the
	 *            placeholders.
	 * @param programConfig
	 *            The program configuration which might be needed to evaluate
	 *            the placeholders.
	 * @return The parameter value with evaluated placeholders.
	 * @throws InternalAttributeException
	 */
	public String evaluateInternalAttributes(final String old,
			final DataConfig dataConfig, final ProgramConfig programConfig)
			throws InternalAttributeException {

		final String extended = extendInternalAttributes(old, dataConfig,
				programConfig);

		StringBuilder result = new StringBuilder(extended);
		int pos = -1;
		while ((pos = result.indexOf("$(")) != -1) {
			int endPos = result.indexOf(")", pos + 1);

			String attributeName = result.substring(pos + 2, endPos);
			String replaceValue;
			if (this.internalDoubleAttributes.containsKey(attributeName)) {
				replaceValue = this.internalDoubleAttributes.get(attributeName)
						+ "";
			} else if (this.internalIntegerAttributes
					.containsKey(attributeName)) {
				replaceValue = this.internalIntegerAttributes
						.get(attributeName) + "";
			} else if (this.internalStringAttributes.containsKey(attributeName)) {
				replaceValue = this.internalStringAttributes.get(attributeName)
						+ "";
			} else {
				throw new InternalAttributeException("The internal attribute "
						+ attributeName + " does not exist.");
			}
			result.replace(pos, endPos + 1, replaceValue);
		}

		return result.toString();
	}

	/**
	 * This method is used to evaluate parameter values containing javascript
	 * arithmetic operations.
	 * 
	 * <p>
	 * A helper method of
	 * {@link ProgramParameter#evaluateDefaultValue(DataConfig, ProgramConfig)},
	 * {@link ProgramParameter#evaluateMinValue(DataConfig, ProgramConfig)} and
	 * {@link ProgramParameter#evaluateMaxValue(DataConfig, ProgramConfig)}.
	 * 
	 * @param script
	 *            The parameter value containing javascript arithmetic
	 *            operations.
	 * @return The evaluated expression.
	 * @throws ScriptException
	 */
	public String evaluateJavaScript(final String script)
			throws ScriptException {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		return engine.eval(script) + "";
	}

	/**
	 * This method prefixes placeholder of internal attributes with their data
	 * configuration such that they can be replaced in an unambigious way later
	 * in {@link Repository#evaluateInternalAttributes(String)}.
	 * 
	 * <p>
	 * A helper method for
	 * {@link #evaluateInternalAttributes(String, DataConfig, ProgramConfig)}.
	 * 
	 * @param old
	 *            The parameter value that might contain placeholders which need
	 *            to be extended.
	 * @param dataConfig
	 *            The data configuration which might be needed to extend the
	 *            placeholders.
	 * @param programConfig
	 *            The program configuration which might be needed to extend the
	 *            placeholders.
	 * @return The parameter value with extended placeholders.
	 */
	@SuppressWarnings("unused")
	private String extendInternalAttributes(final String old,
			final DataConfig dataConfig, final ProgramConfig programConfig) {
		String result = old.replaceAll("\\$\\(minSimilarity\\)", "\\$\\("
				+ dataConfig.getDatasetConfig().getDataSet()
						.getOriginalDataSet().getAbsolutePath()
				+ ":minSimilarity\\)");
		result = result.replaceAll("\\$\\(maxSimilarity\\)", "\\$\\("
				+ dataConfig.getDatasetConfig().getDataSet()
						.getOriginalDataSet().getAbsolutePath()
				+ ":maxSimilarity\\)");
		result = result.replaceAll("\\$\\(meanSimilarity\\)", "\\$\\("
				+ dataConfig.getDatasetConfig().getDataSet()
						.getOriginalDataSet().getAbsolutePath()
				+ ":meanSimilarity\\)");
		result = result.replaceAll("\\$\\(numberOfElements\\)", "\\$\\("
				+ dataConfig.getDatasetConfig().getDataSet()
						.getOriginalDataSet().getAbsolutePath()
				+ ":numberOfElements\\)");
		return result;
	}

	/**
	 * @throws InterruptedException
	 */
	public void terminateSupervisorThread() throws InterruptedException {
		// close Rengine pool
		// this.rEngineForLibraryInstalledChecks.close();
		for (MyRengine rEngine : this.rEngines.values())
			rEngine.close();

		// terminate supervisor thread
		if (this.supervisorThread == null)
			return;
		this.supervisorThread.interrupt();
		this.supervisorThread.join();
	}

	/**
	 * @return The absolute path to the root of this repository.
	 */
	public String getBasePath() {
		return this.basePath;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the
	 * clustering quality measure with the given name.
	 * 
	 * @param clusteringQualityMeasureClassName
	 *            The name of the class of the clustering quality measure.
	 * @return The clustering quality measure class with the given name or null,
	 *         if it does not exist.
	 */
	public Class<? extends ClusteringQualityMeasure> getClusteringQualityMeasureClass(
			final String clusteringQualityMeasureClassName) {
		Class<? extends ClusteringQualityMeasure> result = this.clusteringQualityMeasureClasses
				.get(clusteringQualityMeasureClassName);
		if (result == null && parent != null)
			return parent
					.getClusteringQualityMeasureClass(clusteringQualityMeasureClassName);
		return result;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the dataset
	 * generator with the given name.
	 * 
	 * @param dataSetGeneratorClassName
	 *            The name of the class of the clustering quality measure.
	 * @return The clustering quality measure class with the given name or null,
	 *         if it does not exist.
	 */
	public Class<? extends DataSetGenerator> getDataSetGeneratorClass(
			final String dataSetGeneratorClassName) {
		Class<? extends DataSetGenerator> result = this.dataSetGeneratorClasses
				.get(dataSetGeneratorClassName);
		if (result == null && parent != null)
			return parent.getDataSetGeneratorClass(dataSetGeneratorClassName);
		return result;
	}

	/**
	 * 
	 * @return The set of all registered clustering quality measure classes.
	 */
	public Collection<Class<? extends ClusteringQualityMeasure>> getClusteringQualityMeasureClasses() {
		return this.clusteringQualityMeasureClasses.values();
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all clustering quality measure jars are stored.
	 */
	public String getClusteringQualityMeasuresBasePath() {
		return this.clusteringQualityMeasureBasePath;
	}

	/**
	 * 
	 * @return A boolean attribute indicating whether the clustering quality
	 *         measures have been initialized by the
	 *         {@link ClusteringQualityMeasureFinderThread} .
	 */
	public boolean getClusteringQualityMeasuresInitialized() {
		return this.clusteringQualityMeasuresInitialized;
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all data related files are stored.
	 */
	public String getDataBasePath() {
		return this.dataBasePath;
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all dataset formats are stored.
	 */
	public String getDataFormatsBasePath() {
		return this.dataSetFormatBasePath;
	}

	public String getBasePath(final Class<? extends RepositoryObject> c) {
		return this.repositoryObjectEntities.get(c).getBasePath();
	}

	public <T extends RepositoryObject> Collection<T> getCollection(
			final Class<T> c) {
		return this.repositoryObjectEntities.get(c).asCollection();
	}

	public <T extends RepositoryObject> T getObjectWithName(final Class<T> c,
			final String name) {
		return this.repositoryObjectEntities.get(c).findByString(name);
	}

	public boolean isInitialized(final Class<? extends RepositoryObject> c) {
		return this.repositoryObjectEntities.get(c).isInitialized();
	}

	public <T extends RepositoryObject> T getRegisteredObject(final T object) {
		return this.getRegisteredObject(object, true);
	}

	public <T extends RepositoryObject> T getRegisteredObject(final T object,
			final boolean ignoreChangeDate) {
		@SuppressWarnings("unchecked")
		Class<T> c = (Class<T>) object.getClass();
		return this.getRegisteredObject(c, object, ignoreChangeDate);
	}

	public <T extends RepositoryObject, S extends T> S getRegisteredObject(
			final Class<T> c, final S object, final boolean ignoreChangeDate) {
		if (!this.repositoryObjectEntities.containsKey(c)
				&& object.getClass().getSuperclass() != null
				&& RepositoryObject.class.isAssignableFrom(c.getSuperclass())) {
			return this.getRegisteredObject(
					(Class<? extends RepositoryObject>) c.getSuperclass(),
					object, ignoreChangeDate);
		}
		return this.repositoryObjectEntities.get(c).getRegisteredObject(object,
				ignoreChangeDate);
	}

	public <T extends RepositoryObject, S extends T> boolean unregister(
			final S object) {
		@SuppressWarnings("unchecked")
		Class<S> c = (Class<S>) object.getClass();
		return this.unregister(c, object);
	}

	@SuppressWarnings("unchecked")
	public <T extends RepositoryObject, S extends T> boolean unregister(
			final Class<T> c, final S object) {
		if (!this.repositoryObjectEntities.containsKey(c)
				&& object.getClass().getSuperclass() != null
				&& RepositoryObject.class.isAssignableFrom(c.getSuperclass())) {
			return this.unregister(
					(Class<? extends RepositoryObject>) c.getSuperclass(),
					object);
		}
		return this.repositoryObjectEntities.get(c).unregister(object);
	}

	@SuppressWarnings("unchecked")
	public <T extends RepositoryObject, S extends T> boolean register(
			final S object) throws RegisterException {
		Class<S> c = (Class<S>) object.getClass();
		return this.register(c, object);
	}

	@SuppressWarnings("unchecked")
	public <T extends RepositoryObject, S extends T> boolean register(
			final Class<T> c, final S object) throws RegisterException {
		if (!this.repositoryObjectEntities.containsKey(c)
				&& object.getClass().getSuperclass() != null
				&& RepositoryObject.class.isAssignableFrom(c.getSuperclass())) {
			return this.register(
					(Class<? extends RepositoryObject>) c.getSuperclass(),
					object);
		}
		return this.repositoryObjectEntities.get(c).register(object);
	}

	public <T extends RepositoryObject> void setInitialized(final Class<T> c) {
		this.repositoryObjectEntities.get(c).setInitialized();
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all dataset formats are stored.
	 */
	public String getDataSetFormatBasePath() {
		return this.dataSetFormatBasePath;
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all dataset generators are stored.
	 */
	public String getDataSetGeneratorBasePath() {
		return this.dataSetGeneratorBasePath;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the dataset
	 * format with the given name.
	 * 
	 * @param dataSetFormatClassName
	 *            The name of the class of the dataset format.
	 * @return The dataset format class with the given name or null, if it does
	 *         not exist.
	 */
	public Class<? extends DataSetFormat> getDataSetFormatClass(
			final String dataSetFormatClassName) {
		Class<? extends DataSetFormat> result = this.dataSetFormatClasses
				.get(dataSetFormatClassName);
		if (result == null && parent != null)
			result = this.parent.getDataSetFormatClass(dataSetFormatClassName);
		return result;
	}

	/**
	 * 
	 * @return The set of all registered dataset format classes.
	 */
	public Collection<Class<? extends DataSetFormat>> getDataSetFormatClasses() {
		return this.dataSetFormatClasses.values();
	}

	/**
	 * This method returns the latest and current version of the given format.
	 * It is used by default, if no other version for a format is specified. If
	 * the current version of a format changes, add a static block to that
	 * formats class and overwrite the format version.
	 * 
	 * @param formatClass
	 *            The dataset format class for which we want to know the current
	 *            version.
	 * 
	 * @return The current version for the given dataset format class.
	 * @throws UnknownDataSetFormatException
	 */
	public int getCurrentDataSetFormatVersion(final String formatClass)
			throws UnknownDataSetFormatException {
		if (!dataSetFormatCurrentVersions.containsKey(formatClass))
			throw new UnknownDataSetFormatException("\"" + formatClass
					+ "\" is not a known dataset format.");
		return dataSetFormatCurrentVersions.get(formatClass);
	}

	/**
	 * @param formatClass
	 *            The dataset format class for which we want to set the current
	 *            version.
	 * @param version
	 *            The new version of the dataset format class.
	 */
	public void putCurrentDataSetFormatVersion(final String formatClass,
			final int version) {
		this.dataSetFormatCurrentVersions.put(formatClass, version);
	}

	/**
	 * 
	 * @return The set of all registered dataset generator classes.
	 */
	public Collection<Class<? extends DataSetGenerator>> getDataSetGeneratorClasses() {
		return this.dataSetGeneratorClasses.values();
	}

	/**
	 * This method looks up and returns (if it exists) the class of the parser
	 * corresponding to the dataset format with the given name.
	 * 
	 * @param dataSetFormatName
	 *            The name of the class of the dataset format.
	 * @return The class of the dataset format parser with the given name or
	 *         null, if it does not exist.
	 */
	public Class<? extends DataSetFormatParser> getDataSetFormatParser(
			final String dataSetFormatName) {
		Class<? extends DataSetFormatParser> result = this.dataSetFormatParser
				.get(dataSetFormatName);
		if (result == null && parent != null)
			return this.parent.getDataSetFormatParser(dataSetFormatName);
		return result;
	}

	/**
	 * @return A boolean attribute indicating whether the dataset formats have
	 *         been initialized by the {@link DataSetFormatFinderThread}.
	 */
	public boolean getDataSetFormatsInitialized() {
		return this.dataSetFormatsInitialized;
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all dataset types are stored.
	 */
	public String getDataSetTypeBasePath() {
		return this.dataSetTypeBasePath;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the dataset
	 * type with the given name.
	 * 
	 * @param dataSetTypeClassName
	 *            The name of the class of the dataset type.
	 * @return The class of the dataset type with the given name or null, if it
	 *         does not exist.
	 */
	public Class<? extends DataSetType> getDataSetTypeClass(
			final String dataSetTypeClassName) {
		Class<? extends DataSetType> result = this.dataSetTypeClasses
				.get(dataSetTypeClassName);
		if (result == null && parent != null)
			result = this.parent.getDataSetTypeClass(dataSetTypeClassName);
		return result;
	}

	/**
	 * 
	 * @return The set of all registered dataset type classes.
	 */
	public Collection<Class<? extends DataSetType>> getDataSetTypeClasses() {
		return this.dataSetTypeClasses.values();
	}

	/**
	 * @return A boolean attribute indicating whether the dataset types have
	 *         been initialized by the {@link DataSetTypeFinderThread}.
	 */
	public boolean getDataSetTypesInitialized() {
		return this.dataSetTypesInitialized;
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all data statistics are stored.
	 */
	public String getDataStatisticBasePath() {
		return dataStatisticBasePath;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the data
	 * statistic calculator for the datastatistic class with the given name.
	 * 
	 * @param dataStatisticClassName
	 *            The name of the datastatistic class.
	 * 
	 * @return The class of the data statistic calculator with the given name or
	 *         null, if it does not exist.
	 */
	public Class<? extends DataStatisticCalculator<? extends DataStatistic>> getDataStatisticCalculator(
			final String dataStatisticClassName) {
		Class<? extends DataStatisticCalculator<? extends DataStatistic>> result = this.dataStatisticCalculatorClasses
				.get(dataStatisticClassName);
		if (result == null && parent != null)
			result = this.parent
					.getDataStatisticCalculator(dataStatisticClassName);
		return result;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the data
	 * statistic with the given name.
	 * 
	 * @param dataStatisticClassName
	 *            The name of the class of the data statistic
	 * 
	 * @return The data statistic with the given name or null, if it does not
	 *         exist.
	 */
	public Class<? extends DataStatistic> getDataStatisticClass(
			final String dataStatisticClassName) {
		Class<? extends DataStatistic> result = this.dataStatisticClasses
				.get(dataStatisticClassName);
		if (result == null && parent != null)
			result = this.parent.getDataStatisticClass(dataStatisticClassName);
		return result;
	}

	/**
	 * 
	 * @return The set of all registered data statistic classes.
	 */
	public Collection<Class<? extends DataStatistic>> getDataStatisticClasses() {
		return this.dataStatisticClasses.values();
	}

	/**
	 * @return A boolean attribute indicating whether the data statistics have
	 *         been initialized by the {@link DataStatisticFinderThread}.
	 */
	public boolean getDataStatisticsInitialized() {
		return this.dataStatisticsInitialized;
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all distance measures are stored.
	 */
	public String getDistanceMeasureBasePath() {
		return this.distanceMeasureBasePath;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the distance
	 * measure with the given name.
	 * 
	 * @param distanceMeasureClassName
	 *            The name of the class of the distance measure.
	 * @return The class of the distance measure with the given name or null, if
	 *         it does not exist.
	 */
	public Class<? extends DistanceMeasure> getDistanceMeasureClass(
			final String distanceMeasureClassName) {
		Class<? extends DistanceMeasure> result = this.distanceMeasureClasses
				.get(distanceMeasureClassName);
		if (result == null && parent != null)
			result = this.parent
					.getDistanceMeasureClass(distanceMeasureClassName);
		return result;
	}

	/**
	 * 
	 * @return The set of all registered distance measure classes.
	 */
	public Collection<Class<? extends DistanceMeasure>> getDistanceMeasureClasses() {
		return this.distanceMeasureClasses.values();
	}

	/**
	 * @return A boolean attribute indicating whether the distance measures have
	 *         been initialized by the {@link DistanceMeasureFinderThread}.
	 */
	public boolean getDistanceMeasuresInitialized() {
		return this.distanceMeasuresInitialized;
	}

	/**
	 * This method checks whether the given string is a valid and internal
	 * double attribute by invoking {@link #isInternalAttribute(String)}. Then
	 * the internal double attribute is looked up and returned if it exists.
	 * 
	 * @param value
	 *            The name of the internal double attribute.
	 * @return The internal double attribute with the given name or null, if
	 *         there is no attribute with the given name
	 */
	public NamedDoubleAttribute getInternalDoubleAttribute(final String value) {
		if (!isInternalAttribute(value)) {
			return null;
		}
		NamedDoubleAttribute result = this.internalDoubleAttributes.get(value
				.substring(2, value.length() - 1));
		if (result == null && parent != null)
			result = parent.getInternalDoubleAttribute(value);
		return result;
	}

	/**
	 * This method checks whether the given string is a valid and internal
	 * integer attribute by invoking {@link #isInternalAttribute(String)}. Then
	 * the internal integer attribute is looked up and returned if it exists.
	 * 
	 * @param value
	 *            The name of the internal integer attribute.
	 * @return The internal integer attribute with the given name or null, if
	 *         there is no attribute with the given name
	 */
	public NamedIntegerAttribute getInternalIntegerAttribute(final String value) {
		if (!isInternalAttribute(value)) {
			return null;
		}
		NamedIntegerAttribute result = this.internalIntegerAttributes.get(value
				.substring(2, value.length() - 1));
		if (result == null && parent != null)
			result = parent.getInternalIntegerAttribute(value);
		return result;
	}

	/**
	 * This method checks whether the given string is a valid and internal
	 * string attribute by invoking {@link #isInternalAttribute(String)}. Then
	 * the internal string attribute is looked up and returned if it exists.
	 * 
	 * @param value
	 *            The name of the internal string attribute.
	 * @return The internal string attribute with the given name or null, if
	 *         there is no attribute with the given name
	 */
	public NamedStringAttribute getInternalStringAttribute(final String value) {
		if (!isInternalAttribute(value)) {
			return null;
		}
		NamedStringAttribute result = this.internalStringAttributes.get(value
				.substring(2, value.length() - 1));
		if (result == null && parent != null)
			result = parent.getInternalStringAttribute(value);
		return result;
	}

	/**
	 * @return The absolute path to the directory, where for a certain runresult
	 *         (identified by its unique run identifier) all log files are
	 *         stored.
	 */
	public String getLogBasePath() {
		return ((RunResultEntity) this.repositoryObjectEntities
				.get(RunResult.class)).getResultLogBasePath();
	}

	/**
	 * This method looks up and returns (if it exists) the class of the
	 * parameter optimization method with the given name.
	 * 
	 * @param parameterOptimizationMethodName
	 *            The name of the class of the parameter optimization method.
	 * @return The class of the parameter optimization method with the given
	 *         name or null, if it does not exist.
	 */
	public Class<? extends ParameterOptimizationMethod> getParameterOptimizationMethodClass(
			final String parameterOptimizationMethodName) {
		Class<? extends ParameterOptimizationMethod> result = this.parameterOptimizationMethodClasses
				.get(parameterOptimizationMethodName);
		if (result == null && parent != null)
			return parent
					.getParameterOptimizationMethodClass(parameterOptimizationMethodName);
		return result;
	}

	/**
	 * 
	 * @return The set of all registered parameter optimization method classes.
	 */
	public Collection<Class<? extends ParameterOptimizationMethod>> getParameterOptimizationMethodClasses() {
		return this.parameterOptimizationMethodClasses.values();
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all parameter optimization method jars are stored.
	 */
	public String getParameterOptimizationMethodsBasePath() {
		return this.parameterOptimizationMethodBasePath;
	}

	/**
	 * @return A boolean attribute indicating whether the parameter optimization
	 *         methods have been initialized by the
	 *         {@link ParameterOptimizationMethodFinderThread}.
	 */
	public boolean getParameterOptimizationMethodsInitialized() {
		return this.parameterOptimizationMethodsInitialized;
	}

	/**
	 * 
	 * @return The parent repository of this repository, or null if this
	 *         repository has no parent.
	 */
	public Repository getParent() {
		return this.parent;
	}

	/**
	 * This method checks, whether there is a double program parameter
	 * registered, that is equal to the passed object and returns it.
	 * 
	 * <p>
	 * Equality is checked in terms of
	 * <ul>
	 * <li><b>object.hashCode == other.hashCode</b></li>
	 * <li><b>object.equals(other)</b></li>
	 * </ul>
	 * since internally the repository uses hash datastructures.
	 * 
	 * <p>
	 * By default the {@link RepositoryObject#equals(Object)} method is only
	 * based on the absolute path of the repository object and the repositories
	 * of the two objects, this means two repository objects are considered the
	 * same if they are stored in the same repository and they have the same
	 * absolute path.
	 * 
	 * @param object
	 *            The object for which we want to find an equal registered
	 *            object.
	 * @return The registered object equal to the passed object.
	 */
	public DoubleProgramParameter getRegisteredObject(
			final DoubleProgramParameter object) {
		DoubleProgramParameter other = this.doubleProgramParameters.get(object);
		if (other == null && parent != null)
			return parent.getRegisteredObject(object);
		return other;
	}

	/**
	 * This method looks up and returns (if it exists) the repository object
	 * that belongs to the passed absolute path.
	 * 
	 * @param absFilePath
	 *            The absolute path for which we want to find the repository
	 *            object.
	 * @return The repository object which has the given absolute path.
	 */
	public RepositoryObject getRegisteredObject(final File absFilePath) {
		return this.pathToRepositoryObject.get(absFilePath);
	}

	/**
	 * This method checks, whether there is a finder registered, that is equal
	 * to the passed object and returns it.
	 * 
	 * <p>
	 * Equality is checked in terms of
	 * <ul>
	 * <li><b>object.hashCode == other.hashCode</b></li>
	 * <li><b>object.equals(other)</b></li>
	 * </ul>
	 * since internally the repository uses hash datastructures.
	 * 
	 * <p>
	 * By default the {@link RepositoryObject#equals(Object)} method is only
	 * based on the absolute path of the repository object and the repositories
	 * of the two objects, this means two repository objects are considered the
	 * same if they are stored in the same repository and they have the same
	 * absolute path.
	 * 
	 * @param object
	 *            The object for which we want to find an equal registered
	 *            object.
	 * @return The registered object equal to the passed object.
	 */
	public Finder getRegisteredObject(final Finder object) {
		Finder other = this.finder.get(object);
		if (other == null && parent != null)
			return parent.getRegisteredObject(object);
		return other;
	}

	/**
	 * This method checks, whether there is a goldstandard format registered,
	 * that is equal to the passed object and returns it.
	 * 
	 * <p>
	 * Equality is checked in terms of
	 * <ul>
	 * <li><b>object.hashCode == other.hashCode</b></li>
	 * <li><b>object.equals(other)</b></li>
	 * </ul>
	 * since internally the repository uses hash datastructures.
	 * 
	 * <p>
	 * By default the {@link RepositoryObject#equals(Object)} method is only
	 * based on the absolute path of the repository object and the repositories
	 * of the two objects, this means two repository objects are considered the
	 * same if they are stored in the same repository and they have the same
	 * absolute path.
	 * 
	 * @param object
	 *            The object for which we want to find an equal registered
	 *            object.
	 * @return The registered object equal to the passed object.
	 */
	public GoldStandardFormat getRegisteredObject(
			final GoldStandardFormat object) {
		GoldStandardFormat other = this.goldStandardFormats.get(object);
		if (other == null && parent != null)
			return parent.getRegisteredObject(object);
		return other;
	}

	/**
	 * This method checks, whether there is an integer program parameter
	 * registered, that is equal to the passed object and returns it.
	 * 
	 * <p>
	 * Equality is checked in terms of
	 * <ul>
	 * <li><b>object.hashCode == other.hashCode</b></li>
	 * <li><b>object.equals(other)</b></li>
	 * </ul>
	 * since internally the repository uses hash datastructures.
	 * 
	 * <p>
	 * By default the {@link RepositoryObject#equals(Object)} method is only
	 * based on the absolute path of the repository object and the repositories
	 * of the two objects, this means two repository objects are considered the
	 * same if they are stored in the same repository and they have the same
	 * absolute path.
	 * 
	 * @param object
	 *            The object for which we want to find an equal registered
	 *            object.
	 * @return The registered object equal to the passed object.
	 */
	public IntegerProgramParameter getRegisteredObject(
			final IntegerProgramParameter object) {
		IntegerProgramParameter other = this.integerProgramParameters
				.get(object);
		if (other == null && parent != null)
			return parent.getRegisteredObject(object);
		return other;
	}

	/**
	 * This method checks, whether there is a named double attribute registered,
	 * that is equal to the passed object and returns it.
	 * 
	 * <p>
	 * Equality is checked in terms of
	 * <ul>
	 * <li><b>object.hashCode == other.hashCode</b></li>
	 * <li><b>object.equals(other)</b></li>
	 * </ul>
	 * since internally the repository uses hash datastructures.
	 * 
	 * <p>
	 * By default the {@link RepositoryObject#equals(Object)} method is only
	 * based on the absolute path of the repository object and the repositories
	 * of the two objects, this means two repository objects are considered the
	 * same if they are stored in the same repository and they have the same
	 * absolute path.
	 * 
	 * @param object
	 *            The object for which we want to find an equal registered
	 *            object.
	 * @return The registered object equal to the passed object.
	 */
	public NamedDoubleAttribute getRegisteredObject(
			final NamedDoubleAttribute object) {
		NamedDoubleAttribute other = this.internalDoubleAttributes.get(object
				.getName());
		if (other == null && parent != null)
			return parent.getRegisteredObject(object);
		return other;
	}

	/**
	 * This method checks, whether there is a named integer attribute
	 * registered, that is equal to the passed object and returns it.
	 * 
	 * <p>
	 * Equality is checked in terms of
	 * <ul>
	 * <li><b>object.hashCode == other.hashCode</b></li>
	 * <li><b>object.equals(other)</b></li>
	 * </ul>
	 * since internally the repository uses hash datastructures.
	 * 
	 * <p>
	 * By default the {@link RepositoryObject#equals(Object)} method is only
	 * based on the absolute path of the repository object and the repositories
	 * of the two objects, this means two repository objects are considered the
	 * same if they are stored in the same repository and they have the same
	 * absolute path.
	 * 
	 * @param object
	 *            The object for which we want to find an equal registered
	 *            object.
	 * @return The registered object equal to the passed object.
	 */
	public NamedIntegerAttribute getRegisteredObject(
			final NamedIntegerAttribute object) {
		NamedIntegerAttribute other = this.internalIntegerAttributes.get(object
				.getName());
		if (other == null && parent != null)
			return parent.getRegisteredObject(object);
		return other;
	}

	/**
	 * This method checks, whether there is a named string attribute registered,
	 * that is equal to the passed object and returns it.
	 * 
	 * <p>
	 * Equality is checked in terms of
	 * <ul>
	 * <li><b>object.hashCode == other.hashCode</b></li>
	 * <li><b>object.equals(other)</b></li>
	 * </ul>
	 * since internally the repository uses hash datastructures.
	 * 
	 * <p>
	 * By default the {@link RepositoryObject#equals(Object)} method is only
	 * based on the absolute path of the repository object and the repositories
	 * of the two objects, this means two repository objects are considered the
	 * same if they are stored in the same repository and they have the same
	 * absolute path.
	 * 
	 * @param object
	 *            The object for which we want to find an equal registered
	 *            object.
	 * @return The registered object equal to the passed object.
	 */
	public NamedStringAttribute getRegisteredObject(
			final NamedStringAttribute object) {
		NamedStringAttribute other = this.internalStringAttributes.get(object
				.getName());
		if (other == null && parent != null)
			return parent.getRegisteredObject(object);
		return other;
	}

	/**
	 * This method checks, whether there is a program registered, that is equal
	 * to the passed object and returns it.
	 * 
	 * <p>
	 * Equality is checked in terms of
	 * <ul>
	 * <li><b>object.hashCode == other.hashCode</b></li>
	 * <li><b>object.equals(other)</b></li>
	 * </ul>
	 * since internally the repository uses hash datastructures.
	 * 
	 * <p>
	 * By default the {@link RepositoryObject#equals(Object)} method is only
	 * based on the absolute path of the repository object and the repositories
	 * of the two objects, this means two repository objects are considered the
	 * same if they are stored in the same repository and they have the same
	 * absolute path.
	 * 
	 * @param object
	 *            The object for which we want to find an equal registered
	 *            object.
	 * @return The registered object equal to the passed object.
	 */
	public ParameterOptimizationMethod getRegisteredObject(
			final ParameterOptimizationMethod object) {
		ParameterOptimizationMethod other = this.parameterOptimizationMethodInstances
				.get(object.getClass().getSimpleName()).get(object);
		if (other == null && parent != null)
			return parent.getRegisteredObject(object);
		return other;
	}

	/**
	 * This method checks, whether there is a statistic calculator registered,
	 * that is equal to the passed object and returns it.
	 * 
	 * <p>
	 * Equality is checked in terms of
	 * <ul>
	 * <li><b>object.hashCode == other.hashCode</b></li>
	 * <li><b>object.equals(other)</b></li>
	 * </ul>
	 * since internally the repository uses hash datastructures.
	 * 
	 * <p>
	 * By default the {@link RepositoryObject#equals(Object)} method is only
	 * based on the absolute path of the repository object and the repositories
	 * of the two objects, this means two repository objects are considered the
	 * same if they are stored in the same repository and they have the same
	 * absolute path.
	 * 
	 * @param object
	 *            The object for which we want to find an equal registered
	 *            object.
	 * @return The registered object equal to the passed object.
	 */
	public StatisticCalculator<? extends Statistic> getRegisteredObject(
			final StatisticCalculator<? extends Statistic> object) {
		StatisticCalculator<? extends Statistic> other = this.statisticCalculators
				.get(object);
		if (other == null && parent != null)
			return parent.getRegisteredObject(object);
		return other;
	}

	/**
	 * This method checks, whether there is a string program parameter
	 * registered, that is equal to the passed object and returns it.
	 * 
	 * <p>
	 * Equality is checked in terms of
	 * <ul>
	 * <li><b>object.hashCode == other.hashCode</b></li>
	 * <li><b>object.equals(other)</b></li>
	 * </ul>
	 * since internally the repository uses hash datastructures.
	 * 
	 * <p>
	 * By default the {@link RepositoryObject#equals(Object)} method is only
	 * based on the absolute path of the repository object and the repositories
	 * of the two objects, this means two repository objects are considered the
	 * same if they are stored in the same repository and they have the same
	 * absolute path.
	 * 
	 * @param object
	 *            The object for which we want to find an equal registered
	 *            object.
	 * @return The registered object equal to the passed object.
	 */
	public StringProgramParameter getRegisteredObject(
			final StringProgramParameter object) {
		StringProgramParameter other = this.stringProgramParameters.get(object);
		if (other == null && parent != null)
			return parent.getRegisteredObject(object);
		return other;
	}

	/**
	 * This method looks up and returns (if it exists) the runresult with the
	 * given unique identifier.
	 * 
	 * @param runIdentifier
	 *            The identifier of the runresult.
	 * @return The runresult with the given identifier.
	 */
	public RunResult getRegisteredRunResult(final String runIdentifier) {
		return ((RunResultEntity) this.repositoryObjectEntities
				.get(RunResult.class)).runResultIdentifier.get(runIdentifier);
	}

	/**
	 * @return The configuration of this repository.
	 */
	public RepositoryConfig getRepositoryConfig() {
		return this.repositoryConfig;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the RProgram
	 * with the given name.
	 * 
	 * @param rProgramClassName
	 *            The name of the RProgram class.
	 * @return The RProgram with the given name.
	 */
	public Class<? extends RProgram> getRProgramClass(
			final String rProgramClassName) {
		Class<? extends RProgram> result = this.rProgramClasses
				.get(rProgramClassName);
		if (result == null && parent != null)
			result = this.parent.getRProgramClass(rProgramClassName);
		return result;
	}

	/**
	 * 
	 * @return The set of all registered RProgram classes.
	 */
	public Collection<Class<? extends RProgram>> getRProgramClasses() {
		return this.rProgramClasses.values();
	}

	/**
	 * @return A boolean attribute indicating whether the RPrograms have been
	 *         initialized by the {@link RProgramFinderThread}.
	 */
	public boolean getRProgramsInitialized() {
		return this.rProgramsInitialized;
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all run data statistics are stored.
	 */
	public String getRunDataStatisticBasePath() {
		return runDataStatisticBasePath;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the run-data
	 * statistic calculator corresponding to the run-data-statistic with the
	 * given name.
	 * 
	 * @param runDataStatisticClassName
	 *            The name of the class of the run-data statistic.
	 * @return The class of the run-data statistic calculator for the given
	 *         name, or null if it does not exist.
	 */
	public Class<? extends RunDataStatisticCalculator<? extends RunDataStatistic>> getRunDataStatisticCalculator(
			final String runDataStatisticClassName) {
		Class<? extends RunDataStatisticCalculator<? extends RunDataStatistic>> result = this.runDataStatisticCalculatorClasses
				.get(runDataStatisticClassName);
		if (result == null && parent != null)
			result = this.parent
					.getRunDataStatisticCalculator(runDataStatisticClassName);
		return result;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the run-data
	 * statistic with the given name.
	 * 
	 * @param runDataStatisticClassName
	 *            The name of the class of the run-data statistic.
	 * @return The class of the run-data statistic calculator for the given
	 *         name, or null if it does not exist.
	 */
	public Class<? extends RunDataStatistic> getRunDataStatisticClass(
			final String runDataStatisticClassName) {
		Class<? extends RunDataStatistic> result = this.runDataStatisticClasses
				.get(runDataStatisticClassName);
		if (result == null && parent != null)
			result = this.parent
					.getRunDataStatisticClass(runDataStatisticClassName);
		return result;
	}

	/**
	 * 
	 * @return The set of all registered run data statistic classes.
	 */
	public Collection<Class<? extends RunDataStatistic>> getRunDataStatisticClasses() {
		return this.runDataStatisticClasses.values();
	}

	/**
	 * @return A boolean attribute indicating whether the run data statistics
	 *         have been initialized by the {@link RunDataStatisticFinderThread}
	 *         .
	 */
	public boolean getRunDataStatisticsInitialized() {
		return this.runDataStatisticsInitialized;
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all runresult formats are stored.
	 */
	public String getRunResultFormatBasePath() {
		return this.runResultFormatBasePath;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the
	 * runresult format with the given name.
	 * 
	 * @param runResultFormatClassName
	 *            The runresult format class name.
	 * @return The runresult format with the given name.
	 */
	public Class<? extends RunResultFormat> getRunResultFormatClass(
			final String runResultFormatClassName) {
		Class<? extends RunResultFormat> result = this.runResultFormatClasses
				.get(runResultFormatClassName);
		if (result == null && parent != null)
			return parent.getRunResultFormatClass(runResultFormatClassName);
		return result;
	}

	/**
	 * 
	 * @return The set of all registered run result format classes.
	 */
	public Collection<Class<? extends RunResultFormat>> getRunResultFormatClasses() {
		return this.runResultFormatClasses.values();
	}

	/**
	 * This method looks up and returns (if it exists) the class of the
	 * runresult format parser corresponding to the runresult format with the
	 * given name.
	 * 
	 * @param runResultFormatName
	 *            The runresult format name.
	 * @return The runresult format parser for the given runresult format name,
	 *         or null if it does not exist.
	 */
	public Class<? extends RunResultFormatParser> getRunResultFormatParser(
			final String runResultFormatName) {
		Class<? extends RunResultFormatParser> result = this.runResultFormatParser
				.get(runResultFormatName);
		if (result == null && parent != null)
			result = parent.getRunResultFormatParser(runResultFormatName);
		return result;
	}

	/**
	 * @return A boolean attribute indicating whether the runresult formats have
	 *         been initialized by the {@link RunResultFormatFinderThread}.
	 */
	public boolean getRunResultFormatsInitialized() {
		return this.runResultFormatsInitialized;
	}

	/**
	 * @return A collection with the names of those runresult directories
	 *         contained in the repository of this server, that contain a
	 *         clusters subfolder and at least one *.complete file containing
	 *         results (can be slow if many run result folders are present).
	 */
	public Collection<String> getRunResultIdentifier() {
		Collection<String> result = new HashSet<String>();

		for (File resultDir : new File(this.getBasePath(RunResult.class))
				.listFiles()) {
			if (resultDir.isDirectory()) {
				File clustersDir = new File(FileUtils.buildPath(
						resultDir.getAbsolutePath(), "clusters"));
				if (clustersDir.exists() && clustersDir.isDirectory()) {
					/*
					 * Take only those, that contain at least one *.complete
					 * file
					 */
					for (File resultsFile : clustersDir.listFiles()) {
						if (resultsFile.getName().endsWith(".complete")) {
							result.add(resultDir.getName());
							break;
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * @return A collection with the names of all run result directories
	 *         contained in the repository of this server. Those run result
	 *         directories can be resumed, if they were terminated before.
	 */
	public Collection<String> getRunResumes() {
		Collection<String> result = new HashSet<String>();

		for (File resultDir : new File(this.getBasePath(RunResult.class))
				.listFiles()) {
			if (resultDir.isDirectory()) {
				result.add(resultDir.getName());
			}
		}

		return result;
	}

	// /**
	// * @return A collection with all runs registered in this repository.
	// */
	// TODO: differs from getCollection(Run.class) in that it does not include
	// parent runs -> check
	// public Collection<Run> getRuns() {
	// synchronized (this.runs) {
	// return new HashSet<Run>(this.runs.values());
	// }
	// }

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all run statistics are stored.
	 */
	public String getRunStatisticBasePath() {
		return runStatisticBasePath;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the run
	 * statistic calculator corresponding to the run statistic class with the
	 * given name.
	 * 
	 * @param runStatisticClassName
	 *            The name of the run statistic class.
	 * @return The run statistic calculator for the given run statistic class
	 *         name.
	 */
	public Class<? extends RunStatisticCalculator<? extends RunStatistic>> getRunStatisticCalculator(
			final String runStatisticClassName) {
		Class<? extends RunStatisticCalculator<? extends RunStatistic>> result = this.runStatisticCalculatorClasses
				.get(runStatisticClassName);
		if (result == null && parent != null)
			result = this.parent
					.getRunStatisticCalculator(runStatisticClassName);
		return result;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the run
	 * statistic with the given name.
	 * 
	 * @param runStatisticClassName
	 *            The name of the run statistic class.
	 * @return The run statistic with the given class name.
	 */
	public Class<? extends RunStatistic> getRunStatisticClass(
			final String runStatisticClassName) {
		Class<? extends RunStatistic> result = this.runStatisticClasses
				.get(runStatisticClassName);
		if (result == null && parent != null)
			result = this.parent.getRunStatisticClass(runStatisticClassName);
		return result;
	}

	/**
	 * 
	 * @return The set of all registered run statistic classes.
	 */
	public Collection<Class<? extends RunStatistic>> getRunStatisticClasses() {
		return this.runStatisticClasses.values();
	}

	/**
	 * @return A boolean attribute indicating whether the run statistics have
	 *         been initialized by the {@link RunStatisticFinderThread}.
	 */
	public boolean getRunStatisticsInitialized() {
		return this.runStatisticsInitialized;
	}

	/**
	 * @return In case the backend is connected to a mysql database in the
	 *         frontend, this returns an sql communicator, which updates the
	 *         database after changes of repository objects (removal, addition),
	 *         otherwise it returns a stub sql communicator.
	 */
	public SQLCommunicator getSqlCommunicator() {
		return sqlCommunicator;
	}

	/**
	 * 
	 * @return The supervisor thread is responsible for starting and keeping
	 *         alive all threads that check the repository on the filesystem for
	 *         changes.
	 */
	public SupervisorThread getSupervisorThread() {
		return supervisorThread;
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all supplementary materials are stored.
	 */
	public String getSupplementaryBasePath() {
		return this.supplementaryBasePath;
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all supplementary materials related to clustering are stored.
	 */
	public String getSupplementaryClusteringBasePath() {
		return this.suppClusteringBasePath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.basePath.hashCode();
	}

	/**
	 * A helper method for logging, which can overwritten to change the
	 * logger-level in subclasses of this class. For example in
	 * RunResultRepostories we do not want to log everything, therefore we
	 * change the log level to debug.
	 * 
	 * @param The
	 *            message to log.
	 */
	protected void info(final String message) {
		this.log.info(message);
	}

	/**
	 * This method initializes all attribute maps and all variables, that keep
	 * registered repository objects.
	 * 
	 * <p>
	 * A helper method for and invoked by
	 * {@link #Repository(String, Repository, long, long, long, long, long, long, long)}.
	 */
	protected void initAttributes() {

		this.repositoryObjectEntities = new RepositoryObjectEntityMap();

		this.repositoryObjectEntities.put(
				DataSet.class,
				new RepositoryObjectEntity<DataSet>(this, this.parent != null
						? this.parent.repositoryObjectEntities
								.get(DataSet.class) : null, FileUtils
						.buildPath(this.basePath, "data", "datasets")));

		this.repositoryObjectEntities.put(
				DataSetConfig.class,
				new RepositoryObjectEntity<DataSetConfig>(this,
						this.parent != null
								? this.parent.repositoryObjectEntities
										.get(DataSetConfig.class) : null,
						FileUtils.buildPath(this.basePath, "data", "datasets",
								"configs")));

		this.repositoryObjectEntities.put(
				GoldStandard.class,
				new RepositoryObjectEntity<GoldStandard>(this,
						this.parent != null
								? this.parent.repositoryObjectEntities
										.get(GoldStandard.class) : null,
						FileUtils.buildPath(this.basePath, "data",
								"goldstandards")));

		this.repositoryObjectEntities.put(
				GoldStandardConfig.class,
				new RepositoryObjectEntity<GoldStandardConfig>(this,
						this.parent != null
								? this.parent.repositoryObjectEntities
										.get(GoldStandardConfig.class) : null,
						FileUtils.buildPath(this.basePath, "data",
								"goldstandards", "configs")));

		this.repositoryObjectEntities.put(
				DataConfig.class,
				new RepositoryObjectEntity<DataConfig>(this,
						this.parent != null
								? this.parent.repositoryObjectEntities
										.get(DataConfig.class) : null,
						FileUtils.buildPath(this.basePath, "data", "configs")));

		this.repositoryObjectEntities.put(Run.class,
				new RepositoryObjectEntity<Run>(this, this.parent != null
						? this.parent.repositoryObjectEntities.get(Run.class)
						: null, FileUtils.buildPath(this.basePath, "runs")));

		this.repositoryObjectEntities.put(
				ProgramConfig.class,
				new RepositoryObjectEntity<ProgramConfig>(this,
						this.parent != null
								? this.parent.repositoryObjectEntities
										.get(ProgramConfig.class) : null,
						FileUtils.buildPath(this.basePath, "programs",
								"configs")));

		this.repositoryObjectEntities.put(
				Program.class,
				new RepositoryObjectEntity<Program>(this, this.parent != null
						? this.parent.repositoryObjectEntities
								.get(Program.class) : null, FileUtils
						.buildPath(this.basePath, "programs")));

		this.repositoryObjectEntities.put(
				RunResult.class,
				new RunResultEntity(this, this.parent != null
						? this.parent.repositoryObjectEntities
								.get(RunResult.class) : null, FileUtils
						.buildPath(this.basePath, "results")));

		this.contextClasses = new ConcurrentHashMap<String, Class<? extends Context>>();
		this.contextInstances = new ConcurrentHashMap<String, List<Context>>();
		this.dataSetFormatInstances = new ConcurrentHashMap<String, List<DataSetFormat>>();
		this.dataSetFormatClasses = new ConcurrentHashMap<String, Class<? extends DataSetFormat>>();
		this.dataSetGeneratorInstances = new ConcurrentHashMap<String, List<DataSetGenerator>>();
		this.dataSetGeneratorClasses = new ConcurrentHashMap<String, Class<? extends DataSetGenerator>>();
		this.dataPreprocessorInstances = new ConcurrentHashMap<String, List<DataPreprocessor>>();
		this.dataPreprocessorClasses = new ConcurrentHashMap<String, Class<? extends DataPreprocessor>>();
		this.dataSetTypeInstances = new ConcurrentHashMap<String, List<DataSetType>>();
		this.dataSetTypeClasses = new ConcurrentHashMap<String, Class<? extends DataSetType>>();
		this.distanceMeasureClasses = new ConcurrentHashMap<String, Class<? extends DistanceMeasure>>();
		this.distanceMeasureInstances = new ConcurrentHashMap<String, List<DistanceMeasure>>();
		this.dataStatisticClasses = new ConcurrentHashMap<String, Class<? extends DataStatistic>>();
		this.dataStatisticInstances = new ConcurrentHashMap<String, List<DataStatistic>>();
		this.statisticCalculators = new ConcurrentHashMap<StatisticCalculator<? extends Statistic>, StatisticCalculator<? extends Statistic>>();
		this.runStatisticClasses = new ConcurrentHashMap<String, Class<? extends RunStatistic>>();
		this.runStatisticInstances = new ConcurrentHashMap<String, List<RunStatistic>>();
		this.runDataStatisticClasses = new ConcurrentHashMap<String, Class<? extends RunDataStatistic>>();
		this.runDataStatisticInstances = new ConcurrentHashMap<String, List<RunDataStatistic>>();
		this.dataSetFormatParser = new ConcurrentHashMap<String, Class<? extends DataSetFormatParser>>();
		this.dataStatisticCalculatorClasses = new ConcurrentHashMap<String, Class<? extends DataStatisticCalculator<? extends DataStatistic>>>();
		this.runStatisticCalculatorClasses = new ConcurrentHashMap<String, Class<? extends RunStatisticCalculator<? extends RunStatistic>>>();
		this.runDataStatisticCalculatorClasses = new ConcurrentHashMap<String, Class<? extends RunDataStatisticCalculator<? extends RunDataStatistic>>>();
		this.clusteringQualityMeasureClasses = new ConcurrentHashMap<String, Class<? extends ClusteringQualityMeasure>>();
		this.clusteringQualityMeasureInstances = new ConcurrentHashMap<String, List<ClusteringQualityMeasure>>();
		this.goldStandardFormats = new ConcurrentHashMap<GoldStandardFormat, GoldStandardFormat>();
		this.rProgramClasses = new ConcurrentHashMap<String, Class<? extends RProgram>>();
		this.rProgramInstances = new ConcurrentHashMap<String, List<RProgram>>();
		this.runResultFormatClasses = new ConcurrentHashMap<String, Class<? extends RunResultFormat>>();
		this.runResultFormatInstances = new ConcurrentHashMap<String, List<RunResultFormat>>();
		this.runResultFormatParser = new ConcurrentHashMap<String, Class<? extends RunResultFormatParser>>();
		this.finder = new ConcurrentHashMap<Finder, Finder>();
		this.parameterOptimizationMethodClasses = new ConcurrentHashMap<String, Class<? extends ParameterOptimizationMethod>>();
		this.parameterOptimizationMethodInstances = new ConcurrentHashMap<String, Map<ParameterOptimizationMethod, ParameterOptimizationMethod>>();

		this.internalDoubleAttributes = new ConcurrentHashMap<String, NamedDoubleAttribute>();
		this.internalStringAttributes = new ConcurrentHashMap<String, NamedStringAttribute>();
		this.internalIntegerAttributes = new ConcurrentHashMap<String, NamedIntegerAttribute>();

		this.doubleProgramParameters = new ConcurrentHashMap<DoubleProgramParameter, DoubleProgramParameter>();
		this.integerProgramParameters = new ConcurrentHashMap<IntegerProgramParameter, IntegerProgramParameter>();
		this.stringProgramParameters = new ConcurrentHashMap<StringProgramParameter, StringProgramParameter>();

		this.clusterings = new ConcurrentHashMap<Clustering, Clustering>();
		this.clusters = new ConcurrentHashMap<Cluster, Cluster>();
		this.clusterItems = new ConcurrentHashMap<ClusterItem, ClusterItem>();

		// added 14.04.2013
		this.dataSetFormatCurrentVersions = new HashMap<String, Integer>();
		this.knownFinderExceptions = new ConcurrentHashMap<String, List<Throwable>>();
		this.finderClassLoaders = new ConcurrentHashMap<URL, URLClassLoader>();
		this.finderWaitingFiles = new ConcurrentHashMap<File, List<File>>();
		this.finderLoadedJarFileChangeDates = new ConcurrentHashMap<String, Long>();
	}

	/**
	 * Initializes this repository by creating a supervisor thread
	 * {@link #createSupervisorThread()} and waiting until
	 * {@link #isInitialized()} returns true.
	 * 
	 * @throws InterruptedException
	 *             Is thrown, if the current thread is interrupted while waiting
	 *             for finishing the initialization process.
	 */
	public void initialize() throws InterruptedException {
		if (isInitialized() || this.supervisorThread != null)
			return;

		this.supervisorThread = createSupervisorThread();

		// wait until repository initialized
		try {
			while (!this.isInitialized())
				Thread.sleep(100);
		} catch (InterruptedException e) {
			this.terminateSupervisorThread();
			throw e;
		}

		this.info("Repository initialization finished");

		/**
		 * Print warnings for all required R libraries, that could not be loaded
		 */
		if (ClustevalBackendServer.isRAvailable()) {
			if (this.missingRLibraries.size() > 0) {
				this.warn("The following R library dependencies are not satisified (the corresponding class has not been loaded):");
				this.warn("Please ensure that those libraries are installed in your R installation:");
			}
			for (String className : this.missingRLibraries.keySet())
				for (RLibraryNotLoadedException e : this.missingRLibraries
						.get(className)) {
					this.warn("Class '" + e.getClassName()
							+ "' requires the unavailable R library '"
							+ e.getRLibrary() + "'");
				}
		}
	}

	/**
	 * This method sets all the absolute paths used by the repository to store
	 * any kinds of files and data on the filesystem.
	 * 
	 * <p>
	 * This method only initializes the attributes itself to valid paths, but
	 * does not create or ensure any folder structure.
	 * <p>
	 * A helper method of
	 * {@link #Repository(String, Repository, long, long, long, long, long, long, long)}.
	 * 
	 * @throws InvalidRepositoryException
	 * 
	 */
	@SuppressWarnings("unused")
	protected void initializePaths() throws InvalidRepositoryException {
		this.dataBasePath = FileUtils.buildPath(this.basePath, "data");
		this.supplementaryBasePath = FileUtils.buildPath(this.basePath, "supp");
		this.contextBasePath = FileUtils.buildPath(this.supplementaryBasePath,
				"contexts");
		this.suppClusteringBasePath = FileUtils.buildPath(
				this.supplementaryBasePath, "clustering");
		this.parameterOptimizationMethodBasePath = FileUtils.buildPath(
				this.suppClusteringBasePath, "paramOptimization");
		this.clusteringQualityMeasureBasePath = FileUtils.buildPath(
				this.suppClusteringBasePath, "qualityMeasures");
		this.formatsBasePath = FileUtils.buildPath(this.supplementaryBasePath,
				"formats");
		this.dataSetFormatBasePath = FileUtils.buildPath(this.formatsBasePath,
				"dataset");
		this.generatorBasePath = FileUtils.buildPath(
				this.supplementaryBasePath, "generators");
		this.dataSetGeneratorBasePath = FileUtils.buildPath(
				this.generatorBasePath, "dataset");
		this.dataPreprocessorBasePath = FileUtils.buildPath(
				this.supplementaryBasePath, "preprocessing");
		this.runResultFormatBasePath = FileUtils.buildPath(
				this.formatsBasePath, "runresult");
		this.typesBasePath = FileUtils.buildPath(this.supplementaryBasePath,
				"types");
		this.dataSetTypeBasePath = FileUtils.buildPath(this.typesBasePath,
				"dataset");
		this.dataStatisticBasePath = FileUtils.buildPath(
				this.supplementaryBasePath, "statistics", "data");
		this.runStatisticBasePath = FileUtils.buildPath(
				this.supplementaryBasePath, "statistics", "run");
		this.runDataStatisticBasePath = FileUtils.buildPath(
				this.supplementaryBasePath, "statistics", "rundata");
		this.distanceMeasureBasePath = FileUtils.buildPath(
				this.supplementaryBasePath, "distanceMeasures");
	}

	/**
	 * This method checks whether the given clustering quality measure class is
	 * registered in this repository.
	 * 
	 * @param clusteringQualityMeasure
	 *            The class of the clustering quality measure to look up.
	 * @return True, if the clustering quality measure class was registered.
	 */
	public boolean isClusteringQualityMeasureRegistered(
			final Class<? extends ClusteringQualityMeasure> clusteringQualityMeasure) {
		return this.clusteringQualityMeasureClasses
				.containsKey(clusteringQualityMeasure.getName())
				|| (this.parent != null && this.parent
						.isClusteringQualityMeasureRegistered(clusteringQualityMeasure));
	}

	/**
	 * This method checks whether a clustering quality measure with the given
	 * name is registered in this repository.
	 * 
	 * @param clusteringQualityMeasure
	 *            The name of the clustering quality measure to look up.
	 * @return True, if the clustering quality measure was registered.
	 */
	public boolean isClusteringQualityMeasureRegistered(
			final String clusteringQualityMeasure) {
		return this.clusteringQualityMeasureClasses
				.containsKey(clusteringQualityMeasure)
				|| (this.parent != null && this.parent
						.isClusteringQualityMeasureRegistered(clusteringQualityMeasure));
	}

	/**
	 * This method checks whether the given dataset format class is registered
	 * in this repository.
	 * 
	 * @param dsFormat
	 *            The class of the dataset format to look up.
	 * @return True, if the dataset format class was registered.
	 */
	public boolean isDataSetFormatRegistered(
			final Class<? extends DataSetFormat> dsFormat) {
		return this.dataSetFormatClasses.containsKey(dsFormat.getName())
				|| (this.parent != null && this.parent
						.isDataSetFormatRegistered(dsFormat));
	}

	/**
	 * This method checks whether a dataset format with the given class name is
	 * registered in this repository.
	 * 
	 * @param dsFormatClassName
	 *            The class name of the dataset format to look up.
	 * @return True, if the dataset format class was registered.
	 */
	public boolean isDataSetFormatRegistered(final String dsFormatClassName) {
		return this.dataSetFormatClasses.containsKey(dsFormatClassName)
				|| (this.parent != null && this.parent
						.isDataSetFormatRegistered(dsFormatClassName));
	}

	/**
	 * This method checks whether the a dataset type with the given class is
	 * registered in this repository.
	 * 
	 * @param dsType
	 *            The class of the dataset type to look up.
	 * @return True, if the dataset type class was registered.
	 */
	public boolean isDataSetTypeRegistered(
			final Class<? extends DataSetType> dsType) {
		return this.dataSetTypeClasses.containsKey(dsType.getName())
				|| (this.parent != null && this.parent
						.isDataSetTypeRegistered(dsType));
	}

	/**
	 * This method checks whether a dataset type with the given class name is
	 * registered in this repository.
	 * 
	 * @param dsTypeClassName
	 *            The class of the dataset type to look up.
	 * @return True, if the dataset type class was registered.
	 */
	public boolean isDataSetTypeRegistered(final String dsTypeClassName) {
		return this.dataSetTypeClasses.containsKey(dsTypeClassName)
				|| (this.parent != null && this.parent
						.isDataSetTypeRegistered(dsTypeClassName));
	}

	/**
	 * This method checks whether a data statistic with the given class name is
	 * registered in this repository.
	 * 
	 * @param dsStatisticClassName
	 *            The class name of the data statistic to look up.
	 * @return True, if the data statistic was registered.
	 */
	public boolean isDataStatisticRegistered(final String dsStatisticClassName) {
		return this.dataStatisticClasses.containsKey(dsStatisticClassName)
				|| (this.parent != null && this.parent
						.isDataStatisticRegistered(dsStatisticClassName));
	}

	/**
	 * This method checks whether a distance measure class is registered in this
	 * repository.
	 * 
	 * @param distanceMeasure
	 *            The class of the distance measure to look up.
	 * @return True, if the distance measure class was registered.
	 */
	public boolean isDistanceMeasureRegistered(
			final Class<? extends DistanceMeasure> distanceMeasure) {
		return this.isDistanceMeasureRegistered(distanceMeasure.getName());
	}

	/**
	 * This method checks whether a distance measure with the given class name
	 * is registered in this repository.
	 * 
	 * @param distMeasureClassName
	 *            The class name of the distance measure to look up.
	 * @return True, if the distance measure was registered.
	 */
	public boolean isDistanceMeasureRegistered(final String distMeasureClassName) {
		return this.distanceMeasureClasses.containsKey(distMeasureClassName)
				|| (this.parent != null && this.parent
						.isDistanceMeasureRegistered(distMeasureClassName));
	}

	/**
	 * This method checks, whether this repository has been initialized. A
	 * repository is initialized, if the following invocations return true:
	 * 
	 * <ul>
	 * <li><b>getDataSetFormatsInitialized()</b></li>
	 * <li><b>getDataSetTypesInitialized()</b></li>
	 * <li><b>getDataStatisticsInitialized()</b></li>
	 * <li><b>getRunStatisticsInitialized()</b></li>
	 * <li><b>getRunDataStatisticsInitialized()</b></li>
	 * <li><b>getRunResultFormatsInitialized()</b></li>
	 * <li><b>getClusteringQualityMeasuresInitialized()</b></li>
	 * <li><b>getParameterOptimizationMethodsInitialized()</b></li>
	 * <li><b>getRunsInitialized()</b></li>
	 * <li><b>getRProgramsInitialized()</b></li>
	 * <li><b>getDataSetConfigsInitialized()</b></li>
	 * <li><b>getGoldStandardConfigsInitialized()</b></li>
	 * <li><b>getDataConfigsInitialized()</b></li>
	 * <li><b>getProgramConfigsInitialized()</b></li>
	 * <li><b>getDataSetGeneratorsInitialized()</b></li>
	 * <li><b>getDistanceMeasuresInitialized()</b></li>
	 * </ul>
	 * 
	 * @return True, if this repository is initialized.
	 */
	public boolean isInitialized() {
		// TODO: for loop?
		return getDataSetFormatsInitialized() && getDataSetTypesInitialized()
				&& getDataStatisticsInitialized()
				&& getRunStatisticsInitialized()
				&& getRunDataStatisticsInitialized()
				&& getRunResultFormatsInitialized()
				&& getClusteringQualityMeasuresInitialized()
				&& getParameterOptimizationMethodsInitialized()
				&& isInitialized(Run.class) && getRProgramsInitialized()
				&& isInitialized(DataSetConfig.class)
				&& isInitialized(DataSet.class)
				&& isInitialized(GoldStandardConfig.class)
				&& isInitialized(DataConfig.class)
				&& isInitialized(ProgramConfig.class)
				&& getDataSetGeneratorsInitialized()
				&& getContextsInitialized()
				&& getDataPreprocessorsInitialized()
				&& getDistanceMeasuresInitialized();
	}

	/**
	 * @return A boolean attribute indicating whether the dataset generators
	 *         have been initialized by the {@link DataSetGeneratorFinderThread}
	 *         .
	 */
	public boolean getDataSetGeneratorsInitialized() {
		return this.dataSetGeneratorsInitialized;
	}

	/**
	 * This method checks whether a parameter optimization method with the given
	 * class name is registered in this repository.
	 * 
	 * @param parameterOptimizationMethodClass
	 *            The class name of the parameter optimization method to look
	 *            up.
	 * @return True, if the parameter optimization method was registered.
	 */
	public boolean isParameterOptimizationMethodRegistered(
			final String parameterOptimizationMethodClass) {
		return this.parameterOptimizationMethodClasses
				.containsKey(parameterOptimizationMethodClass)
				|| (this.parent != null && this.parent
						.isParameterOptimizationMethodRegistered(parameterOptimizationMethodClass));
	}

	/**
	 * This method checks whether a parser has been registered for the given
	 * dataset format class.
	 * 
	 * @param dsFormat
	 *            The class for which we want to know whether a parser has been
	 *            registered.
	 * @return True, if the parser has been registered.
	 */
	public boolean isRegisteredForDataSetFormat(
			final Class<? extends DataSetFormat> dsFormat) {
		return this.dataSetFormatParser.containsKey(dsFormat.getName())
				|| (this.parent != null && this.parent
						.isRegisteredForDataSetFormat(dsFormat));
	}

	/**
	 * This method checks whether a parser has been registered for the dataset
	 * format with the given class name.
	 * 
	 * @param dsFormatName
	 *            The class name for which we want to know whether a parser has
	 *            been registered.
	 * @return True, if the parser has been registered.
	 */
	public boolean isRegisteredForDataSetFormat(final String dsFormatName) {
		return this.dataSetFormatParser.containsKey(dsFormatName)
				|| (this.parent != null && this.parent
						.isRegisteredForDataSetFormat(dsFormatName));
	}

	/**
	 * This method checks whether a parser has been registered for the given
	 * runresult format class.
	 * 
	 * @param runResultFormat
	 *            The class for which we want to know whether a parser has been
	 *            registered.
	 * @return True, if the parser has been registered.
	 */
	public boolean isRegisteredForRunResultFormat(
			final Class<? extends RunResultFormat> runResultFormat) {
		return this.runResultFormatParser
				.containsKey(runResultFormat.getName())
				|| (this.parent != null && this.parent
						.isRegisteredForRunResultFormat(runResultFormat));
	}

	/**
	 * This method checks whether a parser has been registered for the dataset
	 * format with the given class name.
	 * 
	 * @param runResultFormatName
	 *            The class for which we want to know whether a parser has been
	 *            registered.
	 * @return True, if the parser has been registered.
	 */
	public boolean isRegisteredForRunResultFormat(
			final String runResultFormatName) {
		return this.runResultFormatParser.containsKey(runResultFormatName)
				|| (this.parent != null && this.parent
						.isRegisteredForRunResultFormat(runResultFormatName));
	}

	/**
	 * This method checks, whether a RProgram with the given name has been
	 * registered.
	 * 
	 * @param string
	 *            The name of the RProgram.
	 * @return True, if an RProgram with the given name has been registered.
	 */
	public boolean isRProgramRegistered(String string) {
		return this.rProgramClasses.containsKey(string)
				|| (this.parent != null && this.parent
						.isRProgramRegistered(string));
	}

	/**
	 * This method checks whether a run-data statistic has been registered for
	 * the given run-data statistic class name.
	 * 
	 * @param dsStatisticClassName
	 *            The class name of the run-data statistic we want to look up.
	 * @return True, if the run-data statistic has been registered.
	 */
	public boolean isRunDataStatisticRegistered(
			final String dsStatisticClassName) {
		return this.runDataStatisticClasses.containsKey(dsStatisticClassName)
				|| (this.parent != null && this.parent
						.isRunDataStatisticRegistered(dsStatisticClassName));
	}

	/**
	 * This method checks whether a runresult format with the given class has
	 * been registered.
	 * 
	 * @param rrFormat
	 *            The class for which we want to know whether a runresult format
	 *            has been registered.
	 * @return True, if the runresult format has been registered.
	 */
	public boolean isRunResultFormatRegistered(
			final Class<? extends RunResultFormat> rrFormat) {
		return this.runResultFormatClasses.containsKey(rrFormat.getName())
				|| (this.parent != null && this.parent
						.isRunResultFormatRegistered(rrFormat));
	}

	/**
	 * This method checks whether a runresult format has been registered with
	 * the given class name.
	 * 
	 * @param rrFormatClassName
	 *            The class name for which we want to know whether a runresult
	 *            format has been registered.
	 * @return True, if the runresult format has been registered.
	 */
	public boolean isRunResultFormatRegistered(final String rrFormatClassName) {
		return this.runResultFormatClasses.containsKey(rrFormatClassName)
				|| (this.parent != null && this.parent
						.isRunResultFormatRegistered(rrFormatClassName));
	}

	/**
	 * This method checks whether a run statistic has been registered with the
	 * given class name.
	 * 
	 * @param runStatisticClassName
	 *            The class name for which we want to look up.
	 * @return True, if the run statistic has been registered.
	 */
	public boolean isRunStatisticRegistered(final String runStatisticClassName) {
		return this.runStatisticClasses.containsKey(runStatisticClassName)
				|| (this.parent != null && this.parent
						.isRunStatisticRegistered(runStatisticClassName));
	}

	/**
	 * This method registers instances of a dataset format.
	 * 
	 * @param dataSetFormat
	 *            The dataset format instance to register.
	 * @return True, if the dataset format was registered successfully, false
	 *         otherwise.
	 */
	public boolean register(final DataSetFormat dataSetFormat) {
		this.dataSetFormatInstances.get(
				dataSetFormat.getClass().getSimpleName()).add(dataSetFormat);

		return true;
	}

	/**
	 * This method registers instances of a dataset generator.
	 * 
	 * @param dataSetGenerator
	 *            The dataset generator instance to register.
	 * @return True, if the dataset generator was registered successfully, false
	 *         otherwise.
	 */
	public boolean register(final DataSetGenerator dataSetGenerator) {
		this.dataSetGeneratorInstances.get(
				dataSetGenerator.getClass().getSimpleName()).add(
				dataSetGenerator);

		return true;
	}

	/**
	 * This method registers instances of a parameter optimization method.
	 * 
	 * @param object
	 *            The parameter optimization method instance to register.
	 * @return True, if the parameter optimization method was registered
	 *         successfully, false otherwise.
	 */
	public boolean register(final ParameterOptimizationMethod object) {
		ParameterOptimizationMethod old = this.getRegisteredObject(object);
		if (old != null) {
			return false;
		}

		this.parameterOptimizationMethodInstances.get(
				object.getClass().getSimpleName()).put(object, object);

		return true;
	}

	/**
	 * This method registers instances of a parameter optimization method.
	 * 
	 * @param clusteringQualityMeasure
	 *            The parameter optimization method instance to register.
	 * @return True, if the parameter optimization method was registered
	 *         successfully, false otherwise.
	 */
	public boolean register(
			final ClusteringQualityMeasure clusteringQualityMeasure) {
		this.clusteringQualityMeasureInstances.get(
				clusteringQualityMeasure.getClass().getSimpleName()).add(
				clusteringQualityMeasure);

		return true;
	}

	/**
	 * This method registers instances of a distance measure.
	 * 
	 * @param distanceMeasure
	 *            The distance measure instance to register.
	 * @return True, if the distance measure method was registered successfully,
	 *         false otherwise.
	 */
	public boolean register(final DistanceMeasure distanceMeasure) {
		this.distanceMeasureInstances.get(
				distanceMeasure.getClass().getSimpleName())
				.add(distanceMeasure);

		return true;
	}

	/**
	 * This method registers instances of a data statistic.
	 * 
	 * @param dataStatistic
	 *            The data statistic instance to register.
	 * @return True, if the data statistic method was registered successfully,
	 *         false otherwise.
	 */
	public boolean register(final DataStatistic dataStatistic) {
		this.dataStatisticInstances.get(
				dataStatistic.getClass().getSimpleName()).add(dataStatistic);

		return true;
	}

	/**
	 * This method registers instances of a RProgram.
	 * 
	 * @param rProgram
	 *            The RProgram instance to register.
	 * @return True, if the RProgram was registered successfully, false
	 *         otherwise.
	 * @throws RegisterException
	 */
	public boolean register(final RProgram rProgram) throws RegisterException {
		this.register((Program) rProgram);
		this.rProgramInstances.get(rProgram.getClass().getSimpleName()).add(
				rProgram);

		return true;
	}

	/**
	 * This method registers instances of a run statistic.
	 * 
	 * @param runStatistic
	 *            The run statistic instance to register.
	 * @return True, if the run statistic was registered successfully, false
	 *         otherwise.
	 */
	public boolean register(final RunStatistic runStatistic) {
		this.runStatisticInstances.get(runStatistic.getClass().getSimpleName())
				.add(runStatistic);

		return true;
	}

	/**
	 * This method registers instances of a run data statistic.
	 * 
	 * @param runDataStatistic
	 *            The run data statistic instance to register.
	 * @return True, if the run data statistic was registered successfully,
	 *         false otherwise.
	 */
	public boolean register(final RunDataStatistic runDataStatistic) {
		this.runDataStatisticInstances.get(
				runDataStatistic.getClass().getSimpleName()).add(
				runDataStatistic);

		return true;
	}

	/**
	 * This method registers instances of a run result format.
	 * 
	 * @param runResultFormat
	 *            The run result format instance to register.
	 * @return True, if the run result format was registered successfully, false
	 *         otherwise.
	 */
	public boolean register(final RunResultFormat runResultFormat) {
		this.runResultFormatInstances.get(
				runResultFormat.getClass().getSimpleName())
				.add(runResultFormat);

		return true;
	}

	/**
	 * This method registers instances of a dataset format.
	 * 
	 * @param dataSetType
	 *            The dataset type instance to register.
	 * @return True, if the dataset type was registered successfully, false
	 *         otherwise.
	 */
	public boolean register(final DataSetType dataSetType) {
		this.dataSetTypeInstances.get(dataSetType.getClass().getSimpleName())
				.add(dataSetType);

		return true;
	}

	/**
	 * This method registers a new double program parameter. In case an old
	 * object is already registered that equals the new object, the new object
	 * is not registered.
	 * 
	 * @param object
	 *            The new object to register.
	 * @return True, if the passed object is registered, false otherwise.
	 */
	public boolean register(final DoubleProgramParameter object) {
		if (this.getRegisteredObject(object) != null)
			return false;
		this.doubleProgramParameters.put(object, object);
		this.pathToRepositoryObject.put(object.absPath, object);

		this.sqlCommunicator.register(object);

		return true;
	}

	/**
	 * This method registers a new finder. In case an old object is already
	 * registered that equals the new object, the new object is not registered.
	 * 
	 * @param object
	 *            The new finder to register.
	 * @return True, if the new object has been registered.
	 */
	public boolean register(final Finder object) {
		if (this.getRegisteredObject(object) != null)
			return false;
		this.finder.put(object, object);
		this.pathToRepositoryObject.put(object.absPath, object);
		return true;
	}

	/**
	 * This method registers a new integer program parameter. In case an old
	 * object is already registered, that equals the new object, the new object
	 * is not registered.
	 * 
	 * @param object
	 *            The new object which wants to be registered.
	 * @return True, if the new object has been registered.
	 */
	public boolean register(final IntegerProgramParameter object) {
		if (this.getRegisteredObject(object) != null)
			return false;
		this.integerProgramParameters.put(object, object);
		this.pathToRepositoryObject.put(object.absPath, object);

		this.sqlCommunicator.register(object);

		return true;
	}

	/**
	 * This method registers a new named double attribute. If an old object was
	 * already registered that equals the new object, the new object is not
	 * registered.
	 * 
	 * @param object
	 *            The new object to register.
	 * @return True, if the new object has been registered.
	 */
	public boolean register(final NamedDoubleAttribute object) {
		if (this.getRegisteredObject(object) != null)
			return false;
		this.internalDoubleAttributes.put(object.getName(), object);
		this.pathToRepositoryObject.put(object.absPath, object);
		return true;
	}

	/**
	 * This method registers a new named integer attribute. If an old object was
	 * already registered that equals the new object, the new object is not
	 * registered.
	 * 
	 * @param object
	 *            The new object to register.
	 * @return True, if the new object has been registered.
	 */
	public boolean register(final NamedIntegerAttribute object) {
		if (this.getRegisteredObject(object) != null)
			return false;
		this.internalIntegerAttributes.put(object.getName(), object);
		this.pathToRepositoryObject.put(object.absPath, object);
		return true;
	}

	/**
	 * This method registers a new named string attribute. If an old object was
	 * already registered that equals the new object, the new object is not
	 * registered.
	 * 
	 * @param object
	 *            The new object to register.
	 * @return True, if the new object has been registered.
	 */
	public boolean register(final NamedStringAttribute object) {
		if (this.getRegisteredObject(object) != null)
			return false;
		this.internalStringAttributes.put(object.getName(), object);
		this.pathToRepositoryObject.put(object.absPath, object);
		return true;
	}

	/**
	 * This method registers a new statistic calculator. If an old object was
	 * already registered that equals the new object, the new object is not
	 * registered.
	 * 
	 * @param object
	 *            The new object to register.
	 * @return True, if the new object has been registered.
	 */
	public boolean register(
			final StatisticCalculator<? extends Statistic> object) {
		if (this.getRegisteredObject(object) != null)
			return false;
		this.statisticCalculators.put(object, object);
		this.pathToRepositoryObject.put(object.absPath, object);
		return true;
	}

	/**
	 * This method registers a new string program parameter. If an old object
	 * was already registered that equals the new object, the new object is not
	 * registered.
	 * 
	 * @param object
	 *            The new object to register.
	 * @return True, if the new object has been registered.
	 */
	public boolean register(final StringProgramParameter object) {
		if (this.getRegisteredObject(object) != null)
			return false;
		this.stringProgramParameters.put(object, object);
		this.pathToRepositoryObject.put(object.absPath, object);

		this.sqlCommunicator.register(object);

		return true;
	}

	/**
	 * This method registers a clustering quality measure class. It is only
	 * registered, if it was not before.
	 * 
	 * @param object
	 *            The new class to register.
	 * @return True, if the new class was registered.
	 */
	public boolean registerClusteringQualityMeasureClass(
			final Class<? extends ClusteringQualityMeasure> object) {
		if (this.isClusteringQualityMeasureRegistered(object)) {
			// first remove the old class
			unregisterClusteringQualityMeasureClass(this.clusteringQualityMeasureClasses
					.get(object.getName()));
		}

		this.clusteringQualityMeasureClasses.put(object.getName(), object);

		this.clusteringQualityMeasureInstances
				.put(object.getSimpleName(),
						Collections
								.synchronizedList(new ArrayList<ClusteringQualityMeasure>()));

		if (!ensureClusteringQualityMeasureRLibraries(object))
			return false;

		this.sqlCommunicator.registerClusteringQualityMeasureClass(object);

		return true;
	}

	/**
	 * This method registers a dataset generator class. The class is only
	 * registered, if it was not before.
	 * 
	 * @param object
	 *            The new class to register.
	 * @return True, if the new class was registered.
	 */
	public boolean registerDataSetGeneratorClass(
			final Class<? extends DataSetGenerator> object) {
		if (isDataSetGeneratorRegistered(object)) {
			// first remove the old class
			unregisterDataSetGeneratorClass(this.dataSetGeneratorClasses
					.get(object.getName()));
		}
		this.dataSetGeneratorClasses.put(object.getName(), object);
		this.dataSetGeneratorInstances
				.put(object.getSimpleName(), Collections
						.synchronizedList(new ArrayList<DataSetGenerator>()));

		if (!ensureDataSetGeneratorRLibraries(object))
			return false;

		return true;
	}

	/**
	 * This method assumes, that the class that is passed is currently
	 * registered in this repository.
	 * 
	 * <p>
	 * If the R libraries are not satisfied, the class is removed from the
	 * repository.
	 * 
	 * @param classObject
	 *            The class for which we want to ensure R library dependencies.
	 * @return True, if all R library dependencies are fulfilled.
	 * @throws UnsatisfiedRLibraryException
	 */
	private boolean ensureDataStatisticRLibraries(
			final Class<? extends DataStatistic> classObject) {
		// create an instance
		RLibraryInferior rLibraryInferior;
		try {
			rLibraryInferior = DataStatistic.parseFromString(this,
					classObject.getSimpleName());

			return this.ensureRLibraries(rLibraryInferior);
		} catch (UnknownDataStatisticException e1) {
			e1.printStackTrace();
		}
		this.dataStatisticClasses.remove(classObject.getName());
		return false;
	}

	/**
	 * @return The MyRengine object corresponding to the current thread.
	 * @throws RserveException
	 */
	public MyRengine getRengineForCurrentThread() throws RserveException {
		if (!this.rEngines.containsKey(Thread.currentThread()))
			this.rEngines.put(Thread.currentThread(), new MyRengine(""));
		return this.rEngines.get(Thread.currentThread());
	}

	/**
	 * This method registers a dataset format class. The class is only
	 * registered, if it was not before.
	 * 
	 * @param object
	 *            The new class to register.
	 * @return True, if the new class was registered.
	 */
	public boolean registerDataSetFormatClass(
			final Class<? extends DataSetFormat> object) {
		if (isDataSetFormatRegistered(object)) {
			// first remove the old class
			unregisterDataSetFormatClass(this.dataSetFormatClasses.get(object
					.getName()));
		}
		this.dataSetFormatClasses.put(object.getName(), object);

		this.dataSetFormatInstances.put(object.getSimpleName(),
				Collections.synchronizedList(new ArrayList<DataSetFormat>()));

		this.sqlCommunicator.registerDataSetFormatClass(object);

		return true;
	}

	/**
	 * This method registers a dataset format parser.
	 * 
	 * @param dsFormatParser
	 *            The dataset format parser to register.
	 * @return True, if the dataset format parser replaced an old object.
	 */
	public boolean registerDataSetFormatParser(
			final Class<? extends DataSetFormatParser> dsFormatParser) {
		this.dataSetFormatParser.put(
				dsFormatParser.getName().replace("Parser", ""), dsFormatParser);
		return true;
	}

	/**
	 * This method registers a new dataset type class. It is only registered, if
	 * it was not before.
	 * 
	 * @param object
	 *            The class to register.
	 * @return True, if the class has been registered.
	 */
	public boolean registerDataSetTypeClass(
			final Class<? extends DataSetType> object) {
		if (isDataSetTypeRegistered(object)) {
			// first remove the old class
			unregisterDataSetTypeClass(this.dataSetTypeClasses.get(object
					.getName()));
			// // register the new class
			// this.dataSetTypeClasses.put(object.getName(), object);
			//
			// this.sqlCommunicator.registerDataSetTypeClass(object);
			// return true;
		}
		this.dataSetTypeClasses.put(object.getName(), object);

		this.dataSetTypeInstances.put(object.getSimpleName(),
				Collections.synchronizedList(new ArrayList<DataSetType>()));

		this.sqlCommunicator.registerDataSetTypeClass(object);

		return true;
	}

	/**
	 * This method registers a new data statistic class. It is only registered,
	 * if it was not before.
	 * 
	 * @param object
	 *            The new class to register.
	 * @return True, if the new class has been registered.
	 */
	public boolean registerDataStatisticClass(
			final Class<? extends DataStatistic> object) {
		if (isDataStatisticRegistered(object.getName())) {
			// first remove the old class
			unregisterDataStatisticClass(this.dataStatisticClasses.get(object
					.getName()));

			// // register the new class
			// this.dataStatisticClasses.put(object.getName(), object);
			//
			// if (!ensureDataStatisticRLibraries(object))
			// return false;
			//
			// this.sqlCommunicator.registerDataStatisticClass(object);
			//
			// return true;
		}
		this.dataStatisticClasses.put(object.getName(), object);

		this.dataStatisticInstances.put(object.getSimpleName(),
				Collections.synchronizedList(new ArrayList<DataStatistic>()));

		if (!ensureDataStatisticRLibraries(object))
			return false;

		this.sqlCommunicator.registerDataStatisticClass(object);

		return true;
	}

	/**
	 * This method registers a new data statistic calculator class.
	 * 
	 * @param object
	 *            The new class to register.
	 * @return True, if the new object replaced an old one.
	 */
	public boolean registerDataStatisticCalculator(
			final Class<? extends DataStatisticCalculator<? extends DataStatistic>> object) {
		return this.dataStatisticCalculatorClasses.put(object.getName()
				.replace("Calculator", ""), object) != null;
	}

	/**
	 * This method registers a new distance measure class. It is only
	 * registered, if it was not before.
	 * 
	 * @param object
	 *            The new object to register.
	 * @return True, if the new object has been registered.
	 */
	public boolean registerDistanceMeasureClass(
			final Class<? extends DistanceMeasure> object) {
		if (isDistanceMeasureRegistered(object)) {
			// first remove the old class
			unregisterDistanceMeasureClass(this.distanceMeasureClasses
					.get(object.getName()));

			// // register the new class
			// this.distanceMeasureClasses.put(object.getName(), object);
			//
			// if (!ensureDistanceMeasureLibraries(object))
			// return false;
			//
			// return true;
		}
		this.distanceMeasureClasses.put(object.getName(), object);

		this.distanceMeasureInstances.put(object.getSimpleName(),
				Collections.synchronizedList(new ArrayList<DistanceMeasure>()));

		if (!ensureDistanceMeasureLibraries(object))
			return false;

		this.log.info("New Distance Measure Class registered: "
				+ object.getSimpleName());

		return true;
	}

	/**
	 * This method registers a new parameter optimization method class. It is
	 * only registered, if it was not before.
	 * 
	 * @param object
	 *            The new class to register.
	 * @return True, if the new class has been registered.
	 */
	public boolean registerParameterOptimizationMethodClass(
			final Class<? extends ParameterOptimizationMethod> object) {
		if (isParameterOptimizationMethodRegistered(object.getName())) {
			// first remove the old class
			unregisterParameterOptimizationMethodClass(this.parameterOptimizationMethodClasses
					.get(object.getName()));
			// // register the new class
			// this.parameterOptimizationMethodClasses.put(object.getName(),
			// object);
			// return true;
		}
		this.parameterOptimizationMethodClasses.put(object.getName(), object);

		this.parameterOptimizationMethodInstances
				.put(object.getSimpleName(),
						new ConcurrentHashMap<ParameterOptimizationMethod, ParameterOptimizationMethod>());

		this.log.info("New Parameter Optimization Method Class registered: "
				+ object.getSimpleName());

		this.sqlCommunicator.registerParameterOptimizationMethodClass(object);

		return true;
	}

	/**
	 * This method registers a new RProgram class. It is only registered, if it
	 * was not before.
	 * 
	 * @param object
	 *            The new class to register.
	 * @return True, if the new class has been registered.
	 */
	public boolean registerRProgramClass(final Class<? extends RProgram> object) {
		if (isRProgramRegistered(object.getName())) {
			// first remove old class
			unregisterRProgramClass(this.rProgramClasses.get(object.getName()));
			// // register the new class
			// this.rProgramClasses.put(object.getName(), object);
			//
			// if (!ensureRProgramRLibraries(object))
			// return false;
			//
			// return true;
		}
		this.rProgramClasses.put(object.getName(), object);

		this.rProgramInstances.put(object.getSimpleName(),
				Collections.synchronizedList(new ArrayList<RProgram>()));

		if (!ensureRProgramRLibraries(object))
			return false;

		this.log.info("New RProgram Class registered: "
				+ object.getSimpleName());

		try {
			// registers the program
			object.getConstructor(Repository.class).newInstance(this);
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

		return true;
	}

	/**
	 * This method registers a new run-data statistic class. It is only
	 * registered, if it was not before.
	 * 
	 * @param object
	 *            The new class to register.
	 * @return True, if the new class has been registered.
	 */
	public boolean registerRunDataStatisticClass(
			final Class<? extends RunDataStatistic> object) {
		if (isRunDataStatisticRegistered(object.getName())) {
			// remove the old class
			unregisterRunDataStatisticClass(this.runDataStatisticClasses
					.get(object.getName()));
			// // register the new class
			// this.runDataStatisticClasses.put(object.getName(), object);
			//
			// if (!ensureRunDataStatisticRLibraries(object))
			// return false;
			//
			// return true;
		}
		this.runDataStatisticClasses.put(object.getName(), object);

		this.runDataStatisticInstances
				.put(object.getSimpleName(), Collections
						.synchronizedList(new ArrayList<RunDataStatistic>()));

		if (!ensureRunDataStatisticRLibraries(object))
			return false;

		this.sqlCommunicator.registerRunDataStatisticClass(object);

		return true;
	}

	/**
	 * This method registers a new run-data statistic calculator class.
	 * 
	 * @param object
	 *            The new class to register.
	 * @return True, if the new class replaced an old one.
	 */
	public boolean registerRunDataStatisticCalculator(
			final Class<? extends RunDataStatisticCalculator<? extends RunDataStatistic>> object) {
		return this.runDataStatisticCalculatorClasses.put(object.getName()
				.replace("Calculator", ""), object) != null;
	}

	/**
	 * This method registers a new runresult format class. If an old object was
	 * already registered that equals the new object, the new object is not
	 * registered.
	 * 
	 * @param object
	 *            The new object to register.
	 * @return True, if the new object has been registered.
	 */
	public boolean registerRunResultFormatClass(
			final Class<? extends RunResultFormat> object) {
		if (isRunResultFormatRegistered(object)) {
			// first remove the old class
			unregisterRunResultFormatClass(this.runResultFormatClasses
					.get(object.getName()));

			// // unregister the new class
			// this.runResultFormatClasses.put(object.getName(), object);
			// return true;
		}
		this.runResultFormatClasses.put(object.getName(), object);

		this.runResultFormatInstances.put(object.getSimpleName(),
				Collections.synchronizedList(new ArrayList<RunResultFormat>()));

		this.sqlCommunicator.registerRunResultFormatClass(object);

		return true;
	}

	/**
	 * This method registers a new runresult format parser class.
	 * 
	 * @param runResultFormatParser
	 *            The new class to register.
	 * @return True, if the new class replaced an old one.
	 */
	public boolean registerRunResultFormatParser(
			final Class<? extends RunResultFormatParser> runResultFormatParser) {
		this.runResultFormatParser.put(
				runResultFormatParser.getName().replace("Parser", ""),
				runResultFormatParser);
		return true;
	}

	/**
	 * This method registers a new run statistic class. It is only registered,
	 * if it was not before.
	 * 
	 * @param object
	 *            The new class to register.
	 * @return True, if the new class has been registered.
	 */
	public boolean registerRunStatisticClass(
			final Class<? extends RunStatistic> object) {
		if (isRunStatisticRegistered(object.getName())) {
			// first remove the old class
			unregisterRunStatisticClass(this.runStatisticClasses.get(object
					.getName()));
			// // we only get here, if the object changed, that is there is
			// // a newer jar file on the filesystem.
			// // The passed class is from the newer jar file.
			// this.runStatisticClasses.put(object.getName(), object);
			//
			// if (!ensureRunStatisticRLibraries(object))
			// return false;
			//
			// return true;
		}
		this.runStatisticClasses.put(object.getName(), object);

		this.runStatisticInstances.put(object.getSimpleName(),
				Collections.synchronizedList(new ArrayList<RunStatistic>()));

		if (!ensureRunStatisticRLibraries(object))
			return false;

		this.sqlCommunicator.registerRunStatisticClass(object);

		return true;
	}

	/**
	 * This method registers a new run statistic calculator.
	 * 
	 * @param object
	 *            The new class to register.
	 * @return True, if the new class replaced an old one.
	 */
	public boolean registerRunStatisticCalculator(
			final Class<? extends RunStatisticCalculator<? extends RunStatistic>> object) {
		return this.runStatisticCalculatorClasses.put(
				object.getName().replace("Calculator", ""), object) != null;
	}

	/**
	 * This method sets the clustering quality measures as initialized. It
	 * should only be invoked by
	 * {@link ClusteringQualityMeasureFinderThread#afterFind()}.
	 */
	public void setClusteringQualityMeasuresInitialized() {
		this.clusteringQualityMeasuresInitialized = true;
	}

	/**
	 * This method sets the dataset formats as initialized. It should only be
	 * invoked by {@link DataSetFormatFinderThread#afterFind()}.
	 */
	public void setDataSetFormatsInitialized() {
		this.dataSetFormatsInitialized = true;
	}

	/**
	 * This method sets the dataset generators as initialized. It should only be
	 * invoked by {@link DataSetGeneratorFinderThread#afterFind()}.
	 */
	public void setDataSetGeneratorsInitialized() {
		this.dataSetGeneratorsInitialized = true;
	}

	/**
	 * This method sets the dataset types as initialized. It should only be
	 * invoked by {@link DataSetTypeFinderThread#afterFind()}.
	 */
	public void setDataSetTypesInitialized() {
		this.dataSetTypesInitialized = true;
	}

	/**
	 * This method sets the data statistics as initialized. It should only be
	 * invoked by {@link DataStatisticFinderThread#afterFind()}.
	 */
	public void setDataStatisticsInitialized() {
		this.dataStatisticsInitialized = true;
	}

	/**
	 * This method sets the distance measures as initialized. It should only be
	 * invoked by {@link DistanceMeasureFinderThread#afterFind()}.
	 */
	public void setDistanceMeasuresInitialized() {
		this.distanceMeasuresInitialized = true;
	}

	/**
	 * This method sets the parameter optimization methods as initialized. It
	 * should only be invoked by
	 * {@link ParameterOptimizationMethodFinderThread#afterFind()}.
	 */
	public void setParameterOptimizationMethodsInitialized() {
		this.parameterOptimizationMethodsInitialized = true;
	}

	/**
	 * This method sets the RPrograms as initialized. It should only be invoked
	 * by {@link RProgramFinderThread#afterFind()}.
	 */
	public void setRProgramsInitialized() {
		this.rProgramsInitialized = true;
	}

	/**
	 * This method sets the run-data statistics as initialized. It should only
	 * be invoked by {@link RunDataStatisticFinderThread#afterFind()}.
	 */
	public void setRunDataStatisticsInitialized() {
		this.runDataStatisticsInitialized = true;
	}

	/**
	 * This method sets the run result formats as initialized. It should only be
	 * invoked by {@link RunResultFormatFinderThread#afterFind()}.
	 */
	public void setRunResultFormatsInitialized() {
		this.runResultFormatsInitialized = true;
	}

	/**
	 * This method sets the run statistics as initialized. It should only be
	 * invoked by {@link RunStatisticFinderThread#afterFind()}.
	 */
	public void setRunStatisticsInitialized() {
		this.runStatisticsInitialized = true;
	}

	/**
	 * @param comm
	 *            The new sql communicator.
	 */
	public void setSQLCommunicator(final SQLCommunicator comm) {
		this.sqlCommunicator = comm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.basePath;
	}

	/**
	 * @param dataSetFormat
	 *            The dataset format to unregister.
	 * @return True, if the dataset format has been unregistered successfully.
	 */
	public boolean unregister(final DataSetFormat dataSetFormat) {
		boolean result = this.dataSetFormatInstances.get(
				dataSetFormat.getClass().getSimpleName()).remove(dataSetFormat);
		if (result) {
			try {
				dataSetFormat.notify(new RepositoryRemoveEvent(dataSetFormat));
			} catch (RegisterException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @param dataSetGenerator
	 *            The dataset generator to unregister.
	 * @return True, if the dataset generator has been unregistered
	 *         successfully.
	 */
	public boolean unregister(final DataSetGenerator dataSetGenerator) {
		boolean result = this.dataSetGeneratorInstances.get(
				dataSetGenerator.getClass().getSimpleName()).remove(
				dataSetGenerator);
		if (result) {
			try {
				dataSetGenerator.notify(new RepositoryRemoveEvent(
						dataSetGenerator));
			} catch (RegisterException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @param paramOptMethod
	 *            The parameter optimization method to unregister.
	 * @return True, if the parameter optimization method has been unregistered
	 *         successfully.
	 */
	public boolean unregister(final ParameterOptimizationMethod paramOptMethod) {
		boolean result = this.parameterOptimizationMethodInstances.get(
				paramOptMethod.getClass().getSimpleName()).remove(
				paramOptMethod) != null;
		if (result) {
			try {
				paramOptMethod
						.notify(new RepositoryRemoveEvent(paramOptMethod));
			} catch (RegisterException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @param clusteringQualityMeasure
	 *            The clustering quality measure to unregister.
	 * @return True, if the clustering quality measure has been unregistered
	 *         successfully.
	 */
	public boolean unregister(
			final ClusteringQualityMeasure clusteringQualityMeasure) {
		boolean result = this.clusteringQualityMeasureInstances.get(
				clusteringQualityMeasure.getClass().getSimpleName()).remove(
				clusteringQualityMeasure);
		if (result) {
			try {
				clusteringQualityMeasure.notify(new RepositoryRemoveEvent(
						clusteringQualityMeasure));
			} catch (RegisterException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @param distanceMeasure
	 *            The distance measure to unregister.
	 * @return True, if the distance measure has been unregistered successfully.
	 */
	public boolean unregister(final DistanceMeasure distanceMeasure) {
		boolean result = this.distanceMeasureInstances.get(
				distanceMeasure.getClass().getSimpleName()).remove(
				distanceMeasure);
		if (result) {
			try {
				distanceMeasure.notify(new RepositoryRemoveEvent(
						distanceMeasure));
			} catch (RegisterException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @param dataStatistic
	 *            The data statistic to unregister.
	 * @return True, if the data statistic has been unregistered successfully.
	 */
	public boolean unregister(final DataStatistic dataStatistic) {
		boolean result = this.dataStatisticInstances.get(
				dataStatistic.getClass().getSimpleName()).remove(dataStatistic);
		if (result) {
			try {
				dataStatistic.notify(new RepositoryRemoveEvent(dataStatistic));
			} catch (RegisterException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @param rProgram
	 *            The RProgram to unregister.
	 * @return True, if the RProgram has been unregistered successfully.
	 */
	public boolean unregister(final RProgram rProgram) {
		this.unregister((Program) rProgram);
		boolean result = this.rProgramInstances.get(
				rProgram.getClass().getSimpleName()).remove(rProgram);
		if (result) {
			try {
				rProgram.notify(new RepositoryRemoveEvent(rProgram));
			} catch (RegisterException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @param runStatistic
	 *            The run statistic to unregister.
	 * @return True, if the run statistic has been unregistered successfully.
	 */
	public boolean unregister(final RunStatistic runStatistic) {
		boolean result = this.runStatisticInstances.get(
				runStatistic.getClass().getSimpleName()).remove(runStatistic);
		if (result) {
			try {
				runStatistic.notify(new RepositoryRemoveEvent(runStatistic));
			} catch (RegisterException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @param runDataStatistic
	 *            The run data statistic to unregister.
	 * @return True, if the run data statistic has been unregistered
	 *         successfully.
	 */
	public boolean unregister(final RunDataStatistic runDataStatistic) {
		boolean result = this.runDataStatisticInstances.get(
				runDataStatistic.getClass().getSimpleName()).remove(
				runDataStatistic);
		if (result) {
			try {
				runDataStatistic.notify(new RepositoryRemoveEvent(
						runDataStatistic));
			} catch (RegisterException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @param runResultFormat
	 *            The run result format to unregister.
	 * @return True, if the run result format has been unregistered
	 *         successfully.
	 */
	public boolean unregister(final RunResultFormat runResultFormat) {
		boolean result = this.runResultFormatInstances.get(
				runResultFormat.getClass().getSimpleName()).remove(
				runResultFormat);
		if (result) {
			try {
				runResultFormat.notify(new RepositoryRemoveEvent(
						runResultFormat));
			} catch (RegisterException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @param dataSetType
	 *            The dataset format to unregister.
	 * @return True, if the dataset format has been unregistered successfully.
	 */
	public boolean unregister(final DataSetType dataSetType) {
		boolean result = this.dataSetTypeInstances.get(
				dataSetType.getClass().getSimpleName()).remove(dataSetType);
		if (result) {
			try {
				dataSetType.notify(new RepositoryRemoveEvent(dataSetType));
			} catch (RegisterException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregister(DoubleProgramParameter object) {
		boolean result = this.doubleProgramParameters.remove(object) != null;

		if (result) {
			this.sqlCommunicator.unregister(object);
		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregister(Finder object) {
		return this.finder.remove(object) != null;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregister(IntegerProgramParameter object) {
		boolean result = this.integerProgramParameters.remove(object) != null;

		if (result) {
			this.sqlCommunicator.unregister(object);
		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregister(NamedDoubleAttribute object) {
		return this.internalDoubleAttributes.remove(object) != null;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregister(NamedIntegerAttribute object) {
		return this.internalIntegerAttributes.remove(object) != null;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregister(NamedStringAttribute object) {
		return this.internalStringAttributes.remove(object) != null;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregister(final RunResultFormatFinder object) {
		return this.finder.remove(object) != null;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregister(
			final StatisticCalculator<? extends Statistic> object) {
		return this.statisticCalculators.remove(object) != null;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregister(StringProgramParameter object) {
		boolean result = this.stringProgramParameters.remove(object) != null;
		if (result) {

			this.sqlCommunicator.unregister(object);
		}

		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregisterDataSetFormatClass(
			final Class<? extends DataSetFormat> object) {
		boolean result = this.dataSetFormatClasses.remove(object.getName()) != null;
		if (result) {
			this.info("DataSetFormat removed: " + object.getSimpleName());
			// we inform all existing datasets about the new class. that
			// means those objects are deleted such that new instances instances
			// can be created using the new class.
			for (DataSetFormat dataSetFormat : Collections
					.synchronizedList(new ArrayList<DataSetFormat>(
							dataSetFormatInstances.get(object.getSimpleName())))) {
				dataSetFormat.unregister();
			}

			this.sqlCommunicator.unregisterDataSetFormatClass(object);
		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregisterDataSetGeneratorClass(
			final Class<? extends DataSetGenerator> object) {
		boolean result = this.dataSetGeneratorClasses.remove(object.getName()) != null;
		if (result) {
			this.info("DataSetGenerator removed: " + object.getSimpleName());
			for (DataSetGenerator dataSetGenerator : Collections
					.synchronizedList(new ArrayList<DataSetGenerator>(
							dataSetGeneratorInstances.get(object
									.getSimpleName())))) {
				dataSetGenerator.unregister();
			}

		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregisterDataSetTypeClass(
			final Class<? extends DataSetType> object) {
		boolean result = this.dataSetTypeClasses.remove(object.getName()) != null;
		if (result) {
			this.info("DataSetType class removed: " + object.getSimpleName());
			// we inform all listeners about the new class. that
			// means those objects are deleted such that new instances instances
			// can be created using the new class.
			for (DataSetType dataSetType : Collections
					.synchronizedList(new ArrayList<DataSetType>(
							dataSetTypeInstances.get(object.getSimpleName())))) {
				dataSetType.unregister();
			}

			this.sqlCommunicator.unregisterDataSetTypeClass(object);
		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregisterParameterOptimizationMethodClass(
			final Class<? extends ParameterOptimizationMethod> object) {
		boolean result = this.parameterOptimizationMethodClasses.remove(object
				.getName()) != null;
		if (result) {
			this.info("ParameterOptimizationMethod class removed: "
					+ object.getSimpleName());
			// we inform all listeners about the new class. that
			// means those objects are deleted such that new instances instances
			// can be created using the new class.
			for (ParameterOptimizationMethod paramOptMethod : new ConcurrentHashMap<ParameterOptimizationMethod, ParameterOptimizationMethod>(
					parameterOptimizationMethodInstances.get(object
							.getSimpleName())).values()) {
				paramOptMethod.unregister();
			}

			this.sqlCommunicator
					.unregisterParameterOptimizationMethodClass(object);
		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregisterDistanceMeasureClass(
			final Class<? extends DistanceMeasure> object) {
		boolean result = this.distanceMeasureClasses.remove(object.getName()) != null;
		if (result) {
			this.info("DistanceMeasure class removed: "
					+ object.getSimpleName());
			// we inform all listeners about the new class. that
			// means those objects are deleted such that new instances instances
			// can be created using the new class.
			for (DistanceMeasure distanceMeasure : Collections
					.synchronizedList(new ArrayList<DistanceMeasure>(
							distanceMeasureInstances.get(object.getSimpleName())))) {
				distanceMeasure.unregister();
			}
		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregisterRunStatisticClass(
			final Class<? extends RunStatistic> object) {
		boolean result = this.runStatisticClasses.remove(object.getName()) != null;
		if (result) {
			this.info("RunStatistic class removed: " + object.getSimpleName());
			// we inform all listeners about the new class. that
			// means those objects are deleted such that new instances instances
			// can be created using the new class.
			for (RunStatistic runStatistic : Collections
					.synchronizedList(new ArrayList<RunStatistic>(
							runStatisticInstances.get(object.getSimpleName())))) {
				runStatistic.unregister();
			}

			this.sqlCommunicator.unregisterRunStatisticClass(object);
		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregisterRunDataStatisticClass(
			final Class<? extends RunDataStatistic> object) {
		boolean result = this.runDataStatisticClasses.remove(object.getName()) != null;
		if (result) {
			this.info("RunDataStatistic class removed: "
					+ object.getSimpleName());
			// we inform all listeners about the new class. that
			// means those objects are deleted such that new instances instances
			// can be created using the new class.
			for (RunDataStatistic runDataStatistic : Collections
					.synchronizedList(new ArrayList<RunDataStatistic>(
							runDataStatisticInstances.get(object
									.getSimpleName())))) {
				runDataStatistic.unregister();
			}

			this.sqlCommunicator.unregisterRunDataStatisticClass(object);
		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregisterRProgramClass(
			final Class<? extends RProgram> object) {
		boolean result = this.rProgramClasses.remove(object.getName()) != null;
		if (result) {
			this.info("RProgram class removed: " + object.getSimpleName());
			// we inform all listeners about the new class. that
			// means those objects are deleted such that new instances instances
			// can be created using the new class.
			for (RProgram rProgram : Collections
					.synchronizedList(new ArrayList<RProgram>(rProgramInstances
							.get(object.getSimpleName())))) {
				rProgram.unregister();
			}
		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregisterDataStatisticClass(
			final Class<? extends DataStatistic> object) {
		boolean result = this.dataStatisticClasses.remove(object.getName()) != null;
		if (result) {
			this.info("DataStatistic class removed: " + object.getSimpleName());
			// we inform all listeners about the new class. that
			// means those objects are deleted such that new instances instances
			// can be created using the new class.
			for (DataStatistic dataStatistic : Collections
					.synchronizedList(new ArrayList<DataStatistic>(
							dataStatisticInstances.get(object.getSimpleName())))) {
				dataStatistic.unregister();
			}

			this.sqlCommunicator.unregisterDataStatisticClass(object);
		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregisterClusteringQualityMeasureClass(
			final Class<? extends ClusteringQualityMeasure> object) {
		boolean result = this.clusteringQualityMeasureClasses.remove(object
				.getName()) != null;
		if (result) {
			this.info("ClusteringQualityMeasure class removed: "
					+ object.getSimpleName());
			// we inform all listeners about the new class. that
			// means those objects are deleted such that new instances instances
			// can be created using the new class.
			for (ClusteringQualityMeasure clusteringQualityMeasure : Collections
					.synchronizedList(new ArrayList<ClusteringQualityMeasure>(
							clusteringQualityMeasureInstances.get(object
									.getSimpleName())))) {
				clusteringQualityMeasure.unregister();
			}

			this.sqlCommunicator
					.unregisterClusteringQualityMeasureClass(object);
		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregisterRunResultFormatClass(
			final Class<? extends RunResultFormat> object) {
		boolean result = this.runResultFormatClasses.remove(object.getName()) != null;
		if (result) {
			this.info("RunResultFormat class removed: " + object);
			// we inform all listeners about the new class. that
			// means those objects are deleted such that new instances instances
			// can be created using the new class.
			for (RunResultFormat runResultFormat : Collections
					.synchronizedList(new ArrayList<RunResultFormat>(
							runResultFormatInstances.get(object.getSimpleName())))) {
				runResultFormat.unregister();
			}

			this.sqlCommunicator.unregisterRunResultFormat(object);
		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregisterRunResultFormatParser(
			final Class<? extends RunResultFormatParser> object) {
		return this.runResultFormatParser.remove(object.getName().replace(
				"Parser", "")) != null;
	}

	/**
	 * This method is invoked by
	 * {@link Run#setStatus(de.clusteval.run.RUN_STATUS)} and ensures that the
	 * new status is passed to the whole framework, e.g. the frontend database.
	 * 
	 * @param run
	 *            The run which changed its status.
	 * @param newStatus
	 *            The new status of the run.
	 * @return True, if the propagation of the new status was successful.
	 */
	public boolean updateStatusOfRun(final Run run, final String newStatus) {
		return this.sqlCommunicator.updateStatusOfRun(run, newStatus);
	}

	/**
	 * A helper method for logging, which can overwritten to change the
	 * logger-level in subclasses of this class. For example in
	 * RunResultRepostories we do not want to log everything, therefore we
	 * change the log level to debug.
	 * 
	 * @param The
	 *            message to log.
	 */
	protected void warn(final String message) {
		this.log.warn(message);
	}

	/**
	 * This method checks whether the given dataset generator class is
	 * registered in this repository.
	 * 
	 * @param dsGenerator
	 *            The class of the dataset generator to look up.
	 * @return True, if the dataset generator class was registered.
	 */
	public boolean isDataSetGeneratorRegistered(
			final Class<? extends DataSetGenerator> dsGenerator) {
		return this.dataSetGeneratorClasses.containsKey(dsGenerator.getName())
				|| (this.parent != null && this.parent
						.isDataSetGeneratorRegistered(dsGenerator));
	}

	/**
	 * This method checks whether a dataset generator with the given class name
	 * is registered in this repository.
	 * 
	 * @param dsGeneratorClassName
	 *            The class name of the dataset generator to look up.
	 * @return True, if the dataset format class was registered.
	 */
	public boolean isDataSetGeneratorRegistered(
			final String dsGeneratorClassName) {
		return this.dataSetGeneratorClasses.containsKey(dsGeneratorClassName)
				|| (this.parent != null && this.parent
						.isDataSetGeneratorRegistered(dsGeneratorClassName));
	}

	private boolean ensureRLibraries(final RLibraryInferior rLibraryInferior) {
		if (rLibraryInferior.getRequiredRlibraries().isEmpty())
			return true;
		// ensure that all R libraries are available
		MyRengine rEngine;
		try {
			rEngine = this.getRengineForCurrentThread();

			if (rLibraryInferior.getRequiredRlibraries().isEmpty())
				return true;
			// ensure that all R libraries are available
			for (String libName : rLibraryInferior.getRequiredRlibraries())
				try {
					rEngine.loadLibrary(libName, rLibraryInferior.getClass()
							.getSimpleName());
					// first we clear the old exceptions for this
					// class
					this.clearMissingRLibraries(rLibraryInferior.getClass()
							.getName());
				} catch (RLibraryNotLoadedException e) {
					if (this.addMissingRLibraryException(e))
						this.warn("\""
								+ rLibraryInferior.getClass().getSimpleName()
								+ "\" could not be loaded due to an unsatisfied R library dependency: "
								+ libName);
				}
			return true;
		} catch (RserveException e) {
			if (this.addMissingRLibraryException(new RLibraryNotLoadedException(
					rLibraryInferior.getClass().getName(), "R")))
				this.warn("\""
						+ rLibraryInferior.getClass().getSimpleName()
						+ "\" could not be loaded since it requires R and no connection could be established.");
		}
		return true;
	}

	/**
	 * This method assumes, that the class that is passed is currently
	 * registered in this repository.
	 * 
	 * <p>
	 * If the R libraries are not satisfied, the class is removed from the
	 * repository.
	 * 
	 * @param classObject
	 *            The class for which we want to ensure R library dependencies.
	 * @return True, if all R library dependencies are fulfilled.
	 * @throws UnsatisfiedRLibraryException
	 */
	private boolean ensureDataSetGeneratorRLibraries(
			final Class<? extends DataSetGenerator> classObject) {
		// create an instance
		RLibraryInferior rLibraryInferior;
		try {
			rLibraryInferior = DataSetGenerator.parseFromString(this,
					classObject.getSimpleName());

			return this.ensureRLibraries(rLibraryInferior);
		} catch (UnknownDataSetGeneratorException e1) {
			e1.printStackTrace();
		}
		this.dataSetGeneratorClasses.remove(classObject.getName());
		return false;
	}

	/**
	 * This method assumes, that the class that is passed is currently
	 * registered in this repository.
	 * 
	 * <p>
	 * If the R libraries are not satisfied, the class is removed from the
	 * repository.
	 * 
	 * @param classObject
	 *            The class for which we want to ensure R library dependencies.
	 * @return True, if all R library dependencies are fulfilled.
	 * @throws UnsatisfiedRLibraryException
	 */
	private boolean ensureDataPreprocessorRLibraries(
			final Class<? extends DataPreprocessor> classObject) {
		// create an instance
		RLibraryInferior object;
		try {
			object = DataPreprocessor.parseFromString(this,
					classObject.getSimpleName());
			return this.ensureRLibraries(object);
		} catch (UnknownDataPreprocessorException e1) {
			e1.printStackTrace();
		}
		this.dataPreprocessorClasses.remove(classObject.getName());
		return false;
	}

	/**
	 * This method assumes, that the class that is passed is currently
	 * registered in this repository.
	 * 
	 * <p>
	 * If the R libraries are not satisfied, the class is removed from the
	 * repository.
	 * 
	 * @param classObject
	 *            The class for which we want to ensure R library dependencies.
	 * @return True, if all R library dependencies are fulfilled.
	 * @throws UnsatisfiedRLibraryException
	 */
	private boolean ensureRProgramRLibraries(
			final Class<? extends RProgram> classObject) {
		try {
			// check whether we have R available
			this.getRengineForCurrentThread();
			try {
				// create an instance
				RLibraryInferior rLibraryInferior = RProgram.parseFromString(
						this, classObject.getSimpleName());

				return this.ensureRLibraries(rLibraryInferior);
			} catch (UnknownRProgramException e1) {
				e1.printStackTrace();
			}
		} catch (RserveException e) {
			this.warn("\""
					+ classObject.getSimpleName()
					+ "\" could not be loaded since it requires R and no connection could be established.");
		}
		this.rProgramClasses.remove(classObject.getName());
		return false;
	}

	/**
	 * This method assumes, that the class that is passed is currently
	 * registered in this repository.
	 * 
	 * <p>
	 * If the R libraries are not satisfied, the class is removed from the
	 * repository.
	 * 
	 * @param classObject
	 *            The class for which we want to ensure R library dependencies.
	 * @return True, if all R library dependencies are fulfilled.
	 * @throws UnsatisfiedRLibraryException
	 */
	private boolean ensureClusteringQualityMeasureRLibraries(
			final Class<? extends ClusteringQualityMeasure> classObject) {
		// create an instance
		RLibraryInferior rLibraryInferior;
		try {
			rLibraryInferior = ClusteringQualityMeasure.parseFromString(this,
					classObject.getSimpleName());

			return this.ensureRLibraries(rLibraryInferior);
		} catch (UnknownClusteringQualityMeasureException e1) {
			e1.printStackTrace();
		}
		this.clusteringQualityMeasureClasses.remove(classObject.getName());
		return false;
	}

	/**
	 * This method assumes, that the class that is passed is currently
	 * registered in this repository.
	 * 
	 * <p>
	 * If the R libraries are not satisfied, the class is removed from the
	 * repository.
	 * 
	 * @param classObject
	 *            The class for which we want to ensure R library dependencies.
	 * @return True, if all R library dependencies are fulfilled.
	 * @throws UnsatisfiedRLibraryException
	 */
	private boolean ensureDistanceMeasureLibraries(
			final Class<? extends DistanceMeasure> classObject) {
		// create an instance
		RLibraryInferior rLibraryInferior;
		try {
			rLibraryInferior = DistanceMeasure.parseFromString(this,
					classObject.getSimpleName());

			return this.ensureRLibraries(rLibraryInferior);
		} catch (UnknownDistanceMeasureException e1) {
			e1.printStackTrace();
		}
		this.distanceMeasureClasses.remove(classObject.getName());
		return false;
	}

	/**
	 * This method assumes, that the class that is passed is currently
	 * registered in this repository.
	 * 
	 * <p>
	 * If the R libraries are not satisfied, the class is removed from the
	 * repository.
	 * 
	 * @param classObject
	 *            The class for which we want to ensure R library dependencies.
	 * @return True, if all R library dependencies are fulfilled.
	 * @throws UnsatisfiedRLibraryException
	 */
	private boolean ensureRunDataStatisticRLibraries(
			final Class<? extends RunDataStatistic> classObject) {
		try {
			RLibraryInferior rLibraryInferior = RunDataStatistic
					.parseFromString(this, classObject.getSimpleName());

			return this.ensureRLibraries(rLibraryInferior);
		} catch (UnknownRunDataStatisticException e1) {
			e1.printStackTrace();
		}
		this.runDataStatisticClasses.remove(classObject.getName());
		return false;
	}

	/**
	 * This method assumes, that the class that is passed is currently
	 * registered in this repository.
	 * 
	 * <p>
	 * If the R libraries are not satisfied, the class is removed from the
	 * repository.
	 * 
	 * @param classObject
	 *            The class for which we want to ensure R library dependencies.
	 * @return True, if all R library dependencies are fulfilled.
	 * @throws UnsatisfiedRLibraryException
	 */
	private boolean ensureRunStatisticRLibraries(
			final Class<? extends RunStatistic> classObject) {
		try {
			RLibraryInferior rLibraryInferior = RunStatistic.parseFromString(
					this, classObject.getSimpleName());

			return this.ensureRLibraries(rLibraryInferior);
		} catch (UnknownRunStatisticException e1) {
			e1.printStackTrace();
		}
		this.runStatisticClasses.remove(classObject.getName());
		return false;
	}

	/**
	 * This method sets the data preprocessors as initialized. It should only be
	 * invoked by {@link DataPreprocessorFinderThread#afterFind()}.
	 */
	public void setDataPreprocessorsInitialized() {
		this.dataPreprocessorsInitialized = true;
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all data preprocessors are stored.
	 */
	public String getDataPreprocessorBasePath() {
		return this.dataPreprocessorBasePath;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the data
	 * preprocessor with the given name.
	 * 
	 * @param dataPreprocessorClassName
	 *            The name of the class of the clustering quality measure.
	 * @return The clustering quality measure class with the given name or null,
	 *         if it does not exist.
	 */
	public Class<? extends DataPreprocessor> getDataPreprocessorClass(
			final String dataPreprocessorClassName) {
		Class<? extends DataPreprocessor> result = this.dataPreprocessorClasses
				.get(dataPreprocessorClassName);
		if (result == null && parent != null)
			return parent.getDataPreprocessorClass(dataPreprocessorClassName);
		return result;
	}

	/**
	 * 
	 * @return The set of all registered data preprocessor classes.
	 */
	public Collection<Class<? extends DataPreprocessor>> getDataPreprocessorClasses() {
		return this.dataPreprocessorClasses.values();
	}

	/**
	 * @return A boolean attribute indicating whether the data preprocessors
	 *         have been initialized by the {@link DataPreprocessorFinderThread}
	 *         .
	 */
	public boolean getDataPreprocessorsInitialized() {
		return this.dataPreprocessorsInitialized;
	}

	/**
	 * This method checks whether the given data preprocessor class is
	 * registered in this repository.
	 * 
	 * @param dataPreprocessor
	 *            The class of the data preprocessor to look up.
	 * @return True, if the data preprocessor class was registered.
	 */
	public boolean isDataPreprocessorRegistered(
			final Class<? extends DataPreprocessor> dataPreprocessor) {
		return this.dataPreprocessorClasses.containsKey(dataPreprocessor
				.getName())
				|| (this.parent != null && this.parent
						.isDataPreprocessorRegistered(dataPreprocessor));
	}

	/**
	 * This method checks whether a data preprocessor with the given class name
	 * is registered in this repository.
	 * 
	 * @param dataPreprocessorClassName
	 *            The class name of the data preprocessor to look up.
	 * @return True, if the data preprocessor class was registered.
	 */
	public boolean isDataPreprocessorRegistered(
			final String dataPreprocessorClassName) {
		return this.dataPreprocessorClasses
				.containsKey(dataPreprocessorClassName)
				|| (this.parent != null && this.parent
						.isDataPreprocessorRegistered(dataPreprocessorClassName));
	}

	/**
	 * This method registers instances of a dataset generator.
	 * 
	 * @param dataPreprocessor
	 *            The data preprocessor instance to register.
	 * @return True, if the data preprocessor was registered successfully, false
	 *         otherwise.
	 */
	public boolean register(final DataPreprocessor dataPreprocessor) {
		this.dataPreprocessorInstances.get(
				dataPreprocessor.getClass().getSimpleName()).add(
				dataPreprocessor);

		return true;
	}

	/**
	 * This method registers a data preprocessor class. The class is only
	 * registered, if it was not before.
	 * 
	 * @param object
	 *            The new class to register.
	 * @return True, if the new class was registered.
	 */
	public boolean registerDataPreprocessorClass(
			final Class<? extends DataPreprocessor> object) {
		if (isDataPreprocessorRegistered(object)) {
			// first remove the old class
			unregisterDataPreprocessorClass(this.dataPreprocessorClasses
					.get(object.getName()));
		}
		this.dataPreprocessorClasses.put(object.getName(), object);
		this.dataPreprocessorInstances
				.put(object.getSimpleName(), Collections
						.synchronizedList(new ArrayList<DataPreprocessor>()));

		if (!ensureDataPreprocessorRLibraries(object))
			return false;

		return true;
	}

	/**
	 * @param dataPreprocessor
	 *            The data preprocessor to unregister.
	 * @return True, if the data preprocessor has been unregistered
	 *         successfully.
	 */
	public boolean unregister(final DataPreprocessor dataPreprocessor) {
		boolean result = this.dataPreprocessorInstances.get(
				dataPreprocessor.getClass().getSimpleName()).remove(
				dataPreprocessor);
		if (result) {
			try {
				dataPreprocessor.notify(new RepositoryRemoveEvent(
						dataPreprocessor));
			} catch (RegisterException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregisterDataPreprocessorClass(
			final Class<? extends DataPreprocessor> object) {
		boolean result = this.dataPreprocessorClasses.remove(object.getName()) != null;
		if (result) {
			this.info("DataPreprocessor removed: " + object.getSimpleName());
			for (DataPreprocessor dataPreprocessor : Collections
					.synchronizedList(new ArrayList<DataPreprocessor>(
							dataPreprocessorInstances.get(object
									.getSimpleName())))) {
				dataPreprocessor.unregister();
			}

		}
		return result;
	}

	/**
	 * @return The map containing all known finder exceptions.
	 */
	public Map<String, List<Throwable>> getKnownFinderExceptions() {
		return this.knownFinderExceptions;
	}

	/**
	 * @return The class loaders used by the finders to load classes
	 *         dynamically.
	 */
	public Map<URL, URLClassLoader> getJARFinderClassLoaders() {
		return this.finderClassLoaders;
	}

	/**
	 * 
	 * @return A map containing dependencies between jar files that are loaded
	 *         dynamically.
	 */
	public Map<File, List<File>> getJARFinderWaitingFiles() {
		return this.finderWaitingFiles;
	}

	/**
	 * 
	 * @return The change dates of the jar files that were loaded dynamically by
	 *         jar finder instances.
	 */
	public Map<String, Long> getFinderLoadedJarFileChangeDates() {
		return this.finderLoadedJarFileChangeDates;
	}

	/**
	 * This method checks whether the given context class is registered in this
	 * repository.
	 * 
	 * @param context
	 *            The class of the context to look up.
	 * @return True, if the context class was registered.
	 */
	public boolean isContextRegistered(final Class<? extends Context> context) {
		return this.contextClasses.containsKey(context.getName())
				|| (this.parent != null && this.parent
						.isContextRegistered(context));
	}

	/**
	 * This method checks whether a context with the given class name is
	 * registered in this repository.
	 * 
	 * @param contextClassName
	 *            The class name of the context to look up.
	 * @return True, if the context class was registered.
	 */
	public boolean isContextRegistered(final String contextClassName) {
		return this.contextClasses.containsKey(contextClassName)
				|| (this.parent != null && this.parent
						.isContextRegistered(contextClassName));
	}

	/**
	 * @return The absolute path to the directory within this repository, where
	 *         all contexts are stored.
	 */
	public String getContextBasePath() {
		return this.contextBasePath;
	}

	/**
	 * This method looks up and returns (if it exists) the class of the context
	 * with the given name.
	 * 
	 * @param contextClassName
	 *            The name of the class of the context.
	 * @return The context class with the given name or null, if it does not
	 *         exist.
	 */
	public Class<? extends Context> getContextClass(
			final String contextClassName) {
		Class<? extends Context> result = this.contextClasses
				.get(contextClassName);
		if (result == null && parent != null)
			result = this.parent.getContextClass(contextClassName);
		return result;
	}

	/**
	 * 
	 * @return The set of all registered context classes.
	 */
	public Collection<Class<? extends Context>> getContextClasses() {
		return this.contextClasses.values();
	}

	/**
	 * @return A boolean attribute indicating whether the contexts have been
	 *         initialized by the {@link ContextFinderThread}.
	 */
	public boolean getContextsInitialized() {
		return this.contextsInitialized;
	}

	/**
	 * This method registers a context class. The class is only registered, if
	 * it was not before.
	 * 
	 * @param object
	 *            The new class to register.
	 * @return True, if the new class was registered.
	 */
	public boolean registerContextClass(final Class<? extends Context> object) {
		if (isContextRegistered(object)) {
			// first remove the old class
			unregisterContextClass(this.contextClasses.get(object.getName()));
		}
		this.contextClasses.put(object.getName(), object);

		this.contextInstances.put(object.getSimpleName(),
				Collections.synchronizedList(new ArrayList<Context>()));

		this.sqlCommunicator.registerContextClass(object);

		return true;
	}

	/**
	 * This method unregisters the passed object.
	 * 
	 * <p>
	 * If the object has been registered before and was unregistered now, this
	 * method tells the sql communicator such that he can also handle the
	 * removal of the object.
	 * 
	 * @param object
	 *            The object to be removed.
	 * @return True, if the object was remved successfully
	 */
	public boolean unregisterContextClass(final Class<? extends Context> object) {
		boolean result = this.contextClasses.remove(object.getName()) != null;
		if (result) {
			this.info("Context removed: " + object.getSimpleName());
			// we inform all existing context objects about the new class. that
			// means those objects are deleted such that new instances instances
			// can be created using the new class.
			for (Context context : Collections
					.synchronizedList(new ArrayList<Context>(contextInstances
							.get(object.getSimpleName())))) {
				context.unregister();
			}

			this.sqlCommunicator.unregisterContextClass(object);
		}
		return result;
	}

	/**
	 * This method sets the contexts as initialized. It should only be invoked
	 * by {@link ContextFinderThread#afterFind()}.
	 */
	public void setContextsInitialized() {
		this.contextsInitialized = true;
	}

	public String getAnalysisResultsBasePath() {
		return ((RunResultEntity) this.repositoryObjectEntities
				.get(RunResult.class)).getAnalysisResultsBasePath();
	}

	public String getClusterResultsBasePath() {
		return ((RunResultEntity) this.repositoryObjectEntities
				.get(RunResult.class)).getClusterResultsBasePath();
	}

	public String getClusterResultsQualityBasePath() {
		return ((RunResultEntity) this.repositoryObjectEntities
				.get(RunResult.class)).getClusterResultsQualityBasePath();
	}
}

// class RepositoryJarEntity<T extends RepositoryObject>
// extends
// RepositoryEntity<T> {
//
// /**
// * @param basePath
// */
// public RepositoryJarEntity(String basePath) {
// super(basePath);
// }
//
// /**
// * A map containing all classes of dataset formats registered in this
// * repository. Mapping from Class.getName() to the class.
// */
// protected Map<String, Class<? extends T>> dataSetFormatClasses;
//
// /**
// * A map mapping from the simple name of the class to all of its
// * instances.Mapping from Class.getSimpleName() to the instances.
// */
// protected Map<String, List<T>> dataSetFormatInstances;
// }
