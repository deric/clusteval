.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: org.rosuda REngine.REXP

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: utils ArraysExt

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

ClusteringCoefficientDataStatisticCalculator
============================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class ClusteringCoefficientDataStatisticCalculator extends DataStatisticCalculator<ClusteringCoefficientDataStatistic>

   :author: Christian Wiwie

Constructors
------------
ClusteringCoefficientDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringCoefficientDataStatisticCalculator(Repository repository, long changeDate, File absPath, DataConfig dataConfig) throws RegisterException
   :outertype: ClusteringCoefficientDataStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param dataConfig:
   :throws RegisterException:

ClusteringCoefficientDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringCoefficientDataStatisticCalculator(ClusteringCoefficientDataStatisticCalculator other) throws RegisterException
   :outertype: ClusteringCoefficientDataStatisticCalculator

   The copy constructor for this statistic calculator.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected ClusteringCoefficientDataStatistic calculateResult() throws DataStatisticCalculateException
   :outertype: ClusteringCoefficientDataStatisticCalculator

writeOutputTo
^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public void writeOutputTo(File absFolderPath)
   :outertype: ClusteringCoefficientDataStatisticCalculator

