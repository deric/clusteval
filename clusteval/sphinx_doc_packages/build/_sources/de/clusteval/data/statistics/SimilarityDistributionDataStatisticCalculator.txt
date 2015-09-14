.. java:import:: java.io File

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: utils ArraysExt

.. java:import:: utils Pair

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset.format RelativeDataSetFormat

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: file FileUtils

SimilarityDistributionDataStatisticCalculator
=============================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class SimilarityDistributionDataStatisticCalculator extends DataStatisticCalculator<SimilarityDistributionDataStatistic>

   :author: Christian Wiwie

Constructors
------------
SimilarityDistributionDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SimilarityDistributionDataStatisticCalculator(Repository repository, long changeDate, File absPath, DataConfig dataConfig) throws RegisterException
   :outertype: SimilarityDistributionDataStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param dataConfig:
   :throws RegisterException:

SimilarityDistributionDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SimilarityDistributionDataStatisticCalculator(SimilarityDistributionDataStatisticCalculator other) throws RegisterException
   :outertype: SimilarityDistributionDataStatisticCalculator

   The copy constructor for this statistic calculator.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected SimilarityDistributionDataStatistic calculateResult() throws DataStatisticCalculateException
   :outertype: SimilarityDistributionDataStatisticCalculator

writeOutputTo
^^^^^^^^^^^^^

.. java:method:: @Override public void writeOutputTo(File absFolderPath) throws InterruptedException
   :outertype: SimilarityDistributionDataStatisticCalculator

