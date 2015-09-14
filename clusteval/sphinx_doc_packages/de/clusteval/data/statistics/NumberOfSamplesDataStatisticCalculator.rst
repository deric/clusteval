.. java:import:: java.io File

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

NumberOfSamplesDataStatisticCalculator
======================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class NumberOfSamplesDataStatisticCalculator extends DataStatisticCalculator<NumberOfSamplesDataStatistic>

   :author: Christian Wiwie

Constructors
------------
NumberOfSamplesDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NumberOfSamplesDataStatisticCalculator(Repository repository, long changeDate, File absPath, DataConfig dataConfig) throws RegisterException
   :outertype: NumberOfSamplesDataStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param dataConfig:
   :throws RegisterException:

NumberOfSamplesDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NumberOfSamplesDataStatisticCalculator(NumberOfSamplesDataStatisticCalculator other) throws RegisterException
   :outertype: NumberOfSamplesDataStatisticCalculator

   The copy constructor for this statistic calculator.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected NumberOfSamplesDataStatistic calculateResult() throws DataStatisticCalculateException
   :outertype: NumberOfSamplesDataStatisticCalculator

writeOutputTo
^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public void writeOutputTo(File absFolderPath)
   :outertype: NumberOfSamplesDataStatisticCalculator

