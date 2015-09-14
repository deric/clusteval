.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Map.Entry

.. java:import:: java.util Set

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: utils ArraysExt

.. java:import:: cern.colt.matrix.tlong LongMatrix2D

.. java:import:: cern.colt.matrix.tlong.impl SparseLongMatrix2D

.. java:import:: de.clusteval.cluster Cluster

.. java:import:: de.clusteval.cluster ClusterItem

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.data.statistics RunStatisticCalculateException

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.program ParameterSet

.. java:import:: de.clusteval.run.result ParameterOptimizationResult

.. java:import:: de.clusteval.run.result RunResult

.. java:import:: file FileUtils

CooccurrenceBestRunStatisticCalculator
======================================

.. java:package:: de.clusteval.run.statistics
   :noindex:

.. java:type:: public class CooccurrenceBestRunStatisticCalculator extends RunStatisticCalculator<CooccurrenceBestRunStatistic>

   :author: Christian Wiwie

Constructors
------------
CooccurrenceBestRunStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public CooccurrenceBestRunStatisticCalculator(Repository repository, long changeDate, File absPath, String uniqueRunIdentifier) throws RegisterException
   :outertype: CooccurrenceBestRunStatisticCalculator

   :param repository:
   :param changeDate:
   :param absPath:
   :param uniqueRunIdentifier:
   :throws RegisterException:

CooccurrenceBestRunStatisticCalculator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public CooccurrenceBestRunStatisticCalculator(CooccurrenceBestRunStatisticCalculator other) throws RegisterException
   :outertype: CooccurrenceBestRunStatisticCalculator

   The copy constructor for this statistic calculator.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
calculateResult
^^^^^^^^^^^^^^^

.. java:method:: @Override protected CooccurrenceBestRunStatistic calculateResult() throws RunStatisticCalculateException
   :outertype: CooccurrenceBestRunStatisticCalculator

getStatistic
^^^^^^^^^^^^

.. java:method:: @Override public CooccurrenceBestRunStatistic getStatistic()
   :outertype: CooccurrenceBestRunStatisticCalculator

writeOutputTo
^^^^^^^^^^^^^

.. java:method:: @Override public void writeOutputTo(File absFolderPath) throws InterruptedException
   :outertype: CooccurrenceBestRunStatisticCalculator

