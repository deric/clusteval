.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: org.apache.commons.configuration ConfigurationException

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

.. java:import:: de.clusteval.framework.repository.parse Parser

.. java:import:: de.clusteval.program NoOptimizableProgramParameterException

.. java:import:: de.clusteval.program UnknownParameterType

.. java:import:: de.clusteval.program UnknownProgramParameterException

.. java:import:: de.clusteval.program UnknownProgramTypeException

.. java:import:: de.clusteval.program.r UnknownRProgramException

.. java:import:: de.clusteval.run InvalidRunModeException

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run RunAnalysisRun

.. java:import:: de.clusteval.run RunException

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.run.result.postprocessing UnknownRunResultPostprocessorException

.. java:import:: de.clusteval.run.statistics RunStatistic

.. java:import:: de.clusteval.run.statistics UnknownRunDataStatisticException

.. java:import:: de.clusteval.run.statistics UnknownRunStatisticException

.. java:import:: de.clusteval.utils InvalidConfigurationFileException

.. java:import:: de.clusteval.utils Statistic

.. java:import:: file FileUtils

RunAnalysisRunResult
====================

.. java:package:: de.clusteval.run.result
   :noindex:

.. java:type:: public class RunAnalysisRunResult extends AnalysisRunResult<String, RunStatistic>

   :author: Christian Wiwie

Constructors
------------
RunAnalysisRunResult
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunAnalysisRunResult(Repository repository, boolean register, long changeDate, File absPath, String runIdentString, Run run) throws RegisterException
   :outertype: RunAnalysisRunResult

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param runIdentString:
   :param run:
   :throws RegisterException:

RunAnalysisRunResult
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunAnalysisRunResult(RunAnalysisRunResult other) throws RegisterException
   :outertype: RunAnalysisRunResult

   The copy constructor for run analysis run results.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public RunAnalysisRunResult clone()
   :outertype: RunAnalysisRunResult

cloneStatistics
^^^^^^^^^^^^^^^

.. java:method:: @Override protected Map<String, List<RunStatistic>> cloneStatistics(Map<String, List<RunStatistic>> statistics)
   :outertype: RunAnalysisRunResult

getRun
^^^^^^

.. java:method:: @Override public RunAnalysisRun getRun()
   :outertype: RunAnalysisRunResult

getRunStatistics
^^^^^^^^^^^^^^^^

.. java:method:: public List<RunStatistic> getRunStatistics(String uniqueRunIdentifier)
   :outertype: RunAnalysisRunResult

   :param uniqueRunIdentifier: The runresult identifier for which we want to know the assessed run statistics.
   :return: A list with all run statistics assessed for the given runresult identifier.

getUniqueRunIdentifier
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Set<String> getUniqueRunIdentifier()
   :outertype: RunAnalysisRunResult

   :return: A set with all runresult identifiers, which the run analysed which produced this runresult.

loadIntoMemory
^^^^^^^^^^^^^^

.. java:method:: @Override public void loadIntoMemory() throws RunResultParseException
   :outertype: RunAnalysisRunResult

parseFromRunResultFolder
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static RunAnalysisRunResult parseFromRunResultFolder(Repository repository, File runResultFolder) throws RepositoryAlreadyExistsException, InvalidRepositoryException, GoldStandardConfigurationException, DataSetConfigurationException, DataSetNotFoundException, DataSetConfigNotFoundException, GoldStandardConfigNotFoundException, DataConfigurationException, DataConfigNotFoundException, IOException, UnknownRunResultFormatException, UnknownDataSetFormatException, InvalidConfigurationFileException, UnknownClusteringQualityMeasureException, InvalidRunModeException, UnknownParameterOptimizationMethodException, NoOptimizableProgramParameterException, UnknownProgramParameterException, NoRepositoryFoundException, GoldStandardNotFoundException, InvalidOptimizationParameterException, RunException, UnknownDataStatisticException, UnknownProgramTypeException, UnknownRProgramException, IncompatibleParameterOptimizationMethodException, UnknownDistanceMeasureException, UnknownRunStatisticException, UnknownGoldStandardFormatException, RepositoryConfigNotFoundException, RepositoryConfigurationException, ConfigurationException, RegisterException, UnknownDataSetTypeException, NumberFormatException, NoDataSetException, UnknownRunDataStatisticException, RunResultParseException, UnknownDataPreprocessorException, IncompatibleDataSetConfigPreprocessorException, UnknownContextException, IncompatibleContextException, UnknownParameterType, InterruptedException, UnknownRunResultPostprocessorException, UnknownDataRandomizerException
   :outertype: RunAnalysisRunResult

   :param repository: The repository in which we want to register the parsed runresult.
   :param runResultFolder: The runresult folder from which we want to parse the runresult.
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
   :return: The run analysis runresult parsed from the runresult folder.

parseFromRunResultFolder
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static RunAnalysisRunResult parseFromRunResultFolder(RunAnalysisRun run, Repository repository, File runResultFolder, List<RunResult> result, boolean register) throws RunResultParseException, RegisterException
   :outertype: RunAnalysisRunResult

   :param run: The run analysis run corresponding to the given runresult folder.
   :param repository: The repository in which we want to register the parsed runresult.
   :param runResultFolder: A file object referencing the runresult folder.
   :throws RunResultParseException:
   :throws RegisterException:
   :return: The run analysis runresult parsed from the given runresult folder.

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: RunAnalysisRunResult

unloadFromMemory
^^^^^^^^^^^^^^^^

.. java:method:: @Override public void unloadFromMemory()
   :outertype: RunAnalysisRunResult

