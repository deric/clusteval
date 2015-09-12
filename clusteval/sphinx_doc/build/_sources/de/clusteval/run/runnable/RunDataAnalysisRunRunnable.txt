.. java:import:: java.io File

.. java:import:: java.util List

.. java:import:: utils Pair

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run RunDataAnalysisRun

.. java:import:: de.clusteval.run.result RunDataAnalysisRunResult

.. java:import:: de.clusteval.run.statistics RunDataStatistic

RunDataAnalysisRunRunnable
==========================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public class RunDataAnalysisRunRunnable extends AnalysisRunRunnable<RunDataStatistic, RunDataAnalysisRunResult, RunDataAnalysisIterationWrapper, RunDataAnalysisIterationRunnable>

   A type of analysis runnable, that corresponds to \ :java:ref:`RunDataAnalysisRun`\  and is responsible for analysing a run result together with a data analysis result.

   :author: Christian Wiwie

Fields
------
currentIteration
^^^^^^^^^^^^^^^^

.. java:field:: protected int currentIteration
   :outertype: RunDataAnalysisRunRunnable

uniqueDataAnalysisRunIdentifier
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<String> uniqueDataAnalysisRunIdentifier
   :outertype: RunDataAnalysisRunRunnable

   The identifiers of data analysis run results.

uniqueRunAnalysisRunIdentifier
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<String> uniqueRunAnalysisRunIdentifier
   :outertype: RunDataAnalysisRunRunnable

   The identifiers of run analysis run results.

Constructors
------------
RunDataAnalysisRunRunnable
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataAnalysisRunRunnable(RunSchedulerThread runScheduler, Run run, String runIdentString, boolean isResume, List<String> uniqueRunAnalysisRunIdentifier, List<String> uniqueDataAnalysisRunIdentifier, List<RunDataStatistic> statistics)
   :outertype: RunDataAnalysisRunRunnable

   :param runScheduler: The run scheduler that the newly created runnable should be passed to and executed by.
   :param run: The run this runnable belongs to.
   :param runIdentString: The unique identification string of the run which is used to store the results in a unique folder to avoid overwriting.
   :param uniqueRunAnalysisRunIdentifier: The identifiers of run analysis run results.
   :param uniqueDataAnalysisRunIdentifier: The identifiers of data analysis run results.
   :param statistics: The statistics that should be assessed during execution of this runnable.
   :param isResume: True, if this run is a resumption of a previous execution or a completely new execution.

Methods
-------
afterRun
^^^^^^^^

.. java:method:: @Override public void afterRun()
   :outertype: RunDataAnalysisRunRunnable

consumeNextIteration
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int consumeNextIteration() throws RunIterationException
   :outertype: RunDataAnalysisRunRunnable

createIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunDataAnalysisIterationRunnable createIterationRunnable(RunDataAnalysisIterationWrapper iterationWrapper)
   :outertype: RunDataAnalysisRunRunnable

createIterationWrapper
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunDataAnalysisIterationWrapper createIterationWrapper()
   :outertype: RunDataAnalysisRunRunnable

createRunResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunDataAnalysisRunResult createRunResult() throws RegisterException
   :outertype: RunDataAnalysisRunRunnable

doRunIteration
^^^^^^^^^^^^^^

.. java:method:: @Override protected void doRunIteration(RunDataAnalysisIterationWrapper iterationWrapper) throws RunIterationException
   :outertype: RunDataAnalysisRunRunnable

hasNextIteration
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean hasNextIteration()
   :outertype: RunDataAnalysisRunRunnable

