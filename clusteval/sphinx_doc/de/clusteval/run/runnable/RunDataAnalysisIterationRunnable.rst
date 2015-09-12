.. java:import:: java.io File

.. java:import:: java.lang.reflect Constructor

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util List

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.run.statistics RunDataStatistic

.. java:import:: de.clusteval.run.statistics RunDataStatisticCalculator

.. java:import:: de.clusteval.utils StatisticCalculator

.. java:import:: file FileUtils

RunDataAnalysisIterationRunnable
================================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public class RunDataAnalysisIterationRunnable extends AnalysisIterationRunnable<RunDataStatistic, RunDataAnalysisIterationWrapper>

   :author: Christian Wiwie

Constructors
------------
RunDataAnalysisIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunDataAnalysisIterationRunnable(RunDataAnalysisIterationWrapper iterationWrapper)
   :outertype: RunDataAnalysisIterationRunnable

   :param iterationWrapper:

Methods
-------
beforeStatisticCalculate
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void beforeStatisticCalculate()
   :outertype: RunDataAnalysisIterationRunnable

getDataAnalysisIdentifier
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getDataAnalysisIdentifier()
   :outertype: RunDataAnalysisIterationRunnable

getOutputPath
^^^^^^^^^^^^^

.. java:method:: @Override protected String getOutputPath()
   :outertype: RunDataAnalysisIterationRunnable

getRunIdentifier
^^^^^^^^^^^^^^^^

.. java:method:: public String getRunIdentifier()
   :outertype: RunDataAnalysisIterationRunnable

getStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected StatisticCalculator<RunDataStatistic> getStatisticCalculator() throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
   :outertype: RunDataAnalysisIterationRunnable

