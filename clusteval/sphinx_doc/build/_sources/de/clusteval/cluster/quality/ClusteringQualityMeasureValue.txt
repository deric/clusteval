ClusteringQualityMeasureValue
=============================

.. java:package:: de.clusteval.cluster.quality
   :noindex:

.. java:type:: public class ClusteringQualityMeasureValue

   This is a wrapper class for double values calculated by clustering quality measures.

   This wrapper class allows for the fact, that iterations of parameter optimizations might not terminate. In this case \ :java:ref:`toString()`\  returns \ **"NT"**\ , where "NT" means \ **"Not Terminated"**\ . The factory method \ :java:ref:`getForNotTerminated()`\  returns such objects.

   :author: Christian Wiwie

Fields
------
isTerminated
^^^^^^^^^^^^

.. java:field:: protected boolean isTerminated
   :outertype: ClusteringQualityMeasureValue

   A boolean indicating, whether the iteration belonging to this object terminated.

Methods
-------
getForDouble
^^^^^^^^^^^^

.. java:method:: public static ClusteringQualityMeasureValue getForDouble(double value)
   :outertype: ClusteringQualityMeasureValue

   :param value: The quality of the clustering as a double value.
   :return: A wrapper object for a clustering quality given as a double value.

getForNotTerminated
^^^^^^^^^^^^^^^^^^^

.. java:method:: public static ClusteringQualityMeasureValue getForNotTerminated()
   :outertype: ClusteringQualityMeasureValue

   :return: A wrapper object for an optimization iteration that did not terminate.

getValue
^^^^^^^^

.. java:method:: public double getValue()
   :outertype: ClusteringQualityMeasureValue

   This method returns the quality of the clustering.

   It should only be invoked, if the corresponding iteration terminated and thus \ :java:ref:`value`\  is != null.

   :return: The quality of the corresponding clustering.

isTerminated
^^^^^^^^^^^^

.. java:method:: public boolean isTerminated()
   :outertype: ClusteringQualityMeasureValue

   :return: A boolean indicating whether the iteration belonging to this value terminated.

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static ClusteringQualityMeasureValue parseFromString(String stringValue)
   :outertype: ClusteringQualityMeasureValue

   This method returns a clustering quality measure value wrapper object corresponding to the given string.

   If the string equals \ **NT**\ , a wrapper object for a not terminated iteration is returned by invoking \ :java:ref:`getForNotTerminated()`\ .

   Otherwise the string is parsed as a double value and the result of \ :java:ref:`getForDouble(double)`\  is returned.

   :param stringValue: A string representation of the clustering quality.
   :return: A clustering quality value wrapper object corresponding to the given string.

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: ClusteringQualityMeasureValue

