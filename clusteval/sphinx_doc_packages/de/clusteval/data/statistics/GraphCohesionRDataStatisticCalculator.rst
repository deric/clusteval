.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: org.rosuda REngine.REXP

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

GraphCohesionRDataStatisticCalculator
=====================================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class GraphCohesionRDataStatisticCalculator extends DataStatisticRCalculator<GraphCohesionRDataStatistic>

   :author: Christian Wiwie

Constructors
------------
GraphCohesionRDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphCohesionRDataStatisticCalculator(Repository repository, long changeDate, File absPath, DataConfig dataConfig) throws RegisterException
   :outertype: GraphCohesionRDataStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param dataConfig:
   :throws RegisterException:

GraphCohesionRDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GraphCohesionRDataStatisticCalculator(GraphCohesionRDataStatisticCalculator other) throws RegisterException
   :outertype: GraphCohesionRDataStatisticCalculator

   The copy constructor for this statistic calculator.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResultHelper
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected GraphCohesionRDataStatistic calculateResultHelper(MyRengine rEngine) throws IllegalArgumentException, IOException, InvalidDataSetFormatVersionException, RegisterException, REngineException, REXPMismatchException, UnknownDataSetFormatException, InterruptedException
   :outertype: GraphCohesionRDataStatisticCalculator

writeOutputToHelper
^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override protected void writeOutputToHelper(File absFolderPath, MyRengine rEngine)
   :outertype: GraphCohesionRDataStatisticCalculator

