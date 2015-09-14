.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: utils SimilarityMatrix

.. java:import:: de.clusteval.cluster Cluster

.. java:import:: de.clusteval.cluster ClusterItem

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset RelativeDataSet

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

CVNNClusteringQualityMeasure
============================

.. java:package:: de.clusteval.cluster.quality
   :noindex:

.. java:type:: public class CVNNClusteringQualityMeasure extends ClusteringQualityMeasure

   :author: Christian Wiwie

Constructors
------------
CVNNClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public CVNNClusteringQualityMeasure(Repository repo, boolean register, long changeDate, File absPath, ClusteringQualityMeasureParameters parameters) throws RegisterException
   :outertype: CVNNClusteringQualityMeasure

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param parameters:
   :throws RegisterException:

CVNNClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public CVNNClusteringQualityMeasure(CVNNClusteringQualityMeasure other) throws RegisterException
   :outertype: CVNNClusteringQualityMeasure

   :param other:
   :throws RegisterException:

Methods
-------
comp
^^^^

.. java:method:: protected double comp(Clustering clustering, RelativeDataSet dataSet)
   :outertype: CVNNClusteringQualityMeasure

comp_norm
^^^^^^^^^

.. java:method:: protected double comp_norm(Clustering clustering, RelativeDataSet dataSet)
   :outertype: CVNNClusteringQualityMeasure

find_knn
^^^^^^^^

.. java:method:: protected Map<ClusterItem, List<ClusterItem>> find_knn(Clustering clustering, RelativeDataSet dataSet, int knn)
   :outertype: CVNNClusteringQualityMeasure

getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: CVNNClusteringQualityMeasure

getMaximum
^^^^^^^^^^

.. java:method:: @Override public double getMaximum()
   :outertype: CVNNClusteringQualityMeasure

getMinimum
^^^^^^^^^^

.. java:method:: @Override public double getMinimum()
   :outertype: CVNNClusteringQualityMeasure

getQualityOfClustering
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public ClusteringQualityMeasureValue getQualityOfClustering(Clustering clustering, Clustering gsClustering, DataConfig dataConfig)
   :outertype: CVNNClusteringQualityMeasure

isBetterThanHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean isBetterThanHelper(ClusteringQualityMeasureValue quality1, ClusteringQualityMeasureValue quality2)
   :outertype: CVNNClusteringQualityMeasure

requiresGoldstandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldstandard()
   :outertype: CVNNClusteringQualityMeasure

sep
^^^

.. java:method:: protected double sep(int knn, Map<ClusterItem, List<ClusterItem>> knn_matrix, Clustering clustering, List<Cluster> clusters, DataConfig dataConfig)
   :outertype: CVNNClusteringQualityMeasure

sep_norm
^^^^^^^^

.. java:method:: protected double sep_norm(int knn, Map<ClusterItem, List<ClusterItem>> knn_matrix, Clustering clustering, List<Cluster> clusters, DataConfig dataConfig)
   :outertype: CVNNClusteringQualityMeasure

supportsFuzzyClusterings
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean supportsFuzzyClusterings()
   :outertype: CVNNClusteringQualityMeasure

