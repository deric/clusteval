.. java:import:: java.util Map

.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethodFinderThread

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasureFinderThread

.. java:import:: de.clusteval.context ContextFinderThread

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data DataConfigFinderThread

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset DataSetConfigFinderThread

.. java:import:: de.clusteval.data.dataset DataSetFinderThread

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format DataSetFormatFinderThread

.. java:import:: de.clusteval.data.dataset.generator DataSetGenerator

.. java:import:: de.clusteval.data.dataset.generator DataSetGeneratorFinderThread

.. java:import:: de.clusteval.data.dataset.type DataSetType

.. java:import:: de.clusteval.data.dataset.type DataSetTypeFinderThread

.. java:import:: de.clusteval.data.distance DistanceMeasure

.. java:import:: de.clusteval.data.distance DistanceMeasureFinderThread

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfig

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfigFinderThread

.. java:import:: de.clusteval.data.preprocessing DataPreprocessorFinderThread

.. java:import:: de.clusteval.data.randomizer DataRandomizerFinderThread

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.data.statistics DataStatisticFinderThread

.. java:import:: de.clusteval.framework ClustevalBackendServer

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramConfigFinderThread

.. java:import:: de.clusteval.program.r RProgram

.. java:import:: de.clusteval.program.r RProgramFinderThread

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run RunFinderThread

.. java:import:: de.clusteval.run.result RunResult

.. java:import:: de.clusteval.run.result RunResultFinderThread

.. java:import:: de.clusteval.run.result.format RunResultFormat

.. java:import:: de.clusteval.run.result.format RunResultFormatFinderThread

.. java:import:: de.clusteval.run.result.postprocessing RunResultPostprocessorFinderThread

.. java:import:: de.clusteval.run.statistics RunDataStatistic

.. java:import:: de.clusteval.run.statistics RunDataStatisticFinderThread

.. java:import:: de.clusteval.run.statistics RunStatistic

.. java:import:: de.clusteval.run.statistics RunStatisticFinderThread

RepositorySupervisorThread
==========================

.. java:package:: de.clusteval.framework.threading
   :noindex:

.. java:type:: public class RepositorySupervisorThread extends SupervisorThread

   A type of supervisor thread which creates the standard set of threads responsible for the initialization of a standard \ :java:ref:`Repository`\ . In detail threads of the following type are created, started and kept alive:

   ..

   * \ **DataSetFormatFinderThread**\ : A thread which checks \ :java:ref:`Repository.dataSetFormatBasePath`\  for new dataset formats (see \ :java:ref:`DataSetFormat`\ ).
   * \ **DataSetTypeFinderThread**\ : A thread which checks \ :java:ref:`Repository.dataSetTypeBasePath`\  for new dataset types (see \ :java:ref:`DataSetType`\ ).
   * \ **DataSetFinderThread**\ : A thread which checks \ :java:ref:`Repository.basePath`\  for new datasets (see \ :java:ref:`DataSet`\ ).
   * \ **DistanceMeasureFinderThread**\ : A thread which checks \ :java:ref:`Repository.distanceMeasureBasePath`\  for new distance measures (see \ :java:ref:`DistanceMeasure`\ ).
   * \ **DataStatisticFinderThread**\ : A thread which checks \ :java:ref:`Repository.dataStatisticBasePath`\  for new data statistics (see \ :java:ref:`DataStatistic`\ ).
   * \ **RunStatisticFinderThread**\ : A thread which checks \ :java:ref:`Repository.runStatisticBasePath`\  for new run statistics (see \ :java:ref:`RunStatistic`\ ).
   * \ **RunDataStatisticFinderThread**\ : A thread which checks \ :java:ref:`Repository.runDataStatisticBasePath`\  for new run data statistics (see \ :java:ref:`RunDataStatistic`\ ).
   * \ **RunResultFormatFinderThread**\ : A thread which checks \ :java:ref:`Repository.runResultFormatBasePath`\  for new runresult formats (see \ :java:ref:`RunResultFormat`\ ).
   * \ **ClusteringQualityMeasureFinderThread**\ : A thread which checks \ :java:ref:`Repository.clusteringQualityMeasureBasePath`\  for new clustering quality measures (see \ :java:ref:`ClusteringQualityMeasure`\ ).
   * \ **ParameterOptimizationMethodFinderThread**\ : A thread which checks \ :java:ref:`Repository.parameterOptimizationMethodBasePath`\  for new parameter optimization methods (see \ :java:ref:`DataSetFormat`\ ).
   * \ **DataSetConfigFinderThread**\ : A thread which checks \ :java:ref:`Repository.dataSetConfigBasePath`\  for new dataset configurations (see \ :java:ref:`DataSetConfig`\ ).
   * \ **GoldStandardConfigFinderThread**\ : A thread which checks \ :java:ref:`Repository.goldStandardConfigBasePath`\  for new goldstandard configurations (see \ :java:ref:`GoldStandardConfig`\ ).
   * \ **DataConfigFinderThread**\ : A thread which checks \ :java:ref:`Repository.dataConfigBasePath`\  for new data configurations (see \ :java:ref:`DataConfig`\ ).
   * \ **RProgramFinderThread**\ : A thread which checks \ :java:ref:`Repository.programBasePath`\  for new RPrograms (see \ :java:ref:`RProgram`\ ).
   * \ **ProgramConfigFinderThread**\ : A thread which checks \ :java:ref:`Repository.programConfigBasePath`\  for new program configurations (see \ :java:ref:`ProgramConfig`\ ).
   * \ **DataSetGeneratorFinderThread**\ : A thread which checks \ :java:ref:`Repository.dataSetGeneratorBasePath`\  for new dataset generators (see \ :java:ref:`DataSetGenerator`\ ).
   * \ **RunFinderThread**\ : A thread which checks \ :java:ref:`Repository.runBasePath`\  for new runs (see \ :java:ref:`Run`\ ).
   * \ **RunSchedulerThread**\ : A thread which is responsible for scheduling, starting and terminating runs. It can be controlled with its \ :java:ref:`RunSchedulerThread.schedule(String,String)`\ , \ :java:ref:`RunSchedulerThread.scheduleResume(String,String)`\  and \ :java:ref:`RunSchedulerThread.terminate(String,String)`\  methods.

   If the boolean parameter \ **checkForRunResults**\  is true, additionally the following threads are started and kept alive:

   ..

   * \ **RunResultFinderThread**\ : A thread which checks \ :java:ref:`Repository.runResultBasePath`\  for new run results (see \ :java:ref:`RunResult`\ ).

   :author: Christian Wiwie

Constructors
------------
RepositorySupervisorThread
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: @SuppressWarnings public RepositorySupervisorThread(Repository repository, Map<String, Long> threadSleepTimes, boolean checkOnce, boolean checkForRunResults)
   :outertype: RepositorySupervisorThread

   :param repository: The repository this thread belongs to.
   :param threadSleepTimes: The sleep times of the created threads.
   :param checkOnce: A boolean indicating, whether this thread should only check once and terminate afterwards.
   :param checkForRunResults: Whether this thread should check for run results in the repository.

