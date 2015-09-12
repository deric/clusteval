.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util Iterator

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util Set

.. java:import:: utils Pair

.. java:import:: utils.parse TextFileParser

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasureValue

.. java:import:: de.clusteval.cluster.quality ClusteringQualitySet

.. java:import:: de.clusteval.data DataConfig

.. java:import:: de.clusteval.data.dataset.format InvalidDataSetFormatVersionException

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.program ParameterSet

Clustering
==========

.. java:package:: de.clusteval.cluster
   :noindex:

.. java:type:: public class Clustering extends RepositoryObject implements Iterable<Cluster>

   A clustering contains several clusters. Every cluster contains cluster items.

Fields
------
clusterIdToCluster
^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, Cluster> clusterIdToCluster
   :outertype: Clustering

   Used to get clusters in O(1) with their id.

clusters
^^^^^^^^

.. java:field:: protected Set<Cluster> clusters
   :outertype: Clustering

   The clusters contained in this clustering.

fuzzySize
^^^^^^^^^

.. java:field:: protected float fuzzySize
   :outertype: Clustering

   The fuzzy size of this clustering is the sum of all fuzzy coefficients of any item contained in any cluster.

itemIdToItem
^^^^^^^^^^^^

.. java:field:: protected Map<String, ClusterItem> itemIdToItem
   :outertype: Clustering

   Used to get cluster items in O(1) with their id.

itemToCluster
^^^^^^^^^^^^^

.. java:field:: protected Map<ClusterItem, Map<Cluster, Float>> itemToCluster
   :outertype: Clustering

   A map from cluster item to cluster and fuzzy coefficient. This serves for fast access and performance purposes only.

qualities
^^^^^^^^^

.. java:field:: protected ClusteringQualitySet qualities
   :outertype: Clustering

   If the qualities of this clustering were set using the method \ :java:ref:`setQualities(ClusteringQualitySet)`\ , they are stored in this attribute.

Constructors
------------
Clustering
^^^^^^^^^^

.. java:constructor:: public Clustering(Repository repository, long changeDate, File absPath) throws RegisterException
   :outertype: Clustering

   Instantiates a new clustering.

   :param repository:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

Clustering
^^^^^^^^^^

.. java:constructor:: public Clustering(Clustering other) throws RegisterException
   :outertype: Clustering

   The copy constructor of clusterings.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
addCluster
^^^^^^^^^^

.. java:method:: public boolean addCluster(Cluster cluster)
   :outertype: Clustering

   Add a cluster to this clustering.

   :param cluster: The cluster to add.
   :return: true, if the cluster is added and hasn't been in the clustering before.

assessQuality
^^^^^^^^^^^^^

.. java:method:: public ClusteringQualitySet assessQuality(DataConfig dataConfig, List<ClusteringQualityMeasure> qualityMeasures) throws UnknownGoldStandardFormatException, IOException, UnknownDataSetFormatException, InvalidDataSetFormatVersionException
   :outertype: Clustering

   Assess quality.

   :param dataConfig:
   :param qualityMeasures: the quality measures
   :throws UnknownDataSetFormatException:
   :throws UnknownGoldStandardFormatException: the unknown gold standard format exception
   :throws IOException: Signals that an I/O exception has occurred.
   :throws InvalidDataSetFormatVersionException:
   :return: A set of qualities for every quality measure that was passed in the list.

clone
^^^^^

.. java:method:: @Override public Clustering clone()
   :outertype: Clustering

cloneClusterIdToCluster
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: protected static Map<String, Cluster> cloneClusterIdToCluster(Map<String, Cluster> clusterIdToCluster)
   :outertype: Clustering

cloneClusters
^^^^^^^^^^^^^

.. java:method:: protected static Set<Cluster> cloneClusters(Set<Cluster> clusters)
   :outertype: Clustering

cloneItemIdToItem
^^^^^^^^^^^^^^^^^

.. java:method:: protected static Map<String, ClusterItem> cloneItemIdToItem(Map<String, ClusterItem> itemIdToItem)
   :outertype: Clustering

cloneItemToClusters
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected static Map<ClusterItem, Map<Cluster, Float>> cloneItemToClusters(Map<ClusterItem, Map<Cluster, Float>> itemToCluster2)
   :outertype: Clustering

clusterIdsToFuzzyCoeff
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static float[][] clusterIdsToFuzzyCoeff(int[] clusterIds)
   :outertype: Clustering

   Convert an integer array holding cluster ids for every object to a fuzzy coefficient matrix.

   :param clusterIds: The cluster ids of the objects.
   :return: Fuzzy coefficient matrix. [i][j] holds the fuzzy coefficient for object i and cluster j.

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: Clustering

fuzzySize
^^^^^^^^^

.. java:method:: public float fuzzySize()
   :outertype: Clustering

   :return: The fuzzy size of this clustering.

   **See also:** :java:ref:`.fuzzySize`

getClusterForItem
^^^^^^^^^^^^^^^^^

.. java:method:: public Map<Cluster, Float> getClusterForItem(ClusterItem item)
   :outertype: Clustering

   :param item: The item to look for.
   :return: A map containing all clusters together with fuzzy coefficients, in which the given item is contained.

getClusterItemWithId
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public ClusterItem getClusterItemWithId(String id)
   :outertype: Clustering

   :param id: The id of the cluster item.
   :return: The cluster item with the given id.

getClusterItems
^^^^^^^^^^^^^^^

.. java:method:: public Set<ClusterItem> getClusterItems()
   :outertype: Clustering

   :return: A set with all cluster items contained in this clustering.

getClusterWithId
^^^^^^^^^^^^^^^^

.. java:method:: public Cluster getClusterWithId(String id)
   :outertype: Clustering

   :param id: The id of the cluster.
   :return: The cluster with the given id.

getClusters
^^^^^^^^^^^

.. java:method:: public Set<Cluster> getClusters()
   :outertype: Clustering

   :return: A set with all clusters of this clustering.

getQualities
^^^^^^^^^^^^

.. java:method:: public ClusteringQualitySet getQualities()
   :outertype: Clustering

   :return: Returns the qualities of this clustering.

   **See also:** :java:ref:`Clustering.qualities`

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: Clustering

iterator
^^^^^^^^

.. java:method:: @Override public Iterator<Cluster> iterator()
   :outertype: Clustering

loadIntoMemory
^^^^^^^^^^^^^^

.. java:method:: public void loadIntoMemory() throws ClusteringParseException
   :outertype: Clustering

   Loads this clustering into memory (clusters + cluster items);

   :throws ClusteringParseException:

parseFromFile
^^^^^^^^^^^^^

.. java:method:: public static Pair<ParameterSet, Clustering> parseFromFile(Repository repository, File absFilePath, boolean parseQualities) throws IOException
   :outertype: Clustering

   This method parses clusterings together with the corresponding parameter sets from a file.

   :param repository:
   :param absFilePath: The absolute path to the input file.
   :param parseQualities: True, if the qualities of the clusterings should also be parsed. Those will be taken from .qual-files.
   :throws IOException: Signals that an I/O exception has occurred.
   :return: A map containing parameter sets and corresponding clusterings.

parseFromFuzzyCoeffMatrix
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static Clustering parseFromFuzzyCoeffMatrix(Repository repository, File absPath, String[] objectIds, float[][] fuzzyCoeffs)
   :outertype: Clustering

   :param objectIds: The ids of the cluster items.
   :param fuzzyCoeffs: Position [i,j] is the fuzzy coefficient of object i and cluster j.
   :return: A clustering wrapper object.

parseFromIntArray
^^^^^^^^^^^^^^^^^

.. java:method:: public static Clustering parseFromIntArray(Repository repository, File absPath, String[] objectIds, int[] clusterIds)
   :outertype: Clustering

   The passed clustering is assumed to be a hard (non-fuzzy) clustering.

   :param objectIds: The ids of the cluster items.
   :param clusterIds: Position i holds the cluster id of cluster item i.
   :return: A clustering wrapper object.

removeClusterItem
^^^^^^^^^^^^^^^^^

.. java:method:: public boolean removeClusterItem(ClusterItem item)
   :outertype: Clustering

   Remove a cluster item from this clustering by removing the item from every cluster contained.

   :param item: The item to remove
   :return: True if this item was contained in this clustering.

removeClusterItem
^^^^^^^^^^^^^^^^^

.. java:method:: public boolean removeClusterItem(ClusterItem item, Cluster cluster)
   :outertype: Clustering

   Remove a cluster item from the specified cluster.

   :param item: The item to remove
   :param cluster: The cluster to remove the item from.
   :return: True if this item was contained in this clustering.

setQualities
^^^^^^^^^^^^

.. java:method:: public void setQualities(ClusteringQualitySet qualitySet)
   :outertype: Clustering

   :param qualitySet: Set the qualities of this clustering.

size
^^^^

.. java:method:: public int size()
   :outertype: Clustering

   :return: The number of items in this clustering. In case of fuzzy clusterings this may differ from the fuzzy size.

toFormattedString
^^^^^^^^^^^^^^^^^

.. java:method:: public String toFormattedString()
   :outertype: Clustering

   :return: A string representing this clustering, where clusters are separated by semi-colons and elements of clusters are separated by commas.

toHardClustering
^^^^^^^^^^^^^^^^

.. java:method:: public Clustering toHardClustering()
   :outertype: Clustering

   This method converts a fuzzy to a hard clustering by assigning each item to the cluster, with the highest according fuzzy coefficient. If there are ties, the assigned cluster is randomly selected.

   :return: A hard clustering resulting from converting this fuzzy clustering.

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: Clustering

unloadFromMemory
^^^^^^^^^^^^^^^^

.. java:method:: public void unloadFromMemory()
   :outertype: Clustering

   Unloads this clustering from memory.

