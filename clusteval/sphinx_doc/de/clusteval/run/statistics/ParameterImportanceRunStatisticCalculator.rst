.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: utils ArraysExt

.. java:import:: utils Pair

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasureValue

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

.. java:import:: de.clusteval.data.statistics RunStatisticCalculateException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.run.result ParameterOptimizationResult

.. java:import:: de.clusteval.run.result RunResult

.. java:import:: file FileUtils

ParameterImportanceRunStatisticCalculator
=========================================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public class ParameterImportanceRunStatisticCalculator extends RunStatisticCalculator<ParameterImportanceRunStatistic>

   :author: Christian Wiwie

Constructors
------------
ParameterImportanceRunStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterImportanceRunStatisticCalculator(Repository repository, long changeDate, File absPath, String uniqueRunIdentifier) throws RegisterException
   :outertype: ParameterImportanceRunStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param uniqueRunIdentifier:
   :throws RegisterException:

ParameterImportanceRunStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ParameterImportanceRunStatisticCalculator(ParameterImportanceRunStatisticCalculator other) throws RegisterException
   :outertype: ParameterImportanceRunStatisticCalculator

   The copy constructor for this statistic calculator.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected ParameterImportanceRunStatistic calculateResult() throws RunStatisticCalculateException
   :outertype: ParameterImportanceRunStatisticCalculator

getStatistic
^^^^^^^^^^^^

.. java:method:: @Override public ParameterImportanceRunStatistic getStatistic()
   :outertype: ParameterImportanceRunStatisticCalculator

writeOutputTo
^^^^^^^^^^^^^

.. java:method:: @Override public void writeOutputTo(File absFolderPath)
   :outertype: ParameterImportanceRunStatisticCalculator

