.. java:import:: java.io File

.. java:import:: java.util HashSet

.. java:import:: java.util Set

.. java:import:: de.clusteval.cluster ClusterItem

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

SensitivityClusteringQualityMeasure
===================================

.. java:package:: de.clusteval.cluster.quality
   :noindex:

.. java:type:: public class SensitivityClusteringQualityMeasure extends ClusteringQualityMeasure

   :author: Christian Wiwie

Constructors
------------
SensitivityClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SensitivityClusteringQualityMeasure(Repository repo, boolean register, long changeDate, File absPath, ClusteringQualityMeasureParameters parameters) throws RegisterException
   :outertype: SensitivityClusteringQualityMeasure

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

SensitivityClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SensitivityClusteringQualityMeasure(SensitivityClusteringQualityMeasure other) throws RegisterException
   :outertype: SensitivityClusteringQualityMeasure

   The copy constructor for this measure.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: SensitivityClusteringQualityMeasure

getMaximum
^^^^^^^^^^

.. java:method:: @Override public double getMaximum()
   :outertype: SensitivityClusteringQualityMeasure

getMinimum
^^^^^^^^^^

.. java:method:: @Override public double getMinimum()
   :outertype: SensitivityClusteringQualityMeasure

getQualityOfClustering
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public ClusteringQualityMeasureValue getQualityOfClustering(Clustering clustering, Clustering gsClustering, DataConfig dataConfig)
   :outertype: SensitivityClusteringQualityMeasure

isBetterThanHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean isBetterThanHelper(ClusteringQualityMeasureValue quality1, ClusteringQualityMeasureValue quality2)
   :outertype: SensitivityClusteringQualityMeasure

requiresGoldstandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldstandard()
   :outertype: SensitivityClusteringQualityMeasure

supportsFuzzyClusterings
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean supportsFuzzyClusterings()
   :outertype: SensitivityClusteringQualityMeasure

