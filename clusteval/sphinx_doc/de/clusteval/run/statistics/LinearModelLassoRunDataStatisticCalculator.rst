.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util LinkedHashSet

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: org.rosuda REngine.REXP

.. java:import:: utils Pair

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasureValue

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.statistics DataStatistic

.. java:import:: de.clusteval.data.statistics DoubleValueDataStatistic

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.program Program

.. java:import:: de.clusteval.run.result DataAnalysisRunResult

.. java:import:: de.clusteval.run.result ParameterOptimizationResult

.. java:import:: de.clusteval.run.result RunResult

.. java:import:: de.clusteval.run.result RunResultParseException

.. java:import:: file FileUtils

LinearModelLassoRunDataStatisticCalculator
==========================================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public class LinearModelLassoRunDataStatisticCalculator extends RunDataStatisticRCalculator<LinearModelLassoRunDataStatistic>

   :author: Christian Wiwie

Constructors
------------
LinearModelLassoRunDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearModelLassoRunDataStatisticCalculator(Repository repository, long changeDate, File absPath, List<String> runIdentifiers, List<String> dataIdentifiers) throws RegisterException
   :outertype: LinearModelLassoRunDataStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param runIdentifiers:
   :param dataIdentifiers:
   :throws RegisterException:

LinearModelLassoRunDataStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearModelLassoRunDataStatisticCalculator(LinearModelLassoRunDataStatisticCalculator other) throws RegisterException
   :outertype: LinearModelLassoRunDataStatisticCalculator

   The copy constructor for this statistic calculator.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResultHelper
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected LinearModelLassoRunDataStatistic calculateResultHelper(MyRengine rEngine) throws IllegalArgumentException, RegisterException, RunResultParseException
   :outertype: LinearModelLassoRunDataStatisticCalculator

getStatistic
^^^^^^^^^^^^

.. java:method:: @Override public LinearModelLassoRunDataStatistic getStatistic()
   :outertype: LinearModelLassoRunDataStatisticCalculator

writeOutputTo
^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public void writeOutputTo(File absFolderPath)
   :outertype: LinearModelLassoRunDataStatisticCalculator

