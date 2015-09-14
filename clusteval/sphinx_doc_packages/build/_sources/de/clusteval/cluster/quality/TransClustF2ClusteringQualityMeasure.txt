.. java:import:: java.io File

.. java:import:: java.util HashSet

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: de.clusteval.cluster Cluster

.. java:import:: de.clusteval.cluster ClusterItem

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

TransClustF2ClusteringQualityMeasure
====================================

.. java:package:: de.clusteval.cluster.quality
   :noindex:

.. java:type:: public class TransClustF2ClusteringQualityMeasure extends ClusteringQualityMeasure

   :author: Christian Wiwie

Constructors
------------
TransClustF2ClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public TransClustF2ClusteringQualityMeasure(Repository repo, boolean register, long changeDate, File absPath, ClusteringQualityMeasureParameters parameters) throws RegisterException
   :outertype: TransClustF2ClusteringQualityMeasure

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

TransClustF2ClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public TransClustF2ClusteringQualityMeasure(TransClustF2ClusteringQualityMeasure other) throws RegisterException
   :outertype: TransClustF2ClusteringQualityMeasure

   The copy constructor for this measure.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: TransClustF2ClusteringQualityMeasure

getMaximum
^^^^^^^^^^

.. java:method:: @Override public double getMaximum()
   :outertype: TransClustF2ClusteringQualityMeasure

getMinimum
^^^^^^^^^^

.. java:method:: @Override public double getMinimum()
   :outertype: TransClustF2ClusteringQualityMeasure

getQualityOfClustering
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public ClusteringQualityMeasureValue getQualityOfClustering(Clustering clustering, Clustering gsClustering, DataConfig dataConfig)
   :outertype: TransClustF2ClusteringQualityMeasure

isBetterThanHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean isBetterThanHelper(ClusteringQualityMeasureValue quality1, ClusteringQualityMeasureValue quality2)
   :outertype: TransClustF2ClusteringQualityMeasure

requiresGoldstandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldstandard()
   :outertype: TransClustF2ClusteringQualityMeasure

supportsFuzzyClusterings
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean supportsFuzzyClusterings()
   :outertype: TransClustF2ClusteringQualityMeasure

