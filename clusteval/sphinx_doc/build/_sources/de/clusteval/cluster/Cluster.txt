.. java:import:: java.util HashMap

.. java:import:: java.util Iterator

.. java:import:: java.util Map

Cluster
=======

.. java:package:: de.clusteval.cluster
   :noindex:

.. java:type:: public class Cluster implements Iterable<ClusterItem>

   A cluster is part of a clustering and contains several item.

   :author: Christian Wiwie

Fields
------
fuzzyItems
^^^^^^^^^^

.. java:field:: protected Map<ClusterItem, Float> fuzzyItems
   :outertype: Cluster

   The items contained in this cluster. Since we support fuzzy clusters, for every item we also have to store the fuzzy coefficient.

fuzzySize
^^^^^^^^^

.. java:field:: protected float fuzzySize
   :outertype: Cluster

   The (fuzzy) size of this cluster is the sum of the fuzzy coefficients of all items contained in this cluster.

id
^^

.. java:field:: protected String id
   :outertype: Cluster

   The id of the cluster should be unique per clustering

Constructors
------------
Cluster
^^^^^^^

.. java:constructor:: public Cluster(String id)
   :outertype: Cluster

   Instantiates a new cluster with a given id.

   :param id: The id of the cluster.

Cluster
^^^^^^^

.. java:constructor:: public Cluster(Cluster other)
   :outertype: Cluster

   The copy constructor of clusters.

   :param other: The object to clone.

Methods
-------
add
^^^

.. java:method:: public boolean add(ClusterItem item, float fuzzy)
   :outertype: Cluster

   Add a new item to this cluster with a certain fuzzy coefficient.

   :param item: The item to add.
   :param fuzzy: The fuzzy coefficient of the new item.
   :return: true, if successful

clone
^^^^^

.. java:method:: @Override public Cluster clone()
   :outertype: Cluster

cloneFuzzyItems
^^^^^^^^^^^^^^^

.. java:method:: protected static Map<ClusterItem, Float> cloneFuzzyItems(Map<ClusterItem, Float> fuzzyItems)
   :outertype: Cluster

contains
^^^^^^^^

.. java:method:: public boolean contains(ClusterItem item)
   :outertype: Cluster

   Checks whether this cluster contains a certain item.

   :param item: The item to check for.
   :return: true, if this cluster contains the item, false otherwise.

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object o)
   :outertype: Cluster

fuzzySize
^^^^^^^^^

.. java:method:: public float fuzzySize()
   :outertype: Cluster

   The (fuzzy) size of this cluster is the sum of the fuzzy coefficients of all items contained in this cluster.

   In case that this clustering is a crisp clustering (all fuzzy coefficients = 1.0), this size is the same as \ :java:ref:`size()`\ .

   :return: The fuzzy size of this cluster.

getFuzzyItems
^^^^^^^^^^^^^

.. java:method:: public Map<ClusterItem, Float> getFuzzyItems()
   :outertype: Cluster

   :return: A map with all items contained in this cluster together with their fuzzy coefficients.

getId
^^^^^

.. java:method:: public String getId()
   :outertype: Cluster

   :return: The id of the cluster.

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: Cluster

iterator
^^^^^^^^

.. java:method:: @Override public Iterator<ClusterItem> iterator()
   :outertype: Cluster

remove
^^^^^^

.. java:method:: public boolean remove(ClusterItem item)
   :outertype: Cluster

   Remove an item from this cluster.

   :param item: The item to remove.
   :return: True, if successful

size
^^^^

.. java:method:: public int size()
   :outertype: Cluster

   :return: The number of items contained in this cluster.

   In case of fuzzy clusterings this does not necessarily return the same as \ :java:ref:`fuzzySize()`\ !

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: Cluster

