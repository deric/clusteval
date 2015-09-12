.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: utils ArraysExt

.. java:import:: utils Pair

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format RelativeDataSetFormat

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: file FileUtils

NodeDegreeDistributionDataStatisticCalculator
=============================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class NodeDegreeDistributionDataStatisticCalculator extends DataStatisticRCalculator<NodeDegreeDistributionDataStatistic>

   :author: Christian Wiwie

Constructors
------------
NodeDegreeDistributionDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NodeDegreeDistributionDataStatisticCalculator(Repository repository, long changeDate, File absPath, DataConfig dataConfig) throws RegisterException
   :outertype: NodeDegreeDistributionDataStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param dataConfig:
   :throws RegisterException:

NodeDegreeDistributionDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NodeDegreeDistributionDataStatisticCalculator(NodeDegreeDistributionDataStatisticCalculator other) throws RegisterException
   :outertype: NodeDegreeDistributionDataStatisticCalculator

   The copy constructor for this statistic calculator.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResultHelper
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected NodeDegreeDistributionDataStatistic calculateResultHelper(MyRengine rEngine) throws IllegalArgumentException, IOException, InvalidDataSetFormatVersionException, RegisterException, UnknownDataSetFormatException
   :outertype: NodeDegreeDistributionDataStatisticCalculator

writeOutputToHelper
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void writeOutputToHelper(File absFolderPath, MyRengine rEngine) throws REngineException, InterruptedException
   :outertype: NodeDegreeDistributionDataStatisticCalculator

