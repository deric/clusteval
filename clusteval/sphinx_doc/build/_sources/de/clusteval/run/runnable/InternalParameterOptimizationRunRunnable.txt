.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util Map

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset.format IncompatibleDataSetFormatException

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.goldstandard IncompleteGoldStandardException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.program ProgramConfig

.. java:import:: de.clusteval.program ProgramParameter

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.utils InternalAttributeException

InternalParameterOptimizationRunRunnable
========================================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public class InternalParameterOptimizationRunRunnable extends ExecutionRunRunnable

   :author: Christian Wiwie

Fields
------
hasNext
^^^^^^^

.. java:field:: protected boolean hasNext
   :outertype: InternalParameterOptimizationRunRunnable

Constructors
------------
InternalParameterOptimizationRunRunnable
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public InternalParameterOptimizationRunRunnable(RunSchedulerThread runScheduler, Run run, ProgramConfig programConfig, DataConfig dataConfig, String runIdentString, boolean isResume, Map<ProgramParameter<?>, String> runParams)
   :outertype: InternalParameterOptimizationRunRunnable

   :param runScheduler:
   :param run:
   :param programConfig:
   :param dataConfig:
   :param runIdentString:
   :param isResume:

Methods
-------
beforeRun
^^^^^^^^^

.. java:method:: @Override protected void beforeRun() throws IllegalArgumentException, UnknownDataSetFormatException, IOException, InvalidDataSetFormatVersionException, RegisterException, InternalAttributeException, IncompatibleDataSetFormatException, UnknownGoldStandardFormatException, IncompleteGoldStandardException, InterruptedException
   :outertype: InternalParameterOptimizationRunRunnable

consumeNextIteration
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int consumeNextIteration() throws RunIterationException
   :outertype: InternalParameterOptimizationRunRunnable

decorateIterationWrapper
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void decorateIterationWrapper(ExecutionIterationWrapper iterationWrapper, int currentPos) throws RunIterationException
   :outertype: InternalParameterOptimizationRunRunnable

getInvocationFormat
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getInvocationFormat()
   :outertype: InternalParameterOptimizationRunRunnable

handleMissingRunResult
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void handleMissingRunResult(ExecutionIterationWrapper iterationWrapper)
   :outertype: InternalParameterOptimizationRunRunnable

hasNextIteration
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean hasNextIteration()
   :outertype: InternalParameterOptimizationRunRunnable

