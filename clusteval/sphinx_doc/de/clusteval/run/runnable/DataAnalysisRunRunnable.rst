.. java:import:: java.io File

.. java:import:: java.util List

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.run DataAnalysisRun

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.run.result DataAnalysisRunResult

DataAnalysisRunRunnable
=======================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public class DataAnalysisRunRunnable extends AnalysisRunRunnable<DataStatistic, DataAnalysisRunResult, DataAnalysisIterationWrapper, DataAnalysisIterationRunnable>

   A type of analysis runnable, that corresponds to \ :java:ref:`DataAnalysisRun`\  and is responsible for analysing a data configuration (dataset and goldstandard).

   :author: Christian Wiwie

Fields
------
currentIteration
^^^^^^^^^^^^^^^^

.. java:field:: protected int currentIteration
   :outertype: DataAnalysisRunRunnable

dataConfig
^^^^^^^^^^

.. java:field:: protected DataConfig dataConfig
   :outertype: DataAnalysisRunRunnable

   The data configuration to be analysed by this runnable.

Constructors
------------
DataAnalysisRunRunnable
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataAnalysisRunRunnable(RunSchedulerThread runScheduler, Run run, String runIdentString, boolean isResume, DataConfig dataConfig, List<DataStatistic> statistics)
   :outertype: DataAnalysisRunRunnable

   :param runScheduler: The run scheduler that the newly created runnable should be passed to and executed by.
   :param run: The run this runnable belongs to.
   :param runIdentString: The unique identification string of the run which is used to store the results in a unique folder to avoid overwriting.
   :param dataConfig: The data configuration to be analysed by this runnable.
   :param statistics: The statistics that should be assessed during execution of this runnable.
   :param isResume: True, if this run is a resumption of a previous execution or a completely new execution.

Methods
-------
afterRun
^^^^^^^^

.. java:method:: @Override public void afterRun()
   :outertype: DataAnalysisRunRunnable

beforeRun
^^^^^^^^^

.. java:method:: @Override public void beforeRun()
   :outertype: DataAnalysisRunRunnable

consumeNextIteration
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected int consumeNextIteration() throws RunIterationException
   :outertype: DataAnalysisRunRunnable

createIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataAnalysisIterationRunnable createIterationRunnable(DataAnalysisIterationWrapper iterationWrapper)
   :outertype: DataAnalysisRunRunnable

createIterationWrapper
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataAnalysisIterationWrapper createIterationWrapper()
   :outertype: DataAnalysisRunRunnable

createRunResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataAnalysisRunResult createRunResult() throws RegisterException
   :outertype: DataAnalysisRunRunnable

decorateIterationWrapper
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void decorateIterationWrapper(DataAnalysisIterationWrapper iterationWrapper, int currentPos) throws RunIterationException
   :outertype: DataAnalysisRunRunnable

doRunIteration
^^^^^^^^^^^^^^

.. java:method:: @Override protected void doRunIteration(DataAnalysisIterationWrapper iterationWrapper) throws RunIterationException
   :outertype: DataAnalysisRunRunnable

getDataConfig
^^^^^^^^^^^^^

.. java:method:: public DataConfig getDataConfig()
   :outertype: DataAnalysisRunRunnable

hasNextIteration
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean hasNextIteration()
   :outertype: DataAnalysisRunRunnable

