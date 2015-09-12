.. java:import:: java.io File

.. java:import:: java.lang.reflect Constructor

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.run.statistics RunStatistic

.. java:import:: de.clusteval.run.statistics RunStatisticCalculator

.. java:import:: de.clusteval.utils StatisticCalculator

.. java:import:: file FileUtils

RunAnalysisIterationRunnable
============================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public class RunAnalysisIterationRunnable extends AnalysisIterationRunnable<RunStatistic, RunAnalysisIterationWrapper>

   :author: Christian Wiwie

Constructors
------------
RunAnalysisIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunAnalysisIterationRunnable(RunAnalysisIterationWrapper iterationWrapper)
   :outertype: RunAnalysisIterationRunnable

   :param iterationWrapper:

Methods
-------
beforeStatisticCalculate
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void beforeStatisticCalculate()
   :outertype: RunAnalysisIterationRunnable

getOutputPath
^^^^^^^^^^^^^

.. java:method:: @Override protected String getOutputPath()
   :outertype: RunAnalysisIterationRunnable

getRunIdentifier
^^^^^^^^^^^^^^^^

.. java:method:: public String getRunIdentifier()
   :outertype: RunAnalysisIterationRunnable

getStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected StatisticCalculator<RunStatistic> getStatisticCalculator() throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
   :outertype: RunAnalysisIterationRunnable

