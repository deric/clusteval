.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: org.rosuda REngine.REXPMismatchException

.. java:import:: org.rosuda REngine.REngineException

.. java:import:: org.rosuda REngine.Rserve.RserveException

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.framework.repository MyRengine

.. java:import:: de.clusteval.framework.repository RException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils RNotAvailableException

ClusteringQualityMeasureR
=========================

.. java:package:: de.clusteval.cluster.quality
   :noindex:

.. java:type:: public abstract class ClusteringQualityMeasureR extends ClusteringQualityMeasure

   This type of clustering quality measure uses the R framework to calculate cluster validities.

   :author: Christian Wiwie

Constructors
------------
ClusteringQualityMeasureR
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringQualityMeasureR(Repository repo, boolean register, long changeDate, File absPath, ClusteringQualityMeasureParameters parameters) throws RegisterException
   :outertype: ClusteringQualityMeasureR

   Instantiates a new R clustering quality measure.

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param parameters:
   :throws RegisterException:

ClusteringQualityMeasureR
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringQualityMeasureR(ClusteringQualityMeasureR other) throws RegisterException
   :outertype: ClusteringQualityMeasureR

   The copy constructor of R clustering quality measures.

   :param other: The quality measure to clone.
   :throws RegisterException:

Methods
-------
getQualityOfClustering
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public final ClusteringQualityMeasureValue getQualityOfClustering(Clustering clustering, Clustering goldStandard, DataConfig dataConfig) throws UnknownGoldStandardFormatException, UnknownDataSetFormatException, IOException, InvalidDataSetFormatVersionException, RNotAvailableException, InterruptedException
   :outertype: ClusteringQualityMeasureR

getQualityOfClusteringHelper
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract ClusteringQualityMeasureValue getQualityOfClusteringHelper(Clustering clustering, Clustering goldStandard, DataConfig dataConfig, MyRengine rEngine) throws UnknownGoldStandardFormatException, UnknownDataSetFormatException, IOException, InvalidDataSetFormatVersionException, REngineException, IllegalArgumentException, REXPMismatchException, InterruptedException
   :outertype: ClusteringQualityMeasureR

