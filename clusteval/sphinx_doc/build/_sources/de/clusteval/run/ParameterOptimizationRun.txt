.. java:import:: java.io File

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: utils Pair

.. java:import:: de.clusteval.cluster.paramOptimization IncompatibleParameterOptimizationMethodException

.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethod

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

.. java:import:: de.clusteval.context Context

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset.format AbsoluteDataSetFormat

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryEvent

.. java:import:: de.clusteval.framework.repository RepositoryRemoveEvent

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.run.result ParameterOptimizationResult

.. java:import:: de.clusteval.run.result.postprocessing RunResultPostprocessor

.. java:import:: de.clusteval.run.runnable ExecutionRunRunnable

.. java:import:: de.clusteval.run.runnable ParameterOptimizationRunRunnable

.. java:import:: de.clusteval.run.runnable RunRunnable

ParameterOptimizationRun
========================

.. java:package:: de.clusteval.run
   :noindex:

.. java:type:: public class ParameterOptimizationRun extends ExecutionRun

   A type of execution run that performs several clusterings with different parameter sets determined in an automatized way for every pair of program and data configuration.

   The evaluated parameter sets during a parameter optimization for one pair of program and data configuration are determined by the corresponding \ :java:ref:`ParameterOptimizationMethod`\  stored in \ :java:ref:`optimizationMethods`\ .

   Every evaluated parameter set is stored in the \ :java:ref:`optimizationParameters`\  attribute, such that evaluation of the results is possible after termination of the run.

   The results of the clusterings evaluated for every parameter set are also stored in the \ :java:ref:`ParameterOptimizationMethod`\  object.

   :author: Christian Wiwie

Fields
------
optimizationMethods
^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<ParameterOptimizationMethod> optimizationMethods
   :outertype: ParameterOptimizationRun

   This list holds the parameter optimization methods for every pair of program and data configuration. These method objects control and keep track of the parameter sets and the results.

optimizationParameters
^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<List<ProgramParameter<?>>> optimizationParameters
   :outertype: ParameterOptimizationRun

   This list holds another list of optimization parameters for every program configuration. These optimization parameters are to be optimized by this run.

Constructors
------------
ParameterOptimizationRun
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterOptimizationRun(Repository repository, Context context, long changeDate, File absPath, List<ProgramConfig> programConfigs, List<DataConfig> dataConfigs, List<ClusteringQualityMeasure> qualityMeasures, List<Map<ProgramParameter<?>, String>> parameterValues, List<List<ProgramParameter<?>>> optimizationParameters, List<ParameterOptimizationMethod> optimizationMethods, List<RunResultPostprocessor> postProcessors, Map<String, Integer> maxExecutionTimes) throws RegisterException
   :outertype: ParameterOptimizationRun

   New objects of this type are automatically registered at the repository.

   :param repository: the repository
   :param context:
   :param changeDate: The date this run was performed.
   :param absPath: The absolute path to the file on the filesystem that corresponds to this run.
   :param programConfigs: The program configurations of the new run.
   :param dataConfigs: The data configurations of the new run.
   :param qualityMeasures: The clustering quality measures of the new run.
   :param parameterValues: The parameter values of this run.
   :param optimizationParameters: The parameters that are to be optimized during this run.
   :param optimizationMethods: The parameter optimization methods determines which parameter sets are to be evaluated and stores the results.
   :throws RegisterException:

ParameterOptimizationRun
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: protected ParameterOptimizationRun(ParameterOptimizationRun otherRun) throws RegisterException
   :outertype: ParameterOptimizationRun

   Copy constructor of parameter optimization runs.

   :param otherRun: The parameter optimization run to be cloned.
   :throws RegisterException:

Methods
-------
checkCompatibilityParameterOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static void checkCompatibilityParameterOptimizationMethod(List<ParameterOptimizationMethod> optimizationMethods, List<ProgramConfig> programConfigs, List<DataConfig> dataConfigs) throws IncompatibleParameterOptimizationMethodException
   :outertype: ParameterOptimizationRun

   This method verifies compatibility between a parameter optimization method, the data input format and the program configuration.

   Some parameter optimization do only work for certain programs, e.g. \ :java:ref:`GapStatisticParameterOptimizationMethod`\  works only for \ :java:ref:`KMeansClusteringRProgram`\  and \ :java:ref:`AbsoluteDataSetFormat`\ .

   :param dataConfigs:
   :param programConfigs:
   :param optimizationMethods:
   :throws IncompatibleParameterOptimizationMethodException:

clone
^^^^^

.. java:method:: @Override public ParameterOptimizationRun clone()
   :outertype: ParameterOptimizationRun

createRunRunnableFor
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected ExecutionRunRunnable createRunRunnableFor(RunSchedulerThread runScheduler, Run run, ProgramConfig programConfig, DataConfig dataConfig, String runIdentString, boolean isResume, Map<ProgramParameter<?>, String> runParams)
   :outertype: ParameterOptimizationRun

getOptimizationMethods
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ParameterOptimizationMethod> getOptimizationMethods()
   :outertype: ParameterOptimizationRun

   :return: A list with optimization methods. One method for every program.

   **See also:** :java:ref:`.optimizationMethods`

getOptimizationParameters
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<List<ProgramParameter<?>>> getOptimizationParameters()
   :outertype: ParameterOptimizationRun

   :return: A list of parameter lists for every program configuration, that are to be optimized.

   **See also:** :java:ref:`.optimizationParameters`

getOptimizationStatus
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Map<Pair<String, String>, Pair<Double, Map<String, Pair<Map<String, String>, String>>>> getOptimizationStatus()
   :outertype: ParameterOptimizationRun

notify
^^^^^^

.. java:method:: @Override public void notify(RepositoryEvent e) throws RegisterException
   :outertype: ParameterOptimizationRun

