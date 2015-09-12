.. java:import:: java.util HashMap

.. java:import:: java.util Map

ClusterItem
===========

.. java:package:: de.clusteval.cluster
   :noindex:

.. java:type:: public class ClusterItem

   A cluster item can be part of several clusters.

   :author: Christian Wiwie

Fields
------
fuzzyClusters
^^^^^^^^^^^^^

.. java:field:: protected Map<Cluster, Float> fuzzyClusters
   :outertype: ClusterItem

   The clusters this item is contained in together with the corresponding fuzzy coefficients.

id
^^

.. java:field:: protected String id
   :outertype: ClusterItem

   The id of the item, should be unique.

Constructors
------------
ClusterItem
^^^^^^^^^^^

.. java:constructor:: public ClusterItem(String id)
   :outertype: ClusterItem

   Instantiates a new cluster item with a certain id.

   :param id: The id of the new cluster item.

ClusterItem
^^^^^^^^^^^

.. java:constructor:: public ClusterItem(ClusterItem other)
   :outertype: ClusterItem

   The copy constructor of cluster items.

   :param other: The object to clone.

Methods
-------
addFuzzyCluster
^^^^^^^^^^^^^^^

.. java:method:: public boolean addFuzzyCluster(Cluster cluster, float fuzzy)
   :outertype: ClusterItem

   Adds a new fuzzy cluster to this items' list of clusters.

   :param cluster: The new cluster to add.
   :param fuzzy: The fuzzy coefficient
   :return: true, if an old fuzzy coefficient for this cluster was replaced, false otherwise.

clone
^^^^^

.. java:method:: @Override public ClusterItem clone()
   :outertype: ClusterItem

cloneFuzzyClusters
^^^^^^^^^^^^^^^^^^

.. java:method:: protected static Map<Cluster, Float> cloneFuzzyClusters(Map<Cluster, Float> fuzzyClusters)
   :outertype: ClusterItem

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: ClusterItem

getFuzzyClusters
^^^^^^^^^^^^^^^^

.. java:method:: public Map<Cluster, Float> getFuzzyClusters()
   :outertype: ClusterItem

   :return: A map with all clusters this item is contained in together with the corresponding fuzzy coefficients.

getId
^^^^^

.. java:method:: public String getId()
   :outertype: ClusterItem

   :return: The id of this cluster item.

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: ClusterItem

removeFuzzyCluster
^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean removeFuzzyCluster(Cluster cluster)
   :outertype: ClusterItem

   Removes one of this items' clusters.

   :param cluster: The cluster to remove
   :return: True, if the cluster was contained in the list and was removed, false otherwise.

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: ClusterItem

