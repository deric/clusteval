.. java:import:: java.io File

.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

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

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: file FileUtils

IntraInterDistributionDataStatisticCalculator
=============================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class IntraInterDistributionDataStatisticCalculator extends DataStatisticCalculator<IntraInterDistributionDataStatistic>

   :author: Christian Wiwie

Constructors
------------
IntraInterDistributionDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public IntraInterDistributionDataStatisticCalculator(Repository repository, long changeDate, File absPath, DataConfig dataConfig) throws RegisterException
   :outertype: IntraInterDistributionDataStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param dataConfig:
   :throws RegisterException:

IntraInterDistributionDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public IntraInterDistributionDataStatisticCalculator(IntraInterDistributionDataStatisticCalculator other) throws RegisterException
   :outertype: IntraInterDistributionDataStatisticCalculator

   The copy constructor for this statistic calculator.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected IntraInterDistributionDataStatistic calculateResult() throws DataStatisticCalculateException
   :outertype: IntraInterDistributionDataStatisticCalculator

writeOutputTo
^^^^^^^^^^^^^

.. java:method:: @Override public void writeOutputTo(File absFolderPath) throws InterruptedException
   :outertype: IntraInterDistributionDataStatisticCalculator

