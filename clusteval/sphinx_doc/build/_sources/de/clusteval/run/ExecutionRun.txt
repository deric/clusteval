.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: org.junit.runners.model RunnerScheduler

.. java:import:: utils Pair

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryEvent

.. java:import:: de.clusteval.framework.repository RepositoryRemoveEvent

.. java:import:: de.clusteval.framework.repository RepositoryReplaceEvent

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.run.result NoRunResultFormatParserException

.. java:import:: de.clusteval.run.result.postprocessing RunResultPostprocessor

.. java:import:: de.clusteval.run.runnable ExecutionRunRunnable

.. java:import:: de.clusteval.run.runnable RunRunnable

.. java:import:: de.clusteval.run.runnable RunRunnableInitializationException

.. java:import:: file FileUtils

ExecutionRun
============

.. java:package:: de.clusteval.run
   :noindex:

.. java:type:: public abstract class ExecutionRun extends Run

   An abstract class for all run types, that involve execution of clustering tools and applying them to datasets.

   An execution run has a list of program and data configurations. These are pairwise combined and for every pair (see \ :java:ref:`runPairs`\ ) a runnable is created and executed asynchronously by the \ :java:ref:`RunnerScheduler`\ .

   The data and program configurations passed to this run are the same as the objects stored in the repository. Thus those objects can change during runtime of this run. To avoid those changes affecting the run during its execution the original objects are cloned in \ :java:ref:`initRunPairs(List,List)`\  before they are passed to the run runnables which are performed asynchronously.

   :author: Christian Wiwie

Fields
------
dataConfigs
^^^^^^^^^^^

.. java:field:: protected List<DataConfig> dataConfigs
   :outertype: ExecutionRun

   A list of data configurations contained in this run.

   The references to data configurations in this list are the same as those stored in the repository. That means the objects in this list can change during runtime of the run.

maxExecutionTimes
^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, Integer> maxExecutionTimes
   :outertype: ExecutionRun

parameterValues
^^^^^^^^^^^^^^^

.. java:field:: protected List<Map<ProgramParameter<?>, String>> parameterValues
   :outertype: ExecutionRun

   The parameter values for every pair of program and data configuration.

postProcessors
^^^^^^^^^^^^^^

.. java:field:: protected List<RunResultPostprocessor> postProcessors
   :outertype: ExecutionRun

programConfigs
^^^^^^^^^^^^^^

.. java:field:: protected List<ProgramConfig> programConfigs
   :outertype: ExecutionRun

   A list of program configurations contained in this run.

   The references to program configurations in this list are the same as those stored in the repository. That means the objects in this list can change during runtime of the run.

qualityMeasures
^^^^^^^^^^^^^^^

.. java:field:: protected List<ClusteringQualityMeasure> qualityMeasures
   :outertype: ExecutionRun

   During execution of this run for every clustering that is calculated a set of clustering quality measures is calculated.

runPairs
^^^^^^^^

.. java:field:: protected List<Pair<ProgramConfig, DataConfig>> runPairs
   :outertype: ExecutionRun

   The pairwise combinations of data and program configurations that are used to create the runnables.

Constructors
------------
ExecutionRun
^^^^^^^^^^^^

.. java:constructor:: protected ExecutionRun(Repository repository, Context context, boolean register, long changeDate, File absPath, List<ProgramConfig> programConfigs, List<DataConfig> dataConfigs, List<ClusteringQualityMeasure> qualityMeasures, List<Map<ProgramParameter<?>, String>> parameterValues, List<RunResultPostprocessor> postProcessors, Map<String, Integer> maxExecutionTimes) throws RegisterException
   :outertype: ExecutionRun

   The constructor of this class takes a name, date and configuration. It is protected, to force usage of the static method

   :param repository: the repository
   :param register: Whether the new instance should be registered at the repository.
   :param name: The name of this run.
   :param changeDate: The date this run was performed.
   :param absPath: The absolute path to the file on the filesystem that corresponds to this run.
   :param programConfigs: The program configurations of the new run.
   :param dataConfigs: The data configurations of the new run.
   :param qualityMeasures: The clustering quality measures of the new run.
   :param parameterValues: The parameter values of this run.
   :throws RegisterException:

ExecutionRun
^^^^^^^^^^^^

.. java:constructor:: protected ExecutionRun(ExecutionRun other) throws RegisterException
   :outertype: ExecutionRun

   Copy constructor for execution runs.

   :param other: The execution run to be cloned.
   :throws RegisterException:

Methods
-------
checkCompatibilityQualityMeasuresDataConfigs
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static void checkCompatibilityQualityMeasuresDataConfigs(List<DataConfig> dataConfigs, List<ClusteringQualityMeasure> qualityMeasures) throws RunException
   :outertype: ExecutionRun

   This method verifies that all quality measures can be calculated for every data configuration. This can be due to the fact, that some quality measures require a goldstandard. If a data configuration does not contain a goldstandard, such quality measures cannot be calculated.

   :param dataConfigs: The data configurations to check.
   :param qualityMeasures: The quality measures to check.
   :throws RunException: An exception that indicates, that some quality measures and data configurations are not compatible.

clone
^^^^^

.. java:method:: @Override public abstract ExecutionRun clone()
   :outertype: ExecutionRun

cloneParameterValues
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected static List<Map<ProgramParameter<?>, String>> cloneParameterValues(List<Map<ProgramParameter<?>, String>> parameterValues)
   :outertype: ExecutionRun

clonePostProcessors
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected static List<RunResultPostprocessor> clonePostProcessors(List<RunResultPostprocessor> postProcessors)
   :outertype: ExecutionRun

createAndScheduleRunnableForResumePair
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunRunnable createAndScheduleRunnableForResumePair(RunSchedulerThread runScheduler, int p)
   :outertype: ExecutionRun

createAndScheduleRunnableForRunPair
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunRunnable createAndScheduleRunnableForRunPair(RunSchedulerThread runScheduler, int p)
   :outertype: ExecutionRun

createRunRunnableFor
^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract ExecutionRunRunnable createRunRunnableFor(RunSchedulerThread runScheduler, Run run, ProgramConfig programConfig, DataConfig dataConfig, String runIdentString, boolean isResume, Map<ProgramParameter<?>, String> runParams)
   :outertype: ExecutionRun

   This is a helper method for the \ :java:ref:`createAndScheduleRunnableForResumePair(RunSchedulerThread,int)`\  and \ :java:ref:`createAndScheduleRunnableForRunPair(RunSchedulerThread,int)`\  methods. This method is responsible to instanciate objects of the corresponding runnable runtime type for the runtime type of this run. Override it in your own sub type of the ExecutionRun class.

   :param runScheduler: The run scheduler to which the newly created runnable should be passed.
   :param run: A reference to a cloned copy of this run that should be executed.
   :param programConfig: The program configuration that is used by the resulting runnable.
   :param dataConfig: The data configuration that is used by the resulting runnable.
   :param runIdentString: The unique run identification string, that identifies this execution of the run.
   :param isResume: A boolean which indicates, whether the created runnable should perform a run or resume one.
   :return: The runnable being executed asynchronously.

getDataConfigs
^^^^^^^^^^^^^^

.. java:method:: public List<DataConfig> getDataConfigs()
   :outertype: ExecutionRun

   :return: A list containing all data configurations of this run.

getMaxExecutionTime
^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getMaxExecutionTime(ProgramConfig pc)
   :outertype: ExecutionRun

getNumberOfRunRunnables
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int getNumberOfRunRunnables()
   :outertype: ExecutionRun

getParameterValues
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Map<ProgramParameter<?>, String>> getParameterValues()
   :outertype: ExecutionRun

   :return: A list of maps containing parameter values. Every entry of the list corresponds to one runpair.

getPostProcessors
^^^^^^^^^^^^^^^^^

.. java:method:: public List<RunResultPostprocessor> getPostProcessors()
   :outertype: ExecutionRun

getProgramConfigs
^^^^^^^^^^^^^^^^^

.. java:method:: public List<ProgramConfig> getProgramConfigs()
   :outertype: ExecutionRun

   :return: A list containing all program configurations of this run.

getQualityMeasures
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ClusteringQualityMeasure> getQualityMeasures()
   :outertype: ExecutionRun

   :return: A list containing all clustering quality measures to be evaluated during execution of this run.

getRunPairs
^^^^^^^^^^^

.. java:method:: public List<Pair<ProgramConfig, DataConfig>> getRunPairs()
   :outertype: ExecutionRun

   :return: The list of runpairs consisting of program and data configurations each.

getRunParameterForRunPair
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected Map<ProgramParameter<? extends Object>, String> getRunParameterForRunPair(int p)
   :outertype: ExecutionRun

getUpperLimitProgress
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected long getUpperLimitProgress()
   :outertype: ExecutionRun

hasMaxExecutionTime
^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean hasMaxExecutionTime(ProgramConfig pc)
   :outertype: ExecutionRun

initRunPairs
^^^^^^^^^^^^

.. java:method:: protected void initRunPairs(List<ProgramConfig> programConfigs, List<DataConfig> dataConfigs) throws RegisterException
   :outertype: ExecutionRun

   For every pair of program and data configuration we create an object and add it to the list of runpairs.

   This method clones the data and program configurations of this execution run, such that only cloned objects are passed to the threads. This ensures, that changes that happen to the configurations during runtime do not affect the runs currently performing.

   :param programConfigs: The list of program configurations of this run.
   :param dataConfigs: The list of data configurations of this run.
   :throws RegisterException:

notify
^^^^^^

.. java:method:: @Override public void notify(RepositoryEvent e) throws RegisterException
   :outertype: ExecutionRun

perform
^^^^^^^

.. java:method:: @Override public void perform(RunSchedulerThread runScheduler) throws IOException, RunRunnableInitializationException, RunInitializationException
   :outertype: ExecutionRun

   This method will perform this run, i.e. it combines every program with every dataset contained in this run's configuration. For every such combination a runnable is performed and the result of this will be added to the list of run results.

   :throws RunRunnableInitializationException:
   :throws RunInitializationException:

resume
^^^^^^

.. java:method:: @SuppressWarnings @Override public void resume(RunSchedulerThread runScheduler, String runIdentString) throws MissingParameterValueException, IOException, NoRunResultFormatParserException, RunRunnableInitializationException, RunInitializationException
   :outertype: ExecutionRun

   This method will resume this run, i.e. it combines every program with every dataset contained in this run's configuration. For every such combination a runnable is performed and the result of this will be added to the list of run results.

   :throws RunRunnableInitializationException:
   :throws RunInitializationException:

terminate
^^^^^^^^^

.. java:method:: @Override public boolean terminate()
   :outertype: ExecutionRun

