.. java:import:: java.io File

.. java:import:: java.util HashSet

.. java:import:: java.util Set

.. java:import:: de.clusteval.cluster ClusterItem

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

RandIndexClusteringQualityMeasure
=================================

.. java:package:: de.clusteval.cluster.quality
   :noindex:

.. java:type:: public class RandIndexClusteringQualityMeasure extends ClusteringQualityMeasure

   :author: Christian Wiwie

Constructors
------------
RandIndexClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RandIndexClusteringQualityMeasure(Repository repo, boolean register, long changeDate, File absPath, ClusteringQualityMeasureParameters parameters) throws RegisterException
   :outertype: RandIndexClusteringQualityMeasure

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

RandIndexClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RandIndexClusteringQualityMeasure(RandIndexClusteringQualityMeasure other) throws RegisterException
   :outertype: RandIndexClusteringQualityMeasure

   The copy constructor for this measure.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: RandIndexClusteringQualityMeasure

getMaximum
^^^^^^^^^^

.. java:method:: @Override public double getMaximum()
   :outertype: RandIndexClusteringQualityMeasure

getMinimum
^^^^^^^^^^

.. java:method:: @Override public double getMinimum()
   :outertype: RandIndexClusteringQualityMeasure

getQualityOfClustering
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public ClusteringQualityMeasureValue getQualityOfClustering(Clustering clustering, Clustering gsClustering, DataConfig dataConfig)
   :outertype: RandIndexClusteringQualityMeasure

isBetterThanHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean isBetterThanHelper(ClusteringQualityMeasureValue quality1, ClusteringQualityMeasureValue quality2)
   :outertype: RandIndexClusteringQualityMeasure

requiresGoldstandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldstandard()
   :outertype: RandIndexClusteringQualityMeasure

supportsFuzzyClusterings
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean supportsFuzzyClusterings()
   :outertype: RandIndexClusteringQualityMeasure

