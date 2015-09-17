.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.io IOException

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: org.apache.commons.configuration ConfigurationException

.. java:import:: utils Pair

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.cluster.paramOptimization IncompatibleParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.paramOptimization InvalidOptimizationParameterException

.. java:import:: de.clusteval.cluster.paramOptimization UnknownParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.quality UnknownClusteringQualityMeasureException

.. java:import:: de.clusteval.context IncompatibleContextException

.. java:import:: de.clusteval.context UnknownContextException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data DataConfigNotFoundException

.. java:import:: de.clusteval.data DataConfigurationException

.. java:import:: de.clusteval.data.dataset DataSetConfigNotFoundException

.. java:import:: de.clusteval.data.dataset DataSetConfigurationException

.. java:import:: de.clusteval.data.dataset DataSetNotFoundException

.. java:import:: de.clusteval.data.dataset IncompatibleDataSetConfigPreprocessorException

.. java:import:: de.clusteval.data.dataset NoDataSetException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.dataset.type UnknownDataSetTypeException

.. java:import:: de.clusteval.data.distance UnknownDistanceMeasureException

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigNotFoundException

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigurationException

.. java:import:: de.clusteval.data.goldstandard GoldStandardNotFoundException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.data.preprocessing UnknownDataPreprocessorException

.. java:import:: de.clusteval.data.randomizer UnknownDataRandomizerException

.. java:import:: de.clusteval.data.statistics UnknownDataStatisticException

.. java:import:: de.clusteval.framework.repository InvalidRepositoryException

.. java:import:: de.clusteval.framework.repository NoRepositoryFoundException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryAlreadyExistsException

.. java:import:: de.clusteval.framework.repository RunResultRepository

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigNotFoundException

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigurationException

.. java:import:: de.clusteval.framework.repository.db DatabaseConnectException

.. java:import:: de.clusteval.framework.repository.parse Parser

.. java:import:: de.clusteval.program NoOptimizableProgramParameterException

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program UnknownParameterType

.. java:import:: de.clusteval.program UnknownProgramParameterException

.. java:import:: de.clusteval.program UnknownProgramTypeException

.. java:import:: de.clusteval.program.r UnknownRProgramException

.. java:import:: de.clusteval.run ClusteringRun

.. java:import:: de.clusteval.run InvalidRunModeException

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run RunException

.. java:import:: de.clusteval.run.result.format RunResultFormat

.. java:import:: de.clusteval.run.result.format RunResultFormatParser

.. java:import:: de.clusteval.run.result.format RunResultNotFoundException

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.run.result.postprocessing UnknownRunResultPostprocessorException

.. java:import:: de.clusteval.run.statistics UnknownRunDataStatisticException

.. java:import:: de.clusteval.run.statistics UnknownRunStatisticException

.. java:import:: de.clusteval.utils InvalidConfigurationFileException

.. java:import:: file FileUtils

ClusteringRunResult
===================

.. java:package:: de.clusteval.run.result
   :noindex:

.. java:type:: public class ClusteringRunResult extends ExecutionRunResult

   The Class ClusteringResult.

   :author: Christian Wiwie

Fields
------
clustering
^^^^^^^^^^

.. java:field:: protected Pair<ParameterSet, Clustering> clustering
   :outertype: ClusteringRunResult

resultFormat
^^^^^^^^^^^^

.. java:field:: protected RunResultFormat resultFormat
   :outertype: ClusteringRunResult

   The result format.

Constructors
------------
ClusteringRunResult
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringRunResult(Repository repository, long changeDate, File absPath, DataConfig dataConfig, ProgramConfig programConfig, RunResultFormat resultFormat, String runIdentString, Run run) throws RegisterException
   :outertype: ClusteringRunResult

   Instantiates a new clustering result.

   :param repository: the repository
   :param changeDate:
   :param dataConfig: the data config
   :param programConfig: the program config
   :param resultFormat: the result format
   :param absPath: the abs file path
   :param runIdentString: the run ident string
   :param run:
   :throws RegisterException:

ClusteringRunResult
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringRunResult(ClusteringRunResult other) throws RegisterException
   :outertype: ClusteringRunResult

   The copy constructor of run results.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public ClusteringRunResult clone()
   :outertype: ClusteringRunResult

convertTo
^^^^^^^^^

.. java:method:: @SuppressWarnings public ClusteringRunResult convertTo(RunResultFormat format, Map<String, String> internalParams, Map<String, String> params) throws NoRunResultFormatParserException, RunResultNotFoundException, RegisterException
   :outertype: ClusteringRunResult

   Convert to.

   :param format: the format
   :param internalParams: Internal parameters used to produced the clustering result needed for parsing parameters.
   :param params: Parameters used to produced the clustering result needed for parsing parameters.
   :throws RunResultNotFoundException:
   :throws NoRunResultFormatParserException: the no run result format parser exception
   :throws RegisterException:
   :return: the clustering result

getClustering
^^^^^^^^^^^^^

.. java:method:: public Pair<ParameterSet, Clustering> getClustering()
   :outertype: ClusteringRunResult

   :return: The clustering corresponding to this clustering run result.

getResultFormat
^^^^^^^^^^^^^^^

.. java:method:: public RunResultFormat getResultFormat()
   :outertype: ClusteringRunResult

   Gets the result format.

   :return: the result format

loadIntoMemory
^^^^^^^^^^^^^^

.. java:method:: @Override public void loadIntoMemory()
   :outertype: ClusteringRunResult

parseFromRunResultCompleteFile
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static ClusteringRunResult parseFromRunResultCompleteFile(Repository repository, ClusteringRun run, DataConfig dataConfig, ProgramConfig programConfig, File completeFile, boolean register) throws RegisterException
   :outertype: ClusteringRunResult

   :param repository:
   :param run:
   :param dataConfig:
   :param programConfig:
   :param completeFile:
   :throws RegisterException:
   :return: The parameter optimization run result parsed from the given runresult folder.

parseFromRunResultFolder
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Run parseFromRunResultFolder(ClusteringRun run, Repository repository, File runResultFolder, List<RunResult> result, boolean register) throws RegisterException
   :outertype: ClusteringRunResult

   :param run: The run corresponding to the runresult folder.
   :param repository: The repository in which we want to register the runresult.
   :param runResultFolder: A file object referencing the runresult folder.
   :param result: The list of runresults this method fills.
   :throws RegisterException:
   :return: The parameter optimization run parsed from the runresult folder.

parseFromRunResultFolder
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Run parseFromRunResultFolder(Repository parentRepository, File runResultFolder, List<ExecutionRunResult> result, boolean register) throws IOException, UnknownRunResultFormatException, UnknownDataSetFormatException, UnknownClusteringQualityMeasureException, InvalidRunModeException, UnknownParameterOptimizationMethodException, NoOptimizableProgramParameterException, UnknownProgramParameterException, UnknownGoldStandardFormatException, InvalidConfigurationFileException, RepositoryAlreadyExistsException, InvalidRepositoryException, NoRepositoryFoundException, GoldStandardNotFoundException, InvalidOptimizationParameterException, GoldStandardConfigurationException, DataSetConfigurationException, DataSetNotFoundException, DataSetConfigNotFoundException, GoldStandardConfigNotFoundException, DataConfigurationException, DataConfigNotFoundException, RunException, UnknownDataStatisticException, UnknownProgramTypeException, UnknownRProgramException, IncompatibleParameterOptimizationMethodException, UnknownDistanceMeasureException, UnknownRunStatisticException, RepositoryConfigNotFoundException, RepositoryConfigurationException, ConfigurationException, RegisterException, UnknownDataSetTypeException, NumberFormatException, NoDataSetException, UnknownRunDataStatisticException, UnknownDataPreprocessorException, IncompatibleDataSetConfigPreprocessorException, UnknownContextException, IncompatibleContextException, UnknownParameterType, InterruptedException, UnknownRunResultPostprocessorException, UnknownDataRandomizerException
   :outertype: ClusteringRunResult

   :param parentRepository:
   :param runResultFolder:
   :param result:
   :throws UnknownDataStatisticException:
   :throws UnknownGoldStandardFormatException:
   :throws UnknownRunStatisticException:
   :throws DataSetConfigurationException:
   :throws RepositoryConfigurationException:
   :throws InterruptedException:
   :throws UnknownParameterType:
   :throws UnknownContextException:
   :throws UnknownRProgramException:
   :throws UnknownRunResultPostprocessorException:
   :throws RegisterException:
   :throws UnknownDistanceMeasureException:
   :throws IncompatibleParameterOptimizationMethodException:
   :throws UnknownProgramParameterException:
   :throws UnknownRunDataStatisticException:
   :throws UnknownDataPreprocessorException:
   :throws NoOptimizableProgramParameterException:
   :throws InvalidRepositoryException:
   :throws UnknownDataSetFormatException:
   :throws UnknownDataRandomizerException:
   :throws NumberFormatException:
   :throws DataConfigNotFoundException:
   :throws IncompatibleDataSetConfigPreprocessorException:
   :throws DataSetNotFoundException:
   :throws ConfigurationException:
   :throws GoldStandardConfigNotFoundException:
   :throws NoRepositoryFoundException:
   :throws UnknownParameterOptimizationMethodException:
   :throws UnknownDataSetTypeException:
   :throws RepositoryAlreadyExistsException:
   :throws InvalidOptimizationParameterException:
   :throws IOException:
   :throws IncompatibleContextException:
   :throws UnknownRunResultFormatException:
   :throws UnknownClusteringQualityMeasureException:
   :throws UnknownProgramTypeException:
   :throws DataConfigurationException:
   :throws InvalidRunModeException:
   :throws GoldStandardConfigurationException:
   :throws RepositoryConfigNotFoundException:
   :throws NoDataSetException:
   :throws InvalidConfigurationFileException:
   :throws DataSetConfigNotFoundException:
   :throws RunException:
   :throws GoldStandardNotFoundException:
   :return: The parameter optimization run result parsed from the given runresult folder.

setResultFormat
^^^^^^^^^^^^^^^

.. java:method:: public void setResultFormat(RunResultFormat resultFormat)
   :outertype: ClusteringRunResult

   Sets the result format.

   :param resultFormat: the new result format

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: ClusteringRunResult

unloadFromMemory
^^^^^^^^^^^^^^^^

.. java:method:: @Override public void unloadFromMemory()
   :outertype: ClusteringRunResult

