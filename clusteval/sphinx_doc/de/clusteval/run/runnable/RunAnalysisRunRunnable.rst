.. java:import:: java.io File

.. java:import:: java.util List

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run RunAnalysisRun

.. java:import:: de.clusteval.run.result RunAnalysisRunResult

.. java:import:: de.clusteval.run.statistics RunStatistic

RunAnalysisRunRunnable
======================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public class RunAnalysisRunRunnable extends AnalysisRunRunnable<RunStatistic, RunAnalysisRunResult, RunAnalysisIterationWrapper, RunAnalysisIterationRunnable>

   A type of analysis runnable, that corresponds to \ :java:ref:`RunAnalysisRun`\  and is responsible for analysing a run result.

   :author: Christian Wiwie

Fields
------
currentIteration
^^^^^^^^^^^^^^^^

.. java:field:: protected int currentIteration
   :outertype: RunAnalysisRunRunnable

uniqueRunAnalysisRunIdentifier
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected String uniqueRunAnalysisRunIdentifier
   :outertype: RunAnalysisRunRunnable

   The unique identifier of a run result run identifier.

Constructors
------------
RunAnalysisRunRunnable
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunAnalysisRunRunnable(RunSchedulerThread runScheduler, Run run, String runIdentString, boolean isResume, String uniqueRunIdentifier, List<RunStatistic> statistics)
   :outertype: RunAnalysisRunRunnable

   :param runScheduler: The run scheduler that the newly created runnable should be passed to and executed by.
   :param run: The run this runnable belongs to.
   :param runIdentString: The unique identification string of the run which is used to store the results in a unique folder to avoid overwriting.
   :param uniqueRunIdentifier: The unique identifier of a run result run identifier.
   :param statistics: The statistics that should be assessed during execution of this runnable.
   :param isResume: True, if this run is a resumption of a previous execution or a completely new execution.

Methods
-------
afterRun
^^^^^^^^

.. java:method:: @Override public void afterRun()
   :outertype: RunAnalysisRunRunnable

consumeNextIteration
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int consumeNextIteration() throws RunIterationException
   :outertype: RunAnalysisRunRunnable

createIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunAnalysisIterationRunnable createIterationRunnable(RunAnalysisIterationWrapper iterationWrapper)
   :outertype: RunAnalysisRunRunnable

createIterationWrapper
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunAnalysisIterationWrapper createIterationWrapper()
   :outertype: RunAnalysisRunRunnable

createRunResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunAnalysisRunResult createRunResult() throws RegisterException
   :outertype: RunAnalysisRunRunnable

doRunIteration
^^^^^^^^^^^^^^

.. java:method:: @Override protected void doRunIteration(RunAnalysisIterationWrapper iterationWrapper) throws RunIterationException
   :outertype: RunAnalysisRunRunnable

getRunIdentifier
^^^^^^^^^^^^^^^^

.. java:method:: public String getRunIdentifier()
   :outertype: RunAnalysisRunRunnable

hasNextIteration
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean hasNextIteration()
   :outertype: RunAnalysisRunRunnable

