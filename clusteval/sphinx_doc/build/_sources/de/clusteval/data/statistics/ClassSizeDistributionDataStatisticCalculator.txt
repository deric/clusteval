.. java:import:: java.io File

.. java:import:: java.util Iterator

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: de.clusteval.cluster Cluster

.. java:import:: de.clusteval.cluster ClusterItem

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.data.goldstandard GoldStandard

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

ClassSizeDistributionDataStatisticCalculator
============================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class ClassSizeDistributionDataStatisticCalculator extends DataStatisticCalculator<ClassSizeDistributionDataStatistic>

   :author: Christian Wiwie

Constructors
------------
ClassSizeDistributionDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClassSizeDistributionDataStatisticCalculator(Repository repository, long changeDate, File absPath, DataConfig dataConfig) throws RegisterException
   :outertype: ClassSizeDistributionDataStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param dataConfig:
   :throws RegisterException:

ClassSizeDistributionDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClassSizeDistributionDataStatisticCalculator(ClassSizeDistributionDataStatisticCalculator other) throws RegisterException
   :outertype: ClassSizeDistributionDataStatisticCalculator

   The copy constructor for this statistic calculator.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected ClassSizeDistributionDataStatistic calculateResult() throws DataStatisticCalculateException
   :outertype: ClassSizeDistributionDataStatisticCalculator

writeOutputTo
^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public void writeOutputTo(File absFolderPath)
   :outertype: ClassSizeDistributionDataStatisticCalculator

