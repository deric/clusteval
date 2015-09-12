.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: utils Triple

.. java:import:: de.clusteval.cluster.paramOptimization IDivergingParameterOptimizationMethod

.. java:import:: de.clusteval.cluster.paramOptimization NoParameterSetFoundException

.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationException

.. java:import:: de.clusteval.cluster.paramOptimization ParameterOptimizationMethod

.. java:import:: de.clusteval.cluster.paramOptimization ParameterSetAlreadyEvaluatedException

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasureValue

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset.format IncompatibleDataSetFormatException

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.goldstandard IncompleteGoldStandardException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.run ParameterOptimizationRun

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run.result ParameterOptimizationResult

.. java:import:: de.clusteval.run.result RunResultParseException

.. java:import:: de.clusteval.utils InternalAttributeException

.. java:import:: de.clusteval.utils.plot Plotter

.. java:import:: file FileUtils

ParameterOptimizationRunRunnable
================================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public class ParameterOptimizationRunRunnable extends ExecutionRunRunnable

   A type of an execution runnable, that corresponds to \ :java:ref:`ParameterOptimizationRun`\ s and is therefore responsible for performing several clusterings iteratively.

   In \ :java:ref:`doRun()`\  the optimization method \ :java:ref:`optimizationMethod`\  determines, how many iterations are to be performed.

   :author: Christian Wiwie

Fields
------
lastConsumedParamSet
^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected ParameterSet lastConsumedParamSet
   :outertype: ParameterOptimizationRunRunnable

   A temporary variable holding the last consumed parameter set for the next iteration.

optimizationMethod
^^^^^^^^^^^^^^^^^^

.. java:field:: protected ParameterOptimizationMethod optimizationMethod
   :outertype: ParameterOptimizationRunRunnable

   This attribute is set to some instance of an parameter optimization method, that will determine the sequence of parameter sets during the optimization process.

Constructors
------------
ParameterOptimizationRunRunnable
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterOptimizationRunRunnable(RunSchedulerThread runScheduler, Run run, ProgramConfig programConfig, DataConfig dataConfig, ParameterOptimizationMethod optimizationMethod, String runIdentString, boolean isResume, Map<ProgramParameter<?>, String> runParams)
   :outertype: ParameterOptimizationRunRunnable

   :param runScheduler: The run scheduler that the newly created runnable should be passed to and executed by.
   :param run: The run this runnable belongs to.
   :param runIdentString: The unique identification string of the run which is used to store the results in a unique folder to avoid overwriting.
   :param programConfig: The program configuration encapsulating the program executed by this runnable.
   :param dataConfig: The data configuration used by this runnable.
   :param optimizationMethod: The optimization method which determines the parameter sets during the optimization process and stores the results.
   :param isResume: True, if this run is a resumption of a previous execution or a completely new execution.

Methods
-------
afterRun
^^^^^^^^

.. java:method:: @Override protected void afterRun() throws InterruptedException
   :outertype: ParameterOptimizationRunRunnable

beforeRun
^^^^^^^^^

.. java:method:: @Override protected void beforeRun() throws IllegalArgumentException, UnknownDataSetFormatException, IOException, InvalidDataSetFormatVersionException, RegisterException, InternalAttributeException, IncompatibleDataSetFormatException, UnknownGoldStandardFormatException, IncompleteGoldStandardException, InterruptedException
   :outertype: ParameterOptimizationRunRunnable

consumeNextIteration
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int consumeNextIteration() throws RunIterationException
   :outertype: ParameterOptimizationRunRunnable

decorateIterationWrapper
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void decorateIterationWrapper(ExecutionIterationWrapper iterationWrapper, int currentPos) throws RunIterationException
   :outertype: ParameterOptimizationRunRunnable

doRun
^^^^^

.. java:method:: @Override protected void doRun() throws RunIterationException
   :outertype: ParameterOptimizationRunRunnable

doRunIteration
^^^^^^^^^^^^^^

.. java:method:: @Override protected void doRunIteration(ExecutionIterationWrapper iterationWrapper) throws RunIterationException
   :outertype: ParameterOptimizationRunRunnable

getOptimizationMethod
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public ParameterOptimizationMethod getOptimizationMethod()
   :outertype: ParameterOptimizationRunRunnable

   :return: Get the optimization method of this parameter optimization run runnable.

   **See also:** :java:ref:`.optimizationMethod`

handleMissingRunResult
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void handleMissingRunResult(ExecutionIterationWrapper iterationWrapper)
   :outertype: ParameterOptimizationRunRunnable

hasNextIteration
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean hasNextIteration()
   :outertype: ParameterOptimizationRunRunnable

parseOptimizationParameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected String[] parseOptimizationParameters(String[] invocation, Map<String, String> effectiveParams)
   :outertype: ParameterOptimizationRunRunnable

   This method replaces the optimization parameters with the values given in the run configuration.

replaceRunParameters
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String[] replaceRunParameters(String[] invocation, Map<String, String> effectiveParams) throws InternalAttributeException, RegisterException, NoParameterSetFoundException
   :outertype: ParameterOptimizationRunRunnable

writeQualitiesToFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void writeQualitiesToFile(List<Triple<ParameterSet, ClusteringQualitySet, Long>> qualities)
   :outertype: ParameterOptimizationRunRunnable

