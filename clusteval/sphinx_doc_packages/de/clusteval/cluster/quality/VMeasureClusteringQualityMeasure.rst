.. java:import:: java.io File

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: de.clusteval.cluster Cluster

.. java:import:: de.clusteval.cluster ClusterItem

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

VMeasureClusteringQualityMeasure
================================

.. java:package:: de.clusteval.cluster.quality
   :noindex:

.. java:type:: public class VMeasureClusteringQualityMeasure extends ClusteringQualityMeasure

   :author: Christian Wiwie

Constructors
------------
VMeasureClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public VMeasureClusteringQualityMeasure(Repository repo, boolean register, long changeDate, File absPath, ClusteringQualityMeasureParameters parameters) throws RegisterException
   :outertype: VMeasureClusteringQualityMeasure

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

VMeasureClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public VMeasureClusteringQualityMeasure(VMeasureClusteringQualityMeasure other) throws RegisterException
   :outertype: VMeasureClusteringQualityMeasure

   :param other:
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: VMeasureClusteringQualityMeasure

getMaximum
^^^^^^^^^^

.. java:method:: @Override public double getMaximum()
   :outertype: VMeasureClusteringQualityMeasure

getMinimum
^^^^^^^^^^

.. java:method:: @Override public double getMinimum()
   :outertype: VMeasureClusteringQualityMeasure

getQualityOfClustering
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public ClusteringQualityMeasureValue getQualityOfClustering(Clustering clustering, Clustering gsClustering, DataConfig dataConfig)
   :outertype: VMeasureClusteringQualityMeasure

isBetterThanHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean isBetterThanHelper(ClusteringQualityMeasureValue quality1, ClusteringQualityMeasureValue quality2)
   :outertype: VMeasureClusteringQualityMeasure

requiresGoldstandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldstandard()
   :outertype: VMeasureClusteringQualityMeasure

supportsFuzzyClusterings
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean supportsFuzzyClusterings()
   :outertype: VMeasureClusteringQualityMeasure

