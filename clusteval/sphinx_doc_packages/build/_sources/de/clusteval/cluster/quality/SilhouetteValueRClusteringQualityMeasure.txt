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

SilhouetteValueRClusteringQualityMeasure
========================================

.. java:package:: de.clusteval.cluster.quality
   :noindex:

.. java:type:: @RLibraryRequirement public class SilhouetteValueRClusteringQualityMeasure extends ClusteringQualityMeasureR

   :author: Christian Wiwie

Constructors
------------
SilhouetteValueRClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SilhouetteValueRClusteringQualityMeasure(Repository repo, boolean register, long changeDate, File absPath, ClusteringQualityMeasureParameters parameters) throws RegisterException
   :outertype: SilhouetteValueRClusteringQualityMeasure

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

SilhouetteValueRClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SilhouetteValueRClusteringQualityMeasure(SilhouetteValueRClusteringQualityMeasure other) throws RegisterException
   :outertype: SilhouetteValueRClusteringQualityMeasure

   The copy constructor for this measure.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: SilhouetteValueRClusteringQualityMeasure

getMaximum
^^^^^^^^^^

.. java:method:: @Override public double getMaximum()
   :outertype: SilhouetteValueRClusteringQualityMeasure

getMinimum
^^^^^^^^^^

.. java:method:: @Override public double getMinimum()
   :outertype: SilhouetteValueRClusteringQualityMeasure

getQualityOfClusteringHelper
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @SuppressWarnings @Override public ClusteringQualityMeasureValue getQualityOfClusteringHelper(Clustering clustering, Clustering gsClustering, DataConfig dataConfig, MyRengine rEngine) throws IllegalArgumentException, REngineException, REXPMismatchException, InterruptedException
   :outertype: SilhouetteValueRClusteringQualityMeasure

isBetterThanHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean isBetterThanHelper(ClusteringQualityMeasureValue quality1, ClusteringQualityMeasureValue quality2)
   :outertype: SilhouetteValueRClusteringQualityMeasure

requiresGoldstandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldstandard()
   :outertype: SilhouetteValueRClusteringQualityMeasure

supportsFuzzyClusterings
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean supportsFuzzyClusterings()
   :outertype: SilhouetteValueRClusteringQualityMeasure

