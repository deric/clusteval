.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: org.rosuda REngine.REXP

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

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

MatrixRankRDataStatisticCalculator
==================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class MatrixRankRDataStatisticCalculator extends DataStatisticRCalculator<MatrixRankRDataStatistic>

   :author: Christian Wiwie

Constructors
------------
MatrixRankRDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MatrixRankRDataStatisticCalculator(Repository repository, long changeDate, File absPath, DataConfig dataConfig) throws RegisterException
   :outertype: MatrixRankRDataStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param dataConfig:
   :throws RegisterException:

MatrixRankRDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MatrixRankRDataStatisticCalculator(MatrixRankRDataStatisticCalculator other) throws RegisterException
   :outertype: MatrixRankRDataStatisticCalculator

   The copy constructor for this statistic calculator.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResultHelper
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected MatrixRankRDataStatistic calculateResultHelper(MyRengine rEngine) throws IllegalArgumentException, IOException, InvalidDataSetFormatVersionException, RegisterException, REngineException, REXPMismatchException, UnknownDataSetFormatException, InterruptedException
   :outertype: MatrixRankRDataStatisticCalculator

writeOutputToHelper
^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected void writeOutputToHelper(File absFolderPath, MyRengine rEngine)
   :outertype: MatrixRankRDataStatisticCalculator

