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

.. java:import:: de.clusteval.data.statistics DataStatistic

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

.. java:import:: de.clusteval.run DataAnalysisRun

.. java:import:: de.clusteval.run InvalidRunModeException

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run RunException

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.run.result.postprocessing UnknownRunResultPostprocessorException

.. java:import:: de.clusteval.run.statistics UnknownRunDataStatisticException

.. java:import:: de.clusteval.run.statistics UnknownRunStatisticException

.. java:import:: de.clusteval.utils InvalidConfigurationFileException

.. java:import:: de.clusteval.utils Statistic

.. java:import:: file FileUtils

DataAnalysisRunResult
=====================

.. java:package:: de.clusteval.run.result
   :noindex:

.. java:type:: public class DataAnalysisRunResult extends AnalysisRunResult<DataConfig, DataStatistic>

   :author: Christian Wiwie

Constructors
------------
DataAnalysisRunResult
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataAnalysisRunResult(Repository repository, long changeDate, File absPath, String runIdentString, Run run) throws RegisterException
   :outertype: DataAnalysisRunResult

   :param repository:
   :param changeDate:
   :param absPath:
   :param runIdentString:
   :param run:
   :throws RegisterException:

DataAnalysisRunResult
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataAnalysisRunResult(DataAnalysisRunResult other) throws RegisterException
   :outertype: DataAnalysisRunResult

   The copy constructor for data analysis run results.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public DataAnalysisRunResult clone()
   :outertype: DataAnalysisRunResult

cloneStatistics
^^^^^^^^^^^^^^^

.. java:method:: @Override protected Map<DataConfig, List<DataStatistic>> cloneStatistics(Map<DataConfig, List<DataStatistic>> statistics)
   :outertype: DataAnalysisRunResult

getDataConfigs
^^^^^^^^^^^^^^

.. java:method:: public Set<DataConfig> getDataConfigs()
   :outertype: DataAnalysisRunResult

   :return: The data configurations encapsulating the datasets that were analysed.

getDataStatistics
^^^^^^^^^^^^^^^^^

.. java:method:: public List<DataStatistic> getDataStatistics(DataConfig dataConfig)
   :outertype: DataAnalysisRunResult

   :param dataConfig: The data configuration for which we want to know which data statistics were evaluated.
   :return: The data statistics that were assessed for the given data configuration.

getRun
^^^^^^

.. java:method:: @Override public DataAnalysisRun getRun()
   :outertype: DataAnalysisRunResult

loadIntoMemory
^^^^^^^^^^^^^^

.. java:method:: @Override public void loadIntoMemory() throws RunResultParseException
   :outertype: DataAnalysisRunResult

parseFromRunResultFolder
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static DataAnalysisRunResult parseFromRunResultFolder(Repository parentRepository, File runResultFolder) throws RepositoryAlreadyExistsException, InvalidRepositoryException, GoldStandardConfigurationException, DataSetConfigurationException, DataSetNotFoundException, DataSetConfigNotFoundException, GoldStandardConfigNotFoundException, DataConfigurationException, DataConfigNotFoundException, IOException, UnknownRunResultFormatException, UnknownDataSetFormatException, InvalidConfigurationFileException, UnknownClusteringQualityMeasureException, InvalidRunModeException, UnknownParameterOptimizationMethodException, NoOptimizableProgramParameterException, UnknownProgramParameterException, NoRepositoryFoundException, GoldStandardNotFoundException, InvalidOptimizationParameterException, RunException, UnknownDataStatisticException, UnknownProgramTypeException, UnknownRProgramException, IncompatibleParameterOptimizationMethodException, UnknownDistanceMeasureException, UnknownRunStatisticException, UnknownGoldStandardFormatException, AnalysisRunResultException, RepositoryConfigNotFoundException, RepositoryConfigurationException, ConfigurationException, RegisterException, UnknownDataSetTypeException, NumberFormatException, NoDataSetException, UnknownRunDataStatisticException, UnknownDataPreprocessorException, IncompatibleDataSetConfigPreprocessorException, UnknownContextException, IncompatibleContextException, UnknownParameterType, InterruptedException, UnknownRunResultPostprocessorException, UnknownDataRandomizerException
   :outertype: DataAnalysisRunResult

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
   :throws AnalysisRunResultException:
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
   :throws NumberFormatException:
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
   :return: The data analysis run result parsed from the given runresult folder.

parseFromRunResultFolder
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static DataAnalysisRunResult parseFromRunResultFolder(DataAnalysisRun run, Repository parentRepository, File runResultFolder, List<RunResult> result, boolean register) throws RegisterException, RunResultParseException
   :outertype: DataAnalysisRunResult

   :param run:
   :param parentRepository:
   :param runResultFolder:
   :throws RunResultParseException:
   :throws RegisterException:
   :return: The data analysis run result parsed from the given runresult folder.

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: DataAnalysisRunResult

unloadFromMemory
^^^^^^^^^^^^^^^^

.. java:method:: @Override public void unloadFromMemory()
   :outertype: DataAnalysisRunResult

