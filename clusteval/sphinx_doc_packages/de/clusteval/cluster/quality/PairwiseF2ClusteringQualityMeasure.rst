.. java:import:: java.io File

.. java:import:: java.io Serializable

.. java:import:: java.util Map

.. java:import:: de.clusteval.cluster Cluster

.. java:import:: de.clusteval.cluster ClusterItem

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

PairwiseF2ClusteringQualityMeasure
==================================

.. java:package:: de.clusteval.cluster.quality
   :noindex:

.. java:type:: public class PairwiseF2ClusteringQualityMeasure extends ClusteringQualityMeasure implements Serializable

   The Class F2ClusteringQualityMeasure.

   :author: Christian Wiwie

Constructors
------------
PairwiseF2ClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public PairwiseF2ClusteringQualityMeasure(Repository repo, boolean register, long changeDate, File absPath, ClusteringQualityMeasureParameters parameters) throws RegisterException
   :outertype: PairwiseF2ClusteringQualityMeasure

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

PairwiseF2ClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public PairwiseF2ClusteringQualityMeasure(PairwiseF2ClusteringQualityMeasure other) throws RegisterException
   :outertype: PairwiseF2ClusteringQualityMeasure

   The copy constructor for this measure.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: PairwiseF2ClusteringQualityMeasure

getMaximum
^^^^^^^^^^

.. java:method:: @Override public double getMaximum()
   :outertype: PairwiseF2ClusteringQualityMeasure

getMinimum
^^^^^^^^^^

.. java:method:: @Override public double getMinimum()
   :outertype: PairwiseF2ClusteringQualityMeasure

getQualityOfClustering
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public ClusteringQualityMeasureValue getQualityOfClustering(Clustering clustering, Clustering gsClustering, DataConfig dataConfig)
   :outertype: PairwiseF2ClusteringQualityMeasure

isBetterThanHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean isBetterThanHelper(ClusteringQualityMeasureValue quality1, ClusteringQualityMeasureValue quality2)
   :outertype: PairwiseF2ClusteringQualityMeasure

requiresGoldstandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldstandard()
   :outertype: PairwiseF2ClusteringQualityMeasure

supportsFuzzyClusterings
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean supportsFuzzyClusterings()
   :outertype: PairwiseF2ClusteringQualityMeasure

