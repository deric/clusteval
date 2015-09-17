.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: org.apache.commons.configuration ConfigurationException

.. java:import:: utils Pair

.. java:import:: de.clusteval.cluster.paramOptimization IncompatibleParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.paramOptimization InvalidOptimizationParameterException

.. java:import:: de.clusteval.cluster.paramOptimization UnknownParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.quality UnknownClusteringQualityMeasureException

.. java:import:: de.clusteval.context IncompatibleContextException

.. java:import:: de.clusteval.context UnknownContextException

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

.. java:import:: de.clusteval.program UnknownParameterType

.. java:import:: de.clusteval.program UnknownProgramParameterException

.. java:import:: de.clusteval.program UnknownProgramTypeException

.. java:import:: de.clusteval.program.r UnknownRProgramException

.. java:import:: de.clusteval.run InvalidRunModeException

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run RunDataAnalysisRun

.. java:import:: de.clusteval.run RunException

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.run.result.postprocessing UnknownRunResultPostprocessorException

.. java:import:: de.clusteval.run.statistics RunDataStatistic

.. java:import:: de.clusteval.run.statistics UnknownRunDataStatisticException

.. java:import:: de.clusteval.run.statistics UnknownRunStatisticException

.. java:import:: de.clusteval.utils InvalidConfigurationFileException

.. java:import:: de.clusteval.utils Statistic

.. java:import:: file FileUtils

RunDataAnalysisRunResult
========================

.. java:package:: de.clusteval.run.result
   :noindex:

.. java:type:: public class RunDataAnalysisRunResult extends AnalysisRunResult<Pair<List<String>, List<String>>, RunDataStatistic>

   :author: Christian Wiwie

Constructors
------------
RunDataAnalysisRunResult
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataAnalysisRunResult(Repository repository, long changeDate, File absPath, String runIdentString, Run run) throws RegisterException
   :outertype: RunDataAnalysisRunResult

   :param repository:
   :param changeDate:
   :param absPath:
   :param runIdentString:
   :param run:
   :throws RegisterException:

RunDataAnalysisRunResult
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataAnalysisRunResult(RunDataAnalysisRunResult other) throws RegisterException
   :outertype: RunDataAnalysisRunResult

   The copy constructor for run data analysis run results.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public RunDataAnalysisRunResult clone()
   :outertype: RunDataAnalysisRunResult

cloneStatistics
^^^^^^^^^^^^^^^

.. java:method:: @Override protected Map<Pair<List<String>, List<String>>, List<RunDataStatistic>> cloneStatistics(Map<Pair<List<String>, List<String>>, List<RunDataStatistic>> statistics)
   :outertype: RunDataAnalysisRunResult

getRun
^^^^^^

.. java:method:: @Override public RunDataAnalysisRun getRun()
   :outertype: RunDataAnalysisRunResult

getRunDataStatistics
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<RunDataStatistic> getRunDataStatistics(Pair<List<String>, List<String>> uniqueRunIdentifierPair)
   :outertype: RunDataAnalysisRunResult

   :param uniqueRunIdentifierPair: A pair with identifier of run analysis runresult and data analysis runresult for which we want to know which run-data statistics were evaluated.
   :return: A list with all run-data statistics that were evaluated for the given pair.

getUniqueIdentifierPairs
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<Pair<List<String>, List<String>>> getUniqueIdentifierPairs()
   :outertype: RunDataAnalysisRunResult

   :return: A set with all pairs of identifiers of run analysis runresults and data analysis runresults.

loadIntoMemory
^^^^^^^^^^^^^^

.. java:method:: @Override public void loadIntoMemory() throws RunResultParseException
   :outertype: RunDataAnalysisRunResult

parseFromRunResultFolder
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static RunDataAnalysisRunResult parseFromRunResultFolder(Repository parentRepository, File runResultFolder) throws RepositoryAlreadyExistsException, InvalidRepositoryException, GoldStandardConfigurationException, DataSetConfigurationException, DataSetNotFoundException, DataSetConfigNotFoundException, GoldStandardConfigNotFoundException, DataConfigurationException, DataConfigNotFoundException, IOException, UnknownRunResultFormatException, UnknownDataSetFormatException, InvalidConfigurationFileException, UnknownClusteringQualityMeasureException, InvalidRunModeException, UnknownParameterOptimizationMethodException, NoOptimizableProgramParameterException, UnknownProgramParameterException, NoRepositoryFoundException, GoldStandardNotFoundException, InvalidOptimizationParameterException, RunException, UnknownDataStatisticException, UnknownProgramTypeException, UnknownRProgramException, IncompatibleParameterOptimizationMethodException, UnknownDistanceMeasureException, UnknownRunStatisticException, UnknownGoldStandardFormatException, RepositoryConfigNotFoundException, RepositoryConfigurationException, ConfigurationException, RegisterException, UnknownDataSetTypeException, NumberFormatException, NoDataSetException, UnknownRunDataStatisticException, RunResultParseException, UnknownDataPreprocessorException, IncompatibleDataSetConfigPreprocessorException, UnknownContextException, IncompatibleContextException, UnknownParameterType, InterruptedException, UnknownRunResultPostprocessorException, UnknownDataRandomizerException
   :outertype: RunDataAnalysisRunResult

   :param parentRepository:
   :param runResultFolder:
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
   :throws DataConfigurationException:
   :throws IncompatibleParameterOptimizationMethodException:
   :throws UnknownProgramParameterException:
   :throws UnknownRunDataStatisticException:
   :throws UnknownDataPreprocessorException:
   :throws NoOptimizableProgramParameterException:
   :throws InvalidRepositoryException:
   :throws UnknownDataSetFormatException:
   :throws UnknownDataRandomizerException:
   :throws NumberFormatException:
   :throws UnknownRunResultFormatException:
   :throws IncompatibleDataSetConfigPreprocessorException:
   :throws DataSetNotFoundException:
   :throws ConfigurationException:
   :throws GoldStandardConfigNotFoundException:
   :throws NoRepositoryFoundException:
   :throws UnknownParameterOptimizationMethodException:
   :throws UnknownDataSetTypeException:
   :throws RepositoryAlreadyExistsException:
   :throws InvalidOptimizationParameterException:
   :throws RunResultParseException:
   :throws IOException:
   :throws IncompatibleContextException:
   :throws DataConfigNotFoundException:
   :throws UnknownClusteringQualityMeasureException:
   :throws UnknownProgramTypeException:
   :throws UnknownDistanceMeasureException:
   :throws InvalidRunModeException:
   :throws GoldStandardConfigurationException:
   :throws RepositoryConfigNotFoundException:
   :throws NoDataSetException:
   :throws InvalidConfigurationFileException:
   :throws DataSetConfigNotFoundException:
   :throws RunException:
   :throws GoldStandardNotFoundException:
   :return: The run-data analysis runresult parsed from the given runresult folder.

parseFromRunResultFolder
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static RunDataAnalysisRunResult parseFromRunResultFolder(RunDataAnalysisRun run, Repository repository, File runResultFolder, List<RunResult> result, boolean register) throws RunResultParseException, RegisterException
   :outertype: RunDataAnalysisRunResult

   :param run: The run corresponding to the given runresult folder.
   :param repository: The repository in which we want to register the parsed runresult.
   :param runResultFolder: The folder containing the runresult.
   :throws RunResultParseException:
   :throws RegisterException:
   :return: The run-data analysis runresult parsed from the given runresult folder.

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: RunDataAnalysisRunResult

unloadFromMemory
^^^^^^^^^^^^^^^^

.. java:method:: @Override public void unloadFromMemory()
   :outertype: RunDataAnalysisRunResult

