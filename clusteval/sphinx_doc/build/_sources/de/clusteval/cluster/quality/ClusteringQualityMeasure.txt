.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.program.r RLibraryInferior

.. java:import:: de.clusteval.utils RCalculationException

.. java:import:: de.clusteval.utils RNotAvailableException

ClusteringQualityMeasure
========================

.. java:package:: de.clusteval.cluster.quality
   :noindex:

.. java:type:: public abstract class ClusteringQualityMeasure extends RepositoryObject implements RLibraryInferior

   A clustering quality measure is used to assess the quality of a \ :java:ref:`Clustering`\  by invoking \ :java:ref:`getQualityOfClustering(Clustering,Clustering,DataConfig)`\ . It has a range of possible values between \ :java:ref:`getMinimum()`\  and \ :java:ref:`getMaximum()`\ . Some measures can only be assessed if a goldstandard is available (see \ :java:ref:`requiresGoldstandard()`\ ). Furthermore, some measures are better when maximized and some when minimized (see \ :java:ref:`isBetterThan`\  and \ :java:ref:`isBetterThanHelper`\  ).

   A clustering quality measure MyClusteringQualityMeasure can be added to ClustEval by

   1. extending the class :java:ref:`ClusteringQualityMeasure` with your own class MyClusteringQualityMeasure. You have to provide your own implementations for the following methods, otherwise the framework will not be able to load your clustering quality measure.

     * public :java:ref:`ClusteringQualityMeasure(Repository, boolean, long, File, ClusteringQualityMeasureParameters)` : The constructor for your distance measure. This constructor has to be implemented and public.
     * public :java:ref:`ClusteringQualityMeasure(MyClusteringQualityMeasure)` : The copy constructor for your distance measure. This constructor has to be implemented and public.
     * public :java:ref:`getAlias()` : This method returns a readable alias for this clustering quality measure which is used e.g. on the website.
     * public :java:ref:`getMinimum()` : Returns the minimal value this measure can calculate.
     * public :java:ref:`getMaximum()` : Returns the maximal value this measure can calculate.
     * public :java:ref:`requiresGoldStandard()` : Indicates, whether this clustering quality measure requires a goldstandard to assess the quality of a given clustering.
     * public :java:ref:`getQualityOfClustering(Clustering)` : This method is the core of your clustering quality measure. It assesses and returns the quality of the given clustering.
     * public :java:ref:`isBetterThanHelper(ClusteringQualityMeasureValue)` : This method is used by sorting algorithms of the framework to compare clustering quality measure results and find the optimal parameter sets.

   2. Creating a jar file named MyClusteringQualityMeasure.jar containing the MyClusteringQualityMeasure class compiled on your machine in the correct folder structure corresponding to the packages:

     * de/clusteval/cluster/quality/MyClusteringQualityMeasure.class

   3. Putting the MyClusteringQualityMeasure.jar into the clustering quality measure folder of the repository:

     * <REPOSITORY ROOT>/supp/clustering/qualityMeasures
     * The backend server will recognize and try to load the new clustering quality measure automatically the next time, the ClusteringQualityMeasureFinderThread checks the filesystem.

   :author: Christian Wiwie

Fields
------
parameters
^^^^^^^^^^

.. java:field:: protected ClusteringQualityMeasureParameters parameters
   :outertype: ClusteringQualityMeasure

Constructors
------------
ClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringQualityMeasure(Repository repo, boolean register, long changeDate, File absPath, ClusteringQualityMeasureParameters parameters) throws RegisterException
   :outertype: ClusteringQualityMeasure

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param parameters:
   :throws RegisterException:

ClusteringQualityMeasure
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ClusteringQualityMeasure(ClusteringQualityMeasure other) throws RegisterException
   :outertype: ClusteringQualityMeasure

   The copy constructor of clustering quality measures.

   :param other: The quality measure to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public ClusteringQualityMeasure clone()
   :outertype: ClusteringQualityMeasure

cloneQualityMeasures
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static List<ClusteringQualityMeasure> cloneQualityMeasures(List<ClusteringQualityMeasure> qualityMeasures)
   :outertype: ClusteringQualityMeasure

   This is a helper method for cloning a list of clustering quality measures.

   :param qualityMeasures: The quality measures to be cloned.
   :return: A list containining cloned objects of the given quality measures.

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: ClusteringQualityMeasure

getAlias
^^^^^^^^

.. java:method:: public abstract String getAlias()
   :outertype: ClusteringQualityMeasure

   This alias is used whenever this clustering quality measure is visually represented and a readable name is needed.

   :return: The alias of this clustering quality measure.

getMaximum
^^^^^^^^^^

.. java:method:: public abstract double getMaximum()
   :outertype: ClusteringQualityMeasure

   :return: The maximal value of the range of possible values of this quality measure.

getMinimum
^^^^^^^^^^

.. java:method:: public abstract double getMinimum()
   :outertype: ClusteringQualityMeasure

   :return: The minimal value of the range of possible values of this quality measure.

getQualityOfClustering
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract ClusteringQualityMeasureValue getQualityOfClustering(Clustering clustering, Clustering goldStandard, DataConfig dataConfig) throws UnknownGoldStandardFormatException, UnknownDataSetFormatException, IOException, InvalidDataSetFormatVersionException, RNotAvailableException, RCalculationException, InterruptedException
   :outertype: ClusteringQualityMeasure

   Gets the quality of clustering.

   :param clustering: the clustering
   :param goldStandard: The expected goldstandard.
   :param dataConfig: the data config
   :throws UnknownGoldStandardFormatException: the unknown gold standard format exception
   :throws InterruptedException:
   :throws UnknownDataSetFormatException:
   :throws IOException:
   :throws RNotAvailableException:
   :throws RCalculationException:
   :throws InvalidDataSetFormatVersionException:
   :return: the quality of clustering

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: ClusteringQualityMeasure

isBetterThan
^^^^^^^^^^^^

.. java:method:: public final boolean isBetterThan(ClusteringQualityMeasureValue quality1, ClusteringQualityMeasureValue quality2)
   :outertype: ClusteringQualityMeasure

   This method compares two values of this clustering quality measure and returns true, if the first one is better than the second one.

   :param quality1: The first quality value.
   :param quality2: The second quality value.
   :return: True, if quality1 is better than quality2

isBetterThanHelper
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean isBetterThanHelper(ClusteringQualityMeasureValue quality1, ClusteringQualityMeasureValue quality2)
   :outertype: ClusteringQualityMeasure

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static ClusteringQualityMeasure parseFromString(Repository repository, String qualityMeasure, ClusteringQualityMeasureParameters parameters) throws UnknownClusteringQualityMeasureException
   :outertype: ClusteringQualityMeasure

   Parses the from string.

   :param repository: the repository
   :param qualityMeasure: the quality measure
   :param parameters:
   :throws UnknownClusteringQualityMeasureException: the unknown clustering quality measure exception
   :return: the clustering quality measure

requiresGoldstandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract boolean requiresGoldstandard()
   :outertype: ClusteringQualityMeasure

   Override this method to indicate, whether the quality measure of your subclass needs a goldstandard to be able to be computed.

   :return: True, if this clustering quality measure requires a goldstandard to be able to assess the quality of a clustering.

supportsFuzzyClusterings
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract boolean supportsFuzzyClusterings()
   :outertype: ClusteringQualityMeasure

   This method has to be implemented in subclasses to indiciate, whether a quality measure supports validating fuzzy clusterings.

   :return: True, if this measure supports fuzzy clusterings, false otherwise.

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: ClusteringQualityMeasure

