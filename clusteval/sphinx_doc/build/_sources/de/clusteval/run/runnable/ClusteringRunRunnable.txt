.. java:import:: java.io BufferedReader

.. java:import:: java.io File

.. java:import:: java.io FileReader

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

.. java:import:: de.clusteval.run ClusteringRun

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run.result ClusteringRunResult

.. java:import:: de.clusteval.utils InternalAttributeException

ClusteringRunRunnable
=====================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public class ClusteringRunRunnable extends ExecutionRunRunnable

   A type of an execution runnable, that corresponds to \ :java:ref:`ClusteringRun`\  and is therefore responsible for performing only a single clustering.

   In \ :java:ref:`doRun()`\  a ClusteringRunRunnable executes only a single iteration.

   :author: Christian Wiwie

Fields
------
finished
^^^^^^^^

.. java:field:: protected boolean finished
   :outertype: ClusteringRunRunnable

hasNext
^^^^^^^

.. java:field:: protected boolean hasNext
   :outertype: ClusteringRunRunnable

Constructors
------------
ClusteringRunRunnable
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringRunRunnable(RunSchedulerThread runScheduler, Run run, ProgramConfig programConfig, DataConfig dataConfig, String runIdentString, boolean isResume, Map<ProgramParameter<?>, String> runParams)
   :outertype: ClusteringRunRunnable

   :param runScheduler: The run scheduler that the newly created runnable should be passed to and executed by.
   :param run: The run this runnable belongs to.
   :param runIdentString: The unique identification string of the run which is used to store the results in a unique folder to avoid overwriting.
   :param programConfig: The program configuration encapsulating the program executed by this runnable.
   :param dataConfig: The data configuration used by this runnable.
   :param isResume: True, if this run is a resumption of a previous execution or a completely new execution.

Methods
-------
beforeRun
^^^^^^^^^

.. java:method:: @Override protected void beforeRun() throws IllegalArgumentException, UnknownDataSetFormatException, IOException, InvalidDataSetFormatVersionException, RegisterException, InternalAttributeException, IncompatibleDataSetFormatException, UnknownGoldStandardFormatException, IncompleteGoldStandardException, InterruptedException
   :outertype: ClusteringRunRunnable

consumeNextIteration
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int consumeNextIteration()
   :outertype: ClusteringRunRunnable

decorateIterationWrapper
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void decorateIterationWrapper(ExecutionIterationWrapper iterationWrapper, int currentPos) throws RunIterationException
   :outertype: ClusteringRunRunnable

handleMissingRunResult
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void handleMissingRunResult(ExecutionIterationWrapper iterationWrapper)
   :outertype: ClusteringRunRunnable

hasNextIteration
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean hasNextIteration()
   :outertype: ClusteringRunRunnable

