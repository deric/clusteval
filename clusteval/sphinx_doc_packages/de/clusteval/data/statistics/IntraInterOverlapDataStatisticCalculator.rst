.. java:import:: java.io File

.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: utils ArraysExt

.. java:import:: utils Pair

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.cluster Cluster

.. java:import:: de.clusteval.cluster ClusterItem

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset.format RelativeDataSetFormat

.. java:import:: de.clusteval.data.goldstandard GoldStandard

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

IntraInterOverlapDataStatisticCalculator
========================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class IntraInterOverlapDataStatisticCalculator extends DataStatisticCalculator<IntraInterOverlapDataStatistic>

   :author: Christian Wiwie

Constructors
------------
IntraInterOverlapDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public IntraInterOverlapDataStatisticCalculator(Repository repository, long changeDate, File absPath, DataConfig dataConfig) throws RegisterException
   :outertype: IntraInterOverlapDataStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param dataConfig:
   :throws RegisterException:

IntraInterOverlapDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public IntraInterOverlapDataStatisticCalculator(IntraInterOverlapDataStatisticCalculator other) throws RegisterException
   :outertype: IntraInterOverlapDataStatisticCalculator

   The copy constructor for this statistic calculator.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected IntraInterOverlapDataStatistic calculateResult() throws DataStatisticCalculateException
   :outertype: IntraInterOverlapDataStatisticCalculator

writeOutputTo
^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public void writeOutputTo(File absFolderPath)
   :outertype: IntraInterOverlapDataStatisticCalculator

