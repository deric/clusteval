.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: org.apache.commons.cli Options

.. java:import:: org.apache.commons.configuration ConfigurationException

.. java:import:: utils Triple

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.cluster.paramOptimization IncompatibleParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.paramOptimization InvalidOptimizationParameterException

.. java:import:: de.clusteval.cluster.paramOptimization UnknownParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasureValue

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

.. java:import:: de.clusteval.cluster.quality UnknownClusteringQualityMeasureException

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.context IncompatibleContextException

.. java:import:: de.clusteval.context UnknownContextException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data DataConfigNotFoundException

.. java:import:: de.clusteval.data DataConfigurationException

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetConfigNotFoundException

.. java:import:: de.clusteval.data.dataset DataSetConfigurationException

.. java:import:: de.clusteval.data.dataset DataSetNotFoundException

.. java:import:: de.clusteval.data.dataset IncompatibleDataSetConfigPreprocessorException

.. java:import:: de.clusteval.data.dataset NoDataSetException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.dataset.type UnknownDataSetTypeException

.. java:import:: de.clusteval.data.distance UnknownDistanceMeasureException

.. java:import:: de.clusteval.data.goldstandard GoldStandard

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigNotFoundException

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigurationException

.. java:import:: de.clusteval.data.goldstandard GoldStandardNotFoundException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.data.preprocessing UnknownDataPreprocessorException

.. java:import:: de.clusteval.data.randomizer DataRandomizeException

.. java:import:: de.clusteval.data.randomizer DataRandomizer

.. java:import:: de.clusteval.data.randomizer UnknownDataRandomizerException

.. java:import:: de.clusteval.data.statistics UnknownDataStatisticException

.. java:import:: de.clusteval.framework.repository InvalidRepositoryException

.. java:import:: de.clusteval.framework.repository NoRepositoryFoundException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryAlreadyExistsException

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigNotFoundException

.. java:import:: de.clusteval.framework.repository.config RepositoryConfigurationException

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.program NoOptimizableProgramParameterException

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.program UnknownParameterType

.. java:import:: de.clusteval.program UnknownProgramParameterException

.. java:import:: de.clusteval.program UnknownProgramTypeException

.. java:import:: de.clusteval.program.r UnknownRProgramException

.. java:import:: de.clusteval.run.result ClusteringRunResult

.. java:import:: de.clusteval.run.result ParameterOptimizationResult

.. java:import:: de.clusteval.run.result RunResult

.. java:import:: de.clusteval.run.result RunResultParseException

.. java:import:: de.clusteval.run.result.format UnknownRunResultFormatException

.. java:import:: de.clusteval.run.result.postprocessing RunResultPostprocessor

.. java:import:: de.clusteval.run.result.postprocessing UnknownRunResultPostprocessorException

.. java:import:: de.clusteval.run.runnable ExecutionRunRunnable

.. java:import:: de.clusteval.run.runnable RobustnessAnalysisRunRunnable

.. java:import:: de.clusteval.run.runnable RunRunnable

.. java:import:: de.clusteval.run.statistics UnknownRunDataStatisticException

.. java:import:: de.clusteval.run.statistics UnknownRunStatisticException

.. java:import:: de.clusteval.utils InvalidConfigurationFileException

.. java:import:: file FileUtils

RobustnessAnalysisRun
=====================

.. java:package:: de.clusteval.run
   :noindex:

.. java:type:: public class RobustnessAnalysisRun extends ClusteringRun

   :author: Christian Wiwie

Fields
------
distortionParams
^^^^^^^^^^^^^^^^

.. java:field:: protected List<ParameterSet> distortionParams
   :outertype: RobustnessAnalysisRun

numberOfDistortedDataSets
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected int numberOfDistortedDataSets
   :outertype: RobustnessAnalysisRun

originalDataConfigs
^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<DataConfig> originalDataConfigs
   :outertype: RobustnessAnalysisRun

randomizer
^^^^^^^^^^

.. java:field:: protected DataRandomizer randomizer
   :outertype: RobustnessAnalysisRun

uniqueRunAnalysisRunIdentifiers
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<String> uniqueRunAnalysisRunIdentifiers
   :outertype: RobustnessAnalysisRun

   A list of unique run identifiers, that should be assessed during execution of the run

Constructors
------------
RobustnessAnalysisRun
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RobustnessAnalysisRun(Repository repository, Context context, long changeDate, File absPath, List<String> uniqueRunIdentifiers, List<ProgramConfig> programConfigs, List<DataConfig> dataConfigs, List<DataConfig> originalDataConfigs, List<ClusteringQualityMeasure> qualityMeasures, List<Map<ProgramParameter<?>, String>> parameterValues, List<RunResultPostprocessor> postProcessors, DataRandomizer randomizer, List<ParameterSet> randomizerParams, int numberOfRandomizedDataSets, Map<String, Integer> maxExecutionTimes) throws RegisterException
   :outertype: RobustnessAnalysisRun

   :param repository: The repository this run should be registered at.
   :param context:
   :param changeDate: The date this run was performed.
   :param absPath: The absolute path to the file on the filesystem that corresponds to this run.
   :param uniqueRunIdentifiers: The list of unique run identifiers, that should be assessed during execution of the run.
   :throws RegisterException:

RobustnessAnalysisRun
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: protected RobustnessAnalysisRun(RobustnessAnalysisRun other) throws RegisterException
   :outertype: RobustnessAnalysisRun

   Copy constructor of run analysis runs.

   :param other: The run analysis run to be cloned.
   :throws RegisterException:

Methods
-------
afterPerform
^^^^^^^^^^^^

.. java:method:: @Override protected void afterPerform()
   :outertype: RobustnessAnalysisRun

afterResume
^^^^^^^^^^^

.. java:method:: @Override protected void afterResume(String runIdentString)
   :outertype: RobustnessAnalysisRun

beforePerform
^^^^^^^^^^^^^

.. java:method:: @Override protected void beforePerform() throws IOException, RunInitializationException
   :outertype: RobustnessAnalysisRun

beforeResume
^^^^^^^^^^^^

.. java:method:: @Override protected void beforeResume(String runIdentString) throws RunInitializationException
   :outertype: RobustnessAnalysisRun

clone
^^^^^

.. java:method:: @Override public RobustnessAnalysisRun clone()
   :outertype: RobustnessAnalysisRun

createAnalysesDirectory
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void createAnalysesDirectory()
   :outertype: RobustnessAnalysisRun

createAndScheduleRunnableForResumePair
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunRunnable createAndScheduleRunnableForResumePair(RunSchedulerThread runScheduler, int p)
   :outertype: RobustnessAnalysisRun

createRunRunnableFor
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected ExecutionRunRunnable createRunRunnableFor(RunSchedulerThread runScheduler, Run run, ProgramConfig programConfig, DataConfig dataConfig, String runIdentString, boolean isResume, Map<ProgramParameter<?>, String> runParams)
   :outertype: RobustnessAnalysisRun

findBestParamsAndInitParameterValues
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void findBestParamsAndInitParameterValues(Repository repository) throws UnknownDataSetFormatException, UnknownGoldStandardFormatException, GoldStandardNotFoundException, GoldStandardConfigurationException, DataSetConfigurationException, DataSetNotFoundException, DataSetConfigNotFoundException, GoldStandardConfigNotFoundException, NoDataSetException, DataConfigurationException, DataConfigNotFoundException, NumberFormatException, RunResultParseException, ConfigurationException, RegisterException, UnknownContextException, UnknownParameterType, IOException, UnknownRunResultFormatException, UnknownClusteringQualityMeasureException, InvalidRunModeException, UnknownParameterOptimizationMethodException, NoOptimizableProgramParameterException, UnknownProgramParameterException, InvalidConfigurationFileException, RepositoryAlreadyExistsException, InvalidRepositoryException, NoRepositoryFoundException, InvalidOptimizationParameterException, RunException, UnknownDataStatisticException, UnknownProgramTypeException, UnknownRProgramException, IncompatibleParameterOptimizationMethodException, UnknownDistanceMeasureException, UnknownRunStatisticException, RepositoryConfigNotFoundException, RepositoryConfigurationException, UnknownDataSetTypeException, UnknownRunDataStatisticException, UnknownDataPreprocessorException, IncompatibleDataSetConfigPreprocessorException, IncompatibleContextException, InterruptedException, UnknownRunResultPostprocessorException, UnknownDataRandomizerException
   :outertype: RobustnessAnalysisRun

   :throws UnknownDataStatisticException:
   :throws UnknownParameterType:
   :throws UnknownRunStatisticException:
   :throws InvalidRepositoryException:
   :throws RepositoryConfigurationException:
   :throws UnknownGoldStandardFormatException:
   :throws UnknownContextException:
   :throws NoOptimizableProgramParameterException:
   :throws UnknownRunResultPostprocessorException:
   :throws IncompatibleContextException:
   :throws RunResultParseException:
   :throws IncompatibleParameterOptimizationMethodException:
   :throws RegisterException:
   :throws UnknownProgramParameterException:
   :throws UnknownRunDataStatisticException:
   :throws InterruptedException:
   :throws UnknownRProgramException:
   :throws UnknownDataPreprocessorException:
   :throws UnknownDataSetFormatException:
   :throws UnknownDataRandomizerException:
   :throws NumberFormatException:
   :throws UnknownRunResultFormatException:
   :throws IncompatibleDataSetConfigPreprocessorException:
   :throws DataSetNotFoundException:
   :throws ConfigurationException:
   :throws DataConfigurationException:
   :throws GoldStandardConfigNotFoundException:
   :throws NoRepositoryFoundException:
   :throws UnknownParameterOptimizationMethodException:
   :throws UnknownDataSetTypeException:
   :throws RepositoryAlreadyExistsException:
   :throws InvalidOptimizationParameterException:
   :throws IOException:
   :throws DataSetConfigurationException:
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

getRunParameterForRunPair
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected Map<ProgramParameter<? extends Object>, String> getRunParameterForRunPair(int p)
   :outertype: RobustnessAnalysisRun

setOriginalDataConfigurations
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setOriginalDataConfigurations(List<DataConfig> dataConfigs)
   :outertype: RobustnessAnalysisRun

