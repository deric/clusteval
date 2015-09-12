.. java:import:: java.io File

.. java:import:: java.lang.reflect Constructor

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.data.statistics DataStatisticCalculator

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils StatisticCalculator

.. java:import:: file FileUtils

DataAnalysisIterationRunnable
=============================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public class DataAnalysisIterationRunnable extends AnalysisIterationRunnable<DataStatistic, DataAnalysisIterationWrapper>

   :author: Christian Wiwie

Constructors
------------
DataAnalysisIterationRunnable
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataAnalysisIterationRunnable(DataAnalysisIterationWrapper iterationWrapper)
   :outertype: DataAnalysisIterationRunnable

   :param iterationWrapper:

Methods
-------
beforeStatisticCalculate
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected void beforeStatisticCalculate()
   :outertype: DataAnalysisIterationRunnable

getDataConfig
^^^^^^^^^^^^^

.. java:method:: public DataConfig getDataConfig()
   :outertype: DataAnalysisIterationRunnable

getOutputPath
^^^^^^^^^^^^^

.. java:method:: @Override protected String getOutputPath()
   :outertype: DataAnalysisIterationRunnable

getStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected StatisticCalculator<DataStatistic> getStatisticCalculator() throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
   :outertype: DataAnalysisIterationRunnable

