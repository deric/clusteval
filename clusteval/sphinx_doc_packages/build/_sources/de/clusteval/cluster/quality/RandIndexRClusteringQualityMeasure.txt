.. java:import:: java.io File

.. java:import:: java.util HashMap

.. java:import:: java.util Iterator

.. java:import:: java.util Map

.. java:import:: org.rosuda REngine.REXP

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: utils ArraysExt

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.cluster Cluster

.. java:import:: de.clusteval.cluster ClusterItem

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.framework RLibraryRequirement

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

RandIndexRClusteringQualityMeasure
==================================

.. java:package:: de.clusteval.cluster.quality
   :noindex:

.. java:type:: @RLibraryRequirement public class RandIndexRClusteringQualityMeasure extends ClusteringQualityMeasureR

   :author: Christian Wiwie

Constructors
------------
RandIndexRClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RandIndexRClusteringQualityMeasure(Repository repo, boolean register, long changeDate, File absPath, ClusteringQualityMeasureParameters parameters) throws RegisterException
   :outertype: RandIndexRClusteringQualityMeasure

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

RandIndexRClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RandIndexRClusteringQualityMeasure(RandIndexRClusteringQualityMeasure other) throws RegisterException
   :outertype: RandIndexRClusteringQualityMeasure

   The copy constructor for this measure.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: RandIndexRClusteringQualityMeasure

getMaximum
^^^^^^^^^^

.. java:method:: @Override public double getMaximum()
   :outertype: RandIndexRClusteringQualityMeasure

getMinimum
^^^^^^^^^^

.. java:method:: @Override public double getMinimum()
   :outertype: RandIndexRClusteringQualityMeasure

getQualityOfClusteringHelper
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public ClusteringQualityMeasureValue getQualityOfClusteringHelper(Clustering clustering, Clustering gsClustering, DataConfig dataConfig, MyRengine rEngine) throws REngineException, REXPMismatchException, InterruptedException
   :outertype: RandIndexRClusteringQualityMeasure

isBetterThanHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean isBetterThanHelper(ClusteringQualityMeasureValue quality1, ClusteringQualityMeasureValue quality2)
   :outertype: RandIndexRClusteringQualityMeasure

requiresGoldstandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldstandard()
   :outertype: RandIndexRClusteringQualityMeasure

supportsFuzzyClusterings
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean supportsFuzzyClusterings()
   :outertype: RandIndexRClusteringQualityMeasure

