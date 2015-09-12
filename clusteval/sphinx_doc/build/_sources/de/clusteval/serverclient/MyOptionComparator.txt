.. java:import:: java.util Comparator

.. java:import:: org.apache.commons.cli Option

MyOptionComparator
==================

.. java:package:: de.clusteval.serverclient
   :noindex:

.. java:type:: @SuppressWarnings public class MyOptionComparator implements Comparator

   This comparator is needed, to sort options by their required property first and second after their name.

   :author: Christian Wiwie

Methods
-------
compare
^^^^^^^

.. java:method:: @Override public int compare(Object o1, Object o2)
   :outertype: MyOptionComparator

